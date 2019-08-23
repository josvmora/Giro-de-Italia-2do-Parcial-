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
public class Ciclista implements Serializable{
    private String nombre;
    private byte[] imagen;
    private static int contadori = 1;
    private int codigo;
    
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

    @Override
    public String toString() {
        return  codigo + "|" + nombre  ;
    }
    
    
}