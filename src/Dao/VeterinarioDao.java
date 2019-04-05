package Dao;

import Modelo.Veterinarios;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

public interface VeterinarioDao {

    /**
     * <b>Função de set para Veterinarios.</b>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    Set<Veterinarios> getVeterinarios() throws IOException, ClassNotFoundException, SQLException;

    /**
     * <b>Função de salvar</b>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    boolean salvar(Veterinarios veterinarios) throws IOException, ClassNotFoundException, SQLException;

    /**
     * <b>Função de busca para Veterinarios.</b>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Veterinarios buscarPorCRVM(String crvm) throws SQLException, ClassNotFoundException;

    /**
     * <b>Função de deletar Veterinarios.</b>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    boolean deletar(Veterinarios veterinarios) throws IOException, ClassNotFoundException, SQLException;

    /**
     * <b>Função de atualizar Veterinarios.</b>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    boolean atualizar(Veterinarios veterinarios) throws IOException, ClassNotFoundException, SQLException;
}
