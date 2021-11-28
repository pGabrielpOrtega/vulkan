/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.vulkan.gui;

import javax.swing.ImageIcon;

/**
 *
 * @author gabri
 */
public class mainMenu extends javax.swing.JFrame {
    
    
    /**
     * Creates new form mainMenu
     */
    public mainMenu() {
        initComponents();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/logo1.png"));
        setIconImage(icon.getImage());
        setTitle("VK Restaurant");
        btn_pedidos.setEnabled(true);  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JPanel();
        lbl_titulo = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btn_clientes = new javax.swing.JButton();
        btn_empleados = new javax.swing.JButton();
        btn_proveedores = new javax.swing.JButton();
        btn_inventario = new javax.swing.JButton();
        btn_factura = new javax.swing.JButton();
        btn_mesas = new javax.swing.JButton();
        btn_reservaciones = new javax.swing.JButton();
        btn_historial_precios = new javax.swing.JButton();
        btn_tipo_documento = new javax.swing.JButton();
        btn_menu = new javax.swing.JButton();
        btn_cerrar_sesion = new javax.swing.JButton();
        btn_pedidos = new javax.swing.JButton();
        btn_Puesto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn_usuario = new javax.swing.JButton();
        btn_sueldos = new javax.swing.JButton();
        btn_productos = new javax.swing.JButton();
        btn_tipopago = new javax.swing.JButton();
        btn_almacen = new javax.swing.JButton();
        btn_ingredientes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setBackground(new java.awt.Color(255, 255, 255));
        titulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        titulo.setLayout(new java.awt.GridBagLayout());

        lbl_titulo.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lbl_titulo.setForeground(new java.awt.Color(0, 0, 0));
        lbl_titulo.setText("MENU PRINCIPAL");
        titulo.add(lbl_titulo, new java.awt.GridBagConstraints());

        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 80));

        menu.setBackground(new java.awt.Color(244, 255, 255));
        menu.setPreferredSize(new java.awt.Dimension(1280, 720));
        menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setPreferredSize(new java.awt.Dimension(1100, 400));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_clientes.setBackground(new java.awt.Color(204, 204, 204));
        btn_clientes.setForeground(new java.awt.Color(0, 0, 255));
        btn_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clientes.png"))); // NOI18N
        btn_clientes.setPreferredSize(new java.awt.Dimension(300, 50));
        btn_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clientesActionPerformed(evt);
            }
        });
        jPanel4.add(btn_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 300, 50));

        btn_empleados.setBackground(new java.awt.Color(204, 204, 204));
        btn_empleados.setForeground(new java.awt.Color(0, 0, 255));
        btn_empleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/empleado.png"))); // NOI18N
        btn_empleados.setPreferredSize(new java.awt.Dimension(300, 50));
        btn_empleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_empleadosActionPerformed(evt);
            }
        });
        jPanel4.add(btn_empleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 300, 50));

        btn_proveedores.setBackground(new java.awt.Color(204, 204, 204));
        btn_proveedores.setForeground(new java.awt.Color(0, 0, 255));
        btn_proveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/proveedores.png"))); // NOI18N
        btn_proveedores.setPreferredSize(new java.awt.Dimension(300, 50));
        btn_proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_proveedoresActionPerformed(evt);
            }
        });
        jPanel4.add(btn_proveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, 300, 50));

        btn_inventario.setBackground(new java.awt.Color(204, 204, 204));
        btn_inventario.setForeground(new java.awt.Color(0, 0, 255));
        btn_inventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inventario.png"))); // NOI18N
        btn_inventario.setPreferredSize(new java.awt.Dimension(300, 50));
        btn_inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inventarioActionPerformed(evt);
            }
        });
        jPanel4.add(btn_inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, 300, 50));

        btn_factura.setBackground(new java.awt.Color(204, 204, 204));
        btn_factura.setForeground(new java.awt.Color(0, 0, 255));
        btn_factura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/factura.png"))); // NOI18N
        btn_factura.setEnabled(false);
        btn_factura.setPreferredSize(new java.awt.Dimension(300, 50));
        btn_factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_facturaActionPerformed(evt);
            }
        });
        jPanel4.add(btn_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 300, 50));

        btn_mesas.setBackground(new java.awt.Color(204, 204, 204));
        btn_mesas.setForeground(new java.awt.Color(0, 0, 255));
        btn_mesas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mesas.png"))); // NOI18N
        btn_mesas.setPreferredSize(new java.awt.Dimension(300, 50));
        btn_mesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mesasActionPerformed(evt);
            }
        });
        jPanel4.add(btn_mesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 300, -1));

        btn_reservaciones.setBackground(new java.awt.Color(204, 204, 204));
        btn_reservaciones.setForeground(new java.awt.Color(0, 0, 255));
        btn_reservaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reservaciones.png"))); // NOI18N
        btn_reservaciones.setPreferredSize(new java.awt.Dimension(300, 50));
        btn_reservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reservacionesActionPerformed(evt);
            }
        });
        jPanel4.add(btn_reservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 300, 50));

        btn_historial_precios.setBackground(new java.awt.Color(204, 204, 204));
        btn_historial_precios.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btn_historial_precios.setForeground(new java.awt.Color(0, 0, 255));
        btn_historial_precios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/historial-precios.png"))); // NOI18N
        btn_historial_precios.setPreferredSize(new java.awt.Dimension(300, 50));
        btn_historial_precios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_historial_preciosActionPerformed(evt);
            }
        });
        jPanel4.add(btn_historial_precios, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 300, 50));

        btn_tipo_documento.setBackground(new java.awt.Color(204, 204, 204));
        btn_tipo_documento.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btn_tipo_documento.setForeground(new java.awt.Color(0, 0, 255));
        btn_tipo_documento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tipos-de-documento.png"))); // NOI18N
        btn_tipo_documento.setPreferredSize(new java.awt.Dimension(300, 50));
        btn_tipo_documento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tipo_documentoActionPerformed(evt);
            }
        });
        jPanel4.add(btn_tipo_documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 300, 50));

        btn_menu.setBackground(new java.awt.Color(204, 204, 204));
        btn_menu.setForeground(new java.awt.Color(0, 0, 255));
        btn_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menu.png"))); // NOI18N
        btn_menu.setPreferredSize(new java.awt.Dimension(300, 50));
        btn_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menuActionPerformed(evt);
            }
        });
        jPanel4.add(btn_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 300, -1));

        btn_cerrar_sesion.setBackground(new java.awt.Color(204, 204, 204));
        btn_cerrar_sesion.setForeground(new java.awt.Color(255, 0, 51));
        btn_cerrar_sesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logout.png"))); // NOI18N
        btn_cerrar_sesion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));
        btn_cerrar_sesion.setPreferredSize(new java.awt.Dimension(50, 50));
        btn_cerrar_sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrar_sesionActionPerformed(evt);
            }
        });
        jPanel4.add(btn_cerrar_sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, -1, -1));

        btn_pedidos.setBackground(new java.awt.Color(204, 204, 204));
        btn_pedidos.setForeground(new java.awt.Color(0, 0, 255));
        btn_pedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pedidos.png"))); // NOI18N
        btn_pedidos.setEnabled(false);
        btn_pedidos.setPreferredSize(new java.awt.Dimension(300, 50));
        btn_pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pedidosActionPerformed(evt);
            }
        });
        jPanel4.add(btn_pedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, -1, -1));

        btn_Puesto.setBackground(new java.awt.Color(204, 204, 204));
        btn_Puesto.setForeground(new java.awt.Color(0, 0, 255));
        btn_Puesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tipo puesto.png"))); // NOI18N
        btn_Puesto.setPreferredSize(new java.awt.Dimension(300, 50));
        btn_Puesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PuestoActionPerformed(evt);
            }
        });
        jPanel4.add(btn_Puesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo2.png"))); // NOI18N
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 330, 100, 90));

        btn_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuarios.png"))); // NOI18N
        btn_usuario.setPreferredSize(new java.awt.Dimension(300, 50));
        btn_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_usuarioActionPerformed(evt);
            }
        });
        jPanel4.add(btn_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btn_sueldos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salario.png"))); // NOI18N
        btn_sueldos.setEnabled(false);
        btn_sueldos.setPreferredSize(new java.awt.Dimension(300, 50));
        btn_sueldos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sueldosActionPerformed(evt);
            }
        });
        jPanel4.add(btn_sueldos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        btn_productos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/productos.png"))); // NOI18N
        btn_productos.setPreferredSize(new java.awt.Dimension(300, 50));
        btn_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_productosActionPerformed(evt);
            }
        });
        jPanel4.add(btn_productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, -1, -1));

        btn_tipopago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/TiposPago.png"))); // NOI18N
        btn_tipopago.setPreferredSize(new java.awt.Dimension(300, 50));
        btn_tipopago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tipopagoActionPerformed(evt);
            }
        });
        jPanel4.add(btn_tipopago, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        btn_almacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/almacen.png"))); // NOI18N
        btn_almacen.setPreferredSize(new java.awt.Dimension(300, 50));
        btn_almacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_almacenActionPerformed(evt);
            }
        });
        jPanel4.add(btn_almacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, -1, -1));

        btn_ingredientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ingredientes.png"))); // NOI18N
        btn_ingredientes.setEnabled(false);
        btn_ingredientes.setPreferredSize(new java.awt.Dimension(300, 50));
        jPanel4.add(btn_ingredientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, -1));

        menu.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 1060, 430));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BackgroundRes.png"))); // NOI18N
        menu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -80, -1, -1));

        getContentPane().add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1280, 640));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clientesActionPerformed
        jFrameClientes frameClientes = new jFrameClientes();
        this.dispose();
        frameClientes.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_clientesActionPerformed

    private void btn_mesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mesasActionPerformed
        jFrameMesas frameMesas = new jFrameMesas();
        this.dispose();
        frameMesas.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_mesasActionPerformed

    private void btn_tipo_documentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tipo_documentoActionPerformed
        jFrameTipoDocumento frameDocumento = new jFrameTipoDocumento();
        this.dispose();
        frameDocumento.setVisible(true);
        // TODO add your handling code here:       
    }//GEN-LAST:event_btn_tipo_documentoActionPerformed

    private void btn_PuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PuestoActionPerformed
        jFramePuesto framePuesto = new jFramePuesto();
        this.dispose();
        framePuesto.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_PuestoActionPerformed

    private void btn_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuActionPerformed
        jFrameMenu frameMenu = new jFrameMenu();
        this.dispose();
        frameMenu.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_menuActionPerformed

    private void btn_empleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_empleadosActionPerformed
        jFrameEmpleado frameEmpleado = new jFrameEmpleado();
        this.dispose();
        frameEmpleado.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_empleadosActionPerformed

    private void btn_cerrar_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrar_sesionActionPerformed
        inicio cerrarSesion = new inicio();
        this.dispose();
        cerrarSesion.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cerrar_sesionActionPerformed

    private void btn_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_usuarioActionPerformed
        jFrameUsuario frameUsuario = new jFrameUsuario();
        this.dispose();
        frameUsuario.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_usuarioActionPerformed

    private void btn_inventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inventarioActionPerformed
        jFrameInventario frameAlmacen = new jFrameInventario();
        this.dispose();
        frameAlmacen.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_inventarioActionPerformed

    private void btn_proveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_proveedoresActionPerformed
        jFrameProvedor frameProveedores = new jFrameProvedor();
        this.dispose();
        frameProveedores.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_proveedoresActionPerformed

    private void btn_historial_preciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_historial_preciosActionPerformed
        jFramePrecioHistorial framePrecioHistorial = new jFramePrecioHistorial();
        this.dispose();
        framePrecioHistorial.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_historial_preciosActionPerformed

    private void btn_pedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pedidosActionPerformed
        jFramePedidos framePedidos = new jFramePedidos();
        this.dispose();
        framePedidos.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_pedidosActionPerformed

    private void btn_reservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reservacionesActionPerformed
        jFrameReservaciones frameReservaciones = new jFrameReservaciones();
        this.dispose();
        frameReservaciones.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_reservacionesActionPerformed

    private void btn_facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_facturaActionPerformed
        jFrameFactura frameFactura = new jFrameFactura();
        this.dispose();
        frameFactura.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_facturaActionPerformed

    private void btn_sueldosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sueldosActionPerformed
        jFrameSueldos frameSueldos = new jFrameSueldos();
        this.dispose();
        frameSueldos.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_sueldosActionPerformed

    private void btn_tipopagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tipopagoActionPerformed
        jFrameTipoPago frameTipoPago = new jFrameTipoPago();
        this.dispose();
        frameTipoPago.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tipopagoActionPerformed

    private void btn_productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_productosActionPerformed
        jFrameProductos frameProductos = new jFrameProductos();
        this.dispose();
        frameProductos.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_productosActionPerformed

    private void btn_almacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_almacenActionPerformed
        jFrameAlmacen frameAlmacen = new jFrameAlmacen();
        this.dispose();
        frameAlmacen.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_almacenActionPerformed

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
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Puesto;
    private javax.swing.JButton btn_almacen;
    private javax.swing.JButton btn_cerrar_sesion;
    private javax.swing.JButton btn_clientes;
    private javax.swing.JButton btn_empleados;
    private javax.swing.JButton btn_factura;
    private javax.swing.JButton btn_historial_precios;
    private javax.swing.JButton btn_ingredientes;
    private javax.swing.JButton btn_inventario;
    private javax.swing.JButton btn_menu;
    private javax.swing.JButton btn_mesas;
    private javax.swing.JButton btn_pedidos;
    private javax.swing.JButton btn_productos;
    private javax.swing.JButton btn_proveedores;
    private javax.swing.JButton btn_reservaciones;
    private javax.swing.JButton btn_sueldos;
    private javax.swing.JButton btn_tipo_documento;
    private javax.swing.JButton btn_tipopago;
    private javax.swing.JButton btn_usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel titulo;
    // End of variables declaration//GEN-END:variables
}
