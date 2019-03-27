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


    @Override
    public void start(Stage PrimaryStage) throws Exception{
        stage = PrimaryStage;

        PrimaryStage.setTitle("Projeto Final POO");

        Parent fxmlInicio = FXMLLoader.load(getClass().getResource("TelaInicial.fxml"));
        telaInicio = new Scene(fxmlInicio, 600, 400);

        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
        telaLogin = new Scene(fxmlLogin, 600, 400);

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
        }
    }

    public static void main(String[] args) {launch(args); }
}


