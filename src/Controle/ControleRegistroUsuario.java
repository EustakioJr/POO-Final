package Controle;

import Dao.UsuarioDaoBanco;
import Modelo.Usuario;
import Visao.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import util.TextFieldFormatter;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * A classe <ControleRegistroUsuario> registra os ids dos elementos da interface grafica e metodos que a mesma realiza.
 * Serve tambem para auxiliar a criação de objetos to tipo Usuario.
 * @author EustakioJr
 * @author Alex Fernandes
 */
public class ControleRegistroUsuario implements Initializable {

   private UsuarioDaoBanco daoUsuario = new UsuarioDaoBanco();

    /**
     * IDs dos campos da interface grafica
     */
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

    /**
     * Função que realiza o cadastro de objetos do tipo Usuario.
     * @param event
     */
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


    /**
     * Função que retorna o usuario para a tela de seleção de tipo de cadastro.
     * @param event
     */
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

    /**
     * Função que seta a mascara do campo CPF.
     * @param event
     */
    @FXML
    void mkCpf(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();

        tff.setMask("###.###.###-##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(campoCpf);
        tff.formatter();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        App.addOnChangeScreenListener(new App.OnChangeScreen() {
            @Override
            public void onScreenChanged(String novaTela, String usuario, String tipo) {
                System.out.println("Nova tela:"+ novaTela +", " + usuario + ", "+ tipo);
            }
        });{

        }
    }
}