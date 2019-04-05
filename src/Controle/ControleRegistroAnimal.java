package Controle;

import Dao.AnimaisDaoBanco;
import Modelo.Animais;
import javafx.beans.property.BooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class ControleRegistroAnimal {

    AnimaisDaoBanco daoAnimais = new AnimaisDaoBanco();

    @FXML
    private Label labelAviso;

    @FXML
    private TextField Id;

    @FXML
    private TextField Nome;

    @FXML
    private TextField Especie;

    @FXML
    private TextField Idade;

    @FXML
    private TextField Ong;

    @FXML
    private CheckBox checkCastrado;

    @FXML
    private Menu menuHome;

    @FXML
    private MenuItem botaoHome;

    @FXML
    private MenuItem botaoPerfil;

    @FXML
    private MenuItem botaoLogout;

    @FXML
    public void avisoConclusao(ActionEvent actionEvent) {

        if (Id.getText().isEmpty() || Nome.getText().isEmpty() || Especie.getText().isEmpty() || Idade.getText().isEmpty() || Ong.getText().isEmpty()){
            labelAviso.setText("Há campos vazios!");
        }else{
            try {
                if (daoAnimais.salvar(new Animais(Id.getText(), Nome.getText(), Especie.getText(), Idade.getText(), Ong.getText(), verifChecked()))){
                    labelAviso.setText("Animal registrado");
                }else labelAviso.setText("ERRO! Animal não registrado");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public boolean verifChecked(){

        if (checkCastrado.selectedProperty().getValue()) {
            return true;
        } else {
            return false;
        }
    }

    @FXML
    void irHome(ActionEvent event) {
        Especie.setText("");
        Idade.setText("");
        Ong.setText("");
        Nome.setText("");
        checkCastrado.setSelected(false);
        Visao.App.trocaTela("homeOng");
    }

    @FXML
    void logout(ActionEvent event) {
        Especie.setText("");
        Idade.setText("");
        Ong.setText("");
        Nome.setText("");
        checkCastrado.setSelected(false);
        labelAviso.setText("");
        Visao.App.trocaTela("inicio");
    }

}