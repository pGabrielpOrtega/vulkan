/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vulkan.declaracion;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author fer3dev
 */

@Entity
@Table (name="Producto_Almacen")
public class decProductoAlmacen implements Serializable{
    @Column
    private int cantidad_actual;
    @Column
    private int cantidad_minima;
    @Column
    private int cantidad_maxima;
    @Column
    private int desactivado;
    
    @Id
    private int id_almacen;
    @Id
    private int id_producto;

    public int getCantidad_actual() {
        return cantidad_actual;
    }

    public void setCantidad_actual(int canitdad_actual) {
        this.cantidad_actual = canitdad_actual;
    }

    public int getCantidad_minima() {
        return cantidad_minima;
    }

    public void setCantidad_minima(int cantidad_minima) {
        this.cantidad_minima = cantidad_minima;
    }

    public int getCantidad_maxima() {
        return cantidad_maxima;
    }

    public void setCantidad_maxima(int cantidad_maxima) {
        this.cantidad_maxima = cantidad_maxima;
    }

    public int getDesactivado() {
        return desactivado;
    }

    public void setDesactivado(int desactivado) {
        this.desactivado = desactivado;
    }

    public int getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(int id_almacen) {
        this.id_almacen = id_almacen;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
}
