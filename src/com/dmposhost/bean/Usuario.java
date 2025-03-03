/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmposhost.bean;

/**
 *
 * @author lmonge
 */
public class Usuario {
    private String usuario;
    private String nombre;
    private String mail;
    private String empresa;
    private String perfil;
    private String tienda;
    private String token;
    private String ptoVenta;
    private String perfilDesc;

    public Usuario() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    public String getPerfilDesc() {
        return perfilDesc;
    }

    public void setPerfilDesc(String perfilDesc) {
        this.perfilDesc = perfilDesc;
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", nombre=" + nombre + ", mail=" + mail + '}';
    }

    /**
     * @return the tienda
     */
    public String getTienda() {
        return tienda;
    }

    /**
     * @param tienda the tienda to set
     */
    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    /**
     * @return the ptoVenta
     */
    public String getPtoVenta() {
        return ptoVenta;
    }

    /**
     * @param ptoVenta the ptoVenta to set
     */
    public void setPtoVenta(String ptoVenta) {
        this.ptoVenta = ptoVenta;
    }
    
}