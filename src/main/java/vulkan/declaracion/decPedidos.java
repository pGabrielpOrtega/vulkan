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
@Table (name="Pedido")
public class decPedidos implements Serializable{
    @Id
    private int id_pedido;
    @Column 
    private int id_cliente;
    @Column(name = "fecha_pedido", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_pedido;
    @Column
    private int id_empleado_mesero;
    @Column
    private int id_mesa;
    @Column
    private boolean pedido_en_linea;
    @Column
    private int desactivado;
    
    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Date getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public int getId_empleado_mesero() {
        return id_empleado_mesero;
    }

    public void setId_empleado_mesero(int id_empleado_mesero) {
        this.id_empleado_mesero = id_empleado_mesero;
    }

    public boolean getPedido_en_linea() {
        return pedido_en_linea;
    }

    public void setPedido_en_linea(boolean pedido_en_linea) {
        this.pedido_en_linea = pedido_en_linea;
    }

    public int getDesactivado() {
        return desactivado;
    }

    public void setDesactivado(int desactivado) {
        this.desactivado = desactivado;
    }

    public int getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(int id_mesa) {
        this.id_mesa = id_mesa;
    }
    
}
