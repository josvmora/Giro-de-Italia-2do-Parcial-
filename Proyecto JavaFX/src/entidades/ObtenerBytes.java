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
import javax.imageio.ImageIO;

/**
 *
 * @author User
 */
public class ObtenerBytes {
     public byte[] extractBytes(String imgPath) throws IOException{
        File objetofile = new File(imgPath);
        BufferedImage bufferedImage = ImageIO.read(objetofile);
        //RecortarFotografia recorte = new RecortarFotografia(bufferedImage,100,100);
        WritableRaster raster =  bufferedImage.getRaster();
        DataBufferByte data = (DataBufferByte) raster.getDataBuffer();
        return (data.getData());
    }
}
