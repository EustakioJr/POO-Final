package Controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

public class ControleTelaHomeClinica {


    @FXML
    private MenuItem opcaoHome;

    @FXML
    private MenuItem opcaoLogout;

    @FXML
    private Button botaoListaOng;

    @FXML
    private Button botaoLogout;

    @FXML
    private Button botaoAlterar;

    @FXML
    private Button botaoAdicionaVet;

    @FXML
    void irAlterar(ActionEvent event) {

    }

    @FXML
    void irCadastroVet(ActionEvent event) {
        Visao.App.trocaTela("registroVet");
    }

    @FXML
    void irHome(ActionEvent event) {
        Visao.App.trocaTela("homeClinica");
    }

    @FXML
    void logout(ActionEvent event) {
        Visao.App.trocaTela("inicio");
    }

    public void irListaOng(ActionEvent actionEvent) {
    }
}
