package br.edu.ifsp.javafx.aulas.model;

import java.util.ArrayList;

import br.edu.ifsp.javafx.aulas.Database2;

public class RelatoDAO {
    
    private Database2 db;
    private static RelatoDAO instance2;

    // O construtor privado garante que uma única instância irá existir
    private RelatoDAO(){
       
    }
    

    // Recupera a única instância do DAO
    public static RelatoDAO getInstance(){
        if(instance2 == null){
            instance2 = new RelatoDAO();
        }
        return instance2;
    }

    // Recupera a conexão com o Banco de Dados
    private Database2 getConnection(){
        if(this.db == null){            
            Database2 db = new Database2();
            db.init();
            this.db = db;
        }
        return this.db;    
    }

    //Cria um novo cadastro
    public void create(Relato novo){
        Database2 db = getConnection();
        db.addDado2(novo);
    }   

    // Recupera todas as listas
    public ArrayList<Relato> read(){
        Database2 db = getConnection();
        return db.recuperaDado();
    }

    public void delete(Relato deletar){
        // Sem implementação
    }

    public void update(Relato toUpdate){
        // Sem implementação
    }
}