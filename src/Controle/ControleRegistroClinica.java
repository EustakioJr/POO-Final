package Controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import util.TextFieldFormatter;

public class ControleRegistroClinica {

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoUser;

    @FXML
    private TextField campoEndereco;

    @FXML
    private TextField campoCNPJ;

    @FXML
    private TextField campoTelefone;

    @FXML
    private Button botaoRegistro;

    @FXML
    private Label labelAviso;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private Button botaoVoltar;

    @FXML
    void criarCadastroClinica(ActionEvent event) {

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

    @FXML
    void mkCNPJ(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();

        tff.setMask("##.###.###/####-##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(campoCNPJ);
        tff.formatter();
    }

    @FXML
    void mkTelefone(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("(##)#####-####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(campoTelefone);
        tff.formatter();
    }

}
