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
    private TextField nomeUsuario;

    @FXML
    private TextField userUsuario;

    @FXML
    private TextField cpfUsuario;

    @FXML
    private DatePicker nascUsuario;

    @FXML
    private PasswordField senhaUsuario;

    @FXML
    private Button botaoVoltar;

    @FXML
    void registrar(ActionEvent event) {
        labelAviso.setText("Usuario registrado com Sucesso");
    }

    @FXML
    void irCadastro(ActionEvent event) {
        Visao.App.trocaTela("cadastro");
    }

}