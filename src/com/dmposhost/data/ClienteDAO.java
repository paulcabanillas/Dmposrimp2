/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmposhost.data;

import com.dmposhost.bean.ClienteMaeVO;
import com.dmposhost.bean.ClienteVO;
//import com.dematicket.bean.FPagomovVO;
//import com.dematicket.bean.VentasCabeceraVO;
//import static com.dematicket.data.MedioPagoDAO.resultado;
//import static com.dematicket.form.FormTicket.txtCliente;
//import static com.dematicket.form.FormTicket.txtDireccionP;
//import static com.dematicket.form.FormTicket.txtRUCDNI;
//import static com.dematicket.form.FormTicket.jcbTipoDocumento;
//
//import static com.dematicket.form.FormTicket.convenio;
//
import com.dmposhost.util.DbConnection;
import com.dmposhost.util.DbConnectionHost;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author jcastillop
 */
public class ClienteDAO {
  ClienteVO cliente;
  
  static boolean resultado=true;
  static boolean resultadoHost=true;
  public ClienteVO consultarCliente() {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT CODIGOCLIENTE,NRODOCUMENTO,CLIENOM,CLIEDIR"
           + " FROM DMTICKET.DMT_CLIENTES_MAE WHERE ESTADO_CLI=? AND CODIGOCLIENTE = ?");
   consulta.setString(1, "A");
   consulta.setString(2, "33333333");
   ResultSet res = consulta.executeQuery();
    
  if(res.next()){
    cliente= new ClienteVO();
    
    cliente.setCODIGOCLIENTE(res.getString("CODIGOCLIENTE"));
    cliente.setCLIERUC(res.getString("NRODOCUMENTO"));
    cliente.setCLIENOM(res.getString("CLIENOM"));  
    cliente.setCLIEDIR(res.getString("CLIEDIR")); 
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo consultar cliente gen�rico\n"+e);
  }
  return cliente;
 }    
  
   public ClienteVO consultarClientexDoc(String documento) {
  
    DbConnectionHost conex= new DbConnectionHost();

    try {
     PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT "
             +" CIAID,CODIGOCLIENTE,TIPOCLIENTE,TIPODOCSUNAT,NRODOCUMENTO,TIPOPERSONA,"
             +" CLIENOM,SEXO,FECNAC,CLIEDIR,UBIGEO,EMAIL,TELEFONO1,TELEFONO2,CELULAR,ESTADO_CLI,CONVENIO "
             + " FROM DMTICKET.DMT_CLIENTES_MAE WHERE ESTADO_CLI=? AND CODIGOCLIENTE = ?");
     consulta.setString(1, "A");
     consulta.setString(2, documento);
     ResultSet res = consulta.executeQuery();

    if(res.next()){
      cliente= new ClienteVO();
      
      cliente.setCiaid(res.getString("CIAID"));
      cliente.setCODIGOCLIENTE(res.getString("CODIGOCLIENTE"));
      cliente.setTcliente(res.getString("TIPOCLIENTE"));
      cliente.setDocsunat(res.getString("TIPODOCSUNAT"));      
      cliente.setCLIERUC(res.getString("NRODOCUMENTO"));
      cliente.setTpersona(res.getString("TIPOPERSONA"));     
      cliente.setCLIENOM(res.getString("CLIENOM"));
      cliente.setSexo(res.getString("SEXO"));
      cliente.setFecnac(res.getString("FECNAC"));
      cliente.setCLIEDIR(res.getString("CLIEDIR"));
      
      cliente.setUbigeo(res.getString("UBIGEO"));
      cliente.setMail(res.getString("EMAIL"));
      cliente.setTelefono1(res.getString("TELEFONO1"));
      cliente.setTelefono2(res.getString("TELEFONO2"));
      cliente.setCelular(res.getString("CELULAR"));
      cliente.setEstado(res.getString("ESTADO_CLI"));
      cliente.setConvenio(res.getString("CONVENIO"));
    }
    res.close();
    consulta.close();
    conex.desconectar();
    } catch (Exception e) {
     JOptionPane.showMessageDialog(null, "no se pudo consultar cliente gen�rico\n"+e);
    }
    return cliente;
 }   
 
 public ClienteVO consultarClientexDocAll(String documento) {
  
    DbConnection conex= new DbConnection();

    try {
     PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT "
             +" CIAID,CODIGOCLIENTE,TIPOCLIENTE,TIPODOCSUNAT,NRODOCUMENTO,TIPOPERSONA,"
             +" CLIENOM,SEXO,FECNAC,CLIEDIR,UBIGEO,EMAIL,TELEFONO1,TELEFONO2,CELULAR,ESTADO_CLI,CONVENIO "
             + " FROM DMTICKET.DMT_CLIENTES_MAE WHERE CODIGOCLIENTE = ?");
     //consulta.setString(1, "A");
     consulta.setString(1, documento);
     ResultSet res = consulta.executeQuery();

    if(res.next()){
      cliente= new ClienteVO();
      
      cliente.setCiaid(res.getString("CIAID"));
      cliente.setCODIGOCLIENTE(res.getString("CODIGOCLIENTE"));
      cliente.setTcliente(res.getString("TIPOCLIENTE"));
      cliente.setDocsunat(res.getString("TIPODOCSUNAT"));      
      cliente.setCLIERUC(res.getString("NRODOCUMENTO"));
      cliente.setTpersona(res.getString("TIPOPERSONA"));     
      cliente.setCLIENOM(res.getString("CLIENOM"));
      cliente.setSexo(res.getString("SEXO"));
      cliente.setFecnac(res.getString("FECNAC"));
      cliente.setCLIEDIR(res.getString("CLIEDIR"));
      
      cliente.setUbigeo(res.getString("UBIGEO"));
      cliente.setMail(res.getString("EMAIL"));
      cliente.setTelefono1(res.getString("TELEFONO1"));
      cliente.setTelefono2(res.getString("TELEFONO2"));
      cliente.setCelular(res.getString("CELULAR"));
      cliente.setEstado(res.getString("ESTADO_CLI"));
      cliente.setConvenio(res.getString("CONVENIO"));
    }
    res.close();
    consulta.close();
    conex.desconectar();
    } catch (Exception e) {
     JOptionPane.showMessageDialog(null, "no se pudo consultar cliente gen�rico\n"+e);
    }
    return cliente;
 }    
   
 //
 public ArrayList<ClienteMaeVO> clientesSinProcesarList (){
       ArrayList<ClienteMaeVO> clientesList = new ArrayList();
       ClienteMaeVO clienteMaeVO;
       DbConnection conex= new DbConnection(); 
       try{
           PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT CIAID, CODIGOCLIENTE,TIPOCLIENTE, " +
            " TIPODOCSUNAT,NRODOCUMENTO,TIPOPERSONA,CLIENOM,SEXO,FECNAC,CLIEDIR,UBIGEO,EMAIL,TELEFONO1,TELEFONO2,CELULAR, " +
            " ESTADO_CLI,USUREG,FECREG,USUMOD,FECMOD,CONVENIO " +
            " FROM DMTICKET.DMT_CLIENTES_MAE WHERE PROCESADO IS NULL");
           
           ResultSet res = consulta.executeQuery();
           while(res.next()){
              clienteMaeVO = new ClienteMaeVO();
              
              clienteMaeVO.setCIAID(res.getString("CIAID"));
              clienteMaeVO.setCODIGOCLIENTE(res.getString("CODIGOCLIENTE"));
              clienteMaeVO.setTIPOCLIENTE(res.getString("TIPOCLIENTE"));
              clienteMaeVO.setTIPODOCSUNAT(res.getString("TIPODOCSUNAT"));
              clienteMaeVO.setNRODOCUMENTO(res.getString("NRODOCUMENTO"));
              clienteMaeVO.setTIPOPERSONA(res.getString("TIPOPERSONA"));
              clienteMaeVO.setCLIENOM(res.getString("CLIENOM"));
              clienteMaeVO.setSEXO(res.getString("SEXO"));
              clienteMaeVO.setFECNAC(res.getString("FECNAC"));
              clienteMaeVO.setCLIEDIR(res.getString("CLIEDIR"));
              clienteMaeVO.setUBIGEO(res.getString("UBIGEO"));
              clienteMaeVO.setEMAIL(res.getString("EMAIL"));
              clienteMaeVO.setTELEFONO1(res.getString("TELEFONO1"));
              clienteMaeVO.setTELEFONO2(res.getString("TELEFONO2"));
              clienteMaeVO.setCELULAR(res.getString("CELULAR"));
              clienteMaeVO.setESTADO_CLI(res.getString("ESTADO_CLI"));
              clienteMaeVO.setUSUREG(res.getString("USUREG"));
              clienteMaeVO.setFECREG(res.getString("FECREG"));
              clienteMaeVO.setUSUMOD(res.getString("USUMOD"));
              clienteMaeVO.setFECMOD(res.getString("FECMOD"));
              clienteMaeVO.setCONVENIO(res.getString("CONVENIO"));
              
              clientesList.add(clienteMaeVO);
              
           }
           consulta.close();
       }catch(Exception ex){
            conex.desconectar();
            ex.printStackTrace();
        }  
       
       return clientesList;
    }
 //
 // Inserta Clientes en DmPosCentral
    public boolean insertaClientesCentral(ClienteMaeVO clienteMaeVO){
        DbConnectionHost conex= new DbConnectionHost(); 
       try{ 
            PreparedStatement consulta = 
            conex.getConnection().prepareStatement("REPLACE INTO DMTICKET.DMT_CLIENTES_MAE ( " +
            " CIAID, CODIGOCLIENTE,TIPOCLIENTE,TIPODOCSUNAT,NRODOCUMENTO, " +
            " TIPOPERSONA,CLIENOM,SEXO,FECNAC,CLIEDIR,UBIGEO,EMAIL,TELEFONO1,TELEFONO2,CELULAR, " +
            " ESTADO_CLI,USUREG,FECREG,USUMOD,FECMOD,CONVENIO) " +                   
            " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            //
            consulta.setString(1,clienteMaeVO.getCIAID());
            consulta.setString(2,clienteMaeVO.getCODIGOCLIENTE());
            consulta.setString(3,clienteMaeVO.getTIPOCLIENTE());
            consulta.setString(4,clienteMaeVO.getTIPODOCSUNAT());
            consulta.setString(5,clienteMaeVO.getNRODOCUMENTO());
            consulta.setString(6,clienteMaeVO.getTIPOPERSONA());
            consulta.setString(7,clienteMaeVO.getCLIENOM());
            consulta.setString(8,clienteMaeVO.getSEXO());
            consulta.setString(9,clienteMaeVO.getFECNAC());
            consulta.setString(10,clienteMaeVO.getCLIEDIR());
            consulta.setString(11,clienteMaeVO.getUBIGEO());
            consulta.setString(12,clienteMaeVO.getEMAIL());
            consulta.setString(13,clienteMaeVO.getTELEFONO1());
            consulta.setString(14,clienteMaeVO.getTELEFONO2());
            consulta.setString(15,clienteMaeVO.getCELULAR());
            consulta.setString(16,clienteMaeVO.getESTADO_CLI());
            consulta.setString(17,clienteMaeVO.getUSUREG());
            consulta.setString(18,clienteMaeVO.getFECREG());
            consulta.setString(19,clienteMaeVO.getUSUMOD());
            consulta.setString(20,clienteMaeVO.getFECMOD());
            consulta.setString(21,clienteMaeVO.getCONVENIO());
            //
            consulta.executeUpdate();  
            consulta.close();
            conex.desconectar();
            resultadoHost = true;
        }catch(Exception ex){
            resultadoHost = false;
            conex.desconectar();
            ex.printStackTrace();
        }
        return resultadoHost;
    }

// Actualiza Flag procesado en Clientes transferidos a DmPosCentral
    public boolean actualizaClientes(ClienteMaeVO clienteMaeVO){
        DbConnection conex= new DbConnection(); 
        try{
            PreparedStatement consulta = conex.getConnection().prepareStatement("UPDATE DMTICKET.DMT_CLIENTES_MAE SET PROCESADO=? WHERE "
                    + " CIAID=? AND CODIGOCLIENTE=? ");
            consulta.setString(1, "S");
            consulta.setString(2, clienteMaeVO.getCIAID());
            consulta.setString(3, clienteMaeVO.getCODIGOCLIENTE());
            //
            consulta.executeUpdate();          
            consulta.close();
            conex.desconectar();
        }catch(Exception ex){
            resultado = false;
            conex.desconectar();
            ex.printStackTrace();
        }
        return resultado;
    }    

 
 
}
