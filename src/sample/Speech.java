package sample;

import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

public class Speech {

    // variables of instance
    private String SpeechText = "No string registered.";
    private String Language = "English";
    private int Pitch = 100;
    private float Volume = 0.5f;

    // variables of other objects
    private ALTextToSpeech tts;



        // Constructor
        public Speech(Connection pCon) throws Exception {
            tts = new ALTextToSpeech(pCon.getSession());
        }



    // methods for NAO
    public void sayText() throws Exception{
        tts.setVolume(this.Volume);
        tts.say("\\vct="+this.Pitch+"\\"+this.SpeechText, this.Language);
    }

    // additional methods for external use
    public void sayText(String pSpeechText, String pLanguage) throws Exception{
        tts.say(pSpeechText,pLanguage);
    }

    public void sayText(String pSpeechText, String pLanguage, int pPitch) throws Exception{
        tts.say("\\vct="+pPitch+"\\"+pSpeechText,pLanguage);
    }


    // set n' get
    public void setSpeechText(String pSpeechText){
        this.SpeechText = pSpeechText;
    }

    public void setLanguage(String pLanguage){
        this.Language = pLanguage;
    }

    public void setPitch(int pPitch){
        this.Pitch = pPitch;
    }

    public void setSpeechVolume(float pVolume) {
        this.Volume = pVolume;
    }

}