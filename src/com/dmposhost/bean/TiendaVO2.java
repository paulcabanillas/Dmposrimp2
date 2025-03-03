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
public class TiendaVO2 {
   private String tiendaid;
   private String tiendadsc;
   private String tiendadir;
   private String tiendaubigeo;
   private String tiendaestablec;

    /**
     * @return the tiendaid
     */
    public String getTiendaid() {
        return tiendaid;
    }

    /**
     * @param tiendaid the tiendaid to set
     */
    public void setTiendaid(String tiendaid) {
        this.tiendaid = tiendaid;
    }

    /**
     * @return the tiendadsc
     */
    public String getTiendadsc() {
        return tiendadsc;
    }

    /**
     * @param tiendadsc the tiendadsc to set
     */
    public void setTiendadsc(String tiendadsc) {
        this.tiendadsc = tiendadsc;
    }
    
    // Dirección de Tienda
        public String getTiendadir() {
        return tiendadir;
    }

    /**
     * @param tiendadsc the tiendadsc to set
     */
    public void setTiendadir(String tiendadir) {
        this.tiendadir = tiendadir;
    }

    // Ubigeo de Tienda
        public String getTiendaubigeo() {
        return tiendaubigeo;
    }

    /**
     * @param tiendaubigeo the tiendaubigeo to set
     */
    public void setTiendaubigeo(String tiendaubigeo) {
        this.tiendaubigeo = tiendaubigeo;
    }
   
    // Código de Estlecimiento de Tienda
        public String getTiendaestablec() {
        return tiendaestablec;
    }

    /**
     * @param tiendaestablec the tiendaestablec to set
     */
    public void setTiendaestablec(String tiendaestablec) {
        this.tiendaestablec = tiendaestablec;
    }
        
}
