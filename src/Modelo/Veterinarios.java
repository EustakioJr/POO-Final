package Modelo;

public class Veterinarios {
    private static int cont;
    private final int ID;
    private String nome;
    private int telefone;
    private String crvm;
    private String email;

    public Veterinarios(String nome, int telefone, String crvm, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.crvm = crvm;
        this.email = email;
        ID = ++cont;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getCrvm() {
        return crvm;
    }

    public void setCrvm(String crvm) {
        this.crvm = crvm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getID() {
        return ID;
    }
}
