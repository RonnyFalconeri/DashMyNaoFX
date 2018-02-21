package sample;

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
    public void playAudioSample() {
        try {
            audioPlayer.playSoundSetFile("Aldebaran",this.AudioSample);
        } catch (Exception e){
            System.out.println("This NAO isn't able to play audio samples.");
        }
    }


    // set n' get
    public void setAudioSample(String pAudioSample) {
        this.AudioSample = pAudioSample;
    }

}
