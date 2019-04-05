package Dao;

import Banco.ConFactory;
import Modelo.Animais;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                int id = resultSet.getInt("ID");
                String nome = resultSet.getString("Nome");
                String especie = resultSet.getString("Especie");
                String ongPertencente = resultSet.getString("ONG Pertencente");
                String idade = resultSet.getString("Idade");
                boolean castrado = resultSet.getBoolean("Castrado");

                animais.add(new Animais(nome, especie, ongPertencente, idade, castrado));
            }
            return animais;
        }
    }

    @Override
    public boolean salvar(Animais animal) throws IOException, ClassNotFoundException, SQLException {
        try (Connection connection = factory.getConnection()){
            PreparedStatement statement= connection.prepareStatement(
                    "INSERT INTO animal(id, nome, especie, ongpertencente, idade, castrado) VALUES(?, ?, ?, ?, ?, ?, ?, ?);"
            );

            statement.setInt(1, animal.getID());
            statement.setString(2, animal.getNome());
            statement.setString(3, animal.getEspecie());
            statement.setString(4, animal.getOngPertencente());
            statement.setString(5, animal.getidade());
            statement.setBoolean(6, animal.isCastrado());

            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public Animais buscarPorId(int id) throws SQLException, ClassNotFoundException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM ANIMAL WHERE ID = ?"
            );

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                String nome = resultSet.getString("Nome");
                String especie = resultSet.getString("Especie");
                String ongPertencente = resultSet.getString("ONG Pertencente");
                String idade = resultSet.getString("Idade");
                boolean castrado = resultSet.getBoolean("Castrado");

                return new Animais(nome, especie, ongPertencente, idade, castrado);
            }else return null;
        }
    }

    @Override
    public boolean deletar(Animais animal) throws IOException, ClassNotFoundException, SQLException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM ANIMAL WHERE ID = ?"
            );

            statement.setInt(1, animal.getID());

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
            statement.setString(4, animal.getidade());
            statement.setBoolean(5, animal.isCastrado());
            statement.setInt(6, animal.getID());

            return statement.executeUpdate() > 0;
        }
    }

}
