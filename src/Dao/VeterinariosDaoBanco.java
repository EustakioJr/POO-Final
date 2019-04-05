package Dao;

import Modelo.Veterinarios;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

public class VeterinariosDaoBanco implements  VeterinarioDao {
    @Override
    public Set<Veterinarios> getVeterinarios() throws IOException, ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public boolean salvar(Veterinarios veterinarios) throws IOException, ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public Veterinarios buscarPorCRVM(String crvm) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean deletar(Veterinarios veterinarios) throws IOException, ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean atualizar(Veterinarios veterinarios) throws IOException, ClassNotFoundException, SQLException {
        return false;
    }
}
