/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmposhost.data;

import com.dmposhost.bean.Sesion;

/**
 *
 * @author lmonge
 */
public class SesionData {

    static Sesion sesion;
    
    public static Sesion getSesion(){
        if(sesion==null){
            sesion = new Sesion();
        }
        return sesion;
    }
    
}
