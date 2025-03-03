/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmposhost.data;

import com.dmposhost.bean.MensajesVO;
import com.dmposhost.util.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author jcastillop
 */
public class MensajesDAO {
    MensajesVO mensaje;
    String cadenaMensaje="";
  public MensajesVO consultarMensajes() {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT LINEA,VALOR"
           + " FROM DMTICKET.DMT_MENSAJES_MAE ORDER BY CAST(LINEA AS UNSIGNED)");
   ResultSet res = consulta.executeQuery();
  /*  
  if(res.next()){
    mensaje= new MensajesVO();
    
    cliente.setCODIGOCLIENTE(res.getString("CODIGOCLIENTE"));
    cliente.setCLIERUC(res.getString("CLIERUC"));
    cliente.setCLIENOM(res.getString("CLIENOM"));  
    cliente.setCLIEDIR(res.getString("CLIEDIR")); 
  }
  res.close();
  */
  mensaje= new MensajesVO();
  
  while(res.next()){
      cadenaMensaje=cadenaMensaje+res.getString("VALOR")+"@";
  }
  mensaje.setMensajes(cadenaMensaje);
  res.close();
  
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
      cadenaMensaje="";
      JOptionPane.showMessageDialog(null, "no se pudo consultar los mensajes\n"+e);
  }
  return mensaje;
 }       
}
