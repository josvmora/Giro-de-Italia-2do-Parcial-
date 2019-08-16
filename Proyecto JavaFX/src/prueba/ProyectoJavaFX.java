/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author JHON
 */
public class ProyectoJavaFX extends Application {
    
    @Override
      
  public void start(Stage primaryStage) throws Exception {
        PaneOrganizer rootContainer = new PaneOrganizer();
        Scene scene = new Scene(rootContainer.getRoot(),400,350);
        primaryStage.setTitle("Busqueda archivos");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
