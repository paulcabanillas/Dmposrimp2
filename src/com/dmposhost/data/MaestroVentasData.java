/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmposhost.data;

import com.dmposhost.bean.MaestroVentasVO;

/**
 *
 * @author jcastillop
 */
public class MaestroVentasData {
    static MaestroVentasVO maestroVentasVO;
    
    public static MaestroVentasVO getMaeVentasBD(String IDCOMPANIA, String ID_TDA,String ptoVenta){
        MaestroVentasDAO miMaestroVentasDAO = new MaestroVentasDAO();
        maestroVentasVO = miMaestroVentasDAO.consultarMaeVentas(IDCOMPANIA, ID_TDA,ptoVenta);
      return maestroVentasVO;
    }
    
     public static String obtenerTurno(boolean cambiarTurno, String IDCOMPANIA, String ID_TDA, String PVTA_ID){
         MaestroVentasDAO miMaestroVentasDAO = new MaestroVentasDAO();
        String turno = miMaestroVentasDAO.obtenerTurno(cambiarTurno, IDCOMPANIA, ID_TDA, PVTA_ID);
      return turno;
    }
}