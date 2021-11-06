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
    public void tresKey(String str){
        int a = str.length();
        if(a >= 3){
             JOptionPane.showMessageDialog(this, "Es mayor a 3");
        }else{
            JOptionPane.showMessageDialog(this, "Es menor a 3 ");
        }
    }
    
}
