/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import archivo.Archivo;
import entidades.Ciclista;
//import entidades.CiclistaEnCarrera;
import entidades.Estaciones;
import entidades.Hilociclista;
import entidades.Jugador;
import entidades.ObtenerBytes;
import entidades.Rutas;
//import hilos.HiloCiclistas;
import hilos.HiloCronometro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author MI
 */
public class PaneOrganizerSimulador {

    private Button inicio;
    private Button pausa;
    private Button play;
    private GridPane root;
    private Group grupo;
    private Rutas rutita;
    private Image iruta;
    private Label tiempo_actual;
    private ArrayList<Jugador> jugadores2;
    private ArrayList<Ciclista> ciclis;
    private Label lbl1;
    private Label lbl2;
    private Label lbl3;
    private Label lbl4;
    private Label lbl5;
    private Button resultadostotales;
    private Button aciertojugada;
    private Button salir;
    private Button detener_reloj;
   
   

    public PaneOrganizerSimulador(Rutas rutita,ArrayList<Ciclista> ciclis,ArrayList<Jugador> jugadores2) {
        this.rutita = rutita;
        this.ciclis=ciclis;
        this.jugadores2=jugadores2;
        createContent();
    }

    public Pane getRoot() {
        return root;
    }

    public void createContent() {
        inicio = new Button("INICIAR");
        pausa=new Button("PAUSA");
        play=new Button("PLAY");
        resultadostotales=new Button("Resultados totales");
        aciertojugada=new Button("Resultados jugadores");
        salir=new Button("SALIR");
        detener_reloj=new Button("S. Watch");
                
        root = new GridPane();
        grupo = new Group();
        ObtenerBytes ob = new ObtenerBytes();
        tiempo_actual = new Label("00:00");
        lbl1 = new Label("");
        lbl2 = new Label("");
        lbl3 = new Label("");
        lbl4 = new Label("");
        lbl5 = new Label("");
        ArrayList<Label> ilabels = new ArrayList();
        ArrayList<Label> labels = new ArrayList<Label>();

        try {
            iruta = ob.createImage(rutita.getImagen(), rutita.getNombre());
        } catch (IOException ex) {
            Logger.getLogger(PaneOrganizerSimulador.class.getName()).log(Level.SEVERE, null, ex);
        }
        Canvas canvas = new Canvas(600, 300);
        grupo.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(iruta, 0, 0, 600, 300);
        Image iestacion = new Image("estacion.jpg");
        for (Estaciones estacion : rutita.getEstaciones()) {
            gc.drawImage(iestacion, ((600 * estacion.getKilometro()) / rutita.getDistancia()), 50, 20, 40);
        }

//        final long starttime = System.currentTimeMillis();
//        final long time = System.nanoTime();
//        System.out.println(starttime);
//        System.out.println(time);
        //tiempo_actual = new Label(starttime);
        root.add(grupo, 0, 0);
        root.setAlignment(Pos.CENTER);
        root.add(inicio, 1, 0);
        root.add(pausa,1,3);
        root.add(play,1,4);
        root.add(detener_reloj,5,4);
        root.add(salir,5,5);
        root.add(resultadostotales,1,5);
        root.add(aciertojugada,1,6);
        root.add(tiempo_actual, 1, 1, 2, 1);
        labels.add(lbl1);
        labels.add(lbl2);
        labels.add(lbl3);
        labels.add(lbl4);
        labels.add(lbl5);
        root.add(lbl1, 0, 5);
        root.add(lbl2, 0, 6);
        root.add(lbl3, 0, 7);
        root.add(lbl4, 0, 8);
        root.add(lbl5, 0, 9);

//        ArrayList<Ciclista> ciclistas = new ArrayList<Ciclista>();
//        ArrayList<CiclistaEnCarrera> ciclistaC = new ArrayList<CiclistaEnCarrera>();
//        try {
//            ciclistas = Archivo.obtener_registros("Ciclista.dat");
//
//        } catch (Exception e) {
//            System.out.println("ERROR");
//        }
//        for (Ciclista cic : ciclistas) {
//            CiclistaEnCarrera c = new CiclistaEnCarrera(cic.getCodigo(), cic.getNombre(), cic.getImagen(), 0);
//            ciclistaC.add(c);
//        }
        HiloCronometro tc = new HiloCronometro(PaneOrganizerSimulador.this, tiempo_actual, 00, 00);
        Thread reloj=new Thread(tc);

        ArrayList<Hilociclista> superhilo= new ArrayList<Hilociclista>();
        for (int i = 0; i < ciclis.size(); i++) {
              superhilo.add(new Hilociclista(ciclis.get(i),rutita,labels.get(i),root,tc.getMinuto(),tc.getSegundo()));
                }
        
        
        
        
        
        
        
        

        inicio.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PaneOrganizerSimulador.this.inicio.setDisable(true);
                reloj.start();
                for (Hilociclista h : superhilo) {
                 try {   
                 Image iciclista = ob.createImage(h.getCiclista().getImagen(), h.getCiclista().getNombre());
                 h.start();
                 
                  new AnimationTimer() {
                            @Override
                            public void handle(long currentNanoTime) {
//                                double t = (currentNanoTime - startNanoTime) / 1000000000.0;
//
//                                double x = 232 + 128 * Math.cos(t);
//                                double y = 232 + 128 * Math.sin(t);

                                gc.drawImage(iciclista, ((600*h.getDistancia())/rutita.getDistancia()), 250, 20, 20);
                            }
                        }.start();
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                } catch (IOException ex) {
                        Logger.getLogger(PaneOrganizerSimulador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                

           }
        });
        
            pausa.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { 
                reloj.suspend();
                for (Hilociclista h : superhilo) {
                    h.suspend();
                  }
                }
        });
        
            play.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { 
                reloj.resume();
                for (Hilociclista h : superhilo) {
                    h.resume();
                  }
                }
        });
        
            aciertojugada.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { 
                Stage stage = new Stage();
                PaneOrganizerResultadosj rootContainer = new PaneOrganizerResultadosj(rutita,ciclis,jugadores2);
                Scene scene = new Scene(rootContainer.getRoot(),900,600);
                stage.setTitle("Aciertos por jugadores");
                stage.setScene(scene);
                stage.show();
                }
        });
            
            
             resultadostotales.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { 
                Stage stage = new Stage();
                PaneOrganizerResultadosg rootContainer = new PaneOrganizerResultadosg(rutita,ciclis);
                Scene scene = new Scene(rootContainer.getRoot(),1100,800);
                stage.setTitle("Aciertos por jugadores");
                stage.setScene(scene);
                stage.show();
                }
        });
            
            salir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { 
               JOptionPane.showMessageDialog(null, "Gracias  por visitar nuestro programa, que tenga un buen dia");
               System.exit(0);
                }
        });
            
            detener_reloj.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { 
               reloj.stop();
                }
        });
            
            
            
        
        
        
    }

}
