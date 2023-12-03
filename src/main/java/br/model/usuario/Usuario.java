package br.model.usuario;

public class Usuario {

    private String nome = "";
    private int score;
    int aux = 0;

    public Usuario() {

    }

    public Usuario(String nome, int score) {
        this.nome = nome;
        this.score = score;
    }

    public Usuario(String nome) {
        this.nome = nome;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getScore() {
        return score;
    }

    public void somar(int ponto) {
        aux = aux + ponto;
    }

    public void setScore(int score) {

        this.score = score ++;
    }

}
