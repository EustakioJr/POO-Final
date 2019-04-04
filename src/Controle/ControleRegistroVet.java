package Controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class ControleRegistroVet {

    @FXML
    private Label labelAviso;

    @FXML
    private TextField textNome;

    @FXML
    private TextField textCrvm;

    @FXML
    private TextField textTelefone;

    @FXML
    private TextField textEmail;

    @FXML
    private Menu menuHome;

    @FXML
    private MenuItem botaoHome;

    @FXML
    private MenuItem botaoLogout;

    @FXML
    void avisoConclusao(ActionEvent event) {
        labelAviso.setText("Veterinario registrado com sucesso");
    }

    @FXML
    void irHome(ActionEvent event) {
        Visao.App.trocaTela("homeClinica");
    }

    @FXML
    void irInicio(ActionEvent event) {
        Visao.App.trocaTela("inicio");
    }

}
