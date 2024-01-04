package br.edu.ifsp.javafx.aulas.controller;

import java.io.IOException;
import java.net.URL;

import br.edu.ifsp.javafx.aulas.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MenuController {
    @FXML
    Button btnDenuncia;
    @FXML
    Button btnRelato;
    @FXML
    Button btnVerDenuncia;
    @FXML
    Button btnVerRelatos;

     public void initialize(){
        //Configuramos um evento no botão para pegar os dados dos campos e retorna-los
        btnDenuncia.setOnAction((ActionEvent event) ->{            
            abreDenuncia();
        }); 

        btnRelato.setOnAction((ActionEvent event) ->{
            abreRelato();
        });

        btnVerDenuncia.setOnAction((ActionEvent event) ->{
            AbreVerDenuncias();
            
        });
        btnVerRelatos.setOnAction((ActionEvent event) ->{
            abreVerRelatos();
        });
    }

     private void abreDenuncia() {
        // try-catch é o bloco de tratamento de exceções
        try {
            URL path = App.class.getResource("denuncia.fxml");
            FXMLLoader loader = new FXMLLoader(path);
            Parent root = loader.load();
            Stage stageTabela = new Stage();
            stageTabela.setTitle("Denúncias");
            stageTabela.setScene(new Scene(root));
            stageTabela.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void abreRelato() {
        // try-catch é o bloco de tratamento de exceções
        try {
            URL path = App.class.getResource("CriarRelatos.fxml");
            FXMLLoader loader = new FXMLLoader(path);
            Parent root = loader.load();

            Stage stageTabela = new Stage();
            stageTabela.setTitle("Criar Relato");
            stageTabela.setScene(new Scene(root));
            stageTabela.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void AbreVerDenuncias() {
        // try-catch é o bloco de tratamento de exceções
        try {
            URL path = App.class.getResource("DenunciaDados.fxml");
            FXMLLoader loader = new FXMLLoader(path);
            Parent root = loader.load();

            Stage stageTabela = new Stage();
            stageTabela.setTitle("Tabela denúncias");
            stageTabela.setScene(new Scene(root));
            stageTabela.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void abreVerRelatos() {
        // try-catch é o bloco de tratamento de exceções
        try {
            URL path = App.class.getResource("relatos.fxml");
            FXMLLoader loader = new FXMLLoader(path);
            Parent root = loader.load();
            Stage stageTabela = new Stage();
            stageTabela.setTitle("Tabela relatos");
            stageTabela.setScene(new Scene(root));
            stageTabela.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
