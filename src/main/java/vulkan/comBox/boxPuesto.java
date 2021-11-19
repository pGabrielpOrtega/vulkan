/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vulkan.comBox;

import com.mycompany.controlador.controlPuesto;
import com.mycompany.vulkan.gui.jFramePuesto;
import java.sql.ResultSet;
import java.util.HashMap;
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
    
   /* public HashMap<String, Integer> populateCombo(){
        HashMap<String, Integer> map = new HashMap<String, Integer>()
                
        ResultSet rs;
        try {
            puestoDao.findclientesEntities();
            puesto p;
        } catch (Exception ex) {
            Logger.getLogger(jFramePuesto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}
