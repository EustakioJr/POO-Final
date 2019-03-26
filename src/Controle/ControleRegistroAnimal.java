package Controle;


import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;

public class ControleRegistroAnimal {

    @FXML
    private Label labelAviso;

    @FXML
    private TextField textNome;

    @FXML
    private TextField textEspecie;

    @FXML
    private TextField textIdade;

    @FXML
    private TextField textOng;

    @FXML
    private CheckBox checkCastrado;

    @FXML
    private Menu menuHome;

    @FXML
    private Menu menuPerfil;

    @FXML
    private Menu logout;



    public void avisoConclusao(ActionEvent actionEvent) {
        labelAviso.setText("Animal registrado");
    }

    public void nomePerfil(Event event) {
        menuPerfil.setText("APAS");
    }
}
