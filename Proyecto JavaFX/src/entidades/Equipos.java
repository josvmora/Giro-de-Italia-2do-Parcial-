/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Equipos implements Serializable {
    private String nombre_equipo;
    private byte[] imagen_equipo;
    private ArrayList<Ciclista> ciclistas;

    public Equipos(String nombre_equipo, byte[] imagen_equipo, ArrayList<Ciclista> ciclistas) {
        this.nombre_equipo = nombre_equipo;
        this.imagen_equipo = imagen_equipo;
        this.ciclistas = ciclistas;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public byte[] getImagen_equipo() {
        return imagen_equipo;
    }

    public void setImagen_equipo(byte[] imagen_equipo) {
        this.imagen_equipo = imagen_equipo;
    }

    public ArrayList<Ciclista> getCiclistas() {
        return ciclistas;
    }

    public void setCiclistas(ArrayList<Ciclista> ciclistas) {
        this.ciclistas = ciclistas;
    }

    public void agregarCiclista(Ciclista c){
        ciclistas.add(c);
    }
    
    
    
}
