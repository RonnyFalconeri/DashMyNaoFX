package sample;

public class Speech {
    private String Speechtext;
    private String Language;
    private int Volume;

    public Speech(){
        System.out.println("new Speech()...");

    }

    public void sayText(){
        System.out.println("sayText()...");
        System.out.println("to say: "+Speechtext);

        // TODO: make Nao speak the given text at given parameters


    }

    public void setSpeechtext(String pSpeechtext){
        this.Speechtext = pSpeechtext;
    }

    public void setLanguage(String pLanguage){
        this.Language = pLanguage;
    }

    public void setVolume(int pVolume){
        this.Volume = pVolume;
    }
}
