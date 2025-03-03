package com.dmposhost.main;

import com.dmposhost.bean.ClienteVO;
import com.dmposhost.bean.CompaniaVO;
import com.dmposhost.bean.ConceptoCobro;
import com.dmposhost.bean.MaestroVentasVO;
import com.dmposhost.bean.MensajesVO;
import com.dmposhost.bean.UsuarioVO;
//import com.sun.glass.events.KeyEvent;
import com.dmposhost.data.VentasDAO;
import com.dmposhost.bean.VentasCabeceraVO;
import com.dmposhost.bean.VentasDetalleVO;
import com.dmposhost.data.ClienteData;
import com.dmposhost.data.CompaniaData;
import com.dmposhost.data.ConceptosDAO;
import com.dmposhost.data.DepartamentoDAO;
import com.dmposhost.data.DistritoDAO;
import com.dmposhost.data.MaestroVentasData;
import com.dmposhost.data.MedioPagoDAO;
import com.dmposhost.data.MensajesData;
import com.dmposhost.data.ProvinciaDAO;
import com.dmposhost.data.TiendaDAO;
import com.dmposhost.data.UsuarioData;
import com.dmposhost.util.NumberToLetterConverter;
import com.dmposhost.util.TipoArchivo;
import com.dmposhost.util.Util;
import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;


/**
 *
 * @author scabanillas
 */
public class FormPedidos extends javax.swing.JFrame {

    /**
     * Creates new form FormPedidos
     */
    String  v_usuario = "";
    
    public FormPedidos() {
        initComponents();
        loadComponentes();
        VentasDAO ventasDAO = new VentasDAO();
        listarpedidos();
        setearColumnasTabla();

    }
    
    private void loadComponentes() {
        //String path = new File("").getAbsolutePath();
        //path = path + "\\img\\";
        //ImageIcon icon = new ImageIcon(path + "logoCrisol.png");
        //this.setIconImage(new ImageIcon(path + "logowindowCrisol.png").getImage());
        //this.setTitle("DmPos - Versión 3.0.2023.02");
        
        String path = new File ("").getAbsolutePath();
        path = path+"\\img\\";
        this.setTitle("Visor de Pedidos Facturados Ecommerce");
        this.setIconImage(new ImageIcon(path+"IconoCrisol.png").getImage());     
        //this.setSize(412, 850);
        limpiar();
    }
    
    private void DmPosCentral(){
        try {
            UsuarioVO usuarioVO;
            usuarioVO =UsuarioData.getUsuarioBD("DMPOSHOST", "123"); 
            v_usuario = usuarioVO.getUsuario();
            
            if (actualizaEComp() == "ok" ){
                // Ejecuta FE();
                }
        
        } catch (Exception ex) {
            //resultado = "";
            ex.printStackTrace();
        }
    }
    //
    private String actualizaEComp() throws IOException {
        String resultado = "ok";
        String numComp ="";
        ArrayList<VentasCabeceraVO> cabeceraList = new ArrayList();
        String vciaid="2";
        String vtipodoc = txtTipoDoc.getText().trim();
        String vserie   = txtSerie.getText().trim();
        String vnumero  = txtNroComprob.getText().trim();
        //
        //ArrayList<FPagomovVO> pagosmovList = new ArrayList();
        try {
            VentasDAO ventasDAO = new VentasDAO();
            cabeceraList = ventasDAO.ventascabPedidoList(vciaid, vtipodoc, vserie, vnumero); 
            if (cabeceraList.size() > 0) {
                for (VentasCabeceraVO item : cabeceraList) { 
                    
                    // Obtiene Ultimo Numero CP
                    //numComp = ventasDAO.obtieneUltimoNroComp(item);
                    //
                    File fileFactElecLocal = Util.validaArchivoTicket(TipoArchivo.TXTLocal.getTipo(),item.getTIPODOCUMENTO(),
                                                item.getSERIE(),item.getNUMERO());                    
                    // Actualiza Estado/Numero de Comprobante 
                    //ventasDAO.actualizaVentasWeb(numComp, item);
                    // Actualiza Numero de Comprobante en Maestro de Series
                    //ventasDAO.actualizaUltimoNroComp(numComp, item);
                    // Actualiza Kardex
                    //
                    // PCC 11.04.2023 : Se comenta Control de Stock
                    //
                    //writeKardex(numComp, item);
                    resultado = "ok";
                    // Invoca FE
                    //writeFactElec(fileFactElecLocal, numComp, item);
                    writeFactElec(fileFactElecLocal, item.getNUMERO(), item);
                    //System.out.println("Conexión a base de datos "+bd+" " +url+ " OK\n");
                }
            }
            
        
        } catch (Exception ex) {
            resultado = "";
            ex.printStackTrace();
        }
        //
        // Actualiza Kardex
        //
        return resultado;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPedido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        txtFechaPed = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTipoDoc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNroComprob = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        btnImprimir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPedidos = //Pcc inicio
        new javax.swing.JTable(){

            public boolean isCellEditable(int rowIndex, int colIndex) {

                return false;

            }
        };
        jPanel3 = new javax.swing.JPanel();
        jcbCriterio = new javax.swing.JComboBox();
        txtBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ECOMMERCE CRISOL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(251, 248, 248));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 102, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(51, 102, 255));

        jLabel2.setText("Nro.Pedido");

        jLabel3.setText("Fecha");

        txtPedido.setEditable(false);
        txtPedido.setEnabled(false);

        jLabel4.setText("Cliente");

        txtCliente.setEditable(false);
        txtCliente.setEnabled(false);

        txtFechaPed.setEditable(false);
        txtFechaPed.setEnabled(false);

        jLabel5.setText("Tipo Doc");

        txtTipoDoc.setEditable(false);
        txtTipoDoc.setEnabled(false);

        jLabel6.setText("Serie");

        txtSerie.setEditable(false);
        txtSerie.setEnabled(false);

        jLabel7.setText("Número");

        txtNroComprob.setEditable(false);
        txtNroComprob.setEnabled(false);

        jLabel8.setText("Almacen Recojo");

        txtEstado.setEditable(false);
        txtEstado.setRequestFocusEnabled(false);

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPedido)
                    .addComponent(txtFechaPed, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNroComprob, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(btnImprimir)
                .addGap(81, 81, 81))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtFechaPed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtNroComprob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addComponent(btnImprimir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPedidosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPedidos);

        jPanel3.setBackground(new java.awt.Color(51, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Filtrar :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jcbCriterio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jcbCriterio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nro.Pedido", "Cliente", "Alm.Recojo" }));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jcbCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtBuscar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jcbCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        VentasDAO ventasDAO = new VentasDAO();
        char tecla = evt.getKeyChar();
        
        //if (tecla == KeyEvent.VK_ENTER){
        if (tecla == '\n'){
            limpiar();
            tblPedidos  .setModel(ventasDAO.ventascabPedidoEcommList(jcbCriterio.getSelectedIndex(), txtBuscar.getText()));
            setearColumnasTabla();
        }
        
    }
        
    private void listarpedidos(){
        VentasDAO ventasDAO = new VentasDAO();
        tblPedidos.setModel(ventasDAO.ventascabPedidoEcommList(jcbCriterio.getSelectedIndex(), txtBuscar.getText()));
      
            
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tblPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPedidosMouseClicked
        // TODO add your handling code here:
        
        int fila = tblPedidos.getSelectedRow();
        txtPedido.setText(tblPedidos.getValueAt(fila, 0).toString());
        txtCliente.setText(tblPedidos.getValueAt(fila, 1).toString());
        txtFechaPed.setText(tblPedidos.getValueAt(fila, 2).toString());
        txtTipoDoc.setText(tblPedidos.getValueAt(fila, 3).toString());
        txtSerie.setText(tblPedidos.getValueAt(fila, 4).toString());
        txtNroComprob.setText(tblPedidos.getValueAt(fila, 5).toString());
        txtEstado.setText(tblPedidos.getValueAt(fila, 7).toString()); 
        btnImprimir.setEnabled(true);
        
        
    }//GEN-LAST:event_tblPedidosMouseClicked

    private void setearColumnasTabla(){
        //
        tblPedidos.getTableHeader().setForeground(Color.blue.brighter());//.setBackground(Color.cyan);
        tblPedidos.getTableHeader().setBackground(Color.lightGray);
        //
        DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer(); 
        Alinear.setHorizontalAlignment(SwingConstants.RIGHT);//.LEFT .RIGHT .CENTER
        //
        DefaultTableCellRenderer Centrar = new DefaultTableCellRenderer(); 
        Centrar.setHorizontalAlignment(SwingConstants.CENTER);//.LEFT .RIGHT .CENTER
        //
        TableColumn columna;
        //Columna 0 : Numero de Pedido
        columna=tblPedidos.getColumnModel().getColumn(0);
        columna.setPreferredWidth(70);
        columna.setMaxWidth(80);
        columna.setMinWidth(80);
        //Columna 1 : Cliente
        columna=tblPedidos.getColumnModel().getColumn(1);
        columna.setPreferredWidth(280);
        columna.setMaxWidth(280);
        columna.setMinWidth(280);
        //Columna 2 : Fecha
        columna=tblPedidos.getColumnModel().getColumn(2);
        columna.setPreferredWidth(80);
        columna.setMaxWidth(80);
        columna.setMinWidth(80);
        //Columna 3 : Tipo Documento
        columna=tblPedidos.getColumnModel().getColumn(3);
        columna.setPreferredWidth(40);
        columna.setMaxWidth(40);
        columna.setMinWidth(40);
        columna.setCellRenderer(Centrar);
        //Columna 4 : Serie
        columna=tblPedidos.getColumnModel().getColumn(4);
        columna.setPreferredWidth(50);
        columna.setMaxWidth(50);
        columna.setMinWidth(50);
        columna.setCellRenderer(Centrar);
        //Columna 5 : Numero
        columna=tblPedidos.getColumnModel().getColumn(5);
        columna.setPreferredWidth(80);
        columna.setMaxWidth(80);
        columna.setMinWidth(80);
        //columna.setCellRenderer(Centrar);
        //Columna 6 : Total
        columna=tblPedidos.getColumnModel().getColumn(6);
        columna.setPreferredWidth(100);
        columna.setMaxWidth(100);
        columna.setMinWidth(100);
        columna.setCellRenderer(Alinear);
        //Columna 7 : Almacen
        columna=tblPedidos.getColumnModel().getColumn(7);
        columna.setPreferredWidth(80);
        columna.setMaxWidth(80);
        columna.setMinWidth(80);
        columna.setCellRenderer(Centrar);
        //Columna 8 : Estado
        columna=tblPedidos.getColumnModel().getColumn(8);
        columna.setPreferredWidth(80);
        columna.setMaxWidth(80);
        columna.setMinWidth(80);
         
     // tblPedidos.setRowHeight(25);
    }  
    
    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
        DmPosCentral();
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void limpiar() {
        txtPedido.setText("");
        txtCliente.setText("");
        txtFechaPed.setText("");
        txtTipoDoc.setText("");
        txtSerie.setText("");
        txtNroComprob.setText("");
        txtEstado.setText("");
        btnImprimir.setEnabled(false);
    }
    private void writeFactElec(File file, String numComp,VentasCabeceraVO ventasCabeceraVO) throws IOException {
        FileWriter escribir = null;
        String mensajes[] = null;
        String indExe = "";
        String codImpuesto = "";
        String codImpuestoIni = "";
        String ArchivoOrigen = "";
        String ArchivoDestino ="";
        String v_tipo_documento_sunat ="1";
        String  txtubigeo = "";
        String v_ruta_FE_Local ="";
        VentasDAO ventasDAO = new VentasDAO();
        ArrayList<VentasDetalleVO> detalleList = new ArrayList();
        try {
            escribir = new FileWriter(file, true);
            //
            ClienteVO clienteVO = ClienteData.getClientexNumDoc(ventasCabeceraVO.getCODIGOCLIENTE());
            v_tipo_documento_sunat = clienteVO.getDocsunat();
            //
            int i = 1;
            if (!(ventasCabeceraVO.getIDCOMPANIA().equals("2"))) {
               escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "CODI_EMPR" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + "1" + "\n");
            }else{
               //escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "CODI_EMPR" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + SesionData.getSesion().getCiaid() + "\n");
               escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "CODI_EMPR" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + "2" + "\n");
            }   
            // Solo para Pruebas con CIA Crisol
            //escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "CODI_EMPR" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + "1" + "\n");
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "TipoDTE" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + ventasCabeceraVO.getTIPODOCUMENTO() + "\n");
            //
            //escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"Serie"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+(SesionData.getSesion().getTipoDocumento().equals("01")?"F":"B")+Util.completarIzquierda(3, ""+ticket.getSerie(), "0")+"\n");
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "Serie" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + ventasCabeceraVO.getSERIE() + "\n");
            //
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "Correlativo" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + Util.completarIzquierda(8, "" + numComp, "0") + "\n");
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "FchEmis" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + ventasCabeceraVO.getFECHAPROCESO().substring(0, 10).replaceAll("/", "-") + "\n");
            //UBL2.1
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "HoraEmision" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + Util.obtieneHora() + "\n");
            //
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "TipoMoneda" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + (ventasCabeceraVO.getTIPOMONEDA().equals("S") ? "PEN" : "USD") + "\n");
            //datos emisor
            //
            CompaniaVO companiaVO;
            companiaVO = CompaniaData.getCompaniaBD(ventasCabeceraVO.getIDCOMPANIA());
            //
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "RUTEmis" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + companiaVO.getRUCDERRAMA() + "\n");
            //escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "RUTEmis" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + "20136424867" + "\n");
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "TipoRUCEmis" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + 6 + "\n");
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "NomComer" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + companiaVO.getNOMBDERRAMA() + "\n");
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "RznSocEmis" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + companiaVO.getNOMBDERRAMA() + "\n");
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "ComuEmis" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + companiaVO.getUBGDERRAMA() + "\n");
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "DirEmis" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + companiaVO.getDIRECDERRAMA() + "\n");
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "UrbanizaEmis" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + "" + "\n");
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "ProviEmis" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + companiaVO.getPRVDERRAMA() + "\n");
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "DeparEmis" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + companiaVO.getDEPDERRAMA() + "\n");
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "DistriEmis" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + companiaVO.getDSTDERRAMA() + "\n");
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "PaisEmis" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + companiaVO.getPAIS() + "\n");
            //Campo para UBL2.1
            String TdaEstablec  = TiendaDAO.consultarTiendaxID(ventasCabeceraVO.getIDCOMPANIA(), ventasCabeceraVO.getALMACEN()).getTiendaestablec();
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "CodigoLocalAnexo" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + TdaEstablec + "\n");
            //
            //datos receptor
            if (ventasCabeceraVO.getFACTDES().equalsIgnoreCase("otros")) {
                //escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "TipoRutReceptor" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + BigDecimal.ZERO + "\n");
                escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "TipoRutReceptor" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + BigDecimal.ONE + "\n");
                escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "RUTRecep" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + Util.completarIzquierda(8, "", "0") + "\n");
            } else {
                //escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "TipoRutReceptor" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + 1 + "\n");
                //v_tipo_documento_sunat
                //escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "TipoRutReceptor" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + (SesionData.getSesion().getTipDocSunat().trim().compareTo("") == 0 ? "-" : SesionData.getSesion().getTipDocSunat()) + "\n");
                // Se envia Tipo de documento Sunat Validado
                //ClienteVO clienteVO = ClienteData.getClientexNumDoc(ventasCabeceraVO.getCODIGOCLIENTE());
                v_tipo_documento_sunat = clienteVO.getDocsunat();
                escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "TipoRutReceptor" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL +  v_tipo_documento_sunat + "\n");
                escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "RUTRecep" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + ventasCabeceraVO.getCLIERUC() + "\n");
            }

            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "RznSocRecep" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + ventasCabeceraVO.getFACTDES() + "\n");
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "DirRecepUbigeo" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + "" + "\n");
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "DirRecep" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + (ventasCabeceraVO.getCLIEDIR().trim().compareTo("") == 0 ? "-" : ventasCabeceraVO.getCLIEDIR()) + "\n");
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "DirRecepUrbaniza" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + "" + "\n");
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "DirRecepProvincia" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + "" + "\n");
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "DirRecepDepartamento" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + "" + "\n");
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "DirRecepDistrito" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + "" + "\n");
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "DirRecepCodPais" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + "PE" + "\n");

            //BigDecimal montoExe = BigDecimal.ZERO;
            BigDecimal montoGra = BigDecimal.ZERO;
            BigDecimal montoExo = BigDecimal.ZERO;
            BigDecimal dsctoExo = BigDecimal.ZERO;
            BigDecimal montoIna = BigDecimal.ZERO;
            BigDecimal montoDescglo = BigDecimal.ZERO;
            BigDecimal igvGravGrat = BigDecimal.ZERO;
            BigDecimal QtyItem = BigDecimal.ZERO;
            BigDecimal DescuentoMonto = BigDecimal.ZERO;
            //
            MaestroVentasVO maestroVentasVO;
            maestroVentasVO =MaestroVentasData.getMaeVentasBD(ventasCabeceraVO.getIDCOMPANIA(),
                        ventasCabeceraVO.getALMACEN(), ventasCabeceraVO.getPVTAID());
            //
            BigDecimal montoGrat = BigDecimal.ZERO;
            BigDecimal divisorIGV = BigDecimal.ONE.add(new BigDecimal(maestroVentasVO.getIGVPORCENTAJE()).divide(new BigDecimal(100)));
            v_ruta_FE_Local = maestroVentasVO.getRUTAFE();
            //
            //BigDecimal montoIGV = BigDecimal.ZERO;
            //
            detalleList = ventasDAO.detalleVentasList(numComp, ventasCabeceraVO);
            for (VentasDetalleVO temp : detalleList) {
            //for (DetalleTicket temp : ticket.getDetalleTicket()) {
                //if ((temp.getMontoIgv().compareTo(BigDecimal.ZERO)) == 0) {
                //    montoExo = montoExo.add(temp.getSubtotal());}
                // Acumula Descuento Global
                montoDescglo = montoDescglo.add(temp.getDFACDCTOMO());
                ConceptoCobro temp1 = ConceptosDAO.getConceptoxCodigoConHost(ventasCabeceraVO.getIDCOMPANIA(),temp.getCODCON().trim());
                // PCC 13.10.2020 Transferencia Gratuita
                // Si descuento es igual al monto del item Acumula monto de operacion gratuita
                if (temp.getDFACMTOMO().compareTo(BigDecimal.ZERO) == 0){
                    //montoGrat = montoGrat.add(temp.getSubtotal());
                    //ConceptoCobro temp1 = ConceptosDAO.getConceptoxCodigoCon(temp.getCODCON().trim());
                    if (temp1.isAplicaIgv()&& temp1.getExonerado().equals("N")) {
                        // PCC 12.10.2021 Se retira IGV a Totales Gratuitos Gravados
                        igvGravGrat = temp.getDFACDCTOMO().subtract(temp.getDFACDCTOMO().divide(divisorIGV, 2, RoundingMode.HALF_UP));
                        montoGrat = montoGrat.add(temp.getDFACDCTOMO().subtract(igvGravGrat));
                        montoDescglo = montoDescglo.subtract(igvGravGrat);
                    } else {
                        montoGrat = montoGrat.add(temp.getDFACDCTOMO());
                    }
                }
                
                // Acumula Montos Globales 
                if (temp1.isAplicaIgv()
                && temp1.getExonerado().equals("N")) {
                   //montoGra = montoGra.add(temp.getSubtotal());
                   //montoGra = montoGra.add(((temp.getDFACMTOMO()).subtract(temp.getDFACIMPMTO1())).setScale(2, RoundingMode.UP)); }
                   montoGra = montoGra.add(((temp.getDFACVTOTMO()).subtract(temp.getDFACIMPMTO1())).setScale(2, RoundingMode.UP)); }
                   //
                if (!temp1.isAplicaIgv()
                 && temp1.getExonerado().equals("S")) {
                    if (!(temp.getDFACMTOMO().compareTo(BigDecimal.ZERO) == 0)){
                        montoExo = montoExo.add(temp.getDFACPREUMO().multiply(temp.getCANTIDAD()));
                        dsctoExo = dsctoExo.add(temp.getDFACDCTOMO());
                    } 
                }
                   //  
                if (!temp1.isAplicaIgv()
                 && temp1.getExonerado().equals("N")) {    
                    montoIna = montoIna.add(temp.getDFACPREUMO().multiply(temp.getCANTIDAD()));}
                    //
                //}
                //montoIGV=montoIGV.add(temp.getMontoIgv());
            }
            //totales
            //escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "MntNeto" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + (ticket.getMontoIgv() == BigDecimal.ZERO ? 0 : (ticket.getTotal().setScale(2).subtract(ticket.getMontoIgv())) ) + "\n");
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "MntNeto" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + montoGra.setScale(2) + "\n");
            //escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "MntExe" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + BigDecimal.ZERO + "\n");
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "MntExe" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + montoIna.setScale(2) + "\n");
            //escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"MntExo"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+(ticket.getMontoIgv()==BigDecimal.ZERO?ticket.getTotal().subtract(ticket.getMontoIgv()):0)+"\n");
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "MntExo" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + montoExo.setScale(2) + "\n");
            // PCC 13.10.2020 Transferencia Gratuita
            //escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "MntTotGrat" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + BigDecimal.ZERO + "\n");
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "MntTotGrat" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + montoGrat.setScale(2) + "\n");
            //
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "MntTotBoni" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + BigDecimal.ZERO + "\n");
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "MntTotAnticipo" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + BigDecimal.ZERO + "\n");
            // PCC 23/09/2021
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "TotDscNA" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + dsctoExo.setScale(2) + "\n");
            //
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "MntTotal" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + ventasCabeceraVO.getFACTOTMO().setScale(2, RoundingMode.UP) + "\n");//monto total
            // 
            // Resolucion 193-2020-Sunat (Formas de Pago) 20/08/2021
            if (ventasCabeceraVO.getTIPODOCUMENTO().equals("01")){
                escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "FormaPago" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + "Contado" + "\n");// Forma de Pago
            }// Fin Resolucion 193-2020-Sunat
            //
            //UBL2.1
            // Los campos TotDscNA, TotCrgNA, MntRedondeo
            // No aplican pues los descuentos y recargos afectan ala BI y Redeondeos mo se utilizan
            //
            // UBL2.1
            String TipOperacion ="0101"; //Venta Interna
            //if ((SesionData.getSesion().getTipDocSunat().equals("0") || SesionData.getSesion().getTipDocSunat().equals("4")
            // || SesionData.getSesion().getTipDocSunat().equals("7"))&& (SesionData.getSesion().getCiaid().equals("2"))){
            //    TipOperacion="0401"; //Ventas no domiciliados que no califican como exportaciÃ³n
            //}
            if (v_tipo_documento_sunat.equals("0") || v_tipo_documento_sunat.equals("4")
               || v_tipo_documento_sunat.equals("7")){  // si es no domiciliado
               if (ventasCabeceraVO.getIDCOMPANIA().equals("2")){
                  TipOperacion="0401"; //Ventas no domiciliados que no califican como exportaciÃ³n para Crisol
               }else{ // Futuro inicio de lÃ³gica para determinar exportaciÃ³n de servicios para DM
                  TipOperacion="0401"; //Ventas no domiciliados que no califican como exportaciÃ³n
               }
            }
            
            
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "TipoOperacion" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + TipOperacion + "\n");//Tipo de OperaciÃ³n
            // Fin UBL2.1
            // Impresora Destino
            escribir.write("A" + Util.FILE_DELIMITADOR_FELOCAL + "ImprDest" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + maestroVentasVO.getPRINTDEST() + "\n");

            //SeccÃ­n A2: Impuestos
            //UBL2.1            
            // Base Imponible Global para impuestos
            i = 1;
            // IGV
            if (montoGra.compareTo(BigDecimal.ZERO) > 0) { 
                   escribir.write("A2" + Util.FILE_DELIMITADOR_FELOCAL + "CodigoImpuesto" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + maestroVentasVO.getCODIMPUESTO().intValue() + "\n");
                   escribir.write("A2" + Util.FILE_DELIMITADOR_FELOCAL + "MontoImpuesto" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + ventasCabeceraVO.getFACIGVMO().setScale(2, RoundingMode.UP) + "\n");
                   escribir.write("A2" + Util.FILE_DELIMITADOR_FELOCAL + "TasaImpuesto" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + maestroVentasVO.getIGVPORCENTAJE() + "\n");
                   escribir.write("A2" + Util.FILE_DELIMITADOR_FELOCAL + "MontoImpuestoBase" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + montoGra.setScale(2) + "\n"); 
                   i++;
            }
            //Impuestom para Bolsas
            if (montoIna.compareTo(BigDecimal.ZERO) > 0) {
                escribir.write("A2" + Util.FILE_DELIMITADOR_FELOCAL + "CodigoImpuesto" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + "9999" + "\n");
                escribir.write("A2" + Util.FILE_DELIMITADOR_FELOCAL + "MontoImpuesto" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + montoIna.setScale(2) + "\n");
                escribir.write("A2" + Util.FILE_DELIMITADOR_FELOCAL + "TasaImpuesto" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + "100" + "\n");
                escribir.write("A2" + Util.FILE_DELIMITADOR_FELOCAL + "MontoImpuestoBase" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + montoIna.setScale(2) + "\n");                 
            }
            //Fin UBL2.1
            i = 1;
            //detalleList = ventasDAO.detalleVentasList(ventasCabeceraVO);
            for (VentasDetalleVO temp : detalleList) {
            //for (DetalleTicket temp : ticket.getDetalleTicket()) {
                //PCC Validando Indicador de ExoneraciÃ³n
                ConceptoCobro temp1 = ConceptosDAO.getConceptoxCodigoConHost(ventasCabeceraVO.getIDCOMPANIA(),temp.getCODCON().trim());
                if (temp1.isAplicaIgv()
                && temp1.getExonerado().equals("N")) {
                   codImpuesto = "1000";
                   indExe = "10";
                   if (temp.getDFACMTOMO().compareTo(BigDecimal.ZERO) == 0){
                      codImpuestoIni = codImpuesto;
                      codImpuesto = "9996";
                      indExe = "13"; // Gratuito Gravado 
                   }
                } // Gravado
                   //
                if (!temp1.isAplicaIgv()
                 && temp1.getExonerado().equals("S")) {
                    codImpuesto = "9997";
                    indExe = "20";
                    if (temp.getDFACMTOMO().compareTo(BigDecimal.ZERO) == 0){
                      codImpuestoIni = codImpuesto;
                      codImpuesto = "9996";
                      indExe = "21";  // Gratuito Exonerado TG
                    }
                }  //Exonerado
                   //  
                if (!temp1.isAplicaIgv()
                 && temp1.getExonerado().equals("N")) {    
                    codImpuesto = "9999";
                    indExe = "30";
                    if (temp.getDFACMTOMO().compareTo(BigDecimal.ZERO) == 0){
                       codImpuestoIni = codImpuesto;
                       codImpuesto = "9996";
                       indExe = "37";  // Gratuito Inafecto TG
                    }
                }  // Inafecto 
                
                //B
                escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "NroLinDet" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + i + "\n");
                escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "QtyItem" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + temp.getCANTIDAD() + "\n");
                escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "UnmdItem" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + (temp.getUNIDADMEDIDA().equals("UND") ? "NIU" : "NIU") + "\n");//SesionData.getSesion().getUnidadMedida()
                //escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "VlrCodigo" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + (SesionData.getSesion().getIdcompania() + temp.getConceptoCobro().getTipo()) + "\n");
                //escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "VlrCodigo" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL +  temp.getConceptoCobro().getCodbarras() + "\n");
                escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "VlrCodigo" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL +  temp1.getTipo() + "\n");
                escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "NmbItem" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + temp1.getConcepto() + "\n");
                //escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "PrcItem" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + temp.getConceptoCobro().getPrecioUnitario().setScale(2, RoundingMode.UP) + "\n");

                    //escribir.write("B"+Util.FILE_DELIMITADOR_FELOCAL+"PrcItemSinIgv"+Util.FILE_DELIMITADOR_FELOCAL+i+Util.FILE_DELIMITADOR_FELOCAL+(temp.getMontoIgv().compareTo(BigDecimal.ZERO)==0?temp.getConceptoCobro().getPrecioUnitario():(temp.getConceptoCobro().getPrecioUnitario()).subtract(temp.getMontoIgv()))+"\n");
                //escribir.write("B"+Util.FILE_DELIMITADOR_FELOCAL+"PrcItemSinIgv"+Util.FILE_DELIMITADOR_FELOCAL+i+Util.FILE_DELIMITADOR_FELOCAL+(temp.getMontoIgv().compareTo(BigDecimal.ZERO)==0?temp.getConceptoCobro().getPrecioUnitario():(temp.getConceptoCobro().getPrecioUnitario()).subtract((temp.getConceptoCobro().getPrecioUnitario().multiply(SesionData.getSesion().getIgvPorcentaje().divide(new BigDecimal(100)))).setScale(2, RoundingMode.HALF_UP)))+"\n");
                //BigDecimal divisorIGV = BigDecimal.ONE.add(SesionData.getSesion().getIgvPorcentaje().divide(new BigDecimal(100)));
                QtyItem =  temp.getCANTIDAD() ;
                DescuentoMonto = (temp.getDFACDCTOMO().setScale(2));
                if (codImpuesto =="9996") { // Gratuitos
                    if (indExe=="21") {
                        escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "PrcItem" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + temp.getDFACPREUMO().setScale(2, RoundingMode.UP) + "\n");
                        escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "PrcItemSinIgv" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + BigDecimal.ZERO.setScale(2) + "\n");
                        //escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "MontoItem" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + (temp.getDescItem().setScale(2)) + "\n");
                        escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "MontoItem" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + (temp.getDFACPREUMO().multiply(QtyItem)).setScale(2, RoundingMode.UP) + "\n");
                        escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "DescuentoMonto" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + BigDecimal.ZERO.setScale(2) + "\n");
                    } else{
                        //
                        igvGravGrat = temp.getDFACDCTOMO().subtract(temp.getDFACDCTOMO().divide(divisorIGV, 2, RoundingMode.HALF_UP));
                        //escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "PrcItem" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + temp.getConceptoCobro().getPrecioUnitario().setScale(2, RoundingMode.UP) + "\n");
                        escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "PrcItem" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + ((temp.getDFACDCTOMO().subtract(igvGravGrat)).multiply(QtyItem)).setScale(2, RoundingMode.UP) + "\n");
                        escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "PrcItemSinIgv" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + BigDecimal.ZERO.setScale(2) + "\n");
                        //escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "PrcItemSinIgv" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + ((temp.getConceptoCobro().getPrecioUnitario().subtract(igvGravGrat)).multiply(QtyItem)).setScale(2, RoundingMode.UP) + "\n");
                        //escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "MontoItem" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + (temp.getDescItem().setScale(2)) + "\n");
                        //escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "MontoItem" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + (temp.getMontoIgv().compareTo(BigDecimal.ZERO) == 0 ? temp.getSubtotal().setScale(2, RoundingMode.UP) : ((temp.getSubtotal()).subtract(temp.getMontoIgv())).setScale(2, RoundingMode.UP)) + "\n");
                        // PCC 10.09.2021 
                        //escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "MontoItem" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + ((temp.getConceptoCobro().getPrecioUnitario().subtract(temp.getMontoIgv())).multiply(QtyItem)).setScale(2, RoundingMode.UP) + "\n");
                        escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "MontoItem" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + ((temp.getDFACDCTOMO().subtract(igvGravGrat)).multiply(QtyItem)).setScale(2, RoundingMode.UP) + "\n");
                        escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "DescuentoMonto" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + BigDecimal.ZERO.setScale(2) + "\n");
                    }
                    //escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "PrcItemSinIgv" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + BigDecimal.ZERO.setScale(2) + "\n");
                    //escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "MontoItem" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + (temp.getDescItem().setScale(2)) + "\n");
                    //escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "MontoItem" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + (temp.getMontoIgv().compareTo(BigDecimal.ZERO) == 0 ? temp.getSubtotal().setScale(2, RoundingMode.UP) : ((temp.getSubtotal()).subtract(temp.getMontoIgv())).setScale(2, RoundingMode.UP)) + "\n");
                    //escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "DescuentoMonto" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + BigDecimal.ZERO.setScale(2) + "\n");
                } else {    
                    if (codImpuesto =="9997") {  // Exonerados
                        // PCC 23.09.2021
                        //if (DescuentoMonto.compareTo(BigDecimal.ZERO) > 0){
                        //    escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "PrcItem" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + (temp.getConceptoCobro().getPrecioUnitario().subtract(DescuentoMonto)).setScale(2, RoundingMode.UP) + "\n");
                        //}else{
                        //    escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "PrcItem" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + temp.getConceptoCobro().getPrecioUnitario().setScale(2, RoundingMode.UP) + "\n");
                        //}
                        //escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "PrcItem" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + (temp.getDFACDCTOMO().subtract(DescuentoMonto.divide(QtyItem))).setScale(2, RoundingMode.UP) + "\n");
                        escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "PrcItem" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + (temp.getDFACPREUMO().subtract(DescuentoMonto.divide(QtyItem,RoundingMode.HALF_UP))).setScale(2, RoundingMode.UP) + "\n");
                        //escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "PrcItem" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + temp.getConceptoCobro().getPrecioUnitario().setScale(2, RoundingMode.UP) + "\n");
                        //escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "PrcItemSinIgv" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + (temp.getMontoIgv().compareTo(BigDecimal.ZERO) == 0 ? temp.getConceptoCobro().getPrecioUnitario().setScale(2) : ((temp.getConceptoCobro().getPrecioUnitario()).divide(divisorIGV, 2, RoundingMode.HALF_UP))) + "\n");
                        escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "PrcItemSinIgv" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + (temp.getDFACPREUMO().setScale(2)) + "\n");
                        //
                        escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "MontoItem" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + ((temp.getDFACMTOMO().add(DescuentoMonto)).setScale(2, RoundingMode.UP)) + "\n");
                        //
                        escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "DescuentoMonto" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + temp.getDFACDCTOMO().setScale(2) + "\n");
                    } else { // Gravados - Otros
                        if (codImpuesto =="1000") {  // 
                            escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "PrcItem" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + (temp.getDFACPREUMO().subtract(DescuentoMonto.divide(QtyItem))).setScale(2, RoundingMode.UP) + "\n");
                            escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "PrcItemSinIgv" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + ((temp.getDFACPREUMO()).divide(divisorIGV, 2, RoundingMode.HALF_UP)) + "\n");
                            escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "MontoItem" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + (((temp.getDFACVTOTMO()).subtract(temp.getDFACIMPMTO1())).setScale(2, RoundingMode.UP)) + "\n");
                            escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "DescuentoMonto" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + DescuentoMonto.divide(divisorIGV, 2, RoundingMode.HALF_UP) + "\n");
                        } else {
                            if (DescuentoMonto.compareTo(BigDecimal.ZERO) > 0){
                                escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "PrcItem" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + (temp.getDFACPREUMO().subtract(DescuentoMonto)).setScale(2, RoundingMode.UP) + "\n");

                            }else{
                                escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "PrcItem" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + temp.getDFACPREUMO().setScale(2, RoundingMode.UP) + "\n");
                            }
                            //escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "PrcItem" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + temp.getConceptoCobro().getPrecioUnitario().setScale(2, RoundingMode.UP) + "\n");
                            escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "PrcItemSinIgv" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + (temp.getDFACIMPMTO1().compareTo(BigDecimal.ZERO) == 0 ? temp.getDFACPREUMO().setScale(2) : ((temp.getDFACPREUMO()).divide(divisorIGV, 2, RoundingMode.HALF_UP))) + "\n");
                            escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "MontoItem" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + (temp.getDFACIMPMTO1().compareTo(BigDecimal.ZERO) == 0 ? temp.getDFACVTOTMO().setScale(2, RoundingMode.UP) : ((temp.getDFACVTOTMO()).subtract(temp.getDFACIMPMTO1())).setScale(2, RoundingMode.UP)) + "\n");
                            escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "DescuentoMonto" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + DescuentoMonto.setScale(2) + "\n");
                        }
                    }
                }    
                escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "IndExe" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL +  indExe + "\n");
                //escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "CodigoTipoIgv" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + SesionData.getSesion().getCodImpuesto() + "\n");
                //Se discrimina CÃ³digo de Impuesto
                escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "CodigoTipoIgv" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + codImpuesto + "\n");
                //
                escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "TasaIgv" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + maestroVentasVO.getIGVPORCENTAJE() + "\n");
                //escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "ImpuestoIgv" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + temp.getMontoIgv().setScale(2, RoundingMode.UP) + "\n");
                // UBL2.1
                // Base IMponible de Item
                if (codImpuesto =="9996") {  //Para items que son TG (transferencia gratuita)
                    if (codImpuestoIni !="1000"){ //Para Exonerados
                       escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "ImpuestoIgv" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + temp.getDFACIMPMTO1().setScale(2, RoundingMode.UP) + "\n");
                       escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "MontoBaseImp" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + (temp.getDFACDCTOMO().setScale(2)) + "\n");
                    } else {   //Para Gravados
                       igvGravGrat = temp.getDFACDCTOMO().subtract(temp.getDFACDCTOMO().divide(divisorIGV, 2, RoundingMode.HALF_UP));
                       escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "ImpuestoIgv" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + igvGravGrat.setScale(2, RoundingMode.UP) + "\n");
                       escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "MontoBaseImp" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + (temp.getDFACDCTOMO().divide(divisorIGV, 2, RoundingMode.HALF_UP)) + "\n");
                    }
                } else {     // Para items que no son TG
                    if (codImpuesto !="1000"){ //Para Exonerados
                       escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "ImpuestoIgv" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + temp.getDFACIMPMTO1().setScale(2, RoundingMode.UP) + "\n");
                       escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "MontoBaseImp" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + ((temp.getDFACMTOMO().add(DescuentoMonto)).setScale(2, RoundingMode.UP)) + "\n"); 
                    } else {   //Para Gravados
                       escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "ImpuestoIgv" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + temp.getDFACIMPMTO1().setScale(2, RoundingMode.UP) + "\n");
                       escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "MontoBaseImp" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + (((temp.getDFACVTOTMO()).subtract(temp.getDFACIMPMTO1())).setScale(2, RoundingMode.UP)) + "\n");
                    }
                }
                escribir.write("B" + Util.FILE_DELIMITADOR_FELOCAL + "CodigoProductoSunat" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL +  temp1.getCodPrdSunat() + "\n");
                // Fin UBL2.1
                i++;
            }
            //UBL2.1
            //Solo se activa seccion B1 si existen descuentos o recargos en el comprobante
            //
            if ((montoDescglo.compareTo(BigDecimal.ZERO) > 0)&&(!(montoDescglo.compareTo(montoGrat) == 0))) {
            //B1 Descuentos y Cargos
                i = 1;
                for (VentasDetalleVO temp : detalleList) {
                //for (DetalleTicket temp : ticket.getDetalleTicket()) {
//////////////////////////////////////////////////////////////////////////////////////////// 
                    // Se replica Rutina de identificaciÃ³n de codimpuesto .. 
                    ConceptoCobro temp1 = ConceptosDAO.getConceptoxCodigoConHost(ventasCabeceraVO.getIDCOMPANIA(),temp.getCODCON().trim());
                    if (temp1.isAplicaIgv()
                        && temp1.getExonerado().equals("N")) {
                        codImpuesto = "1000";
                        indExe = "10";
                        if (temp.getDFACDCTOMO().compareTo(BigDecimal.ZERO) == 0){
                            codImpuestoIni = codImpuesto;
                            codImpuesto = "9996";
                            indExe = "13"; // Gratuito Gravado 
                        }
                    } // Gravado
                   //
                    if (!temp1.isAplicaIgv()
                        && temp1.getExonerado().equals("S")) {
                        codImpuesto = "9997";
                        indExe = "20";
                        if (temp.getDFACDCTOMO().compareTo(BigDecimal.ZERO) == 0){
                            codImpuestoIni = codImpuesto;
                            codImpuesto = "9996";
                            indExe = "21";  // Gratuito Exonerado TG
                        }
                    }  //Exonerado
                   //  
                    if (!temp1.isAplicaIgv()
                    && temp1.getExonerado().equals("N")) {    
                        codImpuesto = "9999";
                        indExe = "30";
                        if (temp.getDFACDCTOMO().compareTo(BigDecimal.ZERO) == 0){
                            codImpuestoIni = codImpuesto;
                            codImpuesto = "9996";
                            indExe = "37";  // Gratuito Inafecto TG
                        }
                    }  // Inafecto                     
////////////////////////////////////////////////////////////////////////////////////////////                    
                    
                    
                     if (!(temp.getDFACDCTOMO().compareTo(BigDecimal.ZERO) == 0)){
                        escribir.write("B1" + Util.FILE_DELIMITADOR_FELOCAL + "NroLinDet" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + i + "\n");
                        escribir.write("B1" + Util.FILE_DELIMITADOR_FELOCAL + "IndCargoDescuento" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + BigDecimal.ZERO + "\n");
                        if (codImpuesto =="9997") {  // Exonerados
                            escribir.write("B1" + Util.FILE_DELIMITADOR_FELOCAL + "CodigoCargoDescuento" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + "01" + "\n");
                        } else {
                            escribir.write("B1" + Util.FILE_DELIMITADOR_FELOCAL + "CodigoCargoDescuento" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + "00" + "\n");    
                        }
                        escribir.write("B1" + Util.FILE_DELIMITADOR_FELOCAL + "FactorCargoDescuento" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + (temp.getDFACDCTOMO().compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : (temp.getDFACDCTOMO().divide(temp.getDFACVTOTMO().add(temp.getDFACDCTOMO()), 2, RoundingMode.HALF_UP))) + "\n");
                        if (codImpuesto =="1000") {  // Gravados
                            escribir.write("B1" + Util.FILE_DELIMITADOR_FELOCAL + "MontoCargoDescuento" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL +  (temp.getDFACDCTOMO().compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : temp.getDFACDCTOMO().divide(divisorIGV, 2, RoundingMode.HALF_UP))+ "\n");
                            escribir.write("B1" + Util.FILE_DELIMITADOR_FELOCAL + "MBaseCargoDescuento" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL  + (temp.getDFACDCTOMO().compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : ((temp.getDFACVTOTMO().add(temp.getDFACDCTOMO())).divide(divisorIGV, 2, RoundingMode.HALF_UP))) + "\n");    
                        } else {
                            escribir.write("B1" + Util.FILE_DELIMITADOR_FELOCAL + "MontoCargoDescuento" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL + temp.getDFACDCTOMO().setScale(2, RoundingMode.UP) + "\n");
                            escribir.write("B1" + Util.FILE_DELIMITADOR_FELOCAL + "MBaseCargoDescuento" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL  + (temp.getDFACDCTOMO().compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : (temp.getDFACVTOTMO().add(temp.getDFACDCTOMO())).setScale(2, RoundingMode.UP)) + "\n");    
                        }
                     }
                     //escribir.write("B1" + Util.FILE_DELIMITADOR_FELOCAL + "MBaseCargoDescuento" + Util.FILE_DELIMITADOR_FELOCAL + i + Util.FILE_DELIMITADOR_FELOCAL  + (temp.getDescItem().compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : temp.getSubtotal().add(temp.getDescItem().setScale(2, RoundingMode.UP))) + "\n");
                     //
                     i++;
                }
            }
            // Reactivar para UBL2.1
            //
            //C
            // UBL2.1 En esta SecciÃ³n sÃ³lo se consignarÃ¡ Recargos y sÃ³lo para cias DM
            //
             if (!(ventasCabeceraVO.getIDCOMPANIA().equals("2"))) {
                escribir.write("C" + Util.FILE_DELIMITADOR_FELOCAL + "NroLinDR" + Util.FILE_DELIMITADOR_FELOCAL + "1" + Util.FILE_DELIMITADOR_FELOCAL + BigDecimal.ONE + "\n");
                escribir.write("C" + Util.FILE_DELIMITADOR_FELOCAL + "TpoMov" + Util.FILE_DELIMITADOR_FELOCAL + "1" + Util.FILE_DELIMITADOR_FELOCAL + "D" + "\n");
                escribir.write("C" + Util.FILE_DELIMITADOR_FELOCAL + "ValorDR" + Util.FILE_DELIMITADOR_FELOCAL + "1" + Util.FILE_DELIMITADOR_FELOCAL + montoDescglo.setScale(2) + "\n");  
                escribir.write("C" + Util.FILE_DELIMITADOR_FELOCAL + "IndCargoDescuento" + Util.FILE_DELIMITADOR_FELOCAL + "1" + Util.FILE_DELIMITADOR_FELOCAL + BigDecimal.ONE + "\n");
                escribir.write("C" + Util.FILE_DELIMITADOR_FELOCAL + "CodigoCargoDescuento" + Util.FILE_DELIMITADOR_FELOCAL + "1" + Util.FILE_DELIMITADOR_FELOCAL + "46" + "\n"); // Recargo al consumo y/o propinas
                escribir.write("C" + Util.FILE_DELIMITADOR_FELOCAL + "FactorCargoDescuento" + Util.FILE_DELIMITADOR_FELOCAL + "1" + Util.FILE_DELIMITADOR_FELOCAL + BigDecimal.ZERO + "\n");
                escribir.write("C" + Util.FILE_DELIMITADOR_FELOCAL + "MontoCargoDescuento" + Util.FILE_DELIMITADOR_FELOCAL + "1" + Util.FILE_DELIMITADOR_FELOCAL  + BigDecimal.ZERO + "\n");
                escribir.write("C" + Util.FILE_DELIMITADOR_FELOCAL + "MBaseCargoDescuento" + Util.FILE_DELIMITADOR_FELOCAL + "1" + Util.FILE_DELIMITADOR_FELOCAL  + BigDecimal.ZERO + "\n");
             }
            // 
            // Se comenta seccion C de versiÃ³n UBL2.0
            //escribir.write("C" + Util.FILE_DELIMITADOR_FELOCAL + "NroLinDR" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + BigDecimal.ONE + "\n");
            //escribir.write("C" + Util.FILE_DELIMITADOR_FELOCAL + "TpoMov" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + "D" + "\n");
            //escribir.write("C" + Util.FILE_DELIMITADOR_FELOCAL + "ValorDR" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + montoDescglo.setScale(2) + "\n");  
            // Fin 
           
            String Tienda = TiendaDAO.consultarTiendaxID(ventasCabeceraVO.getIDCOMPANIA(), ventasCabeceraVO.getALMACEN()).getTiendadsc();
            String TiendaDir = TiendaDAO.consultarTiendaxID(ventasCabeceraVO.getIDCOMPANIA(), ventasCabeceraVO.getALMACEN()).getTiendadir();
            //txtubigeo
            txtubigeo = TiendaDAO.consultarTiendaxID(ventasCabeceraVO.getIDCOMPANIA(), ventasCabeceraVO.getALMACEN()).getTiendaubigeo();
            //
            String txtDistrito  = DistritoDAO.consultarUbigeo(txtubigeo).getDistrito();
            String txtIdProv    = DistritoDAO.consultarUbigeo(txtubigeo).getCodProvincia();
            String txtIdDepart  = DistritoDAO.consultarUbigeo(txtubigeo).getCodDepartamento();
            String txtDepart    = DepartamentoDAO.consultarUbigro(txtIdDepart).getDepartamento(); 
            String txtProvincia = ProvinciaDAO.consultarUbigeo(txtIdProv).getProvincia(); 
            String txtVendedor  = ventasCabeceraVO.getVEID();
            String fpago        = MedioPagoDAO.retornaFormaPago( ventasCabeceraVO.getIDCOMPANIA(),
                                                                 ventasCabeceraVO.getTIPODOCUMENTO(),
                                                                 ventasCabeceraVO.getSERIE(),
                                                                 numComp);
            String fpagodet="-";
            //
            String xPago   = "-";
            String xVuelto = "-";
            String xObserv = "Pedido nro : " + ventasCabeceraVO.getNUMPEDIDO().trim();
            // Datos para DM Hoteles y CR
            String xObserv2 = "";
            String xcodReserva="";
            String xGrupo = "";
            String xCheckIn = "";
            String CheckOut = "";
            String xHabitacion = "";

            //
            
            i = 1;
            MensajesVO mensajesVO;
            mensajesVO = MensajesData.getMensajesBD();
            
            mensajes = mensajesVO.getMensajes().split("@"); 
            // UBL2.1 
            // Se bifurca por compaÃ±Ã­a para Crisol y DM
            if ((ventasCabeceraVO.getIDCOMPANIA().equals("2"))) {   // Crisol
            // Temporal solo por Feria se cambia de cia 2 a 1 PCC 01.09.2021
            //if ((UsuarioData.getUsuario().getEmpresa().equals("1"))) {   // Crisol
                for (String mensaje : mensajes) {
                    if (i < 10) {
                        escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "TipoAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + ("0" + String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + "01" + "\n");
                        escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "NmrLineasAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + ("0" + String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + String.valueOf(i) + "\n");
                    } else {
                        escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "TipoAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + "01" + "\n");
                        escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "NmrLineasAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + String.valueOf(i) + "\n");
                    }
                    if (mensaje.equals("*")) {
                        switch (i) {
                            case 1:
                                String[] numeroToLetras = NumberToLetterConverter.convertNumberToLetter(ventasCabeceraVO.getFACTOTMO().doubleValue()).split(":");
                                //escribir.write("E"+Util.FILE_DELIMITADOR_FELOCAL+"DescripcionAdicSunat"+Util.FILE_DELIMITADOR_FELOCAL+("0"+String.valueOf(i))+Util.FILE_DELIMITADOR_FELOCAL+NumberToLetterConverter.convertNumberToLetter(ticket.getTotal().doubleValue())+"\n");
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + ("0" + String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + numeroToLetras[1].substring(1) + "\n");
                                break;
                            case 3:
                                //Observaciones
                                //escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + ("0" + String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + txtAreaObs.getText() + "\n");
                                //escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + ("0" + String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + (txtAreaObs.getText().trim().compareTo("") == 0 ? "-" : txtAreaObs.getText()+"|") + "\n");
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + ("0" + String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + (xObserv.compareTo("") == 0 ? "-" : xObserv+"|") + "\n");
                                break;   
                            case 7:
                                //Departamento-Provincia-Distrito Tienda
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + ("0" + String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + (txtDepart.trim().compareTo("") == 0 ? "-" : txtDepart.trim() + "-" + txtProvincia.trim() + "-"+ txtDistrito.trim()) + "\n");
                                break;     
                            case 8:
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + ("0" + String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + Tienda + "\n");
                                break;
                            case 9:
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + ("0" + String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + TiendaDir + "\n");
                                break;
                            case 10:
                                //escribir.write("E"+Util.FILE_DELIMITADOR_FELOCAL+"DescripcionAdicSunat"+Util.FILE_DELIMITADOR_FELOCAL+(String.valueOf(i))+Util.FILE_DELIMITADOR_FELOCAL+SesionData.getSesion().getFechaProceso()+"\n");q
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + Util.obtieneHora() + "\n");
                                break;
                            case 11:
                                //escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL +  UsuarioData.getUsuario().getUsuario() + "\n");
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL +  v_usuario + "\n");
                                break;
                            case 12:
                                // Vendedor
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + txtVendedor + "\n");
                                break;     
                            case 13:
                                // Forma de Pago
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + fpago + "\n");
                                break;    
                            case 14:
                                //Pago
                                //escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + txtEfectivo.getText().toString() + "\n");
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + xPago + "\n");
                                break;      
                            case 15:
                                //Vuelto
                                //escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + txtVuelto.getText().toString() + "\n");
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + xVuelto + "\n");
                                break;      
                            //UBL2.1
                            case 16:
                                //Total de Descuento
                                if ((montoDescglo.compareTo(BigDecimal.ZERO) > 0)&&(!(montoDescglo.compareTo(montoGrat) == 0))) {
                                    escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + (montoDescglo.subtract(montoGrat)).setScale(2) + "\n");
                                    
                                } else{
                                    escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + BigDecimal.ZERO.setScale(2)  + "\n");
                                }
                                break;      
                            //Fin UBL2.1
                        }
                    } else if (i < 10) {
                        escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + ("0" + String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + mensaje + "\n");
                    } else {
                        escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + mensaje + "\n");
                    }
                    i++;
                }
            }else {   // Para CompaÃ±Ã­as Derrama
                for (String mensaje : mensajes) {
                    if (i < 10) {
                        escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "TipoAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + ("0" + String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + "01" + "\n");
                        escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "NmrLineasAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + ("0" + String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + String.valueOf(i) + "\n");
                    } else {
                        escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "TipoAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + "01" + "\n");
                        escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "NmrLineasAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + String.valueOf(i) + "\n");
                    }
                    if (mensaje.equals("*")) {
                        switch (i) {
                            case 1:
                                String[] numeroToLetras = NumberToLetterConverter.convertNumberToLetter(ventasCabeceraVO.getFACTOTMO().doubleValue()).split(":");
                                //escribir.write("E"+Util.FILE_DELIMITADOR_FELOCAL+"DescripcionAdicSunat"+Util.FILE_DELIMITADOR_FELOCAL+("0"+String.valueOf(i))+Util.FILE_DELIMITADOR_FELOCAL+NumberToLetterConverter.convertNumberToLetter(ticket.getTotal().doubleValue())+"\n");
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + ("0" + String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + numeroToLetras[1].substring(1) + "\n");
                                break;
                            case 3:
                                //Observaciones 1
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + ("0" + String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + (xObserv.compareTo("") == 0 ? "-" : xObserv+"|") + "\n");
                                break;   
                            case 4:
                                //Observaciones 2
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + ("0" + String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + (xObserv2.compareTo("") == 0 ? "-" : xObserv2+"|") + "\n");
                                break;   
                            case 8:
                                // Descricion de Tienda
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + ("0" + String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + Tienda + "\n");
                                break;
                            case 9:
                                // Direccion de Tienda
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + ("0" + String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + TiendaDir + "\n");
                                break;
                            case 10:
                                // FechaHora de EmisiÃ³n
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + Util.obtieneFechaDiaHora() + "\n");
                                break;
                            case 11:
                                // Usuario
                                //escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + UsuarioData.getUsuario().getUsuario() + "\n");
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + v_usuario + "\n");
                                break;
                            case 12:
                                // CÃ³digo de Reserva
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + xcodReserva + "\n");
                                break;   
                            case 13:
                                // CÃ³digo de Grupo
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + xGrupo + "\n");
                                break;     
                            case 14:
                                // CheckIn
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + xCheckIn + "\n");
                                break;     
                            case 15:
                                // CheckOut
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + CheckOut + "\n");
                                break;     
                            case 16:
                                // Habitaciones
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + xHabitacion + "\n");
                                //escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + txtVendedor + "\n");
                                break;     
                            case 17:
                                // Flag 1:DM 2:Hoteles
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + "1" + "\n");
                                //escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + txtVendedor + "\n");
                                break;   
                            case 18:
                                //Total de Descuento
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + montoDescglo.setScale(2) + "\n");
                                break;                                  
                            case 19:
                                //Vendedor
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + txtVendedor + "\n");
                                break;                                  
                            case 20:
                                // Forma de Pago para RI
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + fpago + "\n");
                                break;    
                            case 21:
                                // Forma de Pago Detalle
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + fpagodet + "\n");
                                break;    
                            //case 14:
                                //Pago
                                //escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + txtEfectivo.getText().toString() + "\n");
                            //    escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + xPago + "\n");
                            //    break;      
                            case 22:
                                //Vuelto
                                //escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + txtVuelto.getText().toString() + "\n");
                                escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + xVuelto + "\n");
                                break;      
                        }
                    } else if (i < 10) {
                        escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + ("0" + String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + mensaje + "\n");
                    } else {
                        escribir.write("E" + Util.FILE_DELIMITADOR_FELOCAL + "DescripcionAdicSunat" + Util.FILE_DELIMITADOR_FELOCAL + (String.valueOf(i)) + Util.FILE_DELIMITADOR_FELOCAL + mensaje + "\n");
                    }
                    i++;
                }                
            }
            
            escribir.write("M" + Util.FILE_DELIMITADOR_FELOCAL + "NroLinMail" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + BigDecimal.ONE + "\n");
            escribir.write("M" + Util.FILE_DELIMITADOR_FELOCAL + "MailEnvi" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + (clienteVO.getMail().trim().compareTo("") == 0 ? "-" : clienteVO.getMail()) + "\n");
            escribir.write("M" + Util.FILE_DELIMITADOR_FELOCAL + "MailCC" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL +  "-"  + "\n");
            escribir.write("M" + Util.FILE_DELIMITADOR_FELOCAL + "MailCCO" + Util.FILE_DELIMITADOR_FELOCAL + Util.FILE_DELIMITADOR_FELOCAL + "-"  + "\n");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            escribir.close();
            
            // Copiando Archivo a Ruta FE
            ArchivoOrigen = file.getPath();
            int f = ArchivoOrigen.indexOf("FE");
            ArchivoDestino = ArchivoOrigen.substring(f);
            ArchivoDestino = v_ruta_FE_Local+"\\"+ArchivoDestino;
            Path origenPath = Paths.get(ArchivoOrigen);
            Path destinoPath = Paths.get(ArchivoDestino);
            Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
            //
            JOptionPane.showMessageDialog(null, "Comprobante enviado a Impresión!!");
            
            //escribir.
            
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcbCriterio;
    private javax.swing.JTable tblPedidos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFechaPed;
    private javax.swing.JTextField txtNroComprob;
    private javax.swing.JTextField txtPedido;
    private javax.swing.JTextField txtSerie;
    private javax.swing.JTextField txtTipoDoc;
    // End of variables declaration//GEN-END:variables
}
