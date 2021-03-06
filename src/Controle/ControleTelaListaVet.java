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
    private Label labelAviso;

    @FXML
    void alteraDados(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {

        Veterinarios vet = tableVeterinarios.getSelectionModel().getSelectedItem();
        if (vet != null){
            Veterinarios v = daoVeterinario.buscarPorCRVM(campoCrvm.getText());
            daoVeterinario.atualizar(new Veterinarios(v.getNome(), campoCrvm.getText(), campoTelefone.getText(), campoEmail.getText()));
            carregarTableViewVeterinarios();
        } else{
            labelAviso.setText("Por favor, selecione uma veterinario da tabela");
        }
    }

    @FXML
    void deletarVet(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        Veterinarios vet = daoVeterinario.buscarPorCRVM(campoCrvm.getText());

        daoVeterinario.deletar(vet);
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


    public void atualizar(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {
        carregarTableViewVeterinarios();
    }
}