package br.edu.ifsp.javafx.aulas;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.javafx.aulas.model.Cadastro;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    // public static ArrayList<Cadastro> listaCadastros = new ArrayList<>();
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        URL path = getClass().getResource("Menu.fxml");
        GridPane root = (GridPane) FXMLLoader.load(path);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    } 

    public static void main(String[] args) {
        launch();
    }
}