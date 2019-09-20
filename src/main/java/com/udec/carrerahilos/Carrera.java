/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.carrerahilos;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *Clase Carrera
 * @author julian esteban vallejo galindo
 */
public class Carrera extends Thread {

    private int posicion;
    private int equipo;
    Equipos equipos;
    private int pista;
    String camino = "_________________________________";
    String caminoUno = "_________________________________";
    StringBuffer nuevoCaminoUno = new StringBuffer(caminoUno); 
    
    String camino2 = "_________________________________";
    String caminoDos = "_________________________________";
    StringBuffer nuevoCaminoDos = new StringBuffer(caminoDos); 
    
    String camino3 = "_________________________________";
    String caminoTres = "_________________________________";
    StringBuffer nuevoCaminoTres = new StringBuffer(caminoTres); 
    
    public static final String reset = "\u001B[0m";
    public static final String verde = "\u001B[32m";
    public static final String rojo = "\u001B[31m";
    public static final String negro = "\u001B[30m";

    /**
     * constructor clase Carrera
     * @param posicion
     * @param equipo
     * @param equipos
     * @param pista 
     */
    public Carrera(int posicion, int equipo, Equipos equipos, int pista) {
        this.posicion = posicion;
        this.equipo = equipo;
        this.equipos = equipos;
        this.pista = pista;
    } 

    /**
     * getter posicion
     * @return posicion del corredor
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * setter posicion
     * @param posicion posicion del corredor
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    } 

    /**
     * getter equipo
     * @return equipo del corredor
     */
    public int getEquipo() {
        return equipo;
    }

    /**
     * setter equipo
     * @param equipo equipo del jugador
     */
    public void setEquipo(int equipo) {
        this.equipo = equipo;
    }

    /**
     * getter pista
     * @return pista
     */
    public int getPista() {
        return pista;
    }

    /**
     * setter pista
     * @param pista almacena la pista
     */
    public void setPista(int pista) {
        this.pista = pista;
    }
    
    
    /**
     * Metodo heredado de Thread para hilos
     */
    @Override
    public void run(){
        if (pista == 1) {
            pintarPrimeraMeta();
        } else {           
            esperaHilo();
        }
        if (pista == 2) {
            pintarSegundaMeta();
        } else {          
            esperaHilo();
        }
        if (pista == 3) {
            pintarTerceraMeta();
        } else {
            esperaHilo();
        }  
    }
    
    /**
     * metodo que pinta cuando un corredor esta en el 1 relevo
     */
    public void pintarPrimeraMeta() {
        while(true){
            if(posicion <=32){
                pintarMeta(posicion, equipo, pista);
                posicion = posicion + (generarNumero(1, 3));
            }else{
                synchronized (equipos) {
                    equipos.notifyAll();         
                    pista = 2;
                    posicion=0;
                }
                break;                             
            }
        }
    }
    
    /**
     * metodo que pinta cuando un corredor esta en el segundo relevo
     */
    public void pintarSegundaMeta() {
        while(true){
            if(posicion <=32){
                pintarMeta(posicion, equipo, pista);
                posicion = posicion + (generarNumero(1, 3));
            }else{
                synchronized (equipos) {                                       
                    posicion = 0;
                    equipos.notify();
                    pista=3;
                }
                System.out.println(equipos.getNombreEquipo()+" Llegó a la meta primero");
                System.exit(0);
                break;                           
            }
        }
    }
    
    /**
     * metodo que pinta cuando hay un ganador
     */
    public void pintarTerceraMeta() {
        while(true){
            if(posicion <=32){
                pintarMeta(posicion, equipo, pista);
                posicion = posicion + (generarNumero(1, 3));
            }else{
                System.out.println(equipos.getNombreEquipo()+" Llegó a la meta primero");
                System.exit(0);
            }
            break;                                         
        }
    }

    /**
     * metodo generar numero random entre maximo y minimo
     * @param min minimo numero randomico
     * @param max maximo numero randomico
     * @return numero random
     */
    public int generarNumero(int min, int max) {
        Random r = new Random();
        return r.ints(min, (max + 1)).findFirst().getAsInt();
    }
    
    /**
     * metodo que borra consola
     */
    public void borrarConsola(){       
       for(int i=0; i<=2; i++){
           System.out.println(" ");
       }
    }
    
    /**
     * metodo que pinta la carrera 
     * @param posicion almacena la posicion del corredor
     * @param equipo almacena el equipo del corredor
     * @param pista almacena en que pista esta el corredor
     */
    public void pintarMeta(int posicion, int equipo, int pista){
        if(equipo==1){
            if(pista==1){
                caminoUno(verde);
            }else if(pista==2){
                caminoDos(verde);
            }else if (pista==3){
                caminoTres(verde);
            }
        }else if(equipo==2){
            if(pista==1){
                caminoUno(rojo);
            }else if(pista==2){
                caminoDos(rojo);
            }else if(pista==3){
                caminoTres(rojo);
            }
        }else if (equipo==3){
            if(pista==1){
                caminoUno(negro);
            }else if(pista==2){
                caminoDos(negro);
            }else if(pista==3){
                caminoTres(negro);
            }
        }
        tiempoEspera();        
    }
    
    /**
     * metodo que hace una pausa y borra consola
     */
    public void tiempoEspera(){
        borrarConsola();
        try {
            Thread.sleep(500);
        }catch (InterruptedException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * metodo que pinta el camino numero 1
     * @param color lleva almacenado que color es
     */
    public void caminoUno(String color){
        nuevoCaminoUno.setCharAt(posicion, 'O');
        caminoUno = nuevoCaminoUno.toString();
        nuevoCaminoDos.setCharAt(0, '¶');
        caminoDos = nuevoCaminoDos.toString();
        nuevoCaminoTres.setCharAt(0, 'X');
        caminoTres = nuevoCaminoTres.toString();
        System.out.println(color + caminoUno + caminoDos + caminoTres + reset);           
        nuevoCaminoUno.setCharAt(posicion, '_');
    }
    
    /**
     * metodo que pinta el camino numero 2
     * @param color lleva almacenado que color es
     */
    public void caminoDos(String color){
        nuevoCaminoUno.setCharAt(32, 'O');
        caminoUno = nuevoCaminoUno.toString();
        nuevoCaminoDos.setCharAt(posicion, '¶');
        caminoDos = nuevoCaminoDos.toString();
        nuevoCaminoTres.setCharAt(0, 'X');
        caminoTres = nuevoCaminoTres.toString();
        System.out.println(color + caminoUno + caminoDos + caminoTres + reset);
        nuevoCaminoDos.setCharAt(posicion, '_');
    }
    
    /**
     * metodo que pinta el camino numero 3
     * @param color lleva almacenado que color es
     */
    public void caminoTres(String color){
        nuevoCaminoUno.setCharAt(32, 'O');
        caminoUno = nuevoCaminoUno.toString();
        nuevoCaminoDos.setCharAt(32, '¶');
        caminoDos = nuevoCaminoDos.toString();
        nuevoCaminoTres.setCharAt(posicion, 'X');
        caminoTres = nuevoCaminoTres.toString();
        System.out.println(color + caminoUno + caminoDos + caminoTres + reset);           
        nuevoCaminoTres.setCharAt(posicion, '_');
    }
    
    /**
     * Método que hace que el corredor espere si es necesario 
     */
    public void esperaHilo(){
        synchronized (equipos) {
            try {
                equipos.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
