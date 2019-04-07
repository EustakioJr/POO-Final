package Controle;

import Dao.ClinicasDaoBanco;
import Dao.OngDaoBanco;
import Dao.UsuarioDaoBanco;
import Modelo.Clinicas;
import Modelo.Ong;
import Modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import Enum.TipoCadastro;

import java.sql.SQLException;

public class ControleTelaLogin {

    OngDaoBanco daoOng = new OngDaoBanco();
    ClinicasDaoBanco daoClinica = new ClinicasDaoBanco();
    UsuarioDaoBanco daoUsuario = new UsuarioDaoBanco();

    @FXML
    private Button botaoLogin;

    @FXML
    private ChoiceBox<TipoCadastro> campoTipo;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private TextField campoUser;

    @FXML
    private Label labelAviso;

    @FXML
    private Button botaoVoltar;

    @FXML
    void irInicio(ActionEvent event) {
        campoSenha.setText("");
        campoUser.setText("");
        campoTipo.setValue(null);
        Visao.App.trocaTela("inicio");
    }

    /**
     * Metodo que realiza a busca e autenticação do login e o realiza
     * @param event
     */
    @FXML
    void login(ActionEvent event) {
        if (campoUser.getText().isEmpty() || campoSenha.getText().isEmpty()) {
            labelAviso.setText("Preenchar todos os camopos");
        }

        switch (campoTipo.getValue()){
            case ONG:
                try{
                    Ong ong = daoOng.buscarPorUsername(campoUser.getText());
                    if (ong != null){
                        if (ong.getSenha().compareTo(campoSenha.getText()) == 0){
                            Visao.App.trocaTela("homeOng");
                        }else labelAviso.setText("Dados invalidos");
                    } else{
                        labelAviso.setText("Dados invalidos");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
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
                        if (clinica.getSenha().compareTo(campoSenha.getText()) == 0){
                            Visao.App.trocaTela("homeClinica");
                        }else labelAviso.setText("Dados invalidos");
                    } else{
                        labelAviso.setText("Dados invalidos");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
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
                        if (usuario.getSenha().compareTo(campoSenha.getText()) == 0){
                            Visao.App.trocaTela("homeUsuario");
                        }else labelAviso.setText("Dados invalidos");
                    } else{
                        labelAviso.setText("Dados invalidos");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                campoSenha.setText("");
                campoUser.setText("");
                campoTipo.setValue(null);

        }
    }

    public void initialize() {
        campoTipo.getItems().addAll(TipoCadastro.values());

    }


}


