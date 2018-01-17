package sample;
import com.aldebaran.qi.CallError;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
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

        // Posture
        @FXML ComboBox PostureComboBox;
        @FXML Button PostureButton;
        @FXML Slider PostureSpeedSlider;

    // instanciate new objects here
    Connection connection = new Connection();

    public Controller() throws Exception {
    }
    //Speech speech = new Speech(connection);
    //Posture posture = new Posture();


    // methods for GUI actions here

        // Connection
        public void changeIP_Adress(KeyEvent keyEvent) {
            connection.setIP_Adress(ConnectionIP.getText());
        }

        public void changePort(KeyEvent keyEvent) {
            connection.setPort(ConnectionPort.getText());
        }

        public void clickConnectionButton(ActionEvent actionEvent) throws Exception {
            connection.buildNewConnection();

        }

        private void changeConnectionStatus(){
            // TODO: change color of the connection state dipentend on the actual state
        }



        // Speech
        public void changeSpeechText(KeyEvent keyEvent) {
            connection.getSpeech().setSpeechtext(SpeechText.getText());
        }

        public void clickSpeechButton(ActionEvent actionEvent) throws Exception {
            connection.getSpeech().sayText();
        }

        public void changeLanguage(ActionEvent actionEvent) {
            connection.getSpeech().setLanguage(SpeechLanguage.getSelectionModel().getSelectedItem().toString());
        }

        public void changePitch(MouseEvent mouseEvent) {
            connection.getSpeech().setPitch((float)SpeechPitch.getValue());
        }

        public void changeSpeechVolume(MouseEvent mouseEvent) {
            float vol = (float) PostureSpeedSlider.getValue();
            connection.getSpeech().setSpeechVolume(vol);
        }


        // Posture
        public void changePosture(ActionEvent actionEvent) {
            connection.getPosture().setPosture(PostureComboBox.getSelectionModel().getSelectedItem().toString());
        }

        public void clickPostureButton(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getPosture().posePosture();
        }

        public void changePostureSpeed(MouseEvent mouseEvent) {
            float speed = (float) PostureSpeedSlider.getValue();
            connection.getPosture().setSpeed(speed);
        }


}