package org.example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
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

        

        Scene scene = new Scene(root, 500,300);
        primarystage.setTitle("BorderPane ");
        primarystage.setScene(scene);

        primarystage.show();
    }
}