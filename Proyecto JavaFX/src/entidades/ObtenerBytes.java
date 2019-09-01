/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import javafx.scene.image.Image;

/**
 *
 * @author User
 */
public class ObtenerBytes {

    public byte[] extractBytes(String imgPath) throws IOException {
        File objetofile = new File(imgPath);
        ByteArrayOutputStream baos = new ByteArrayOutputStream(1000);
        BufferedImage img = ImageIO.read(objetofile);
        ImageIO.write(img, "jpg", baos);
        //baos.flush();
        byte[] data = baos.toByteArray();
        //String base64String = Base64.encode(baos.toByteArray());
        //baos.close();

        //byte[] bytearray = Base64.decode(base64String);
        //RecortarFotografia recorte = new RecortarFotografia(bufferedImage,100,100);
//        WritableRaster raster =  bufferedImage.getRaster();
//        DataBufferByte data = (DataBufferByte) raster.getDataBuffer();
        return data;
    }

    public Image createImage(byte[] data, String nombre_ruta) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        BufferedImage bImage2 = ImageIO.read(bis);
        ImageIO.write(bImage2, "png", new File(nombre_ruta+".png"));
        System.out.println("image created");
        File file = new File(nombre_ruta+".png");
        String path = file.getAbsolutePath();
        System.out.println(path+"************sss*");
        Image image = new Image(file.toURI().toURL().toString());
        return image;
         
    }
}
