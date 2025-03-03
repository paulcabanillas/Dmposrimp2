/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmposhost.bean;

import com.dmposhost.util.Util;
import java.math.BigDecimal;
import java.util.GregorianCalendar;

/**
 *
 * @author lmonge
 */
public class Sesion {
    private String ciaid = "";
    private String idcompania = "idcompania";
    private String compania = "CRISOL";
    private String direccionCompania = "";
    private String idlocalidad = "idlocalidad";
    private String almacen = "almacen";
    private String tienda = "tienda";
    private String ptoventa = "ptoventa";
    private String listaPrecios = "NOR";
    private String codigoCliente = "33333333";
    private String claseAux = "C";
    private String tipoDocumento = "33";
    private String formaPago = "01";
    private String tipoMoneda = "N";
    private String tipoVenta = "01";
    private String tipoCliente = "02";
    private String unidadMedida = "UND";
    private String fechaProceso = "";
    private GregorianCalendar fechaCalendar = new GregorianCalendar();
    //
    private String serie = "B011";
    private int topeSerie = 0;
    private int numero = 5000;
    private int topeNumero = 0;
    private int impresiones = 1;
    private String turno = "1";
    private BigDecimal igvPorcentaje = new BigDecimal(18);
    private String copyFilePath = "";
    private String impresora = "";
    private String modelo = "";
    private String serial = "";
    private String ipserver = "";
    private double topeTicket = 700.00;
    //jcastillo inicio
    private String rutaFELocal ="";
    private String rucDerrama ="";
    private String nombDerrama ="";
    private String direcDerrama ="";
    private String ubgDerrama ="";
    private String prvDerrama ="";
    private String depDerrama ="";
    private String dstDerrama ="";
    private String pais ="";
    private String printDestino ="";
    private String codImpuesto ="";
    private String mensajes="";
    private String tipDocSunat="";
    private String idlprecios="";
    private String idcampana="";
    
    public Sesion() {
    }

    
    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }
    
    public String getMensajes() {
        return mensajes;
    }

    public void setMensajes(String mensajes) {
        this.mensajes = mensajes;
    }
    
    public String getrutaFELocal() {
        return rutaFELocal;
    }

    public String getRutaFELocal() {
        return rutaFELocal;
    }

    public void setRutaFELocal(String rutaFELocal) {
        this.rutaFELocal = rutaFELocal;
    }

    public String getRucDerrama() {
        return rucDerrama;
    }

    public void setRucDerrama(String rucDerrama) {
        this.rucDerrama = rucDerrama;
    }

    public String getNombDerrama() {
        return nombDerrama;
    }

    public void setNombDerrama(String nombDerrama) {
        this.nombDerrama = nombDerrama;
    }

    public String getDirecDerrama() {
        return direcDerrama;
    }

    public void setDirecDerrama(String direcDerrama) {
        this.direcDerrama = direcDerrama;
    }

    public String getUbgDerrama() {
        return ubgDerrama;
    }

    public void setUbgDerrama(String ubgDerrama) {
        this.ubgDerrama = ubgDerrama;
    }

    public String getPrvDerrama() {
        return prvDerrama;
    }

    public void setPrvDerrama(String prvDerrama) {
        this.prvDerrama = prvDerrama;
    }

    public String getDepDerrama() {
        return depDerrama;
    }

    public void setDepDerrama(String depDerrama) {
        this.depDerrama = depDerrama;
    }

    public String getDstDerrama() {
        return dstDerrama;
    }

    public void setDstDerrama(String dstDerrama) {
        this.dstDerrama = dstDerrama;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPrintDestino() {
        return printDestino;
    }

    public void setPrintDestino(String printDestino) {
        this.printDestino = printDestino;
    }

    public String getCodImpuesto() {
        return codImpuesto;
    }

    public void setCodImpuesto(String codImpuesto) {
        this.codImpuesto = codImpuesto;
    }

    public void setrutaFELocal(String rutaFELocal) {
        this.rutaFELocal = rutaFELocal;
    }
//jcastillo fin
    public String getIdcompania() {
        return idcompania;
    }

    public void setIdcompania(String idcompania) {
        this.idcompania = idcompania;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public String getIdlocalidad() {
        return idlocalidad;
    }

    public void setIdlocalidad(String idlocalidad) {
        this.idlocalidad = idlocalidad;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public String getListaPrecios() {
        return listaPrecios;
    }

    public void setListaPrecios(String listaPrecios) {
        this.listaPrecios = listaPrecios;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getClaseAux() {
        return claseAux;
    }

    public void setClaseAux(String claseAux) {
        this.claseAux = claseAux;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getFechaProceso() {
        return fechaProceso;
    }

    public void setFechaProceso(String fechaProceso) {
        this.fechaProceso = fechaProceso;
    }

    public GregorianCalendar getFechaCalendar() {
        return fechaCalendar;
    }

    public void setFechaCalendar(GregorianCalendar fechaCalendar) {
        this.fechaCalendar = fechaCalendar;
    }

//    public int getSerie() {
//        return serie;
//    }
//
//    public void setSerie(int serie) {
//        this.serie = serie;
//    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public BigDecimal getIgvPorcentaje() {
        return igvPorcentaje;
    }

    public void setIgvPorcentaje(BigDecimal igvPorcentaje) {
        this.igvPorcentaje = igvPorcentaje;
    }

    public int getImpresiones() {
        return impresiones;
    }

    public void setImpresiones(int impresiones) {
        this.impresiones = impresiones;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getCopyFilePath() {
        return copyFilePath;
    }

    public void setCopyFilePath(String copyFilePath) {
        this.copyFilePath = copyFilePath;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    public String getPtoventa() {
        return ptoventa;
    }

    public void setPtoventa(String ptoventa) {
        this.ptoventa = ptoventa;
    }

    public int getTopeSerie() {
        return topeSerie;
    }

    public void setTopeSerie(int topeSerie) {
        this.topeSerie = topeSerie;
    }

    public int getTopeNumero() {
        return topeNumero;
    }

    public void setTopeNumero(int topeNumero) {
        this.topeNumero = topeNumero;
    }

    public String getImpresora() {
        return impresora;
    }

    public void setImpresora(String impresora) {
        this.impresora = impresora;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getIpserver() {
        return ipserver;
    }

    public void setIpserver(String ipserver) {
        this.ipserver = ipserver;
    }

    public String getDireccionCompania() {
        return direccionCompania;
    }

    public void setDireccionCompania(String direccionCompania) {
        this.direccionCompania = direccionCompania;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public double getTopeTicket() {
        return topeTicket;
    }

    public void setTopeTicket(double topeTicket) {
        this.topeTicket = topeTicket;
    }

    /**
     * @return the ciaid
     */
    public String getCiaid() {
        return ciaid;
    }

    /**
     * @param ciaid the ciaid to set
     */
    public void setCiaid(String ciaid) {
        this.ciaid = ciaid;
    }

    /**
     * @return the tipDocSunat
     */
    public String getTipDocSunat() {
        return tipDocSunat;
    }

    /**
     * @param tipDocSunat the tipDocSunat to set
     */
    public void setTipDocSunat(String tipDocSunat) {
        this.tipDocSunat = tipDocSunat;
    }

    /**
     * @return the idlprecios 
     */
    public String getIdlprecios() {
        return idlprecios;
    }

    /**
     * @param idlprecios the idlprecios to set
     */
    public void setIdlprecios(String idlprecios) {
        this.idlprecios = idlprecios;
    }

    /**
     * @return the idcampana
     */
    public String getIdcampana() {
        return idcampana;
    }

    /**
     * @param idcampana the idcampana to set
     */
    public void setIdcampana(String idcampana) {
        this.idcampana = idcampana;
    }
    
}
