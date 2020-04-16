package org.example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    public void start(Stage stage) throws IOException {

        stage.setTitle("Hello JavaFX");

        VBox root = new VBox();
        Text msg = new Text("Kérlek add meg a neved!");
        TextField mezo =new TextField();

        Button exit = new Button("Exit");
        exit.setOnAction( e -> { Platform.exit(); } );

        mezo.setOnKeyReleased( e -> { msg.setText("Üdv " + mezo.getText()); });

        root.getChildren().addAll(msg, mezo, exit);

        Scene scene = new Scene(root, 500,300);
        stage.setScene(scene);

        stage.show();
    }

    /*
        scene = new Scene(loadFXML("primary"));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
*/


}