package Dao;

import Banco.ConFactory;
import Modelo.Animais;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class AnimaisDaoBanco implements AnimaisDao {

    private ConFactory factory;

    public AnimaisDaoBanco(){
        factory = new ConFactory();
    }

    @Override
    public Set<Animais> getAnimais() throws IOException, ClassNotFoundException, SQLException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM ANIMAL"
            );

            ResultSet resultSet = statement.executeQuery();
            Set<Animais> animais = new HashSet<>();

            while (resultSet.next())
            {
                String id = resultSet.getString("id");
                String nome = resultSet.getString("nome");
                String especie = resultSet.getString("especie");
                String ongPertencente = resultSet.getString("ongpertecente");
                LocalDate idade = resultSet.getDate("idade").toLocalDate();
                boolean castrado = resultSet.getBoolean("castrado");

                animais.add(new Animais(id, nome, especie, ongPertencente, idade, castrado));
            }
            return animais;
        }
    }

    @Override
    public boolean salvar(Animais animal) throws IOException, ClassNotFoundException, SQLException {
        try (Connection connection = factory.getConnection()){
            PreparedStatement statement= connection.prepareStatement(
                    "INSERT INTO animal(id, nome, especie, ongpertencente, idade, castrado) VALUES(?, ?, ?, ?, ?, ?);"
            );

            statement.setString(1, animal.getId());
            statement.setString(2, animal.getNome());
            statement.setString(3, animal.getEspecie());
            statement.setString(4, animal.getOngPertencente());
            statement.setDate(5, Date.valueOf(animal.getNascimento()));
            statement.setBoolean(6, animal.isCastrado());

            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public Animais buscarPorId(String id) throws SQLException, ClassNotFoundException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM ANIMAL WHERE ID = ?"
            );

            statement.setString(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                String nome = resultSet.getString("nome");
                String especie = resultSet.getString("especie");
                String ongPertencente = resultSet.getString("ongpertecente");
                LocalDate idade = resultSet.getDate("idade").toLocalDate();
                boolean castrado = resultSet.getBoolean("castrado");

                return new Animais(id, nome, especie, ongPertencente, idade, castrado);
            }else return null;
        }
    }

    @Override
    public boolean deletar(Animais animal) throws IOException, ClassNotFoundException, SQLException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM ANIMAL WHERE ID = ?"
            );

            statement.setString(1, animal.getId());

            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public boolean atualizar(Animais animal) throws IOException, ClassNotFoundException, SQLException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE animal " +
                            "SET nome = ?, especie = ?, ongpertencente = ?, idade = ?, castrado = ?" +
                            "WHERE id = ?"
            );

            statement.setString(1, animal.getNome());
            statement.setString(2, animal.getEspecie());
            statement.setString(3, animal.getOngPertencente());
            statement.setDate(4, Date.valueOf(animal.getNascimento()));
            statement.setBoolean(5, animal.isCastrado());
            statement.setString(6, animal.getId());

            return statement.executeUpdate() > 0;
        }
    }

}
