package Controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControleAlteraUsuario {

    @FXML
    private TextField campoUser;

    @FXML
    private Button botaoVerifica;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoCPF;

    @FXML
    private TextField campoNasc;

    @FXML
    private TextField campoSenha;

    @FXML
    private Label labelAviso;

    @FXML
    private Button botaoAltera;

    @FXML
    void atualizar(ActionEvent event) {

    }

    @FXML
    void verifica(ActionEvent event) {

    }

    public void irHomeUser(ActionEvent actionEvent) {Visao.App.trocaTela("homeUsuario");}
}
