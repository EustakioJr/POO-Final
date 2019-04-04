package Controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

public class ControleTelaListaAnimaisOng {

    @FXML
    private MenuItem menuHome;

    @FXML
    private MenuItem menuLogout;

    @FXML
    private Button botaoAltera;

    @FXML
    private Button botaoDeleta;

    @FXML
    void alteraDados(ActionEvent event) {

    }

    @FXML
    void deletarVet(ActionEvent event) {

    }

    @FXML
    void irInicio(ActionEvent event) {
        Visao.App.trocaTela("inicio");
    }

    @FXML
    public void irHome(ActionEvent actionEvent) {
        Visao.App.trocaTela("homeOng");
    }
}