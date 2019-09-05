/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;
import archivo.Archivo;
import entidades.Equipos;
import entidades.Estaciones;
import entidades.ObtenerBytes;
import entidades.Rutas;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import javafx.stage.FileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author Hernan
 */
public class PaneOrganizerRU {
     private GridPane root;
    private Label name;
    private Label image;
    private Label distance;
    private TextField name_text;
    private TextField distance_text;
    private TextField path_text;
    private Button file_chooser;
    private Button guardar_Button;
    private ImageView imageView;
    private Label estaciones_premios;
    private Label distancia_premio;
    private Label categoria;
    private TextField distancia_premioText;
    private ComboBox combobox;
    private ListView lista_estaciones;
    private Button agregar;
    
    public PaneOrganizerRU (){
        createContent();
    }
    public Pane getRoot() {
        return root;
    }
    public void createContent(){
        agregar = new Button("+");
        distancia_premioText = new TextField();
        lista_estaciones = new ListView();
        estaciones_premios = new Label("Estaciones:");
        distancia_premio = new Label("Ubicacion (Km):");
        categoria = new Label("Categoria:");
        imageView = new ImageView();
        root = new GridPane();
        name = new Label("Nombre:");
        image = new Label("Imagen:");
        distance = new Label("Distancia(Km):");
        name_text = new TextField();
        distance_text = new TextField();
        path_text = new TextField();
        file_chooser = new Button("...");
        guardar_Button = new Button("Guardar");
        name_text.setPromptText("Ingrese el nombre de la ruta.");
        distance_text.setPromptText("Ingrese la distancia de la ruta");
        
        ObservableList<String> items = FXCollections.observableArrayList();
        items.addAll("1","2","3","4");
        combobox = new ComboBox(items);
        
        root.add(name,0,0);
        root.add(image,0,1);
        root.add(name_text,1,0,2,1);
        root.add(path_text,1,1);
        root.add(file_chooser,2,1);
        root.add(distance,0,2);
        root.add(distance_text,1,2);
        root.add(guardar_Button,1,9,9,1);
        root.add(imageView,0,3,3,1);
        root.add(estaciones_premios,0,4);
        root.add(distancia_premio,0,5);
        root.add(categoria,0,6);
        root.add(distancia_premioText,1,5);
        root.add(combobox,1,6);
        root.add(lista_estaciones,1,8,8,1);
        root.add(agregar,2,6);
        
        imageView.setX(50);
        imageView.setY(50);
        guardar_Button.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20,20,20,20));
        
        //ArrayList<Estaciones> estaciones_premios = new ArrayList<Estaciones>();
        //ObservableList<String> mostrar = FXCollections.observableArrayList();
        
        file_chooser.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event){
                FileChooser fc = new FileChooser();
                File seleccionar_file = fc.showOpenDialog(null);
                if(seleccionar_file!=null){
                    path_text.setText(seleccionar_file.getAbsolutePath());
                }else{
                    System.out.println("No se enceuntra el archivo");
                }
                Image image = new Image(seleccionar_file.toURI().toString());
                imageView.setImage(image);
                imageView.setFitWidth(300);
                imageView.setFitHeight(200);
                
                    
                
            }
        });
        
        agregar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle (ActionEvent event){
                
                String ele =(String)combobox.getValue();
                Integer cat = Integer.parseInt(ele);
                Integer kil = Integer.parseInt(distancia_premioText.getText());
                
                //mostrar.add("distancia: "+distancia_premioText.getText()+" Km"+" / Categoria: "+(String)combobox.getValue());
                //lista_estaciones.setItems(mostrar);
                Estaciones estacion = new Estaciones(kil,cat);
                lista_estaciones.getItems().addAll(estacion);
                
                //estaciones_premios.add(estacion);
                
                //distancia_premioText.setText(null);
                //combobox.setValue(null);
               
            }
        });
        
        guardar_Button.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle (ActionEvent event){
                try{
                    
                    
                    
                    ObtenerBytes obytes = new ObtenerBytes();
                    String nombreDeRuta = name_text.getText();
                    Integer kilometros = Integer.parseInt(distance_text.getText());
                    byte [] imagen = obytes.extractBytes(path_text.getText());
                    
                    
                    ArrayList<Estaciones> ep= new ArrayList<Estaciones>(lista_estaciones.getItems());
              
                    
                    
                    Rutas ruta = new Rutas(nombreDeRuta,kilometros,imagen,ep);
                    Archivo.crear("Rutas.dat");
                    Archivo.insertar_registro_Rutas("Rutas.dat", ruta);
                    JOptionPane.showMessageDialog(null, "Ruta Ingresada");
                    name_text.setText(null);
                    distance_text.setText(null);
                    path_text.setText(null);
                    lista_estaciones.getItems().clear();
                    imageView.setImage(null);
                    distancia_premioText.setText(null);
                    combobox.setValue(null);
                    
              
                    

                                      
                }catch(IOException e){
                    System.out.println(e);
                }
  
                
                                    
            }
        });
        
        
    }
}
