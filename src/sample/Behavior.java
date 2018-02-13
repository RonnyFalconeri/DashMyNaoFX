package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALBehaviorManager;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;

public class Behavior {

    // variables of instance
    private String BehaviorName = "System/animationMode";

    // variables of other objects
    private ALBehaviorManager behavior;
    private ALRobotPosture posture;



        // Constructor
        public Behavior(Connection pCon) throws Exception {
            behavior = new ALBehaviorManager(pCon.getSession());
            posture = new ALRobotPosture(pCon.getSession());
        }



    // methods for NAO
    public void startBehavior() throws InterruptedException, CallError {
        posture.goToPosture("StandInit", 1.0f);
        behavior.stopAllBehaviors();
        behavior.startBehavior(this.BehaviorName);
    }

        // additional methods for external use
        public void startBehavior(String pBehaviorName) throws InterruptedException, CallError {
            posture.goToPosture("StandInit", 1.0f);
            behavior.stopAllBehaviors();
            behavior.startBehavior(pBehaviorName);
        }

    public void stopBehavior() throws InterruptedException, CallError {
        behavior.stopAllBehaviors();
    }


    // set n' get
    public void setBehaviorName(String pBehaviorName){
        this.BehaviorName = pBehaviorName;
    }

}