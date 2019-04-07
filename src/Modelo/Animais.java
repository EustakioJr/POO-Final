package Modelo;

import Excecoes.DataInvalida;

import java.time.LocalDate;

/**
 * A classe <b>Animais</b> tem como função guardar métodos e valores para o mesmo
 * @author Eustakio Junior
 * @author Alex Fernandes
 */


public class Animais {
    private String id;
    private String nome;
    private String especie;
    private String ongPertencente;
    private LocalDate Nascimento;
    private boolean castrado;

    /**
     *Construtor com dados iniciais
     */


    public Animais(String id, String nome, String especie, String ongPertencente, LocalDate Nascimento, boolean castrado) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.ongPertencente = ongPertencente;
        this.Nascimento = Nascimento;
        this.castrado = castrado;
    }

    /**
     * Gets e Sets do objeto Animais
     * @return nome, especie, ongPertence, Nascimento, castrado, ID
     */


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

    public LocalDate getNascimento() throws DataInvalida {
        if (Nascimento.compareTo(LocalDate.now()) > 0) throw new DataInvalida(
                "Data de nascimento Invalida");
        return Nascimento;
    }

    public void setNascimento(LocalDate Nascimento) {
        this.Nascimento = Nascimento;
    }

    public boolean isCastrado() {
        return castrado;
    }

    public void setCastrado(boolean castrado) {
        this.castrado = castrado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
