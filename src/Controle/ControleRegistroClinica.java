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

/**
 * A classe <ControleRegistroClinica> registra os ids dos elementos da interface grafica e metodos que a mesma realiza.
 * Serve tambem para auxiliar a criação de objetos to tipo Clinica.
 * @author EustakioJr
 * @author Alex Fernandes
 */
public class ControleRegistroClinica {


    private ClinicasDaoBanco daoOng = new ClinicasDaoBanco();
    /**
     * IDs dos campos da interface grafica
     */
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

    /**
     * Função que serve para criação do objeto clinica
     * @param event
     */
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
                    alerta.setTitle("Clinica cadastrada!");
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

    /**
     * Função usada para resetar os campos quando realizada o cadastro com sucesso.
     */
    public void limpar(){
        campoNome.setText("");
        campoUser.setText("");
        campoCNPJ.setText("");
        campoEndereco.setText("");
        campoSenha.setText("");
        campoTelefone.setText("");
    }

    /**
     * Função que retorna o usuario para a tela de seleção de tipo de cadastro.
     * @param event
     */
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

    /**
     * Função que seta a mascara do campo CNPJ
     * @param event
     */
    @FXML
    void mkCNPJ(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();

        tff.setMask("##.###.###/####-##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(campoCNPJ);
        tff.formatter();
    }
    /**
     * Função que seta a mascara do campo Telefone.
     * @param event
     */
    @FXML
    void mkTelefone(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("(##)#####-####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(campoTelefone);
        tff.formatter();
    }

}
