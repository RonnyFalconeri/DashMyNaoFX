package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALAudioPlayer;

public class AudioPlayer {

    // variables of instance
    private String Audiosample;

    // variables of other objects
    private ALAudioPlayer audioplayer;



        // Constructor
        public AudioPlayer(Connection pCon) throws Exception {
            audioplayer = new ALAudioPlayer(pCon.getSession());
        }



    // methods for NAO
    public void playAudiosample() throws InterruptedException, CallError {
        audioplayer.playSoundSetFile("Aldebaran",this.Audiosample);
    }


    // set n' get
    public void setAudiosample(String audiosample) {
        this.Audiosample = audiosample;
    }

}
