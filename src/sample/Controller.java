package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class Controller {

    // declaration of GUI objects here

        // Connection
        @FXML TextField ConnectionIP;
        @FXML TextField ConnectionPort;
        @FXML Button ConnectionButton;
        @FXML Circle ConnectionStatus;

        // Speech
        @FXML TextField SpeechText;
        @FXML Button SpeechButton;
        @FXML ComboBox SpeechLanguage;
        @FXML Slider SpeechPitch;

    // instanciate new objects here
    Connection connection = new Connection();
    Speech speech = new Speech(connection);


    // methods for GUI actions here

    // Connection
    public void changeIP_Adress(KeyEvent keyEvent) {
        connection.setIP_Adress(ConnectionIP.getText());
    }

    public void changePort(KeyEvent keyEvent) {
        connection.setPort(ConnectionPort.getText());
    }

    public void clickConnectionButton(ActionEvent actionEvent) {
        connection.buildNewConnection();

    }

    private void changeConnectionStatus(){
        // TODO: change color of the connection state dipentend on the actual state
    }



    // Speech
    public void changeSpeechText(KeyEvent keyEvent) {
        speech.setSpeechtext(SpeechText.getText());
    }

    public void clickSpeechButton(ActionEvent actionEvent) throws Exception {
        speech.sayText();
    }

    public void changeLanguage(ActionEvent actionEvent) {
        speech.setLanguage(SpeechLanguage.getSelectionModel().getSelectedItem().toString());
    }

    public void changePitch(MouseEvent mouseEvent) {
        speech.setPitch(SpeechPitch.getValue());
    }
}