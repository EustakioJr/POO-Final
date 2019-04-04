package Controle;

import javafx.beans.property.BooleanProperty;
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
    private TextField Nome;

    @FXML
    private TextField Especie;

    @FXML
    private TextField Idade;

    @FXML
    private TextField Ong;

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
        Especie.setText("");
        Idade.setText("");
        Ong.setText("");
        Nome.setText("");
        checkCastrado.setSelected(false);
        Visao.App.trocaTela("homeOng");
    }

    @FXML
    void logout(ActionEvent event) {
        Especie.setText("");
        Idade.setText("");
        Ong.setText("");
        Nome.setText("");
        checkCastrado.setSelected(false);
        labelAviso.setText("");
        Visao.App.trocaTela("inicio");
    }

}