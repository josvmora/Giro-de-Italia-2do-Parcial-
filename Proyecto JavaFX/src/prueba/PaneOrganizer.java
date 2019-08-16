/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author CltControl
 */
public class PaneOrganizer {
    private Label lb1;
    private TextField nombre;
    private GridPane root;
    private Button boton_busqueda;
    
    public PaneOrganizer(){
        createContent();
    }
    public Pane getRoot(){
        return root;
    }
    
    public void createContent(){
        
    }
}
