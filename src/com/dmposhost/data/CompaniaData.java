/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmposhost.data;

import com.dmposhost.bean.CompaniaVO;

/**
 *
 * @author jcastillop
 */
public class CompaniaData {
    static CompaniaVO companiaVO;
    
    public static CompaniaVO getCompaniaBD(String ciaid){
        CompaniaDAO miCompaniaDAO = new CompaniaDAO();
        companiaVO = miCompaniaDAO.consultarCompania(ciaid);
      return companiaVO;
    }
    
    public static CompaniaVO getCompaniaBDP(String ciaid){
        CompaniaDAO miCompaniaDAO = new CompaniaDAO();
        companiaVO = miCompaniaDAO.consultarCia();
      return companiaVO;
    }
}
