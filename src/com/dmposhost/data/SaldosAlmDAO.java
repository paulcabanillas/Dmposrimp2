/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmposhost.data;

import com.dmposhost.bean.SaldosAlmVO;
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
 */
public class SaldosAlmDAO {
   static SaldosAlmVO saldosalm;
   
  //
  public static SaldosAlmVO consultarSaldosAlm(String xCiaId, String xAlm, String xCodcon) {
  
    //DbConnection conex= new DbConnection();
    DbConnectionHost conex= new DbConnectionHost(); 
     
    try {
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT CIAID, ALMACEN, "
                + " CODCON, STOCK_FIS, STOCK_RES, STOCK_ACT "
                + " FROM DMTICKET.dmt_saldosalm_mae WHERE  CIAID=? AND ALMACEN=? AND CODCON=? ");
        consulta.setString(1, xCiaId);
        consulta.setString(2, xAlm);
        consulta.setString(3, xCodcon);
        ResultSet res = consulta.executeQuery();
        
        saldosalm=null;
   
        while(res.next()){
            //
            saldosalm= new SaldosAlmVO();     
            saldosalm.setCiaid(res.getString("CIAID"));   
            saldosalm.setAlmacen(res.getString("ALMACEN")); 
            saldosalm.setCodcon(res.getString("CODCON"));   
            saldosalm.setStock_act(res.getBigDecimal("STOCK_ACT")); 
        }
        res.close();
        consulta.close();
        conex.desconectar();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "No se pudo obtener Saldos de Art�culo\n"+e);
    }
    return saldosalm;
 }
  
//
public static boolean ActualizaSaldosAlm(String xCiaId, String xAlm, String xCodcon, BigDecimal xCantidad) {
    //
    //DbConnection conex= new DbConnection();
    boolean resultado = true;
    DbConnectionHost conex= new DbConnectionHost(); 
    // 
    try {
        PreparedStatement consulta = conex.getConnection().prepareStatement("UPDATE DMTICKET.dmt_saldosalm_mae SET "
                + " STOCK_FIS = (STOCK_FIS - ?) , STOCK_RES = (STOCK_RES - ?), STOCK_ACT = (STOCK_ACT - ?) "
                + " WHERE  CIAID=? AND ALMACEN=? AND CODCON=? ");
        consulta.setBigDecimal(1, xCantidad);
        consulta.setBigDecimal(2, xCantidad);
        consulta.setBigDecimal(3, xCantidad);
        consulta.setString(4, xCiaId);
        consulta.setString(5, xAlm);
        consulta.setString(6, xCodcon);
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
