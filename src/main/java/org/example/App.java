package org.example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage mainWindow;
    private Scene scene1, scene2;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        mainWindow = primaryStage;

        mainWindow.setTitle("Hello JavaFX");

        constructScene1();
        constructScene2();

        mainWindow.setScene(scene1);
        mainWindow.setTitle("MultiScene");
        mainWindow.show();
    }

    private void  constructScene1()
    {
        Label lbl = new Label("Scene 1");
        Button btn = new  Button("Go Scene 2");
        btn.setOnAction( e -> {
            mainWindow.setScene(scene2);
        });

        /* ComboBox */
        ObservableList<String> days = FXCollections.observableArrayList(
                "Monday", "Tuesday", "Wednesday", "Thursday",
                "Friday", "Saturday", "Sunday");

        ComboBox<String> combo = new ComboBox<String>();

        combo.setItems(days); //értékek beállítása
        combo.setValue("Friday"); //default érték

        combo.setEditable(true);

        VBox root = new VBox();
        root.getChildren().addAll(lbl, btn, combo);

        scene1 = new Scene(root, 300, 300);
    }

    private void constructScene2()
    {
        Label lbl = new Label("Scene 2");
        Button btn = new  Button("Go Scene 1");
        btn.setOnAction( e -> {
            mainWindow.setScene(scene1);
        });

        VBox root = new VBox();
        root.getChildren().addAll(lbl, btn);

        scene2 = new Scene(root, 300, 300);
    }

}