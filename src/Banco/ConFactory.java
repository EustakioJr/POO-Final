package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConFactory {

    private final String url;
    private final String usuario;
    private final String senha;

    public ConFactory(){
        url = "jdbc:postgresql://localhost:5432/projeto_ongs";
        usuario = "postgres";
        senha = "postgres";
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url,usuario,senha);
    }
}
