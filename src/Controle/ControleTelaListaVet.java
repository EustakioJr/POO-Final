package Controle;

import Dao.VeterinariosDaoBanco;
import Modelo.Veterinarios;
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

public class ControleTelaListaVet implements Initializable {

    VeterinariosDaoBanco daoVeterinario = new VeterinariosDaoBanco();

    @FXML
    private TableView<Veterinarios> tableVeterinarios;

    @FXML
    private TableColumn<Veterinarios, String> colCrvm;

    @FXML
    private TableColumn<Veterinarios, String> colNome;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoCrvm;

    @FXML
    private TextField campoTelefone;

    @FXML
    private TextField campoEmail;

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
        Visao.App.trocaTela("homeClinica");
    }

    private List<Veterinarios> listVeterinario;

    private ObservableList<Veterinarios> observableListVeterinarios;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            carregarTableViewVeterinarios();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        tableVeterinarios.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selectItemClinicas(newValue));
    }

    public void carregarTableViewVeterinarios() throws SQLException, ClassNotFoundException, IOException {
        colCrvm.setCellValueFactory(new PropertyValueFactory<>("crvm"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        listVeterinario = new ArrayList<>(daoVeterinario.getVeterinarios());

        observableListVeterinarios = FXCollections.observableArrayList(listVeterinario);
        tableVeterinarios.setItems(observableListVeterinarios);
    }

    public void selectItemClinicas(Veterinarios veterinarios) {
        if (veterinarios != null) {
            campoCrvm.setText(veterinarios.getCrvm());
            campoNome.setText(veterinarios.getNome());
            campoTelefone.setText(veterinarios.getTelefone());
            campoEmail.setText(veterinarios.getEmail());
        }else{
            campoCrvm.setText("");
            campoNome.setText("");
            campoTelefone.setText("");
            campoEmail.setText("");
        }
    }


}