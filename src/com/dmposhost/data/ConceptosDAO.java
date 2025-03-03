/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmposhost.data;

import com.dmposhost.bean.ConceptoCobro;
import com.dmposhost.bean.ConceptosVO;
import com.dmposhost.util.DbConnection;
import com.dmposhost.util.DbConnectionHost;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author scabanillas
 * 
 */
public class ConceptosDAO {
   static ArrayList<ConceptoCobro> conceptos = new ArrayList<ConceptoCobro>();
   //static ConceptoCobro concepto = new ConceptoCobro();
   static ArrayList<ConceptoCobro> conceptosFiltrados = new ArrayList<ConceptoCobro>();
   //
   static boolean resultadoHost=true;
   static boolean resultadoLoc=true;
   // Variable modoconectado=True : Cuando la conexion es a la BD del Servidor Central
   //          modoconectado=False: Cuando la conexion es a la BD Local
   static boolean modoconectado =true;
   //
    //public static ArrayList<ConceptoCobro> getConceptos(){
    public static ArrayList<ConceptoCobro> getConceptos(String codigoBarras){        
        resetListArticulos();
        //
        if(conceptos.isEmpty()){
            //if  (modoconectado) {
            //   DbConnectionHost conex= new DbConnectionHost();
            //} else {
            //    DbConnection conex= new DbConnection();
            //}
            DbConnectionHost conex= new DbConnectionHost();
            /*try{
                BufferedReader br = new BufferedReader(new FileReader(
                                        Util.validaArchivoTicket(TipoArchivo.DAT.getTipo(), "concepto")));
                String line = br.readLine();
                while (line != null) {
                    if(line!=null && line.trim().compareTo("")!=0){
                        String[] linea = line.split("\\"+Util.FILE_DELIMITADOR);
                        conceptos.add(new ConceptoCobro(linea[0],linea[1],new BigDecimal(linea[2]),new Boolean(linea[3])));
                        conceptosFiltrados.add(new ConceptoCobro(linea[0],linea[1],new BigDecimal(linea[2]),new Boolean(linea[3])));
                    }
                    line = br.readLine();
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }*/
            try{
             //PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT CODCON,DESCON,APLICAIGV,PRECONIGV,PRESINIGV,TipoMon,Exonerado,UNIMED "
             //PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT CODCON,DESCON,APLICAIGV,round(PRECONIGV,2) as PRECONIGV,round(PRESINIGV,2) as PRESINIGV,TipoMon,Exonerado,UNIMED "                     
             //PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT CODBARRAS AS CODCON,DESCON, "
             PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT CODCON,DESCON, "        
                            + "APLICAIGV,round(PRECONIGV,2) as PRECONIGV,round(PRESINIGV,2) as PRESINIGV,TipoMon, "
                            + "Exonerado,UNIMED,CodPrdSunat,CodGrp,CodFam,CodSFam,FlgAplDes "                     
                            //+ " FROM DMTICKET.DMT_CONCEPTOS_MAE WHERE ESTCON =? AND CIAID=?");
                            + " FROM DMTICKET.DMT_CONCEPTOS_MAE WHERE ESTCON =? AND CIAID=? AND CODBARRAS=?");                                         
             consulta.setString(1, "A");   
             consulta.setString(2, UsuarioData.getUsuario().getEmpresa()); 
             consulta.setString(3, codigoBarras); 
             ResultSet res = consulta.executeQuery();
            // if ( res.getRow() == 0 ) {
              //   JOptionPane.showMessageDialog(null, "Articulo NO existe... Por favor validar!!\n");
            // }
            // else {
                while(res.next()){
                    boolean aplicaigv = "1".equals(res.getString("APLICAIGV"));
                    conceptos.add(new ConceptoCobro(res.getString("CODCON"),res.getString("DESCON"),new BigDecimal(res.getDouble("PRECONIGV")),new Boolean(aplicaigv),new BigDecimal(res.getDouble("PRESINIGV")),res.getString("TipoMon"),res.getString("Exonerado"),res.getString("UNIMED"),res.getString("CodPrdSunat"),res.getString("CodGrp"),res.getString("CodFam"),res.getString("CodSFam"),res.getString("FlgAplDes")));
                    conceptosFiltrados.add(new ConceptoCobro(res.getString("CODCON"),res.getString("DESCON"),new BigDecimal(res.getDouble("PRECONIGV")),new Boolean(aplicaigv),new BigDecimal(res.getDouble("PRESINIGV")),res.getString("TipoMon"),res.getString("Exonerado"),res.getString("UNIMED"),res.getString("CodPrdSunat"),res.getString("CodGrp"),res.getString("CodFam"),res.getString("CodSFam"),res.getString("FlgAplDes")));  
                }
             //}   
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
        }
        return conceptos;
    }
    
    // PCC 20.12.2019
    public static ArrayList<ConceptoCobro> getConceptosLP(String xidlistap, String codigoBarras){        
        resetListArticulos();
        if(conceptos.isEmpty()){
            DbConnectionHost conex= new DbConnectionHost();
            //DbConnection conex= new DbConnection();
            try{
             /*
             PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT CODCON,DESCON, "        
                            + "APLICAIGV,round(PRECONIGV,2) as PRECONIGV,round(PRESINIGV,2) as PRESINIGV,TipoMon, "
                            + "Exonerado,UNIMED,CodPrdSunat "                     
                            + " FROM DMTICKET.DMT_CONCEPTOS_MAE WHERE ESTCON =? AND CIAID=? AND CODBARRAS=?");     
             */
             PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT T.CODCON,UPPER(T.DESCON) DESCON, "
                            + " T.APLICAIGV,round(L.PRECONIGVMN,2) as PRECONIGV,round(L.PRESINIGVMN,2) as PRESINIGV, "
                            + " T.TipoMon, T.Exonerado,T.UNIMED,T.CodPrdSunat, T.CodGrp, T.CodFam, T.CodSFam, T.FlgAplDes "
                            + " FROM DMTICKET.DMT_CONCEPTOS_MAE T, DMTICKET.DMT_LPRECIOS_DET L "
                            + " WHERE T.CIAID=L.CIAID AND T.CODCON=L.CODCON AND L.IDLPRECIOS=? AND L.INDACTIVO=? "
                            + " AND T.ESTCON =? AND T.CIAID=? AND T.CODBARRAS=?");
             
             consulta.setString(1, xidlistap);   
             consulta.setString(2, "S");   
             consulta.setString(3, "A");   
             consulta.setString(4, UsuarioData.getUsuario().getEmpresa()); 
             consulta.setString(5, codigoBarras); 
             ResultSet res = consulta.executeQuery();
                while(res.next()){
                    boolean aplicaigv = "1".equals(res.getString("APLICAIGV"));
                    conceptos.add(new ConceptoCobro(res.getString("CODCON"),res.getString("DESCON"),new BigDecimal(res.getDouble("PRECONIGV")),new Boolean(aplicaigv),new BigDecimal(res.getDouble("PRESINIGV")),res.getString("TipoMon"),res.getString("Exonerado"),res.getString("UNIMED"),res.getString("CodPrdSunat"),res.getString("CodGrp"),res.getString("CodFam"),res.getString("CodSFam"),res.getString("FlgAplDes")));
                    conceptosFiltrados.add(new ConceptoCobro(res.getString("CODCON"),res.getString("DESCON"),new BigDecimal(res.getDouble("PRECONIGV")),new Boolean(aplicaigv),new BigDecimal(res.getDouble("PRESINIGV")),res.getString("TipoMon"),res.getString("Exonerado"),res.getString("UNIMED"),res.getString("CodPrdSunat"),res.getString("CodGrp"),res.getString("CodFam"),res.getString("CodSFam"),res.getString("FlgAplDes")));  
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return conceptos;
    }
    

    
    public static ArrayList<ConceptoCobro> getConceptos(){        
        if(conceptos.isEmpty()){
            DbConnectionHost conex= new DbConnectionHost();
            //DbConnection conex= new DbConnection();
            /*try{
                BufferedReader br = new BufferedReader(new FileReader(
                                        Util.validaArchivoTicket(TipoArchivo.DAT.getTipo(), "concepto")));
                String line = br.readLine();
                while (line != null) {
                    if(line!=null && line.trim().compareTo("")!=0){
                        String[] linea = line.split("\\"+Util.FILE_DELIMITADOR);
                        conceptos.add(new ConceptoCobro(linea[0],linea[1],new BigDecimal(linea[2]),new Boolean(linea[3])));
                        conceptosFiltrados.add(new ConceptoCobro(linea[0],linea[1],new BigDecimal(linea[2]),new Boolean(linea[3])));
                    }
                    line = br.readLine();
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }*/
            try{
             PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT CODCON,DESCON,APLICAIGV,"
                            + "PRECONIGV,PRESINIGV,TipoMon,Exonerado,UNIMED,CodPrdSunat,CodGrp,CodFam,CodSFam,FlgAplDes "
                            //+ " FROM DMTICKET.DMT_CONCEPTOS_MAE WHERE ESTCON =? AND CIAID=?");
                            + " FROM DMTICKET.DMT_CONCEPTOS_MAE WHERE ESTCON =? AND CIAID=? ");                                         
             consulta.setString(1, "A");   
             consulta.setString(2, UsuarioData.getUsuario().getEmpresa()); 
             ResultSet res = consulta.executeQuery();
             while(res.next()){
               boolean aplicaigv = "1".equals(res.getString("APLICAIGV"));
               conceptos.add(new ConceptoCobro(res.getString("CODCON"),res.getString("DESCON"),new BigDecimal(res.getDouble("PRECONIGV")),new Boolean(aplicaigv),new BigDecimal(res.getDouble("PRESINIGV")),res.getString("TipoMon"),res.getString("Exonerado"),res.getString("UNIMED"),res.getString("CodPrdSunat"),res.getString("CodGrp"),res.getString("CodFam"),res.getString("CodSFam"),res.getString("FlgAplDes")));
               conceptosFiltrados.add(new ConceptoCobro(res.getString("CODCON"),res.getString("DESCON"),new BigDecimal(res.getDouble("PRECONIGV")),new Boolean(aplicaigv),new BigDecimal(res.getDouble("PRESINIGV")),res.getString("TipoMon"),res.getString("Exonerado"),res.getString("UNIMED"),res.getString("CodPrdSunat"),res.getString("CodGrp"),res.getString("CodFam"),res.getString("CodSFam"),res.getString("FlgAplDes")));  
             }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
        }
        return conceptos;
    }
    
    
    
    public static ConceptoCobro getBeanByIndex(int index){
        //return conceptos.get(index);
        return conceptosFiltrados.get(index);
    }
    
    public static void resetListConceptos(){
        conceptosFiltrados.clear();
        for(ConceptoCobro temp: conceptos){
            conceptosFiltrados.add(temp);
        }
    }
    public static void resetListArticulos(){
        conceptos.clear();        
    }
    
    public static void updateConceptos(ArrayList<ConceptoCobro> conceptosFiltradosParam){
        conceptosFiltrados.clear();
        for(ConceptoCobro temp: conceptosFiltradosParam){
            conceptosFiltrados.add(temp);
        }
    }
    public static ConceptoCobro getConceptoxCodigo(String codigo){
        ConceptoCobro conceptoCobro=null;
        DbConnectionHost conex= new DbConnectionHost();
        //DbConnection conex= new DbConnection();            
        try{
             PreparedStatement consulta = conex.getConnection().prepareStatement(
                     "SELECT CIAID,"
                    + "CODCON, "
                    + "DESCON, "
                    + "ESTCON, "
                    + "APLICAIGV, "
                    + "TipoMon, "
                    + "Preconigv, "
                    + "PreSinigv, "
                    + "UNIMED, "
                    + "CODBARRAS,Exonerado, CodPrdSunat, CodGrp, CodFam, CodSFam, FlgAplDes "
                    //+ " FROM DMTICKET.DMT_CONCEPTOS_MAE WHERE ESTCON =? AND CIAID=? AND CODCON=?");
                    + " FROM DMTICKET.DMT_CONCEPTOS_MAE WHERE ESTCON =? AND CIAID=? AND CODBARRAS=?");
             consulta.setString(1, "A");   
             consulta.setString(2, UsuarioData.getUsuario().getEmpresa());
             consulta.setString(3, codigo); 
             ResultSet res = consulta.executeQuery();
             while(res.next()){
               boolean aplicaigv = "1".equals(res.getString("APLICAIGV"));
               conceptoCobro= new ConceptoCobro(res.getString("CODCON"),res.getString("DESCON"),new BigDecimal(res.getDouble("PRECONIGV")),new Boolean(aplicaigv),new BigDecimal(res.getDouble("PRESINIGV"))
                                ,res.getString("CODCON"),res.getString("ESTCON"),res.getString("TipoMon"),res.getString("UNIMED"),res.getString("CODBARRAS"),res.getString("Exonerado"),res.getString("CodPrdSunat")
                                ,res.getString("CodGrp"),res.getString("CodFam"),res.getString("CodSFam"),res.getString("FlgAplDes"));
              //conceptosFiltrados.add(new ConceptoCobro(res.getString("CODCON"),res.getString("DESCON"),new BigDecimal(res.getDouble("PRECONIGV")),new Boolean(res.getString("APLICAIGV")),new BigDecimal(res.getDouble("PRESINIGV"))));  
             }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return conceptoCobro;
    }
//
    public static ConceptoCobro getConceptoxCodigoCon(String codigo){
        ConceptoCobro conceptoCobro=null;
        DbConnectionHost conex= new DbConnectionHost();
        //DbConnection conex= new DbConnection();            
        try{
             PreparedStatement consulta = conex.getConnection().prepareStatement(
                     "SELECT CIAID,"
                    + "CODCON, "
                    + "DESCON, "
                    + "ESTCON, "
                    + "APLICAIGV, "
                    + "TipoMon, "
                    + "Preconigv, "
                    + "PreSinigv, "
                    + "UNIMED, "
                    + "CODBARRAS,Exonerado, CodPrdSunat, CodGrp, CodFam, CodSFam, FlgAplDes "
                    + " FROM DMTICKET.DMT_CONCEPTOS_MAE WHERE ESTCON =? AND CIAID=? AND CODCON=?");
                    //+ " FROM DMTICKET.DMT_CONCEPTOS_MAE WHERE ESTCON =? AND CIAID=? AND CODBARRAS=?");
             consulta.setString(1, "A");   
             consulta.setString(2, UsuarioData.getUsuario().getEmpresa());
             consulta.setString(3, codigo); 
             ResultSet res = consulta.executeQuery();
             while(res.next()){
               boolean aplicaigv = "1".equals(res.getString("APLICAIGV"));
               conceptoCobro= new ConceptoCobro(res.getString("CODCON"),res.getString("DESCON"),new BigDecimal(res.getDouble("PRECONIGV")),new Boolean(aplicaigv),new BigDecimal(res.getDouble("PRESINIGV"))
                                ,res.getString("CODCON"),res.getString("ESTCON"),res.getString("TipoMon"),res.getString("UNIMED"),res.getString("CODBARRAS"),res.getString("Exonerado"),res.getString("CodPrdSunat")
                                ,res.getString("CodGrp"),res.getString("CodFam"),res.getString("CodSFam"),res.getString("FlgAplDes"));
              //conceptosFiltrados.add(new ConceptoCobro(res.getString("CODCON"),res.getString("DESCON"),new BigDecimal(res.getDouble("PRECONIGV")),new Boolean(res.getString("APLICAIGV")),new BigDecimal(res.getDouble("PRESINIGV"))));  
             }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return conceptoCobro;
    }    
//
    public static ConceptoCobro getConceptoxCodigoConHost(String ciaid, String codigo){
        ConceptoCobro conceptoCobro=null;
        DbConnectionHost conex= new DbConnectionHost();
        //DbConnection conex= new DbConnection();            
        try{
             PreparedStatement consulta = conex.getConnection().prepareStatement(
                     "SELECT CIAID,"
                    + "CODCON, "
                    + "DESCON, "
                    + "ESTCON, "
                    + "APLICAIGV, "
                    + "TipoMon, "
                    + "Preconigv, "
                    + "PreSinigv, "
                    + "UNIMED, "
                    + "CODBARRAS,Exonerado, CodPrdSunat, CodGrp, CodFam, CodSFam, FlgAplDes "
                    + " FROM DMTICKET.DMT_CONCEPTOS_MAE WHERE ESTCON =? AND CIAID=? AND CODCON=?");
                    //+ " FROM DMTICKET.DMT_CONCEPTOS_MAE WHERE ESTCON =? AND CIAID=? AND CODBARRAS=?");
             consulta.setString(1, "A");   
             consulta.setString(2, ciaid);
             consulta.setString(3, codigo); 
             ResultSet res = consulta.executeQuery();
             while(res.next()){
               boolean aplicaigv = "1".equals(res.getString("APLICAIGV"));
               conceptoCobro= new ConceptoCobro(res.getString("CODCON"),res.getString("DESCON"),new BigDecimal(res.getDouble("PRECONIGV")),new Boolean(aplicaigv),new BigDecimal(res.getDouble("PRESINIGV"))
                                ,res.getString("CODCON"),res.getString("ESTCON"),res.getString("TipoMon"),res.getString("UNIMED"),res.getString("CODBARRAS"),res.getString("Exonerado"),res.getString("CodPrdSunat")
                                ,res.getString("CodGrp"),res.getString("CodFam"),res.getString("CodSFam"),res.getString("FlgAplDes"));
              //conceptosFiltrados.add(new ConceptoCobro(res.getString("CODCON"),res.getString("DESCON"),new BigDecimal(res.getDouble("PRECONIGV")),new Boolean(res.getString("APLICAIGV")),new BigDecimal(res.getDouble("PRESINIGV"))));  
             }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return conceptoCobro;
    }    
    
//    
    public static void actualizarConcepto(String codigo,boolean aplicaIGV, String precio, String preciosinigv, String conceptodes, String exonerado ) {
    DbConnectionHost conex= new DbConnectionHost();
    //DbConnection conex= new DbConnection();     
    try {        
        PreparedStatement consultaUpdate = conex.getConnection().prepareStatement(
        "UPDATE DMTICKET.DMT_CONCEPTOS_MAE " +
        "SET APLICAIGV =?, PRECONIGV=?, PRESINIGV=?, DESCON=?" +
        //"WHERE CODCON=? AND CIAID=? AND Exonerado=?"); 
        "WHERE CODBARRAS=? AND CIAID=? AND Exonerado=?"); 
        consultaUpdate.setBoolean(1,aplicaIGV);
        consultaUpdate.setBigDecimal(2,new BigDecimal(precio));
        consultaUpdate.setBigDecimal(3,new BigDecimal(preciosinigv));
        consultaUpdate.setString(4,conceptodes);
        consultaUpdate.setString(5,codigo);
        consultaUpdate.setString(6,UsuarioData.getUsuario().getEmpresa());
        consultaUpdate.setString(7,exonerado);
        consultaUpdate.executeUpdate();
        JOptionPane.showMessageDialog(null, "Articulo modificado correctamente\n");
         
        conex.desconectar();

    } catch (Exception e) {
     JOptionPane.showMessageDialog(null, "no se pudo actualizar el Articulo\n"+e);
    }
   }
   // PCC 19/12/2019 
   public static void actualizarConceptoCB(String codigo, String precio, String preciosinigv, String codbarras ) {
    DbConnectionHost conex= new DbConnectionHost();
    //DbConnection conex= new DbConnection();     
    try {        
        PreparedStatement consultaUpdate = conex.getConnection().prepareStatement(
        "UPDATE DMTICKET.DMT_CONCEPTOS_MAE " +
        "SET PRECONIGV=?, PRESINIGV=?, CODBARRAS=? " +
        //"WHERE CODCON=? AND CIAID=? AND Exonerado=?"); 
        "WHERE CODCON=? AND CIAID=? "); 
        consultaUpdate.setBigDecimal(1,new BigDecimal(precio));
        consultaUpdate.setBigDecimal(2,new BigDecimal(preciosinigv));
        consultaUpdate.setString(3,codbarras);
        consultaUpdate.setString(4,codigo);
        consultaUpdate.setString(5,UsuarioData.getUsuario().getEmpresa());
        //
        consultaUpdate.executeUpdate();
        JOptionPane.showMessageDialog(null, "Articulo modificado correctamente\n");
        // 
        conex.desconectar();

    } catch (Exception e) {
     JOptionPane.showMessageDialog(null, "no se pudo actualizar el Articulo\n"+e);
    }
   }
   // Fin PCC 19/12/2019
   // Extraemos conceptos actualizados desde DmPos Central
   public ArrayList<ConceptosVO> ListaConceptosActualizar(){
       ArrayList<ConceptosVO> conceptosList = new ArrayList();
       ConceptosVO conceptosVO;
       DbConnectionHost conex= new DbConnectionHost(); 
       try{
           PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT CiaId,Codcon,Descon,Estcon, " +
            " AplicaIgv,Exonerado,TipoMon,Preconigv,PreSinigv,Unimed,Stock_Gen,Stock_Tda,CodBarras, " +
            " CodGrp,CodFam,CodSFam,CodPrdSunat,UsuReg,FecReg,UsuMod,FecMod,FlgAplDes " +
            " FROM DMTICKET.dmt_conceptos_act ");
           
           ResultSet res = consulta.executeQuery();
           while(res.next()){
              conceptosVO = new ConceptosVO();
              
              conceptosVO.setCiaId(res.getString("CiaId"));
              conceptosVO.setCodcon(res.getString("Codcon"));
              conceptosVO.setDescon(res.getString("Descon"));
              conceptosVO.setEstcon(res.getString("Estcon"));
              conceptosVO.setAplicaIgv(res.getBoolean("AplicaIgv"));
              conceptosVO.setExonerado(res.getString("Exonerado"));
              conceptosVO.setTipoMon(res.getString("TipoMon"));
              conceptosVO.setPreconigv(res.getBigDecimal("Preconigv"));
              conceptosVO.setPreSinigv(res.getBigDecimal("PreSinigv"));
              conceptosVO.setUnimed(res.getString("Unimed"));
              conceptosVO.setStock_Gen(res.getBigDecimal("Stock_Gen"));
              conceptosVO.setStock_Tda(res.getBigDecimal("Stock_Tda"));
              conceptosVO.setCodBarras(res.getString("CodBarras"));
              conceptosVO.setCodGrp(res.getString("CodGrp"));
              conceptosVO.setCodFam(res.getString("CodFam"));
              conceptosVO.setCodSFam(res.getString("CodSFam"));
              conceptosVO.setCodPrdSunat(res.getString("CodPrdSunat"));
              conceptosVO.setUsuReg(res.getString("UsuReg"));
              conceptosVO.setFecReg(res.getString("FecReg"));
              conceptosVO.setUsuMod(res.getString("UsuMod"));
              conceptosVO.setFecMod(res.getString("FecMod"));
              conceptosVO.setFlgAplDes(res.getString("FlgAplDes"));
              
              conceptosList.add(conceptosVO);
              
           }
           consulta.close();
       }catch(Exception ex){
            resultadoHost = false;
            conex.desconectar();
            ex.printStackTrace();
        }  
       
       return conceptosList;
    }
   
    // Insertamos/actualizamos conceptos(articulos) actualizados en DmPos Central.
    public boolean ActualizaConceptosLoc(ConceptosVO conceptosVO){
       //
       DbConnection conex= new DbConnection();     
       try{ 
            PreparedStatement consulta = conex.getConnection().prepareStatement("REPLACE INTO dmticket.dmt_conceptos_mae " +
            " (CiaId,Codcon,Descon,Estcon, AplicaIgv,Exonerado,TipoMon,Preconigv,PreSinigv,Unimed,Stock_Gen,Stock_Tda, " +
            " CodBarras,CodGrp,CodFam,CodSFam,CodPrdSunat,UsuReg,FecReg,UsuMod,FecMod,FlgAplDes) " +        
            "VALUES" +
            " (?,?,?,?, ?,?,?,?,?,?,?,?, " +
            " ?,?,?,?,?,?,?,?,?,?);");

            consulta.setString(1,conceptosVO.getCiaId());
            consulta.setString(2,conceptosVO.getCodcon());
            consulta.setString(3,conceptosVO.getDescon());
            consulta.setString(4,conceptosVO.getEstcon());
            consulta.setBoolean(5,conceptosVO.isAplicaIgv());
            consulta.setString(6,conceptosVO.getExonerado());
            consulta.setString(7,conceptosVO.getTipoMon());
            consulta.setBigDecimal(8,conceptosVO.getPreconigv());
            consulta.setBigDecimal(9,conceptosVO.getPreSinigv());
            consulta.setString(10,conceptosVO.getUnimed());
            consulta.setBigDecimal(11,conceptosVO.getStock_Gen());
            consulta.setBigDecimal(12,conceptosVO.getStock_Tda());
            consulta.setString(13,conceptosVO.getCodBarras());
            consulta.setString(14,conceptosVO.getCodGrp());
            consulta.setString(15,conceptosVO.getCodFam());
            consulta.setString(16,conceptosVO.getCodSFam());
            consulta.setString(17,conceptosVO.getCodPrdSunat());
            consulta.setString(18,conceptosVO.getUsuReg());            
            consulta.setString(19,conceptosVO.getFecReg());
            consulta.setString(20,conceptosVO.getUsuMod());
            consulta.setString(21,conceptosVO.getFecMod());
            consulta.setString(22,conceptosVO.getFlgAplDes());

            consulta.executeUpdate();
            consulta.close();
            conex.desconectar();
            
        }catch(Exception ex){
            resultadoLoc = false;
            conex.desconectar();
            ex.printStackTrace();
        }
        return resultadoLoc;
    }
    
    // Extraemos conceptos actualizados desde DmPos Central
   public static ArrayList<ConceptosVO> ListaConceptosBuscar(String patronBuscar){
       ArrayList<ConceptosVO> conceptosListBus = new ArrayList();
       ConceptosVO conceptosVO;
       DbConnectionHost conex= new DbConnectionHost();
       //DbConnection conex= new DbConnection(); 
       try{
           PreparedStatement consulta = conex.getConnection().prepareStatement
           ("SELECT codbarras,UPPER(descon) descon,preconigv FROM DMTICKET.dmt_conceptos_mae " +
            "WHERE UPPER(descon) LIKE ? AND ciaid=? ORDER BY descon LIMIT 500 ");
           //
           consulta.setString(1, patronBuscar); 
           consulta.setString(2, UsuarioData.getUsuario().getEmpresa());
           ResultSet res = consulta.executeQuery();
           //
           while(res.next()){
              conceptosVO = new ConceptosVO();
              
              conceptosVO.setCodBarras(res.getString("CodBarras"));
              conceptosVO.setDescon(res.getString("Descon"));
              conceptosVO.setPreconigv(res.getBigDecimal("Preconigv"));
              
              conceptosListBus.add(conceptosVO);
           }
           consulta.close();
       }catch(Exception ex){
            resultadoHost = false;
            conex.desconectar();
            ex.printStackTrace();
        }  
       return conceptosListBus;
    }
    
}

