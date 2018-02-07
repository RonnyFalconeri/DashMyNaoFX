package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALAudioPlayer;

public class AudioPlayer {

    // variables of instance
    private String AudioSample;

    // variables of other objects
    private ALAudioPlayer audioPlayer;



        // Constructor
        AudioPlayer(Connection pCon) throws Exception {
            audioPlayer = new ALAudioPlayer(pCon.getSession());
        }



    // methods for NAO
    public void playAudioSample() throws InterruptedException, CallError {
        audioPlayer.playSoundSetFile("Aldebaran",this.AudioSample);
    }


    // set n' get
    public void setAudioSample(String pAudioSample) {
        this.AudioSample = pAudioSample;
    }

}
