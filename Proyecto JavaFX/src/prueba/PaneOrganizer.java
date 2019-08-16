/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author CltControl
 */
public class PaneOrganizer {

    private Label lb1;
    private Label lb2;
    private TextField nombre;
    private GridPane root;
    private Button boton_guardar;
    private Button file_chooser;

    public PaneOrganizer() {
        createContent();
    }

    public Pane getRoot() {
        return root;
    }

    public void createContent() {
        root = new GridPane();
        lb1 = new Label("Nombre:");
        lb2 = new Label("Imagen:");
        nombre = new TextField();
        nombre.setPromptText("Ingrese su nombre: ");
        boton_guardar = new Button("Guardar");
        file_chooser = new Button("...");
        root.add(lb1,0,0);
        root.add(lb2,0,1);
        root.add(nombre,1,0);
        root.add(file_chooser,1,1);
        root.add(boton_guardar,1,3,2,1);
        boton_guardar.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20,20,20,20));
        
        

    }

//    private String abrirArchivo() {
//        String aux = "";
//        String texto = "";
//        try {
//            /**
//             * llamamos el metodo que permite cargar la ventana
//             */
//            JFileChooser file = new JFileChooser();
//            file.showOpenDialog(this);
//            /**
//             * abrimos el archivo seleccionado
//             */
//            File abre = file.getSelectedFile();
//
//            /**
//             * recorremos el archivo, lo leemos para plasmarlo en el area de texto
//             */
//            if (abre != null) {
//                FileReader archivos = new FileReader(abre);
//                BufferedReader lee = new BufferedReader(archivos);
//                while ((aux = lee.readLine()) != null) {
//                    texto += aux + "\n";
//                }
//                lee.close();
//            }
//        } catch (IOException ex) {
//            JOptionPane.showMessageDialog(null, ex + ""
//                    + "\nNo se ha encontrado el archivo",
//                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
//        }
//        return texto;//El texto se almacena en el JTextArea
//    }
}
