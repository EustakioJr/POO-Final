package Controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControleRegistroOng {

    @FXML
    private Button botaoCadastro;

    @FXML
    private Label labelAviso;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoUser;

    @FXML
    private TextField campoCNPJ;

    @FXML
    private TextField campoEndereco;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private TextField campoTelefone;

    @FXML
    private Button botaoVoltar;

    public void registrar(ActionEvent actionEvent) {
        labelAviso.setText("Sucesso");
    }

    @FXML
    void irCadastro(ActionEvent event) {
        campoCNPJ.setText("");
        campoTelefone.setText("");
        campoEndereco.setText("");
        campoNome.setText("");
        campoSenha.setText("");
        campoUser.setText("");
        labelAviso.setText("");
        Visao.App.trocaTela("cadastro");
    }
}