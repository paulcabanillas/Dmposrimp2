/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmposhost.data;

import com.dmposhost.bean.DistritoVO;
import com.dmposhost.bean.DocumentosVO;
import com.dmposhost.bean.EmpresaVO;
import com.dmposhost.bean.ProvinciaVO;
import com.dmposhost.bean.TiendaVO;
import com.dmposhost.util.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jcastillop
 */
public class DistritoDAO {
   static DistritoVO distrito;
   static ArrayList<DistritoVO> distritoList = new ArrayList<DistritoVO>();
   
  public static ArrayList<DistritoVO> consultarDistrixProv(String codDepa, String codProv) {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT DISTID, NOMBRE,DEPAID, PROVID "
           + " FROM dmticket.dmt_distritos_mae WHERE DEPAID=? AND PROVID=?");
   consulta.setString(1, codDepa);
   consulta.setString(2, codProv);
   ResultSet res = consulta.executeQuery();
  
  distritoList.clear();
  distrito= new DistritoVO();     
  distrito.setDistrito("- Seleccionar -");
  distritoList.add(distrito);
  
  while(res.next()){
    distrito= new DistritoVO(); 
    distrito.setCodProvincia(res.getString("PROVID"));
    distrito.setDistrito(res.getString("NOMBRE"));   
    distrito.setCodDepartamento(res.getString("DEPAID")); 
    distrito.setCodDistrito(res.getString("DISTID")); 
    distritoList.add(distrito);
    
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo obtener los distritos de la provincia seleccionada\n"+e);
  }
  return distritoList;
 }
 public static DistritoVO consultarUbigeo(String codigo) {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT DISTID, NOMBRE,DEPAID, PROVID "
           + " FROM dmticket.dmt_distritos_mae WHERE DISTID=?");
   consulta.setString(1, codigo);
   ResultSet res = consulta.executeQuery();
  
  while(res.next()){
    distrito= new DistritoVO(); 
    distrito.setCodProvincia(res.getString("PROVID"));
    distrito.setDistrito(res.getString("NOMBRE"));   
    distrito.setCodDepartamento(res.getString("DEPAID")); 
    distrito.setCodDistrito(res.getString("DISTID")); 
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo obtener los distritos de la provincia seleccionada\n"+e);
  }
  return distrito;
 }
 public static DistritoVO getByIndex(int index) {  
     return distritoList.get(index);
 }
}
