package Modelo;

import java.util.Objects;

public class Ong {
    private String nomeOng;
    private String usernameOng;
    private String cnpj;
    private String endereco;
    private String senha;
    private String descricao;

    public Ong(String nomeOng, String usernameOng, String cnpj, String endereco, String senha, String descricao) {
        this.nomeOng = nomeOng;
        this.usernameOng = usernameOng;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.senha = senha;
        this.descricao = descrição;
    }

    public String getNomeOng() {
        return nomeOng;
    }

    public void setNomeOng(String nomeOng) {
        this.nomeOng = nomeOng;
    }

    public String getUsernameOng() {
        return usernameOng;
    }

    public void setUsernameOng(String usernameOng) {
        this.usernameOng = usernameOng;
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
        return Objects.equals(usernameOng, ong.usernameOng) &&
                Objects.equals(cnpj, ong.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usernameOng, cnpj);
    }
}
