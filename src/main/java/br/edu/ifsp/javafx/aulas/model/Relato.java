package br.edu.ifsp.javafx.aulas.model;

import java.util.ArrayList;
import java.util.Date;

import br.edu.ifsp.javafx.aulas.Database2;
import javafx.scene.chart.PieChart.Data;

public class Relato {
    protected String nome;
    protected String descricao;
    private Date data = new Date();
    protected ArrayList<String> sintomas;

    
    public Relato(String nome, String descricao, String string, ArrayList<String> sintomas) {
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.sintomas = sintomas;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Date getData() {
        return data;
    }
    public void setdata(Date data) {
        this.data = data;
    }

    public ArrayList<String> getSintomas() {
        return sintomas;
    }

    public void setSintomas(ArrayList<String> sintomas) {
        this.sintomas = sintomas;
    }
    
    public void addDado(Database2 database2){
        database2.relatos.add(this);
    }
    
    @Override
    public String toString() {
        return "Relato [nome=" + nome + ", descricao=" + descricao + ", data=" + data + ", sintomas=" + sintomas + "]";
    }

    public void setData(Date data) {
        this.data = data;
    }
}
