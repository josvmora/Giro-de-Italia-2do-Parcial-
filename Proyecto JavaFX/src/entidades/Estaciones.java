/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;

/**
 *
 * @author Hernan
 */
public class Estaciones implements Serializable{
    private static Integer auto_incremental = 1;
    private final Integer codigo;
    private Integer kilometro;
    private Integer categoria;
    
    public Estaciones(Integer kilometro, Integer categoria){
        this.codigo = Estaciones.auto_incremental++;
        this.kilometro = kilometro;
        this.categoria = categoria;
    }

    /**
     * @return the kilometro
     */
    public Integer getKilometro() {
        return kilometro;
    }

    /**
     * @param kilometro the kilometro to set
     */
    public void setKilometro(Integer kilometro) {
        this.kilometro = kilometro;
    }

    /**
     * @return the categoria
     */
    public Integer getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }
    
}
