package br.com.model;

import java.io.Serializable;

public class Cliente implements Serializable{
    
    private static final long serialVersionUID = 19L;
    private String nome;
    private String cod;

    public Cliente() {
    }

    public Cliente(String nome, String cod) {
        this.nome = nome;
        this.cod = cod;
    }
    

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", cod=" + cod + '}';
    }
    
}
