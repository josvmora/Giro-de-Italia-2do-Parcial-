/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

/**
 *
 * @author User
 */

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import entidades.Ciclista;
import entidades.ObtenerBytes;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PaneOrganizerP {
    private Button Iniciar_juego;
    private Button equipos_y_ciclistas;
    private Button rutas;
    private Button salir;
    private GridPane root;
    
    public PaneOrganizerP(){
        createContent();
    }
    
    public Pane getRoot() {
        return root;
    }
    
    public void createContent(){
         root = new GridPane();
         Iniciar_juego = new Button("Iniciar juego");
         equipos_y_ciclistas = new Button("Ingresar equipos y ciclistas");
         rutas = new Button("Ingresar rutas");
         salir= new Button("Salir");
         root.add(Iniciar_juego,0,0);
         root.add(equipos_y_ciclistas,0,1);
         root.add(rutas,0,2);
         root.add(salir,0,3);
         root.setHgap(10);
         root.setVgap(10);
         root.setAlignment(Pos.CENTER);
         root.setPadding(new Insets(20,20,20,20));
         Iniciar_juego.setAlignment(Pos.CENTER);
         equipos_y_ciclistas.setAlignment(Pos.CENTER);
         rutas.setAlignment(Pos.CENTER);
         salir.setAlignment(Pos.CENTER);
         
        equipos_y_ciclistas.setOnAction(new EventHandler<ActionEvent>(){
             public void handle(ActionEvent event){
                  Stage stage=new Stage();
                  PaneOrganizerCyR rootContainer = new PaneOrganizerCyR();        
                  Scene scene = new Scene(rootContainer.getRoot(),400,350);
                  stage.setTitle("Ingreso de ciclistas y rutas");
                  stage.setScene(scene);
                  stage.show();
            }
    });
        salir.setOnAction(new EventHandler<ActionEvent>(){
             public void handle(ActionEvent event){ 
                 System.exit(0);
            }
    });
        
        
        
        
        
        
    }
    
}
