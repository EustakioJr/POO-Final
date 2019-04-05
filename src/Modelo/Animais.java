package Modelo;

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
    private String idade;
    private boolean castrado;

    /**
     *Construtor com dados iniciais
     */


    public Animais(String id, String nome, String especie, String ongPertencente, String idade, boolean castrado) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.ongPertencente = ongPertencente;
        this.idade = idade;
        this.castrado = castrado;
    }

    /**
     * Gets e Sets do objeto Animais
     * @return nome, especie, ongPertence, idade, castrado, ID
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

    public String getidade() {
        return idade;
    }

    public void setidade(String idade) {
        this.idade = idade;
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
