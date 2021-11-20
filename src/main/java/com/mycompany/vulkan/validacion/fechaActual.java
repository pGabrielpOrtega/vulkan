/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vulkan.validacion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author fer3dev
 */

public class fechaActual {

    public String getFechaActual() {
        DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        return dtf4.format(LocalDateTime.now());
    }
    
    public String anio() {
        DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy");
        return dtf4.format(LocalDateTime.now());
    }
    
    public String mes() {
        DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("MM");
        return dtf4.format(LocalDateTime.now());
    }
    
    public String dia() {
        DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("dd");
        return dtf4.format(LocalDateTime.now());
    }
    
    public String hora() {
        DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("HH");
        return dtf4.format(LocalDateTime.now());
    }
    
    public String minuto() {
        DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("mm");
        return dtf4.format(LocalDateTime.now());
    }
    
    public String anio(String fecha) {
        String[] partes = fecha.split(" ");
        String[] anio = partes[0].split("-");
        return anio[0];
    }
    
    public String mes(String fecha) {
        String[] partes = fecha.split(" ");
        String[] mes = partes[0].split("-");
        return mes[1];
    }
    
    public String dia(String fecha) {
        String[] partes = fecha.split(" ");
        String[] dia = partes[0].split("-");
        return dia[2];
    }
    
    public String hora(String fecha) {
        String[] partes = fecha.split(" ");
        String[] hora = partes[1].split(":");
        return hora[0];
    }
    
    public String minuto(String fecha) {
        String[] partes = fecha.split(" ");
        String[] minutos = partes[1].split(":");
        return minutos[1];
    }

}
