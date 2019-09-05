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
public class Estaciones implements Serializable{
    private static Integer auto_incremental = 1;
    private final Integer codigo;
   
    
    
    
    private Integer kilometro;
    private Integer categoria;
    private ArrayList<Ciclista> ciclis=new ArrayList<Ciclista>();
    
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

    public ArrayList<Ciclista> getCiclis() {
        return ciclis;
    }

    

    
    
    
    public void agregar(Ciclista c){
       ciclis.add(c);
        
        
    }
    
    
    
    @Override
    public String toString() {
        return "distancia: "+kilometro+" Km"+" / Categoria: "+categoria;
    }
    
    
    public void pasarDescuento(){
        int i=1;
        for (Ciclista c1:ciclis) {
            long premio=3000/(i*categoria);
            c1.setTime_descuento(premio);
            i++;
        }
    }
    
    
}
