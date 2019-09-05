/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import archivo.Archivo;
import entidades.Ciclista;
import entidades.CiclistaSeleccionado;
import entidades.Equipos;
import entidades.Jugador;
import entidades.ObtenerBytes;
import entidades.Rutas;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author MI
 */
public class PaneOrganizerSeleccion {

    private GridPane root;
    private ComboBox ciclista_seleccionado;
    private ListView ciclistas_seleccionados;
    private Jugador jugador;
    private Button agregar;
    private Button limpiar;
    private Button eliminar;
    private Button ingresar;
    private Button iniciar;
    private TextField nombre_jugador;
    private Label lb1;
    private Label lb2;
    private Label lb3;
    private ComboBox posiciones_ciclista;
    private static ArrayList<Jugador> jugadores = new ArrayList();
    private int n_max;
    private int jugador_n = 1;
    private Rutas ruta;

    public PaneOrganizerSeleccion(int n, Rutas ruta) {
        this.ruta = ruta;
        this.n_max = n;
        createContent();
    }

    public Pane getRoot() {
        return root;
    }

    public void createContent() {
         ObservableList<Integer> n_posiciones = FXCollections.observableArrayList(1, 2, 3, 4, 5);
        ObservableList<Ciclista> ol = FXCollections.observableArrayList();
        try {
            ArrayList<Ciclista> ciclistas = Archivo.obtener_registros("Ciclista.dat");
            for (Ciclista c : ciclistas) {
                ol.add(c);
            }
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        root = new GridPane();
        agregar = new Button("Agregar ciclista");
        limpiar = new Button("Limpiar");
        eliminar = new Button("Eliminar ciclista");
        ingresar = new Button("Aceptar");
        lb1 = new Label("Seleccione 5 ciclistas:");
        nombre_jugador = new TextField("Nombre del jugador 1");
        ciclistas_seleccionados = new ListView();
        ciclista_seleccionado = new ComboBox(ol);
        iniciar = new Button("Iniciar simulador");
        lb2 = new Label("Nombre del jugador:");
        
        lb3= new Label("Seleccione posiciones de llegada");
        posiciones_ciclista=new ComboBox(n_posiciones);
        
        root.add(lb2, 0, 0);
        root.add(nombre_jugador, 1, 0);
        root.add(lb1, 0, 1);
        
        root.add(lb3,1,1);
        root.add(posiciones_ciclista,1,2);
        
        root.add(ciclista_seleccionado, 0, 2);
        root.add(agregar, 2, 2);
        root.add(eliminar, 2, 3);
        root.add(limpiar, 2, 4);
        root.add(ingresar, 1, 5);
        root.add(iniciar, 1, 6);
        root.add(ciclistas_seleccionados, 0, 3);
        ingresar.setAlignment(Pos.CENTER);
        iniciar.setAlignment(Pos.CENTER);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20, 20, 20, 20));

        
        
        
        
        //asumimos posiciones repetidas
        
        
        iniciar.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                PaneOrganizerSimulador rootcontainer = new PaneOrganizerSimulador(ruta,jugadores);
                Stage stage = new Stage();
                Scene scene = new Scene(rootcontainer.getRoot(),900,600);
                stage.setTitle("Simulador");
                stage.setScene(scene);
                stage.show();
            }
        
    });
        
        
        
        agregar.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {                
              //crear una instancia de la clase ciclista seleccionado
              
              CiclistaSeleccionado cs= new CiclistaSeleccionado((Ciclista)ciclista_seleccionado.getValue(),(Integer)posiciones_ciclista.getValue());
              ciclistas_seleccionados.getItems().addAll(cs);                 
            }
        });
        
        limpiar.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                ciclistas_seleccionados.getItems().clear();
                //nombre.setText(null);
                //ruta.setText(null);                  
            }
        });

        eliminar.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                int c = ciclistas_seleccionados.getItems().size();
                if (c != 0) {
                    int n_prueba = ciclistas_seleccionados.getSelectionModel().getSelectedIndex();
                    if (n_prueba != -1) {
                        ciclistas_seleccionados.getItems().remove(n_prueba);
                    }
                }
            }
        });
        
        
        
        ingresar.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                try {
                    CiclistaSeleccionado[] seleccionados = new CiclistaSeleccionado[5];
                    ObservableList<CiclistaSeleccionado> ciclistas = ciclistas_seleccionados.getItems();
                   /// corregir el while genera que solo se guarde el ultimo ciclista guardado
                    if(ciclistas.size()==5){       
                        if (jugador_n < n_max) { 
                        int i = 0;
                        for (CiclistaSeleccionado cl : ciclistas) {
                            seleccionados[i] = cl;
                            i++;
                        }                                                                               
                        jugador = new Jugador(nombre_jugador.getText(), seleccionados);
                        jugador_n++;
                        JOptionPane.showMessageDialog(null, "Selección ingresada satisfactoriamente");
                        jugadores.add(jugador);
                        ciclistas_seleccionados.getItems().clear();
                        nombre_jugador.setText("Nombre del jugador " + (jugador_n ));
                     } else {
                        int i = 0;
                        for (CiclistaSeleccionado cl : ciclistas) {
                            seleccionados[i] = cl;
                            i++;
                        }
                        jugador = new Jugador(nombre_jugador.getText(), seleccionados);
                        jugador_n++;
                        JOptionPane.showMessageDialog(null, "Selección ingresada satisfactoriamente");
                        jugadores.add(jugador);
                        JOptionPane.showMessageDialog(null, "Total máximo de jugadores registrados, inicie el simulador");
                        //System.out.println("Total máximo de jugadores registrados, inicie el simulador");
                        ciclistas_seleccionados.getItems().clear();
                        nombre_jugador.setText(null);
                        ingresar.setDisable(true);
                        for(Jugador j1: jugadores){
                            System.out.println(j1.getCiclistas_elegidos());
                            for(CiclistaSeleccionado c:j1.getCiclistas_elegidos() ){
                                System.out.println(c);
                            }        
                        }
                     }                            
                    }
                    
                    else if(ciclistas.size()==0){
                        JOptionPane.showMessageDialog(null, "No ha seleccionado a ningun ciclista");
                    }
                    
                    else{
                        JOptionPane.showMessageDialog(null, "Debe ingresar a cinco ciclistas, ni mas ni menos");
                    }

                    /*
                    ArrayList<Integer> integrantes = new ArrayList<Integer>();
                    ObtenerBytes obytes = new ObtenerBytes();
                    //byte[] foto =  obytes.extractBytes(ruta.getText());

                    ObservableList<Ciclista> ep = ciclistas_seleccionados.getItems();
                     */
 /*
                 for(Ciclista c1: ep){
                    integrantes.add(c1.getCodigo());
                    }
                 Equipos ep1= new Equipos(nombre.getText(),foto,integrantes);
                 
                 
                 //falta el ingreso en el archivo 
                  Archivo.crear("Equipos.dat");
                  Archivo.insertar_registro_Equipos("Equipos.dat",ep1);
                  JOptionPane.showMessageDialog(null, "Equipo Ingresado");
                                
                  lista.getItems().clear();
                  nombre.setText(null);
                  ruta.setText(null);    
                     */
                } catch (Exception ex) {
                    System.out.println(ex);
                }

            }

        });

    }

//    public ArrayList<Jugador> getJugador() {
//        return this.jugadores;
//    }

}
