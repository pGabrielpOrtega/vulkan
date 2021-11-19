/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vulkan.validacion;

import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class valString extends javax.swing.JFrame{
    //validar que sea solamente letras en el key type
    public void letras(java.awt.event.KeyEvent evt){
        char c = evt.getKeyChar();
        if((c < 'A' || c > 'Z') && (c <'a' || c > 'z')){
            if(c == 32 || c == 45 || c == 47){
                
            }
            else{
                evt.consume();
            }
        }
    }
    // validar que el string tenga tres letras
    public static boolean tresKey(String str){
        int a = str.length();
        if(a >= 3){
             
             return true;
             
        }else{
            return false;
        }
    }
    public static boolean ochoKey(String str){
        int a = str.length();
        if(a >= 8){
             return true;
 
        }else{
            return false;
        }
    }
    public void consumeMayor25(java.awt.event.KeyEvent evt,String str){
        int a = str.length();
        if(a <= 25){
            
        }else{
            evt.consume();
        }
    }
    public void consumeMayor50(java.awt.event.KeyEvent evt,String str){
        int a = str.length();
        if(a <= 49){
            
        }else{
            evt.consume();
        }
    }
    
    
}
