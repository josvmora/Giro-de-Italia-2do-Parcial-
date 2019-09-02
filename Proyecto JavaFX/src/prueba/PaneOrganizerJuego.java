/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import entidades.Rutas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import archivo.Archivo;
import entidades.ObtenerBytes;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author MI
 */
public class PaneOrganizerJuego {

    private GridPane root;
    private ComboBox jugadores;
    private ComboBox<Rutas> ruta_jugar;
    private Button boton;
    private Label lb1;
    private Label lb2;
    private Rutas ruta_seleccionada;
    private int cant_jugadores;

    public PaneOrganizerJuego() {
        createContent();
    }

    public Pane getRoot() {
        return root;
    }

    public void createContent() {
        ObservableList<String> n_jugadores = FXCollections.observableArrayList("1", "2", "3", "4", "5");
        ObservableList<Rutas> os=FXCollections.observableArrayList();
        try{
            ArrayList<Rutas> rutas = Archivo.obtener_registros_rutas("Rutas.dat");
            for(Rutas ruta: rutas){
                os.add(ruta);
            }
        }catch(Exception e){
            System.out.println("ERROR");
        }
        root = new GridPane();
        boton = new Button("Continuar");
        ruta_jugar = new ComboBox(os);
        jugadores = new ComboBox(n_jugadores);
        //ruta_jugar.setButtonCell(new ListCell());
        ruta_jugar.setCellFactory(c -> new StatusListCell());
        lb1 = new Label("SELECCIONE NÚMERO DE JUGADORES");
        lb2 = new Label("SELECCIONE LA RUTA A UTILIZAR");
        root.add(lb1, 0, 0);
        root.add(jugadores, 1, 0);
        root.add(lb2, 0, 1);
        root.add(ruta_jugar, 1, 1);
        root.add(boton, 2, 5);
        boton.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(20, 20, 20, 20));
        
        boton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                cant_jugadores = (int)jugadores.getValue();
                ruta_seleccionada = (Rutas)ruta_jugar.getValue();
                Stage stage = new Stage();
                PaneOrganizerSeleccion rootcontainer = new PaneOrganizerSeleccion();
                Scene scene = new Scene(rootcontainer.getRoot(),900,600);
                stage.setTitle("Selección de ciclistas");
                stage.setScene(scene);
                stage.show();
            
        }
        });

    }

    public class StatusListCell extends ListCell<Rutas> {

        @Override
        protected void updateItem(Rutas item, boolean empty) {
            super.updateItem(item, empty);
            setGraphic(null);
            setText(null);
            if (item != null) {
                ObtenerBytes ob = new ObtenerBytes();
                Image imagen;
                try {
                    imagen = ob.createImage(item.getImagen(), item.getNombre());
                    ImageView imageView = new ImageView(imagen);
                    imageView.setFitWidth(100);
                    imageView.setFitHeight(100);
                    setGraphic(imageView);
                    setText(item.getNombre());
                } catch (IOException ex) {
                    Logger.getLogger(PaneOrganizerJuego.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

    }
    
    public void setRuta(Rutas ruta){
        this.ruta_seleccionada = ruta;
    }
    
    public Rutas getRuta(){
        return ruta_seleccionada;
    }
    
    public void setCantidadJugadores(int n_jugadores){
        this.cant_jugadores = n_jugadores;
    }
    
    public int getCantidadJugadores(){
        return cant_jugadores;
    }
}
