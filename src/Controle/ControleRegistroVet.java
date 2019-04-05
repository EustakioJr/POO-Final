package Controle;

import Dao.VeterinariosDaoBanco;
import Modelo.Veterinarios;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import util.TextFieldFormatter;

import java.io.IOException;
import java.sql.SQLException;

public class ControleRegistroVet {

    VeterinariosDaoBanco daoVeterinario = new VeterinariosDaoBanco();

    @FXML
    private Label labelAviso;

    @FXML
    private TextField textNome;

    @FXML
    private TextField textCrvm;

    @FXML
    private TextField textTelefone;

    @FXML
    private TextField textEmail;

    @FXML
    private Menu menuHome;

    @FXML
    private MenuItem botaoHome;

    @FXML
    private MenuItem botaoLogout;

    @FXML
    void avisoConclusao(ActionEvent event) {

        if (textNome.getText().isEmpty() || textTelefone.getText().isEmpty() || textCrvm.getText().isEmpty() || textEmail.getText().isEmpty()){
            labelAviso.setText("Há campos vazios!");
        }else{
            try {
                if (daoVeterinario.salvar(new Veterinarios(textNome.getText(), textTelefone.getText(), textCrvm.getText(), textEmail.getText()))){
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


        labelAviso.setText("Veterinario registrado com sucesso");
    }

    @FXML
    void irHome(ActionEvent event) {
        textCrvm.setText("");
        textEmail.setText("");
        textNome.setText("");
        textTelefone.setText("");
        labelAviso.setText("");
        Visao.App.trocaTela("homeClinica");
    }

    @FXML
    void irInicio(ActionEvent event) {
        textCrvm.setText("");
        textEmail.setText("");
        textNome.setText("");
        textTelefone.setText("");
        labelAviso.setText("");
        Visao.App.trocaTela("inicio");
    }

}
