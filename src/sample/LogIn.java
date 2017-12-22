package sample;

public class LogIn {
    //private String Username;
    //private String Password;

    private String IP_Adress;
    private String Port;

    public LogIn(String pIP_Adress, String pPort){
        System.out.println("new Classes.LogIn()...");

        //this.Username = pUsername;
        //this.Password = pPassword;

        this.IP_Adress = pIP_Adress;
        this.Port = pPort;

        Connection connection = new Connection(this.IP_Adress, this.Port);
    }

}
