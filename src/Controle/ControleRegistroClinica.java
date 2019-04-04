package Controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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

}
