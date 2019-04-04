package Modelo;

import java.util.Objects;

public class Clinicas  {

    private String nome;
    private String username;
    private String endereco;
    private String cnpj;
    private String descricao;
    private String senha;
    private String horarioAtendimento;

    public Clinicas(String nome, String username, String endereco, String cnpj, String descricao, String senha, String horarioAtendimento) {
        this.horarioAtendimento = horarioAtendimento;
        this.nome = nome;
        this.username = username;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.senha = senha;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getHorarioAtendimento() {
        return horarioAtendimento;
    }

    public void setHorarioAtendimento(String horarioAtendimento) {
        this.horarioAtendimento = horarioAtendimento;
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
