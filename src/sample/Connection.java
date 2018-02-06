package sample;
import com.aldebaran.qi.Application;
import com.aldebaran.qi.Session;

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
    private Session session;
    private TactileSensors tactile;



        // Constructor
        public Connection() throws Exception {
            System.out.println("new connection... ");
        }



    // methods for NAO
    public void buildNewConnection() throws Exception {
        String ConnectionURL = "tcp://"+IP_Adress+":"+Port;
        System.out.println("building new connection with IP:  "+ConnectionURL);

        session = new Session(ConnectionURL);
        session.connect(ConnectionURL);

        this.setConnected(true);

        // instanciate new objects here
        posture = new Posture(this);
        speech = new Speech(this);
        audioplayer = new AudioPlayer(this);
        appereance = new Appereance(this);
        movement = new Movement(this);
        bodystate = new BodyState(this);
        headalignment = new HeadAlignment(this);
        tactile = new TactileSensors(this);

        // giving feedback
        posture.posePosture("Stand");
        speech.sayText("I am connected", "English", 100);
    }

    public void killConnection() throws Exception {
        speech.sayText("Getting disconnected", "English", 100);
        session.close();
        this.setConnected(false);
        System.out.println("connection closed.");
    }

    public void checkConnectionState(){
        boolean state = session.isConnected();
        setConnected(state);
    }


    //set n' get
    public void setIP_Adress(String IP){
        this.IP_Adress = IP;
    }

    public void setPort(String Port){
        this.Port = Port;
    }

    private void setConnected(boolean ConnectionState) {
        this.IsConnected = ConnectionState;
    }

    public boolean isConnected(){
            checkConnectionState();
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

    public Session getSession() {return this.session;}
}