package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALBehaviorManager;

public class Behavior {

    // variables of instance
    private String BehaviorName = "User/pushups-310730/pushups";

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

/*

Auswahl:
System/animations/Stand/Emotions/Negative/Bored_1,
User/pushups-310730/pushups,



[User/.lastUploadedChoregrapheBehavior/behavior_1,
User/pushups-310730/pushups,
System/animationMode,
System/animations/SitOnPod/BodyTalk/Listening/Listening_6,
System/animations/SitOnPod/BodyTalk/Listening/Listening_2,
System/animations/SitOnPod/BodyTalk/Listening/Listening_3,
System/animations/SitOnPod/BodyTalk/Listening/Listening_7,
System/animations/SitOnPod/BodyTalk/Listening/Listening_5,
System/animations/SitOnPod/BodyTalk/Listening/Listening_4,
System/animations/SitOnPod/BodyTalk/Listening/Listening_1,
System/animations/SitOnPod/BodyTalk/Listening/Listening_8,
System/animations/SitOnPod/BodyTalk/Thinking/Remember_3,
System/animations/SitOnPod/BodyTalk/Thinking/ThinkingLoop_2,
System/animations/SitOnPod/BodyTalk/Thinking/Remember_2,
System/animations/SitOnPod/BodyTalk/Thinking/Remember_1,
System/animations/SitOnPod/BodyTalk/Thinking/ThinkingLoop_1,
System/animations/SitOnPod/BodyTalk/Speaking/BodyTalk_12,
System/animations/SitOnPod/BodyTalk/Speaking/BodyTalk_4,
System/animations/SitOnPod/BodyTalk/Speaking/BodyTalk_9,
System/animations/SitOnPod/BodyTalk/Speaking/BodyTalk_10,
System/animations/SitOnPod/BodyTalk/Speaking/BodyTalk_6,
System/animations/SitOnPod/BodyTalk/Speaking/BodyTalk_5,
System/animations/SitOnPod/BodyTalk/Speaking/BodyTalk_7,
System/animations/SitOnPod/BodyTalk/Speaking/BodyTalk_11,
System/animations/SitOnPod/BodyTalk/Speaking/BodyTalk_1,
System/animations/SitOnPod/BodyTalk/Speaking/BodyTalk_8,
System/animations/SitOnPod/BodyTalk/Speaking/BodyTalk_2,
System/animations/SitOnPod/BodyTalk/Speaking/BodyTalk_3,
System/animations/SitOnPod/Emotions/Neutral/Hello_1,
System/animations/SitOnPod/Gestures/Yes_1,
System/animations/SitOnPod/Gestures/Me_7,
System/animations/SitOnPod/Gestures/Yes_2,
System/animations/SitOnPod/Gestures/WhatSThis_6,
System/animations/SitOnPod/Gestures/Everything_4,
System/animations/SitOnPod/Gestures/Me_1,
System/animations/SitOnPod/Gestures/WhatSThis_14,
System/animations/SitOnPod/Gestures/No_2,
System/animations/SitOnPod/Gestures/This_7,
System/animations/SitOnPod/Gestures/This_6,
System/animations/SitOnPod/Gestures/Me_8,
System/animations/SitOnPod/Gestures/Hey_3,
System/animations/SitOnPod/Gestures/WhatSThis_15,
System/animations/SitOnPod/Gestures/This_1,
System/animations/SitOnPod/Gestures/CountTwo_1,
System/animations/SitOnPod/Gestures/Hey_7,
System/animations/SitOnPod/Gestures/This_9,
System/animations/SitOnPod/Gestures/Me_2,
System/animations/SitOnPod/Gestures/No_5,
System/animations/SitOnPod/Gestures/This_15,
System/animations/SitOnPod/Gestures/No_1,
System/animations/SitOnPod/Gestures/Hey_1,
System/animations/SitOnPod/Gestures/This_12,
System/animations/SitOnPod/Gestures/This_4,
System/animations/SitOnPod/Gestures/This_2,
System/animations/SitOnPod/Gestures/You_5,
System/animations/SitOnPod/Gestures/This_5,
System/animations/SitOnPod/Gestures/WhatSThis_4,

*/