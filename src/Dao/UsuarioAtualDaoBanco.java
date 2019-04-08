package Dao;

import Banco.ConFactory;
import Excecoes.DataInvalida;
import Modelo.UsuarioAtual;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class UsuarioAtualDaoBanco implements UsuarioAtualDao {

    private ConFactory factory;

    public UsuarioAtualDaoBanco() {

        factory = new ConFactory();
    }

    @Override
    public Set<UsuarioAtual> getUserAtual() throws IOException, ClassNotFoundException, SQLException {
        try (Connection connection = factory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM useratual;"
            );

            ResultSet resultSet = statement.executeQuery();
            Set<UsuarioAtual> usuarioAtual = new HashSet<>();

            while (resultSet.next()) {
                String user = resultSet.getString("usera");
                String tipo = resultSet.getString("tipo");

                usuarioAtual.add(new UsuarioAtual(user, tipo));
            }
            return usuarioAtual;
        }
    }

    public UsuarioAtual buscarPorPadrao(String p) throws SQLException, ClassNotFoundException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM USERATUAL WHERE PADRAO = ?"
            );

            statement.setString(1, p);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                String user = resultSet.getString("usera");
                String tipo = resultSet.getString("tipo");

                return new UsuarioAtual(user, tipo);
            }else return null;
        }
    }

    public boolean atualizar(UsuarioAtual userA) throws IOException, ClassNotFoundException, SQLException {
        try (Connection connection = factory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE useratual " +
                            "SET usera=?, tipo = ?" +
                            "WHERE padrao = ?"
            );
            String p = "padrao";
            statement.setString(1, userA.getUseratual());
            statement.setString(2, userA.getTipo());
            statement.setString(3, p);

            return statement.executeUpdate() > 0;
        }
    }
}
