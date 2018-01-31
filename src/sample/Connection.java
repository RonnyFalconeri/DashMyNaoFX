package sample;
import com.aldebaran.qi.Application;

public class Connection {

    // variables of instance
    private String IP_Adress = "192.168.1.133";
    private String Port = "9559";
    private boolean IsConnected=false;

    // variables of other objects
    private Application application;
    private Speech speech;
    private Posture posture;
    private AudioPlayer audioplayer;
    private Appereance appereance;
    private Movement movement;
    private BodyState bodystate;
    private HeadAlignment headalignment;



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
        this.setConnected(true);

        // instanciate new objects here
        posture = new Posture(this);
        speech = new Speech(this);
        audioplayer = new AudioPlayer(this);
        appereance = new Appereance(this);
        movement = new Movement(this);
        bodystate = new BodyState(this);
        headalignment = new HeadAlignment(this);

        // giving feedback
        posture.posePosture("Stand");
        speech.sayText("I am connected.", "English");
    }

    public void killConnection(){
        System.out.println("kill current connection...");
        application.session().close();
        this.setConnected(false);
        System.out.println("kill successfull.");
    }

    public void checkConnectionState(){
        System.out.println("checking the connection state...");
        boolean state = application.session().isConnected();
        System.out.println("state: "+state);
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

    public void setConnected(boolean ConnectionState) {
        this.IsConnected = ConnectionState;
    }

    public boolean isConnected(){
        return this.IsConnected;
    }


    // get objects from outside
    public Speech getSpeech(){return this.speech;}

    public Application getApplication(){return this.application;}

    public Posture getPosture() {return this.posture;}

    public AudioPlayer getAudioplayer(){return this.audioplayer;}

    public Appereance getAppereance() {return this.appereance;}

    public Movement getMovement() {return this.movement;}

    public BodyState getBodystate() {return this.bodystate;}

    public HeadAlignment getHeadalignment() {return this.headalignment;}

}