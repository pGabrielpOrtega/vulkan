/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vulkan.validacion;

import com.mycompany.controlador.controlPuesto;
import com.mycompany.vulkan.gui.jFramePuesto;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vulkan.declaracion.decPuesto;

/**
 *
 * @author gabri
 */
public class boxPuesto {
    controlPuesto puestoDao = new controlPuesto();
    decPuesto puesto = new decPuesto();
    
   /*private void comboBoxArea(){
        box_puesto.removeAllItems();
        
        List<decPuesto> area = this.puestoDao.findclientesEntities();
        
        box_puesto.addItem("Seleccione");
        
        for(decPuesto AreaLaboral : area)
        {
            String lista = AreaLaboral.getNombre();
            box_puesto.addItem(lista);
        } 
    }*/
}
