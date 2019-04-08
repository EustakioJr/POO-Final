package Controle;

import Excecoes.DataInvalida;
import Modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import Dao.UsuarioDaoBanco;

import java.sql.SQLException;

public class ControleAlteraUsuario {
    UsuarioDaoBanco daoUsuario = new UsuarioDaoBanco();

    @FXML
    private TextField campoUser;

    @FXML
    private Button botaoVerifica;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoCPF;

    @FXML
    private DatePicker campoNasc;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private Label labelAviso;

    @FXML
    private Button botaoAltera;

    @FXML
    void atualizar(ActionEvent event) {

    }

    @FXML
    void verifica(ActionEvent event) {
        if (campoUser.getText().isEmpty()) {
            labelAviso.setText("Preencha o campo para verificação");
        } else {
            try {
                Usuario usuario = daoUsuario.buscarPorUsername(campoUser.getText());
                if (usuario != null) {
                    campoNome.isEditable();
                    campoNome.setText(usuario.getNome());
                    campoCPF.isEditable();
                    campoCPF.setText(usuario.getCpf());
                    campoNasc.isEditable();
                    campoNasc.setValue(usuario.getNascimento());
                    campoSenha.isEditable();
                    campoSenha.setText(usuario.getSenha());
                }else{labelAviso.setText("Usuario não encontrado");}
            } catch (DataInvalida dataInvalida) {
                dataInvalida.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void irHomeUser(ActionEvent actionEvent) {
        Visao.App.trocaTela("homeUsuario");
    }
}
