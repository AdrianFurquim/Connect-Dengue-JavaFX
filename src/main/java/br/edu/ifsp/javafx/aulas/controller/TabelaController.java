package br.edu.ifsp.javafx.aulas.controller;

import java.util.ArrayList;

import br.edu.ifsp.javafx.aulas.Database;
import br.edu.ifsp.javafx.aulas.model.Cadastro;
import br.edu.ifsp.javafx.aulas.model.CadastroDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TabelaController {
    //Necessário especificar o tipo de dados da tabela
    @FXML
    TableView<Cadastro> tabeladenuncias;
    //Necessário especificar o par <Tipo de objeto, Tipo do campo do objeto>
    @FXML
    TableColumn<Cadastro, String> colName;
    @FXML
    TableColumn<Cadastro, String> colIdentificacao;
    @FXML
    TableColumn<Cadastro, String> colLocal;
    @FXML
    TableColumn<Cadastro, String> colTipoLocal;
    @FXML
    TableColumn<Cadastro, String> colDescricao;

    public void initialize(){
        //Ensina para a coluna qual o campo deve ser invocado no objeto de Cadastro
        colName.setCellValueFactory(
            //"nome" será convertido para getNome()
            new PropertyValueFactory<>("nome")
        );
        colIdentificacao.setCellValueFactory(
            //"nome" será convertido para getNome()
            new PropertyValueFactory<>("tipoPersona")
        );
        colLocal.setCellValueFactory(
            //"nome" será convertido para getNome()
            new PropertyValueFactory<>("Local")
        );
        colTipoLocal.setCellValueFactory(
            //"nome" será convertido para getNome()
            new PropertyValueFactory<>("tipo")
        );
        colDescricao.setCellValueFactory(
            //"nome" será convertido para getNome()
            new PropertyValueFactory<>("descricao")
        );
        
        
        // Atribuir os dados para a tabela
        tabeladenuncias.setItems(
            //Converte o ArrayList para o tipo de dados aceito pela tabela
            // Uso do DAO
            FXCollections.observableList(CadastroDAO.getInstance().read())
            // FXCollections.observableList(App.listaCadastros)
        );
    }
}
