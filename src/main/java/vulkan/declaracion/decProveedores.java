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
    @Column
    private int desactivado;
    @Column
    private String idnum_identificacion_empleado;
    @Column
    private String nombre_tipoDoc_empleado;

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

    public int getid_proveedores() {
        return id_proveedores;
    }

    public void setid_proveedores(int id_empleado) {
        this.id_proveedores = id_empleado;
    }

    public int getId_proveedores() {
        return id_proveedores;
    }

    public void setId_proveedores(int id_proveedores) {
        this.id_proveedores = id_proveedores;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDesactivado() {
        return desactivado;
    }

    public void setDesactivado(int desactivado) {
        this.desactivado = desactivado;
    }

    public String getIdnum_identificacion_empleado() {
        return idnum_identificacion_empleado;
    }

    public void setIdnum_identificacion_empleado(String idnum_identificacion_empleado) {
        this.idnum_identificacion_empleado = idnum_identificacion_empleado;
    }

    public String getNombre_tipoDoc_empleado() {
        return nombre_tipoDoc_empleado;
    }

    public void setNombre_tipoDoc_empleado(String nombre_tipoDoc_empleado) {
        this.nombre_tipoDoc_empleado = nombre_tipoDoc_empleado;
    }
    
}
