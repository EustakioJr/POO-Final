package Modelo;

import java.util.Objects;


/**
 * A classe <b>Ong</b> tem como função guardar métodos e valores para a mesma
 * @author Eustakio Junior
 * @author Alex Fernandes
 */


public class Ong {
    private String nomeOng;
    private String username;
    private String cnpj;
    private String endereco;
    private String senha;
    private String telefone;

    /**
     *Construtor com dados iniciais
     */


    public Ong(String nomeOng, String username, String cnpj, String endereco, String senha, String telefone) {
        this.nomeOng = nomeOng;
        this.username = username;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.senha = senha;
        this.telefone = telefone;
    }


    /**
     * Gets e Sets do objeto Animais
     * @return nomeOng, username, cnpj, endereco, senha, telefone
     */


    public String getNomeOng() {
        return nomeOng;
    }

    public void setNomeOng(String nomeOng) {
        this.nomeOng = nomeOng;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ong)) return false;
        Ong ong = (Ong) o;
        return Objects.equals(username, ong.username) &&
                Objects.equals(cnpj, ong.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, cnpj);
    }

}
