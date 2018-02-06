/*
        DASH MY NAO FX - A JAVA APPLICATION

        Created by: Ronny Falconeri, Marcel Uthe, Niclas Meier
        DHBW Lörrach, Feb 2018

 */


package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Dash My Nao FX");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream( "images/icon.png" )));
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }

}