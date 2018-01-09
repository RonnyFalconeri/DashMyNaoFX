package sample;

public class Speech {
    private String Speechtext;
    private String Language;
    private int Volume;

    public Speech(String pSpeechtext, String pLanguage, int pVolume){
        System.out.println("new Speech()...");

        this.Speechtext = pSpeechtext;
        this.Language = pLanguage;
        this.Volume = pVolume;
    }

    public static void sayText(){
        System.out.println("sayText()...");

        // TODO: make Nao speak the given text at given parameters
    }
}
