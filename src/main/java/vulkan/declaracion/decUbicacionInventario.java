/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vulkan.declaracion;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

/**
 *
 * @author gabri
 */
public class decUbicacionInventario {
    @Column
    private String nombre;
    @Column
    private String direccion;
    @Id
    private int id_almacen;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(int id_almacen) {
        this.id_almacen = id_almacen;
    }
    
}
