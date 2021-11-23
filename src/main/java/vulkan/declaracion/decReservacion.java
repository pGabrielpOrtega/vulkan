/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author fer3dev
 */

@Entity
@Table(name = "Reservacion")
public class decReservacion implements Serializable{

    @Column
    private int id_mesa;
    @Column
    private int id_cliente;
    @Column
    private int desactivado;
    @Column(name = "fecha_inicio", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_inicio;
    @Column(name = "fecha_fin", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_fin;

    @Id
    private int id_reservacion;

    public int getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(int id_mesa) {
        this.id_mesa = id_mesa;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getDesactivado() {
        return desactivado;
    }

    public void setDesactivado(int id_desactivado) {
        this.desactivado = id_desactivado;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getId_reservacion() {
        return id_reservacion;
    }

    public void setId_reservacion(int id_reservacion) {
        this.id_reservacion = id_reservacion;
    }

}
