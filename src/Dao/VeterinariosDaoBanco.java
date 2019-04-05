package Dao;

import Banco.ConFactory;
import Modelo.Veterinarios;

import java.io.IOException;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class VeterinariosDaoBanco implements  VeterinarioDao {

    private ConFactory factory;

    public VeterinariosDaoBanco(){
        factory = new ConFactory();
    }

    @Override
    public Set<Veterinarios> getVeterinarios() throws IOException, ClassNotFoundException, SQLException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Veterinario"
            );

            ResultSet resultSet = statement.executeQuery();
            Set<Veterinarios> veterinarios = new HashSet<>();


            while (resultSet.next())
            {
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                String crvm = resultSet.getString("crvm");
                String email = resultSet.getString("email");

                veterinarios.add(new Veterinarios(nome, telefone, crvm, email));
            }
            return veterinarios;

        }
    }

    @Override
    public boolean salvar(Veterinarios veterinarios) throws IOException, ClassNotFoundException, SQLException {
        try (Connection connection = factory.getConnection()){
            PreparedStatement statement= connection.prepareStatement(
                    "INSERT INTO veterinario(nome, telefone, crvm, email) VALUES(?, ?, ?, ?);"
            );

            statement.setString(1, veterinarios.getNome());
            statement.setString(2, veterinarios.getTelefone());
            statement.setString(3, veterinarios.getCrvm());
            statement.setString(4, veterinarios.getEmail());

            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public Veterinarios buscarPorCRVM(String crvm) throws SQLException, ClassNotFoundException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM veterinario WHERE crvm = ?"
            );

            statement.setString(1, crvm);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                String email = resultSet.getString("email");

                return new Veterinarios(nome, telefone, crvm, email);
            }else return null;
        }
    }

    @Override
    public boolean deletar(Veterinarios veterinarios) throws IOException, ClassNotFoundException, SQLException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM veterinario WHERE crvm = ?"
            );

            statement.setString(1, veterinarios.getCrvm());

            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public boolean atualizar(Veterinarios veterinarios) throws IOException, ClassNotFoundException, SQLException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE veterinario " +
                            "SET nome=?, telefone=?, email=?" +
                            "WHERE crvm = ?"
            );

            statement.setString(1, veterinarios.getNome());
            statement.setString(2, veterinarios.getTelefone());
            statement.setString(3, veterinarios.getCrvm());
            statement.setString(4, veterinarios.getEmail());

            return statement.executeUpdate() > 0;
        }
    }
}
