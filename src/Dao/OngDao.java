package Dao;

import Modelo.Ong;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

public interface OngDao {

    Set<Ong> getOngs() throws IOException, ClassNotFoundException, SQLException;
    boolean salvar(Ong ong) throws IOException, ClassNotFoundException, SQLException;
    public Ong buscarPorUsername(String username) throws SQLException, ClassNotFoundException;
    boolean deletar(Ong ong) throws IOException, ClassNotFoundException, SQLException;
    boolean atualizar(Ong ong) throws IOException, ClassNotFoundException, SQLException;
}
