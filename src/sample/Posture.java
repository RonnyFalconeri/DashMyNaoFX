package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;

public class Posture {

    private String Posture="Stand";
    private float Speed=1.0f;

    private Connection Con;
    private ALRobotPosture pos;



        // Constructor
        public Posture(Connection pCon) throws Exception {
            System.out.println("new Posture()...");
            this.Con = pCon;
            pos = new ALRobotPosture(this.Con.getApplication().session());
        }



    // methods for NAO
    public void posePosture() throws InterruptedException, CallError {
        System.out.println("posing to: "+this.Posture);
        pos.goToPosture("StandInit", this.Speed);
        pos.goToPosture(this.Posture, this.Speed);
    }

    // additional method for external use
    public void posePosture(String pPosture) throws InterruptedException, CallError {
        pos.goToPosture(pPosture, 1.0f);
    }


    // set n' get
    public void setPosture(String Posture){
        System.out.println("set Posture to: "+Posture);
        this.Posture = Posture;
    }

    public void setSpeed(float Speed){
        System.out.println("set Speed to: "+Speed);
        this.Speed = Speed;
    }

}
