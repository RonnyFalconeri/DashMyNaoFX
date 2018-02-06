package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;

public class Posture {

    // variables of instance
    private String Posture="Stand";
    private float Speed=1.0f;

    // variables of other objects
    private Connection Con;
    private ALRobotPosture pos;



        // Constructor
        public Posture(Connection pCon) throws Exception {
            this.Con = pCon;
            pos = new ALRobotPosture(this.Con.getSession());
        }



    // methods for NAO
    public void posePosture() throws InterruptedException, CallError {
        pos.goToPosture("StandInit", this.Speed);
        pos.goToPosture(this.Posture, this.Speed);
    }

    // additional method for external use
    public void posePosture(String pPosture) throws InterruptedException, CallError {
        pos.goToPosture(pPosture, 1.0f);
    }


    // set n' get
    public void setPosture(String Posture){
        this.Posture = Posture;
    }

    public void setSpeed(float Speed){
        this.Speed = Speed;
    }

}
