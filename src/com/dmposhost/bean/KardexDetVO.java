/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmposhost.bean;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author scabanillas
 */
public class KardexDetVO {

    private String ciaid;
    private String almacen;
    private String tipo_mov;
    private String id_mov;
    private String item;
    private String fecmov;
    private String anomes;
    private String codcon;
    private BigDecimal cantidad;
    private String usureg;
    private String fecreg;
    private String usumod;
    private String fecmod;

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
     * @return the almacen
     */
    public String getAlmacen() {
        return almacen;
    }

    /**
     * @param almacen the almacen to set
     */
    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    /**
     * @return the tipo_mov
     */
    public String getTipo_mov() {
        return tipo_mov;
    }

    /**
     * @param tipo_mov the tipo_mov to set
     */
    public void setTipo_mov(String tipo_mov) {
        this.tipo_mov = tipo_mov;
    }

    /**
     * @return the id_mov
     */
    public String getId_mov() {
        return id_mov;
    }

    /**
     * @param id_mov the id_mov to set
     */
    public void setId_mov(String id_mov) {
        this.id_mov = id_mov;
    }

    /**
     * @return the item
     */
    public String getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(String item) {
        this.item = item;
    }

    /**
     * @return the fecmov
     */
    public String getFecmov() {
        return fecmov;
    }

    /**
     * @param fecmov the fecmov to set
     */
    public void setFecmov(String fecmov) {
        this.fecmov = fecmov;
    }

    /**
     * @return the anomes
     */
    public String getAnomes() {
        return anomes;
    }

    /**
     * @param anomes the anomes to set
     */
    public void setAnomes(String anomes) {
        this.anomes = anomes;
    }

    /**
     * @return the codcon
     */
    public String getCodcon() {
        return codcon;
    }

    /**
     * @param codcon the codcon to set
     */
    public void setCodcon(String codcon) {
        this.codcon = codcon;
    }

    /**
     * @return the cantidad
     */
    public BigDecimal getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the usureg
     */
    public String getUsureg() {
        return usureg;
    }

    /**
     * @param usureg the usureg to set
     */
    public void setUsureg(String usureg) {
        this.usureg = usureg;
    }

    /**
     * @return the fecreg
     */
    public String getFecreg() {
        return fecreg;
    }

    /**
     * @param fecreg the fecreg to set
     */
    public void setFecreg(String fecreg) {
        this.fecreg = fecreg;
    }

    /**
     * @return the usumod
     */
    public String getUsumod() {
        return usumod;
    }

    /**
     * @param usumod the usumod to set
     */
    public void setUsumod(String usumod) {
        this.usumod = usumod;
    }

    /**
     * @return the fecmod
     */
    public String getFecmod() {
        return fecmod;
    }

    /**
     * @param fecmod the fecmod to set
     */
    public void setFecmod(String fecmod) {
        this.fecmod = fecmod;
    }


}
