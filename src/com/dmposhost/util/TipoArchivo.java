/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmposhost.util;

/**
 *
 * @author lmonge
 */
public enum TipoArchivo {
//jcastillo inicio
    DAT(1, "dat"), DM(2, "dm"), DMD(3, "dmd"), XLS(4, "xls"),TXT (5,"txt"),TXTLocal (6,"txt"); 
//jcastillo fin        
    private int tipo;
    private String extension;

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    private TipoArchivo(int tipo, String descripcion) {
        this.tipo = tipo;
        this.extension = descripcion;
    }
    
}
