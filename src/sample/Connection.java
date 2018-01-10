package sample;

import com.aldebaran.qi.Application;

public class Connection {
    private String IP_Adress="192.168.1.133";
    private String Port="9559";

    public Application app;

    public Connection(){
        System.out.println("new Classes.Connection()...");


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
