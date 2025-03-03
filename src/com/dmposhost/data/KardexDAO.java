/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmposhost.data;

import com.dmposhost.bean.KardexCabVO;
import com.dmposhost.bean.KardexDetVO;
import com.dmposhost.bean.KardexMesVO;
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
public class KardexDAO {
   static SaldosAlmVO saldosalm;
   static boolean resultado=true;
   
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
        JOptionPane.showMessageDialog(null, "No se pudo obtener Convenio\n"+e);
    }
    return saldosalm;
 }
  
public static boolean insertaKardexcab(KardexCabVO kardexCabVO){
    DbConnectionHost conex= new DbConnectionHost(); 
    try {
        PreparedStatement consulta = 
            conex.getConnection().prepareStatement("REPLACE INTO DMTICKET.dmt_kardexmov_cab ( " +
            " ciaid, almacen, tipo_mov, id_mov, fecmov, anomes, tipodoc_ref, serie_ref,numero_ref, " +
            " usureg, fecreg, usumod,fecmod ) " +
            " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            //
            consulta.setString(1,kardexCabVO.getCiaid());
            consulta.setString(2,kardexCabVO.getAlmacen());
            consulta.setString(3,kardexCabVO.getTipo_mov());
            consulta.setString(4,kardexCabVO.getId_mov());
            consulta.setString(5,kardexCabVO.getFecmov());
            consulta.setString(6,kardexCabVO.getAnomes());
            consulta.setString(7,kardexCabVO.getTipodoc_ref());
            consulta.setString(8,kardexCabVO.getSerie_ref());
            consulta.setString(9,kardexCabVO.getNumero_ref());
            consulta.setString(10,kardexCabVO.getUsureg());
            consulta.setString(11,kardexCabVO.getFecreg());
            consulta.setString(12,kardexCabVO.getUsumod());
            consulta.setString(13,kardexCabVO.getFecmod());
            //
            consulta.executeUpdate();  
            consulta.close();
            conex.desconectar();
            resultado = true;
            //
    }catch (Exception ex) {
            resultado = false;
            conex.desconectar();
            ex.printStackTrace();
    }
    return resultado;
}
    
public static boolean insertaKardexdet(KardexDetVO kardexDetVO){
    DbConnectionHost conex= new DbConnectionHost(); 
    try {
        PreparedStatement consulta = 
            conex.getConnection().prepareStatement("REPLACE INTO DMTICKET.dmt_kardexmov_det ( " +
            " ciaid, almacen, tipo_mov, id_mov, item, fecmov, anomes, codcon, cantidad, " +
            " usureg, fecreg, usumod,fecmod) " +
            " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        
            //
            consulta.setString(1,kardexDetVO.getCiaid());
            consulta.setString(2,kardexDetVO.getAlmacen());
            consulta.setString(3,kardexDetVO.getTipo_mov());
            consulta.setString(4,kardexDetVO.getId_mov());
            consulta.setString(5,kardexDetVO.getItem());
            consulta.setString(6,kardexDetVO.getFecmov());
            consulta.setString(7,kardexDetVO.getAnomes());
            consulta.setString(8,kardexDetVO.getCodcon());
            consulta.setBigDecimal(9,kardexDetVO.getCantidad());
            consulta.setString(10,kardexDetVO.getUsureg());
            consulta.setString(11,kardexDetVO.getFecreg());
            consulta.setString(12,kardexDetVO.getUsumod());
            consulta.setString(13,kardexDetVO.getFecmod());
            //
            consulta.executeUpdate();  
            consulta.close();
            conex.desconectar();
            resultado = true;
            //
    }catch (Exception ex) {
            resultado = false;
            conex.desconectar();
            ex.printStackTrace();
    }
    return resultado;
}

public static boolean insertaKardexmes(KardexMesVO kardexMesVO){
    DbConnectionHost conex= new DbConnectionHost(); 
    try {
        PreparedStatement consulta = 
            conex.getConnection().prepareStatement("REPLACE INTO DMTICKET.dmt_kardexmov_det ( " +
            " ciaid, almacen, anomes, codcon, cant_ing, cant_sal, stock_ini, stock_fin, " +
            " usureg, fecreg, usumod,fecmod) " +
            " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            //
            consulta.setString(1,kardexMesVO.getCiaid());
            consulta.setString(2,kardexMesVO.getAlmacen());
            consulta.setString(3,kardexMesVO.getAnomes());
            consulta.setString(4,kardexMesVO.getCodcon());
            consulta.setBigDecimal(5,kardexMesVO.getCant_ing());
            consulta.setBigDecimal(6,kardexMesVO.getCant_sal());
            consulta.setBigDecimal(7,kardexMesVO.getStock_ini());
            consulta.setBigDecimal(8,kardexMesVO.getStock_fin());
            consulta.setString(9,kardexMesVO.getUsureg());
            consulta.setString(10,kardexMesVO.getFecreg());
            consulta.setString(11,kardexMesVO.getUsumod());
            consulta.setString(12,kardexMesVO.getFecmod());
            //
            consulta.executeUpdate();  
            consulta.close();
            conex.desconectar();
            resultado = true;
            //
    }catch (Exception ex) {
            resultado = false;
            conex.desconectar();
            ex.printStackTrace();
    }
    return resultado;
}

  
}
