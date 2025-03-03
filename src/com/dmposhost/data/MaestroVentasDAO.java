/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmposhost.data;

import com.dmposhost.bean.MaestroVentasVO;
import com.dmposhost.util.DbConnection;
import com.dmposhost.util.Util;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author jcastillop
 */
public class MaestroVentasDAO {
  MaestroVentasVO maeven;
  
  //public MaestroVentasVO consultarMaeVentas(String ptoVenta) {
  public MaestroVentasVO consultarMaeVentas(String IDCOMPANIA, String ID_TDA, String ptoVenta) {
      
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT IDCOMPANIA,PVTA_ID,"
           + "ID_TDA,LISTAPRECIOS,TIPOMONEDA,TIPOVENTA,UNIDADMEDIDA,TURNO,CLASEAUX,IMPRESIONES,TIPOCLIENTE,"
           + "IGVPORCENTAJE,CODIMPUESTO,IDLOCALIDAD,ALMACEN,FECHAPROCESO,IMPRESORA,RUTAFE,PRINTDEST "
           + "FROM DMTICKET.DMT_VENTAS_MAE WHERE IDCOMPANIA=? AND ID_TDA=? AND PVTA_ID=?");
   consulta.setString(1, IDCOMPANIA);
   consulta.setString(2, ID_TDA);
   consulta.setString(3, ptoVenta);  
   ResultSet res = consulta.executeQuery();
   //JOptionPane.showMessageDialog(null, "cia,tda,pvta\n"+IDCOMPANIA+"-"+ID_TDA+"-"+ptoVenta);
    
  if(res.next()){
    maeven= new MaestroVentasVO();    
    maeven.setIDCOMPANIA(res.getString("IDCOMPANIA"));
    //maeven.setPVTA_ID(res.getString("PVTA_ID"));
    maeven.setPVTA_ID(UsuarioData.getUsuario().getPtoVenta()); // Seteado de archivo INI
    maeven.setID_TDA(res.getString("ID_TDA"));
    maeven.setLISTAPRECIOS(res.getString("LISTAPRECIOS"));
    maeven.setTIPOMONEDA(res.getString("TIPOMONEDA"));
    maeven.setTIPOVENTA(res.getString("TIPOVENTA"));
    maeven.setUNIDADMEDIDA(res.getString("UNIDADMEDIDA"));
    maeven.setTURNO("");
    maeven.setCLASEAUX(res.getString("CLASEAUX"));
    maeven.setIMPRESIONES(res.getString("IMPRESIONES"));
    maeven.setTIPOCLIENTE(res.getString("TIPOCLIENTE"));
    maeven.setIGVPORCENTAJE(res.getDouble("IGVPORCENTAJE"));
    maeven.setCODIMPUESTO(res.getDouble("CODIMPUESTO"));
    maeven.setIDLOCALIDAD(res.getString("IDLOCALIDAD"));
    maeven.setALMACEN(res.getString("ALMACEN"));
    maeven.setFECHAPROCESO(res.getDate("FECHAPROCESO"));
    maeven.setIMPRESORA(res.getString("IMPRESORA"));
    maeven.setRUTAFE(res.getString("RUTAFE"));
    maeven.setPRINTDEST(res.getString("PRINTDEST"));
  }
  
  String turno = this.obtenerTurno(false,maeven.getIDCOMPANIA(),maeven.getID_TDA(),maeven.getPVTA_ID());
  maeven.setTURNO(turno);
  
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo consultar el maestro de ventas\n"+e);
  }
  return maeven;
 }   
  
  
 public String obtenerTurno(boolean cambiarTurno, String IDCOMPANIA, String ID_TDA, String PVTA_ID) {
  String turno=null;
  String fecModTurno="";
  String fecSistema="";
  //boolean actualiza=false;
  boolean actualiza=true;
  DbConnection conex= new DbConnection();     
  try {
    if(cambiarTurno==false){
        PreparedStatement consulta = conex.getConnection().prepareStatement("select TURNO "
           + "from DMTICKET.dmt_puntovta_mae where ciaid=? and tdaid=? and pvtaid=? "
           + "and DATE_FORMAT(fecmod, '%Y-%m-%d')=DATE_FORMAT(SYSDATE(), '%Y-%m-%d')");
        consulta.setString(1, IDCOMPANIA);
        consulta.setString(2, ID_TDA);
        consulta.setString(3, PVTA_ID);    
        ResultSet res = consulta.executeQuery();

        while (res.next()){   
          turno = res.getString("TURNO");
        }  
        res.close();
        consulta.close();
    }    
  
    if(turno==null){
        int turnoMax=1;
        int turnoCab=1;
        try{
        // Recupera �ltimo Turno de Cabecera de Ventas    
        PreparedStatement consulta1 = conex.getConnection().prepareStatement("select max(turno) TURNOCAB "
           + "from DMTICKET.dmt_ventas_cab where idcompania=? and almacen=? and pvtaid=? ");  
        consulta1.setString(1, IDCOMPANIA);
        consulta1.setString(2, ID_TDA);
        consulta1.setString(3, PVTA_ID);    
        ResultSet res1 = consulta1.executeQuery();
        //
        if (res1.next()){   
          //turnoMax = Integer.parseInt(res2.getString("TURNO"))+1;        
          turnoCab = Integer.parseInt(res1.getString("TURNOCAB"));
        }  
        res1.close();
        consulta1.close(); 
        // Recupera Turno del maestro de puntos de venta    
        PreparedStatement consulta2 = conex.getConnection().prepareStatement("select TURNO, "
           + "DATE_FORMAT(fecmod, '%Y-%m-%d') FECMOD, DATE_FORMAT(SYSDATE(), '%Y-%m-%d') FECSYS "
           + "from DMTICKET.dmt_puntovta_mae where ciaid=? and tdaid=? and pvtaid=? ");  // and indcierre='N'
        consulta2.setString(1, IDCOMPANIA);
        consulta2.setString(2, ID_TDA);
        consulta2.setString(3, PVTA_ID);    
        ResultSet res2 = consulta2.executeQuery();
        //
        if (res2.next()){   
          //turnoMax = Integer.parseInt(res2.getString("TURNO"))+1;        
          turnoMax = Integer.parseInt(res2.getString("TURNO"));
          fecModTurno= res2.getString("FECMOD");
          fecSistema=res2.getString("FECSYS");
        }  
        res2.close();
        consulta2.close(); 
        //
        // Validando que turno tenga movimientos
        PreparedStatement consulta5 = conex.getConnection().prepareStatement("select count(*) as CANTREG "
           + "from DMTICKET.dmt_ventas_cab where idcompania=? and almacen=? and pvtaid=? and turno=?");
        consulta5.setString(1, IDCOMPANIA);
        //consulta5.setString(2, Util.completarIzquierda(2, String.valueOf(ID_TDA) + "", "0"));    
        consulta5.setString(2, ID_TDA);    
        consulta5.setString(3, PVTA_ID);  
        consulta5.setString(4, Util.completarIzquierda(4, String.valueOf(turnoMax) + "", "0"));    
        ResultSet res5 = consulta5.executeQuery();
        if(res5.next()){   
        //if  (!(res5.getString("CANTREG").equals("0")) || !(fecModTurno.equals(fecSistema)) ){
          if  (!(res5.getString("CANTREG").equals("0")) || (turnoCab==turnoMax) ){
              //
              String turnoRep = Util.completarIzquierda(4, String.valueOf(turnoMax) + "", "0");
              JOptionPane.showMessageDialog(null, "No CERR� el Turno/Fecha : " +turnoRep+" / " +fecModTurno+"\n"+"SE PROCEDERA CON EL CIERRE AUTOMATICO...", "DmPos", JOptionPane.WARNING_MESSAGE);
              //
             // com.dematicket.form.FormTicket.imprimirReporte_Fecha_Turno(fecModTurno, turnoRep);
              turnoMax = turnoMax+1; 
              //actualiza=true;
          }
        } 
        res5.close();
        consulta5.close(); 
        // Fin Validacion de 
        }catch(Exception e){}
        
        
        if (actualiza==true) {
            PreparedStatement consulta3 = conex.getConnection().prepareStatement("UPDATE DMTICKET.dmt_puntovta_mae "
                    + "SET TURNO=? ,FECMOD=CURDATE() "
                    + "where ciaid=? and tdaid=? and pvtaid=? "); 
            consulta3.setString(1,Util.completarIzquierda(4, String.valueOf(turnoMax) + "", "0"));
            consulta3.setString(2,IDCOMPANIA);
            consulta3.setString(3,ID_TDA);
            consulta3.setString(4,PVTA_ID);        
            consulta3.executeUpdate();
            consulta3.close();
            //turno=Util.completarIzquierda(4, String.valueOf(turnoMax) + "", "0");
        }
        turno=Util.completarIzquierda(4, String.valueOf(turnoMax) + "", "0");
    }
  
    conex.desconectar();
  } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "no se pudo obtener turno del punto de venta\n"+e);
  }
  return turno;
 }    
 }