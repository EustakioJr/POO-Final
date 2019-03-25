package Modelo;

import java.util.Objects;

public class Ong {
    private final String ID;
    private String nomeOng;
    private String username;
    private String cnpj;
    private String endereco;
    private String senha;
    private String descricao;

    public Ong(String nomeOng, String username, String cnpj, String endereco, String senha, String descricao) {
        ID = "ONG";
        this.nomeOng = nomeOng;
        this.username = username;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.senha = senha;
        this.descricao = descricao;
    }

    @SuppressWarnings("WeakerAccess")
    public String getID() {
        return ID;
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    @Override
    public String toString() {
        return getID();
    }
}
