package Controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class ControleRegistroAnimal {

    @FXML
    private Label labelAviso;

    @FXML
    private TextField textNome;

    @FXML
    private TextField textEspecie;

    @FXML
    private TextField textIdade;

    @FXML
    private TextField textOng;

    @FXML
    private CheckBox checkCastrado;

    @FXML
    private Menu menuHome;

    @FXML
    private MenuItem botaoHome;

    @FXML
    private MenuItem botaoPerfil;

    @FXML
    private MenuItem botaoLogout;

    @FXML
    public void avisoConclusao(ActionEvent actionEvent) {
        labelAviso.setText("Animal registrado");
    }

    @FXML
    void irHome(ActionEvent event) {

    }

    @FXML
    void irPerfil(ActionEvent event) {

    }

    @FXML
    void irTelaInicial(ActionEvent event) {

    }

}