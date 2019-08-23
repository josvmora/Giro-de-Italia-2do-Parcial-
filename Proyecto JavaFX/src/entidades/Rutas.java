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
 * @author Hernan
 */
public class Rutas implements Serializable {
    private static Integer codigo_incremental = 1;
    private final Integer codigo;
    private String nombre;
    private Integer distancia;
    private byte[] imagen;
    private ArrayList<Estaciones> estaciones;
    
    public Rutas (String nombre, Integer distancia, byte[] imagen, ArrayList<Estaciones> estaciones){
        this.codigo = Rutas.codigo_incremental++;
        this.nombre = nombre;
        this.distancia = distancia;
        this.imagen = imagen;
        this.estaciones = estaciones;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the distancia
     */
    public Integer getDistancia() {
        return distancia;
    }

    /**
     * @param distancia the distancia to set
     */
    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    /**
     * @return the imagen
     */
    public byte[] getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the estaciones
     */
    public ArrayList<Estaciones> getEstaciones() {
        return estaciones;
    }

    /**
     * @param estaciones the estaciones to set
     */
    public void setEstaciones(ArrayList<Estaciones> estaciones) {
        this.estaciones = estaciones;
    }
    
    
}
