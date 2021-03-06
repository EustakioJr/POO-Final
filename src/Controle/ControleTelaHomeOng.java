package Controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

public class ControleTelaHomeOng {

    @FXML
    private MenuItem opcaoHome;

    @FXML
    private MenuItem opcaoLogout;

    @FXML
    private Button botaoListaClinica;

    @FXML
    private Button botaoListaAnimal;

    @FXML
    private Button botaoLogout;

    @FXML
    private Button botaoAlterar;

    @FXML
    private Button botaoAdicionaAnimal;

    @FXML
    void irAlterar(ActionEvent event) {
        Visao.App.trocaTela("alteraDados");
    }

    @FXML
    void irCadastroAnimal(ActionEvent event) {
        Visao.App.trocaTela("registroAnimal");
    }

    @FXML
    void irHome(ActionEvent event) {
        Visao.App.trocaTela("homeOng");
    }

    @FXML
    void irListaAnimal(ActionEvent event) {
        Visao.App.trocaTela("listaAnimalOng");
    }

    @FXML
    void irListaClinica(ActionEvent event) {
        Visao.App.trocaTela("listaClinicaOng");
    }

    @FXML
    void logout(ActionEvent event) {
        Visao.App.trocaTela("inicio");
    }

}
