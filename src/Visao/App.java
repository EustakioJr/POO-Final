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
    private static Scene telaListaOngUser;
    private static Scene telaListaOngClinica;
    private static Scene telaListaClinicaUser;
    private static Scene telaListaClinicaOng;
    private static Scene telaListaVet;
    private static Scene telaListaAnimalUser;
    private static Scene telaListaAnimalOng;


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

        //Cria a tela de lista de ONGs para usuarios
        Parent fxmlTelaListaOngUser = FXMLLoader.load(getClass().getResource("TelaListaOngUser.fxml"));
        telaListaOngUser = new Scene(fxmlTelaListaOngUser, 600, 400);

        //Cria a tela de lista de ONGs para clinicas
        Parent fxmlTelaListaOngClinica = FXMLLoader.load(getClass().getResource("TelaListaOngClinica.fxml"));
        telaListaOngClinica = new Scene(fxmlTelaListaOngClinica, 600, 400);

        //Cria a tela de lista de Clinicas para usuarios
        Parent fxmlTelaListaClinicaUser = FXMLLoader.load(getClass().getResource("TelaListaClinicaUser.fxml"));
        telaListaClinicaUser = new Scene(fxmlTelaListaClinicaUser, 600, 400);

        //Cria a tela de lista de Clinicas para ONGs
        Parent fxmlTelaListaClinicaOng = FXMLLoader.load(getClass().getResource("TelaListaClinicaOng.fxml"));
        telaListaClinicaOng = new Scene(fxmlTelaListaClinicaOng, 600, 400);

        //Cria a tela de lista de Veterinarios para as clinicas
        Parent fxmlTelaListaVet = FXMLLoader.load(getClass().getResource("TelaListaVet.fxml"));
        telaListaVet = new Scene(fxmlTelaListaVet, 600, 400);

        //Cria a tela de lista de Animais para usuarios
        Parent fxmlTelaListaAnimalUser = FXMLLoader.load(getClass().getResource("TelaListaAnimaisUser.fxml"));
        telaListaAnimalUser = new Scene(fxmlTelaListaAnimalUser, 600, 400);

        //Cria a tela de lista de animais para ongs
        Parent fxmlTelaListaAnimalOng = FXMLLoader.load(getClass().getResource("TelaListaAnimaisOng.fxml"));
        telaListaAnimalOng = new Scene(fxmlTelaListaAnimalOng, 600, 400);

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
            case "listaOngUser":
                stage.setScene(telaListaOngUser);
                notifyAllListeners("listaOngUser", usuario, tipo);
                break;
            case "listaOngClinica": //fadada a desaparecer
                stage.setScene(telaListaOngClinica);
                notifyAllListeners("listaOngClinica", usuario, tipo);
                break;
            case "listaClinicaUser":
                stage.setScene(telaListaClinicaUser);
                notifyAllListeners("listaClinicaUser", usuario, tipo);
                break;
            case "listaClinicaOng": //fadada a desaparecer
                stage.setScene(telaListaClinicaOng);
                notifyAllListeners("listaClinicaOng", usuario, tipo);
                break;
            case "listaVet":
                stage.setScene(telaListaVet);
                notifyAllListeners("listaVet", usuario, tipo);
                break;
            case "listaAnimalUser":
                stage.setScene(telaListaAnimalUser);
                notifyAllListeners("homeAnimalUser", usuario, tipo);
                break;
            case "listaAnimalOng":
                stage.setScene(telaListaAnimalOng);
                notifyAllListeners("listaAnimalOng", usuario, tipo);
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


