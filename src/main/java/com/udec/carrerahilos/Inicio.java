/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.carrerahilos;

/**
 *Clase Inicio
 * @author julian esteban vallejo galindo
 */
public class Inicio {
    Equipos verde = new Equipos("Verde", 1);
    Equipos rojo = new Equipos("Rojo", 2);
    Equipos negro = new Equipos("Negro",3);
    
    Carrera verde1 = new Carrera(0,1,verde,1);
    Carrera verde2 = new Carrera(0,1,verde,2);
    Carrera verde3 = new Carrera(0,1,verde,3);
    Carrera rojo1 = new Carrera(0,2,rojo,1);
    Carrera rojo2 = new Carrera(0,2,rojo,2);
    Carrera rojo3 = new Carrera(0,2,rojo,3);
    Carrera negro1 = new Carrera(0,3,negro,1);
    Carrera negro2 = new Carrera(0,3,negro,2);
    Carrera negro3 = new Carrera(0,3,negro,3);
    
    /**
     * metodo inicia hilos
     */
    public void iniciarHilos(){       
        verde1.start();
        verde2.start();
        verde3.start();
        rojo1.start();
        rojo2.start();
        rojo3.start();
        negro1.start();
        negro2.start();
        negro3.start();     
    }

    /**
     * Inicio Programa
     * @param args 
     */
    public static void main(String[] args) {       
        
        Inicio inicio = new Inicio();
        inicio.iniciarHilos();
    }
}
