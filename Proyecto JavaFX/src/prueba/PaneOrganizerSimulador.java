/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import entidades.Estaciones;
import entidades.Jugador;
import entidades.ObtenerBytes;
import entidades.Rutas;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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
    private GridPane root;
    private Group grupo;
    private Rutas ruta_seleccionada;
    private Image iruta;
    private Label tiempo_actual;
    private ArrayList<Jugador> jugadores;
    public PaneOrganizerSimulador(Rutas ruta, ArrayList<Jugador> jugadores){
        this.jugadores = jugadores;
        this.ruta_seleccionada = ruta;
        createContent();
    }
    
    public Pane getRoot(){
        return root;
    }
    
    public void createContent(){
        root = new GridPane();
        grupo = new Group();
        ObtenerBytes ob = new ObtenerBytes();
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
        
       
    }
    
}
