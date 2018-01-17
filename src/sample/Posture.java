package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;

public class Posture {

    private String Posture;
    private float Speed=1.0f;

    private Connection connection;
    private ALRobotPosture pos;



    // Constructor
    public Posture(Connection pConnection) throws Exception {
        System.out.println("new Posture()...");
        this.connection = pConnection;
        pos = new ALRobotPosture(this.connection.getApplication().session());
    }



    // methods for NAO
    public void posePosture() throws InterruptedException, CallError {
        System.out.println("posing to: "+this.Posture);
        pos.goToPosture("StandInit", this.Speed);
        pos.goToPosture(this.Posture, this.Speed);
    }

    // set n' get
    public void setPosture(String Posture){
        System.out.println("set Posture to: "+this.Posture);
        this.Posture = Posture;
    }

    public void setSpeed(float Speed){
        System.out.println("set Speed to: "+Speed);
        this.Speed = Speed;
    }
}
