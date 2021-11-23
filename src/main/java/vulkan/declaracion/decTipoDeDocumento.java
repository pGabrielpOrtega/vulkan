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
@Table (name="Tipo_Documento")
public class decTipoDeDocumento implements Serializable{
    
    @Column
    private String descripcion;
    @Column
    private String nombre;
    @Column
    private String id_documento;
    @Column
    private int desactivado;
    
    @Id
    private int id_tipo_documento;

    public int getDesactivado() {
        return desactivado;
    }

    public void setDesactivado(int desactivado) {
        this.desactivado = desactivado;
    }
    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String apellido) {
        this.descripcion = apellido;
    }
    public int getId() {
        return id_tipo_documento;
    }

    public void setId(int id) {
        this.id_tipo_documento = id;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String apellido) {
        this.nombre = apellido;
    }

    public String getId_documento() {
        return id_documento;
    }

    public void setId_documento(String id_documento) {
        this.id_documento = id_documento;
    }

    public int getId_tipo_documento() {
        return id_tipo_documento;
    }

    public void setId_tipo_documento(int id_tipo_documento) {
        this.id_tipo_documento = id_tipo_documento;
    }
}
