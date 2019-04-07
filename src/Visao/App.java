package Visao;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;


public class App extends Application {
    private static Stage stage;

    private static Scene telaInicio;
    private static Scene telaCadastro;
    private static Scene telaRegistroClinica;
    private static Scene telaRegistroOng;
    private static Scene telaRegistroUsuario;
    private static Scene telaHomeUsuario;
    private static Scene telaHomeOng;
    private static Scene telaHomeClinica;
    private static Scene telaRegistroAnimal;
    private static Scene telaRegistroVet;
    private static Scene telaListaOng;
    private static Scene telaListaClinica;
    private static Scene telaListaVet;
    private static Scene telaListaAnimal;


    @Override
    public void start(Stage PrimaryStage) throws Exception{
        stage = PrimaryStage;

        PrimaryStage.setTitle("Projeto Final POO");

        //Cria a Tela inicial
        Parent fxmlInicio = FXMLLoader.load(getClass().getResource("TelaInicial.fxml"));
        telaInicio = new Scene(fxmlInicio, 600, 400);

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
        Parent fxmlTelaHomeClinica = FXMLLoader.load(getClass().getResource("TelaHomeClinica.fxml"));
        telaHomeClinica = new Scene(fxmlTelaHomeClinica, 600, 400);

        //Cria a tela de registro de animal
        Parent fxmlTelaRegistroAnimal = FXMLLoader.load(getClass().getResource("TelaRegistroAnimal.fxml"));
        telaRegistroAnimal = new Scene(fxmlTelaRegistroAnimal, 600, 400);

        //Cria a tela de registro de veterinarios
        Parent fxmlTelaRegistroVet = FXMLLoader.load(getClass().getResource("TelaRegistroVet.fxml"));
        telaRegistroVet = new Scene(fxmlTelaRegistroVet, 600, 400);

        //Cria a tela de lista de ONGs
        Parent fxmlTelaListaOng = FXMLLoader.load(getClass().getResource("TelaListaOngUser.fxml"));
        telaListaOng = new Scene(fxmlTelaListaOng, 600, 400);

        //Cria a tela de lista de Clinica
        Parent fxmlTelaListaClinica = FXMLLoader.load(getClass().getResource("TelaListaClinica.fxml"));
        telaListaClinica = new Scene(fxmlTelaListaClinica, 600, 400);

        //Cria a tela de lista de Veterinarios para as clinicas
        Parent fxmlTelaListaVet = FXMLLoader.load(getClass().getResource("TelaListaVet.fxml"));
        telaListaVet = new Scene(fxmlTelaListaVet, 600, 400);

        //Cria a tela de lista de Animais
        Parent fxmlTelaListaAnimal = FXMLLoader.load(getClass().getResource("TelaListaAnimais.fxml"));
        telaListaAnimal = new Scene(fxmlTelaListaAnimal, 600, 400);


        //Seta a tela que sera mostrada ao iniciar o aplicativo
        PrimaryStage.setScene(telaInicio);
        //Inicia a tela no aplicativo
        PrimaryStage.show();
    }

    public static void trocaTela (String idTela, String usuario, String tipo){
        //troca a tela que esta sendo mostrada de acordo com o valor da tela informado.
        switch (idTela){
            case "inicio":
                stage.setScene(telaInicio);
                notifyAllListeners("inicio", usuario, tipo);
                break;
            case "cadastro":
                stage.setScene(telaCadastro);
                notifyAllListeners("cadastro", usuario, tipo);
                break;
            case "registroClinica":
                stage.setScene(telaRegistroClinica);
                notifyAllListeners("registroClinica", usuario, tipo);
                break;
            case "registroOng":
                stage.setScene(telaRegistroOng);
                notifyAllListeners("registroOng", usuario, tipo);
                break;
            case "registroUsuario":
                stage.setScene(telaRegistroUsuario);
                notifyAllListeners("registroUsuario", usuario, tipo);
                break;
            case "homeUsuario":
                stage.setScene(telaHomeUsuario);
                notifyAllListeners("homeUsuario", usuario, tipo);
                break;
            case "homeOng":
                stage.setScene(telaHomeOng);
                notifyAllListeners("homeOng", usuario, tipo);
                break;
            case "homeClinica":
                stage.setScene(telaHomeClinica);
                notifyAllListeners("homeClinica", usuario, tipo);
                break;
            case "registroAnimal":
                stage.setScene(telaRegistroAnimal);
                notifyAllListeners("registroAnimal", usuario, tipo);
                break;
            case "registroVet":
                stage.setScene(telaRegistroVet);
                notifyAllListeners("registroVet", usuario, tipo);
                break;
            case "listaOng":
                stage.setScene(telaListaOng);
                notifyAllListeners("listaOng", usuario, tipo);
                break;
            case "listaClinica":
                stage.setScene(telaListaClinica);
                notifyAllListeners("listaClinica", usuario, tipo);
                break;
            case "listaVet":
                stage.setScene(telaListaVet);
                notifyAllListeners("listaVet", usuario, tipo);
                break;
            case "listaAnimal":
                stage.setScene(telaListaAnimal);
                notifyAllListeners("homeAnimar", usuario, tipo);
                break;
        }
    }
    public static void trocaTela (String idTela){
        trocaTela(idTela, "", "");
    }

    public static void main(String[] args) {launch(args); }

    //----------------------------------------------------------
    private static ArrayList<OnChangeScreen> listeners = new ArrayList<>();

    public static interface OnChangeScreen{
        void onScreenChanged(String novaTela, String usuario, String tipo);
    }

    public static void addOnChangeScreenListener(OnChangeScreen newListener){
        listeners.add(newListener);
    }

    public static void notifyAllListeners(String novaTela, String usuario, String tipo){
        for(OnChangeScreen l : listeners)
            l.onScreenChanged(novaTela, usuario, tipo);
    }
}


