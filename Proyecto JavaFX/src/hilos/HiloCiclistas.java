/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import entidades.CiclistaEnCarrera;
import entidades.Rutas;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Hernan
 */
public class HiloCiclistas implements Runnable{
    private GridPane root;
    private Label lbl;
    private CiclistaEnCarrera ciclista;
    private Rutas ruta;
    
    public HiloCiclistas(CiclistaEnCarrera ciclista, Rutas ruta,Label lbl,GridPane root){
        this.ciclista = ciclista;
        this.ruta = ruta;
        this.lbl = lbl;
        this.root = root;
    }
     @Override
    public void run(){
            try{
                for(int i = 0 ; i<=ruta.getDistancia() ; i++){
                    int dis=0+i;
                    
                    Platform.runLater(() -> ciclista.setKilometraje(dis));
                    Platform.runLater(() -> lbl.setText(Integer.toString(dis)));
                    Thread.sleep((int)(Math.random()*1000));
                    
                    
                   
                   
                }
            }catch(InterruptedException exc){
                exc.printStackTrace();
            }
            
                
                      
        }
}
