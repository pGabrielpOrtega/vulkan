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
import com.mycompany.vulkan.validacion.fechaActual;
import vulkan.declaracion.decReservacion;
import com.mycompany.controlador.controlReservacion;
import vulkan.declaracion.decClientes;
import com.mycompany.controlador.controlClientes;
import vulkan.declaracion.decMesas;
import com.mycompany.controlador.controlMesas;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.EmptyStackException;
import javax.swing.ImageIcon;

/**
 *
 * @author fer3dev
 */
public class jFrameReservaciones extends javax.swing.JFrame {

    controlReservacion reservacionDao = new controlReservacion();
    controlClientes clienteDao = new controlClientes();
    controlMesas mesasDao = new controlMesas();

    /**
     * Creates new form jFrameReservaciones
     */
    public jFrameReservaciones() {
        initComponents();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/logo1.png"));
        setIconImage(icon.getImage());
        setTitle("VK Restaurant");
        btn_modificar.setEnabled(false);
        btn_desactivar.setEnabled(false);
        btn_agregar.setEnabled(true);
        actualizar();
        updateCBB();
        
    }

    private void actualizar() {
        DefaultTableModel modelo = new DefaultTableModel();
        tbl_registros.setModel(modelo);
        modelo.addColumn("Id");
        modelo.addColumn("Nombre de cliente");
        modelo.addColumn("Número de mesa");
        modelo.addColumn("Fecha de inicio");
        modelo.addColumn("Fecha de fin");

        List<decReservacion> reservacion = reservacionDao.findReservacionEntities();

        for (decReservacion unReservacion : reservacion) {
            if (unReservacion.getDesactivado() == 0) {

                modelo.addRow(
                        new Object[]{
                            unReservacion.getId_reservacion(),
                            clienteDao.findClientes(unReservacion.getId_cliente()).getNombre()
                            + " "
                            + clienteDao.findClientes(unReservacion.getId_cliente()).getApellido(),
                            unReservacion.getId_mesa(),
                            unReservacion.getFecha_inicio(),
                            unReservacion.getFecha_fin(),}
                );
            }
        }
        
    }

    private void limpiar() {

        cbb_anio.removeAllItems();
        cbb_mes.enable(false);
        cbb_mes.removeAllItems();
        cbb_dia.enable(false);
        cbb_dia.removeAllItems();
        cbb_horai.enable(false);
        cbb_horai.removeAllItems();
        cbb_minutoi.enable(false);
        cbb_minutoi.removeAllItems();
        cbb_horaf.enable(false);
        cbb_horaf.removeAllItems();
        cbb_minutof.enable(false);
        cbb_minutof.removeAllItems();

        cbb_mesas.removeAllItems();

        txt_nombre.setText("");
        txt_id.setText("");
        txt_id_cliente.setText("");
        btn_modificar.setEnabled(false);
        btn_desactivar.setEnabled(false);
        btn_agregar.setEnabled(true);

        updateCBB();
    }

    private void updateCBB() {
        cbb_mesas.addItem("Seleccionar");
        List<decMesas> mesas = mesasDao.findMesasEntities();
        for (decMesas unMesa : mesas) {
            if (unMesa.getDesactivado() == 0) {
                cbb_mesas.addItem(String.valueOf(unMesa.getId_mesa()));
            }
        }
        cbb_anio.addItem("-");
        fechaActual fecha = new fechaActual();
        cbb_anio.addItem(fecha.anio());
        cbb_anio.addItem(String.valueOf(parseInt(fecha.anio()) + 1));
    }

    private void desactivar(int id) {
        try {
            decReservacion reservacion = new decReservacion();
            reservacion.setId_reservacion(id);
            reservacion.setId_mesa(parseInt(cbb_mesas.getSelectedItem().toString()));
            reservacion.setId_cliente(parseInt(txt_id_cliente.getText()));

            reservacion.setDesactivado(1);

            String fechaI = cbb_anio.getSelectedItem().toString()
                    + "-"
                    + cbb_mes.getSelectedItem().toString()
                    + "-"
                    + cbb_dia.getSelectedItem().toString()
                    + " "
                    + cbb_horai.getSelectedItem().toString()
                    + ":"
                    + cbb_minutoi.getSelectedItem().toString();

            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            java.util.Date date = formatter.parse(fechaI);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            String fechaF = cbb_anio.getSelectedItem().toString()
                    + "-"
                    + cbb_mes.getSelectedItem().toString()
                    + "-"
                    + cbb_dia.getSelectedItem().toString()
                    + " "
                    + cbb_horaf.getSelectedItem().toString()
                    + ":"
                    + cbb_minutof.getSelectedItem().toString();
            DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            java.util.Date date1 = formatter1.parse(fechaF);
            java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());

            reservacion.setFecha_inicio(sqlDate);
            reservacion.setFecha_fin(sqlDate1);

            try {
                reservacionDao.edit(reservacion);
            } catch (Exception ex) {
                Logger.getLogger(jFramePuesto.class.getName()).log(Level.SEVERE, null, ex);
            }
            limpiar();
            actualizar();
        } catch (ParseException ex) {
            Logger.getLogger(jFrameReservaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void registrar() {
        decReservacion reservacion = new decReservacion();
        if (txt_nombre.getText().length() == 0
                || txt_id_cliente.getText().length() == 0
                || cbb_minutof.getSelectedItem() == null
                || "-".equals(cbb_minutof.getSelectedItem().toString())) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar todos los campos");
        } else {
            try {
                reservacion.setId_mesa(parseInt(cbb_mesas.getSelectedItem().toString()));
                reservacion.setId_cliente(parseInt(txt_id_cliente.getText()));

                String fechaI = cbb_anio.getSelectedItem().toString()
                        + "-"
                        + cbb_mes.getSelectedItem().toString()
                        + "-"
                        + cbb_dia.getSelectedItem().toString()
                        + " "
                        + cbb_horai.getSelectedItem().toString()
                        + ":"
                        + cbb_minutoi.getSelectedItem().toString();
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                java.util.Date date = formatter.parse(fechaI);
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                String fechaF = cbb_anio.getSelectedItem().toString()
                        + "-"
                        + cbb_mes.getSelectedItem().toString()
                        + "-"
                        + cbb_dia.getSelectedItem().toString()
                        + " "
                        + cbb_horaf.getSelectedItem().toString()
                        + ":"
                        + cbb_minutof.getSelectedItem().toString();
                DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                java.util.Date date1 = formatter1.parse(fechaF);
                java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());

                List<decReservacion> reservacionDate = reservacionDao.findReservacionEntities();

                for (decReservacion unReservacion : reservacionDate) {
                    if (unReservacion.getDesactivado() == 0) {
                        if (unReservacion.getId_mesa() == parseInt(cbb_mesas.getSelectedItem().toString())) {
                            System.out.println(unReservacion.getFecha_inicio().getTime());
                            System.out.println(sqlDate.getTime());
                            if (unReservacion.getFecha_inicio().getTime() == sqlDate.getTime()) {
                                JOptionPane.showMessageDialog(this, "Esta hora ya está reservada");
                                throw new EmptyStackException();
                            } else if (sqlDate.getTime() > unReservacion.getFecha_inicio().getTime()
                                    && sqlDate.getTime() < unReservacion.getFecha_fin().getTime()) {
                                JOptionPane.showMessageDialog(this, "Esta hora colisiona con otra reservación");
                                throw new EmptyStackException();
                            }
                        }
                    }
                }
                reservacion.setFecha_inicio(sqlDate);
                reservacion.setFecha_fin(sqlDate1);
                JOptionPane.showMessageDialog(this, "Registrado");
                try {
                    reservacionDao.guardar(reservacion);
                } catch (Exception ex) {
                    Logger.getLogger(jFramePuesto.class.getName()).log(Level.SEVERE, null, ex);
                }
                limpiar();
                actualizar();
            } catch (ParseException ex) {
                Logger.getLogger(jFrameReservaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void registrar(int id) {
        decReservacion reservacion = new decReservacion();
        if (txt_nombre.getText().length() == 0
                || txt_id_cliente.getText().length() == 0
                || cbb_minutof.getSelectedItem() == null
                || "-".equals(cbb_minutof.getSelectedItem().toString())) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar todos los campos");
        } else {
            try {
                reservacion.setId_reservacion(id);
                reservacion.setId_mesa(parseInt(cbb_mesas.getSelectedItem().toString()));
                reservacion.setId_cliente(parseInt(txt_id_cliente.getText()));

                String fechaI = cbb_anio.getSelectedItem().toString()
                        + "-"
                        + cbb_mes.getSelectedItem().toString()
                        + "-"
                        + cbb_dia.getSelectedItem().toString()
                        + " "
                        + cbb_horai.getSelectedItem().toString()
                        + ":"
                        + cbb_minutoi.getSelectedItem().toString();
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                java.util.Date date = formatter.parse(fechaI);
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                String fechaF = cbb_anio.getSelectedItem().toString()
                        + "-"
                        + cbb_mes.getSelectedItem().toString()
                        + "-"
                        + cbb_dia.getSelectedItem().toString()
                        + " "
                        + cbb_horaf.getSelectedItem().toString()
                        + ":"
                        + cbb_minutof.getSelectedItem().toString();
                DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                java.util.Date date1 = formatter1.parse(fechaF);
                java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());

                List<decReservacion> reservacionDate = reservacionDao.findReservacionEntities();

                for (decReservacion unReservacion : reservacionDate) {
                    if (unReservacion.getDesactivado() == 0) {
                        if (unReservacion.getId_mesa() == parseInt(cbb_mesas.getSelectedItem().toString())) {
                            System.out.println(unReservacion.getFecha_inicio().getTime());
                            System.out.println(sqlDate.getTime());
                            if (unReservacion.getFecha_inicio().getTime() == sqlDate.getTime()) {
                                JOptionPane.showMessageDialog(this, "Esta hora ya está reservada");
                                throw new EmptyStackException();
                            } else if (sqlDate.getTime() > unReservacion.getFecha_inicio().getTime()
                                    && sqlDate.getTime() < unReservacion.getFecha_fin().getTime()) {
                                JOptionPane.showMessageDialog(this, "Esta hora colisiona con otra reservación");
                                throw new EmptyStackException();
                            }
                        }
                    }
                }
                reservacion.setFecha_inicio(sqlDate);
                reservacion.setFecha_fin(sqlDate1);
                JOptionPane.showMessageDialog(this, "Reservación modificada correctamente");
                try {
                    reservacionDao.edit(reservacion);
                } catch (Exception ex) {
                    Logger.getLogger(jFramePuesto.class.getName()).log(Level.SEVERE, null, ex);
                }
                limpiar();
                actualizar();
            } catch (ParseException ex) {
                Logger.getLogger(jFrameReservaciones.class.getName()).log(Level.SEVERE, null, ex);
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
        lbl_puestos_trabajo = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txt_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbb_mesas = new javax.swing.JComboBox<>();
        cbb_dia = new javax.swing.JComboBox<>();
        cbb_mes = new javax.swing.JComboBox<>();
        cbb_anio = new javax.swing.JComboBox<>();
        cbb_horaf = new javax.swing.JComboBox<>();
        cbb_minutof = new javax.swing.JComboBox<>();
        cbb_horai = new javax.swing.JComboBox<>();
        cbb_minutoi = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        txt_id_cliente = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btn_buscar_cliente = new javax.swing.JButton();
        txt_descripcion_mesa = new javax.swing.JTextField();
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
        lbl_puestos_trabajo.setText("Reservaciones");
        jPanel4.add(lbl_puestos_trabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, -1, -1));

        jPanel3.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_id.setEditable(false);
        txt_id.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 90, -1));

        jLabel3.setText("ID");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel5.setText("ID de cliente");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel6.setText("Número de mesa");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel7.setText("Fecha");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));

        jLabel8.setText("Hora inicio");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jLabel9.setText("Hora fin");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, -1));

        cbb_mesas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_mesasItemStateChanged(evt);
            }
        });
        jPanel6.add(cbb_mesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 150, -1));

        cbb_dia.setEnabled(false);
        cbb_dia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_diaItemStateChanged(evt);
            }
        });
        jPanel6.add(cbb_dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 50, -1));

        cbb_mes.setEnabled(false);
        cbb_mes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_mesItemStateChanged(evt);
            }
        });
        jPanel6.add(cbb_mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 50, -1));

        cbb_anio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_anioItemStateChanged(evt);
            }
        });
        jPanel6.add(cbb_anio, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 70, -1));

        cbb_horaf.setEnabled(false);
        cbb_horaf.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_horafItemStateChanged(evt);
            }
        });
        jPanel6.add(cbb_horaf, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 50, -1));

        cbb_minutof.setEnabled(false);
        jPanel6.add(cbb_minutof, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 50, -1));

        cbb_horai.setEnabled(false);
        cbb_horai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_horaiItemStateChanged(evt);
            }
        });
        jPanel6.add(cbb_horai, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 50, -1));

        cbb_minutoi.setEnabled(false);
        cbb_minutoi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_minutoiItemStateChanged(evt);
            }
        });
        jPanel6.add(cbb_minutoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 50, -1));

        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("Mes");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, -1));

        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("Año");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, -1));

        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setText("Día");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, -1, -1));

        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setText("Hora");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, -1, -1));

        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setText("Minutos");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, -1, -1));

        jLabel16.setForeground(new java.awt.Color(153, 153, 153));
        jLabel16.setText("Hora");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, -1, -1));

        jLabel17.setForeground(new java.awt.Color(153, 153, 153));
        jLabel17.setText("Minutos");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, -1, -1));

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar50.png"))); // NOI18N
        btn_buscar.setPreferredSize(new java.awt.Dimension(50, 50));
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel6.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, -1, -1));

        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar50.png"))); // NOI18N
        btn_limpiar.setPreferredSize(new java.awt.Dimension(50, 50));
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });
        jPanel6.add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, -1, -1));

        txt_id_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_id_clienteKeyTyped(evt);
            }
        });
        jPanel6.add(txt_id_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 60, -1));

        txt_nombre.setEditable(false);
        txt_nombre.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 150, -1));

        jLabel10.setText("Nombre");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        btn_buscar_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar20.png"))); // NOI18N
        btn_buscar_cliente.setPreferredSize(new java.awt.Dimension(20, 20));
        btn_buscar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar_clienteActionPerformed(evt);
            }
        });
        jPanel6.add(btn_buscar_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, -1));

        txt_descripcion_mesa.setEditable(false);
        txt_descripcion_mesa.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.add(txt_descripcion_mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 220, 30));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 600, 230));

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

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        actualizar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        limpiar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void cbb_anioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_anioItemStateChanged
        if (!cbb_mes.isEnabled()) {
            fechaActual fecha = new fechaActual();
            try {
                if (!cbb_anio.getSelectedItem().equals("-")) {
                    cbb_mes.enable(true);
                    cbb_mes.addItem("-");
                    if (cbb_anio.getSelectedItem().equals(fecha.anio())) {
                        int mes = parseInt(fecha.mes());
                        for (int i = mes; i <= 12; i++) {
                            cbb_mes.addItem(String.valueOf(i));
                        }
                    } else {
                        for (int i = 1; i <= 12; i++) {
                            cbb_mes.addItem(String.valueOf(i));
                        }
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(jFramePuesto.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_anioItemStateChanged

    private void cbb_mesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_mesItemStateChanged
        if (!cbb_dia.isEnabled()) {
            fechaActual fecha = new fechaActual();
            try {
                if (!cbb_mes.getSelectedItem().equals("-")) {
                    cbb_dia.enable(true);
                    cbb_dia.addItem("-");
                    if (cbb_mes.getSelectedItem().equals(fecha.mes())) {
                        int dia = parseInt(fecha.dia());
                        for (int i = dia; i <= 31; i++) {
                            cbb_dia.addItem(String.valueOf(i));
                        }
                    } else {
                        for (int i = 1; i <= 31; i++) {
                            cbb_dia.addItem(String.valueOf(i));
                        }
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(jFramePuesto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_mesItemStateChanged

    private void cbb_diaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_diaItemStateChanged
        if (!cbb_horai.isEnabled()) {
            fechaActual fecha = new fechaActual();
            try {
                if (!cbb_dia.getSelectedItem().equals("-")) {
                    cbb_horai.enable(true);
                    cbb_horai.addItem("-");
                    if (cbb_dia.getSelectedItem().equals(fecha.dia())) {
                        int hora = parseInt(fecha.hora());
                        if (hora < 8) {
                            hora = 7;
                        }
                        for (int i = hora + 1; i <= 20; i++) {
                            if (i < 10) {
                                cbb_horai.addItem("0" + String.valueOf(i));
                            } else {
                                cbb_horai.addItem(String.valueOf(i));
                            }
                        }
                    } else {
                        for (int i = 8; i <= 20; i++) {
                            if (i < 10) {
                                cbb_horai.addItem("0" + String.valueOf(i));
                            } else {
                                cbb_horai.addItem(String.valueOf(i));
                            }
                        }
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(jFramePuesto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_diaItemStateChanged

    private void cbb_horaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_horaiItemStateChanged
        if (!cbb_minutoi.isEnabled()) {
            fechaActual fecha = new fechaActual();
            try {
                if (!cbb_horai.getSelectedItem().equals("-")) {
                    cbb_minutoi.enable(true);
                    cbb_minutoi.addItem("-");
                    if (cbb_horai.getSelectedItem().equals(fecha.hora())) {
                        int minuto = parseInt(fecha.minuto());
                        if (minuto < 10) {
                            cbb_minutoi.addItem("30");
                        }
                    } else {
                        cbb_minutoi.addItem("00");
                        cbb_minutoi.addItem("30");
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(jFramePuesto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_horaiItemStateChanged

    private void cbb_minutoiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_minutoiItemStateChanged
        if (!cbb_horaf.isEnabled()) {
            fechaActual fecha = new fechaActual();
            try {
                if (!cbb_minutoi.getSelectedItem().equals("-")) {
                    cbb_horaf.enable(true);
                    cbb_horaf.addItem("-");
                    int hora = parseInt(cbb_horai.getSelectedItem().toString());
                    for (int i = hora + 1; i <= 21; i++) {
                        if (i < 10) {
                            cbb_horaf.addItem("0" + String.valueOf(i));
                        } else {
                            cbb_horaf.addItem(String.valueOf(i));
                        }
                    }

                }
            } catch (Exception ex) {
                Logger.getLogger(jFramePuesto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_minutoiItemStateChanged

    private void cbb_horafItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_horafItemStateChanged
        if (!cbb_minutof.isEnabled()) {
            fechaActual fecha = new fechaActual();
            try {
                if (!cbb_horaf.getSelectedItem().equals("-")) {
                    cbb_minutof.enable(true);
                    cbb_minutof.addItem("-");
                    int minuto = parseInt(cbb_minutoi.getSelectedItem().toString());
                    int hora = parseInt(cbb_horaf.getSelectedItem().toString());
                    if (hora == (parseInt(cbb_horai.getSelectedItem().toString()) + 1)) {
                        if (parseInt(cbb_minutoi.getSelectedItem().toString()) == 30) {
                            cbb_minutof.addItem("30");
                        } else {
                            cbb_minutof.addItem("00");
                            cbb_minutof.addItem("30");
                        }
                    } else {
                        cbb_minutof.addItem("00");
                        cbb_minutof.addItem("30");
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(jFramePuesto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_horafItemStateChanged

    private void btn_buscar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar_clienteActionPerformed
        String input = txt_id_cliente.getText();
        try {
            parseInt(input);
            decClientes clienteBuscar = clienteDao.findClientes(parseInt(input));
            if (clienteBuscar == null) {
                JOptionPane.showMessageDialog(this, "Cliente no encontrada");
            } else if (clienteBuscar.getDesactivado() == 1) {
                JOptionPane.showMessageDialog(this, "Cliente actualmente desactivado");
            } else {
                String apll = String.valueOf(clienteBuscar.getApellido());
                String name = String.valueOf(clienteBuscar.getNombre());
                String fna = name + " " + apll;
                txt_nombre.setText(fna);
            }
        } catch (Exception ex) {
            Logger.getLogger(jFramePuesto.class
                    .getName()).log(Level.SEVERE, null, ex);
            if (input != null) {
                JOptionPane.showMessageDialog(this, "El ID solo puede contener números");
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_buscar_clienteActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        String input = JOptionPane.showInputDialog("Ingrese el ID de la reservación a buscar");
        System.out.println(input);
        try {
            parseInt(input);
            decReservacion reservacionBuscar = reservacionDao.findReservacion(parseInt(input));
            if (reservacionBuscar == null) {
                JOptionPane.showMessageDialog(this, "Reservación no encontrada");
            } else if (reservacionBuscar.getDesactivado() == 1) {
                JOptionPane.showMessageDialog(this, "Reservación actualmente desactivada");
            } else {
                decClientes clienteBuscar = clienteDao.findClientes(reservacionBuscar.getId_cliente());
                txt_id.setText(String.valueOf(reservacionBuscar.getId_reservacion()));
                txt_id_cliente.setText(String.valueOf(reservacionBuscar.getId_cliente()));
                String fna = clienteBuscar.getNombre() + " " + clienteBuscar.getApellido();
                txt_nombre.setText(fna);
                cbb_mesas.setSelectedItem(String.valueOf(reservacionBuscar.getId_mesa()));

                String finit = reservacionBuscar.getFecha_inicio().toString();
                fechaActual fecha = new fechaActual();
                cbb_anio.setSelectedItem(fecha.anio(finit));
                cbb_mes.setSelectedItem(fecha.mes(finit));
                cbb_dia.setSelectedItem(fecha.dia(finit));

                cbb_horai.setSelectedItem(fecha.hora(finit));
                cbb_minutoi.setSelectedItem(fecha.minuto(finit));
                System.out.println(fecha.minuto(finit));

                String ffin = reservacionBuscar.getFecha_fin().toString();
                cbb_horaf.setSelectedItem(fecha.hora(ffin));
                System.out.println(fecha.minuto(ffin));
                cbb_minutof.setSelectedItem(fecha.minuto(ffin));

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

    private void txt_id_clienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_id_clienteKeyTyped
        valStringInt valN = new valStringInt();
        valN.numeros(evt);
        if (txt_id_cliente.getText().length() == 11) {
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_clienteKeyTyped

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        if (!txt_id.getText().equals("")) {
            registrar(parseInt(txt_id.getText()));
        } else {
            JOptionPane.showMessageDialog(this, "No selecciono ninguna reservación a modificar");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_desactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_desactivarActionPerformed
        if (!txt_id.getText().equals("")) {
            desactivar(parseInt(txt_id.getText()));
        } else {
            JOptionPane.showMessageDialog(this, "No selecciono ninguna reservación a desactivar");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_desactivarActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        registrar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void cbb_mesasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_mesasItemStateChanged
        // TODO add your handling code here:
        String input = cbb_mesas.getSelectedItem().toString();
                //parseInt(cbb_mesas.getSelectedItem().toString()));
        
        try {
            parseInt(input);
            decMesas clienteBuscar = mesasDao.findMesas(parseInt(input));
            if (clienteBuscar == null) {
                JOptionPane.showMessageDialog(this, "documento no encontrada");
            } else if (clienteBuscar.getDesactivado() == 1) {
                JOptionPane.showMessageDialog(this, "Documento actualmente desactivado");
            } else {
                
                String name = String.valueOf(clienteBuscar.getDescripcion());
                String fna = name;
                txt_descripcion_mesa.setText(fna);
            }
        } catch (Exception ex) {
            Logger.getLogger(jFramePuesto.class
                .getName()).log(Level.SEVERE, null, ex);
            if (input.equals("Seleccionar")) {
                txt_descripcion_mesa.setText("");
            }
        }
    }//GEN-LAST:event_cbb_mesasItemStateChanged

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
            java.util.logging.Logger.getLogger(jFrameReservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrameReservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrameReservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrameReservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFrameReservaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_buscar_cliente;
    private javax.swing.JButton btn_desactivar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cbb_anio;
    private javax.swing.JComboBox<String> cbb_dia;
    private javax.swing.JComboBox<String> cbb_horaf;
    private javax.swing.JComboBox<String> cbb_horai;
    private javax.swing.JComboBox<String> cbb_mes;
    private javax.swing.JComboBox<String> cbb_mesas;
    private javax.swing.JComboBox<String> cbb_minutof;
    private javax.swing.JComboBox<String> cbb_minutoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JLabel lbl_puestos_trabajo;
    private javax.swing.JTable tbl_registros;
    private javax.swing.JTextField txt_descripcion_mesa;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_id_cliente;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
