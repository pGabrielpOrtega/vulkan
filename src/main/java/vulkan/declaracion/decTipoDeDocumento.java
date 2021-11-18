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
    @Id
    private int id_tipo_documento;
    
    
    
    

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
}
