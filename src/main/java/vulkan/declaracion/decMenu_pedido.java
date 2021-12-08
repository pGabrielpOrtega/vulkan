/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vulkan.declaracion;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author gabri
 */
@Entity
@Table (name="menu_pedido")
public class decMenu_pedido implements Serializable{
    @Id
    private int id_menu_pedido;
    @Column 
    private int id_menu;
    @Column
    private int id_pedido;
    @Column
    private int cantidad;
    @Column
    private double precio;

    public int getId_menu_pedido() {
        return id_menu_pedido;
    }

    public void setId_menu_pedido(int id_menu_pedido) {
        this.id_menu_pedido = id_menu_pedido;
    }

    public int getId_menu() {
        return id_menu;
    }

    public void setId_menu(int id_menu) {
        this.id_menu = id_menu;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
