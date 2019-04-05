package Dao;

import Modelo.Ong;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

public interface OngDao {
    /**
     * <b>Função de set para Ongs.</b>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    Set<Ong> getOngs() throws IOException, ClassNotFoundException, SQLException;

    /**
     * <b>Função de salvar</b>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    boolean salvar(Ong ong) throws IOException, ClassNotFoundException, SQLException;

    /**
     * <b>Função de busca para Ongs.</b>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Ong buscarPorUsername(String username) throws SQLException, ClassNotFoundException;

    /**
     * <b>Função de deletar Ongs.</b>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    boolean deletar(Ong ong) throws IOException, ClassNotFoundException, SQLException;

    /**
     * <b>Função de atualizar Ongs.</b>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    boolean atualizar(Ong ong) throws IOException, ClassNotFoundException, SQLException;
}

