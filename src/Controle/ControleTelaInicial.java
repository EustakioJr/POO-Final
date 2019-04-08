package Controle;

import Dao.ClinicasDaoBanco;
import Dao.OngDaoBanco;
import Dao.UsuarioDaoBanco;
import Modelo.Clinicas;
import Modelo.Ong;
import Modelo.Usuario;
import Visao.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;
import Enum.TipoCadastro;

public class ControleTelaInicial {


    OngDaoBanco daoOng = new OngDaoBanco();
    ClinicasDaoBanco daoClinica = new ClinicasDaoBanco();
    UsuarioDaoBanco daoUsuario = new UsuarioDaoBanco();

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
