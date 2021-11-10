/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vulkan.validacion;
import org.apache.commons.validator.routines.EmailValidator;
/**
 *
 * @author gabri
 */
public class valEmail {
   
   
   public static boolean email(String str){
       boolean va = EmailValidator.getInstance().isValid(str);
       return va;
   }
}
