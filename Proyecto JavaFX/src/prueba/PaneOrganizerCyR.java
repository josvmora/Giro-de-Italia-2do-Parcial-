/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class PaneOrganizerCyR {
     private Button Ingreso_de_ciclistas;
    private Button Ingreso_de_equipos;
    private GridPane root;
    
    public PaneOrganizerCyR(){
        createContent();
    }
    
    public Pane getRoot() {
        return root;
    }
    
    public void createContent(){
        root = new GridPane();
        Ingreso_de_equipos=new Button("Ingreso de equipos");
        Ingreso_de_ciclistas=new Button("Ingreso de ciclistas");
        root.add(Ingreso_de_equipos,0,0);
        root.add(Ingreso_de_ciclistas,0,1);
        root.setHgap(10);
        root.setVgap(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20,20,20,20));
        Ingreso_de_equipos.setAlignment(Pos.CENTER);
        Ingreso_de_ciclistas.setAlignment(Pos.CENTER);
        
        Ingreso_de_ciclistas.setOnAction(new EventHandler<ActionEvent>(){
             public void handle(ActionEvent event){
                  Stage stage=new Stage();
                  PaneOrganizer rootContainer = new PaneOrganizer();        
                  Scene scene = new Scene(rootContainer.getRoot(),400,350);
                  stage.setTitle("Ingreso de ciclistas");
                  stage.setScene(scene);
                  stage.show();                   
            }
        });
        
        Ingreso_de_equipos.setOnAction(new EventHandler<ActionEvent>(){
             public void handle(ActionEvent event){
                  Stage stage=new Stage();
                  PaneOrganizerE rootContainer = new PaneOrganizerE();        
                  Scene scene = new Scene(rootContainer.getRoot(),600,550);
                  stage.setTitle("Ingreso de equipos");
                  stage.setScene(scene);
                  stage.show();                   
            }
        });
        
        
    }
}
