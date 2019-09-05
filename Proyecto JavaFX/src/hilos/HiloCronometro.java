/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import javafx.application.Platform;
import javafx.scene.control.Label;
import prueba.PaneOrganizerSimulador;

/**
 *
 * @author Hernan
 */
public class HiloCronometro implements Runnable {
    private PaneOrganizerSimulador po;
    private Label cronometro;
    private int minuto;
    private int segundo;
    
    public HiloCronometro(PaneOrganizerSimulador po,Label cronometro, int minuto, int segundo){
        this.po = po;
        this.cronometro = cronometro;
        this.minuto = minuto;
        this.segundo = segundo;
    }
    @Override
    public void run(){
        try{
            
            for(minuto=0 ; minuto<60 ; minuto++){
                for(segundo=0 ; segundo<60 ; segundo++){
                    Platform.runLater(() -> cronometro.setText(minuto+":"+segundo));
                    Thread.sleep(1000);
                    
                }
            }
        }catch(InterruptedException exc){
            exc.printStackTrace();
        }
    }
}
