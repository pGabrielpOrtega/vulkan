/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vulkan.gui;

import javax.swing.table.DefaultTableModel;
import vulkan.declaracion.decMesas;
import com.mycompany.controlador.controlMesas;
import com.mycompany.vulkan.validacion.valString;
import static java.lang.Integer.parseInt;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 * @author fer3dev
 */
public class jFrameMesas extends javax.swing.JFrame {

    controlMesas mesasDao = new controlMesas();

    /**
     * Creates new form jFrameMesas
     */
    public jFrameMesas() {
        initComponents();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/logo1.png"));
        setIconImage(icon.getImage());
        setTitle("VK Restaurant");
        btn_modificar.setEnabled(false);
        btn_desactivar.setEnabled(false);
        btn_agregar.setEnabled(true);
        updateCBB();
        actualizar();
    }

    private void actualizar() {
        DefaultTableModel modelo = new DefaultTableModel();
        tbl_registros.setModel(modelo);
        modelo.addColumn("Id");
        modelo.addColumn("Cantidad de asientos");
        modelo.addColumn("Descripcion");

        List<decMesas> mesas = mesasDao.findMesasEntities();

        for (decMesas unMesa : mesas) {
            if (unMesa.getDesactivado() == 0) {
                modelo.addRow(
                        new Object[]{
                            unMesa.getId_mesa(),
                            unMesa.getCantidad(),
                            unMesa.getDescripcion(),}
                );
            }
        }

    }

    private void limpiar() {
        txt_id.setText("");
        txt_descripcion.setText("");
        cbb_cantidad.setSelectedItem("Seleccionar");
        btn_modificar.setEnabled(false);
        btn_desactivar.setEnabled(false);
        btn_agregar.setEnabled(true);
    }

    private void updateCBB() {
        cbb_cantidad.addItem("Seleccionar");
        cbb_cantidad.addItem("2");
        cbb_cantidad.addItem("4");
        cbb_cantidad.addItem("6");
    }

    private void desactivar(int id) {
        decMesas mesas = new decMesas();
        mesas.setId_mesa(id);
        mesas.setCantidad(parseInt(cbb_cantidad.getSelectedItem().toString()));
        mesas.setDescripcion(txt_descripcion.getText());
        mesas.setDesactivado(1);
        try {
            mesasDao.edit(mesas);
        } catch (Exception ex) {
            Logger.getLogger(jFramePuesto.class.getName()).log(Level.SEVERE, null, ex);
        }
        limpiar();
        actualizar();
    }

    private void registrar() {
        decMesas mesa = new decMesas();
        if (cbb_cantidad.getSelectedItem().toString().equals("Seleccionar")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una cantidad de asientos");
        } else if (txt_descripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una descripción");
        }else if(valString.ochoKey(txt_descripcion.getText())==false){
            JOptionPane.showMessageDialog(this, "Debe ingresar una descripción mayor a 8 letras");
        } else {
            JOptionPane.showMessageDialog(this, "Registrado");
            mesa.setDescripcion(txt_descripcion.getText());
            mesa.setCantidad(parseInt(cbb_cantidad.getSelectedItem().toString()));
            try {
                mesasDao.guardar(mesa);
            } catch (Exception ex) {
                Logger.getLogger(jFramePuesto.class.getName()).log(Level.SEVERE, null, ex);
            }
            limpiar();
            actualizar();
        }
    }

    private void registrar(int id) {
        decMesas mesa = new decMesas();
        if (cbb_cantidad.getSelectedItem().toString().equals("Seleccionar")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una cantidad de asientos");
        } else if (txt_descripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una descripción");
        } else {
            JOptionPane.showMessageDialog(this, "Mesa modificada correctamente");
            mesa.setId_mesa(id);
            mesa.setDescripcion(txt_descripcion.getText());
            mesa.setCantidad(parseInt(cbb_cantidad.getSelectedItem().toString()));
            try {
                mesasDao.edit(mesa);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        btn_limpiar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        cbb_cantidad = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();
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
        lbl_puestos_trabajo.setText("Mesas");
        jPanel4.add(lbl_puestos_trabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, -1));

        jPanel3.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("ID");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel5.setText("Descripción");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel6.setText("Cantidad de asientos");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        txt_id.setEditable(false);
        txt_id.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 90, -1));

        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar50.png"))); // NOI18N
        btn_limpiar.setPreferredSize(new java.awt.Dimension(50, 50));
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });
        jPanel6.add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, -1, -1));

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar50.png"))); // NOI18N
        btn_buscar.setPreferredSize(new java.awt.Dimension(50, 50));
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel6.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, -1, -1));

        jPanel6.add(cbb_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 160, -1));

        txt_descripcion.setColumns(20);
        txt_descripcion.setRows(5);
        txt_descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_descripcionKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txt_descripcion);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, -1, -1));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 530, 210));

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

    private void txt_descripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descripcionKeyTyped
        
        if (txt_descripcion.getText().length() == 50) {
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_descripcionKeyTyped

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        actualizar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        limpiar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        String input = JOptionPane.showInputDialog("Ingrese el ID de la mesa a buscar");
        System.out.println(input);
        try {
            parseInt(input);
            decMesas mesaBuscar = mesasDao.findMesas(parseInt(input));
            if (mesaBuscar == null) {
                JOptionPane.showMessageDialog(this, "Mesa no encontrada");
            } else if (mesaBuscar.getDesactivado() == 1) {
                JOptionPane.showMessageDialog(this, "Mesa actualmente desactivada");
            } else {
                String idn = String.valueOf(mesaBuscar.getId_mesa());
                txt_id.setText(idn);
                txt_descripcion.setText(mesaBuscar.getDescripcion());
                cbb_cantidad.setSelectedItem(String.valueOf(mesaBuscar.getCantidad()));
                btn_modificar.setEnabled(true);
                btn_desactivar.setEnabled(true);
                btn_agregar.setEnabled(false);
            }
        } catch (Exception ex) {
            Logger.getLogger(jFramePuesto.class
                    .getName()).log(Level.SEVERE, null, ex);
            if (input != null) {
                JOptionPane.showMessageDialog(this, "El ID solo puede contener números");
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_desactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_desactivarActionPerformed
        if (!txt_id.getText().equals("")) {
            desactivar(parseInt(txt_id.getText()));
        } else {
            JOptionPane.showMessageDialog(this, "No selecciono ninguna mesa a desactivar");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_desactivarActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        registrar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        if (!txt_id.getText().equals("")) {
            registrar(parseInt(txt_id.getText()));
        } else {
            JOptionPane.showMessageDialog(this, "No selecciono ninguna mesa a modificar");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void tbl_registrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_registrosMouseClicked
        int row = tbl_registros.getSelectedRow();
        TableModel model = tbl_registros.getModel();
        btn_modificar.setEnabled(true);
        btn_desactivar.setEnabled(true);
        btn_agregar.setEnabled(false);
        txt_id.setText(model.getValueAt(row, 0).toString());
        cbb_cantidad.setSelectedItem(model.getValueAt(row, 1).toString());
        txt_descripcion.setText(model.getValueAt(row, 2).toString());
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
            java.util.logging.Logger.getLogger(jFrameMesas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrameMesas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrameMesas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrameMesas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFrameMesas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_desactivar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cbb_cantidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_puestos_trabajo;
    private javax.swing.JTable tbl_registros;
    private javax.swing.JTextArea txt_descripcion;
    private javax.swing.JTextField txt_id;
    // End of variables declaration//GEN-END:variables
}
