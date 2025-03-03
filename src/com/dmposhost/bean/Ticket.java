/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmposhost.bean;

import com.dmposhost.data.SesionData;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author lmonge
 */
public class Ticket {
    //jcastillo inicio
    //private int serie;
    private String serie;
    //jcastillo fin
    private int numero;
    private String fecha = "";
    private GregorianCalendar fechaCalendar = new GregorianCalendar();
    private ArrayList<DetalleTicket> detalleTicket = new ArrayList();
    private BigDecimal total = BigDecimal.ZERO;
    private BigDecimal montoIgv = BigDecimal.ZERO;
    private String estado = "ACEPTADO";
    private String moneda = "S/";
    private BigDecimal tipoCambio = BigDecimal.ONE;
    private String tipoCliente = "";
    private String nombreCliente = "";
    private String identificacionCliente = "";
    private String direccionCliente = "";
    private String emailCliente = "";
    private BigDecimal montoGravado = BigDecimal.ZERO;
    private BigDecimal montoExonerado = BigDecimal.ZERO;
    private BigDecimal montoInafecto = BigDecimal.ZERO; 
    private BigDecimal montoDescuento = BigDecimal.ZERO; 
    // PCC 22/10/2020 Transferencia Gratuita
    private BigDecimal montoGratuito = BigDecimal.ZERO; 
    //
    private boolean aplicaIGV;

    
    public boolean isAplicaIGV() {
        return aplicaIGV;
    }

    public void setAplicaIGV(boolean aplicaIGV) {
        this.aplicaIGV = aplicaIGV;
    }
    //jcastillo fin
    public Ticket() {
        this.serie = SesionData.getSesion().getSerie();
        this.numero = SesionData.getSesion().getNumero();
        // PCC
        //this.total.setScale(4, RoundingMode.HALF_UP);
        //this.montoIgv.setScale(4, RoundingMode.HALF_UP);
        //this.montoIgv.setScale(4, RoundingMode.HALF_UP);
        this.total.setScale(2, RoundingMode.HALF_UP);
        this.montoIgv.setScale(2, RoundingMode.HALF_UP);
        this.montoIgv.setScale(2, RoundingMode.HALF_UP);
        //jcastillo inicio
        //this.aplicaIGV = false;
        //jcastillo fin
    }
    
    public ArrayList<DetalleTicket> getDetalleTicket() {
        return detalleTicket;
    }

    public void setDetalleTicket(ArrayList<DetalleTicket> detalleTicket) {
        this.detalleTicket = detalleTicket;
    }
    
    public void addDetalleTicket(DetalleTicket detalleTicket) {
        this.detalleTicket.add(detalleTicket);
        BigDecimal total = new BigDecimal(0);
        BigDecimal igv = new BigDecimal(0);
        //jcastillo inicio
        boolean aplicaIGV=false;
        //jcastillo fin
        for(DetalleTicket temp: this.detalleTicket){
            total = total.add(temp.getSubtotal());
            igv = igv.add(temp.getMontoIgv());
            //jcastillo inicio
            aplicaIGV = temp.getConceptoCobro().isAplicaIgv();
            //jcastillo inicio
        }
        this.total = total;
        this.montoIgv = igv;
        this.aplicaIGV = aplicaIGV;
    }
   
    public void calculateTicket() {
        BigDecimal total = new BigDecimal(0);
        BigDecimal igv = new BigDecimal(0);
        for(DetalleTicket temp: this.detalleTicket){
            System.out.print("subtotal -> "+temp.getSubtotal());
            total = total.add(temp.getSubtotal());
            igv = igv.add(temp.getMontoIgv());
        }
        this.total = total;
        this.montoIgv = igv;
    }
    
    public void removeDetalleTicketByIndex(Integer index) {
        this.detalleTicket.remove(index);
        BigDecimal total = new BigDecimal(0);
        BigDecimal igv = new BigDecimal(0);
        for(DetalleTicket temp: this.detalleTicket){
            total = total.add(temp.getSubtotal());
            igv = igv.add(temp.getMontoIgv());
        }
        this.total = total;
        this.montoIgv = igv;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

//    public int getSerie() {
//        return serie;
//    }
//
//    public void setSerie(int serie) {
//        this.serie = serie;
//    }
    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }
    
//jcastillo fin
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getMontoIgv() {
        return montoIgv;
    }

    public void setMontoIgv(BigDecimal montoIgv) {
        this.montoIgv = montoIgv;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public BigDecimal getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(BigDecimal tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }
    //PCC 30.10.2018 Email Cliente
    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }
    
    
    public GregorianCalendar getFechaCalendar() {
        return fechaCalendar;
    }

    public void setFechaCalendar(GregorianCalendar fechaCalendar) {
        this.fechaCalendar = fechaCalendar;
    }

    public String getIdentificacionCliente() {
        return identificacionCliente;
    }

    public void setIdentificacionCliente(String identificacionCliente) {
        this.identificacionCliente = identificacionCliente;
    }

    @Override
    public String toString() {
        return "Ticket{" + "serie=" + serie + ", numero=" + numero + ", detalleTicket=" + detalleTicket + ", total=" + total + '}';
    }

    /**
     * @return the montoGravado
     */
    public BigDecimal getMontoGravado() {
        return montoGravado;
    }

    /**
     * @param montoGravado the montoGravado to set
     */
    public void setMontoGravado(BigDecimal montoGravado) {
        this.montoGravado = montoGravado;
    }

    /**
     * @return the montoExonerado
     */
    public BigDecimal getMontoExonerado() {
        return montoExonerado;
    }

    /**
     * @param montoExonerado the montoExonerado to set
     */
    public void setMontoExonerado(BigDecimal montoExonerado) {
        this.montoExonerado = montoExonerado;
    }

    /**
     * @return the montoInafecto
     */
    public BigDecimal getMontoInafecto() {
        return montoInafecto;
    }

    /**
     * @param montoInafecto the montoInafecto to set
     */
    public void setMontoInafecto(BigDecimal montoInafecto) {
        this.montoInafecto = montoInafecto;
    }
    
    /**
     * @return the montoDescuento
     */
    public BigDecimal getMontoDescuento() {
        return montoDescuento; 
    }
    
    
     /**
     * @param montoDescuento the montoDescuento to set
     */
    public void setMontoDescuento(BigDecimal montoDescuento) {
        this.montoDescuento = montoDescuento;
    }

    /**
     * @return the montoGratuito
     */
    public BigDecimal getMontoGratuito() {
        return montoGratuito;
    }

    /**
     * @param montoGratuito the montoGratuito to set
     */
    public void setMontoGratuito(BigDecimal montoGratuito) {
        this.montoGratuito = montoGratuito;
    }
    
}
