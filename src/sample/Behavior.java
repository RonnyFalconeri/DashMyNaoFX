package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALBehaviorManager;

public class Behavior {

    // variables of instance
    private String BehaviorName = "System/animationMode";

    // variables of other objects
    private ALBehaviorManager behavior;



        // Constructor
        public Behavior(Connection pCon) throws Exception {
            behavior = new ALBehaviorManager(pCon.getSession());
        }



    // methods for NAO
    public void startBehavior() throws InterruptedException, CallError {
        behavior.stopAllBehaviors();
        behavior.startBehavior(this.BehaviorName);
    }

    public void stopBehavior() throws InterruptedException, CallError {
        behavior.stopAllBehaviors();
    }


    // set n' get
    public void setBehaviorName(String pBehaviorName){
        System.out.println("set BehaviorName to: "+pBehaviorName);
        this.BehaviorName = pBehaviorName;
    }

}