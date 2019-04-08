package Modelo;

import Excecoes.DataInvalida;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;
import Excecoes.DataInvalida;

/**
 * A classe <b>Usuario</b> tem como função guardar métodos e valores para o mesmo
 * @author Eustakio Junior
 * @author Alex Fernandes
 */


public class Usuario {
    private String nome;
    private String username;
    private String cpf;
    private LocalDate nascimento;
    private String senha;

    /**
     *Construtor com dados iniciais
     */


    public Usuario(String nome, String username, String cpf, LocalDate nascimento, String senha) {
        this.nome = nome;
        this.username = username;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.senha = senha;
    }


    /**
     * Gets e Sets do objeto Animais
     * @return nome, username, cpf, nascimento, senha, ID
     */


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

    public LocalDate getNascimento() throws DataInvalida {
        if (nascimento.compareTo(LocalDate.now()) > 0) throw new DataInvalida(
                "Data de nascimento Invalida");
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
