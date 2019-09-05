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
public class CiclistaEnCarrera implements Serializable{
    private int id;
    private String name;
    private byte[] foto;
    private Integer kilometraje;
    
    public CiclistaEnCarrera(int id, String name,byte[] foto, Integer kilometraje){
        this.id = id;
        this.name = name;
        this.foto = foto;
        this.kilometraje = kilometraje;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the foto
     */
    public byte[] getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    /**
     * @return the kilometraje
     */
    public Integer getKilometraje() {
        return kilometraje;
    }

    /**
     * @param kilometraje the kilometraje to set
     */
    public void setKilometraje(Integer kilometraje) {
        this.kilometraje = kilometraje;
    }
    @Override
   public String toString(){
       return this.id+" "+this.name+"  (Km): "+this.kilometraje;
   }
}
