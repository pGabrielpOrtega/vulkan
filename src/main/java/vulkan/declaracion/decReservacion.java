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
@Table (name="Reservacion")
public class decReservacion {
    @Id
    private int idCliente;
    
    
    
    public int getId() {
        return idCliente;
    }

    public void setId(int id) {
        this.idCliente = id;
}
    
}
