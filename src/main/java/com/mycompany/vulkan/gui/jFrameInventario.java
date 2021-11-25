/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vulkan.gui;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import static java.lang.Integer.parseInt;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import com.mycompany.vulkan.validacion.valStringInt;
import vulkan.declaracion.decProductoAlmacen;
import vulkan.declaracion.decAlmacen;
import com.mycompany.controlador.controlProductoAlmacen;
import com.mycompany.controlador.controlAlmacen;
import com.mycompany.controlador.controlProductos;
import javax.swing.ImageIcon;
import vulkan.declaracion.decProducto;

/**
 * @author fer3dev
 */
public class jFrameInventario extends javax.swing.JFrame {

    controlProductoAlmacen productoAlmacenDao = new controlProductoAlmacen();
    controlAlmacen almacenDao = new controlAlmacen();
    controlProductos productoDao = new controlProductos();

    /**
     * Creates new form jFrameInventario
     */
    public jFrameInventario() {
        initComponents();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/logo1.png"));
        setIconImage(icon.getImage());
        setTitle("VK Restaurant");
        actualizar();
        updateCBB();
    }

    private void actualizar() {
        DefaultTableModel modelo = new DefaultTableModel();
        tbl_registros.setModel(modelo);
        modelo.addColumn("Nombre almacen");
        modelo.addColumn("Nombre producto");
        modelo.addColumn("Cantidad minima");
        modelo.addColumn("Cantidad maxima");
        modelo.addColumn("Cantidad actual");

        List<decProductoAlmacen> productoAlmacen = productoAlmacenDao.findProductoAlmacenEntities();

        for (decProductoAlmacen unProductoAlmacen : productoAlmacen) {
            if (unProductoAlmacen.getDesactivado() == 0) {
                modelo.addRow(
                        new Object[]{
                            almacenDao.findAlmacen(unProductoAlmacen.getId_almacen()).getNombre(),
                            productoDao.findclientes(unProductoAlmacen.getId_producto()).getNombre(),
                            unProductoAlmacen.getCantidad_minima(),
                            unProductoAlmacen.getCantidad_maxima(),
                            unProductoAlmacen.getCantidad_actual(),}
                );
            }
        }

    }

    private void updateCBB() {
        cbb_almacen.addItem("Seleccionar");
        List<decAlmacen> almacen = almacenDao.findAlmacenEntities();
        for (decAlmacen unAlmacen : almacen) {
            if (unAlmacen.getDesactivado() == 0) {
                cbb_almacen.addItem(unAlmacen.getNombre());
            }
        }

        cbb_producto.addItem("Seleccionar");
        List<decProducto> producto = productoDao.findclientesEntities();
        for (decProducto unProducto : producto) {
            if (unProducto.getDesactivado() == 0) {
                cbb_producto.addItem(unProducto.getNombre());
            }
        }
        btn_agregar.setEnabled(true);
        btn_modificar.setEnabled(false);
        btn_desactivar.setEnabled(false);
    }

    private void limpiar() {
        cbb_almacen.setSelectedItem("Seleccionar");
        cbb_producto.setSelectedItem("Seleccionar");
        txt_minima.setText("");
        txt_maxima.setText("");
        txt_actual.setText("");
        btn_agregar.setEnabled(true);
        btn_modificar.setEnabled(false);
        btn_desactivar.setEnabled(false);
    }

    private void limpiarTxt() {
        txt_actual.setText("");
        txt_minima.setText("");
        txt_maxima.setText("");
        btn_agregar.setEnabled(true);
        btn_modificar.setEnabled(false);
        btn_desactivar.setEnabled(false);
    }

    private void desactivar() {
        decProductoAlmacen productoAlmacen = new decProductoAlmacen();
        productoAlmacen.setCantidad_minima(0);
        productoAlmacen.setCantidad_maxima(0);
        productoAlmacen.setCantidad_actual(0);
        List<decAlmacen> almacen = almacenDao.findAlmacenEntities();
        for (decAlmacen unAlmacen : almacen) {
            if (unAlmacen.getNombre().equals(cbb_almacen.getSelectedItem().toString())) {
                productoAlmacen.setId_almacen(unAlmacen.getId_almacen());
            }
        }
        List<decProducto> producto = productoDao.findclientesEntities();
        for (decProducto unProducto : producto) {
            if (unProducto.getNombre().equals(cbb_producto.getSelectedItem().toString())) {
                productoAlmacen.setId_producto(unProducto.getid_producto());
            }
        }
        productoAlmacen.setDesactivado(1);

        try {
            productoAlmacenDao.edit(productoAlmacen);
        } catch (Exception ex) {
            Logger.getLogger(jFramePuesto.class.getName()).log(Level.SEVERE, null, ex);
        }
        limpiar();
        actualizar();
    }

    private void registrar() {
        decProductoAlmacen productoAlmacen = new decProductoAlmacen();
        if (cbb_almacen.getSelectedItem().toString().equals("Seleccionar")
                || cbb_producto.getSelectedItem().toString().equals("Seleccionar")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un almacén y un producto");
        } else if (txt_minima.getText().isEmpty()
                || txt_maxima.getText().isEmpty()
                || txt_actual.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe rellenar todos los campos de cantidades");
        } else if(Integer.valueOf(txt_minima.getText()) == 0
                || Integer.valueOf(txt_maxima.getText()) == 0
                || Integer.valueOf(txt_actual.getText()) == 0) {
            JOptionPane.showMessageDialog(this, "Ninguna cantidad puede ser 0");
        } else if(Integer.valueOf(txt_minima.getText()) >= Integer.valueOf(txt_maxima.getText())) {
            JOptionPane.showMessageDialog(this, "La cantidad mínima no puede ser mayor o igual a la máxima");
        }else if(Integer.valueOf(txt_actual.getText()) > Integer.valueOf(txt_maxima.getText())){
            JOptionPane.showMessageDialog(this, "La cantidad actual no puede ser mayor a la cantidad máxima");
        }else if(Integer.valueOf(txt_actual.getText()) < Integer.valueOf(txt_minima.getText())){
            JOptionPane.showMessageDialog(this, "La cantidad actual no puede ser menor a la cantidad minima");
        }
        else {
            JOptionPane.showMessageDialog(this, "Registrado");
            productoAlmacen.setCantidad_actual(parseInt(txt_actual.getText()));
            productoAlmacen.setCantidad_minima(parseInt(txt_minima.getText()));
            productoAlmacen.setCantidad_maxima(parseInt(txt_maxima.getText()));
            List<decAlmacen> almacen = almacenDao.findAlmacenEntities();
            for (decAlmacen unAlmacen : almacen) {
                if (unAlmacen.getNombre().equals(cbb_almacen.getSelectedItem().toString())) {
                    productoAlmacen.setId_almacen(unAlmacen.getId_almacen());
                }
            }
            List<decProducto> producto = productoDao.findclientesEntities();
            for (decProducto unProducto : producto) {
                if (unProducto.getNombre().equals(cbb_producto.getSelectedItem().toString())) {
                    productoAlmacen.setId_producto(unProducto.getid_producto());
                }
            }
            try {
                productoAlmacenDao.guardar(productoAlmacen);
            } catch (Exception ex) {
                Logger.getLogger(jFramePuesto.class.getName()).log(Level.SEVERE, null, ex);
            }
            limpiar();
            actualizar();
        }
    }

    private void registrarM() {
        decProductoAlmacen productoAlmacen = new decProductoAlmacen();
        if (cbb_almacen.getSelectedItem().toString().equals("Seleccionar")
                || cbb_producto.getSelectedItem().toString().equals("Seleccionar")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un almacén y un producto");
        } else if (txt_minima.getText().isEmpty()
                || txt_maxima.getText().isEmpty()
                || txt_actual.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe rellenar todos los campos de cantidades");
        } else if(Integer.valueOf(txt_minima.getText()) == 0
                || Integer.valueOf(txt_maxima.getText()) == 0
                || Integer.valueOf(txt_actual.getText()) == 0) {
            JOptionPane.showMessageDialog(this, "Ninguna cantidad puede ser 0");
        } else if(Integer.valueOf(txt_minima.getText()) >= Integer.valueOf(txt_maxima.getText())) {
            JOptionPane.showMessageDialog(this, "La cantidad mínima no puede ser mayor o igual a la máxima");
        }else if(Integer.valueOf(txt_actual.getText()) > Integer.valueOf(txt_maxima.getText())){
            JOptionPane.showMessageDialog(this, "La cantidad actual no puede ser mayor a la cantidad máxima");
        }else if(Integer.valueOf(txt_actual.getText()) < Integer.valueOf(txt_minima.getText())){
            JOptionPane.showMessageDialog(this, "La cantidad actual no puede ser menor a la cantidad minima");
        }
        else {
            JOptionPane.showMessageDialog(this, "Registro modificado correctamente");
            productoAlmacen.setCantidad_actual(parseInt(txt_actual.getText()));
            productoAlmacen.setCantidad_minima(parseInt(txt_minima.getText()));
            productoAlmacen.setCantidad_maxima(parseInt(txt_maxima.getText()));
            List<decAlmacen> almacen = almacenDao.findAlmacenEntities();
            for (decAlmacen unAlmacen : almacen) {
                if (unAlmacen.getNombre().equals(cbb_almacen.getSelectedItem().toString())) {
                    productoAlmacen.setId_almacen(unAlmacen.getId_almacen());
                }
            }
            List<decProducto> producto = productoDao.findclientesEntities();
            for (decProducto unProducto : producto) {
                if (unProducto.getNombre().equals(cbb_producto.getSelectedItem().toString())) {
                    productoAlmacen.setId_producto(unProducto.getid_producto());
                }
            }
            productoAlmacen.setDesactivado(0);
            try {
                productoAlmacenDao.edit(productoAlmacen);
            } catch (Exception ex) {
                Logger.getLogger(jFramePuesto.class.getName()).log(Level.SEVERE, null, ex);
            }
            limpiar();
            actualizar();
        }
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
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btn_limpiar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labelbug = new javax.swing.JLabel();
        cbb_producto = new javax.swing.JComboBox<>();
        txt_actual = new javax.swing.JTextField();
        txt_minima = new javax.swing.JTextField();
        txt_maxima = new javax.swing.JTextField();
        cbb_almacen = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_registros = new javax.swing.JTable();
        btn_update = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_desactivar = new javax.swing.JButton();
        btn_regresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
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
        lbl_puestos_trabajo.setText("Inventario");
        lbl_puestos_trabajo.setToolTipText("");
        jPanel4.add(lbl_puestos_trabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, -1));

        jPanel3.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Nombre de almacén");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar50.png"))); // NOI18N
        btn_limpiar.setPreferredSize(new java.awt.Dimension(50, 50));
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });
        jPanel6.add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, -1, -1));

        jLabel7.setText("Nombre de producto");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jLabel8.setText("Cantidad actual");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel9.setText("Cantidad mínima");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        labelbug.setText("Cantidad máxima");
        jPanel6.add(labelbug, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        cbb_producto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_productoItemStateChanged(evt);
            }
        });
        jPanel6.add(cbb_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 180, -1));

        txt_actual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_actualKeyTyped(evt);
            }
        });
        jPanel6.add(txt_actual, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 80, -1));

        txt_minima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_minimaKeyTyped(evt);
            }
        });
        jPanel6.add(txt_minima, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 80, -1));

        txt_maxima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_maximaKeyTyped(evt);
            }
        });
        jPanel6.add(txt_maxima, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 80, -1));

        cbb_almacen.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_almacenItemStateChanged(evt);
            }
        });
        jPanel6.add(cbb_almacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 180, -1));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 500, 240));

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
        tbl_registros.setSelectionBackground(new java.awt.Color(0, 255, 204));
        tbl_registros.setSelectionForeground(new java.awt.Color(204, 204, 255));
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
        btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Añadir1.png"))); // NOI18N
        btn_agregar.setPreferredSize(new java.awt.Dimension(150, 50));
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, -1, -1));

        btn_modificar.setBackground(new java.awt.Color(204, 204, 204));
        btn_modificar.setForeground(new java.awt.Color(0, 0, 255));
        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar1.png"))); // NOI18N
        btn_modificar.setPreferredSize(new java.awt.Dimension(150, 50));
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, -1, -1));

        btn_desactivar.setBackground(new java.awt.Color(204, 204, 204));
        btn_desactivar.setForeground(new java.awt.Color(0, 0, 255));
        btn_desactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Desactivar1.png"))); // NOI18N
        btn_desactivar.setPreferredSize(new java.awt.Dimension(150, 50));
        btn_desactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_desactivarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_desactivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 50, -1, -1));

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
        jPanel2.add(btn_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 50, -1, -1));

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
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_regresarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        limpiar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        actualizar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_updateActionPerformed

    private void txt_actualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_actualKeyTyped
        valStringInt valN = new valStringInt();
        valN.numeros(evt);
        if (txt_actual.getText().length() == 9) {
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_actualKeyTyped

    private void txt_minimaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_minimaKeyTyped
        valStringInt valN = new valStringInt();
        valN.numeros(evt);
        if (txt_actual.getText().length() == 9) {
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_minimaKeyTyped

    private void txt_maximaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_maximaKeyTyped
        valStringInt valN = new valStringInt();
        valN.numeros(evt);
        if (txt_actual.getText().length() == 9) {
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maximaKeyTyped

    private void btn_desactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_desactivarActionPerformed
        if (!cbb_almacen.getSelectedItem().equals("Seleccionar")
                && !cbb_producto.getSelectedItem().equals("Seleccionar")) {
            desactivar();
        } else {
            JOptionPane.showMessageDialog(this, "No selecciono ninguna combinacion a desactivar");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_desactivarActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        registrar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        if (!cbb_almacen.getSelectedItem().equals("Seleccionar")
                && !cbb_producto.getSelectedItem().equals("Seleccionar")) {
            registrarM();
        } else {
            JOptionPane.showMessageDialog(this, "No selecciono ninguna combinacion a modificar");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void cbb_almacenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_almacenItemStateChanged
        int encontrado = 0;
        if (!cbb_almacen.getSelectedItem().equals("Seleccionar")) {
            if (!cbb_producto.getSelectedItem().equals("Seleccionar")) {
                List<decProductoAlmacen> productoAlmacen = productoAlmacenDao.findProductoAlmacenEntities();
                for (decProductoAlmacen unProductoAlmacen : productoAlmacen) {
                    if (productoDao.findclientes(unProductoAlmacen.getId_producto()).getNombre().equals(cbb_producto.getSelectedItem().toString())
                            && almacenDao.findAlmacen(unProductoAlmacen.getId_almacen()).getNombre().equals(cbb_almacen.getSelectedItem().toString())) {
                        txt_actual.setText(String.valueOf(unProductoAlmacen.getCantidad_actual()));
                        txt_minima.setText(String.valueOf(unProductoAlmacen.getCantidad_minima()));
                        txt_maxima.setText(String.valueOf(unProductoAlmacen.getCantidad_maxima()));
                        btn_agregar.setEnabled(false);
                        btn_modificar.setEnabled(true);
                        btn_desactivar.setEnabled(true);
                        encontrado = 1;
                    }
                }
                if (encontrado == 0) {
                    limpiarTxt();
                }
            } else {
                limpiarTxt();
            }
        } else {
            limpiarTxt();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_almacenItemStateChanged

    private void cbb_productoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_productoItemStateChanged
        int encontrado = 0;
        if (!cbb_almacen.getSelectedItem().equals("Seleccionar")) {
            if (!cbb_producto.getSelectedItem().equals("Seleccionar")) {
                List<decProductoAlmacen> productoAlmacen = productoAlmacenDao.findProductoAlmacenEntities();
                for (decProductoAlmacen unProductoAlmacen : productoAlmacen) {
                    if (productoDao.findclientes(unProductoAlmacen.getId_producto()).getNombre().equals(cbb_producto.getSelectedItem().toString())
                            && almacenDao.findAlmacen(unProductoAlmacen.getId_almacen()).getNombre().equals(cbb_almacen.getSelectedItem().toString())) {
                        txt_actual.setText(String.valueOf(unProductoAlmacen.getCantidad_actual()));
                        txt_minima.setText(String.valueOf(unProductoAlmacen.getCantidad_minima()));
                        txt_maxima.setText(String.valueOf(unProductoAlmacen.getCantidad_maxima()));
                        btn_agregar.setEnabled(false);
                        btn_modificar.setEnabled(true);
                        btn_desactivar.setEnabled(true);
                        encontrado = 1;
                    }
                }
                if (encontrado == 0) {
                    limpiarTxt();
                }
            } else {
                limpiarTxt();
            }
        } else {
            limpiarTxt();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_productoItemStateChanged

    private void tbl_registrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_registrosMouseClicked
        int fila = tbl_registros.getSelectedRow();
        if (fila == -1) {

            JOptionPane.showMessageDialog(this, "Debe seleccionar una Fila");

        } else {
            btn_agregar.setEnabled(false);
            btn_modificar.setEnabled(true);
            btn_desactivar.setEnabled(true);
            
            txt_actual.setText(tbl_registros.getValueAt(fila, 4).toString());
            txt_minima.setText(tbl_registros.getValueAt(fila, 2).toString());
            txt_maxima.setText(tbl_registros.getValueAt(fila, 3).toString());
            cbb_almacen.setSelectedItem(tbl_registros.getValueAt(fila, 0).toString());
            cbb_producto.setSelectedItem(tbl_registros.getValueAt(fila, 1).toString());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_registrosMouseClicked

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
            java.util.logging.Logger.getLogger(jFrameInventario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrameInventario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrameInventario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrameInventario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFrameInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_desactivar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cbb_almacen;
    private javax.swing.JComboBox<String> cbb_producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JLabel labelbug;
    private javax.swing.JLabel lbl_puestos_trabajo;
    private javax.swing.JTable tbl_registros;
    private javax.swing.JTextField txt_actual;
    private javax.swing.JTextField txt_maxima;
    private javax.swing.JTextField txt_minima;
    // End of variables declaration//GEN-END:variables
}
