/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmposhost.data;

import com.dmposhost.bean.DepartamentoVO;
import com.dmposhost.bean.DocumentosVO;
import com.dmposhost.bean.EmpresaVO;
import com.dmposhost.util.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jcastillop
 */
public class DepartamentoDAO {
   static DepartamentoVO departamento;
   static ArrayList<DepartamentoVO> departamentoList = new ArrayList<DepartamentoVO>();
   
  public static ArrayList<DepartamentoVO> consultarDepartamentos() {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT DEPAID, NOMBRE "
           + " FROM dmticket.dmt_departamentos_mae");
   ResultSet res = consulta.executeQuery();
  
   departamentoList.clear();
   departamento= new DepartamentoVO();     
   departamento.setDepartamento("- Seleccionar -");
   departamentoList.add(departamento);
  
  while(res.next()){
    departamento= new DepartamentoVO();     
    departamento.setCodDepartamento(res.getString("DEPAID"));   
    departamento.setDepartamento(res.getString("NOMBRE")); 
    departamentoList.add(departamento);
    
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo obtener los departamentos\n"+e);
  }
  return departamentoList;
 }
 public static DepartamentoVO consultarUbigro(String codigo) {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT DEPAID, NOMBRE "
           + " FROM dmticket.dmt_departamentos_mae Where DEPAID=?");
   consulta.setString(1, codigo);
   ResultSet res = consulta.executeQuery();
  
   while(res.next()){
    departamento= new DepartamentoVO();     
    departamento.setCodDepartamento(res.getString("DEPAID"));   
    departamento.setDepartamento(res.getString("NOMBRE")); 
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo obtener los departamentos\n"+e);
  }
  return departamento;
 }
 public static DepartamentoVO getByIndex(int index) {  
     return departamentoList.get(index);
 }
}
