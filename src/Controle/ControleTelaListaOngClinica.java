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
<<<<<<< HEAD

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
=======

    @FXML
    private Label labelNome;

    @FXML
    private Label labelTelefone;

    @FXML
    private Label labelEndereco;
>>>>>>> 9b8c91db2d618fb743e102a2651acb52aa09b974

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

<<<<<<< HEAD
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


=======
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

>>>>>>> 9b8c91db2d618fb743e102a2651acb52aa09b974
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
