package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.EventCallback;
import com.aldebaran.qi.helper.proxies.*;

class TactileSensors {

    // variables of instance
    private long frontTactileSubscriptionId;
    private long middleTactileSubscriptionId;
    private long rearTactileSubscriptionId;

    // variables of other objects
    private Connection Con;



        // Constructor
        TactileSensors(Connection pCon) throws Exception {
            this.Con = pCon;
            ALMemory memory = new ALMemory(this.Con.getSession());

            // subscribe to event listener - front
            frontTactileSubscriptionId = memory.subscribeToEvent("FrontTactilTouched", new EventCallback<Float>() {
                @Override
                public void onEvent(Float arg0)
                        throws InterruptedException, CallError {
                    if (arg0 > 0) {
                        if (frontTactileSubscriptionId > 0) {
                            System.out.println("pressed");
                            try {
                                Con.getSpeech().sayText("front","English");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });

            // subscribe to event listener - middle
            middleTactileSubscriptionId = memory.subscribeToEvent("MiddleTactilTouched", new EventCallback<Float>() {
                @Override
                public void onEvent(Float arg0)
                        throws InterruptedException, CallError {
                    if (arg0 > 0) {
                        if (middleTactileSubscriptionId > 0) {
                            System.out.println("pressed");
                            try {
                                Con.getSpeech().sayText("middle","English");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });

            // subscribe to event listener - rear
            rearTactileSubscriptionId = memory.subscribeToEvent("RearTactilTouched", new EventCallback<Float>() {
                @Override
                public void onEvent(Float arg0)
                        throws InterruptedException, CallError {
                    if (arg0 > 0) {
                        if (rearTactileSubscriptionId > 0) {
                            System.out.println("pressed");
                            try {
                                Con.getSpeech().sayText("back","English");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });

        }

}
