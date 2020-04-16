package org.example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primarystage) throws IOException {

        //BorderPane
        BorderPane root1 = new BorderPane();

        root1.setTop(new Label("Fent"));
        root1.setLeft(new Label("Bal"));
        root1.setRight(new Label("Jobb"));
        root1.setBottom(new Label("Lent"));
        root1.setCenter(new Label("Közép"));

        //HBox
        HBox root2 = new HBox();
        root2.setSpacing(10);
        root2.setPadding(new Insets(10,10,10,10));
        root2.getChildren().addAll(new Button("Egy"), new Button("Kettő"), new Button("Három"));

        //GridPane
        GridPane root = new GridPane();
        root.setVgap(10); //függőleges
        root.setHgap(30); //vízszíntes

        //Első sor
        Text name = new Text("Név:");
        root.add(name, 0, 0); //add(Node child, int columnIndex, int rowIndex)
        TextField nameTextField = new TextField();
        root.add(nameTextField, 1, 0);

        //Második sor
        Text email = new Text("Email:");
        root.add(email, 0, 1);
        TextField emailTextField = new TextField();
        root.add(emailTextField, 1, 1);

        // A két gombot belerakjuk egy HBox-ba
        Button ok = new Button("Ok");
        Button cancel = new Button("Mégse");
        HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER); // A hbox-on belül középre igazítottak az elemek
        hb.setSpacing(20); // az elemek közötti távolság
        hb.getChildren().addAll(ok, cancel); // gombok a hbox-hoz

        root.add(hb, 0, 2, 2, 1);
        //hbox a grid-hez -> add(Node child, int columnIndex, int rowIndex, int colspan, int rowspan)
        root.setPadding(new Insets(10, 10, 10, 10)); // gridre egy padding

        Scene scene = new Scene(root, 500,300);

        primarystage.setScene(scene);
        primarystage.show();
    }
}