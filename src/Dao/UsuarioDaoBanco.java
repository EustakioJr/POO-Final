package Dao;

import Banco.ConFactory;
import Modelo.Usuario;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class UsuarioDaoBanco implements UsuarioDao {

    private ConFactory factory;

    public UsuarioDaoBanco(){
        factory = new ConFactory();
    }

    @Override
    public Set<Usuario> getUsuarios() throws IOException, ClassNotFoundException, SQLException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM USUARIO"
            );

            ResultSet resultSet = statement.executeQuery();
            Set<Usuario> usuarios = new HashSet<>();

            while (resultSet.next())
            {
                String nome = resultSet.getString("nome");
                String username = resultSet.getString("username");
                String cpf = resultSet.getString("cpf");
                LocalDate datanasc = resultSet.getDate("datanasc").toLocalDate();
                String senha = resultSet.getString("Senha");

                usuarios.add(new Usuario(nome, username, cpf, datanasc, senha));
            }
            return usuarios;

        }
    }

    @Override
    public boolean salvar(Usuario usuario) throws IOException, ClassNotFoundException, SQLException {


        try (Connection connection = factory.getConnection()){
            PreparedStatement statement= connection.prepareStatement(
                    "INSERT INTO usuario(nome, username, cpf, datanasc, senha) VALUES(?, ?, ?, ?, ?);"
            );

            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getUsername());
            statement.setString(3, usuario.getCpf());
            statement.setDate(4, Date.valueOf(usuario.getNascimento()));
            statement.setString(5, usuario.getSenha());

            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public Usuario buscarPorUsername(String username) throws SQLException, ClassNotFoundException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM USUARIO WHERE USERNAME = ?"
            );

            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                String nome = resultSet.getString("nome");
                String cpf = resultSet.getString("cpf");
                LocalDate datanasc = resultSet.getDate("datanasc").toLocalDate();
                String senha = resultSet.getString("Senha");

                return new Usuario(nome, username, cpf, datanasc, senha);
            }else return null;
        }
    }

    @Override
    public boolean deletar(Usuario usuario) throws IOException, ClassNotFoundException, SQLException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM USUARIO WHERE CPF = ?"
            );

            statement.setString(1, usuario.getCpf());

            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public boolean atualizar(Usuario usuario) throws IOException, ClassNotFoundException, SQLException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE USUARIO " +
                            "SET nome=?, username=?, datanasc=?, senha=?" +
                            "WHERE cpf = ?"
            );

            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getUsername());
            statement.setDate(3, Date.valueOf(usuario.getNascimento()));
            statement.setString(4, usuario.getSenha());
            statement.setString(5, usuario.getCpf());

            return statement.executeUpdate() > 0;
        }
    }
}
