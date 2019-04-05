package Controle;

import Dao.ClinicasDaoBanco;
import Modelo.Clinicas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import util.TextFieldFormatter;

import java.io.IOException;
import java.sql.SQLException;

public class ControleRegistroClinica {


    private ClinicasDaoBanco daoOng = new ClinicasDaoBanco();

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoUser;

    @FXML
    private TextField campoEndereco;

    @FXML
    private TextField campoCNPJ;

    @FXML
    private TextField campoTelefone;

    @FXML
    private Button botaoRegistro;

    @FXML
    private Label labelAviso;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private Button botaoVoltar;

    @FXML
    void criarCadastroClinica(ActionEvent event) {

        if (campoNome.getText().isEmpty() || campoUser.getText().isEmpty() || campoEndereco.getText().isEmpty() || campoCNPJ.getText().isEmpty() || campoSenha.getText().isEmpty()){
            labelAviso.setText("Há campos vazios!");
        }else{
            try {
                if (daoOng.salvar(new Clinicas(campoNome.getText(),
                        campoUser.getText(),
                        campoEndereco.getText(),
                        campoCNPJ.getText(),
                        campoTelefone.getText(),
                        campoSenha.getText()
                        ))){
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("Cadastrado com Sucesso!");
                    alerta.setHeaderText("A sua ONG foi cadastrada!");
                    alerta.show();
                    limpar();
//                    labelAviso.setText("ONG registrado");
                }else labelAviso.setText("ERRO! ONG não registrado");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }


    public void limpar(){
        campoNome.setText("");
        campoUser.setText("");
        campoCNPJ.setText("");
        campoEndereco.setText("");
        campoSenha.setText("");
        campoTelefone.setText("");
    }

    @FXML
    void irCadastro(ActionEvent event) {
        campoCNPJ.setText("");
        campoTelefone.setText("");
        campoEndereco.setText("");
        campoNome.setText("");
        campoSenha.setText("");
        campoUser.setText("");
        labelAviso.setText("");
        Visao.App.trocaTela("cadastro");
    }

    @FXML
    void mkCNPJ(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();

        tff.setMask("##.###.###/####-##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(campoCNPJ);
        tff.formatter();
    }

    @FXML
    void mkTelefone(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("(##)#####-####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(campoTelefone);
        tff.formatter();
    }

}
