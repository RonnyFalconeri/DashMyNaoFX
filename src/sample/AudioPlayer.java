package sample;

public class AudioPlayer {

    private String Audiosample;
    private float Volume=0.5f;



    // Constructor
    public AudioPlayer() {
        System.out.println("new AudioPlayer()...");

    }


    // methods for NAO
    public void playAudiosample(){
        System.out.println("playing Audiosample: "+this.Audiosample);

        // TODO: make the NAO play the given audio sample
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
