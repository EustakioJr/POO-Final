package Dao;

import Modelo.Clinicas;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

public interface ClinicaDao {
    /**
     * <b>Função de set para Clinicas.</b>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    Set<Clinicas> getClinicas() throws IOException, ClassNotFoundException, SQLException;

    /**
     * <b>Função de salvar</b>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    boolean salvar(Clinicas clinicas) throws IOException, ClassNotFoundException, SQLException;

    /**
     * <b>Função de busca para Clinicas.</b>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Clinicas buscarPorUsername(String username) throws SQLException, ClassNotFoundException;

    /**
     * <b>Função de deletar Clinicas.</b>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    boolean deletar(Clinicas clinicas) throws IOException, ClassNotFoundException, SQLException;

    /**
     * <b>Função de atualizar Clinicas.</b>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    boolean atualizar(Clinicas clinicas) throws IOException, ClassNotFoundException, SQLException;
}

