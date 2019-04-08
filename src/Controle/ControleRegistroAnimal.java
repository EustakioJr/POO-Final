package Controle;

import Dao.AnimaisDaoBanco;
import Modelo.Animais;
import javafx.beans.property.BooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;

/**
 * A classe <ControleRegistroAnimal> registra os ids dos elementos da interface grafica e metodos que a mesma realiza.
 * Serve tambem para auxiliar a criação de objetos to tipo Animal.
 * @author EustakioJr
 * @author Alex Fernandes
 */
public class ControleRegistroAnimal {

    private AnimaisDaoBanco daoAnimais = new AnimaisDaoBanco();
    /**
     * IDs da interface grafica
     */
    @FXML
    private Label labelAviso;

    @FXML
    private TextField Id;

    @FXML
    private TextField Nome;

    @FXML
    private TextField Especie;

    @FXML
    private DatePicker Idade;

    @FXML
    private TextField Ong;

    @FXML
    private CheckBox checkCastrado;

    @FXML
    private Menu menuHome;

    @FXML
    private MenuItem botaoHome;

    @FXML
    private MenuItem botaoPerfil;

    @FXML
    private MenuItem botaoLogout;



    /**
     * Função que serve para criação do objeto animal.
     * @param actionEvent
     */
    @FXML
    public void cadastrar(ActionEvent actionEvent) {

        if (Id.getText().isEmpty() || Nome.getText().isEmpty() || Especie.getText().isEmpty() || Idade.getValue()== null || Ong.getText().isEmpty()){
            labelAviso.setText("Há campos vazios!");
        }else{
            try {
                if (daoAnimais.salvar(new Animais(Id.getText(), Nome.getText(), Especie.getText(), Ong.getText(), Idade.getValue(), verifChecked()))){
                    labelAviso.setText("Animal registrado");
                }else labelAviso.setText("ERRO! Animal não registrado");
            } catch (SQLException e) {
                e.printStackTrace();
                labelAviso.setText("Dados Invalidos!");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * Esta função verifica se o campo que informa se o animal é castrado esta marcado ou não.
     * @return
     */
    public boolean verifChecked(){

        if (checkCastrado.selectedProperty().getValue()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Função responsavel por retornar o usuario Ong para sua tela de home.
     * @param event
     */
    @FXML
    void irHome(ActionEvent event) {
        Especie.setText("");
        Idade.setValue(null);
        Ong.setText("");
        Nome.setText("");
        checkCastrado.setSelected(false);
        Visao.App.trocaTela("homeOng");
    }

    /**
     * Função responsavel por fazer o logout do usuario e retorna-lo para a pagina de login.
     * @param event
     */
    @FXML
    void logout(ActionEvent event) {
        Especie.setText("");
        Idade.setValue(null);
        Ong.setText("");
        Nome.setText("");
        checkCastrado.setSelected(false);
        labelAviso.setText("");
        Visao.App.trocaTela("inicio");
    }

}