package br.edu.ifsp.javafx.aulas.model;

import java.util.ArrayList;

import br.edu.ifsp.javafx.aulas.Database;

public class CadastroDAO {
    
    private Database db;
    private static CadastroDAO instance;

    // O construtor privado garante que uma única instância irá existir
    private CadastroDAO(){
       
    }

    // Recupera a única instância do DAO
    public static CadastroDAO getInstance(){
        if(instance == null){
            instance = new CadastroDAO();
        }
        return instance;
    }

    // Recupera a conexão com o Banco de Dados
    private Database getConnection(){
        if(this.db == null){            
            Database db = new Database();
            db.init();
            this.db = db;
        }
        return this.db;    
    }

    //Cria um novo cadastro
    public void create(Cadastro novo){
        Database db = getConnection();
        db.addDado(novo);
    }   

    // Recupera todas as listas
    public ArrayList<Cadastro> read(){
        Database db = getConnection();
        return db.recuperaDado();
    }

    public void delete(Cadastro deletar){
        // Sem implementação
    }

    public void update(Cadastro toUpdate){
        // Sem implementação
    }

}
