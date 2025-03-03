/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmposhost.data;

import com.dmposhost.bean.ConceptoCobro;
import com.dmposhost.util.TipoArchivo;
import com.dmposhost.util.Util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author scabanillas
 */
public class ConceptoCobroList {

    static ArrayList<ConceptoCobro> conceptos = new ArrayList<ConceptoCobro>();
    static ArrayList<ConceptoCobro> conceptosFiltrados = new ArrayList<ConceptoCobro>();
    
    public static ArrayList<ConceptoCobro> getConceptos(){
        if(conceptos.isEmpty()){
            try{
                /*BufferedReader br = new BufferedReader(new FileReader(
                                        Util.validaArchivoTicket(TipoArchivo.DAT.getTipo(), "concepto")));
                String line = br.readLine();
                while (line != null) {
                    if(line!=null && line.trim().compareTo("")!=0){
                        String[] linea = line.split("\\"+Util.FILE_DELIMITADOR);
                        conceptos.add(new ConceptoCobro(linea[0],linea[1],new BigDecimal(linea[2]),new Boolean(linea[3])));
                        conceptosFiltrados.add(new ConceptoCobro(linea[0],linea[1],new BigDecimal(linea[2]),new Boolean(linea[3])));
                    }
                    line = br.readLine();
                }*/
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return conceptos;
    }
    
    public static ConceptoCobro getBeanByIndex(int index){
        //return conceptos.get(index);
        return conceptosFiltrados.get(index);
    }
    
    public static void resetListConceptos(){
        conceptosFiltrados.clear();
        for(ConceptoCobro temp: conceptos){
            conceptosFiltrados.add(temp);
        }
    }
    
    public static void updateConceptos(ArrayList<ConceptoCobro> conceptosFiltradosParam){
        conceptosFiltrados.clear();
        for(ConceptoCobro temp: conceptosFiltradosParam){
            conceptosFiltrados.add(temp);
        }
    }
    
}
