package Dao;

import Modelo.Animais;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

public interface AnimaisDao {
    Set<Animais> getAnimais() throws IOException, ClassNotFoundException, SQLException;
    boolean salvar(Animais animal) throws IOException, ClassNotFoundException, SQLException;
    public Animais buscarPorId(int id) throws SQLException, ClassNotFoundException;
    boolean deletar(Animais animal) throws IOException, ClassNotFoundException, SQLException;
    boolean atualizar(Animais animal) throws IOException, ClassNotFoundException, SQLException;
}
