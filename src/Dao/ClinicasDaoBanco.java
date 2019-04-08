package Dao;

import Banco.ConFactory;
import Modelo.Clinicas;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ClinicasDaoBanco implements ClinicaDao{

    private ConFactory factory;

    public ClinicasDaoBanco(){
        factory = new ConFactory();
    }

    @Override
    public Set<Clinicas> getClinicas() throws IOException, ClassNotFoundException, SQLException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM CLINICA"
            );

            ResultSet resultSet = statement.executeQuery();
            Set<Clinicas> clinicas = new HashSet<>();


            while (resultSet.next())
            {
                String nome = resultSet.getString("razao");
                String username = resultSet.getString("username");
                String endereco = resultSet.getString("endereco");
                String cnpj = resultSet.getString("cnpj");
                String telefone = resultSet.getString("telefone");
                String senha = resultSet.getString("senha");

                clinicas.add(new Clinicas(nome, username, endereco, cnpj, telefone, senha));
            }
            return clinicas;

        }
    }

    @Override
    public boolean salvar(Clinicas clinicas) throws IOException, ClassNotFoundException, SQLException {
        try (Connection connection = factory.getConnection()){
            PreparedStatement statement= connection.prepareStatement(
                    "INSERT INTO clinica(razao, username, endereco, cnpj, telefone, senha) VALUES(?, ?, ?, ?, ?, ?);"
            );



            statement.setString(1, clinicas.getNome());
            statement.setString(2, clinicas.getUsername());
            statement.setString(3, clinicas.getEndereco());
            statement.setString(4, clinicas.getCnpj());
            statement.setString(5, clinicas.getTelefone());
            statement.setString(6, clinicas.getSenha());

            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public Clinicas buscarPorUsername(String username) throws SQLException, ClassNotFoundException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM CLINICA WHERE USERNAME = ?"
            );

            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                String nome = resultSet.getString("razao");
                String endereco = resultSet.getString("endereco");
                String cnpj = resultSet.getString("cnpj");
                String telefone = resultSet.getString("telefone");
                String senha = resultSet.getString("senha");

                return new Clinicas(nome, username, endereco, cnpj, telefone, senha);
            }else return null;
        }
    }

    @Override
    public boolean deletar(Clinicas clinicas) throws IOException, ClassNotFoundException, SQLException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM CLINICA WHERE CNPJ = ?"
            );

            statement.setString(1, clinicas.getCnpj());

            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public boolean atualizar(Clinicas clinicas) throws IOException, ClassNotFoundException, SQLException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE CLINICA " +
                            "SET razao=?, username=?, endereco=?, telefone=?, senha=?" +
                            "WHERE cnpj = ?"
            );

            statement.setString(1, clinicas.getNome());
            statement.setString(2, clinicas.getUsername());
            statement.setString(3, clinicas.getEndereco());
            statement.setString(4, clinicas.getTelefone());
            statement.setString(5, clinicas.getSenha());
            statement.setString(7, clinicas.getCnpj());

            return statement.executeUpdate() > 0;
        }
    }
}
