package Controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControleTelaCadastro {

    @FXML
    private Button botaoUsuario;

    @FXML
    private Button botaoOng;

    @FXML
    private Button botaoClinica;

    @FXML
    private Button botaoVoltar;

    @FXML
    void irCadastroClinica(ActionEvent event) {
        Visao.App.trocaTela("registroClinica");
    }

    @FXML
    void irCadastroOng(ActionEvent event) {
        Visao.App.trocaTela("registroOng");
    }

    @FXML
    void irCadastroUsuario(ActionEvent event) {
        Visao.App.trocaTela("registroUsuario");
    }

    @FXML
    void irInicio(ActionEvent event) {
        Visao.App.trocaTela("inicio");
    }

}