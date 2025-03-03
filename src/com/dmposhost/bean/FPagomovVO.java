/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmposhost.bean;

import java.math.BigDecimal;

/**
 *
 * @author scabanillas
 */
public class FPagomovVO {
    private String IDCOMPANIA;
    private String TIPODOCUMENTO;
    private String SERIE;
    private String NUMERO;
    private String ITEM;
    private String FPAGOID;
    private String SUBFPAGOID;
    private String FPAGOID_SUNAT;
    private String TIPODOC_REF;
    private String SERIE_REF;
    private String NUMERO_REF;
    private String TIPOMONEDA;
    private BigDecimal MTOPAGORI;
    private BigDecimal MTOPAGLOC;
    private BigDecimal MTOPAGEXT;
    private BigDecimal MTOPEXORI;
    private BigDecimal MTOPEXLOC;
    private BigDecimal MTOPEXEXT;
    private BigDecimal MTOVTOORI;
    private BigDecimal MTOVTOLOC;
    private BigDecimal MTOVTOEXT;
    private String USUREG;
    private String FECREG;
    private String procesado;

    /**
     * @return the IDCOMPANIA
     */
    public String getIDCOMPANIA() {
        return IDCOMPANIA;
    }

    /**
     * @param IDCOMPANIA the IDCOMPANIA to set
     */
    public void setIDCOMPANIA(String IDCOMPANIA) {
        this.IDCOMPANIA = IDCOMPANIA;
    }

    /**
     * @return the TIPODOCUMENTO
     */
    public String getTIPODOCUMENTO() {
        return TIPODOCUMENTO;
    }

    /**
     * @param TIPODOCUMENTO the TIPODOCUMENTO to set
     */
    public void setTIPODOCUMENTO(String TIPODOCUMENTO) {
        this.TIPODOCUMENTO = TIPODOCUMENTO;
    }

    /**
     * @return the SERIE
     */
    public String getSERIE() {
        return SERIE;
    }

    /**
     * @param SERIE the SERIE to set
     */
    public void setSERIE(String SERIE) {
        this.SERIE = SERIE;
    }

    /**
     * @return the NUMERO
     */
    public String getNUMERO() {
        return NUMERO;
    }

    /**
     * @param NUMERO the NUMERO to set
     */
    public void setNUMERO(String NUMERO) {
        this.NUMERO = NUMERO;
    }

    /**
     * @return the ITEM
     */
    public String getITEM() {
        return ITEM;
    }

    /**
     * @param ITEM the ITEM to set
     */
    public void setITEM(String ITEM) {
        this.ITEM = ITEM;
    }

    /**
     * @return the FPAGOID
     */
    public String getFPAGOID() {
        return FPAGOID;
    }

    /**
     * @param FPAGOID the FPAGOID to set
     */
    public void setFPAGOID(String FPAGOID) {
        this.FPAGOID = FPAGOID;
    }

    /**
     * @return the SUBFPAGOID
     */
    public String getSUBFPAGOID() {
        return SUBFPAGOID;
    }

    /**
     * @param SUBFPAGOID the SUBFPAGOID to set
     */
    public void setSUBFPAGOID(String SUBFPAGOID) {
        this.SUBFPAGOID = SUBFPAGOID;
    }

    /**
     * @return the FPAGOID_SUNAT
     */
    public String getFPAGOID_SUNAT() {
        return FPAGOID_SUNAT;
    }

    /**
     * @param FPAGOID_SUNAT the FPAGOID_SUNAT to set
     */
    public void setFPAGOID_SUNAT(String FPAGOID_SUNAT) {
        this.FPAGOID_SUNAT = FPAGOID_SUNAT;
    }

    /**
     * @return the TIPODOC_REF
     */
    public String getTIPODOC_REF() {
        return TIPODOC_REF;
    }

    /**
     * @param TIPODOC_REF the TIPODOC_REF to set
     */
    public void setTIPODOC_REF(String TIPODOC_REF) {
        this.TIPODOC_REF = TIPODOC_REF;
    }

    /**
     * @return the SERIE_REF
     */
    public String getSERIE_REF() {
        return SERIE_REF;
    }

    /**
     * @param SERIE_REF the SERIE_REF to set
     */
    public void setSERIE_REF(String SERIE_REF) {
        this.SERIE_REF = SERIE_REF;
    }

    /**
     * @return the NUMERO_REF
     */
    public String getNUMERO_REF() {
        return NUMERO_REF;
    }

    /**
     * @param NUMERO_REF the NUMERO_REF to set
     */
    public void setNUMERO_REF(String NUMERO_REF) {
        this.NUMERO_REF = NUMERO_REF;
    }

    /**
     * @return the TIPOMONEDA
     */
    public String getTIPOMONEDA() {
        return TIPOMONEDA;
    }

    /**
     * @param TIPOMONEDA the TIPOMONEDA to set
     */
    public void setTIPOMONEDA(String TIPOMONEDA) {
        this.TIPOMONEDA = TIPOMONEDA;
    }

    /**
     * @return the MTOPAGORI
     */
    public BigDecimal getMTOPAGORI() {
        return MTOPAGORI;
    }

    /**
     * @param MTOPAGORI the MTOPAGORI to set
     */
    public void setMTOPAGORI(BigDecimal MTOPAGORI) {
        this.MTOPAGORI = MTOPAGORI;
    }

    /**
     * @return the MTOPAGLOC
     */
    public BigDecimal getMTOPAGLOC() {
        return MTOPAGLOC;
    }

    /**
     * @param MTOPAGLOC the MTOPAGLOC to set
     */
    public void setMTOPAGLOC(BigDecimal MTOPAGLOC) {
        this.MTOPAGLOC = MTOPAGLOC;
    }

    /**
     * @return the MTOPAGEXT
     */
    public BigDecimal getMTOPAGEXT() {
        return MTOPAGEXT;
    }

    /**
     * @param MTOPAGEXT the MTOPAGEXT to set
     */
    public void setMTOPAGEXT(BigDecimal MTOPAGEXT) {
        this.MTOPAGEXT = MTOPAGEXT;
    }

    /**
     * @return the MTOPEXORI
     */
    public BigDecimal getMTOPEXORI() {
        return MTOPEXORI;
    }

    /**
     * @param MTOPEXORI the MTOPEXORI to set
     */
    public void setMTOPEXORI(BigDecimal MTOPEXORI) {
        this.MTOPEXORI = MTOPEXORI;
    }

    /**
     * @return the MTOPEXLOC
     */
    public BigDecimal getMTOPEXLOC() {
        return MTOPEXLOC;
    }

    /**
     * @param MTOPEXLOC the MTOPEXLOC to set
     */
    public void setMTOPEXLOC(BigDecimal MTOPEXLOC) {
        this.MTOPEXLOC = MTOPEXLOC;
    }

    /**
     * @return the MTOPEXEXT
     */
    public BigDecimal getMTOPEXEXT() {
        return MTOPEXEXT;
    }

    /**
     * @param MTOPEXEXT the MTOPEXEXT to set
     */
    public void setMTOPEXEXT(BigDecimal MTOPEXEXT) {
        this.MTOPEXEXT = MTOPEXEXT;
    }

    /**
     * @return the MTOVTOORI
     */
    public BigDecimal getMTOVTOORI() {
        return MTOVTOORI;
    }

    /**
     * @param MTOVTOORI the MTOVTOORI to set
     */
    public void setMTOVTOORI(BigDecimal MTOVTOORI) {
        this.MTOVTOORI = MTOVTOORI;
    }

    /**
     * @return the MTOVTOLOC
     */
    public BigDecimal getMTOVTOLOC() {
        return MTOVTOLOC;
    }

    /**
     * @param MTOVTOLOC the MTOVTOLOC to set
     */
    public void setMTOVTOLOC(BigDecimal MTOVTOLOC) {
        this.MTOVTOLOC = MTOVTOLOC;
    }

    /**
     * @return the MTOVTOEXT
     */
    public BigDecimal getMTOVTOEXT() {
        return MTOVTOEXT;
    }

    /**
     * @param MTOVTOEXT the MTOVTOEXT to set
     */
    public void setMTOVTOEXT(BigDecimal MTOVTOEXT) {
        this.MTOVTOEXT = MTOVTOEXT;
    }

    /**
     * @return the USUREG
     */
    public String getUSUREG() {
        return USUREG;
    }

    /**
     * @param USUREG the USUREG to set
     */
    public void setUSUREG(String USUREG) {
        this.USUREG = USUREG;
    }

    /**
     * @return the FECREG
     */
    public String getFECREG() {
        return FECREG;
    }

    /**
     * @param FECREG the FECREG to set
     */
    public void setFECREG(String FECREG) {
        this.FECREG = FECREG;
    }

    /**
     * @return the procesado
     */
    public String getProcesado() {
        return procesado;
    }

    /**
     * @param procesado the procesado to set
     */
    public void setProcesado(String procesado) {
        this.procesado = procesado;
    }
   
}


