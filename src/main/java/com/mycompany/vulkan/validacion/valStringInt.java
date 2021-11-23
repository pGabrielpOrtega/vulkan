/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vulkan.validacion;

/**
 * @author fer3dev
 */
//Valida que se ingresen solo numeros y letras
public class valStringInt {

    public void letras_numeros(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z')) {
            if (!Character.isDigit(c)) {
                evt.consume();
            }
        }
    }

    public void letras(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z')) {
            evt.consume();
        }
    }

    public void numeros(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }
}
