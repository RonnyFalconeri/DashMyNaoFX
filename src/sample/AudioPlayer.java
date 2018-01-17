package sample;

public class AudioPlayer {

    private String Audiosample;
    private float Volume;



    // Constructor
    public AudioPlayer() {
        System.out.println("new AudioPlayer()...");

    }


    // methods for NAO
    public void playAudiosample(){
        System.out.println("playing Audiosample...");

        // TODO: make the NAO play the given audio sample
    }


    // set n' get
    public void setAudiosample(String audiosample) {
        Audiosample = audiosample;
    }

    public void setVolume(float volume) {
        Volume = volume;
    }
}
