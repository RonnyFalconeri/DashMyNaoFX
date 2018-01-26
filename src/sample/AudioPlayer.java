package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALAudioPlayer;

public class AudioPlayer {

    private String Audiosample;
    private float Volume=0.5f;

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

        audioplayer.setMasterVolume(this.Volume);
        audioplayer.playSoundSetFile("Aldebaran",this.Audiosample);
    }

    public void stopPlaying() throws InterruptedException, CallError {
        System.out.println("stop playing...");
        audioplayer.stopAll();
    }


    // set n' get
    public void setAudiosample(String audiosample) {
        System.out.println("set Audiosample to: "+audiosample);
        this.Audiosample = audiosample;
    }

    public void setVolume(float volume) {
        System.out.println("set Volume to: "+volume);
        this.Volume = volume;
    }
}
