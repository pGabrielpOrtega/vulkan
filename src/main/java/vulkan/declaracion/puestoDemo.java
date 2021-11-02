/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vulkan.declaracion;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import vulkan.declaracion.decPuesto;
/**
 *
 * @author gabri
 */
public class puestoDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(decPuesto.class)
                                .buildSessionFactory();
        
        Session session = factory.getCurrentSession();
    } 
}
