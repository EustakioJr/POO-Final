package Dao;

import Modelo.Animais;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

public interface AnimaisDao {

    /**
     * <b>Função de set para Animais.</b>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */

    Set<Animais> getAnimais() throws IOException, ClassNotFoundException, SQLException;

    /**
     * <b>Função de salvar</b>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    boolean salvar(Animais animal) throws IOException, ClassNotFoundException, SQLException;

    /**
     * <b>Função de busca para Animais.</b>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Animais buscarPorId(int id) throws SQLException, ClassNotFoundException;

    /**
     * <b>Função de deletar Animais.</b>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    boolean deletar(Animais animal) throws IOException, ClassNotFoundException, SQLException;

    /**
     * <b>Função de atualizar Animais.</b>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    boolean atualizar(Animais animal) throws IOException, ClassNotFoundException, SQLException;
}
