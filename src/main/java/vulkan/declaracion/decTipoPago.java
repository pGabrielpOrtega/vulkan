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

/**
 * @author fer3dev
 */

@Entity
@Table (name="Tipo_pago")
public class decTipoPago {
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private int desactivado;
    
    @Id
    private int id_tipo_pago;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDesactivado() {
        return desactivado;
    }

    public void setDesactivado(int desactivado) {
        this.desactivado = desactivado;
    }

    public int getId_tipo_pago() {
        return id_tipo_pago;
    }

    public void setId_tipo_pago(int id_tipo_pago) {
        this.id_tipo_pago = id_tipo_pago;
    }
}
