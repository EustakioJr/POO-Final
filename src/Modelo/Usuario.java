package Modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Usuario {
    private String nome;
    private String username;
    private String cpf;
    private LocalDate nascimento;
    private String senha;

    public Usuario(String nome, String username, String cpf, LocalDate nascimento, String senha) {
        this.nome = nome;
        this.username = username;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.senha = senha;
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

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
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

}
