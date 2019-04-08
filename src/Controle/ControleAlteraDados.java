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

        String sAtual= campoSenha.getText();
        UsuarioAtual ua = daoUA.buscarPorPadrao("padrao");
        String tUser = ua.getTipo();
        System.out.println(tUser);
        switch (tUser){
            case "USUARIO":
                Usuario u = daoUsuario.buscarPorUsername(ua.getUseratual());
                String sUser = u.getSenha();
                if (sUser.equals(sAtual)){

                    String novaS = novaSenha.getText();
                    if (daoUsuario.atualizar(new Usuario(u.getNome(), u.getUsername(), u.getCpf(), u.getNascimento(), novaS))){
                        labelAviso.setText("Senha Alterada!");
                    }
                } else {
                    labelAviso.setText("Senha atual invalida");
                }
                break;
            case "ONG":
                Ong o = daoOng.buscarPorUsername(ua.getUseratual());
                if (o.getSenha() == sAtual){
                    String novaS = novaSenha.getText();
                    if (daoOng.atualizar(new Ong(o.getNomeOng(), o.getUsername(), o.getCnpj(), o.getEndereco(), novaS, o.getTelefone()))){
                        labelAviso.setText("Senha Alterada!");
                    }
                } else {
                    labelAviso.setText("Senha atual invalida");
                }
                break;
            case "CLINICA":
                Clinicas c = daoClinica.buscarPorUsername(ua.getUseratual());
                if (c.getSenha() == sAtual){
                    String novaS = novaSenha.getText();
                    if (daoClinica.atualizar(new Clinicas(c.getNome(), c.getUsername(), c.getEndereco(), c.getCnpj(), c.getTelefone(), novaS))){
                        labelAviso.setText("Senha Alterada!");
                    }
                } else {
                    labelAviso.setText("Senha atual invalida");
                }
                break;
            default:
                System.out.println("Não foi reconhecido!");
        }
    }

    @FXML
    void excluir(ActionEvent event) {

    }

    @FXML
    void irHome(ActionEvent event) {

    }

}
