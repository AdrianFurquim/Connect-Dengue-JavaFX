package br.edu.ifsp.javafx.aulas;

import java.util.ArrayList;

import br.edu.ifsp.javafx.aulas.model.Cadastro;
import br.edu.ifsp.javafx.aulas.model.Relato;

// Esta classe simula um SGDB. Coloque onde ficará os dados aqui!
public class Database {
    private ArrayList<Cadastro> cadastros;
    
    public Database() {
        cadastros = new ArrayList<>();
    }

    public void init(){
        cadastros.add(new Cadastro("João", "São Paulo", "Muita água parada ", "Urbano", "Cidadão"));
    }

    public void addDado(Cadastro novo){
        cadastros.add(novo);
    }

    public ArrayList<Cadastro> recuperaDado(){
        return cadastros;
    }

    
}
