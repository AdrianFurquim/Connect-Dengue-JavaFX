package br.edu.ifsp.javafx.aulas.controller;

import java.io.IOException;
import java.net.URL;

import br.edu.ifsp.javafx.aulas.App;
import br.edu.ifsp.javafx.aulas.model.Cadastro;
import br.edu.ifsp.javafx.aulas.model.CadastroDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class FormularioController {
    
    @FXML
    private TextField textName;
    @FXML
    private TextField textLocal;
    @FXML
    private TextArea textDescricao;
    @FXML
    private Button btnCriar;
    @FXML
    private Button btnExibir;
    @FXML
    private Button btnLimpar;
    @FXML
    private RadioButton radioCidadao;
    @FXML
    private RadioButton radioAgente;
    @FXML
    private RadioButton radioAnonimo;
    @FXML
    private ComboBox<String> comboboxTipoLocal;

    private ToggleGroup radioGroup;

    public void initialize() {
        comboboxTipoLocal.getItems().addAll("Rural", "Urbano");
        comboboxTipoLocal.getSelectionModel().selectFirst();

        radioGroup = new ToggleGroup();
        radioCidadao.setToggleGroup(radioGroup);
        radioAgente.setToggleGroup(radioGroup);
        radioAnonimo.setToggleGroup(radioGroup);

        radioCidadao.setOnAction(this::handleRadioSelection);
        radioAgente.setOnAction(this::handleRadioSelection);
        radioAnonimo.setOnAction(this::handleRadioSelection);

        btnCriar.setOnAction(this::criarCadastro);

        btnExibir.setOnAction(this::abreJanelaTabela);

        btnLimpar.setOnAction(this::limparCampos);
    }

    private void abreJanelaTabela(ActionEvent event) {
        try {
            URL path = App.class.getResource("DenunciaDados.fxml");
            FXMLLoader loader = new FXMLLoader(path);
            Parent root = loader.load();

            Stage stageTabela = new Stage();
            stageTabela.setTitle("Tabela de denuncias");
            stageTabela.setScene(new Scene(root));
            stageTabela.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void limparCampos(ActionEvent event) {
        textName.clear();
        textLocal.clear();
        textDescricao.clear();
    }

    private void criarCadastro(ActionEvent event) {
        String tipo = comboboxTipoLocal.getValue();

        String tipoPersona = "";
        RadioButton selectedRadioButton = (RadioButton) radioGroup.getSelectedToggle();
        if (selectedRadioButton != null) {
            tipoPersona = selectedRadioButton.getText();
        }

        Cadastro novoCadastro = new Cadastro(textName.getText(), textLocal.getText(), textDescricao.getText(), tipo,
                tipoPersona);

        CadastroDAO cadDAO = CadastroDAO.getInstance();
        cadDAO.create(novoCadastro);
        System.out.println("Cadastro Salvo!");
        System.out.println(novoCadastro);
    }

    private void handleRadioSelection(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) event.getSource();

        if (selectedRadioButton.isSelected()) {
            radioCidadao.setSelected(selectedRadioButton == radioCidadao);
            radioAgente.setSelected(selectedRadioButton == radioAgente);
            radioAnonimo.setSelected(selectedRadioButton == radioAnonimo);
        } else {
            radioCidadao.setSelected(false);
            radioAgente.setSelected(false);
            radioAnonimo.setSelected(false);
        }
    }
}