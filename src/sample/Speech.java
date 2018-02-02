package sample;

import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

public class Speech {

    // variables of instance
    private String Speechtext="null";
    private String Language = "Deutsch";
    private int Pitch = 100;
    private float Volume = 0.5f;

    // variables of other objects5
    private Connection Con;
    private ALTextToSpeech tts;



        // Constructor
        public Speech(Connection pCon){
            System.out.println("new Speech()...");
            this.Con = pCon;
        }



    // methods for NAO
    public void sayText() throws Exception{
        System.out.println("sayText()...");
        System.out.println("to say: '"+this.Speechtext+"', language: "+this.Language);
        tts = new ALTextToSpeech(Con.getApplication().session());
        tts.setVolume(this.Volume);
        tts.say("\\vct="+this.Pitch+"\\"+this.Speechtext, this.Language);
    }

    // additional methods for external use
    public void sayText(String pSpeechtext, String pLanguage) throws Exception{
        System.out.println("sayText()...");
        System.out.println("to say: '"+pSpeechtext+"', language: "+pLanguage);
        ALTextToSpeech tts = new ALTextToSpeech(Con.getApplication().session());
        tts.say(pSpeechtext,pLanguage);
    }

    public void sayText(String pSpeechtext, String pLanguage, int pPitch) throws Exception{
        System.out.println("sayText()...");
        System.out.println("to say: '"+pSpeechtext+"', language: "+pLanguage);
        ALTextToSpeech tts = new ALTextToSpeech(Con.getApplication().session());
        tts.say("\\vct="+pPitch+"\\"+pSpeechtext,pLanguage);
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

    public void setPitch(int pPitch){
        System.out.println("set Pitch to: "+pPitch);
        this.Pitch = pPitch;
    }

    public void setSpeechVolume(float volume) {
        System.out.println("set Volume to: "+volume);
        this.Volume = volume;
    }

}