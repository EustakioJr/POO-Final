package Dao;

import Banco.ConFactory;
import Modelo.Ong;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class OngDaoBanco implements OngDao {

    private ConFactory factory;

    public OngDaoBanco(){
        factory = new ConFactory();
    }


    @Override
    public Set<Ong> getOngs() throws IOException, ClassNotFoundException, SQLException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM ONG"
            );

            ResultSet resultSet = statement.executeQuery();
            Set<Ong> ongs = new HashSet<>();

            while (resultSet.next())
            {
                String nome = resultSet.getString("Razão");
                String username = resultSet.getString("User");
                String cnpj = resultSet.getString("CNPJ");
                String endereco = resultSet.getString("Endereço");
                String senha = resultSet.getString("Senha");
                String telefone = resultSet.getString("Telefone");

                ongs.add(new Ong(nome, username, cnpj, endereco, senha, telefone));
            }
            return ongs;

        }
    }

    @Override
    public boolean salvar(Ong ong) throws IOException, ClassNotFoundException, SQLException {
        try (Connection connection = factory.getConnection()){
            PreparedStatement statement= connection.prepareStatement(
                    "INSERT INTO ong(razao, username, cnpj, endereco, senha, telefone) VALUES(?, ?, ?, ?, ?, ?);"
            );

            statement.setString(1, ong.getNomeOng());
            statement.setString(2, ong.getUsername());
            statement.setString(3, ong.getCnpj());
            statement.setString(4, ong.getEndereco());
            statement.setString(5, ong.getSenha());
            statement.setString(6, ong.getTelefone());

            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public Ong buscarPorUsername(String username) throws SQLException, ClassNotFoundException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM ONG WHERE USERNAME = ?"
            );

            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                String nome = resultSet.getString("Razão");
                String cnpj = resultSet.getString("CNPJ");
                String endereco = resultSet.getString("Endereço");
                String senha = resultSet.getString("Senha");
                String telefone = resultSet.getString("Telefone");

                return new Ong(nome, username, cnpj, endereco, senha, telefone);
            }else return null;
        }
    }

    @Override
    public boolean deletar(Ong ong) throws IOException, ClassNotFoundException, SQLException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM ONG WHERE cnpj = ?"
            );

            statement.setString(1, ong.getCnpj());

            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public boolean atualizar(Ong ong) throws IOException, ClassNotFoundException, SQLException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE ong " +
                            "SET razao = ?, username = ?, endereco = ?, senha = ?, telefone = ?" +
                            "WHERE cnpj = ?"
            );

            statement.setString(1, ong.getNomeOng());
            statement.setString(2, ong.getUsername());
            statement.setString(3, ong.getEndereco());
            statement.setString(4, ong.getSenha());
            statement.setString(5, ong.getTelefone());
            statement.setString(6, ong.getCnpj());

            return statement.executeUpdate() > 0;
        }
    }
}
