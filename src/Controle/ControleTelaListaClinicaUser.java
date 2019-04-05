package Controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

public class ControleTelaListaClinicaUser {


    @FXML
    private Label ClinicaNome;

    @FXML
    private Label ClinicaCNPJ;

    @FXML
    private Label ClinicaEndereco;

    @FXML
    private MenuItem menuHome;

    @FXML
    private MenuItem menuLogout;

    @FXML
    void irHome(ActionEvent event) {
        Visao.App.trocaTela("homeUsuario");
    }

    @FXML
    void logout(ActionEvent event) {
        Visao.App.trocaTela("inicio");
    }

}
