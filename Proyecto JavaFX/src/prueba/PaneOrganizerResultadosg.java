/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import entidades.Ciclista;
import entidades.Estaciones;
import entidades.Jugador;
import entidades.Rutas;
import java.util.ArrayList;
import java.util.Collections;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author User
 */
public class PaneOrganizerResultadosg {
     private ListView categoria1;
     private ListView categoria2;
     private ListView categoria3;
     private ListView categoria4;
     private ListView resultadosg;
     private GridPane root;
     private Rutas ruta;
     private ArrayList<Ciclista> ciclis;
     private Label toc1;
     private Label toc2;
     private Label toc3;
     private Label toc4;
     private Label toc5;

    public PaneOrganizerResultadosg(Rutas ruta, ArrayList<Ciclista> ciclis) {
        this.ruta = ruta;
        this.ciclis = ciclis;
        createContent();
    }
     public Pane getRoot() {
        return root;
    }
     public void createContent(){
         toc1=new Label("Categoria 1");
         toc2=new Label("Categoria 2");
         toc3=new Label("Categoria 3");
         toc4=new Label("Categoria 4");
         toc5=new Label("Total con descuento");
         
        
       
         
         root = new GridPane();
         categoria1=new ListView();
         categoria2=new ListView();
         categoria3=new ListView();
         categoria4=new ListView();
         resultadosg=new ListView();
          ArrayList<ListView> listas= new  ArrayList<ListView>();
          listas.add(categoria1);
          listas.add(categoria2);
          listas.add(categoria3);
          listas.add(categoria4);
         
         
         root.add(categoria1,0,3,2,1);
         root.add(categoria2,20,3,2,1);
         root.add(categoria3,40,3,2,1);
         
         
         
         root.add(toc1,0,2);
         root.add(toc2,20,2);
         root.add(toc3,40,2);
         root.add(toc4,0,14);
         root.add(toc5,20,14);
         root.add(categoria4,0,15,2,1);
         root.add(resultadosg,20,15,2,1);
         root.setAlignment(Pos.CENTER);

         for (int i = 0; i < listas.size(); i++) {
             for(Ciclista c:ruta.getEstaciones().get(i).getCiclis()){
                 listas.get(i).getItems().addAll(c);
             }
         }
         
         Collections.sort(ciclis);
         for (Ciclista c1 : ciclis) {
             resultadosg.getItems().addAll(c1);
         }
         
 
                   
           
           
        
         
         
     }
    
}
