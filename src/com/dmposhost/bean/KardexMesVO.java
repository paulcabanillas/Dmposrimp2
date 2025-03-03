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
public class KardexMesVO {

    private String ciaid;
    private String almacen;
    private String anomes;
    private String codcon;
    private BigDecimal cant_ing;
    private BigDecimal cant_sal;
    private BigDecimal stock_ini;
    private BigDecimal stock_fin;
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
     * @return the cant_ing
     */
    public BigDecimal getCant_ing() {
        return cant_ing;
    }

    /**
     * @param cant_ing the cant_ing to set
     */
    public void setCant_ing(BigDecimal cant_ing) {
        this.cant_ing = cant_ing;
    }

    /**
     * @return the cant_sal
     */
    public BigDecimal getCant_sal() {
        return cant_sal;
    }

    /**
     * @param cant_sal the cant_sal to set
     */
    public void setCant_sal(BigDecimal cant_sal) {
        this.cant_sal = cant_sal;
    }

    /**
     * @return the stock_ini
     */
    public BigDecimal getStock_ini() {
        return stock_ini;
    }

    /**
     * @param stock_ini the stock_ini to set
     */
    public void setStock_ini(BigDecimal stock_ini) {
        this.stock_ini = stock_ini;
    }

    /**
     * @return the stock_fin
     */
    public BigDecimal getStock_fin() {
        return stock_fin;
    }

    /**
     * @param stock_fin the stock_fin to set
     */
    public void setStock_fin(BigDecimal stock_fin) {
        this.stock_fin = stock_fin;
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
