package br.edu.ifsp.javafx.aulas;

import java.util.ArrayList;

import br.edu.ifsp.javafx.aulas.model.Cadastro;
import br.edu.ifsp.javafx.aulas.model.Relato;

// Esta classe simula um SGDB. Coloque onde ficará os dados aqui!
public class Database2 {
    public ArrayList<Relato> relatos;
    
    public Database2() {
        relatos = new ArrayList<>();
    }

    public void init(){
        ArrayList<String> sintomas = new ArrayList<>();
        String sin1 = "dor de cabeça";
        String sin2 = "Febre";
        String sin3 = "Manchas no corpo";
        sintomas.add(sin1);
        sintomas.add(sin2);
        sintomas.add(sin3);
        relatos.add(new Relato("João", "Acabei contraindo dengue, e fuquei internado 6 dias no hospital pois minha situação estava bem ruim, com dores no corpo, febre alta, e muito mais.", "Teste", sintomas));
    }

    public ArrayList<Relato> recuperaDado(){
        return relatos;
    }

    public void addDado2(Relato novo) {
        relatos.add(novo);
    }
    public ArrayList<Relato> recuperaDado2(){
        return relatos;
    }

    
}