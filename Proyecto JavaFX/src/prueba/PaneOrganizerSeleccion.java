/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import archivo.Archivo;
import entidades.Ciclista;
import entidades.Rutas;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author MI
 */
public class PaneOrganizerSeleccion {
    private GridPane root;
    private ComboBox ciclista_seleccionado;
    private ListView ciclistas_seleccionado;
    
    public PaneOrganizerSeleccion(){
        createContent();
    }
    public Pane getRoot(){
        return root;
    }
    
    public void createContent(){
        ObservableList<Ciclista> ol = FXCollections.observableArrayList();
        try{
            ArrayList<Ciclista> ciclistas = Archivo.obtener_registros("Ciclista.dat");
            for(Ciclista c: ciclistas){
                ol.add(c);
            }
        }catch(Exception e){
            System.out.println("ERROR");
        }
        root = new GridPane();
        

    }
            
            
            


}
