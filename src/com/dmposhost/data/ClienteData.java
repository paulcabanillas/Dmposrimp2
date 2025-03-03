/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmposhost.data;

import com.dmposhost.bean.ClienteVO;

/**
 *
 * @author jcastillop
 */
public class ClienteData {
  static ClienteVO clienteVO;
    
    public static ClienteVO getClienteBD(){
        ClienteDAO miClienteDAO = new ClienteDAO();
        clienteVO = miClienteDAO.consultarCliente();
      return clienteVO;
    } 
    public static ClienteVO getClientexNumDoc(String documento){
        ClienteDAO miClienteDAO = new ClienteDAO();
        clienteVO = miClienteDAO.consultarClientexDoc(documento);
      return clienteVO;
    }
        public static ClienteVO getClientexNumDocAll(String documento){
        ClienteDAO miClienteDAO = new ClienteDAO();
        clienteVO = miClienteDAO.consultarClientexDocAll(documento);
      return clienteVO;
    }
   
}
