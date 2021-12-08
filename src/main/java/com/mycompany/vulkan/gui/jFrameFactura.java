/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vulkan.gui;
import com.mycompany.controlador.controlClientes;
import com.mycompany.controlador.controlEmpleado;
import com.mycompany.controlador.controlMenu;
import com.mycompany.controlador.controlMesas;
import com.mycompany.controlador.controlPedidos;
import com.mycompany.controlador.controlTipoPago;
import com.mycompany.vulkan.validacion.fechaActual;
import com.mycompany.vulkan.validacion.valNumero;
import com.mycompany.vulkan.validacion.valString;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import static java.lang.Integer.parseInt;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import com.mycompany.controlador.controlFactura;
import com.mycompany.controlador.controlMenu_pedido;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import vulkan.declaracion.decClientes;
import vulkan.declaracion.decMenu;
import vulkan.declaracion.decMesas;
import vulkan.declaracion.decPedidos;
import vulkan.declaracion.decEmpleado;
import vulkan.declaracion.decFactura;
import vulkan.declaracion.decMenu_pedido;
import vulkan.declaracion.decTipoPago;
import vulkan.declaracion.decSingletonUser;
import vulkan.declaracion.decUsuario;
import vulkan.declaracion.facturaDataSource;

/**
 * @author fer3dev
 */

public class jFrameFactura extends javax.swing.JFrame {
    valString valS = new valString();
    valNumero valN = new valNumero();
    //Clientes
    controlClientes clienteDao = new controlClientes();
    //Mesas
    controlMesas mesasDao = new controlMesas();
    //Menu
    controlMenu menuDao = new controlMenu();
    //Empleado
    controlEmpleado empleadoDao = new controlEmpleado();
    //Fecha
    fechaActual fechactual = new fechaActual();
    
    //Control pedido
    controlPedidos pedidosDao = new controlPedidos();
    //Control Tipo pago
    controlTipoPago pagoDao = new controlTipoPago();
    //control factura
    controlFactura facturaDao = new controlFactura();
    
    static DefaultTableModel t2;
    decFactura factura = new decFactura();
    decMenu menu = new decMenu();
    decPedidos pedidos = new decPedidos();
    controlMenu_pedido menuPedidoDao = new controlMenu_pedido();
    
    
    facturaDataSource dataSource;
    private decUsuario usuarios = new decUsuario();
    private decSingletonUser singleton = decSingletonUser.getUsuario(usuarios);
    /**
     * Creates new form jFramePlantilla
     */
    public jFrameFactura() {
        initComponents();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/logo1.png"));
        setIconImage(icon.getImage());
        setTitle("VK Restaurant");
        this.cbb_tipoDePago();
        //this.iniciar();
        this.llenarTabla();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lbl_puestos_trabajo = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_id_pedido = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cbb_mesa = new javax.swing.JComboBox<>();
        cbb_mesa1 = new javax.swing.JComboBox<>();
        cbx_delivery = new javax.swing.JCheckBox();
        cbx_delivery1 = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbb_tipoPago = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_tarjeta = new javax.swing.JTextField();
        txt_efectivo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        txt_subTotal = new javax.swing.JTextField();
        txt_impuesto = new javax.swing.JTextField();
        btn_limpiar = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txt_nombre_cliente = new javax.swing.JTextField();
        txt_mesero = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_registros = new javax.swing.JTable();
        btn_update = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        btn_regresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(244, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(1280, 300));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setPreferredSize(new java.awt.Dimension(1280, 50));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_puestos_trabajo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lbl_puestos_trabajo.setText("Factura");
        jPanel4.add(lbl_puestos_trabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, -1));

        jLabel10.setText("Id pedido");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
        jPanel4.add(txt_id_pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel14.setText("Mesa");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        jPanel4.add(cbb_mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 140, -1));

        jPanel4.add(cbb_mesa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 110, 20));

        cbx_delivery.setText("Delivery");
        cbx_delivery.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbx_deliveryStateChanged(evt);
            }
        });
        cbx_delivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_deliveryActionPerformed(evt);
            }
        });
        jPanel4.add(cbx_delivery, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, -1));

        cbx_delivery1.setText("Delivery");
        cbx_delivery1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbx_delivery1StateChanged(evt);
            }
        });
        cbx_delivery1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_delivery1ActionPerformed(evt);
            }
        });
        jPanel4.add(cbx_delivery1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        jPanel3.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Nombre Cajero");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        cbb_tipoPago.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_tipoPagoItemStateChanged(evt);
            }
        });
        jPanel6.add(cbb_tipoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 160, -1));

        jLabel5.setText("Tipos de pago");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 20));

        txt_fecha.setEditable(false);
        txt_fecha.setEnabled(false);
        jPanel6.add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 160, -1));

        jLabel6.setText("Fecha");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        txt_tarjeta.setEnabled(false);
        txt_tarjeta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_tarjetaKeyTyped(evt);
            }
        });
        jPanel6.add(txt_tarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, 170, -1));

        txt_efectivo.setEnabled(false);
        jPanel6.add(txt_efectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 70, -1));

        jLabel7.setText("Número de tarjeta");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, -1, -1));

        jLabel8.setText("cantidad");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, -1, -1));

        jPanel6.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 160, -1));

        jLabel11.setText("Cantidad");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, -1, -1));

        jTextField2.setEnabled(false);
        jPanel6.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 70, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Pago en efectivo:");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Pago con tarjeta:");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, -1));

        jLabel15.setText("Sub-total");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, -1));

        jLabel16.setText("Impuesto");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, -1));

        jLabel17.setText("Total");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));

        txt_total.setEnabled(false);
        jPanel6.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 80, -1));

        txt_subTotal.setEnabled(false);
        jPanel6.add(txt_subTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 80, -1));

        txt_impuesto.setEnabled(false);
        jPanel6.add(txt_impuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 80, -1));

        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar50.png"))); // NOI18N
        btn_limpiar.setPreferredSize(new java.awt.Dimension(50, 50));
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });
        jPanel6.add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 170, -1, -1));

        jLabel18.setText("Nombre del mesero");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jTextField6.setEnabled(false);
        jPanel6.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 160, -1));

        jLabel19.setText("Numero de factura");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTextField7.setEnabled(false);
        jPanel6.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 190, -1));

        jLabel9.setText("Descuento");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));
        jPanel6.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 80, -1));

        jLabel20.setText("Cliente");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));
        jPanel6.add(txt_nombre_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 160, -1));
        jPanel6.add(txt_mesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, -1));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 840, 230));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo2.png"))); // NOI18N
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 10, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BackgroundRes.png"))); // NOI18N
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        tbl_registros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_registros.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_registros.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tbl_registros.setSelectionForeground(new java.awt.Color(204, 204, 255));
        tbl_registros.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                tbl_registrosAncestorRemoved(evt);
            }
        });
        tbl_registros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_registrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_registros);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1280, 310));

        btn_update.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Actualizar1.png"))); // NOI18N
        btn_update.setToolTipText("");
        btn_update.setPreferredSize(new java.awt.Dimension(50, 50));
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel2.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        btn_agregar.setBackground(new java.awt.Color(204, 204, 204));
        btn_agregar.setForeground(new java.awt.Color(0, 0, 255));
        btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imprimir.png"))); // NOI18N
        btn_agregar.setPreferredSize(new java.awt.Dimension(150, 50));
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 50, 150, 50));

        btn_regresar.setBackground(new java.awt.Color(204, 204, 204));
        btn_regresar.setForeground(new java.awt.Color(255, 0, 51));
        btn_regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Regresar1.png"))); // NOI18N
        btn_regresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));
        btn_regresar.setPreferredSize(new java.awt.Dimension(150, 50));
        btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 50, 140, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BackgroundRes.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -250, -1, -1));

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
        mainMenu menu = new mainMenu();
        this.dispose();
        menu.setVisible(true);
        this.comboBoxMesa();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_regresarActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        //this.llenarTabla();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void txt_tarjetaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tarjetaKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_tarjetaKeyTyped

    private void cbb_tipoPagoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_tipoPagoItemStateChanged
        // TODO add your handling code here:
        if(cbb_tipoPago.getSelectedItem().equals("Efectivo")){
            txt_efectivo.setEnabled(true);
            txt_tarjeta.setEnabled(false);
            
        }
        else if(cbb_tipoPago.getSelectedItem().equals("Tarjeta")){
            txt_tarjeta.setEnabled(true);
            txt_efectivo.setEnabled(false);
        }else if(cbb_tipoPago.getSelectedItem().equals("Mixto")){
            txt_tarjeta.setEnabled(true);
            txt_efectivo.setEnabled(true);
        }else{
            txt_tarjeta.setEnabled(false);
            txt_efectivo.setEnabled(false);
        }    
    }//GEN-LAST:event_cbb_tipoPagoItemStateChanged

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        venta();

    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void tbl_registrosAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_registrosAncestorRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_registrosAncestorRemoved

    private void tbl_registrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_registrosMouseClicked
        // TODO add your handling code here:
        int row = tbl_registros.getSelectedRow();
        double a = (double) tbl_registros.getValueAt(row, 6);
        double b = a * 0.15;
        double c = a + b;
        if (tbl_registros.getValueAt(row, 4).toString().equals("En linea")) {
            cbx_delivery.setSelected(true);
            cbb_mesa.setEnabled(false);
        } else {
            cbx_delivery.setSelected(false);
            cbb_mesa.setEnabled(true);
        }

        cbb_mesa.setSelectedItem(tbl_registros.getValueAt(row, 5).toString());
        txt_id_pedido.setText(tbl_registros.getValueAt(row, 0).toString());
        txt_nombre_cliente.setText(tbl_registros.getValueAt(row, 2).toString());
        txt_subTotal.setText(tbl_registros.getValueAt(row, 6).toString());
        txt_impuesto.setText(Double.toString(b));
        txt_total.setText(Double.toString(c));
        
        btn_agregar.setEnabled(true);
        
    }//GEN-LAST:event_tbl_registrosMouseClicked

    private void cbx_deliveryStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbx_deliveryStateChanged
       
    }//GEN-LAST:event_cbx_deliveryStateChanged

    private void cbx_deliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_deliveryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_deliveryActionPerformed

    private void cbx_delivery1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbx_delivery1StateChanged
       
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_delivery1StateChanged

    private void cbx_delivery1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_delivery1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_delivery1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jFrameFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrameFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrameFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrameFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFrameFactura().setVisible(true);
            }
        });
    }
    
    private void cbb_tipoDePago(){
        cbb_tipoPago.removeAllItems();
        cbb_tipoPago.addItem("Seleccionar");
        
        List<decTipoPago> mp = this.pagoDao.findTipoPagoEntities();
        for (decTipoPago unTipo : mp){
            if (unTipo.getDesactivado() == 0) {
               cbb_tipoPago.addItem(String.valueOf(unTipo.getNombre()));}
        }
    }
    
    
    
    public void imprimirFactura(){         
           
        
        List<decFactura> facturar = facturaDao.findClientesEntities();
        decFactura facturaActual = facturar.get(facturar.size()-1);

        //FROM decFactura E WHERE E.id_factura = :id_factura
        EntityManager em = facturaDao.getEntityManager();
        String hqlDetalleProd = "select id_factura FROM decFactura";
        Query queryDetalleProd = em.createQuery(hqlDetalleProd);
        queryDetalleProd.setParameter("id_factura",facturaActual.getId_factura());
        
        String idpedidos = "select id_pedido from decPedidos where desactivado = 0";

        Object[][] arrayDetallesFactura;
        arrayDetallesFactura = new Object[facturar.size()][3];   
    
        for(int i = 0; i < facturar.size(); i++)
        {        
            for(int j = 0; j < 3 ; j++)
            {            
                switch(j)
                {                
                    case 0: // nombre del menu
                        arrayDetallesFactura[i][0] = menuDao.findclientes(menu.getId_menu()).getNombre();                        
                    break;
                    
                    case 1: // Precio original en menu
                        arrayDetallesFactura[i][1] = menuDao.findclientes(menu.getId_menu()).getPrecio();                        
                    break;
                    
                    case 2: // cantidad en menu pedido 
                        arrayDetallesFactura[i][2] = menuPedidoDao.findclientes(pedidos.getId_pedido()).getCantidad();
                    break;                                                               
                }            
            }
        }
        
        HashMap param = new HashMap();  
        param.put("Empleado",empleadoDao.findclientes(facturaActual.getId_empleado_cajero()).getNombre());
                
        
        try {
            JasperReport reporteFactura = JasperCompileManager.compileReport("src/main/resources/reportes/facturaReporte.jrxml");
            JasperPrint print = JasperFillManager.fillReport(
                    reporteFactura,
                    param, 
                    dataSource.getDataSource(arrayDetallesFactura));
            JasperViewer view = new JasperViewer(print,false);
            view.setVisible(true);
            view.setTitle("Factura ");            
        } catch (JRException ex) {
            Logger.getLogger(jFrameFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void iniciar(){
        txt_fecha.setText(fechactual.getFechaActual());
    }
    
    
    
    private void llenarTabla(){
        DefaultTableModel modelo = new DefaultTableModel();
        tbl_registros.setModel(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("Nombre del cliente");
        modelo.addColumn("Nombre del mesero");
        modelo.addColumn("Fecha del pedido");
        modelo.addColumn("Tipo de pedido");
        modelo.addColumn("Número de mesa");
        
        modelo.addColumn("Sub Total");

        List<decPedidos> pedidos = pedidosDao.findMesasEntities();

        
        for (decPedidos unPedido : pedidos) {
            if (unPedido.getDesactivado() == 0) {
                
               String nombreCliente = clienteDao.findClientes(unPedido.getId_cliente()).getNombre()
                    + " "
                    + clienteDao.findClientes(unPedido.getId_cliente()).getApellido();
            String nombreEmpleado = empleadoDao.findclientes(unPedido.getId_empleado_mesero()).getNombre()
                    + " "
                    + empleadoDao.findclientes(unPedido.getId_empleado_mesero()).getApellido();

            String linea = "";
            String mesass = "";
            if (unPedido.getPedido_en_linea()) {
                linea = "En linea";
                mesass = "-";
            } else {
                linea = "En restaurante";
                mesass = String.valueOf(unPedido.getId_mesa());
            }
            
            modelo.addRow(
                    new Object[]{
                        unPedido.getId_pedido(),
                        nombreCliente,
                        nombreEmpleado,
                        unPedido.getFecha_pedido(),
                        linea,
                        mesass,
                        subTotal(unPedido.getId_pedido()),
                        }
            );
        } 
            } 
            
        
        btn_agregar.setEnabled(false);
        txt_tarjeta.setEnabled(false);
        txt_efectivo.setEnabled(false);
    }
    
    private static double subTotal(int Nombre) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("base_datos_mysql");
        EntityManager em = emf.createEntityManager();
        String select = "select SUM(precio) from decMenu_pedido where id_pedido = '" + Nombre+"'";
        Query query = em.createQuery(select);

        return Double.parseDouble(query.getSingleResult().toString());
    }
    private void venta(){
        
        if(cbb_tipoPago.getSelectedItem().equals("Seleccione"))
        {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una tipo de pago", "Error", JOptionPane.ERROR_MESSAGE);
        }/*else if(txt_efectivo.getText().isBlank()
                || txt_tarjeta.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debe seleccionar rellena tarjeta o efectivo", "Error", JOptionPane.ERROR_MESSAGE);
        }*/else {
            
            factura.setId_pedido(parseInt(txt_id_pedido.getText()));
            factura.setImpuesto(parseDouble(txt_impuesto.getText()));
            factura.setTotal(parseDouble(txt_total.getText()));
            factura.setSub_total(parseDouble(txt_subTotal.getText()));
            //factura.setId_mesa();
            //**************************/ID de cliente/*************************
            List<decClientes> clientes = clienteDao.findClientesEntities();
            for (decClientes unCliente : clientes) {
                String nombreCompleto = unCliente.getNombre() + " " + unCliente.getApellido();
                if (nombreCompleto.equals(txt_nombre_cliente.getText())) {
                    
                    //pedidos.setId_cliente(unCliente.getId_cliente());
                }
            }
            //**************************/ID de empleado/************************
            List<decEmpleado> empleados = empleadoDao.findclientesEntities();
            for (decEmpleado unEmpleado : empleados) {
                String nombreCompleto = unEmpleado.getNombre() + " " + unEmpleado.getApellido();
                if (nombreCompleto.equals(txt_nombre_cliente.getText())) {
                    factura.setId_empleado_cajero(unEmpleado.getId_empleado());
                }
            }
                factura.setId_mesa(1);
                factura.setId_tipo_pago(1);
            try{
                facturaDao.guardar(factura);
                JOptionPane.showMessageDialog(null, "Venta facturada.\nGenerando factura.", "Venta Realizad", 0);                              
            }catch(Exception ex){
                Logger.getLogger(jFrameFactura.class.getName()).log(Level.SEVERE, null, ex);                
            }
        }
        
        
        String fechaVenta = txt_fecha.getText();            
            //String idEmpleado = txt_empleado.getText();
            //int idpedido = Integer.parseInt(txt_id_pedido.getText());
                        
             
            
            //DATOS PAGO MIXTO
            if(cbb_tipoPago.getSelectedItem().equals("Efectivo"))
            {
                //txt_tarjeta. = "";
                                                               
            }else{
                 //txt_efectivo  y el de la tarjeta                             
            }
            
            if(cbb_tipoPago.getSelectedItem().equals("Tarjeta"))
            {
                //aqui tarjeta                
            }
            
                                             
                        
                                    
            
            //DETALLE DE factura            
            for(int i = 0; i < tbl_registros.getRowCount(); i++)
            {
                
            }                        
            imprimirFactura();
    }
    private void factura(){
        
    }
    private void comboBoxMesa() {
        cbb_mesa.removeAllItems();
        cbb_mesa.addItem("Seleccionar");
        List<decMesas> mesas = mesasDao.findMesasEntities();
        for (decMesas unMesa : mesas) {
            if (unMesa.getDesactivado() == 0 && unMesa.getId_mesa() != 1) {
                cbb_mesa.addItem(String.valueOf(unMesa.getId_mesa()));
            }
        }
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cbb_mesa;
    private javax.swing.JComboBox<String> cbb_mesa1;
    private javax.swing.JComboBox<String> cbb_tipoPago;
    private javax.swing.JCheckBox cbx_delivery;
    private javax.swing.JCheckBox cbx_delivery1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel lbl_puestos_trabajo;
    private javax.swing.JTable tbl_registros;
    private javax.swing.JTextField txt_efectivo;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_id_pedido;
    private javax.swing.JTextField txt_impuesto;
    private javax.swing.JTextField txt_mesero;
    private javax.swing.JTextField txt_nombre_cliente;
    private javax.swing.JTextField txt_subTotal;
    private javax.swing.JTextField txt_tarjeta;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
