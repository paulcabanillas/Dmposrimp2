/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmposhost.bean;

import com.dmposhost.data.SesionData;
import com.dmposhost.util.Util;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author lmonge
 */
public class DetalleTicket {
    private ConceptoCobro conceptoCobro;
    private int cantidad;
    private BigDecimal subtotal = BigDecimal.ZERO;
    private BigDecimal montoIgv = BigDecimal.ZERO;
    private String flag;
    private BigDecimal montoGravado = BigDecimal.ZERO;
    private BigDecimal montoExonerado = BigDecimal.ZERO;
    private BigDecimal montoInafecto = BigDecimal.ZERO;
    // PCC 22/10/2020 : Transferencia Gratuita
    private BigDecimal montoGratuito = BigDecimal.ZERO;
    //
    private String aplimpto;
    private BigDecimal descItem= BigDecimal.ZERO;
    //UBL 2.1
    private String CodPrdSunat;
    //private String tmoneda;
    //
    private String CodGrp;
    private String CodFam;
    private String CodSFam;
    private String FlgAplDes;

    public DetalleTicket(ConceptoCobro conceptoCobro, int cantidad, String tmoneda,BigDecimal tcambio, BigDecimal desc) {
        this.subtotal.setScale(2, RoundingMode.HALF_DOWN);
        this.montoIgv.setScale(2, RoundingMode.HALF_UP);
        this.conceptoCobro = conceptoCobro;
        this.cantidad = cantidad;        
        this.subtotal = conceptoCobro.getPrecioUnitario().multiply(new BigDecimal(cantidad));
        this.descItem = desc.multiply(new BigDecimal(cantidad));
        BigDecimal descuento = this.descItem;
        this.descItem = new BigDecimal(Util.formatDecimal(descuento.doubleValue()));
        if(!conceptoCobro.getTipomon().equals(tmoneda)){
            if(tmoneda.equals("S")){
                //conceptoCobro.setPrecioUnitario(conceptoCobro.getPrecioUnitario().multiply(tcambio));
                this.subtotal = subtotal.multiply(tcambio);                
            }else if(tmoneda.equals("D")){
                //conceptoCobro.setPrecioUnitario(conceptoCobro.getPrecioUnitario().divide(tcambio,2, RoundingMode.HALF_UP));
                this.subtotal = subtotal.divide(tcambio,4, RoundingMode.HALF_UP);                
            }
        }
        if(this.descItem.compareTo(BigDecimal.ZERO)>0){
            this.subtotal = this.subtotal.subtract(this.descItem);
        }
        BigDecimal factor = BigDecimal.ZERO;
        if(conceptoCobro.isAplicaIgv()){
            factor = SesionData.getSesion().getIgvPorcentaje().divide(new BigDecimal(100));
            factor = factor.add(BigDecimal.ONE);
            montoIgv = this.subtotal.divide(factor, 2, RoundingMode.HALF_DOWN);
            montoIgv = this.subtotal.subtract(montoIgv);
        }
        
        if(conceptoCobro.isAplicaIgv() && conceptoCobro.getExonerado().equals("N")){
            if (this.subtotal.compareTo(BigDecimal.ZERO)>0){
                montoGravado= montoGravado.add(this.subtotal);
                aplimpto="G"; // Gravado
            } else {
                montoGratuito= montoGratuito.add(this.descItem);
                aplimpto="R"; // Gratuito 
            }
        }
        if(!conceptoCobro.isAplicaIgv() && conceptoCobro.getExonerado().equals("S")){
            if (this.subtotal.compareTo(BigDecimal.ZERO)>0){
                montoExonerado= montoExonerado.add(this.subtotal);
                aplimpto="E"; // Exonerado
            } else {
                montoGratuito= montoGratuito.add(this.descItem);
                aplimpto="R"; // Gratuito 
            }
         }
        if(!conceptoCobro.isAplicaIgv() && conceptoCobro.getExonerado().equals("N")){
            if (this.subtotal.compareTo(BigDecimal.ZERO)>0){
                montoInafecto= montoInafecto.add(this.subtotal);
                aplimpto="I"; // Inafecto
            } else {
                montoGratuito= montoGratuito.add(this.descItem);
                aplimpto="R"; // Gratuito 
            }
        }        
    }

    public ConceptoCobro getConceptoCobro() {
        return conceptoCobro;
    }

    public void setConceptoCobro(ConceptoCobro conceptoCobro) {
        this.conceptoCobro = conceptoCobro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getMontoIgv() {
        return montoIgv;
    }

    public void setMontoIgv(BigDecimal montoIgv) {
        this.montoIgv = montoIgv;
    }
        
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "DetalleTicket{" + " conceptoCobro=" + conceptoCobro + ", cantidad=" + cantidad + ", subtotal=" + subtotal + '}';
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
     * @return the aplimpto
     */
    public String getAplimpto() {
        return aplimpto;
    }

    /**
     * @param aplimpto the aplimpto to set
     */
    public void setAplimpto(String aplimpto) {
        this.aplimpto = aplimpto;
    }

    /**
     * @return the descItem
     */
    public BigDecimal getDescItem() {
        return descItem;
    }

    /**
     * @param descItem the descItem to set
     */
    public void setDescItem(BigDecimal descItem) {
        this.descItem = descItem;
    }
    
    //UBL2.1
    /**
     * @return the CodPrdSunat
     */
    public String getCodPrdSunat() {
        return CodPrdSunat;
    }

    /**
     * @param CodPrdSunat the CodPrdSunat to set
     */
    public void setCodPrdSunat(String CodPrdSunat) {
        this.CodPrdSunat = CodPrdSunat;
    }
    // Fin UBL2.1

    /**
     * @return the CodGrp
     */
    public String getCodGrp() {
        return CodGrp;
    }

    /**
     * @param CodGrp the CodGrp to set
     */
    public void setCodGrp(String CodGrp) {
        this.CodGrp = CodGrp;
    }

    /**
     * @return the CodFam
     */
    public String getCodFam() {
        return CodFam;
    }

    /**
     * @param CodFam the CodFam to set
     */
    public void setCodFam(String CodFam) {
        this.CodFam = CodFam;
    }

    /**
     * @return the CodSFam
     */
    public String getCodSFam() {
        return CodSFam;
    }

    /**
     * @param CodSFam the CodSFam to set
     */
    public void setCodSFam(String CodSFam) {
        this.CodSFam = CodSFam;
    }

    /**
     * @return the FlgAplDes
     */
    public String getFlgAplDes() {
        return FlgAplDes; 
    }

    /**
     * @param FlgAplDes the FlgAplDes to set
     */
    public void setFlgAplDes(String FlgAplDes) {
        this.FlgAplDes = FlgAplDes;
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
