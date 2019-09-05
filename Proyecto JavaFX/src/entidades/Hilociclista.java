/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author User
 */
public class Hilociclista extends Thread {
    private Ciclista c;
    private Rutas r;
    private int i;
    private int minuto;
    private int segundo;
    private GridPane root;
    private Label lbl;
    private int dis;
    
    //private ArrayList<Ciclista> fg;
    public Hilociclista(Ciclista c, Rutas r,Label lbl,GridPane root,int minuto,int segundo) {
        this.c = c;
        this.r=r;
        this.lbl=lbl;
        this.root=root;
        this.minuto=minuto;
        this.segundo=segundo;
        
    }
    public void run() {
        try {
            long ti=System.currentTimeMillis();
            for (int i = 1; i <= r.getDistancia(); i++) {
                dis=i;
                System.out.println(c.getNombre()+"      "+i);
                for(Estaciones es:r.getEstaciones()){
                    if(i==es.getKilometro()){
                        es.agregar(c);
                        long ts=System.currentTimeMillis();
                        Platform.runLater(() -> lbl.setText("Distancia: "+dis+" Ciclista: "+c.getNombre()+"Tiempo: "+(ts-ti)));
                        
                        
                    }
                }
                
                //Platform.runLater(() -> lbl.setText("Distancia: "+dis+" Ciclista: "+c.getNombre()));
                
                
                
                
                Thread.sleep((int)(Math.random()*1000));
            }
            long tf=System.currentTimeMillis();
            long tt= tf-ti;
            Platform.runLater(() -> lbl.setText("Distancia: "+dis+" Ciclista: "+c.getNombre()+"Tiempo de llegada: "+tt));
            c.setTime_llegada(tt);
           
            System.out.println(c.getNombre()+" "+tt);
            
           } catch (InterruptedException exc) {
             exc.printStackTrace();
           }
    }
    
    
    public Ciclista getCiclista() {
        return c;
    }
    
    public int getDistancia(){
        return dis;
    }
    
}
