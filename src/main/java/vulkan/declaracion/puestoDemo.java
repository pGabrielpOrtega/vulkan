/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vulkan.declaracion;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 *
 * @author gabri
 */
public class puestoDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration();
                                .configure("hibernate.cfg.xml");
                                .addAnnotedClass(decPuesto.class);
                                .buildSessionFactory();
    } 
}
