/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vulkan.declaracion;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author gabri
 */
@Entity
@Table (name="Menu")
public class decMenu {
    @Column
    private String nombre;
    @Column
    private int precio;
    @Id
    private int id_menu;
     public void setNombre(String nombre) {
        this.nombre = nombre;
    }
      public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(int apellido) {
        this.precio = apellido;
    }
    public int getId() {
        return id_menu;
    }

    public void setId(int id) {
        this.id_menu = id;
    }
    
}
