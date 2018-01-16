package sample;
import com.aldebaran.qi.Application;

public class Connection {

    private String IP_Adress;
    private String Port;
    //private String ConnectionURL = "tcp://"+IP_Adress+":"+Port;
    private boolean IsConnected=false;
    private Application application;



    // Constructor
    public Connection(){
        System.out.println("new Connection()...");
    }


    // methods for NAO
    public void buildNewConnection(){
        String ConnectionURL = "tcp://"+IP_Adress+":"+Port;
        System.out.println("building new connection with IP: "+ConnectionURL);

        //application = new Application(new String[]{}, ConnectionURL);
        //application.start();
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

    public Application getApplication(){
        return this.application;
    }

    public void setConnected(boolean connected) {
        IsConnected = connected;
    }
}