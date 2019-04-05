package Modelo;

/**
 * A classe <b>Veterinarios</b> tem como função guardar métodos e valores para o mesmo
 * @author Eustakio Junior
 * @author Alex Fernandes
 */


public class Veterinarios{
    private String nome;
    private String telefone;
    private String crvm;
    private String email;

    /**
     *Construtor com dados iniciais
     */


    public Veterinarios(String nome, String telefone, String crvm, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.crvm = crvm;
        this.email = email;
    }


    /**
     * Gets e Sets do objeto Animais
     * @return nome, telefone, crvm, email, ID
     */


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
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
}
