/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vulkan.declaracion;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author gabri
 */
@Entity
@Table (name="Proveedores")
public class decProveedores {
     @Id
    private int id_proveedores;
    @Column
    private String nombre;
    @Column
    private int telefono;
    @Column
    private String apellido;
    @Column
    private String direccion;
    @Column
    private String email;
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getAppelido() {
        return apellido;
    }

    public void setAppelido(String appelido) {
        this.apellido = appelido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String correo) {
        this.email = correo;
    }

    public int getId_empleado() {
        return id_proveedores;
    }

    public void setId_empleado(int id_empleado) {
        this.id_proveedores = id_empleado;
    }
}
