
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmposhost.main;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author scabanillas
 */
public class Main {
    
    public Main() {
   
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //run DmPosCentral()
        // set look and feel to the system look and feel
        try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
                ex.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                        //new DmPosCentral();
                        new FormPedidos().setVisible(true);
                }
        });
    }
    
}
