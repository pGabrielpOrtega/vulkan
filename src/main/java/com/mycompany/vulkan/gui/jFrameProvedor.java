/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.vulkan.gui;

import com.mycompany.vulkan.validacion.valString;
import com.mycompany.vulkan.validacion.valNumero;
import vulkan.declaracion.decProveedores;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.mycompany.controlador.controlProvedores;
import com.mycompany.controlador.controlTipoDeDocumento;
import static com.mycompany.vulkan.gui.jFrameClientes.ValidacionDNI;
import static com.mycompany.vulkan.gui.jFrameClientes.ValidacionRTN;
import static com.mycompany.vulkan.gui.jFrameClientes.Validacionvisa;
import com.mycompany.vulkan.validacion.valEmail;
import com.mycompany.vulkan.validacion.valStringInt;
import static java.lang.Integer.parseInt;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.ImageIcon;
import vulkan.declaracion.decTipoDeDocumento;

/**
 *
 * @author gabri
 */
public class jFrameProvedor extends javax.swing.JFrame {

    valString valS = new valString();
    valNumero valN = new valNumero();
    controlProvedores provedorDao = new controlProvedores();
    decProveedores provedor = new decProveedores();
    controlTipoDeDocumento tipoDocumentoDao = new controlTipoDeDocumento();
    Boolean estado = true;

    /**
     * Creates new form jFrameMenu
     */
    public jFrameProvedor() {
        initComponents();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/logo1.png"));
        setIconImage(icon.getImage());
        setTitle("VK Restaurant");
        this.llenarTabla();
        comboBoxTipoDoc();
    }

    private void llenarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        tbl_registros.setModel(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Dirección");
        modelo.addColumn("Email");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Identificación");
        modelo.addColumn("Documento");
        modelo.addColumn("Estado");
        List<decProveedores> puesto = provedorDao.findclientesEntities();
        String estado = "";
        for (decProveedores cliente : puesto) {
            if (cliente.getDesactivado() == 0) {
                estado = "Activado";
            } else {
                estado = "Desactivado";
            }
            modelo.addRow(
                    new Object[]{
                        cliente.getid_proveedores(),
                        cliente.getNombre(),
                        cliente.getAppelido(),
                        cliente.getDireccion(),
                        cliente.getEmail(),
                        cliente.getTelefono(),
                        cliente.getIdnum_identificacion_empleado(),
                        cliente.getNombre_tipoDoc_empleado(),
                        estado,}
            );

        }
        btn_modificar.setEnabled(false);
        btn_desactivar.setEnabled(false);
        btn_agregar.setEnabled(true);
    }

    private void limpiar() {
        btn_modificar.setEnabled(false);
        btn_desactivar.setEnabled(false);
        btn_agregar.setEnabled(true);
        txt_id_area.setText("");
        txt_id_area.setText("");
        txt_nombre.setText("");
        txt_apellido.setText("");
        txt_direccion.setText("");
        txt_email.setText("");
        txt_telefono.setText("");
        txt_id_documento.setText("");
        cbb_documento.setSelectedItem("Seleccionar");
    }

    private void comboBoxTipoDoc() {
        cbb_documento.removeAllItems();
        cbb_documento.addItem("Seleccionar");

        List<decTipoDeDocumento> tipoDocumento = tipoDocumentoDao.findclientesEntities();
        for (decTipoDeDocumento unTipo : tipoDocumento) {
            if (unTipo.getDesactivado() == 0) {
                cbb_documento.addItem(String.valueOf(unTipo.getNombre()));
            }
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
        lbl_menu_restaurante = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_apellido = new javax.swing.JTextField();
        lbl_id_menu = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_id_area = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_direccion = new javax.swing.JTextArea();
        btn_buscar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        cbb_documento = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_id_documento = new javax.swing.JTextField();
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
        lbl_menu_restaurante.setText("Proveedores");
        jPanel4.add(lbl_menu_restaurante, new java.awt.GridBagConstraints());

        jPanel3.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBackground(new java.awt.Color(244, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo2.png"))); // NOI18N
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 10, -1, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Apellido");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel7.setText("Email");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });
        jPanel6.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 170, -1));

        jLabel6.setText("Nombre");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txt_apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_apellidoKeyTyped(evt);
            }
        });
        jPanel6.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 170, -1));

        lbl_id_menu.setText("ID");
        jPanel6.add(lbl_id_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyTyped(evt);
            }
        });
        jPanel6.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 170, -1));

        txt_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_emailKeyTyped(evt);
            }
        });
        jPanel6.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 170, -1));

        jLabel8.setText("Dirección");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, -1, -1));

        jLabel4.setText("Télefono");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txt_id_area.setEditable(false);
        txt_id_area.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.add(txt_id_area, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 90, -1));

        txt_direccion.setColumns(20);
        txt_direccion.setRows(5);
        txt_direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_direccionKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txt_direccion);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 240, 100));

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar50.png"))); // NOI18N
        btn_buscar.setPreferredSize(new java.awt.Dimension(50, 50));
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel6.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, -1, -1));

        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar50.png"))); // NOI18N
        btn_limpiar.setPreferredSize(new java.awt.Dimension(50, 50));
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });
        jPanel6.add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 170, -1, -1));

        cbb_documento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_documentoItemStateChanged(evt);
            }
        });
        jPanel6.add(cbb_documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 100, -1));

        jLabel10.setText("Tipo de documento");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, -1));

        jLabel11.setText("ID de documento");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, -1, -1));

        txt_id_documento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_id_documentoKeyTyped(evt);
            }
        });
        jPanel6.add(txt_id_documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 240, 30));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 730, 230));

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
        boolean email = false;
        int a = 0;
        if (valString.tresKey(txt_email.getText()) == false) {

        } else {
            email = valEmail.email(txt_email.getText());
        }

        a = Integer.parseInt(txt_telefono.getText());

        int b = Integer.parseInt(Integer.toString(a).substring(0, 1));

        if (valString.tresKey(txt_nombre.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Error nombre tiene menos de 3 letras");
        } else if (valString.tresKey(txt_direccion.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Error en direccion tiene menos de 3 caracteres");
        } else if (email == false) {
            JOptionPane.showMessageDialog(this, "email No valido");
        } else if (valString.tresKey(txt_apellido.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Error en descripcion tiene menos de 3 caracteres");
        } else if (valNumero.telefono(b) == false) {
            JOptionPane.showMessageDialog(this, "Error numero no es igual a 2 7 8 9");
        } else if (false) {
            JOptionPane.showMessageDialog(this, "Error puesto no esta seleccionado");
        } else {
            JOptionPane.showMessageDialog(this, "Proveedor editado con exito");
            provedor.setid_proveedores(parseInt(txt_id_area.getText()));
            provedor.setNombre(txt_nombre.getText());
            provedor.setAppelido(txt_apellido.getText());
            provedor.setTelefono(a);
            provedor.setEmail(txt_email.getText());
            provedor.setDireccion(txt_direccion.getText());
            provedor.setIdnum_identificacion_empleado(txt_id_documento.getText());
            provedor.setNombre_tipoDoc_empleado(cbb_documento.getSelectedItem().toString());
            try {
                provedorDao.edit(provedor);
                llenarTabla();
                limpiar();
            } catch (Exception ex) {
                Logger.getLogger(jFrameEmpleado.class.getName()).log(Level.SEVERE, null, ex);
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
        this.llenarTabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        // TODO add your handling code here:
        boolean email = false;
        int a = 0;
        if (valString.tresKey(txt_email.getText()) == false) {

        } else {
            email = valEmail.email(txt_email.getText());
        }
        if (valNumero.unoKey(txt_telefono.getText()) == false) {

        } else {
            a = Integer.parseInt(txt_telefono.getText());
        }

        int b = Integer.parseInt(Integer.toString(a).substring(0, 1));

        if (valString.tresKey(txt_nombre.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Error nombre tiene menos de 3 letras");
        } else if (valString.tresLetrasRepetidas(txt_nombre.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Error nombre tiene 3 letras repetidas");
        } else if (valString.tresKey(txt_direccion.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Error en dirección tiene menos de 3 caracteres");
        } else if (email == false) {
            JOptionPane.showMessageDialog(this, "email No valido");
        } else if (valString.tresKey(txt_apellido.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Error en apellido tiene menos de 3 caracteres");
        } else if (valNumero.telefono(b) == false) {
            JOptionPane.showMessageDialog(this, "Error numero no posee en su prinicipio a 2 7 8 9");
        } else if (valNumero.telefonoOcho(txt_telefono.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Error teléfono no posee 8 numeros");
        } else if (String.valueOf(cbb_documento.getSelectedItem()) == "Seleccionar") {
            JOptionPane.showMessageDialog(this, "Error documento no esta seleccionado");
        } else if ((String.valueOf(cbb_documento.getSelectedItem()).equalsIgnoreCase("DNI")
                && ValidacionDNI(txt_id_documento.getText()) == false)
                || (String.valueOf(cbb_documento.getSelectedItem()).equalsIgnoreCase("identidad")
                && ValidacionDNI(txt_id_documento.getText()) == false)
                || (String.valueOf(cbb_documento.getSelectedItem()).equalsIgnoreCase("RTN")
                && ValidacionRTN(txt_id_documento.getText()) == false)
                || String.valueOf(cbb_documento.getSelectedItem()).equalsIgnoreCase("VISA")
                && Validacionvisa(txt_id_documento.getText())) {

            JOptionPane.showMessageDialog(this, "Error Formato de identidad no aceptado");
        } else {
            JOptionPane.showMessageDialog(this, "Guardando");

            provedor.setNombre(txt_nombre.getText());
            provedor.setAppelido(txt_apellido.getText());
            provedor.setTelefono(a);
            provedor.setEmail(txt_email.getText());
            provedor.setDireccion(txt_direccion.getText());
            provedor.setIdnum_identificacion_empleado(txt_id_documento.getText());
            provedor.setNombre_tipoDoc_empleado(cbb_documento.getSelectedItem().toString());
            llenarTabla();
            try {
                provedorDao.guardar(provedor);
                llenarTabla();
                limpiar();
            } catch (Exception ex) {
                Logger.getLogger(jFrameEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_btn_agregarActionPerformed

    private void txt_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonoKeyTyped
        // TODO add your handling code here:
        valN.valKeyTypeNumeros(evt);
        valN.valKeyTypeNumeros(evt);
        if (txt_telefono.getText().length() == 8) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_telefonoKeyTyped

    private void tbl_registrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_registrosMouseClicked
        // TODO add your handling code here:
        int fila = tbl_registros.getSelectedRow();
        if (fila == -1) {

            JOptionPane.showMessageDialog(this, "Debe seleccionar una Fila");

        } else {
            btn_agregar.setEnabled(false);
            btn_modificar.setEnabled(true);
            btn_desactivar.setEnabled(true);
            String Id = tbl_registros.getValueAt(fila, 0).toString();
            String Nombre = tbl_registros.getValueAt(fila, 1).toString();
            String apellido = tbl_registros.getValueAt(fila, 2).toString();
            String direcion = tbl_registros.getValueAt(fila, 3).toString();
            String email = tbl_registros.getValueAt(fila, 4).toString();
            String telefono = tbl_registros.getValueAt(fila, 5).toString();
            String num = tbl_registros.getValueAt(fila, 6).toString();
            String documento = tbl_registros.getValueAt(fila, 7).toString();
            //String Activo = tbl_registros.getValueAt(fila, 6).toString();
            if (tbl_registros.getValueAt(fila, 8).toString().equals("Activado")) {
                btn_desactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Desactivar1.png")));
                this.estado = true;
            } else {
                btn_desactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Activar.png")));
                this.estado = false;
            }
            txt_id_area.setText(Id);
            txt_nombre.setText(Nombre);
            txt_apellido.setText(apellido);
            txt_direccion.setText(direcion);
            txt_email.setText(email);
            txt_telefono.setText(telefono);
            txt_id_documento.setText(num);
            cbb_documento.setSelectedItem(documento);
            //Txt_Activo.setText(Activo);

        }
    }//GEN-LAST:event_tbl_registrosMouseClicked

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        String input = JOptionPane.showInputDialog("Ingrese el nombre completo del proveedor a buscar");
        String nombre = "";
        String apellido = "";
        String[] inp = input.split(" ");
        limpiar();
        Boolean find = false;
        try {
            nombre = inp[0];
            apellido = inp[1];
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Debe ingresar 1 nombre y 1 apellido");
            find = true;
            Logger.getLogger(jFrameEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < tbl_registros.getRowCount(); i++) {//For each row
            if (tbl_registros.getModel().getValueAt(i, 1).equals(nombre)
                    && tbl_registros.getModel().getValueAt(i, 2).equals(apellido)) {//Search the model
                txt_id_area.setText(tbl_registros.getModel().getValueAt(i, 0).toString());
                txt_nombre.setText(tbl_registros.getModel().getValueAt(i, 1).toString());
                txt_apellido.setText(tbl_registros.getModel().getValueAt(i, 2).toString());
                txt_direccion.setText(tbl_registros.getModel().getValueAt(i, 3).toString());
                txt_email.setText(tbl_registros.getModel().getValueAt(i, 4).toString());
                txt_telefono.setText(tbl_registros.getModel().getValueAt(i, 5).toString());
                cbb_documento.setSelectedItem(tbl_registros.getModel().getValueAt(i, 7).toString());
                txt_id_documento.setText(tbl_registros.getModel().getValueAt(i, 6).toString());
                if (tbl_registros.getModel().getValueAt(i, 8).equals("Activado")) {
                    btn_desactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Desactivar1.png")));
                    this.estado = true;
                } else {
                    btn_desactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Activar.png")));
                    this.estado = false;
                }
                btn_agregar.setEnabled(false);
                btn_modificar.setEnabled(true);
                btn_desactivar.setEnabled(true);
                find = true;
            }
        }//For loop outer
        if (!find) {
            JOptionPane.showMessageDialog(this, "Usuario no encontrado");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        limpiar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_desactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_desactivarActionPerformed
        boolean email = false;
        int a = 0;
        if (valString.tresKey(txt_email.getText()) == false) {

        } else {
            email = valEmail.email(txt_email.getText());
        }

        a = Integer.parseInt(txt_telefono.getText());

        int b = Integer.parseInt(Integer.toString(a).substring(0, 1));

        if (valString.tresKey(txt_nombre.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Error nombre tiene menos de 3 letras");
        } else if (valString.tresKey(txt_direccion.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Error en direccion tiene menos de 3 caracteres");
        } else if (email == false) {
            JOptionPane.showMessageDialog(this, "email No valido");
        } else if (valString.tresKey(txt_apellido.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Error en descripcion tiene menos de 3 caracteres");
        } else if (valNumero.telefono(b) == false) {
            JOptionPane.showMessageDialog(this, "Error numero no es igual a 2 7 8 9");
        } else if (false) {
            JOptionPane.showMessageDialog(this, "Error puesto no esta seleccionado");
        } else {
            //JOptionPane.showMessageDialog(this, "Proveedor editado con exito");
            provedor.setid_proveedores(parseInt(txt_id_area.getText()));
            provedor.setNombre(txt_nombre.getText());
            provedor.setAppelido(txt_apellido.getText());
            provedor.setTelefono(a);
            provedor.setEmail(txt_email.getText());
            provedor.setDireccion(txt_direccion.getText());
            provedor.setIdnum_identificacion_empleado(txt_id_documento.getText().toString());
            provedor.setNombre_tipoDoc_empleado(cbb_documento.getSelectedItem().toString());
            if (this.estado) {
                provedor.setDesactivado(1);
            } else {
                provedor.setDesactivado(0);
            }

            try {
                provedorDao.edit(provedor);
                llenarTabla();
                limpiar();
            } catch (Exception ex) {
                Logger.getLogger(jFrameEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_desactivarActionPerformed

    private void cbb_documentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_documentoItemStateChanged
        // TODO add your handling code here:
        String input = cbb_documento.getSelectedItem().toString();
        //parseInt(cbb_mesas.getSelectedItem().toString()));
        /*
        try {
            parseInt(input);
            decTipoDeDocumento clienteBuscar = tipoDocumentoDao.findclientes(parseInt(input));
            if (clienteBuscar == null) {
                JOptionPane.showMessageDialog(this, "Documento no encontrada");
            } else if (clienteBuscar.getDesactivado() == 1) {
                JOptionPane.showMessageDialog(this, "Documento actualmente desactivado");
            } else {

                String name = String.valueOf(clienteBuscar.getNombre());
                //String fna = name;
                //txt_nombre_tipoDocumento.setText(fna);
            }
        } catch (Exception ex) {
            Logger.getLogger(jFramePuesto.class
                    .getName()).log(Level.SEVERE, null, ex);
            if (input != null) {

            }
        }*/
    }//GEN-LAST:event_cbb_documentoItemStateChanged

    private void txt_id_documentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_id_documentoKeyTyped
        valStringInt valS = new valStringInt();

        if (txt_id_documento.getText().length() == 15) {
            evt.consume();
        }
        char c = evt.getKeyChar();
        String Texto = txt_id_documento.getText();

        //  if(CBox_TipoDoc=="Visa"){
        //   Validacionvisa();
        //   evt.consume();
        //}
        if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && (c < '0' || c > '9')) {
            evt.consume();
        }

        if ((evt.getKeyChar() == 22)) {
            txt_id_documento.setText(Texto.substring(0, 20));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_documentoKeyTyped

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        // TODO add your handling code here:
        valS.letras(evt);
        valS.consumeMayor25(evt, txt_nombre.getText());
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void txt_apellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidoKeyTyped
        // TODO add your handling code here:
        valS.letras(evt);
        valS.consumeMayor25(evt, txt_nombre.getText());
    }//GEN-LAST:event_txt_apellidoKeyTyped

    private void txt_emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emailKeyTyped
        // TODO add your handling code here:
        valS.letras(evt);
        valS.consumeMayor25(evt, txt_nombre.getText());
    }//GEN-LAST:event_txt_emailKeyTyped

    private void txt_direccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_direccionKeyTyped
        // TODO add your handling code here:
        valS.letras(evt);
        valS.consumeMayor50(evt, txt_nombre.getText());
    }//GEN-LAST:event_txt_direccionKeyTyped

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
            java.util.logging.Logger.getLogger(jFrameProvedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrameProvedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrameProvedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrameProvedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFrameProvedor().setVisible(true);
            }
        });
    }

    private static int GetIdTipoDocumento(String Nombre) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("base_datos_mysql");
        EntityManager em = emf.createEntityManager();
        String select = "select id_tipo_documento from decTipoDeDocumento where nombre = '" + Nombre + "'";
        Query query = em.createQuery(select);

        return Integer.parseInt(query.getSingleResult().toString());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_desactivar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JComboBox<String> cbb_documento;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_id_menu;
    private javax.swing.JLabel lbl_menu_restaurante;
    private javax.swing.JTable tbl_registros;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextArea txt_direccion;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_id_area;
    private javax.swing.JTextField txt_id_documento;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
