package br.edu.ifsp.javafx.aulas.model;

public class Cadastro {
    private String nome;
    private String local;
    private String descricao;
    private String tipo;
    private String tipoPersona;
    
    public Cadastro(String nome, String local, String descricao, String tipo, String tipoPersona) {
        this.nome = nome;
        this.local = local;
        this.descricao = descricao;
        this.tipo = tipo;
        this.tipoPersona = tipoPersona;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getTipoPersona() {
        return tipoPersona;
    }
    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
    @Override
    public String toString() {
        return "Cadastro [nome=" + nome + ", local=" + local + ", descricao=" + descricao + ", tipo=" + tipo
                + ", tipoPersona=" + tipoPersona + "]";
    }    
}
