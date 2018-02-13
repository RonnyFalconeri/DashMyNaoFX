package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.EventCallback;
import com.aldebaran.qi.helper.proxies.*;

class TactileSensors {

    // variables of instance
    private long frontTactileSubscriptionId;
    private long middleTactileSubscriptionId;
    private long rearTactileSubscriptionId;
    private boolean TrackerIsActive = false;

    // variables of other objects
    private Connection Con;
    private ALTracker tracker;



        // Constructor
        TactileSensors(Connection pCon) throws Exception {

            this.Con = pCon;
            ALMemory memory = new ALMemory(this.Con.getSession());
            tracker = new ALTracker(this.Con.getSession());

            // subscribe to event listener - front
            frontTactileSubscriptionId = memory.subscribeToEvent("FrontTactilTouched", (EventCallback<Float>) arg0 -> {
                if (arg0 > 0) { if (frontTactileSubscriptionId > 0) { try {

                    if (TrackerIsActive){
                        // disable tracker
                        TrackerIsActive = false;
                        Con.getSpeech().sayText("Tracker disabled.","English");

                    } else{
                        // enable tracker
                        TrackerIsActive = true;
                        Con.getSpeech().sayText("Tracker enabled. Searching for Faces.","English");

                        boolean search = true;
                        boolean detected;

                        tracker.stopTracker();
                        tracker.registerTarget("Face", 0.1F);
                        tracker.track("Face"); //PTargets: [RedBall, Face, LandMark, LandMarks, People, Sound]
                        tracker.toggleSearch(true);


                        while (search) {
                            detected = tracker.isNewTargetDetected();
                            if (detected) {
                                tracker.toggleSearch(false);
                                Con.getSpeech().sayText("Ha! found ya!","English");
                                tracker.removeAllTargets();
                                search = false;
                            }
                        }
                    }

                } catch (Exception e) { e.printStackTrace();}}}});

            // subscribe to event listener - middle
            middleTactileSubscriptionId = memory.subscribeToEvent("MiddleTactilTouched", (EventCallback<Float>) arg0 -> {
                if (arg0 > 0) { if (middleTactileSubscriptionId > 0) { try {

                    Con.getBehavior().startBehavior("animations/Stand/Waiting/ShowMuscles_5");
                    Con.getSpeech().sayText("Huuulk is aaangry!","English", 50);

                } catch (Exception e) { e.printStackTrace(); }}}});

            // subscribe to event listener - rear
            rearTactileSubscriptionId = memory.subscribeToEvent("RearTactilTouched", (EventCallback<Float>) arg0 -> {
                if (arg0 > 0) { if (rearTactileSubscriptionId > 0) { try {

                    Con.getSpeech().sayText("English motherfucker!","English");
                    Con.getSpeech().sayText("Do you speak it?!","English",30);

                } catch (Exception e) { e.printStackTrace(); }}}});

        }

}
