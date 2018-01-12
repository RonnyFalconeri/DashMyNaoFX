package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {
    private int width = 700;
    private int height = 300;

    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        loadFXML("sample.fxml");
        primaryStage.show();
    }

    private void loadFXML(String Path) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(Path));
        stage.setTitle("Dash My Nao FX");

        if (stage.getScene() == null) {
            stage.setScene(new Scene(root, this.width, this.height));
        } else {
            stage.getScene().setRoot(root);
        }
    }
}