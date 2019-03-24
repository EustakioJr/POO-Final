package Modelo;

import java.time.LocalDate;

public class Animais {
    private String nome;
    private String especie;
    private String ongPertencente;
    private LocalDate idade;
    private boolean castrado;

    public Animais(String nome, String especie, String ongPertencente, LocalDate idade, boolean castrado) {
        this.nome = nome;
        this.especie = especie;
        this.ongPertencente = ongPertencente;
        this.idade = idade;
        this.castrado = castrado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getOngPertencente() {
        return ongPertencente;
    }

    public void setOngPertencente(String ongPertencente) {
        this.ongPertencente = ongPertencente;
    }

    public LocalDate getidade() {
        return idade;
    }

    public void setidade(LocalDate idade) {
        this.idade = idade;
    }

    public boolean isCastrado() {
        return castrado;
    }

    public void setCastrado(boolean castrado) {
        this.castrado = castrado;
    }
}
