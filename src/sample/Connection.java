package sample;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALAudioDevice;

public class Connection {

    // variables of instance
    private String IP_Address = "192.168.1.133";
    private String Port = "9559";
    private boolean IsConnected = false;

    // variables of other objects
    private Speech speech;
    private Posture posture;
    private AudioPlayer audioplayer;
    private Appearance appearance;
    private Movement movement;
    private BodyState bodystate;
    private HeadAlignment headalignment;
    private Session session;
    private Behavior behavior;



    // Constructor
        public Connection() {
            System.out.println("new connection... ");
        }



    // methods for NAO
    public void buildNewConnection() throws Exception {
        String ConnectionURL = "tcp://"+ IP_Address +":"+Port;
        System.out.println("building new connection with IP:  "+ConnectionURL);

        // build new session
        session = new Session(ConnectionURL);
        session.connect(ConnectionURL);
        this.setConnected(true);

        // save latest IP in "latest connection.txt"
        FileManager.writeInFile(this.IP_Address);

        // instantiate new objects here
        posture = new Posture(this);
        speech = new Speech(this);
        audioplayer = new AudioPlayer(this);
        appearance = new Appearance(this);
        movement = new Movement(this);
        bodystate = new BodyState(this);
        headalignment = new HeadAlignment(this);
        behavior = new Behavior(this);
        TactileSensors tactile = new TactileSensors(this);
        ALAudioDevice audioDevice = new ALAudioDevice(this.session);

        // giving feedback
        audioDevice.setOutputVolume(90);
        appearance.resetLEDs();
        posture.posePosture("Stand");
        speech.sayText("I am connected.", "English", 100);
        System.out.println("connection successful.");
    }

    public void killConnection() throws Exception {
        speech.sayText("Getting disconnected.", "English", 100);
        session.close();
        this.setConnected(false);
        System.out.println("connection closed.");
    }

    private void checkConnectionState(){
        boolean state = session.isConnected();
        setConnected(state);
    }


    //set n' get
    public void setIP_Address(String pIP){
        this.IP_Address = pIP;
    }

    public void setPort(String pPort){
        this.Port = pPort;
    }

    private void setConnected(boolean pConnectionState) {
        this.IsConnected = pConnectionState;
    }

    public boolean isConnected(){
            checkConnectionState();
        return this.IsConnected;
    }


    // get objects from outside
    public Speech getSpeech(){return this.speech;}

    public Posture getPosture() {return this.posture;}

    public AudioPlayer getAudioPlayer(){return this.audioplayer;}

    public Appearance getAppearance() {return this.appearance;}

    public Movement getMovement() {return this.movement;}

    public BodyState getBodyState() {return this.bodystate;}

    public HeadAlignment getHeadAlignment() {return this.headalignment;}

    public Session getSession() {return this.session;}

    public Behavior getBehavior() {return this.behavior;}
}