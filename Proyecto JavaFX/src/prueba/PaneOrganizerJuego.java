/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import entidades.Rutas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import archivo.Archivo;
import entidades.ObtenerBytes;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;

/**
 *
 * @author MI
 */
public class PaneOrganizerJuego {

    private GridPane root;
    private ComboBox jugadores;
    private ComboBox<Image> ruta_jugar;
    private Button boton;
    private Label lb1;
    private Label lb2;
    private ArrayList<Rutas> obj_rutas;

    public PaneOrganizerJuego() {
        createContent();
    }

    public Pane getRoot() {
        return root;
    }

    public void createContent() {
        root = new GridPane();
        boton = new Button("Continuar");
        ObservableList<String> n_jugadores = FXCollections.observableArrayList("1", "2", "3", "4", "5");
        //ObservableList<Image> img_rutas = FXCollections.observableArrayList();
        final ObservableList<Image> images = colocarImagenes();
        ruta_jugar = createComboBox(images);

        jugadores = new ComboBox(n_jugadores);
        ruta_jugar = new ComboBox<>();
        //ruta_jugar.getItems().addAll(img_rutas);
        ruta_jugar.setButtonCell(new ListCell());
        ruta_jugar.setCellFactory(listView -> new ImageListCell());
        lb1 = new Label("SELECCIONE NÚMERO DE JUGADORES");
        lb2 = new Label("SELECCIONE LA RUTA A UTILIZAR");
        root.add(lb1, 0, 0);
        root.add(jugadores, 1, 0);
        root.add(lb2, 0, 1);
        root.add(ruta_jugar, 1, 1);
        root.add(boton, 2, 2);
        boton.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(20, 20, 20, 20));

    }

    private ComboBox<Image> createComboBox(ObservableList<Image> data) {
        ComboBox<Image> combo = new ComboBox<>();
        combo.getItems().addAll(data);
        combo.setButtonCell(new ImageListCell());
        combo.setCellFactory(listView -> new ImageListCell());
        combo.getSelectionModel().select(0);
        return combo;
    }

    private ObservableList<Image> colocarImagenes() {
        final ObservableList<Image> data = FXCollections.observableArrayList();

        try {
            System.out.println("11111");
            obj_rutas = Archivo.obtener_registros_rutas("Rutas.dat");
            System.out.println((obj_rutas).getClass());
            System.out.println(obj_rutas + "-----------");
            System.out.println("22222");

            //System.out.println("*********     "+obj_rutas);
            for (Rutas ruta : obj_rutas) {
                try {
                    ObtenerBytes obj = new ObtenerBytes();
                    Image imagen = obj.createImage(ruta.getImagen(), ruta.getNombre());
//                    System.out.println(ruta+"____________");
//                    System.out.println(ruta.getImagen().getClass()+"-------------");
//                    BufferedImage imag = ImageIO.read(new ByteArrayInputStream(ruta.getImagen()));
//                                        System.out.println(imag.getClass()+"********");
//                    System.out.println("33333");
//                    ImageIO.write(imag, "jpg", new File(ruta.getNombre()+".jpg"));
//                    byte[] bytes = 
                    //System.out.println("ARCHIVO_CREADO");
                    //Image img = javafx.embed.swing.SwingFXUtils.toFXImage(imag, null);

                    //Image img = new Image(new ByteArrayInputStream(ruta.getImagen()));
                    //graphicsContext.drawImage(img, 10, 10, 100, 100);
                    //System.out.println(img);
                    //Thread.sleep(1000);
                    data.add((imagen));
                } catch (IOException ex) {
                    System.out.println("ERRRO_1");
                }

            }
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        return data;
    }

    public class ImageListCell extends ListCell {

        private final ImageView view;

        public ImageListCell() {
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            view = new ImageView();
        }

        protected void updateItem(Image item, boolean empty) {
            super.updateItem(item, empty);
            if (item == null || empty) {
                setGraphic(null);
                setText(null);
            } else {
                //ImageView imageView = new ImageView(new Image(item));
                view.setImage(item);
                //view.setFitWidth(100);
                //view.setFitHeight(100);
                setGraphic(view);
                //setText("a");
            }
        }
    }

}
