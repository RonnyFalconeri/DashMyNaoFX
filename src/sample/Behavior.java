package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALBehaviorManager;

public class Behavior {

    // variables of instance
    private String BehaviorName;

    // variables of other objects
    private ALBehaviorManager behavior;



        // Constructor
        public Behavior(Connection pCon) throws Exception {
            System.out.println("new Behavior()...");
            behavior = new ALBehaviorManager(pCon.getSession());
        }



    // methods for NAO
    public void startBehavior() throws InterruptedException, CallError {
        System.out.println("start behavior: "+this.BehaviorName);
        behavior.stopAllBehaviors();
        behavior.startBehavior(this.BehaviorName);
    }

    public void stopBehavior() throws InterruptedException, CallError {
        System.out.println("stop all behaviors.");
        behavior.stopAllBehaviors();
    }


    // set n' get
    public void setBehaviorName(String pBehaviorName){
        System.out.println("set BehaviorName to: "+pBehaviorName);
        this.BehaviorName = pBehaviorName;
    }

}
