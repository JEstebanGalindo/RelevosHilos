/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.carrerahilos;

/**
 *Clase Equipos
 * @author julian esteban vallejo galindo
 */
public class Equipos {
    private String nombreEquipo;
    private int idEquipo;

    /**
     * constructor clase Equipos
     * @param nombreEquipo almacena nombre equipo
     * @param idEquipo almacena el id del equipo
     */
    public Equipos(String nombreEquipo, int idEquipo) {
        this.nombreEquipo = nombreEquipo;
        this.idEquipo = idEquipo;
    }

    /**
     * getter nombreEquipo
     * @return nombreEquipo
     */
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    /**
     * setter nombreEquipo
     * @param nombreEquipo nombreEquipo
     */
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    /**
     * getter idEquipo
     * @return idEquipo
     */
    public int getIdEquipo() {
        return idEquipo;
    }

    /**
     * setter idEquipo
     * @param idEquipo idEquipo
     */
    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }
    
}
