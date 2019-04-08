package Dao;

import Modelo.UsuarioAtual;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

public interface UsuarioAtualDao {

    Set<UsuarioAtual> getUserAtual() throws IOException, ClassNotFoundException, SQLException;
}
