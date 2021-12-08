/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vulkan.validacion;

import org.apache.commons.validator.routines.EmailValidator ;
/**
 *
 * @author fer3dev
 */
public class valEmail {
        public static boolean email(String str) {
            boolean va  = EmailValidator.getInstance().isValid(str);
            return va;
        }
    }