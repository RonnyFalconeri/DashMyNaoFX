package sample;

import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

public class Speech {

    private String Speechtext;
    private String Language = "Deutsch";
    private float Pitch;
    private float Volume;

    private Connection con;
    private ALTextToSpeech tts;


    // Constructor
    public Speech(Connection connection){
        System.out.println("new Speech()...");
        this.con = connection;
    }


    // methods for NAO
    public void sayText() throws Exception{
        System.out.println("sayText()...");
        System.out.println("to say: '"+this.Speechtext+"', language: "+this.Language);

        tts = new ALTextToSpeech(con.getApplication().session());
        tts.setParameter("pitchShift",this.Pitch);
        tts.setVolume(this.Volume);
        tts.say(this.Speechtext, this.Language);
    }

    public void sayText(String pSpeechtext, String pLanguage) throws Exception{
        System.out.println("sayText()...");
        System.out.println("to say: '"+pSpeechtext+"', language: "+pLanguage);

        ALTextToSpeech tts = new ALTextToSpeech(con.getApplication().session());
        tts.say(pSpeechtext,pLanguage);
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

    public void setPitch(float pPitch){
        System.out.println("set Pitch to: "+pPitch);
        this.Pitch = pPitch;
    }

    public void setSpeechVolume(float volume) {
        this.Volume = volume;
    }
}