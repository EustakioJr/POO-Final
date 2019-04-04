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
    private static Scene telaHomeUsuario;
    private static Scene telaHomeOng;
    private static Scene telaHomeClinica;
    private static Scene telaRegistroAnimal;


    @Override
    public void start(Stage PrimaryStage) throws Exception{
        stage = PrimaryStage;

        PrimaryStage.setTitle("Projeto Final POO");

        //Cria a Tela inicial
        Parent fxmlInicio = FXMLLoader.load(getClass().getResource("TelaInicial.fxml"));
        telaInicio = new Scene(fxmlInicio, 600, 400);

        //Cria a tela de login
        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
        telaLogin = new Scene(fxmlLogin, 600, 400);

        //Cria a tela do menu de cadastro
        Parent fxmlCadastro = FXMLLoader.load(getClass().getResource("TelaCadastro.fxml"));
        telaCadastro = new Scene(fxmlCadastro, 600, 400);

        //Cria a tela de cadastro de clinicas
        Parent fxmlRegistroClinica = FXMLLoader.load(getClass().getResource("TelaRegistroClinica.fxml"));
        telaRegistroClinica = new Scene(fxmlRegistroClinica, 600, 400);

        //Cria a tela de cadastro de ONGs
        Parent fxmlRegistroOng = FXMLLoader.load(getClass().getResource("TelaRegistroOng.fxml"));
        telaRegistroOng = new Scene(fxmlRegistroOng, 600, 400);

        //Cria a tela de cadastro de usuario
        Parent fxmlRegistroUsuario = FXMLLoader.load(getClass().getResource("TelaRegistroUsuario.fxml"));
        telaRegistroUsuario = new Scene(fxmlRegistroUsuario, 600, 400);

        //Cria a tela home mostrada após o login de usuario normal
        Parent fxmlTelaHomeUsuario = FXMLLoader.load(getClass().getResource("TelaHomeUsuario.fxml"));
        telaHomeUsuario = new Scene(fxmlTelaHomeUsuario, 600, 400);

        //Cria a tela home mostrada após o login de usuario Ong
        Parent fxmlTelaHomeOng = FXMLLoader.load(getClass().getResource("TelaHomeOng.fxml"));
        telaHomeOng = new Scene(fxmlTelaHomeOng, 600, 400);

        //Cria a tela home mostrada após o login de usuario Clinica
//        Parent fxmlTelaHomeClinica = FXMLLoader.load(getClass().getResource("TelaHomeClinica.fxml"));
//        telaHomeClinica = new Scene(fxmlTelaHomeClinica, 600, 400);

        //Cria a tela de registro de animal
        Parent fxmlTelaRegistroAnimal = FXMLLoader.load(getClass().getResource("TelaRegistroAnimal.fxml"));
        telaRegistroAnimal = new Scene(fxmlTelaRegistroAnimal, 600, 400);

        //Seta a tela que sera mostrada ao iniciar o aplicativo
        PrimaryStage.setScene(telaInicio);
        //Inicia a tela no aplicativo
        PrimaryStage.show();
    }

    public static void trocaTela (String idTela){
        //troca a tela que esta sendo mostrada de acordo com o valor da tela informado.
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
                break;
            case "homeUsuario":
                stage.setScene(telaHomeUsuario);
                break;
            case "homeOng":
                stage.setScene(telaHomeOng);
                break;
//            case "homeClinica":
//                stage.setScene(telaHomeClinica);
//                break;
            case "registroAnimal":
                stage.setScene(telaRegistroAnimal);
        }
    }

    public static void main(String[] args) {launch(args); }
}


