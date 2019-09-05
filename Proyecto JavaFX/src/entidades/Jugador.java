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
    private CiclistaSeleccionado[] ciclistas_elegidos;//cambiar por clase ciclista seleccionado

    public Jugador(String nombre, CiclistaSeleccionado[] ciclistas_elegidos) {
        this.nombre = nombre;
        this.ciclistas_elegidos = ciclistas_elegidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CiclistaSeleccionado[] getCiclistas_elegidos() {
        return ciclistas_elegidos;
    }

    public void setCiclistas_elegidos(CiclistaSeleccionado[] ciclistas_elegidos) {
        this.ciclistas_elegidos = ciclistas_elegidos;
    }
    
    
    public int Aciertos(ArrayList<Ciclista> cicl){
        int acu=0;
        
        
        for(CiclistaSeleccionado cs:ciclistas_elegidos){
            int i=1;
            for(Ciclista c:cicl){
                if(c.getNombre().equals(cs.getCicli().getNombre())){
                    if(i==cs.getPosicion()){
                        acu+=1;
                    }
                }
                i++;
            }
        }
        
        return acu;
    }
        

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", ciclistas_elegidos=" + ciclistas_elegidos + '}';
    }
    
   
}
