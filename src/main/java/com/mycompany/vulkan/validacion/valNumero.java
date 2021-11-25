/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vulkan.validacion;

/**
 *
 * @author gabri
 */
public class valNumero {
    public void valKeyTypeNumeros(java.awt.event.KeyEvent evt){
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }
    public static boolean numMayorUno(int a ){
        if(a >= 1){
            return true;
            
    }else {
            return false;
        }
    }
    public static boolean telefono(int a){
        boolean f ;
        switch(a){
            case 2: 
                f = true;
                break;
            case 3:
                f = true;
                break;
            case 7:
                f = true;
                break;
            case 8:
                f = true;
                break;
            
            case 9:
                f = true;
                break;
            default: f = false;
        }
        
        return f;    
    }
    public void valTelefonoKeyType(java.awt.event.KeyEvent evt,Integer a){
        if(a <=8){
            
        }else{
            evt.consume();
        }
                
    }
    public static boolean unoKey(String str){
        int a = str.length();
        if(a >= 1){
             
             return true;
             
        }else{
            return false;
        }
    }
    public static boolean telefonoOcho(String str){
        int a = str.length();
        if(a >= 8){
            return true;
        }else{
            return false;
        }
        
    }
    public static boolean dni(String str){
        int a = str.length();
        if(a >=13 ){
            return true;
        }else {
            return false;
        }
    }
}
