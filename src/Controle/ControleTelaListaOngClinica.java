package Controle;

import Dao.OngDaoBanco;
import Modelo.Ong;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControleTelaListaOngClinica implements Initializable {

    OngDaoBanco daoOng  = new OngDaoBanco();

    @FXML
    private Label labelCnpj;

    @FXML
    private Label labelNome;

    @FXML
    private Label labelTelefone;

    @FXML
    private Label labelEndereco;

    @FXML
    private TableView<Ong> tableOng;

    @FXML
    private TableColumn<Ong, String> colCnpj;

    @FXML
    private TableColumn<Ong, String> colNome;
    @FXML
    void irHome(ActionEvent event) {
        Visao.App.trocaTela("homeClinica");
    }

    @FXML
    void logout(ActionEvent event) {
        Visao.App.trocaTela("inicio");
    }

    private List<Ong> listOngs;

    private ObservableList<Ong> observableListOngs;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            carregarTableViewOng();

        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        tableOng.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selectItemOngs(newValue));
    }

    public void carregarTableViewOng() throws SQLException, ClassNotFoundException, IOException {
        colCnpj.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("razao"));

        listOngs = new ArrayList<>(daoOng.getOngs());

        observableListOngs = FXCollections.observableArrayList(listOngs);
        tableOng.setItems(observableListOngs);
    }

    public void selectItemOngs(Ong ong) {
        if (ong != null) {
            labelCnpj.setText(ong.getCnpj());
            labelNome.setText(ong.getNomeOng());
            labelTelefone.setText(ong.getTelefone());
            labelEndereco.setText(ong.getEndereco());
        }else{
            labelCnpj.setText("");
            labelCnpj.setText("");
            labelTelefone.setText("");
            labelEndereco.setText("");
        }
    }

}
