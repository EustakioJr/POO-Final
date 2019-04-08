package Controle;

import Dao.AnimaisDaoBanco;
import Excecoes.DataInvalida;
import Modelo.Animais;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.CheckBox;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControleTelaListaAnimaisUser implements Initializable {

    AnimaisDaoBanco daoAnimais = new AnimaisDaoBanco();

    @FXML
    private Button btVoltar;

    @FXML
    private Label labelId;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoEspecie;

    @FXML
    private DatePicker dataNasc;

    @FXML
    private CheckBox checkCastrado;

    @FXML
    private TableView<Animais> tableAnimais;

    @FXML
    private TableColumn<Animais, String> colId;

    @FXML
    private TableColumn<Animais, String> colNome;

    @FXML
    private TableColumn<Animais, String> colEspecie;

    @FXML
    public void irMenu(ActionEvent actionEvent) {

        Visao.App.trocaTela("homeUsuario");
    }

    private List<Animais> listAnimais;

    private ObservableList<Animais> observableListAnimais;

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


        tableAnimais.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                selectItemAnimais(newValue);
            } catch (DataInvalida dataInvalida) {
                dataInvalida.printStackTrace();
            }
        });
    }

    public void carregarTableViewAnimais() throws SQLException, ClassNotFoundException, IOException {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colEspecie.setCellValueFactory(new PropertyValueFactory<>("especie"));

        listAnimais = new ArrayList<>(daoAnimais.getAnimais());

        observableListAnimais = FXCollections.observableArrayList(listAnimais);
        tableAnimais.setItems(observableListAnimais);
    }

    public void selectItemAnimais(Animais animais) throws DataInvalida {
        if (animais != null) {
            labelId.setText(animais.getId());
            campoNome.setText(animais.getNome());
            campoEspecie.setText(animais.getEspecie());
            dataNasc.setValue(animais.getNascimento());
        } else {
            labelId.setText("");
            campoNome.setText("");
            campoEspecie.setText("");
            dataNasc.setValue(null);
        }
    }
}