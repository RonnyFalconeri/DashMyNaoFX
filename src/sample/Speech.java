package sample;

import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

public class Speech {

    private String Speechtext;
    private String Language;
    private int Volume;
    private Connection Con;



    // Constructor
    public Speech(Connection pCon){
        System.out.println("new Speech()...");
        this.Con = pCon;
    }


    // methods for NAO
    public void sayText() throws Exception{
        System.out.println("sayText()...");
        System.out.println("to say: "+Speechtext);

        ALTextToSpeech tts = new ALTextToSpeech(Con.app.session());
        tts.say(Speechtext);
    }


    // set n' get
    public void setSpeechtext(String pSpeechtext){
        System.out.println("set speechtext to: "+pSpeechtext);
        this.Speechtext = pSpeechtext;
    }

    public void setLanguage(String pLanguage){
        System.out.println("set language to: "+pLanguage);
        this.Language = pLanguage;
    }

    public void setVolume(int pVolume){
        System.out.println("set language to: "+pVolume);
        this.Volume = pVolume;
    }
}