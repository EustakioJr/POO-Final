package Modelo;

public class Clinicas  {

    private final String ID;
    private String nome;
    private String username;
    private String endereco;
    private String cnpj;
    private String descricao;

    public Clinicas(String nome, String username, String endereco, String cnpj, String descricao) {
        ID = "Clinicas";
        this.nome = nome;
        this.username = username;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.descricao = descricao;
    }

    @SuppressWarnings("WeakerAccess")
    public String getID() {
        return ID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getdescricao() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return getID();
    }
}
