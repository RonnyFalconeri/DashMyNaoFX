package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;

public class Posture {

    // variables of instance
    private String Posture = "Stand";
    private float Speed=1.0f;

    // variables of other objects
    private ALRobotPosture pos;



        // Constructor
        public Posture(Connection pCon) throws Exception {
            pos = new ALRobotPosture(pCon.getSession());
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
    public void setPosture(String pPosture){
        this.Posture = pPosture;
    }

    public void setSpeed(float pSpeed){
        this.Speed = pSpeed;
    }

}
