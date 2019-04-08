package Controle;

import Dao.ClinicasDaoBanco;
import Modelo.Animais;
import Modelo.Clinicas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControleTelaListaClinicas implements Initializable {

    ClinicasDaoBanco daoClinicas = new ClinicasDaoBanco();

    @FXML
    private Button btVoltar;

    @FXML
    private TextField campoCnpj;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoEndereco;

    @FXML
    private TextField campoTelefone;

    @FXML
    private TableView<Clinicas> tableClinicas;

    @FXML
    private TableColumn<Animais, String> colCnpj;

    @FXML
    private TableColumn<Animais, String> colNome;

    @FXML
    public void irMenu(ActionEvent actionEvent) {

        Visao.App.trocaTela("homeOng");
    }

    private List<Clinicas> listClinicas;

    private ObservableList<Clinicas> observableListClinicas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            carregarTableViewAnimais();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        tableClinicas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selectItemAnimais(newValue));
    }

    public void carregarTableViewAnimais() throws SQLException, ClassNotFoundException, IOException {
        colCnpj.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("razao"));

        listClinicas = new ArrayList<>(daoClinicas.getClinicas());

        observableListClinicas = FXCollections.observableArrayList(listClinicas);
        tableClinicas.setItems(observableListClinicas);
    }

    public void selectItemAnimais(Clinicas clinicas) {
        if (clinicas != null) {
            campoCnpj.setText(clinicas.getCnpj());
            campoNome.setText(clinicas.getNome());
            campoEndereco.setText(clinicas.getEndereco());
            campoTelefone.setText(clinicas.getTelefone());
        }else{
            campoCnpj.setText("");
            campoNome.setText("");
            campoTelefone.setText("");
            campoEndereco.setText("");
        }
    }
}