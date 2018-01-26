package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALAudioPlayer;

public class AudioPlayer {

    private String Audiosample;

    private ALAudioPlayer audioplayer;
    private Connection Con;



        // Constructor
        public AudioPlayer(Connection pCon) throws Exception {
            System.out.println("new AudioPlayer()...");
            this.Con = pCon;
            audioplayer = new ALAudioPlayer(Con.getApplication().session());
        }


    // methods for NAO
    public void playAudiosample() throws InterruptedException, CallError {
        System.out.println("playing Audiosample: "+this.Audiosample);
        audioplayer.playSoundSetFile("Aldebaran",this.Audiosample);
    }


    // set n' get
    public void setAudiosample(String audiosample) {
        System.out.println("set Audiosample to: "+audiosample);
        this.Audiosample = audiosample;
    }
}
