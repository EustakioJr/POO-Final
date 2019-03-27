package Visao;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {
    private static Stage stage;

    private static Scene telaInicio;
    private static Scene telaLogin;
    private static Scene telaCadastro;
    private static Scene telaRegistroClinica;
    private static Scene telaRegistroOng;
    private static Scene telaRegistroUsuario;


    @Override
    public void start(Stage PrimaryStage) throws Exception{
        stage = PrimaryStage;

        PrimaryStage.setTitle("Projeto Final POO");

        Parent fxmlInicio = FXMLLoader.load(getClass().getResource("TelaInicial.fxml"));
        telaInicio = new Scene(fxmlInicio, 600, 400);

        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
        telaLogin = new Scene(fxmlLogin, 600, 400);

        Parent fxmlCadastro = FXMLLoader.load(getClass().getResource("TelaCadastro.fxml"));
        telaCadastro = new Scene(fxmlCadastro, 600, 400);

        Parent fxmlRegistroClinica = FXMLLoader.load(getClass().getResource("TelaRegistroClinica.fxml"));
        telaRegistroClinica = new Scene(fxmlRegistroClinica, 600, 400);

        Parent fxmlRegistroOng = FXMLLoader.load(getClass().getResource("TelaRegistroOng.fxml"));
        telaRegistroOng = new Scene(fxmlRegistroOng, 600, 400);

        Parent fxmlRegistroUsuario = FXMLLoader.load(getClass().getResource("TelaRegistroUsuario.fxml"));
        telaRegistroUsuario = new Scene(fxmlRegistroUsuario, 600, 400);

        PrimaryStage.setScene(telaInicio);
        PrimaryStage.show();
    }

    public static void trocaTela (String idTela){
        switch (idTela){
            case "inicio":
                stage.setScene(telaInicio);
                break;
            case "login":
                stage.setScene(telaLogin);
                break;
            case "cadastro":
                stage.setScene(telaCadastro);
                break;
            case "registroClinica":
                stage.setScene(telaRegistroClinica);
                break;
            case "registroOng":
                stage.setScene(telaRegistroOng);
                break;
            case "registroUsuario":
                stage.setScene(telaRegistroUsuario);
        }
    }

    public static void main(String[] args) {launch(args); }
}


