/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vulkan.validacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author fer3dev
 */

public class valContrasenia {
    
    //Comprueba que la contrasenia tenga al menos 1 numero, 1 letra y 1 caracter especial
    public static boolean Password_Validation(String password) {

        if(password.length()>=8)
        {
            Pattern letter = Pattern.compile("[a-zA-z]");
            Pattern digit = Pattern.compile("[0-9]");
            Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
            //Pattern eight = Pattern.compile (".{8}");


               Matcher hasLetter = letter.matcher(password);
               Matcher hasDigit = digit.matcher(password);
               Matcher hasSpecial = special.matcher(password);

               return hasLetter.find() && hasDigit.find() && hasSpecial.find();

        }
        else
            return false;

    }
    
}
