package Controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControleRegistroUsuario {

    @FXML
    private Button botaoRegistro;

    @FXML
    private Label labelAviso;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoUser;

    @FXML
    private TextField campoCpf;

    @FXML
    private TextField campoNasc;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private Button botaoVoltar;

    @FXML
    void registrar(ActionEvent event) {
        labelAviso.setText("Usuario registrado com Sucesso");
    }

    @FXML
    void irCadastro(ActionEvent event) {
        campoCpf.setText("");
        campoNasc.setText("");
        campoNome.setText("");
        campoSenha.setText("");
        campoUser.setText("");
        labelAviso.setText("");
        Visao.App.trocaTela("cadastro");
    }

}