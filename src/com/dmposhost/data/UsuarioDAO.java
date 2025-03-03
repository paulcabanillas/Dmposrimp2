/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmposhost.data;

import com.dmposhost.bean.UsuarioVO;
import com.dmposhost.util.DbConnection;
import com.dmposhost.util.DbConnectionHost;
import com.dmposhost.util.Seguridad;

import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jcastillop
 */
public class UsuarioDAO {
  
  UsuarioVO usu;
  UsuarioVO usu2;
  
  static ArrayList<UsuarioVO> vendedorList = new ArrayList<UsuarioVO>();
  
  public UsuarioVO consultarUsuario(String usuario, String password) {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement(""
           + "SELECT U.USUARIO,U.PASSWORD,U.NOMBRE,U.MAIL,U.CIAID,U.PERFIL,U.IDTIENDA,P.PERFIL PERFILDESC " 
           + "FROM DMTICKET.DMT_USUARIOS_MAE U INNER JOIN DMTICKET.DMT_PERFILES_MAE P ON U.PERFIL=P.PERFILID "
//           + " WHERE U.USUARIO = ? AND U.PASSWORD= ? AND U.ESTADO='A' ");
           + " WHERE U.USUARIO = ? AND U.ESTADO='A' ");
   consulta.setString(1, usuario.toUpperCase());
   //consulta.setString(2, password);
   ResultSet res = consulta.executeQuery();
    
   //Seguridad.Encriptar(fieldPassword.getText())
  
  if (res.next()){
     //String xPasswD=res.getString("PASSWORD");
     //if (Seguridad.Desencriptar(xPasswD).equals(password)){
        usu= new UsuarioVO();
    
        usu.setUsuario(res.getString("USUARIO"));
        usu.setPassword(res.getString("PASSWORD"));
        usu.setNombre(res.getString("NOMBRE"));
        usu.setEmail(res.getString("MAIL"));
        usu.setEmpresa(res.getString("CIAID"));
        usu.setPerfil(res.getString("PERFIL"));
        usu.setTienda(res.getString("IDTIENDA")); 
        usu.setPerfilDesc(res.getString("PERFILDESC"));
     //}
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo consultar al Usuario\n"+e);
  }
  return usu;
 }
 
 public ArrayList<UsuarioVO> listarVendedores(String ciaid, String tiendaid) {
  
  DbConnection conex= new DbConnection();
     
  try {
   //primero se obtiene el codigo del perfil vendedor
   PreparedStatement consultaPerfil = conex.getConnection().prepareStatement("SELECT PERFILID FROM DMTICKET.dmt_perfiles_mae WHERE ESTADO = ? AND PERFIL= ? ");
   consultaPerfil.setString(1, "A");  
   consultaPerfil.setString(2, "Vendedor");
   ResultSet resPerfil = consultaPerfil.executeQuery();
   String perfilID="";
   if(resPerfil.next()){
    perfilID =resPerfil.getString("PERFILID");
    
   }
   resPerfil.close();
   consultaPerfil.close();

   //segundo procedemos a obtener la lista de vendedores
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT USUARIO,NOMBRE FROM DMTICKET.DMT_USUARIOS_MAE WHERE ESTADO = ? AND PERFIL= ? AND CIAID= ? AND IDTIENDA= ?");
   consulta.setString(1, "A");
   consulta.setString(2, perfilID);
   consulta.setString(3, ciaid);
   consulta.setString(4, tiendaid);
   ResultSet res = consulta.executeQuery();
   
   
   vendedorList.clear();
   usu2= new UsuarioVO();     
   usu2.setUsuario("- Seleccionar -");
   vendedorList.add(usu2);
    while(res.next()){
        usu2= new UsuarioVO();
        usu2.setUsuario(res.getString("USUARIO"));
        usu2.setNombre(res.getString("NOMBRE")); 
        vendedorList.add(usu2);

    }
    res.close();
    consulta.close();
    conex.desconectar();
    } catch (Exception e) {
     JOptionPane.showMessageDialog(null, "no se pudo obtener la lista de vendedores\n"+e);
    }
    return vendedorList;
 }
 
 //PCC 28.10.2019 Solo Consulta Host
 public ArrayList<UsuarioVO> listarVendedoresxDOI(String ciaid, String tiendaid) {
  
  //DbConnection conex= new DbConnection();
  DbConnectionHost conex= new DbConnectionHost(); 
     
  try {
   //primero se obtiene el codigo del perfil vendedor
   PreparedStatement consultaPerfil = conex.getConnection().prepareStatement("SELECT PERFILID FROM DMTICKET.dmt_perfiles_mae WHERE ESTADO = ? AND PERFIL= ? ");
   consultaPerfil.setString(1, "A");  
   consultaPerfil.setString(2, "Vendedor");
   ResultSet resPerfil = consultaPerfil.executeQuery();
   String perfilID="";
   if(resPerfil.next()){
    perfilID =resPerfil.getString("PERFILID");
    
   }
   resPerfil.close();
   consultaPerfil.close();

   //segundo procedemos a obtener la lista de vendedores
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT USUARIO,NOMBRE,DOI FROM DMTICKET.DMT_USUARIOS_MAE WHERE ESTADO = ? AND PERFIL= ? AND CIAID= ? AND IDTIENDA= ?");
   consulta.setString(1, "A");
   consulta.setString(2, perfilID);
   consulta.setString(3, ciaid);
   consulta.setString(4, tiendaid);
   ResultSet res = consulta.executeQuery();
   
   
   vendedorList.clear();
   usu2= new UsuarioVO();     
   usu2.setDoi("- Seleccionar -");
   vendedorList.add(usu2);
    while(res.next()){
        usu2= new UsuarioVO();
        usu2.setDoi(res.getString("DOI"));
        usu2.setNombre(res.getString("NOMBRE")); 
        vendedorList.add(usu2);

    }
    res.close();
    consulta.close();
    conex.desconectar();
    } catch (Exception e) {
     JOptionPane.showMessageDialog(null, "no se pudo obtener la lista de vendedores\n"+e);
    }
    return vendedorList;
 }
 
  public UsuarioVO getVendedorByIndex(int index) {  
     return vendedorList.get(index);
 }
  
 public void cambiarClaveUsuario(String usuario, String password, String newPassword) {
  boolean flag = false;
  DbConnection conex= new DbConnection();     
  try {        
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT USUARIO,PASSWORD,NOMBRE,MAIL FROM DMTICKET.DMT_USUARIOS_MAE WHERE USUARIO = ? AND PASSWORD= ? AND ESTADO =?");
        consulta.setString(1, usuario.toUpperCase());
        consulta.setString(2, password);
        consulta.setString(3, "A");        
        ResultSet res = consulta.executeQuery();

       if(res.next()){
         flag = true;         
       }       
       consulta.close();
       res.close();
       
       if(flag){
         PreparedStatement consulta2 = conex.getConnection().prepareStatement("UPDATE DMTICKET.DMT_USUARIOS_MAE SET PASSWORD=? WHERE USUARIO= ?"); 
         consulta2.setString(1,newPassword);
         consulta2.setString(2,usuario.toUpperCase());
         consulta2.executeUpdate();
         consulta2.close();
         JOptionPane.showMessageDialog(null, "clave modificada correctamente\n");
       }else{          
           JOptionPane.showMessageDialog(null, "usuario o clave incorrecta\n"); 
       }
       conex.desconectar();
       
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo consultar al Usuario\n"+e);
  }
 }   
 
 public void ingresarUsuario(String usuario, String password, String empresa, String perfil, String email, 
                             String nombres, String tienda, String estado, String tdoc, String doi, boolean xFlagUsuHost) {
  boolean flag = false;
  DbConnection conex= new DbConnection();     
  try {        
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT USUARIO,PASSWORD,NOMBRE,MAIL FROM DMTICKET.DMT_USUARIOS_MAE WHERE USUARIO = ?");
        consulta.setString(1, usuario.toUpperCase());
        ResultSet res = consulta.executeQuery();

       if(res.next()){
         flag = true;
         JOptionPane.showMessageDialog(null, "El Usuario ya se encuentra registrado, se proceder� a actualizarlo\n");         
       }       
       consulta.close();
       res.close();
       
       if(flag){
         PreparedStatement consulta2 = conex.getConnection().prepareStatement
                           ("UPDATE DMTICKET.DMT_USUARIOS_MAE SET CIAID=?, PERFIL=?,MAIL=?, NOMBRE=?, USUMOD=?, FECMOD=CURDATE(), " +
                            "IDTIENDA=?, ESTADO=?, PASSWORD=?, TDOCSUNAT=?, DOI=? WHERE USUARIO= ?"); 
         
         consulta2.setString(1,empresa);
         consulta2.setString(2,perfil);
         consulta2.setString(3,email);
         consulta2.setString(4,nombres);    
         //consulta2.setString(5,UsuarioData.getUsuario().getUsuario());  
         consulta2.setString(5,"");  
         consulta2.setString(6,tienda);
         consulta2.setString(7,estado);
         consulta2.setString(8,password);
         consulta2.setString(9,tdoc);
         consulta2.setString(10,doi);
         consulta2.setString(11,usuario.toUpperCase());
         consulta2.executeUpdate();
         consulta2.close();
         JOptionPane.showMessageDialog(null, "Usuario modificado correctamente\n");
       }else{          
           if (xFlagUsuHost){
               //
                Object[] options = {"Si","No"};
                int dialogButton = JOptionPane.showOptionDialog(null,
                    "ALERTA: El C�digo de Usuario YA se encuentra Registrado en la Central, Desea IMPORTAR el mismo Usuario a esta Tienda? ", "CONFIRMACION", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null
                    ,options, options[1]);     

                if (dialogButton == JOptionPane.YES_OPTION) {
                    try {
                        //
                        PreparedStatement consulta3 = conex.getConnection().prepareStatement
                           ("INSERT INTO DMTICKET.DMT_USUARIOS_MAE (USUARIO,PASSWORD,ESTADO,NOMBRE,MAIL,USUREG,FECREG,CIAID,PERFIL, " +
                            "IDTIENDA,TDOCSUNAT,DOI ) VALUES (?,?,?,?,?,?,CURDATE(),?,?,?,?,?)"); 
                        consulta3.setString(1,usuario.toUpperCase());
                        consulta3.setString(2,password);
                        consulta3.setString(3,estado);
                        consulta3.setString(4,nombres);
                        consulta3.setString(5,email);
                        //consulta3.setString(6,UsuarioData.getUsuario().getUsuario());
                        consulta3.setString(6,"");
                        consulta3.setString(7,empresa);
                        consulta3.setString(8,perfil);
                        consulta3.setString(9,tienda);
                        // PCC 12/11/2019 Se a�ade DOI
                        consulta3.setString(10,tdoc);
                        consulta3.setString(11,doi);
           
                        consulta3.executeUpdate();
                        consulta3.close();
                        JOptionPane.showMessageDialog(null, "Usuario registrado correctamente\n");
                        //JOptionPane.showMessageDialog(null, "usuario o clave incorrecta\n"); 
                        //
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "No se Registr� Usuario \n");
                }
           }else{
                try {
                        //
                        PreparedStatement consulta3 = conex.getConnection().prepareStatement
                           ("INSERT INTO DMTICKET.DMT_USUARIOS_MAE (USUARIO,PASSWORD,ESTADO,NOMBRE,MAIL,USUREG,FECREG,CIAID,PERFIL, " +
                            "IDTIENDA,TDOCSUNAT,DOI ) VALUES (?,?,?,?,?,?,CURDATE(),?,?,?,?,?)"); 
                        consulta3.setString(1,usuario.toUpperCase());
                        consulta3.setString(2,password);
                        consulta3.setString(3,estado);
                        consulta3.setString(4,nombres);
                        consulta3.setString(5,email);
                        //consulta3.setString(6,UsuarioData.getUsuario().getUsuario());
                        consulta3.setString(6,"");
                        consulta3.setString(7,empresa);
                        consulta3.setString(8,perfil);
                        consulta3.setString(9,tienda);
                        // PCC 12/11/2019 Se a�ade DOI
                        consulta3.setString(10,tdoc);
                        consulta3.setString(11,doi);
           
                        consulta3.executeUpdate();
                        consulta3.close();
                        JOptionPane.showMessageDialog(null, "Usuario registrado correctamente\n");
                        //JOptionPane.showMessageDialog(null, "usuario o clave incorrecta\n"); 
                        //
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
           }
       }
       conex.desconectar();
       
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo consultar al Usuario\n"+e);
  }
 }   
 
 
 public UsuarioVO validarUsuario(String usuario) {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().
           prepareStatement("SELECT U.USUARIO,U.PASSWORD,U.NOMBRE,U.MAIL,U.CIAID,U.PERFIL,U.IDTIENDA,U.ESTADO,U.TDOCSUNAT,U.DOI, " +
            "E.EMPRESA DESEMPRESA, P.PERFIL DESPERFIL, T.TDADES DESTIENDA, " +
            "CASE WHEN U.ESTADO='A' THEN 'Actvio' ELSE 'Inactivo' END DESESTADO " +
            "FROM DMTICKET.DMT_USUARIOS_MAE U " +
            "INNER JOIN DMTICKET.dmt_empresas_mae E ON U.CIAID=E.EMPRESAID " +
            "INNER JOIN DMTICKET.dmt_perfiles_mae P ON U.PERFIL=P.PERFILID " +
            "INNER JOIN DMTICKET.dmt_tiendas_mae T ON U.CIAID=T.CIAID AND U.IDTIENDA=T.TDAID WHERE USUARIO = ? ");
   consulta.setString(1, usuario.toUpperCase());
   ResultSet res = consulta.executeQuery();
    
  if(res.next()){
    usu= new UsuarioVO();    
    usu.setUsuario(res.getString("USUARIO"));
    usu.setPassword(res.getString("PASSWORD"));
    usu.setNombre(res.getString("NOMBRE"));
    usu.setEmail(res.getString("MAIL"));
    usu.setEmpresa(res.getString("DESEMPRESA"));
    usu.setPerfil(res.getString("DESPERFIL"));
    usu.setTienda(res.getString("DESTIENDA"));
    usu.setEstado(res.getString("DESESTADO"));
    usu.setTdocsunat(res.getString("TDOCSUNAT"));
    usu.setDoi(res.getString("DOI"));
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo consultar al Usuario\n"+e);
  }
  return usu;
 }
 
 //
 public UsuarioVO validarUsuarioHost(String usuario) {
  
  DbConnectionHost conex= new DbConnectionHost();
     
  try {
   PreparedStatement consulta = conex.getConnection().
           prepareStatement("SELECT U.USUARIO,U.PASSWORD,U.NOMBRE,U.MAIL,U.CIAID,U.PERFIL,U.IDTIENDA,U.ESTADO,U.TDOCSUNAT,U.DOI, " +
            "E.EMPRESA DESEMPRESA, P.PERFIL DESPERFIL, T.TDADES DESTIENDA, " +
            "CASE WHEN U.ESTADO='A' THEN 'Actvio' ELSE 'Inactivo' END DESESTADO " +
            "FROM DMTICKET.DMT_USUARIOS_MAE U " +
            "INNER JOIN DMTICKET.dmt_empresas_mae E ON U.CIAID=E.EMPRESAID " +
            "INNER JOIN DMTICKET.dmt_perfiles_mae P ON U.PERFIL=P.PERFILID " +
            "INNER JOIN DMTICKET.dmt_tiendas_mae T ON U.CIAID=T.CIAID AND U.IDTIENDA=T.TDAID WHERE USUARIO = ? ");
   consulta.setString(1, usuario.toUpperCase());
   ResultSet res = consulta.executeQuery();
    
  if(res.next()){
    usu= new UsuarioVO();    
    usu.setUsuario(res.getString("USUARIO"));
    usu.setPassword(res.getString("PASSWORD"));
    usu.setNombre(res.getString("NOMBRE"));
    usu.setEmail(res.getString("MAIL"));
    usu.setEmpresa(res.getString("DESEMPRESA"));
    usu.setPerfil(res.getString("DESPERFIL"));
    usu.setTienda(res.getString("DESTIENDA"));
    usu.setEstado(res.getString("DESESTADO"));
    usu.setTdocsunat(res.getString("TDOCSUNAT"));
    usu.setDoi(res.getString("DOI"));
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo consultar al Usuario\n"+e);
  }
  return usu;
 }
 //
 
 
 
}