/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vulkan.declaracion;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author gabri
 */
@Entity
@Table (name="factura")
public class decFactura {
    @Id
    private int id_factura;
    @Column
    private double total;
    @Column 
    private double impuesto; 
    @Column 
    private int id_pedido;
    @Column
    private int id_mesa;
    @Column
    private int id_empleado_cajero;
    @Column
    private int id_tipo_pago;
    @Column
    private int numero_de_tarjeta;
    @Column
    private double sub_total;
    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(int id_mesa) {
        this.id_mesa = id_mesa;
    }

    public int getId_empleado_cajero() {
        return id_empleado_cajero;
    }

    public void setId_empleado_cajero(int id_empleado_cajero) {
        this.id_empleado_cajero = id_empleado_cajero;
    }

    public int getId_tipo_pago() {
        return id_tipo_pago;
    }

    public void setId_tipo_pago(int id_tipo_pago) {
        this.id_tipo_pago = id_tipo_pago;
    }

    public int getNumero_de_tarjeta() {
        return numero_de_tarjeta;
    }

    public void setNumero_de_tarjeta(int Numero_de_tarjeta) {
        this.numero_de_tarjeta = Numero_de_tarjeta;
    }

    public double getSub_total() {
        return sub_total;
    }

    public void setSub_total(double sub_total) {
        this.sub_total = sub_total;
    }
    
}
