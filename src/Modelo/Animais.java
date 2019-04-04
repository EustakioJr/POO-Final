package Modelo;

public class Animais {
    private static int cont;
    private final int ID;
    private String nome;
    private String especie;
    private String ongPertencente;
    private int idade;
    private boolean castrado;

    public Animais(String nome, String especie, String ongPertencente, int idade, boolean castrado) {
        this.nome = nome;
        this.especie = especie;
        this.ongPertencente = ongPertencente;
        this.idade = idade;
        this.castrado = castrado;
        ID = ++cont;
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

    public int getidade() {
        return idade;
    }

    public void setidade(int idade) {
        this.idade = idade;
    }

    public boolean isCastrado() {
        return castrado;
    }

    public void setCastrado(boolean castrado) {
        this.castrado = castrado;
    }

    public int getID() {
        return ID;
    }
}
