package br.edu.ifsp.javafx.aulas.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import br.edu.ifsp.javafx.aulas.App;
import br.edu.ifsp.javafx.aulas.model.Relato;
import br.edu.ifsp.javafx.aulas.model.RelatoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

//imports omitidos
public class CriarRelatoController{
    @FXML
    TextField textRnome; //mesmo tipo do nó e identificador no campo fx:id
    @FXML
    TextArea textRDescricao; //mesmo tipo do nó e identificador no campo fx:id
    @FXML
    Button btnReCriar; //mesmo tipo do nó e identificador no campo fx:id
    @FXML
    Button btnReExibir; //ADICIONIONADO
    @FXML
    Button btnReLimpar; //Limpando
    @FXML
    RadioButton radioReCidadao; //Botões de escolha
    @FXML
    RadioButton radioReAgente; //Botões de escolha
    @FXML
    RadioButton radioReAnonimo; //Botões de escolha
    @FXML
    CheckBox checkBoxDorCabeca; //Botões de escolha
    @FXML
    CheckBox checkBoxFebre; //Botões de escolha
    @FXML
    CheckBox checkBoxVomito; //Botões de escolha
    @FXML
    CheckBox checkBoxDorArt; //Botões de escolha
    @FXML
    CheckBox checkBoxDorOlho; //Botões de escolha
    @FXML
    CheckBox checkBoxDiarreia; //Botões de escolha

    // chamado pelo FXML loader depois que os nós são injetados nos campos acima. 
    public void initialize(){
        //Configuramos um evento no botão para pegar os dados dos campos e retorna-los
        ArrayList<String> sintomas = new ArrayList<>();

        btnReCriar.setOnAction((ActionEvent event) ->{            
            criarRelato();
        }); 

        btnReExibir.setOnAction((ActionEvent event) ->{
            abreJanelaTabela();
        });

        btnReLimpar.setOnAction((ActionEvent event) ->{
            limparCampos();
        });
    }

    private void abreJanelaTabela() {
        // try-catch é o bloco de tratamento de exceções
        try {
            URL path = App.class.getResource("relatos.fxml");
            FXMLLoader loader = new FXMLLoader(path);
            Parent root = loader.load();

            Stage stageTabela = new Stage();
            stageTabela.setTitle("Postagem de relatos");
            stageTabela.setScene(new Scene(root));
            stageTabela.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void limparCampos(){
        textRnome.clear();
        textRDescricao.clear();
    }

    private void criarRelato() {
        ArrayList<String> sintomas = new ArrayList<>();

        if (checkBoxDorCabeca.isSelected()) {
            sintomas.add("Dor de cabeça");
        }
        if (checkBoxFebre.isSelected()) {
            sintomas.add("Febre");
        }
        if (checkBoxVomito.isSelected()) {
            sintomas.add("Vômito");
        }
        if (checkBoxDorArt.isSelected()) {
            sintomas.add("Dor nas articulações");
        }
        if (checkBoxDorOlho.isSelected()) {
            sintomas.add("Dor nos olhos");
        }
        if (checkBoxDiarreia.isSelected()) {
            sintomas.add("Diarréia");
        }
        
        Relato novoRelato = new Relato(textRnome.getText(), 
                                             textRDescricao.getText(), null, sintomas);
        // App.listaCadastros.add(novoCadastro);
        // Uso do DAO
        RelatoDAO RelDAO = RelatoDAO.getInstance();   
        RelDAO.create(novoRelato);     
        System.out.println("Relato Salvo!");
        
        System.out.println(novoRelato);
    }
}
