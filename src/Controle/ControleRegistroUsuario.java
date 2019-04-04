package Controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import util.TextFieldFormatter;

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
    private DatePicker campoNasc;

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
        campoNasc.setValue(null);
        campoNome.setText("");
        campoSenha.setText("");
        campoUser.setText("");
        labelAviso.setText("");
        Visao.App.trocaTela("cadastro");
    }

    @FXML
    void mkCpf(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();

        tff.setMask("###.###.###-##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(campoCpf);
        tff.formatter();
    }

}