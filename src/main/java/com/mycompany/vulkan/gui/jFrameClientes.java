/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.vulkan.gui;

import javax.swing.table.DefaultTableModel;
import static java.lang.Integer.parseInt;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import com.mycompany.vulkan.validacion.valStringInt;
import com.mycompany.vulkan.validacion.valEmail;
import com.mycompany.vulkan.validacion.valNumero;
import vulkan.declaracion.decTipoDeDocumento;
import vulkan.declaracion.decClientes;
import com.mycompany.controlador.controlClientes;
import com.mycompany.controlador.controlTipoDeDocumento;
import com.mycompany.vulkan.validacion.valString;
import javax.swing.ImageIcon;

/**
 *
 * @author gabri
 */
public class jFrameClientes extends javax.swing.JFrame {

    controlClientes clientesDao = new controlClientes();
    controlTipoDeDocumento tipoDocumentoDao = new controlTipoDeDocumento();
    /**
     * Creates new form jFrameClientes
     */
    public jFrameClientes() {
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
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Telefono");
        modelo.addColumn("Email");
        modelo.addColumn("ID de documento");
        modelo.addColumn("Tipo de documento ");
        modelo.addColumn("Direccion");
        modelo.addColumn("Numero de Identidad");

        List<decClientes> clientes = clientesDao.findClientesEntities();

        for (decClientes unCliente : clientes) {
            if (unCliente.getDesactivado() == 0) {
                modelo.addRow(
                        new Object[]{
                            unCliente.getId_cliente(),
                            unCliente.getNombre(),
                            unCliente.getApellido(),
                            unCliente.getTelefono(),
                            unCliente.getEmail(),
                            //CAMBIAR CUANDO LA TABLA ESTE LISTA
                            unCliente.getId_tipo_documento(),
                            unCliente.getNombre_documento(),
                            unCliente.getDireccion(),
                            unCliente.getNumIdentidad_cliente(),
                            }
                );
            }
        }
        this.comboBoxTipoDoc();
        btn_modificar.setEnabled(false);
        btn_desactivar.setEnabled(false);
        btn_agregar.setEnabled(true);
    }
    
    private void updateCBB() {
        cbb_documento.addItem("Seleccionar");
        
        List<decTipoDeDocumento> tipoDocumento = tipoDocumentoDao.findclientesEntities();
        for (decTipoDeDocumento unTipo : tipoDocumento){
            if (unTipo.getDesactivado() == 0) {
                cbb_documento.addItem(String.valueOf(unTipo.getId_tipo_documento()));
            }
        }
    }

    private void limpiar() {
        txt_id.setText("");
        txt_nombre.setText("");
        txt_apellido.setText("");
        txt_telefono.setText("");
        txt_email.setText("");
        cbb_documento.setSelectedItem("Seleccionar");
        txt_id_documento.setText("");
        txt_direccion.setText("");
    }

    

    private void desactivar(int id) {
        decClientes clientes = new decClientes();
        clientes.setId_cliente(id);
        clientes.setNombre(txt_nombre.getText());
        clientes.setApellido(txt_apellido.getText());
        clientes.setTelefono(parseInt(txt_telefono.getText()));
        clientes.setEmail(txt_email.getText());
        clientes.setDireccion(txt_direccion.getText());
        //CAMBIAAR CUANDO LA TABLA ESTE LISTA
        clientes.setId_tipo_documento(1);
        clientes.setDesactivado(1);
        try {
            clientesDao.edit(clientes);
        } catch (Exception ex) {
            Logger.getLogger(jFramePuesto.class.getName()).log(Level.SEVERE, null, ex);
        }
        limpiar();
        actualizar();
    }

    private void registrar() {
        decClientes clientes = new decClientes();
        valEmail valE = new valEmail();
        if (cbb_documento.getSelectedItem().toString().equals("Seleccionar")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de documento");
        } else if (txt_nombre.getText().isEmpty()
                || txt_apellido.getText().isEmpty()
                || txt_telefono.getText().isEmpty()
                || txt_email.getText().isEmpty()
                || txt_id_documento.getText().isEmpty()
                || txt_direccion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe rellenar todos los campos");
        } else if(!valE.email(txt_email.getText())){
            JOptionPane.showMessageDialog(this, "Email debe seguir la forma \"direccion@dominio.com\"");
        }else if( (String.valueOf(txt_nombre_tipoDocumento.getText()).equalsIgnoreCase("DNI") 
                && ValidacionDNI(txt_id_documento.getText()) == false ) 
                || (String.valueOf(cbb_documento.getSelectedItem()).equalsIgnoreCase("identidad") 
                && ValidacionDNI(txt_id_documento.getText()) == false ) 
                || (String.valueOf(txt_nombre_tipoDocumento.getText()).equalsIgnoreCase("RTN") 
                && ValidacionRTN(txt_id_documento.getText())== false)
                || String.valueOf(cbb_documento.getSelectedItem()).equalsIgnoreCase("VISA")
                && Validacionvisa(txt_id_documento.getText())){
                
            JOptionPane.showMessageDialog(this, "Error Formato de identidad no aceptado");      
        }else {
            JOptionPane.showMessageDialog(this, "Registrado");
            clientes.setNombre(txt_nombre.getText());
            clientes.setApellido(txt_apellido.getText());
            clientes.setTelefono(parseInt(txt_telefono.getText()));
            clientes.setEmail(txt_email.getText());
            clientes.setDireccion(txt_direccion.getText());
            //CAMBIAAR CUANDO LA TABLA ESTE LISTA
            
            clientes.setNumIdentidad_cliente(txt_id_documento.getText());
            clientes.setId_tipo_documento(parseInt(cbb_documento.getSelectedItem().toString()));
            clientes.setNombre_documento(txt_nombre_tipoDocumento.getText());
            
            try {
                clientesDao.guardar(clientes);
            } catch (Exception ex) {
                Logger.getLogger(jFramePuesto.class.getName()).log(Level.SEVERE, null, ex);
            }
            limpiar();
            actualizar();
        }
    }

    private void registrar(int id) {
        decClientes clientes = new decClientes();
        valEmail valE = new valEmail();
        int a= 0;
        if(valNumero.unoKey(txt_telefono.getText())== false){
            
        }else{
            a = Integer.parseInt(txt_telefono.getText());
        }
        int b = Integer.parseInt(Integer.toString(a).substring(0, 1));
        if (cbb_documento.getSelectedItem().toString().equals("Seleccionar")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de documento");
        } else if (txt_nombre.getText().isEmpty()
                || txt_apellido.getText().isEmpty()
                || txt_telefono.getText().isEmpty()
                || txt_email.getText().isEmpty()
                || txt_id_documento.getText().isEmpty()
                || txt_direccion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe rellenar todos los campos");
        } else if(!valE.email(txt_email.getText())){
            JOptionPane.showMessageDialog(this, "Email debe seguir la forma \"direccion@dominio.com\"");
        }else if(valNumero.telefono(b)== false){
            JOptionPane.showMessageDialog(this, "Error numero no es igual a 2 7 8 9");
        }
        else {
            JOptionPane.showMessageDialog(this, "cliente modificado correctamente");
            clientes.setId_cliente(id);
            clientes.setNombre(txt_nombre.getText());
            clientes.setApellido(txt_apellido.getText());
            clientes.setTelefono(parseInt(txt_telefono.getText()));
            clientes.setEmail(txt_email.getText());
            clientes.setDireccion(txt_direccion.getText());
            //CAMBIAAR CUANDO LA TABLA ESTE LISTA
            clientes.setId_tipo_documento(parseInt(cbb_documento.getSelectedItem().toString()));
            clientes.setNombre_documento(txt_nombre_tipoDocumento.getText());
            clientes.setNumIdentidad_cliente(txt_id_documento.getText());
            try {
                clientesDao.edit(clientes);
            } catch (Exception ex) {
                Logger.getLogger(jFramePuesto.class.getName()).log(Level.SEVERE, null, ex);
            }
            limpiar();
            actualizar();
        }
    }
    private void comboBoxTipoDoc(){
        /*cbb_documento.removeAllItems();
        
        List<decTipoDeDocumento> mp = this.docDao.findclientesEntities();
        
        
        cbb_documento.addItem("Seleccionar");
        for(decTipoDeDocumento pes : mp)
        {
            if(pes.getDesactivado() <= 0){    
                String lista = pes.getNombre();
                cbb_documento.addItem(lista);
            }else{
                
            }
                
            
        }    */
         
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
        txt_id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_limpiar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_direccion = new javax.swing.JTextArea();
        txt_nombre = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_id_documento = new javax.swing.JTextField();
        cbb_documento = new javax.swing.JComboBox<>();
        txt_nombre_tipoDocumento = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
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
        lbl_puestos_trabajo.setText("Clientes");
        lbl_puestos_trabajo.setToolTipText("");
        jPanel4.add(lbl_puestos_trabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, -1));

        jPanel3.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("ID");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        txt_id.setEditable(false);
        txt_id.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 90, -1));

        jLabel5.setText("Nombre");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jLabel6.setText("Dirección");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, -1, -1));

        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar50.png"))); // NOI18N
        btn_limpiar.setPreferredSize(new java.awt.Dimension(50, 50));
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });
        jPanel6.add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 170, -1, -1));

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar50.png"))); // NOI18N
        btn_buscar.setPreferredSize(new java.awt.Dimension(50, 50));
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel6.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 110, -1, -1));

        jLabel7.setText("Apellido");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel8.setText("Teléfono");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel9.setText("Email");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel10.setText("Tipo de documento");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        txt_direccion.setColumns(20);
        txt_direccion.setRows(5);
        txt_direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_direccionKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txt_direccion);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, -1, -1));

        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });
        jPanel6.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 190, -1));

        txt_apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_apellidoKeyTyped(evt);
            }
        });
        jPanel6.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 190, -1));

        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyTyped(evt);
            }
        });
        jPanel6.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 190, -1));

        txt_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_emailKeyTyped(evt);
            }
        });
        jPanel6.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 190, -1));

        jLabel11.setText("ID de documento");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        txt_id_documento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_id_documentoKeyTyped(evt);
            }
        });
        jPanel6.add(txt_id_documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 220, -1));

        cbb_documento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_documentoItemStateChanged(evt);
            }
        });
        jPanel6.add(cbb_documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 100, -1));

        txt_nombre_tipoDocumento.setEditable(false);
        txt_nombre_tipoDocumento.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.add(txt_nombre_tipoDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 150, -1));

        jLabel12.setText("Nombre del documento");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, -1));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 850, 230));

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

    private void btn_desactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_desactivarActionPerformed
        if (!txt_id.getText().equals("")) {
            desactivar(parseInt(txt_id.getText()));
        } else {
            JOptionPane.showMessageDialog(this, "No selecciono ningún cliente a desactivar");
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
            JOptionPane.showMessageDialog(this, "No selecciono ningún cliente a modificar");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        actualizar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_updateActionPerformed

    private void tbl_registrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_registrosMouseClicked
        int row = tbl_registros.getSelectedRow();
        TableModel model = tbl_registros.getModel();
        btn_agregar.setEnabled(false);
        btn_modificar.setEnabled(true);
        btn_desactivar.setEnabled(true);
        txt_id.setText(model.getValueAt(row, 0).toString());
        txt_nombre.setText(model.getValueAt(row, 1).toString());
        txt_apellido.setText(model.getValueAt(row, 2).toString());
        txt_telefono.setText(model.getValueAt(row, 3).toString());
        txt_email.setText(model.getValueAt(row, 4).toString());
        //txt_nombre_tipoDocumento.setText(model.getValueAt(row, 6).toString());
        //ID DE DOCUMENTO CUANDO ESTE LISTA LA TABLA
        cbb_documento.setSelectedItem(model.getValueAt(row, 5).toString());
        txt_direccion.setText(model.getValueAt(row, 7).toString());
        // TODO add your handling code here:
        txt_id_documento.setText(model.getValueAt(row, 8).toString());
    }//GEN-LAST:event_tbl_registrosMouseClicked

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        valStringInt valS = new valStringInt();
        valS.letras(evt);
        if(txt_nombre.getText().length() == 15){
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void txt_apellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidoKeyTyped
        valStringInt valS = new valStringInt();
        valS.letras(evt);
        if(txt_apellido.getText().length() == 15){
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_apellidoKeyTyped

    private void txt_direccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_direccionKeyTyped
        valString valS = new valString();
        valS.letras(evt);
        if(txt_direccion.getText().length() == 50){
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_direccionKeyTyped

    private void txt_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonoKeyTyped
        valStringInt valS = new valStringInt();
        valS.numeros(evt);
        if(txt_telefono.getText().length() == 8){
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefonoKeyTyped

    private void txt_id_documentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_id_documentoKeyTyped
        valStringInt valS = new valStringInt();
        
        if(txt_id_documento.getText().length() == 15){
            evt.consume();
        }
        char c = evt.getKeyChar();
        String Texto = txt_id_documento.getText();
       
        //  if(CBox_TipoDoc=="Visa"){
         //   Validacionvisa();
          //   evt.consume(); 
        //}
        
        
        if((c < 'A' || c > 'Z') && (c < 'a' || c > 'z')&&(c < '0' || c > '9'))
        {
            evt.consume();                        
        }
        
        
        
        if((evt.getKeyChar() == 22))
        {
            txt_id_documento.setText(Texto.substring(0, 20));                    
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_documentoKeyTyped

    private void txt_emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emailKeyTyped
        if(txt_id_documento.getText().length() == 30){
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailKeyTyped

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        String input = JOptionPane.showInputDialog("Ingrese el ID del cliente a buscar");
        System.out.println(input);
        try {
            parseInt(input);
            decClientes clienteBuscar = clientesDao.findClientes(parseInt(input));
            if (clienteBuscar == null) {
                JOptionPane.showMessageDialog(this, "Cliente no encontrada");
            } else if (clienteBuscar.getDesactivado() == 1) {
                JOptionPane.showMessageDialog(this, "Cliente actualmente desactivada");
            } else {
                String idn = String.valueOf(clienteBuscar.getId_cliente());
                txt_id.setText(idn);
                txt_nombre.setText(clienteBuscar.getNombre());
                txt_apellido.setText(clienteBuscar.getApellido());
                txt_telefono.setText(String.valueOf(clienteBuscar.getTelefono()));
                txt_email.setText(clienteBuscar.getEmail());
                txt_direccion.setText(clienteBuscar.getDireccion());
                //ID DE DOCUMENTO CUANDO ESTE LISTA LA TABLA
                txt_id_documento.setText("50");
                cbb_documento.setSelectedItem("Identidad");
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

    private void cbb_documentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_documentoItemStateChanged
        // TODO add your handling code here:
        String input = cbb_documento.getSelectedItem().toString();
                //parseInt(cbb_mesas.getSelectedItem().toString()));
        
        try {
            parseInt(input);
            decTipoDeDocumento clienteBuscar = tipoDocumentoDao.findclientes(parseInt(input));
            if (clienteBuscar == null) {
                JOptionPane.showMessageDialog(this, "Cliente no encontrada");
            } else if (clienteBuscar.getDesactivado() == 1) {
                JOptionPane.showMessageDialog(this, "Cliente actualmente desactivado");
            } else {
                
                String name = String.valueOf(clienteBuscar.getNombre());
                String fna = name;
                txt_nombre_tipoDocumento.setText(fna);
            }
        } catch (Exception ex) {
            Logger.getLogger(jFramePuesto.class
                .getName()).log(Level.SEVERE, null, ex);
            if (input != null) {
                
            }
        }
    }//GEN-LAST:event_cbb_documentoItemStateChanged

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
            java.util.logging.Logger.getLogger(jFrameClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrameClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrameClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrameClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFrameClientes().setVisible(true);
            }
        });
    }
    
      public static boolean Validacionvisa(String Visa)
    {  
        
        return Visa.matches("[a-zA-Z]{2,}");               
    }
          
    public static boolean ValidacionDNI(String DNI){
        
        return DNI.matches("^[0-1]{1}[0-9]{12}$");
                
        }
       
    public static boolean ValidacionRTN(String RTN){
        
        return RTN.matches("^[0-1]{1}[0-9]{13}$");
                
        }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_desactivar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cbb_documento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_puestos_trabajo;
    private javax.swing.JTable tbl_registros;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextArea txt_direccion;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_id_documento;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nombre_tipoDocumento;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
