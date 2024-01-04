package br.edu.ifsp.javafx.aulas.controller;

import java.io.IOException;
import java.util.ArrayList;

import br.edu.ifsp.javafx.aulas.model.Relato;
import br.edu.ifsp.javafx.aulas.model.RelatoDAO;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class RelatosController {
    @FXML
    ScrollPane painelRelatos;

    public void initialize() throws IOException {
        // puxar do banco
        // List<Relato> relatos = RelatosDAO.all();
        ArrayList<Relato> relatos = RelatoDAO.getInstance().read();
        
        //ArrayList<Relato> relatos = new ArrayList<>();

        Pane pane = new Pane();
        int paragrafo = 0;

        for(Relato item : relatos){
            
            VBox vbox = new VBox();
                Label label = new Label();
                label.setText("Nome do usúario: " + item.getNome());
            vbox.getChildren().add(label);

                Label label2 = new Label();
                label2.setText(item.getDescricao());
            vbox.getChildren().add(label2);

            HBox hbox = new HBox();
            hbox.setAlignment(Pos.TOP_LEFT);

                Label label3 = new Label();
                label3.setText("Principais sintomas: " + item.getSintomas()+ "                     ");
                label3.setAlignment(Pos.CENTER);
                hbox.getChildren().add(label3);

                Label label4 = new Label();
                label4.setText("Data: "+item.getData());
                label4.setAlignment(Pos.CENTER);
                hbox.getChildren().add(label4);

            vbox.getChildren().add(hbox);
            vbox.setTranslateY(paragrafo);
            pane.getChildren().add(vbox);
            
            
            paragrafo = paragrafo + 100;
        }

        painelRelatos.setContent(pane);
    }
}
