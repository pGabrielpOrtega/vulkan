/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vulkan.declaracion;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.ColumnTransformer;

/**
 * @author fer3dev
 */

@Entity
@Table (name="Usuario")
public class decUsuario {
    @Column
    private String nombre_usuario;
    @Column
    private String tipo_usuario;
    @Column
    private int fallos;
    
    @ColumnTransformer(
        read = "cast(aes_decrypt(contrasenia, 'vulkan') as char(255))", 
        write = "aes_encrypt(?, 'vulkan')")
    @Column(columnDefinition = "varbinary")
    private String contrasenia;
    
    @Id
    private int id_usuario;

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public int getFallos() {
        return fallos;
    }

    public void setFallos(int fallos) {
        this.fallos = fallos;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

}
