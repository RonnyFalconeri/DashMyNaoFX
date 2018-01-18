package sample;
import com.aldebaran.qi.Application;

public class Connection {

    private String IP_Adress = "192.168.1.133";
    private String Port = "9559";
    private boolean IsConnected=false;

    private Application application;
    private Speech speech;
    private Posture posture;
    private AudioPlayer audioplayer;



    // Constructor
    public Connection() throws Exception {
        System.out.println("new Connection()... ");
    }



    // methods for NAO
    public void buildNewConnection() throws Exception {
        String ConnectionURL = "tcp://"+IP_Adress+":"+Port;
        System.out.println("building new connection with IP:  "+ConnectionURL);
        application = new Application(new String[]{}, ConnectionURL);
        application.start();

        // TODO: move to constructor for bugfix
        // instanciate new objects here
        posture = new Posture(this);
        speech = new Speech(this);
        audioplayer = new AudioPlayer();

        // TODO: instanciate temporary speech object
        speech.sayText("I am connected.", "English");
    }

    public void killConnection(){
        System.out.println("kill current connection...");

        // TODO: kill the connection with NAO
    }

    public void checkConnectionState(){
        System.out.println("checking the connection state...");
        boolean state=false;

        // TODO: check the current connection of NAO

        setConnected(state);
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

    private void setConnected(boolean ConnectionState) {
        this.IsConnected = ConnectionState;
    }

    public boolean isConnected(){
        return this.IsConnected;
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

    public AudioPlayer getAudioplayer(){
        return this.audioplayer;
    }

}