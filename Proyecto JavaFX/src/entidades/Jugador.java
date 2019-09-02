/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;

/**
 *
 * @author MI
 */
public class Jugador {
    private String nombre;
    private ArrayList<Ciclista> ciclistas_elegidos;
    
    public Jugador(String nombre, ArrayList<Ciclista> ciclistas_elegidos){
        this.nombre = nombre;
        this.ciclistas_elegidos = ciclistas_elegidos;
    }
}
