package Controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import Enum.TipoCadastro;

public class ControleTelaLogin {
    @FXML
    private Button botaoLogin;

    @FXML
    private ChoiceBox<TipoCadastro> campoTipo;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private TextField campoUser;

    @FXML
    private Label labelAviso;

    @FXML
    private Button botaoVoltar;

    @FXML
    void irInicio(ActionEvent event) {
        Visao.App.trocaTela("inicio");
    }

    @FXML
    void login(ActionEvent event) {
        switch (campoTipo.getValue()){
            case ONG:
                Visao.App.trocaTela("homeOng");
                break;
            case CLINICA:
                Visao.App.trocaTela("homeClinica");
                break;
            case USUARIO:
                Visao.App.trocaTela("homeUsuario");
        }
    }

    public void initialize() {
        campoTipo.getItems().addAll(TipoCadastro.values());

    }


}


