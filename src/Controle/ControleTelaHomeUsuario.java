package Controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

public class ControleTelaHomeUsuario {

    @FXML
    private MenuItem opcaoHome;

    @FXML
    private MenuItem opcaoLogout;

    @FXML
    private Button botaoListaOng;

    @FXML
    private Button botaoLogout;

    @FXML
    private Button botaoAlterar;

    @FXML
    private Button botaoListaClinica;

    @FXML
    private Button botaoListaAnimais;

    @FXML
    void irListaAnimais(ActionEvent event) { Visao.App.trocaTela("listaAnimalUser"); }

    @FXML
    void irListaClinica(ActionEvent event) {
        Visao.App.trocaTela("listaClinicaUser");
    }

    @FXML
    void irListaOng(ActionEvent event) {
        Visao.App.trocaTela("listaOngUser");
    }

    @FXML
    void alteraDados(ActionEvent event) {Visao.App.trocaTela("alteraUser");
    }

    @FXML
    void irHome(ActionEvent event) {
        Visao.App.trocaTela("homeUsuario");
    }

    @FXML
    void logout(ActionEvent event) {
        Visao.App.trocaTela("inicio");
    }


}
