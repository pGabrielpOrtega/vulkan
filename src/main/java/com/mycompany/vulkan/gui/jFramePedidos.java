/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vulkan.gui;

import com.mycompany.vulkan.validacion.valNumero;
import com.mycompany.vulkan.validacion.valString;
import com.mycompany.vulkan.validacion.fechaActual;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import static java.lang.Integer.parseInt;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.awt.Color;
import java.sql.Timestamp;
import javax.swing.ImageIcon;

import java.text.DateFormat;
import java.text.ParseException;
import com.mycompany.controlador.controlClientes;
import com.mycompany.controlador.controlEmpleado;
import com.mycompany.controlador.controlMenu;
import com.mycompany.controlador.controlMesas;
import com.mycompany.controlador.controlPedidos;
import com.mycompany.controlador.controlMenu_pedido;
import static java.lang.Double.parseDouble;
import vulkan.declaracion.decClientes;
import vulkan.declaracion.decEmpleado;
import vulkan.declaracion.decMesas;
import vulkan.declaracion.decPedidos;
import vulkan.declaracion.decMenu;
import vulkan.declaracion.decMenu_pedido;
import vulkan.declaracion.decUsuario;

/**
 * @author fer3dev
 */
public class jFramePedidos extends javax.swing.JFrame {

    ;
    controlMesas mesasDao = new controlMesas();
    controlMenu menu = new controlMenu();
    controlEmpleado empleadoDao = new controlEmpleado();
    controlPedidos pedidosDao = new controlPedidos();
    controlMenu menuDao = new controlMenu();
    controlMenu_pedido menuPedidoDao = new controlMenu_pedido();

    valString valS = new valString();
    valNumero valN = new valNumero();
    fechaActual fechactual = new fechaActual();

    private decUsuario usuarios = new decUsuario();

    static String nombrePlatilloTest;
    static String precioPlatilloTest;
    static String idPlatilloTest;
    DefaultTableModel modeloMenu = new DefaultTableModel();
    controlClientes clienteDao = new controlClientes();

    boolean state = true;

    /**
     * Creates new form jFramePlantilla
     */
    public jFramePedidos() {
        initComponents();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/logo1.png"));
        setIconImage(icon.getImage());
        setTitle("VK Restaurant");
        this.llenarTabla();
        this.comboBoxMesero();
        this.comboBoxMesa();
        this.llenarMenu();
        cbb_mesero.setEnabled(false);
        cbb_mesa.setEnabled(false);
    }

    private void comboBoxMesero() {
        cbb_mesero.removeAllItems();
        cbb_mesero.addItem("Seleccionar");

        List<decEmpleado> mp = this.empleadoDao.findclientesEntities();
        for (decEmpleado unTipo : mp) {
            if (unTipo.getDesactivado() == 0) {
                if (unTipo.getEmpleadoNombre_puesto().equals("Mesero")) {
                    cbb_mesero.addItem(String.valueOf(unTipo.getNombre() + " " + unTipo.getApellido()));
                }
            }
        }
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

    private void llenarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        tbl_registros.setModel(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("Nombre del cliente");
        modelo.addColumn("Nombre del mesero");
        modelo.addColumn("Fecha del pedido");
        modelo.addColumn("Tipo de pedido");
        modelo.addColumn("Número de mesa");
        modelo.addColumn("Estado");

        List<decPedidos> pedidos = pedidosDao.findMesasEntities();

        String estado = "";
        for (decPedidos unPedido : pedidos) {
            if (unPedido.getDesactivado() == 0) {
                estado = "Activado";
            } else {
                estado = "Desactivado";
            }
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
                        estado,}
            );
        }
        this.comboBoxMesero();
        this.comboBoxMesa();
    }

    private void llenarMenu() {
        tbl_resumen.setModel(modeloMenu);
        modeloMenu.addColumn("ID");
        modeloMenu.addColumn("Nombre");
        modeloMenu.addColumn("Cantidad");
        modeloMenu.addColumn("Precio por unidad");
    }

    private void limpiarMenu() {
        txt_menu_id.setText("");
        txt_menu_nombre.setText("");
        txt_menu_precio.setText("");
        txt_menu_cantidad.setText("");
        btn_agregar_menu.setEnabled(true);
        btn_modificar_menu.setEnabled(false);
        btn_borrar_menu.setEnabled(false);

    }

    private void agregarMenu() {
        if (txt_menu_nombre.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un menú");
        } else if (txt_menu_cantidad.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una cantidad");
        } else {
            modeloMenu.addRow(
                    new Object[]{
                        txt_menu_id.getText(),
                        txt_menu_nombre.getText(),
                        txt_menu_cantidad.getText(),
                        txt_menu_precio.getText(),}
            );
            limpiarMenu();
        }
    }

    private void modificarMenu() {
        if (txt_menu_cantidad.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una cantidad");
        } else {
            String cantidadNew = txt_menu_cantidad.getText();
            int row = buscarTablaMenu(txt_menu_nombre.getText());
            if (row != -1) {
                modeloMenu.removeRow(row);
                modeloMenu.addRow(
                        new Object[]{
                            txt_menu_id.getText(),
                            txt_menu_nombre.getText(),
                            cantidadNew,
                            txt_menu_precio.getText(),}
                );
            }
            limpiarMenu();
        }
    }

    private void eliminarMenu() {
        int row = buscarTablaMenu(txt_menu_nombre.getText());
        if (row != -1) {
            modeloMenu.removeRow(row);
        }
        limpiarMenu();
    }

    private int buscarTablaMenu(String menu) {
        Boolean find = false;
        int row = -1;
        for (int i = 0; i < tbl_resumen.getRowCount(); i++) {//For each row

            if (tbl_resumen.getModel().getValueAt(i, 1).equals(menu)) {//Search the model

                txt_menu_id.setText(tbl_resumen.getModel().getValueAt(i, 0).toString());
                txt_menu_nombre.setText(tbl_resumen.getModel().getValueAt(i, 1).toString());
                txt_menu_precio.setText(tbl_resumen.getModel().getValueAt(i, 3).toString());
                txt_menu_cantidad.setText(tbl_resumen.getModel().getValueAt(i, 2).toString());

                btn_agregar_menu.setEnabled(false);
                btn_modificar_menu.setEnabled(true);
                btn_borrar_menu.setEnabled(true);
                find = true;
                row = i;
                return row;
            }
        }//For loop outer
        if (!find) {
            txt_menu_cantidad.setText("");
        }
        return row;
    }

    private void limpiarPedido() {
        cbx_delivery.setSelected(false);
        txt_nombre.setText("");
        cbb_mesero.setSelectedItem("Seleccionar");
        cbb_mesa.setSelectedItem("Seleccionar");
        txt_nombre.setEnabled(true);
        cbb_mesero.setEnabled(false);
        cbb_mesa.setEnabled(false);
        lbl_mensaje.setText("Buscar");
        lbl_mensaje.setForeground(Color.black);
        btn_buscar_menu.setEnabled(false);
        txt_menu_cantidad.setEnabled(false);
        btn_modificar.setEnabled(false);
        btn_desactivar.setEnabled(false);
        btn_agregar.setEnabled(false);
        limpiarTablaMenu();
        limpiarMenu();
        btn_agregar_menu.setEnabled(false);
        btn_limpiar_menu.setEnabled(false);
    }

    private void limpiarTablaMenu() {
        for (int i = modeloMenu.getRowCount() - 1; i >= 0; i--) {
            modeloMenu.removeRow(i);
        }
    }

    //******************AGREGAR - MODIFICAR - DESACTIVAR************************
    private void agregar() {
        if (cbb_mesero.getSelectedItem().toString().equals("Seleccionar")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un mesero", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (cbb_mesa.getSelectedItem().toString().equals("Seleccionar") && !cbx_delivery.isSelected()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una mesa", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (tbl_resumen.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No ha ingresado ningún menú", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            //**************************/Pedidos/*******************************
            decPedidos pedidos = new decPedidos();
            //**************************/Pedido en linea/***********************
            if (cbx_delivery.isSelected()) {
                pedidos.setPedido_en_linea(true);
            } else {
                pedidos.setPedido_en_linea(false);
            }
            //**************************/Fecha del pedido/**********************
            fechaActual fechaAct = new fechaActual();
            try {
                String fechaActual = fechaAct.anio()
                        + "-"
                        + fechaAct.mes()
                        + "-"
                        + fechaAct.dia()
                        + " "
                        + fechaAct.hora()
                        + ":"
                        + fechaAct.minuto();
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                java.util.Date date = formatter.parse(fechaActual);
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                pedidos.setFecha_pedido(sqlDate);
            } catch (ParseException ex) {
                Logger.getLogger(jFramePedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
            //**************************/ID de cliente/*************************
            List<decClientes> clientes = clienteDao.findClientesEntities();
            for (decClientes unCliente : clientes) {
                String nombreCompleto = unCliente.getNombre() + " " + unCliente.getApellido();
                if (nombreCompleto.equals(txt_nombre.getText())) {
                    pedidos.setId_cliente(unCliente.getId_cliente());
                }
            }
            //**************************/ID de empleado/************************
            List<decEmpleado> empleados = empleadoDao.findclientesEntities();
            for (decEmpleado unEmpleado : empleados) {
                String nombreCompleto = unEmpleado.getNombre() + " " + unEmpleado.getApellido();
                if (nombreCompleto.equals(cbb_mesero.getSelectedItem().toString())) {
                    pedidos.setId_empleado_mesero(unEmpleado.getId_empleado());
                }
            }
            //**************************/ID de mesa/****************************
            if (!cbx_delivery.isSelected()) {
                pedidos.setId_mesa(parseInt(cbb_mesa.getSelectedItem().toString()));
            } else {
                pedidos.setId_mesa(1);
            }
            //**************************/Guardar Pedido/************************
            try {
                pedidosDao.guardar(pedidos);

            } catch (Exception ex) {
                Logger.getLogger(jFrameEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
            llenarTabla();

            //**************************/Menu-Pedidos/**************************
            int lastRow = tbl_registros.getModel().getRowCount() - 1;
            //**************************/ID de pedido/**************************
            String idPedido = tbl_registros.getModel().getValueAt(lastRow, 0).toString();
            //**************************/Registrar todo el pedido/**************

            // List<decMenu_pedido> menuPedidoLista = menuPedidoDao.findclientesEntities();
            //for (decMenu_pedido unMenuPedido : menuPedidoLista) {}
            for (int i = 0; i <= tbl_resumen.getModel().getRowCount() - 1; i++) {
                decMenu_pedido menuPedido = new decMenu_pedido();
                menuPedido.setId_menu(parseInt(tbl_resumen.getModel().getValueAt(i, 0).toString()));
                menuPedido.setId_pedido(parseInt(idPedido));
                menuPedido.setCantidad(parseInt(tbl_resumen.getModel().getValueAt(i, 2).toString()));
                menuPedido.setPrecio(parseDouble(tbl_resumen.getModel().getValueAt(i, 3).toString()));
                try {
                    menuPedidoDao.guardar(menuPedido);
                } catch (Exception ex) {
                    Logger.getLogger(jFrameEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            limpiarPedido();
            modeloMenu.setRowCount(0);
            JOptionPane.showMessageDialog(this, "Guardando", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void modificar() {
        if (cbb_mesero.getSelectedItem().toString().equals("Seleccionar")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un mesero", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (cbb_mesa.getSelectedItem().toString().equals("Seleccionar") && !cbx_delivery.isSelected()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una mesa", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (tbl_resumen.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No ha ingresado ningún menú", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            //**************************/Pedidos/*******************************
            decPedidos pedidos = new decPedidos();

            String idPedido = tbl_registros.getValueAt(tbl_registros.getSelectedRow(), 0).toString();
            pedidos.setId_pedido(parseInt(idPedido));

            //**************************/Pedido en linea/***********************
            if (cbx_delivery.isSelected()) {
                pedidos.setPedido_en_linea(true);
            } else {
                pedidos.setPedido_en_linea(false);
            }
            //**************************/Fecha del pedido/**********************
            fechaActual fechaAct = new fechaActual();
            try {
                String fechaActual = fechaAct.anio()
                        + "-"
                        + fechaAct.mes()
                        + "-"
                        + fechaAct.dia()
                        + " "
                        + fechaAct.hora()
                        + ":"
                        + fechaAct.minuto();
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                java.util.Date date = formatter.parse(fechaActual);
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                pedidos.setFecha_pedido(sqlDate);
            } catch (ParseException ex) {
                Logger.getLogger(jFramePedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
            //**************************/ID de cliente/*************************
            List<decClientes> clientes = clienteDao.findClientesEntities();
            for (decClientes unCliente : clientes) {
                String nombreCompleto = unCliente.getNombre() + " " + unCliente.getApellido();
                if (nombreCompleto.equals(txt_nombre.getText())) {
                    pedidos.setId_cliente(unCliente.getId_cliente());
                }
            }
            //**************************/ID de empleado/************************
            List<decEmpleado> empleados = empleadoDao.findclientesEntities();
            for (decEmpleado unEmpleado : empleados) {
                String nombreCompleto = unEmpleado.getNombre() + " " + unEmpleado.getApellido();
                if (nombreCompleto.equals(cbb_mesero.getSelectedItem().toString())) {
                    pedidos.setId_empleado_mesero(unEmpleado.getId_empleado());
                }
            }
            //**************************/ID de mesa/****************************
            if (!cbx_delivery.isSelected()) {
                pedidos.setId_mesa(parseInt(cbb_mesa.getSelectedItem().toString()));
            } else {
                pedidos.setId_mesa(1);
            }
            //**************************/Guardar Pedido/************************
            try {
                pedidosDao.edit(pedidos);

            } catch (Exception ex) {
                Logger.getLogger(jFrameEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
            llenarTabla();

            //**************************/Menu-Pedidos/**************************
            //**************************/Registrar todo el pedido/**************
            List<decMenu_pedido> menuPedidoLista = menuPedidoDao.findclientesEntities();
            for (decMenu_pedido unMenuPedido : menuPedidoLista) {
                if (unMenuPedido.getId_pedido() == parseInt(idPedido)) {
                    try {
                        menuPedidoDao.destroy(unMenuPedido.getId_menu_pedido());
                    } catch (Exception ex) {
                        Logger.getLogger(jFrameEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            for (int i = 0; i <= tbl_resumen.getModel().getRowCount() - 1; i++) {
                decMenu_pedido menuPedido = new decMenu_pedido();
                menuPedido.setId_menu(parseInt(tbl_resumen.getModel().getValueAt(i, 0).toString()));
                menuPedido.setId_pedido(parseInt(idPedido));
                menuPedido.setCantidad(parseInt(tbl_resumen.getModel().getValueAt(i, 2).toString()));
                menuPedido.setPrecio(parseDouble(tbl_resumen.getModel().getValueAt(i, 3).toString()));
                try {
                    menuPedidoDao.guardar(menuPedido);
                } catch (Exception ex) {
                    Logger.getLogger(jFrameEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            limpiarPedido();
            //modeloMenu.setRowCount(0);
            JOptionPane.showMessageDialog(this, "Registro modificado correctamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void desactivar() {
        if (cbb_mesero.getSelectedItem().toString().equals("Seleccionar")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un mesero", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (cbb_mesa.getSelectedItem().toString().equals("Seleccionar") && !cbx_delivery.isSelected()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una mesa", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            //**************************/Pedidos/*******************************
            decPedidos pedidos = new decPedidos();

            String idPedido = tbl_registros.getValueAt(tbl_registros.getSelectedRow(), 0).toString();
            pedidos.setId_pedido(parseInt(idPedido));
            if (state) {
                pedidos.setDesactivado(1);
            } else {
                pedidos.setDesactivado(0);
            }
            //**************************/Pedido en linea/***********************
            if (cbx_delivery.isSelected()) {
                pedidos.setPedido_en_linea(true);
            } else {
                pedidos.setPedido_en_linea(false);
            }
            //**************************/Fecha del pedido/**********************
            fechaActual fechaAct = new fechaActual();
            try {
                String fechaActual = fechaAct.anio()
                        + "-"
                        + fechaAct.mes()
                        + "-"
                        + fechaAct.dia()
                        + " "
                        + fechaAct.hora()
                        + ":"
                        + fechaAct.minuto();
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                java.util.Date date = formatter.parse(fechaActual);
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                pedidos.setFecha_pedido(sqlDate);
            } catch (ParseException ex) {
                Logger.getLogger(jFramePedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
            //**************************/ID de cliente/*************************
            List<decClientes> clientes = clienteDao.findClientesEntities();
            for (decClientes unCliente : clientes) {
                String nombreCompleto = unCliente.getNombre() + " " + unCliente.getApellido();
                if (nombreCompleto.equals(txt_nombre.getText())) {
                    pedidos.setId_cliente(unCliente.getId_cliente());
                }
            }
            //**************************/ID de empleado/************************
            List<decEmpleado> empleados = empleadoDao.findclientesEntities();
            for (decEmpleado unEmpleado : empleados) {
                String nombreCompleto = unEmpleado.getNombre() + " " + unEmpleado.getApellido();
                if (nombreCompleto.equals(cbb_mesero.getSelectedItem().toString())) {
                    pedidos.setId_empleado_mesero(unEmpleado.getId_empleado());
                }
            }
            //**************************/ID de mesa/****************************
            if (!cbx_delivery.isSelected()) {
                pedidos.setId_mesa(parseInt(cbb_mesa.getSelectedItem().toString()));
            } else {
                pedidos.setId_mesa(1);
            }
            //**************************/Guardar Pedido/************************
            try {
                pedidosDao.edit(pedidos);

            } catch (Exception ex) {
                Logger.getLogger(jFrameEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
            llenarTabla();
            limpiarPedido();
            //modeloMenu.setRowCount(0);
            //JOptionPane.showMessageDialog(this, "Registro modificado correctamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
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
        btn_buscar_cliente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbx_delivery = new javax.swing.JCheckBox();
        cbb_mesero = new javax.swing.JComboBox<>();
        btn_buscar_menu = new javax.swing.JToggleButton();
        jLabel8 = new javax.swing.JLabel();
        txt_menu_precio = new javax.swing.JTextField();
        txt_menu_nombre = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btn_limpiar_pedido = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_menu_cantidad = new javax.swing.JTextField();
        lbl_mensaje = new javax.swing.JLabel();
        btn_agregar_menu = new javax.swing.JToggleButton();
        btn_limpiar_menu = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cbb_mesa = new javax.swing.JComboBox<>();
        btn_modificar_menu = new javax.swing.JButton();
        btn_borrar_menu = new javax.swing.JButton();
        txt_menu_id = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_resumen = new javax.swing.JTable();
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
        lbl_puestos_trabajo.setText("Pedidos");
        jPanel4.add(lbl_puestos_trabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, -1));

        jPanel3.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_buscar_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar20.png"))); // NOI18N
        btn_buscar_cliente.setPreferredSize(new java.awt.Dimension(20, 20));
        btn_buscar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar_clienteActionPerformed(evt);
            }
        });
        jPanel6.add(btn_buscar_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, -1));

        jLabel3.setText("ID");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txt_id.setEditable(false);
        txt_id.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 80, -1));

        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });
        jPanel6.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 140, -1));

        jLabel5.setText("Nombre del cliente");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel7.setText("Nombre Mesero");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

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
        jPanel6.add(cbx_delivery, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, -1));

        jPanel6.add(cbb_mesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 140, -1));

        btn_buscar_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AgregarMenu.png"))); // NOI18N
        btn_buscar_menu.setEnabled(false);
        btn_buscar_menu.setPreferredSize(new java.awt.Dimension(100, 25));
        btn_buscar_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar_menuActionPerformed(evt);
            }
        });
        jPanel6.add(btn_buscar_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, -1, -1));

        jLabel8.setText("Nombre del menú");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, -1, -1));

        txt_menu_precio.setEditable(false);
        txt_menu_precio.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.add(txt_menu_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 90, -1));

        txt_menu_nombre.setEditable(false);
        txt_menu_nombre.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.add(txt_menu_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 180, -1));

        jLabel12.setText("Precio");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        btn_limpiar_pedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar30.png"))); // NOI18N
        btn_limpiar_pedido.setPreferredSize(new java.awt.Dimension(30, 30));
        btn_limpiar_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiar_pedidoActionPerformed(evt);
            }
        });
        jPanel6.add(btn_limpiar_pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));

        jLabel6.setText("cantidad");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, -1, -1));

        txt_menu_cantidad.setEnabled(false);
        txt_menu_cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_menu_cantidadKeyTyped(evt);
            }
        });
        jPanel6.add(txt_menu_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 90, -1));

        lbl_mensaje.setText("Buscar");
        jPanel6.add(lbl_mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        btn_agregar_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas30.png"))); // NOI18N
        btn_agregar_menu.setEnabled(false);
        btn_agregar_menu.setMaximumSize(new java.awt.Dimension(30, 30));
        btn_agregar_menu.setMinimumSize(new java.awt.Dimension(30, 30));
        btn_agregar_menu.setPreferredSize(new java.awt.Dimension(30, 30));
        btn_agregar_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregar_menuActionPerformed(evt);
            }
        });
        jPanel6.add(btn_agregar_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 30, 30));

        btn_limpiar_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar30.png"))); // NOI18N
        btn_limpiar_menu.setEnabled(false);
        btn_limpiar_menu.setPreferredSize(new java.awt.Dimension(30, 30));
        btn_limpiar_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiar_menuActionPerformed(evt);
            }
        });
        jPanel6.add(btn_limpiar_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, -1, -1));

        jLabel10.setText("Mesa");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jPanel6.add(cbb_mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 140, -1));

        btn_modificar_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modi30.png"))); // NOI18N
        btn_modificar_menu.setEnabled(false);
        btn_modificar_menu.setPreferredSize(new java.awt.Dimension(30, 30));
        btn_modificar_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificar_menuActionPerformed(evt);
            }
        });
        jPanel6.add(btn_modificar_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, -1, -1));

        btn_borrar_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menos30.png"))); // NOI18N
        btn_borrar_menu.setEnabled(false);
        btn_borrar_menu.setPreferredSize(new java.awt.Dimension(30, 30));
        btn_borrar_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrar_menuActionPerformed(evt);
            }
        });
        jPanel6.add(btn_borrar_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, -1, -1));

        txt_menu_id.setBackground(new java.awt.Color(204, 204, 204));
        txt_menu_id.setEnabled(false);
        jPanel6.add(txt_menu_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 50, -1));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 710, 230));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo2.png"))); // NOI18N
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 10, -1, -1));

        tbl_resumen.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_resumen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_resumenMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_resumen);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 410, 230));

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
        btn_agregar.setEnabled(false);
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
        btn_modificar.setEnabled(false);
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
        btn_desactivar.setEnabled(false);
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
        menu.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_regresarActionPerformed

    private void btn_buscar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar_clienteActionPerformed
        String input = txt_nombre.getText();
        String nombre = "";
        String apellido = "";
        String[] inp = input.split(" ");
        Boolean find = false;
        try {
            nombre = inp[0];
            apellido = inp[1];
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Debe ingresar 1 nombre y 1 apellido");
            find = true;
            Logger.getLogger(jFrameEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<decClientes> clientes = clienteDao.findClientesEntities();
        for (decClientes unCliente : clientes) {
            String clientN = unCliente.getNombre();
            String clientA = unCliente.getApellido();
            if (clientN.equals(nombre) && clientA.equals(apellido)) {
                if (unCliente.getDesactivado() != 1) {
                    lbl_mensaje.setText("¡Encontrado!");
                    lbl_mensaje.setForeground(Color.green);
                    txt_nombre.setEnabled(false);
                    cbb_mesero.setEnabled(true);
                    cbb_mesa.setEnabled(true);
                    btn_buscar_menu.setEnabled(true);
                    btn_agregar_menu.setEnabled(true);
                    btn_limpiar_menu.setEnabled(true);
                    txt_menu_cantidad.setEnabled(true);
                    btn_agregar.setEnabled(true);
                    find = true;
                    break;
                }
            }
        }
        if (!find) {
            lbl_mensaje.setText("¡No encontrado!");
            lbl_mensaje.setForeground(Color.red);
            txt_nombre.setText("");
            txt_nombre.setEnabled(true);
            cbb_mesero.setEnabled(false);
            if (cbx_delivery.isSelected()) {
                cbb_mesa.setEnabled(false);
            } else {
                cbb_mesa.setEnabled(true);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_buscar_clienteActionPerformed

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        valS.letras(evt);
        if (txt_nombre.getText().length() == 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void cbx_deliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_deliveryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_deliveryActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        llenarTabla();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_buscar_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar_menuActionPerformed
        // TODO add your handling code here:
        JDialogBuscarMenu buscarMenu = new JDialogBuscarMenu(this, rootPaneCheckingEnabled);
        buscarMenu.setVisible(true);
        txt_menu_nombre.setText(nombrePlatilloTest);
        txt_menu_precio.setText(precioPlatilloTest);
        txt_menu_id.setText(idPlatilloTest);
        buscarTablaMenu(nombrePlatilloTest);
    }//GEN-LAST:event_btn_buscar_menuActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        agregar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void txt_menu_cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_menu_cantidadKeyTyped
        // TODO add your handling code here:
        valN.valKeyTypeNumeros(evt);
        if (txt_menu_cantidad.getText().length() == 2) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_menu_cantidadKeyTyped

    private void btn_agregar_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregar_menuActionPerformed
        agregarMenu();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agregar_menuActionPerformed

    private void btn_limpiar_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiar_menuActionPerformed
        limpiarMenu();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_limpiar_menuActionPerformed

    private void btn_limpiar_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiar_pedidoActionPerformed
        limpiarPedido();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_limpiar_pedidoActionPerformed

    private void btn_modificar_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar_menuActionPerformed
        modificarMenu();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modificar_menuActionPerformed

    private void btn_borrar_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrar_menuActionPerformed
        eliminarMenu();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_borrar_menuActionPerformed

    private void tbl_resumenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_resumenMouseClicked
        int row = tbl_resumen.getSelectedRow();
        txt_menu_id.setText(tbl_resumen.getModel().getValueAt(row, 0).toString());
        txt_menu_nombre.setText(tbl_resumen.getModel().getValueAt(row, 1).toString());
        txt_menu_precio.setText(tbl_resumen.getModel().getValueAt(row, 3).toString());
        txt_menu_cantidad.setText(tbl_resumen.getModel().getValueAt(row, 2).toString());
        btn_agregar_menu.setEnabled(false);
        btn_modificar_menu.setEnabled(true);
        btn_borrar_menu.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_resumenMouseClicked

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        modificar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_desactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_desactivarActionPerformed
        desactivar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_desactivarActionPerformed

    private void tbl_registrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_registrosMouseClicked
        int row = tbl_registros.getSelectedRow();
        txt_nombre.setText(tbl_registros.getValueAt(row, 1).toString());
        txt_nombre.setEnabled(false);
        cbb_mesero.setEnabled(true);
        cbb_mesero.setSelectedItem(tbl_registros.getValueAt(row, 2).toString());
        if (tbl_registros.getValueAt(row, 4).toString().equals("En linea")) {
            cbx_delivery.setSelected(true);
            cbb_mesa.setEnabled(false);
        } else {
            cbx_delivery.setSelected(false);
            cbb_mesa.setEnabled(true);
        }

        cbb_mesa.setSelectedItem(tbl_registros.getValueAt(row, 5).toString());
        if (tbl_registros.getValueAt(row, 6).toString().equals("Activado")) {
            state = true;
            btn_desactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Desactivar1.png")));
        } else {
            state = false;
            btn_desactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Activar.png")));
        }

        limpiarTablaMenu();

        List<decMenu_pedido> menuPedidoLista = menuPedidoDao.findclientesEntities();
        for (decMenu_pedido unMenuPedido : menuPedidoLista) {
            if (unMenuPedido.getId_pedido() == parseInt(tbl_registros.getValueAt(row, 0).toString())) {
                int id = unMenuPedido.getId_menu();
                modeloMenu.addRow(
                        new Object[]{
                            id,
                            menuDao.findclientes(id).getNombre(),
                            unMenuPedido.getCantidad(),
                            menuDao.findclientes(id).getPrecio(),}
                );
            }
        }
        txt_menu_cantidad.setEnabled(true);
        btn_buscar_menu.setEnabled(true);

        btn_modificar.setEnabled(true);
        btn_desactivar.setEnabled(true);
        btn_agregar.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_registrosMouseClicked

    private void cbx_deliveryStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbx_deliveryStateChanged
        if (!txt_nombre.isEnabled()) {
            if (cbx_delivery.isSelected()) {
                cbb_mesa.setSelectedItem("Seleccionar");
                cbb_mesa.setEnabled(false);
            } else {
                cbb_mesa.setEnabled(true);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_deliveryStateChanged

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
            java.util.logging.Logger.getLogger(jFramePedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFramePedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFramePedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFramePedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFramePedidos().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JToggleButton btn_agregar_menu;
    private javax.swing.JButton btn_borrar_menu;
    private javax.swing.JButton btn_buscar_cliente;
    private javax.swing.JToggleButton btn_buscar_menu;
    private javax.swing.JButton btn_desactivar;
    private javax.swing.JButton btn_limpiar_menu;
    private javax.swing.JButton btn_limpiar_pedido;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_modificar_menu;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cbb_mesa;
    private javax.swing.JComboBox<String> cbb_mesero;
    private javax.swing.JCheckBox cbx_delivery;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel lbl_mensaje;
    private javax.swing.JLabel lbl_puestos_trabajo;
    private javax.swing.JTable tbl_registros;
    private javax.swing.JTable tbl_resumen;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_menu_cantidad;
    private javax.swing.JTextField txt_menu_id;
    private javax.swing.JTextField txt_menu_nombre;
    private javax.swing.JTextField txt_menu_precio;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables

}
