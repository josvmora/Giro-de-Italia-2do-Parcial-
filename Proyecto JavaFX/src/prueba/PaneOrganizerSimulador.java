/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import archivo.Archivo;
import entidades.Ciclista;
import entidades.CiclistaEnCarrera;
import entidades.Estaciones;
import entidades.Jugador;
import entidades.ObtenerBytes;
import entidades.Rutas;
import hilos.HiloCiclistas;
import hilos.HiloCronometro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author MI
 */
public class PaneOrganizerSimulador {
    private Button inicio;
    private Button pausa;
    private GridPane root;
    private Group grupo;
    private Rutas ruta_seleccionada;
    private Image iruta;
    private Label tiempo_actual;
    private ArrayList<Jugador> jugadores;
    private Label lbl1;
    private Label lbl2;
    private Label lbl3;
    private Label lbl4;
    private Label lbl5;
    public PaneOrganizerSimulador(Rutas ruta, ArrayList<Jugador> jugadores){
        this.jugadores = jugadores;
        this.ruta_seleccionada = ruta;
        createContent();
    }
    
    public Pane getRoot(){
        return root;
    }
    
    public void createContent(){
        inicio = new Button("INICIAR");
        root = new GridPane();
        grupo = new Group();
        ObtenerBytes ob = new ObtenerBytes();
        tiempo_actual = new Label("00:00");
        lbl1 = new Label("");
        lbl2 = new Label("");
        lbl3 = new Label("");
        lbl4 = new Label("");
        lbl5 = new Label("");
        ArrayList<Label> labels = new ArrayList<Label>();
        
        try {
            iruta = ob.createImage(ruta_seleccionada.getImagen(), ruta_seleccionada.getNombre());
        } catch (IOException ex) {
            Logger.getLogger(PaneOrganizerSimulador.class.getName()).log(Level.SEVERE, null, ex);
        }
        Canvas canvas = new Canvas(600,300);
        grupo.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(iruta, 0, 0, 600, 300);
        Image iestacion = new Image("estacion.jpg");
        for(Estaciones estacion: ruta_seleccionada.getEstaciones() ){
            gc.drawImage(iestacion,((6*estacion.getKilometro())/ruta_seleccionada.getDistancia()),50,20,40);
        }
        
        
//        final long starttime = System.currentTimeMillis();
//        final long time = System.nanoTime();
//        System.out.println(starttime);
//        System.out.println(time);
        //tiempo_actual = new Label(starttime);
        root.getChildren().add(grupo);
        root.setAlignment(Pos.CENTER);
        root.add(inicio,0,0);
        root.add(tiempo_actual,1,0,2,1);
        labels.add(lbl1);
        labels.add(lbl2);
        labels.add(lbl3);
        labels.add(lbl4);
        labels.add(lbl5);
        root.add(lbl1,0,5);
        root.add(lbl2,0,6);
        root.add(lbl3,0,7);
        root.add(lbl4,0,8);
        root.add(lbl5,0,9);
        
        
        ArrayList<Ciclista> ciclistas = new ArrayList<Ciclista>();
        ArrayList<CiclistaEnCarrera> ciclistaC = new ArrayList<CiclistaEnCarrera>();
        try{
            ciclistas = Archivo.obtener_registros("Ciclista.dat");
            
        }catch(Exception e){
            System.out.println("ERROR");
        }    
        for (Ciclista cic : ciclistas){
            CiclistaEnCarrera c = new CiclistaEnCarrera(cic.getCodigo(),cic.getNombre(),cic.getImagen(),0);
            ciclistaC.add(c);
        }
       
        inicio.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle (ActionEvent event){
               PaneOrganizerSimulador.this.inicio.setDisable(true);
               new Thread(new HiloCronometro(PaneOrganizerSimulador.this,tiempo_actual,00,00)).start();
               for(int i = 0 ; i < ciclistaC.size(); i++){
                   new Thread(new HiloCiclistas(ciclistaC.get(i),ruta_seleccionada,labels.get(i),root)).start();
               }
               
           }
        });
    }
    
}
