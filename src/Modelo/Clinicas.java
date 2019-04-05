package Modelo;

import java.util.Objects;

/**
 * A classe <b>Clinicas</b> tem como função guardar métodos e valores para a mesma
 * @author Eustakio Junior
 * @author Alex Fernandes
 */


public class Clinicas  {
    private String nome;
    private String username;
    private String endereco;
    private String cnpj;
    private String telefone;
    private String senha;


    /**
     *Construtor com dados iniciais
     */


    public Clinicas(String nome, String username, String endereco, String cnpj, String telefone, String senha) {
        this.nome = nome;
        this.username = username;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.senha = senha;
    }


    /**
     * Gets e Sets do objeto Animais
     * @return horarioAtendimento, nome, username, endereco, cnpj, telefone, senha
     */


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clinicas clinicas = (Clinicas) o;
        return Objects.equals(username, clinicas.username) &&
                Objects.equals(cnpj, clinicas.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, cnpj);
    }

}
