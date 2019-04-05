package Dao;

import Modelo.Clinicas;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

public interface ClinicaDao {

    Set<Clinicas> getClinicas() throws IOException, ClassNotFoundException, SQLException;
    boolean salvar(Clinicas clinicas) throws IOException, ClassNotFoundException, SQLException;
    public Clinicas buscarPorUsername(String username) throws SQLException, ClassNotFoundException;
    boolean deletar(Clinicas clinicas) throws IOException, ClassNotFoundException, SQLException;
    boolean atualizar(Clinicas clinicas) throws IOException, ClassNotFoundException, SQLException;
}
