package Controle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControleRegistroAnimal {

    @FXML
    private Button botaoRegistro;

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

    public void avisoConclusao(ActionEvent actionEvent) {
        labelAviso.setText("Sucesso");
    }
}
