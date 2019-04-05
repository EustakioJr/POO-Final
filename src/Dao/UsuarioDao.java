package Dao;

import Modelo.Usuario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

public interface UsuarioDao {

    Set<Usuario> getUsuarios() throws IOException, ClassNotFoundException, SQLException;
    boolean salvar(Usuario usuario) throws IOException, ClassNotFoundException, SQLException;
    public Usuario buscarPorUsername(String username) throws SQLException, ClassNotFoundException;
    boolean deletar(Usuario usuario) throws IOException, ClassNotFoundException, SQLException;
    boolean atualizar(Usuario usuario) throws IOException, ClassNotFoundException, SQLException;

}
