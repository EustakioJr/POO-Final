package Controle;

import Dao.ClinicasDaoBanco;
import Dao.OngDaoBanco;
import Dao.UsuarioDaoBanco;
import Modelo.Clinicas;
import Modelo.Ong;
import Modelo.Usuario;
import Visao.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Classe responsavel de salvar os IDs dos elementos graficos da interface e guardar os metodos que serão utilizados.
 */
public class ControleTelaInicial implements Initializable {
    OngDaoBanco daoOng = new OngDaoBanco();
    ClinicasDaoBanco daoClinica = new ClinicasDaoBanco();
    UsuarioDaoBanco daoUsuario = new UsuarioDaoBanco();
    /**
     * IDs da interface grafica
     */
    @FXML
    private Button botaoLogin;

    @FXML
    private Button botaoCadastro;

    @FXML
    void irTelaCadastro(ActionEvent event) {
        Visao.App.trocaTela("cadastro");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /**
     * Metodo que realiza a busca e autenticação do login e o realiza
     * @param event
     */

}
