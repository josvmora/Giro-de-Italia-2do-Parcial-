/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author User
 */
public class CiclistaSeleccionado {
    private Ciclista cicli;
    private int posicion;

    public CiclistaSeleccionado(Ciclista cicli, int posicion) {
        this.cicli = cicli;
        this.posicion = posicion;
    }

    public Ciclista getCicli() {
        return cicli;
    }

    public void setCicli(Ciclista cicli) {
        this.cicli = cicli;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return  "Ciclista:" + cicli + " posicion:" + posicion ;
    }
    
}
