package sample;

import com.aldebaran.qi.Application;

public class Connection {
    private String IP_Adress;
    private String Port;

    public Application app;

    public Connection(String pIP_Adress, String pPort){
        System.out.println("new Classes.Connection()...");

        this.IP_Adress = pIP_Adress;
        this.Port = pPort;

        buildNewConnection();
    }

    private void buildNewConnection(){
        System.out.println("building new connection with IP: '"+this.IP_Adress+":"+this.Port+"' ");

        // TODO: build a new connection to NAO using the given IP adress and port
        String[] bugfix = new String[]{};
        app = new Application(bugfix, IP_Adress);
        app.start();
    }
}
