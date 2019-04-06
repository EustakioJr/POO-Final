package Controle;

import Modelo.Clinicas;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableView<Clinicas> listaClinicas;

    @FXML
    private TableColumn<Clinicas, String> colNome;

    @FXML
    private TableColumn<Clinicas, String> colCnpj;

    @FXML
    private TableColumn<Clinicas, String> colEndereco;

    @FXML
    void initialize(){

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
