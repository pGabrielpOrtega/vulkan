/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.vulkan.gui;

import com.mycompany.vulkan.validacion.valString;
import com.mycompany.vulkan.validacion.valNumero;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.mycompany.controlador.controlMenu;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import vulkan.declaracion.decMenu;

/**
 *
 * @author gabri
 */
public class jFrameMenu extends javax.swing.JFrame {

    valString valS = new valString();
    valNumero valN = new valNumero();
    controlMenu menuDao = new controlMenu();
    decMenu menu = new decMenu();

    /**
     * Creates new form jFrameMenu
     */
    public jFrameMenu() {
        initComponents();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/logo1.png"));
        setIconImage(icon.getImage());
        setTitle("VK Restaurant");
        this.llenadoTabla();
    }

    private void llenadoTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        tbl_registros.setModel(modelo);
        modelo.addColumn("Id");
        modelo.addColumn("Nombre Plato");
        modelo.addColumn("precio");
        modelo.addColumn("Descripción");

        List<decMenu> puesto = menuDao.findclientesEntities();

        for (decMenu cliente : puesto) {
            if (cliente.getDesactivado() == 0) {
                modelo.addRow(
                        new Object[]{
                            cliente.getId_menu(),
                            cliente.getNombre(),
                            cliente.getPrecio(),
                            cliente.getDescripcion()
                        }
                );
            }
        }
        btn_modificar.setEnabled(false);
        btn_desactivar.setEnabled(false);
        btn_agregar.setEnabled(true);
    }

    private void limpiar() {
        txt_id_menu.setText("");
        txt_nombre.setText("");
        txt_precio.setText("");
        txt_descripcion.setText("");
        btn_agregar.setEnabled(true);
        btn_modificar.setEnabled(false);
        btn_desactivar.setEnabled(false);
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
        lbl_menu_restaurante = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbl_id_menu = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        lbl_nombre = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();
        lbl_precio = new javax.swing.JLabel();
        txt_id_menu = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_registros = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_desactivar = new javax.swing.JButton();
        btn_regresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

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
        jPanel4.setLayout(new java.awt.GridBagLayout());

        lbl_menu_restaurante.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lbl_menu_restaurante.setText("MENU DE RESTAURANTE");
        jPanel4.add(lbl_menu_restaurante, new java.awt.GridBagConstraints());

        jPanel3.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBackground(new java.awt.Color(244, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo2.png"))); // NOI18N
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 10, -1, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_id_menu.setText("ID de menu");
        jPanel6.add(lbl_id_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });
        jPanel6.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 220, -1));

        lbl_nombre.setText("Nombre");
        jPanel6.add(lbl_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        txt_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_precioKeyTyped(evt);
            }
        });
        jPanel6.add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 220, -1));

        lbl_precio.setText("Precio");
        jPanel6.add(lbl_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        txt_id_menu.setEditable(false);
        txt_id_menu.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.add(txt_id_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 90, -1));

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar50.png"))); // NOI18N
        btn_buscar.setPreferredSize(new java.awt.Dimension(50, 50));
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel6.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, -1, -1));

        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar50.png"))); // NOI18N
        btn_limpiar.setPreferredSize(new java.awt.Dimension(50, 50));
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });
        jPanel6.add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, -1, 50));

        txt_descripcion.setColumns(20);
        txt_descripcion.setRows(5);
        txt_descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_descripcionKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txt_descripcion);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        jLabel4.setText("Descripción");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 470, 220));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BackgroundRes.png"))); // NOI18N
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(244, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        tbl_registros.setGridColor(new java.awt.Color(0, 0, 0));
        tbl_registros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_registrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_registros);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1280, 310));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Actualizar1.png"))); // NOI18N
        jButton1.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BackgroundRes.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -250, -1, -1));

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        // TODO add your handling code here:
        int val = (int) Math.round(Double.valueOf(txt_precio.getText()));
        if (valString.tresKey(txt_nombre.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Error nombre puesto tiene menos de 3 letras");
        }else if(valString.tresLetrasRepetidas(txt_nombre.getText()) == false){
            JOptionPane.showMessageDialog(this, "Error nombre puesto 3 letras repetidas");
        }else if (valNumero.unoKey(txt_precio.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Error precio vacio");
        } else if (Double.parseDouble(txt_precio.getText()) <= 1) {
            JOptionPane.showMessageDialog(this, "Error numero menor a uno");
        }else if(valString.ochoKey(txt_descripcion.getText()) == false){
            JOptionPane.showMessageDialog(this, "Error descripción tiene menos de 8 letras");
        }else if(valString.tresLetrasRepetidas(txt_descripcion.getText()) == false){
            JOptionPane.showMessageDialog(this, "Error descripción 3 letras repetidas");
        } else {
            JOptionPane.showMessageDialog(this, "Menu editado correctamente");
            menu.setId_menu(parseInt(txt_id_menu.getText()));
            menu.setNombre(txt_nombre.getText());
            menu.setPrecio(Double.valueOf(txt_precio.getText()));
            menu.setDescripcion(txt_descripcion.getText());
            
            try {
                menuDao.edit(menu);
                limpiar();
                llenadoTabla();
            } catch (Exception ex) {
                Logger.getLogger(jFramePuesto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
        mainMenu menu = new mainMenu();
        this.dispose();
        menu.setVisible(true);

    }//GEN-LAST:event_btn_regresarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.llenadoTabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        // TODO add your handling code here:

        if (valString.tresKey(txt_nombre.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Error nombre puesto tiene menos de 3 letras");
        }else if(valString.tresLetrasRepetidas(txt_nombre.getText()) == false){
            JOptionPane.showMessageDialog(this, "Error nombre puesto 3 letras repetidas");
        }else if (valNumero.unoKey(txt_precio.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Error precio vacio");
        } else if (Double.parseDouble(txt_precio.getText()) < 1) {
            JOptionPane.showMessageDialog(this, "Error numero menor a uno");
        }else if(valString.tresKey(txt_descripcion.getText()) == false){
            JOptionPane.showMessageDialog(this, "Error descripción tiene menos de 3 letras");
        }else if(valString.tresLetrasRepetidas(txt_descripcion.getText()) == false){
            JOptionPane.showMessageDialog(this, "Error descripción 3 letras repetidas");
        }
        else {
            JOptionPane.showMessageDialog(this, "Registrado");
            menu.setNombre(txt_nombre.getText());
            menu.setPrecio(Double.valueOf(txt_precio.getText()));
            menu.setDescripcion(txt_descripcion.getText());
            try {
                menuDao.guardar(menu);
                limpiar();
                llenadoTabla();
            } catch (Exception ex) {
                Logger.getLogger(jFramePuesto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        // TODO add your handling code here:
        valS.letras(evt);
        valS.consumeMayor25(evt, txt_nombre.getText());
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void txt_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_precioKeyTyped
        // TODO add your handling code here:
        char n = evt.getKeyChar();
        
        // Permitir solo números y puntos
        if (!Character.isDigit(n) && n != KeyEvent.VK_PERIOD)
        {
            evt.consume(); 
            
            
        }
        
        // Máximo de carácteres
        if (txt_precio.getText().length() >= 8)
        {
            evt.consume();                
        }
    }//GEN-LAST:event_txt_precioKeyTyped

    private void tbl_registrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_registrosMouseClicked
        // TODO add your handling code here:
        int fila = tbl_registros.getSelectedRow();
        if (fila == -1) {

            JOptionPane.showMessageDialog(this, "Debe seleccionar una Fila");

        } else {
            btn_agregar.setEnabled(false);
            btn_modificar.setEnabled(true);
            btn_desactivar.setEnabled(true);
            txt_id_menu.setText(tbl_registros.getValueAt(fila, 0).toString());
            txt_nombre.setText(tbl_registros.getValueAt(fila, 1).toString());
            txt_precio.setText(tbl_registros.getValueAt(fila, 2).toString());
            txt_descripcion.setText(tbl_registros.getValueAt(fila, 3).toString());
        }
    }//GEN-LAST:event_tbl_registrosMouseClicked

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        String input = JOptionPane.showInputDialog("Ingrese el ID de el menu a buscar");
        System.out.println(input);
        try {
            parseInt(input);
            decMenu menuBuscar = menuDao.findclientes(parseInt(input));
            if (menuBuscar == null) {
                JOptionPane.showMessageDialog(this, "Menu no encontrado");
            } else if (menuBuscar.getDesactivado() == 1) {
                JOptionPane.showMessageDialog(this, "Menu está actualmente desactivado");
            } else {
                String idn = String.valueOf(menuBuscar.getId_menu());
                txt_id_menu.setText(idn);
                txt_nombre.setText(menuBuscar.getNombre());
                txt_precio.setText(String.valueOf(menuBuscar.getPrecio()));
                txt_descripcion.setText(menuBuscar.getDescripcion());
                btn_agregar.setEnabled(false);
                btn_modificar.setEnabled(true);
                btn_desactivar.setEnabled(true);
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

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        limpiar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_desactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_desactivarActionPerformed
        int val = (int) Math.round(Double.valueOf(txt_precio.getText()));
        if (valString.tresKey(txt_nombre.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Error nombre puesto tiene menos de 3 letras");
        } else if (valNumero.numMayorUno(val) == false) {
            JOptionPane.showMessageDialog(this, "Error numero menor a uno");
        } else {
            JOptionPane.showMessageDialog(this, "Menu desactivado correctamente");
            menu.setId_menu(parseInt(txt_id_menu.getText()));
            menu.setNombre(txt_nombre.getText());
            menu.setPrecio(Double.valueOf(txt_precio.getText()));
            menu.setDescripcion(txt_descripcion.getText());
            menu.setDesactivado(1);
            try {
                menuDao.edit(menu);
                limpiar();
                llenadoTabla();
            } catch (Exception ex) {
                Logger.getLogger(jFramePuesto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_desactivarActionPerformed

    private void txt_descripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descripcionKeyTyped
        // TODO add your handling code here:
        valS.letras(evt);
        valS.consumeMayor50(evt, txt_descripcion.getText());
    }//GEN-LAST:event_txt_descripcionKeyTyped

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
            java.util.logging.Logger.getLogger(jFrameMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrameMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrameMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrameMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFrameMenu().setVisible(true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_id_menu;
    private javax.swing.JLabel lbl_menu_restaurante;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_precio;
    private javax.swing.JTable tbl_registros;
    private javax.swing.JTextArea txt_descripcion;
    private javax.swing.JTextField txt_id_menu;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
}
