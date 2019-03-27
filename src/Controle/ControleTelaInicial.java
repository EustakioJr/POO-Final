package Controle;

import Visao.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControleTelaInicial {

    @FXML
    private Button botaoLogin;

    @FXML
    private Button botaoCadastro;

    @FXML
    void irTelaCadastro(ActionEvent event) {
        Visao.App.trocaTela("cadastro");
    }

    @FXML
    void irTelaLogin(ActionEvent event) {
        Visao.App.trocaTela("login");
    }

}
