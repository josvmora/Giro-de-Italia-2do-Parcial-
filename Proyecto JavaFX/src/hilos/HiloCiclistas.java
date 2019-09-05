/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import entidades.CiclistaEnCarrera;
import entidades.Estaciones;
import entidades.Rutas;
import java.time.LocalTime;
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
    private int dis;
    private int minuto;
    private int segundo;
    private LocalTime lt;
    private int pos;
    
    public HiloCiclistas(CiclistaEnCarrera ciclista, Rutas ruta,Label lbl,GridPane root,int minuto,int segundo){
        this.ciclista = ciclista;
        this.ruta = ruta;
        this.lbl = lbl;
        this.root = root;
        this.minuto = minuto;
        this.segundo = segundo;
    }
     @Override
    public void run(){
            try{
                for(int i = 0 ; i<=ruta.getDistancia() ; i++){
                    dis=0+i;
                    for(Estaciones estacion: ruta.getEstaciones()){
                        if(dis == estacion.getKilometro()){
                            segundo = (minuto*60)+segundo-(30)/(pos*estacion.getCategoria());
                            lt = LocalTime.ofSecondOfDay(segundo);
                        }
                    
                    Platform.runLater(() -> ciclista.setKilometraje(dis));
                    Platform.runLater(() -> lbl.setText("Distancia: "+dis+" Ciclista: "+ciclista.getName()+" Tiempo: "+lt));
                    Thread.sleep((int)(Math.random()*1000));
                    }
                    
                   
                   
                }
            }catch(InterruptedException exc){
                exc.printStackTrace();
            }
            
                
                      
        }
    public int getDistancia(){
        return dis;
    }
}
