/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import javax.imageio.ImageIO;

/**
 *
 * @author User
 */
public class Ciclista implements Serializable, Comparable<Ciclista>{
    private String nombre;
    private byte[] imagen;
    private static int contadori = 1;
    private int codigo;
    private long time_descuento;
    private long time_llegada;
    
    public Ciclista(String nombre, byte[] imagen){
        this.nombre = nombre;
        this.imagen = imagen;
        this.codigo = contadori++;
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

    public int getCodigo() {
        return codigo;
    }

    
    
    
    public long getTime_descuento() {
        return time_descuento;
    }

    public void setTime_descuento(long time_descuento) {
        this.time_descuento += time_descuento;
    }

    public long getTime_llegada() {
        return time_llegada;
    }

    public void setTime_llegada(long time_llegada) {
        this.time_llegada = time_llegada;
    }
    
    
    public long tiempoTotal(){
        return time_llegada-time_descuento;
    }
    
    public int compareTo(Ciclista cl) {
        if((time_llegada-time_descuento)<cl.tiempoTotal()){
            return -1;
        }
        if((time_llegada-time_descuento)>cl.tiempoTotal()){
            return 1;
        }
        return 0;
    }
    
    
    
    
    
    

    @Override
    public String toString() {
        return  codigo + "|" + nombre  ;
    }
    
    
}