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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author User
 */
public class PaneOrganizerResultadosj {
     private ListView listajugadores;
     private GridPane root;
     private Rutas ruta;
     private ArrayList<Ciclista> ciclis;
     private ArrayList<Jugador> jugadores2;
     
     
    public PaneOrganizerResultadosj (Rutas ruta,ArrayList<Ciclista> ciclis,ArrayList<Jugador> jugadores2){
        this.ciclis=ciclis;
        this.ruta=ruta;
        this.jugadores2=jugadores2;
        createContent();
    }
    public Pane getRoot() {
        return root;
    }
     public void createContent(){
         root = new GridPane();
         listajugadores=new ListView();
         root.add(listajugadores,0,3,2,1);
         root.setAlignment(Pos.CENTER);
         for (Estaciones et: ruta.getEstaciones()){
                       System.out.println(et.getCiclis());
                       et.pasarDescuento();
                   } 
                   for (Ciclista c : ciclis) {
                       System.out.println(c.getNombre()+"Iimepo de llegada"+c.getTime_llegada());
                       System.out.println("Tiempo descuento: "+c.getTime_descuento());
                       System.out.println("Tiempo total: "+c.tiempoTotal());
                   }
                   
                   System.out.println(ciclis);
                   System.out.println("ciclistas ordenados");
                   //Collections.sort(ciclis, (x, y) -> x.tiempoTotal().compareTo(y.tiempoTotal()));
                   Collections.sort(ciclis);
                   System.out.println(ciclis);
                   
                   for(Jugador j:jugadores2){
                       String r=j.getNombre()+" Numero de acierto: "+j.Aciertos(ciclis);
                       System.out.println(r);
                       listajugadores.getItems().addAll(r);
                   }
                   
                   
           
           
        
         
         
     }
    
    
    
}
