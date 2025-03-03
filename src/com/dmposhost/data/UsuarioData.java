/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmposhost.data;

import com.dmposhost.bean.Usuario;
import com.dmposhost.bean.UsuarioVO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lmonge
 */
public class UsuarioData {

    static Usuario usuario;
    static UsuarioVO usuarioVO;
    static ArrayList<UsuarioVO> vendedorList = new ArrayList<UsuarioVO>();
    
    public static Usuario getUsuario(){
        if(usuario==null){
            usuario = new Usuario();
        }
        return usuario;
    }
    public static UsuarioVO getUsuarioBD(String usuario, String password){
        UsuarioDAO miusuarioDAO = new UsuarioDAO();
        usuarioVO = miusuarioDAO.consultarUsuario(usuario, password);
      return usuarioVO;
    }
    
    public static ArrayList<UsuarioVO> listarVendedoresBD(String ciaid, String tiendaid){
        UsuarioDAO miusuarioDAO = new UsuarioDAO();
        vendedorList = miusuarioDAO.listarVendedores(ciaid,tiendaid);
      return vendedorList;
    }
    
    public static ArrayList<UsuarioVO> listarVendedoresDOI(String ciaid, String tiendaid){
        UsuarioDAO miusuarioDAO = new UsuarioDAO();
        vendedorList = miusuarioDAO.listarVendedoresxDOI(ciaid,tiendaid);
      return vendedorList;
    }
    
    public static UsuarioVO getVendedorByIndex(int index){
        UsuarioDAO miusuarioDAO = new UsuarioDAO();
        return miusuarioDAO.getVendedorByIndex(index);
      //return vendedorList;
    }
    
    public static UsuarioVO updateInsertUsuarioBD(String usuario, String password, String empresa, String perfil, String email, String nombres, String tienda, String estado, String tdoc, String doi, boolean xFlagUsuHost){
        UsuarioDAO miusuarioDAO = new UsuarioDAO();
        miusuarioDAO.ingresarUsuario(usuario, password, empresa, perfil,email, nombres,tienda,estado,tdoc,doi,xFlagUsuHost);
      return usuarioVO;
    }
    public static void changePassBD(String usuario, String password, String newPassword){
        UsuarioDAO miusuarioDAO = new UsuarioDAO();
        miusuarioDAO.cambiarClaveUsuario(usuario, password, newPassword);
      //return usuarioVO;
    }
    
    public static UsuarioVO validarUsuario(String usuario){
        UsuarioDAO miusuarioDAO = new UsuarioDAO();
        usuarioVO = miusuarioDAO.validarUsuario(usuario);
        return usuarioVO;
    }
    
    public static UsuarioVO validarUsuarioHost(String usuario){
        UsuarioDAO miusuarioDAO = new UsuarioDAO();
        usuarioVO = miusuarioDAO.validarUsuarioHost(usuario);
        return usuarioVO;
    }
    
}
