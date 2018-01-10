package sample;
import com.aldebaran.qi.Application;

public class Connection {

    private String ConnectionURL = "tcp://192.168.1.133:9559";
    public Application app;



    // Constructor
    public Connection(){
        System.out.println("new Connection()...");

        buildNewConnection();
    }


    // methods for NAO
    private void buildNewConnection(){
        System.out.println("building new connection with IP: '"+this.ConnectionURL);

        String[] bugfix = new String[]{};
        app = new Application(bugfix, ConnectionURL);
        app.start();
    }


    //set n' get
    public void setIP_Adress(String IP, String Port){
        String URL = "tcp://"+IP+":"+Port;
        System.out.println("set ConnectionURL to: "+URL);
        this.ConnectionURL = URL;
    }

    public void setIP_Adress(String URL){
        System.out.println("set ConnectionURL to: "+URL);
        this.ConnectionURL = URL;
    }
}
