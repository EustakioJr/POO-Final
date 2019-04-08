package Controle;

import Dao.ClinicasDaoBanco;
import Dao.OngDaoBanco;
import Dao.UsuarioAtualDaoBanco;
import Dao.UsuarioDaoBanco;
import Modelo.Clinicas;
import Modelo.Ong;
import Modelo.Usuario;
import Modelo.UsuarioAtual;
import Visao.App;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Enum.TipoCadastro;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControleTelaInicial implements Initializable {


    OngDaoBanco daoOng = new OngDaoBanco();
    ClinicasDaoBanco daoClinica = new ClinicasDaoBanco();
    UsuarioDaoBanco daoUsuario = new UsuarioDaoBanco();
    UsuarioAtualDaoBanco daoUserAtual = new UsuarioAtualDaoBanco();

    @FXML
    private ChoiceBox<TipoCadastro> campoTipo;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private TextField campoUser;

    @FXML
    private Label labelAviso;

    @FXML
    private Button botaoLogin;

    @FXML
    private Button botaoCadastro;

    @FXML
    void irTelaCadastro(ActionEvent event) {
        Visao.App.trocaTela("cadastro");
    }

    @FXML
    void login(ActionEvent event) {
        if (campoUser.getText().isEmpty() || campoSenha.getText().isEmpty() ||campoTipo.getValue() == null) {
            labelAviso.setText("Preenchar todos os campos");
        } else{
            switch (campoTipo.getValue()){
                case ONG:
                    try{
                        Ong ong = daoOng.buscarPorUsername(campoUser.getText());
                        if (ong != null){
                            if (ong.getSenha().compareTo(campoSenha.getText()) == 0 && daoUserAtual.atualizar(new UsuarioAtual(campoUser.getText(), campoTipo.getValue().toString()))){

                                Visao.App.trocaTela("homeOng");
                            }else labelAviso.setText("Dados invalidos");
                        } else{
                            labelAviso.setText("Dados invalidos");
                        }
                    } catch (SQLException | IOException e) {
                        labelAviso.setText("Username ou senha incorreto");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    campoSenha.setText("");
                    campoUser.setText("");
                    campoTipo.setValue(null);
                    break;
                case CLINICA:
                    try{
                        Clinicas clinica = daoClinica.buscarPorUsername(campoUser.getText());
                        if (clinica != null){
                            if (clinica.getSenha().compareTo(campoSenha.getText()) == 0 && daoUserAtual.atualizar(new UsuarioAtual(campoUser.getText(), campoTipo.getValue().toString()))){
                                Visao.App.trocaTela("homeClinica");
                            }else labelAviso.setText("Dados invalidos");
                        } else{
                            labelAviso.setText("Dados invalidos");
                        }
                    } catch (SQLException e) {
                        labelAviso.setText("Username ou senha incorreto");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    campoSenha.setText("");
                    campoUser.setText("");
                    campoTipo.setValue(null);
                    break;
                case USUARIO:
                    try{
                        Usuario usuario = daoUsuario.buscarPorUsername(campoUser.getText());
                        if (usuario != null){
                            if (usuario.getSenha().compareTo(campoSenha.getText()) == 0 && daoUserAtual.atualizar(new UsuarioAtual(campoUser.getText(), campoTipo.getValue().toString()))){
                                Visao.App.trocaTela("homeUsuario");
                            }else labelAviso.setText("Dados invalidos");
                        } else{
                            labelAviso.setText("Dados invalidos");
                        }
                    } catch (SQLException e) {
                        labelAviso.setText("Username ou senha incorreto");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    campoSenha.setText("");
                    campoUser.setText("");
                    campoTipo.setValue(null);
            }

        }


    }

    private List<UsuarioAtual> listUA;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            campoTipo.getItems().addAll(TipoCadastro.values());
    }



}
