package Controle;

import Dao.OngDaoBanco;
import Modelo.Ong;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import util.TextFieldFormatter;

import java.io.IOException;
import java.sql.SQLException;

/**
 * A classe <ControleRegistroOng> registra os ids dos elementos da interface grafica e metodos que a mesma realiza.
 * Serve tambem para auxiliar a criação de objetos to tipo Ong.
 * @author EustakioJr
 * @author Alex Fernandes
 */
public class ControleRegistroOng {

    private OngDaoBanco daoOng = new OngDaoBanco();
    /**
     * IDs da interface grafica.
     */
    @FXML
    private Button botaoCadastro;

    @FXML
    private Label labelAviso;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoUser;

    @FXML
    private TextField campoCNPJ;

    @FXML
    private TextField campoEndereco;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private TextField campoTelefone;

    @FXML
    private Button botaoVoltar;

    /**
     * Função que realiza a cração de objetos Ong.
     * @param actionEvent
     */
    public void registrar(ActionEvent actionEvent) {

        if (campoNome.getText().isEmpty() || campoUser.getText().isEmpty() || campoCNPJ.getText().isEmpty() || campoEndereco.getText().isEmpty() || campoSenha.getText().isEmpty() || campoTelefone.getText().isEmpty()){
            labelAviso.setText("Há campos vazios!");
        }else{
            try {
                if (daoOng.salvar(new Ong(campoNome.getText(),
                                campoUser.getText(),
                                campoCNPJ.getText(),
                                campoEndereco.getText(),
                                campoSenha.getText(),
                                campoTelefone.getText()))){

                    labelAviso.setText("ONG cadastrada!");
                }else labelAviso.setText("Cadastro impossível!");
            } catch (IOException e) {
            } catch (SQLException e) {
                labelAviso.setText("CNPJ ou UserName já existem!");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Função que limpa os campos após realizado o cadastro.
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
     * Função que seta a mascara para o campo de CNPJ.
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
     * função que seta a mascara para o campo telefone.
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