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
public class SaldosAlmVO {

    private String ciaid;
    private String almacen;
    private String codcon;
    private BigDecimal stock_fis;
    private BigDecimal stock_res;
    private BigDecimal stock_act;
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
     * @return the stock_fis
     */
    public BigDecimal getStock_fis() {
        return stock_fis;
    }

    /**
     * @param stock_fis the stock_fis to set
     */
    public void setStock_fis(BigDecimal stock_fis) {
        this.stock_fis = stock_fis;
    }

    /**
     * @return the stock_res
     */
    public BigDecimal getStock_res() {
        return stock_res;
    }

    /**
     * @param stock_res the stock_res to set
     */
    public void setStock_res(BigDecimal stock_res) {
        this.stock_res = stock_res;
    }

    /**
     * @return the stock_act
     */
    public BigDecimal getStock_act() {
        return stock_act;
    }

    /**
     * @param stock_act the stock_act to set
     */
    public void setStock_act(BigDecimal stock_act) {
        this.stock_act = stock_act;
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
