/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmposhost.data;

import com.dmposhost.bean.MensajesVO;

/**
 *
 * @author jcastillop
 */
public class MensajesData {
   static MensajesVO mensajesVO;
    
    public static MensajesVO getMensajesBD(){
        MensajesDAO miMensajesDAO = new MensajesDAO();
        mensajesVO = miMensajesDAO.consultarMensajes();
      return mensajesVO;
    }  
}
