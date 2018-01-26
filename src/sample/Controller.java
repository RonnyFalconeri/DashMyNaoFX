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

    Connection connection = new Connection();

    // declaration of GUI objects here

        // Connection
        @FXML Button ConnectionButton;
        @FXML TextField ConnectionIP;
        @FXML TextField ConnectionPort;
        @FXML Circle ConnectionStatus;

        // Speech
        @FXML Button SpeechButton;
        @FXML TextField SpeechText;
        @FXML ComboBox SpeechLanguage;
        @FXML Slider SpeechPitch;
        @FXML Slider SpeechVolumeSlider;

        // Posture
        @FXML Button PostureButton;
        @FXML ComboBox PostureComboBox;
        @FXML Slider PostureSpeedSlider;

        // AudioPlayer
        @FXML Button AudioPlayerButton;
        @FXML ComboBox AudioPlayerComboBox;
        @FXML Slider AudioPlayerSlider;

        // Movement
        @FXML Button MovementButtonW;
        @FXML Button MovementButtonA;
        @FXML Button MovementButtonS;
        @FXML Button MovementButtonD;
        @FXML Button MovementButtonStop;
        @FXML Slider MovementSliderVel;

        // Appereance
        @FXML Button AppereanceButtonSet;
        @FXML Button AppereanceButtonReset;
        @FXML ComboBox AppereanceComboBoxColor;
        @FXML ComboBox AppereanceComboBoxGroup;

        // BodyState
        @FXML Button BodyStateButton;
        @FXML Label BodyStateBatteryPerc;
        @FXML Label BodyStateLabelTemp;


    // methods for GUI actions here

        // GUI modification
        private void changeButtonText(Button ButtonName, String Text){ ButtonName.setText(Text);}public Controller() throws Exception {}

        private void changeLabelText(Label Labelname, String Text){
            Labelname.setText(Text);
        }

        private void changeConnectionState(boolean state){
            // TODO: change the connection state of GUI
        }


        // Connection
        public void clickConnectionButton(ActionEvent actionEvent) throws Exception {
            connection.buildNewConnection();
           /*
            connection.checkConnectionState();
            if (connection.isConnected()){
                // kill connection
                connection.killConnection();
                changeConnectionState(false);
                changeButtonText(ConnectionButton, "Connect");
            } else {
                // build connection
                connection.buildNewConnection();
                changeConnectionState(true);
                changeButtonText(ConnectionButton,"Disconnect");
            }
            */
        }

        public void changeIP_Adress(KeyEvent keyEvent) {
            connection.setIP_Adress(ConnectionIP.getText());
        }

        public void changePort(KeyEvent keyEvent) {
            connection.setPort(ConnectionPort.getText());
        }


        // Speech
        public void clickSpeechButton(ActionEvent actionEvent) throws Exception {
            connection.getSpeech().sayText();
        }

        public void changeSpeechText(KeyEvent keyEvent) {
            connection.getSpeech().setSpeechtext(SpeechText.getText());
        }

        public void changeLanguage(ActionEvent actionEvent) {
            connection.getSpeech().setLanguage(SpeechLanguage.getSelectionModel().getSelectedItem().toString());
        }

        public void changePitch(MouseEvent mouseEvent) {
            connection.getSpeech().setPitch((int)SpeechPitch.getValue());
        }

        public void changeSpeechVolume(MouseEvent mouseEvent) {
            float vol = (float) SpeechVolumeSlider.getValue();
            connection.getSpeech().setSpeechVolume(vol);
        }


        // Posture
        public void clickPostureButton(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getPosture().posePosture();
        }

        public void changePosture(ActionEvent actionEvent) {
            connection.getPosture().setPosture(PostureComboBox.getSelectionModel().getSelectedItem().toString());
        }

        public void changePostureSpeed(MouseEvent mouseEvent) {
            float speed = (float) PostureSpeedSlider.getValue();
            connection.getPosture().setSpeed(speed);
        }


        // AudioPlayer
        public void clickAudioPlayerButton(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getAudioplayer().playAudiosample();
        }

        public void changeAudioPlayerAudiosample(ActionEvent actionEvent) {
            connection.getAudioplayer().setAudiosample(AudioPlayerComboBox.getSelectionModel().getSelectedItem().toString());
        }

        public void changeAudioPlayerVolume(MouseEvent mouseEvent) {
            connection.getAudioplayer().setVolume((float)AudioPlayerSlider.getValue());
        }

        public void clickAudioPlayerButtonStop(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getAudioplayer().stopPlaying();
        }


        // Movement
        public void clickMovementButtonW(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getMovement().moveBodyForward();
        }

        public void clickMovementButtonA(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getMovement().changeMovementDirectionLeft();
        }

        public void clickMovementButtonS(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getMovement().moveBodyBackwards();
        }

        public void clickMovementButtonD(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getMovement().changeMovementDirectionRight();
        }

        public void clickMovementButtonStop(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getMovement().stopMovement();
        }

        public void changeMovementVel(MouseEvent mouseEvent) {
            connection.getMovement().setVelocity((float)MovementSliderVel.getValue());
        }


        // Appereance
        public void clickAppereanceButtonReset(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getAppereance().resetLEDs();
        }

        public void clickAppereanceButtonSet(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getAppereance().changeLEDColor();
        }

        public void changeAppereanceGroup(ActionEvent actionEvent) {
            connection.getAppereance().setGroup(AppereanceComboBoxGroup.getSelectionModel().getSelectedItem().toString());
        }

        public void changeAppereanceColor(ActionEvent actionEvent) {
            connection.getAppereance().setColor(AppereanceComboBoxColor.getSelectionModel().getSelectedItem().toString());
        }


        // BodyState
        public void clickBodyStateButton(ActionEvent actionEvent) throws InterruptedException, CallError {
            // get battery percentage
            String BatteryPerc;
            BatteryPerc = connection.getBodystate().getBatteryPercentage()+" %";
            changeLabelText(BodyStateBatteryPerc, BatteryPerc);

            // get temperature
            String Temp;
            Temp = connection.getBodystate().getTemperature();
            changeLabelText(BodyStateLabelTemp,Temp);

        }


}