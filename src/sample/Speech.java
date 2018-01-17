package sample;

import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

public class Speech {

    private String Speechtext;
    private String Language = "Deutsch";
    private double Pitch;
    private Connection connection;





    // Constructor
    public Speech(Connection connection){
        System.out.println("new Speech()...");
        this.connection = connection;
    }




    // methods for NAO
    public void sayText() throws Exception{
        System.out.println("sayText()...");
        System.out.println("to say: '"+this.Speechtext+"', language: "+this.Language);

        ALTextToSpeech tts = new ALTextToSpeech(connection.getApplication().session());
        tts.say(Speechtext,Language);
    }

    public void sayText(String pSpeechtext, String pLanguage) throws Exception{
        System.out.println("sayText()...");
        System.out.println("to say: '"+pSpeechtext+"', language: "+pLanguage);

        ALTextToSpeech tts = new ALTextToSpeech(connection.getApplication().session());
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

    public void setPitch(double pPitch){
        System.out.println("set Pitch to: "+pPitch);
        this.Pitch = pPitch;
    }
}