/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmposhost.data;

import com.dmposhost.bean.FPagomovVO;
//import com.dematicket.bean.MedioPagoVO;
//import com.dematicket.bean.VentasCabeceraVO;
//import com.dematicket.bean.VentasDetalleVO;
//import static com.dematicket.data.VentasDAO.resultado;
import com.dmposhost.util.DbConnection;
import com.dmposhost.util.DbConnectionHost;
import com.dmposhost.util.Util;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author scabanillas
 */
public class MedioPagoDAO {
   static FPagomovVO medio;
   static boolean resultado=true;
   static boolean resultadoHost=true;
      
   
  public static String retornaFormaPago(String xciaid, String xtdoc, String xserie, String xnumero) {
  
    DbConnectionHost conex= new DbConnectionHost();
    
    String xformapago="";

    try {
     PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT  "
             + " CONCAT ((select descripcion from dmticket.dmt_fpago_par where idcompania='2' and fpagoid= t.fpagoid and subfpagoid=t.subfpagoid), ' ', "
             + " tipomoneda ,'/ ', truncate(mtopagori,2), ' Ref: ', ifnull(substr(card_number,-4),'-'),'|') forma_pago "
             + " FROM dmticket.dmt_fpago_mov t "
             + " WHERE t.idcompania=? AND t.tipodocumento=? AND t.serie=? AND t.numero=? AND item=1");
     consulta.setString(1, xciaid);
     consulta.setString(2, xtdoc);
     consulta.setString(3, xserie);
     consulta.setString(4, xnumero);
     ResultSet res = consulta.executeQuery();
     //
     xformapago="-";
     //
     while(res.next()){
         xformapago= res.getString("forma_pago");
     }
     res.close();
     consulta.close();
     conex.desconectar();
    } catch (Exception e) {
     JOptionPane.showMessageDialog(null, "no se pudo obtener Forma de Pago\n"+e);
    }
    return xformapago;
 }
  
    
}
