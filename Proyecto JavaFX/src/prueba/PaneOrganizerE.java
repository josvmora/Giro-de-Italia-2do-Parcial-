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
import archivo.Archivo;
import entidades.Ciclista;
import entidades.ObtenerBytes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class PaneOrganizerE {
    private Label lb1;
    private Label lb2;
    private TextField ruta;
    private TextField nombre;
    private GridPane root;
   // private Button boton_guardar;
    private Button file_chooser;
    
    private ComboBox combo;
    private Button agregar;
    private Button eliminar;
    private Button ingresar;
    private Button limpiar;
    private ListView lista;
    
    public PaneOrganizerE() {
        createContent();
    }
     public Pane getRoot() {
        return root;
    }
    public void createContent() {
        ObservableList<String> os=FXCollections.observableArrayList();
        try{
            ArrayList<Ciclista> ciclistas = Archivo.obtener_registros("Ciclista.dat");
            for(Ciclista c: ciclistas){
                os.add(c.toString());
            }
        }catch(Exception e){
            System.out.println("ERROR");
        }
        root = new GridPane();
        lb1 = new Label("Nombre del equipo:");
        lb2 = new Label("Logotipo:");
        nombre = new TextField();
        ruta = new TextField();
        nombre.setPromptText("Ingrese el nombre del equipo ");
       // boton_guardar = new Button("Guardar");
        combo=new ComboBox(os);
        agregar=new Button("+");
        eliminar=new Button("-");
        lista=new ListView();
        ingresar=new Button("Ingresar");
        limpiar=new Button("Limpiar");
        
        
        file_chooser = new Button("...");
        root.add(lb1,0,0);
        root.add(lb2,0,1);
        root.add(nombre,1,0);
        root.add(ruta,1,1);
        root.add(file_chooser,2,1);
        
        root.add(combo,0,2);
        root.add(agregar,1,2);
        root.add(eliminar,2,2);
        root.add(lista,0,3,2,1);
        root.add(ingresar,0,4);
        root.add(limpiar,1,4);
        
       // root.add(boton_guardar,1,2,2,1);
       // boton_guardar.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20,20,20,20));
        file_chooser.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                FileChooser fc = new FileChooser();
                File selecionar_file = fc.showOpenDialog(null);
                if( selecionar_file != null){
                    ruta.setText(selecionar_file.getAbsolutePath());
                }else{
                    System.out.println("El archivo no se encuentra");
                }
                
                           
            }
        });
        
        agregar.setOnAction(new EventHandler<ActionEvent>(){
             public void handle(ActionEvent event){
                 lista.getItems().addAll(combo.getValue());
//             

            }
        });
        limpiar.setOnAction(new EventHandler<ActionEvent>(){
             public void handle(ActionEvent event){
                 lista.getItems().clear();
                 nombre.setText(null);
                 ruta.setText(null);                  
            }
        });
        
        eliminar.setOnAction(new EventHandler<ActionEvent>(){
             public void handle(ActionEvent event){
                 int c=lista.getItems().size();
                 if (c!=0){
                    lista.getItems().remove(c-1);
                 }                
            }
        });
        
        
        
        
        
        
//        boton_guardar.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//           public void handle(ActionEvent ae){
//                try{
//                    ObtenerBytes obytes = new ObtenerBytes();
//                    String name = nombre.getText();
//                    byte[] foto =  obytes.extractBytes(ruta.getText());
//                    Ciclista c = new Ciclista(name,foto);
//                    Archivo.crear("Rutas.dat");
//                    Archivo.insertar_registro("Rutas.dat",c);
//                    JOptionPane.showMessageDialog(null, "Ruta ingresada Ingresado");
//                    nombre.setText(null);
//                    ruta.setText(null);
//                }catch(IOException ex){
//                    System.out.println(ex);
//                }
//                
//            }
//        });

    }



    
}
