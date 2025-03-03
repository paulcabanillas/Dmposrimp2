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
public class ConceptoCobro {

    private String tipo;
    private String concepto;
    private BigDecimal precioUnitario = BigDecimal.ZERO;
    private boolean aplicaIgv;
    //private String aplicaIgv;
    private BigDecimal precioUnitarioSinIgv = BigDecimal.ZERO;
    private String ciaid;
    private String estadocon;
    private String tipomon;
    private String unimed;
    private String codbarras;
    private String exonerado;
    //UBL2.1
    private String CodPrdSunat;
    //
    private String CodGrp;
    private String CodFam;
    private String CodSFam;
    private String FlgAplDes;
    

    public ConceptoCobro(String tipo, String concepto, BigDecimal monto, BigDecimal montoSinIgv) {
        this.tipo = tipo;
        this.concepto = concepto;
        this.precioUnitario.setScale(4, RoundingMode.HALF_UP);
        this.precioUnitario = monto;
        aplicaIgv = true;
        //aplicaIgv = "1";
        this.precioUnitarioSinIgv.setScale(4, RoundingMode.HALF_UP);
        this.precioUnitarioSinIgv.setScale(4, RoundingMode.HALF_UP);
        this.precioUnitarioSinIgv = montoSinIgv;
    }

    public ConceptoCobro(String tipo, String concepto, BigDecimal monto, boolean aplicaIgv, BigDecimal montoSinIgv, String tipomon, String exonerado, String unimed, String CodPrdSunat, String CodGrp, String CodFam, String CodSFam, String FlgAplDes) {
        this.tipo = tipo;
        this.concepto = concepto;
        this.precioUnitario = monto;
        this.precioUnitario = this.precioUnitario.setScale(4, RoundingMode.HALF_UP);
        this.aplicaIgv = aplicaIgv;
        this.precioUnitarioSinIgv = montoSinIgv;
        this.precioUnitarioSinIgv = this.precioUnitarioSinIgv.setScale(4, RoundingMode.HALF_UP);
        this.tipomon=tipomon;
        this.exonerado=exonerado;
        this.unimed=unimed;
        //UBL2.1
        this.CodPrdSunat=CodPrdSunat;
        //
        this.CodGrp=CodGrp;
        this.CodFam=CodFam;
        this.CodSFam=CodSFam;
        this.FlgAplDes=FlgAplDes;
    }
    public ConceptoCobro(String tipo, String concepto, BigDecimal monto, boolean aplicaIgv, BigDecimal montoSinIgv
                        ,String ciaid,String estadocon,String tipomon,String unimed,String codbarras, String exonerado,
                         String CodPrdSunat, String CodGrp, String CodFam, String CodSFam, String FlgAplDes) {
        this.tipo = tipo;
        this.concepto = concepto;
        this.precioUnitario = monto;
        this.precioUnitario = this.precioUnitario.setScale(4, RoundingMode.HALF_UP);
        this.aplicaIgv = aplicaIgv;
        this.precioUnitarioSinIgv = montoSinIgv;
        this.precioUnitarioSinIgv = this.precioUnitarioSinIgv.setScale(4, RoundingMode.HALF_UP);
        this.ciaid=ciaid;
        this.estadocon=estadocon;
        this.tipomon=tipomon;
        this.unimed=unimed;
        this.codbarras=codbarras;
        this.exonerado=exonerado;
        //UBL2.1
        this.CodPrdSunat=CodPrdSunat;
        //
        this.CodGrp=CodGrp;
        this.CodFam=CodFam;
        this.CodSFam=CodSFam;
        this.FlgAplDes=FlgAplDes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public boolean isAplicaIgv() {
        return aplicaIgv;
    }

    public void setAplicaIgv(boolean aplicaIgv) {
        this.aplicaIgv = aplicaIgv;
    }

    /**
     * @return the precioUnitarioSinIgv
     */
    public BigDecimal getPrecioUnitarioSinIgv() {
        return precioUnitarioSinIgv;
    }

    /**
     * @param precioUnitarioSinIgv the precioUnitarioSinIgv to set
     */
    public void setPrecioUnitarioSinIgv(BigDecimal precioUnitarioSinIgv) {
        this.precioUnitarioSinIgv = precioUnitarioSinIgv;
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
     * @return the estadocon
     */
    public String getEstadocon() {
        return estadocon;
    }

    /**
     * @param estadocon the estadocon to set
     */
    public void setEstadocon(String estadocon) {
        this.estadocon = estadocon;
    }

    /**
     * @return the tipomon
     */
    public String getTipomon() {
        return tipomon;
    }

    /**
     * @param tipomon the tipomon to set
     */
    public void setTipomon(String tipomon) {
        this.tipomon = tipomon;
    }

    /**
     * @return the unimed
     */
    public String getUnimed() {
        return unimed;
    }

    /**
     * @param unimed the unimed to set
     */
    public void setUnimed(String unimed) {
        this.unimed = unimed;
    }

    /**
     * @return the codbarras
     */
    public String getCodbarras() {
        return codbarras;
    }

    /**
     * @param codbarras the codbarras to set
     */
    public void setCodbarras(String codbarras) {
        this.codbarras = codbarras;
    }

    /**
     * @return the exonerado
     */
    public String getExonerado() {
        return exonerado;
    }

    /**
     * @param exonerado the exonerado to set
     */
    public void setExonerado(String exonerado) {
        this.exonerado = exonerado;
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

    @Override
    public String toString() {
        return "ConceptoCobro{" + "tipo=" + tipo + ", concepto=" + concepto + ", precioUnitario=" + precioUnitario + ", aplicaIgv=" + aplicaIgv + ", precioUnitarioSinIgv=" + precioUnitarioSinIgv + ", ciaid=" + ciaid + ", estadocon=" + estadocon + ", tipomon=" + tipomon + ", unimed=" + unimed + ", codbarras=" + codbarras + ", exonerado=" + exonerado + '}';
    }

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

}
