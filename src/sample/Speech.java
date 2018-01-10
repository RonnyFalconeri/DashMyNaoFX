package sample;

import com.aldebaran.qi.Application;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

public class Speech {
    private String Speechtext;
    private String Language;
    private int Volume;

    public Speech(){
        System.out.println("new Speech()...");
    }

    public void sayText() throws Exception{
        System.out.println("sayText()...");
        System.out.println("to say: "+Speechtext);


        // TODO: make Nao speak the given text at given parameters
        ALTextToSpeech tts = new ALTextToSpeech(sample.Connection.app.session());
        tts.say(Speechtext);

    }

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
