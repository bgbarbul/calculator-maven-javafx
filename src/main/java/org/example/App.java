package org.example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setOnCloseRequest(e -> {
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, null, ButtonType.YES, ButtonType.NO);
            confirm.setTitle("Are you sure you want to exit?");
            confirm.setHeaderText("Are you sure you want to exit?");

            Optional<ButtonType> answer = confirm.showAndWait();

            if (answer.get() == ButtonType.NO) {
                e.consume();
            }
        });

        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.show();

    }
}