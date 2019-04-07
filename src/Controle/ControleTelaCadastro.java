package Controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


/**
 * A classe <ControleRegistroCadastro> registra os ids dos elementos da interface grafica e metodos que a mesma realiza.
 * @author EustakioJr
 * @author Alex Fernandes
 */
public class ControleTelaCadastro {
    /**
     * IDs da interface grafica.
     */
    @FXML
    private Button botaoUsuario;

    @FXML
    private Button botaoOng;

    @FXML
    private Button botaoClinica;

    @FXML
    private Button botaoVoltar;

    /**
     * Encaminha o usuario para a tela de cadastro de Clinicas.
     * @param event
     */
    @FXML
    void irCadastroClinica(ActionEvent event) {
        Visao.App.trocaTela("registroClinica");
    }

    /**
     * Encaminha o usuario para a tela de cadastro de ONGs.
     * @param event
     */
    @FXML
    void irCadastroOng(ActionEvent event) {
        Visao.App.trocaTela("registroOng");
    }

    /**
     * Encaminha o usuario para a tela de cadastro de Usuario.
     * @param event
     */
    @FXML
    void irCadastroUsuario(ActionEvent event) {
        Visao.App.trocaTela("registroUsuario");
    }

    /**
     * Retorna o usuario para a tela inicial do programa.
     * @param event
     */
    @FXML
    void irInicio(ActionEvent event) {
        Visao.App.trocaTela("inicio");
    }

}