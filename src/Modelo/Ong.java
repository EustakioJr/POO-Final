package Modelo;

import java.util.Objects;

public class Ong {
    private static int cont;
    private final int ID;
    private String nomeOng;
    private String username;
    private String cnpj;
    private String endereco;
    private String senha;
    private String telefone;

    public Ong(String nomeOng, String username, String cnpj, String endereco, String senha, String telefone) {
        this.nomeOng = nomeOng;
        this.username = username;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.senha = senha;
        this.telefone = telefone;
        ID = ++cont;
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

    public int getID() {
        return ID;
    }
}
