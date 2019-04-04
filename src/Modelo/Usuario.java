package Modelo;

import java.util.Objects;

public class Usuario {
    private static int cont;
    private final int ID;
    private String nome;
    private String username;
    private String cpf;
    private String nascimento;
    private String senha;

    public Usuario(String nome, String username, String cpf, String nascimento, String senha) {
        this.nome = nome;
        this.username = username;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.senha = senha;
        ID = ++cont;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
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
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(username, usuario.username) &&
                Objects.equals(cpf, usuario.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, cpf);
    }

    public int getID() {
        return ID;
    }
}
