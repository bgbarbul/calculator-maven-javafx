package org.example;

import hu.alkfejl.nyilvantarto.controller.NyilvantartoController;
import hu.alkfejl.nyilvantarto.controller.NyilvantartoControllerImpl;
import hu.alkfejl.nyilvantarto.model.bean.Szemely;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private MenuBar menuBar = new MenuBar(); // menubar letrehozasa
    private NyilvantartoController controller = new NyilvantartoControllerImpl();
   // private TableView<Person> table = new TableView<>();


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Menu szemelyMenu = new Menu("Szemely"); // menu letrehozasa
        menuBar.getMenus().add(szemelyMenu); // menu hozzaadasa a menubarhoz
        MenuItem addSzemelyMenuItem = new MenuItem("Szemely felvetele");//menupont letrehozas
        addSzemelyMenuItem.setOnAction( e -> { addSzemely(); });
        szemelyMenu.getItems().add(addSzemelyMenuItem); // menupot hozzaadasa a menuhoz

        VBox root = new VBox(menuBar);
        root.setSpacing(10);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
/*
        table.setEditable(false);

        TableColumn<Person, String> nameCol = new TableColumn<>("Név");
        nameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("nev"));

        TableColumn<Person, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));

        TableColumn<Person, Integer> birthCol = new TableColumn<>("Születési év");
        birthCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("szulEv"));

        TableColumn<Person, Integer> telCol = new TableColumn<>("Telefon");
        telCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("telefon"));

        table.getColumns().addAll(nameCol, emailCol, birthCol, telCol);
        table.setItems(FXCollections.observableArrayList(controller.getAll()));
*/

    }

    private void addSzemely() {
        Stage stage = new Stage(); // új ablakot fogunk létrehozni

        // grid-es elrendezést használunk
        GridPane gridPane = new GridPane();
        // egy kis csinosítás
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));

        // a beviteli mezők
        TextField nevTF = new TextField();
        TextField emailTF = new TextField();
        TextField telTF = new TextField();
        TextField evTF = new TextField();

        // Egyszerű szövegeket és a beviteli vezérlőket rápakoljuk a gridre
        gridPane.add(new Text("Nev:"), 0, 0);
        gridPane.add(nevTF, 1, 0);
        gridPane.add(new Text("Email:"), 0, 1);
        gridPane.add(emailTF, 1, 1);
        gridPane.add(new Text("Telefon:"), 0, 2);
        gridPane.add(telTF, 1, 2);
        gridPane.add(new Text("Szul. ev:"), 0, 3);
        gridPane.add(evTF, 1, 3);

        // Rápakolunk két gombot is a felületre
        Button okButton = new Button("OK");
        okButton.setDefaultButton(true);
        gridPane.add(okButton, 0, 4);

        Button cancelButton = new Button("Cancel");
        cancelButton.setCancelButton(true);
        gridPane.add(cancelButton, 1, 4);

        // Készítünk egy Scene-t az ablaknak, aminek a root node-ja a grid lesz
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.setTitle("Szemely felvetele");
        stage.show();

        cancelButton.setOnAction(e -> stage.close() );

        okButton.setOnAction(e -> {
            if (nevTF.getText().isEmpty()) {
                showWarning("A nev nem lehet ures");
                return;
            }
            if (emailTF.getText().isEmpty()) {
                showWarning("Az email cimet meg kell adni");
                return;
            }
            if (telTF.getText().isEmpty()) {
                showWarning("Az telefon szamot meg kell adni");
                return;
            }
            if (evTF.getText().isEmpty()) {
                showWarning("A szul. evet meg kell adni");
                return;
            }
            int ev;
            try {
                ev = Integer.parseInt(evTF.getText());
            } catch (NumberFormatException nfe) {
                showWarning("A szul. ev nem szam");
                return;
            }


            if (controller.addSzemely(new Szemely(nevTF.getText(), emailTF.getText(), telTF.getText(), ev)))
            {
                showWarning("Sikeres");
                stage.close();
            } else {
                showWarning("Nem sikerult a mentes");
                return;
            }
        });
    }

    private void showWarning(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Hiba");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}