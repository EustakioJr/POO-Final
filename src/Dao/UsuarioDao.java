package Dao;

import Modelo.Usuario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

public interface UsuarioDao {

    Set<Usuario> getUsuarios() throws IOException, ClassNotFoundException, SQLException;

    /**
     * <b>Função de salvar</b>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */

    boolean salvar(Usuario usuario) throws IOException, ClassNotFoundException, SQLException;

    /**
     * <b>Função de busca os Ususarios.</b>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    public Usuario buscarPorUsername(String username) throws SQLException, ClassNotFoundException;

    /**
     * <b>Função de deletar Usuarios.</b>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */

    boolean deletar(Usuario usuario) throws IOException, ClassNotFoundException, SQLException;

    /**
     * <b>Função de atualizar Usuarios.</b>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */

    boolean atualizar(Usuario usuario) throws IOException, ClassNotFoundException, SQLException;

}
