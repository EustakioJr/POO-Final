package Controle;

import Dao.UsuarioDaoBanco;
import Modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import util.TextFieldFormatter;

import java.io.IOException;
import java.sql.SQLException;

public class ControleRegistroUsuario {

    UsuarioDaoBanco daoUsuario = new UsuarioDaoBanco();


    @FXML
    private Button botaoRegistro;

    @FXML
    private Label labelAviso;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoUser;

    @FXML
    private TextField campoCpf;

    @FXML
    private DatePicker campoNasc;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private Button botaoVoltar;

    @FXML
    void registrar(ActionEvent event) {

        if (campoNome.getText().isEmpty() || campoUser.getText().isEmpty() || campoCpf.getText().isEmpty() || campoNasc.getValue() == null || campoSenha.getText().isEmpty()){
            labelAviso.setText("Há campos vazios!");
        }else{
            try {
                if (daoUsuario.salvar(new Usuario(campoNome.getText(), campoUser.getText(), campoCpf.getText(), campoNasc.getValue(), campoSenha.getText()))){
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

    @FXML
    void irCadastro(ActionEvent event) {
        campoCpf.setText("");
        campoNasc.setValue(null);
        campoNome.setText("");
        campoSenha.setText("");
        campoUser.setText("");
        labelAviso.setText("");
        Visao.App.trocaTela("cadastro");
    }

    @FXML
    void mkCpf(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();

        tff.setMask("###.###.###-##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(campoCpf);
        tff.formatter();
    }

}