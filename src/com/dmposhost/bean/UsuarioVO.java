/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmposhost.bean;

/**
 *
 * @author jcastillop
 */ 
public class UsuarioVO {
    private String usuario;
    private String password;
    private String nombre;
    private String email;
    private String empresa;
    private String perfil;
    private String tienda;
    private String estado;
    private String perfilDesc;
    private String tdocsunat;
    private String doi;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }
    
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getPerfil() {
        return perfil;
    }
    
    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    public String getTienda() {
        return tienda;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
     public void setPerfilDesc(String perfilDesc) {
        this.perfilDesc = perfilDesc;
    }

    public String getPerfilDesc() {
        return perfilDesc;
    }

    /**
     * @return the doi
     */
    public String getDoi() {
        return doi;
    }

    /**
     * @param doi the doi to set
     */
    public void setDoi(String doi) {
        this.doi = doi;
    }

    /**
     * @return the tdocsunat
     */
    public String getTdocsunat() {
        return tdocsunat;
    }

    /**
     * @param tdocsunat the tdocsunat to set
     */
    public void setTdocsunat(String tdocsunat) {
        this.tdocsunat = tdocsunat;
    }
}