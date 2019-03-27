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

    }

    @FXML
    void irTelaLogin(ActionEvent event) {
        System.out.println("Apertou Login!");
        Visao.App.trocaTela("login");
    }

}
