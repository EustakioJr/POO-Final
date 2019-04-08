package Controle;

import Dao.ClinicasDaoBanco;
import Dao.OngDaoBanco;
import Dao.UsuarioAtualDaoBanco;
import Dao.UsuarioDaoBanco;
import Excecoes.DataInvalida;
import Modelo.Clinicas;
import Modelo.Ong;
import Modelo.Usuario;
import Modelo.UsuarioAtual;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

import java.io.IOException;
import java.sql.SQLException;

public class ControleAlteraDados {

    UsuarioAtualDaoBanco daoUA = new UsuarioAtualDaoBanco();
    UsuarioDaoBanco daoUsuario = new UsuarioDaoBanco();
    OngDaoBanco daoOng = new OngDaoBanco();
    ClinicasDaoBanco daoClinica = new ClinicasDaoBanco();

    @FXML
    private Button botaoVoltar;

    @FXML
    private Label labelAviso;

    @FXML
    private Button botaoAltera;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private Button botaoExcluir;

    @FXML
    private PasswordField novaSenha;

    @FXML
    private PasswordField confirmaSenha;

    @FXML
    void atualizar(ActionEvent event) throws SQLException, ClassNotFoundException, DataInvalida, IOException {

        if (novaSenha.getText().equals(confirmaSenha.getText())){
            String sAtual= campoSenha.getText();
            UsuarioAtual ua = daoUA.buscarPorPadrao("padrao");
            String tUser = ua.getTipo();
            System.out.println(tUser);
            switch (tUser){
                case "USUARIO":
                    Usuario u = daoUsuario.buscarPorUsername(ua.getUseratual());
                    String sUserU = u.getSenha();
                    if (sUserU.equals(sAtual)){

                        String novaS = novaSenha.getText();
                        if (daoUsuario.atualizar(new Usuario(u.getNome(), u.getUsername(), u.getCpf(), u.getNascimento(), novaS))){
                            labelAviso.setText("Senha Alterada!");
                            Visao.App.trocaTela("homeUsuario");
                        }
                    } else {
                        labelAviso.setText("Senha atual invalida");
                    }
                    break;
                case "ONG":
                    Ong o = daoOng.buscarPorUsername(ua.getUseratual());
                    String sUserO = o.getSenha();
                    if (sUserO.equals(sAtual)){
                        String novaS = novaSenha.getText();
                        if (daoOng.atualizar(new Ong(o.getNomeOng(), o.getUsername(), o.getCnpj(), o.getEndereco(), novaS, o.getTelefone()))){
                            labelAviso.setText("Senha Alterada!");
                            Visao.App.trocaTela("homeOng");
                        }
                    } else {
                        labelAviso.setText("Senha atual invalida");
                    }
                    break;
                case "CLINICA":
                    Clinicas c = daoClinica.buscarPorUsername(ua.getUseratual());
                    String sUserC = c.getSenha();
                    if (sUserC.equals(sAtual)){
                        String novaS = novaSenha.getText();
                        if (daoClinica.atualizar(new Clinicas(c.getNome(), c.getUsername(), c.getEndereco(), c.getCnpj(), c.getTelefone(), novaS))){
                            labelAviso.setText("Senha Alterada!");
                            Visao.App.trocaTela("homeClinica");
                        }
                    } else {
                        labelAviso.setText("Senha atual invalida");
                    }
                    break;
                default:
                    System.out.println("Não foi reconhecido!");
            }
        }else{
            labelAviso.setText("Senha nova incorreta");
        }

    }

    @FXML
    void excluir(ActionEvent event) {

    }

    @FXML
    void irHome(ActionEvent event) throws SQLException, ClassNotFoundException {
        UsuarioAtual ua = daoUA.buscarPorPadrao("padrao");
        String tUser = ua.getTipo();
        switch (tUser){
            case "USUARIO":
                Visao.App.trocaTela("homeUsuario");
                break;
            case "ONG":
                Visao.App.trocaTela("homeOng");
                break;
            case "CLINICA":
                Visao.App.trocaTela("homeClinica");
        }
    }

}
