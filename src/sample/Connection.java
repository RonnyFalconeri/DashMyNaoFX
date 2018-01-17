package sample;
import com.aldebaran.qi.Application;

public class Connection {

    private String IP_Adress;
    private String Port;
    private boolean IsConnected=false;

    private Application application;
    private Speech speech;
    private Posture posture;

    // Constructor
    public Connection() throws Exception {
        System.out.println("new Connection()... ");

        // instanciate new objects here
        speech = new Speech(this);
        posture = new Posture(this);
    }


    // methods for NAO
    public void buildNewConnection() throws Exception {
        String ConnectionURL = "tcp://"+IP_Adress+":"+Port;
        System.out.println("building new connection with IP:  "+ConnectionURL);

        application = new Application(new String[]{}, ConnectionURL);
        application.start();

        speech.sayText("I am connected.", "English");
    }


    //set n' get
    public void setIP_Adress(String IP){
        System.out.println("set IP_Adress to: "+IP);
        this.IP_Adress = IP;
    }

    public void setPort(String Port){
        System.out.println("set Port to: "+Port);
        this.Port = Port;
    }

    public Speech getSpeech(){
        return this.speech;
    }

    public Application getApplication(){
        return this.application;
    }

    public Posture getPosture() {
        return this.posture;
    }

    public void setConnected(boolean connected) {
        IsConnected = connected;
    }
}