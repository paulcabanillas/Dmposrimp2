/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmposhost.data;

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
public class ProvinciaDAO {
   static ProvinciaVO provincia;
   static ArrayList<ProvinciaVO> provinciaList = new ArrayList<ProvinciaVO>();
   
  public static ArrayList<ProvinciaVO> consultarProvxDepa(String codDepa) {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT PROVID, NOMBRE,DEPAID "
           + " FROM dmticket.dmt_provincias_mae WHERE DEPAID=?");
   consulta.setString(1, codDepa);
   ResultSet res = consulta.executeQuery();
  
  provinciaList.clear();
  provincia= new ProvinciaVO();     
  provincia.setProvincia("- Seleccionar -");
  provinciaList.add(provincia);
  
  while(res.next()){
    provincia= new ProvinciaVO(); 
    provincia.setCodProvincia(res.getString("PROVID"));
    provincia.setProvincia(res.getString("NOMBRE"));   
    provincia.setCodDepartamento(res.getString("DEPAID")); 
    provinciaList.add(provincia);
    
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo obtener las provincias del departamento seleccionado\n"+e);
  }
  return provinciaList;
 }
  public static ProvinciaVO consultarUbigeo(String codigo) {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT PROVID, NOMBRE,DEPAID "
           + " FROM dmticket.dmt_provincias_mae WHERE PROVID=?");
   consulta.setString(1, codigo);
   ResultSet res = consulta.executeQuery();
  
  while(res.next()){
    provincia= new ProvinciaVO(); 
    provincia.setCodProvincia(res.getString("PROVID"));
    provincia.setProvincia(res.getString("NOMBRE"));   
    provincia.setCodDepartamento(res.getString("DEPAID")); 
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo obtener las provincias del departamento seleccionado\n"+e);
  }
  return provincia;
 }
 public static ProvinciaVO getByIndex(int index) {  
     return provinciaList.get(index);
 }
}
