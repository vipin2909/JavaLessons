package DesignPatterns.State;

import org.apache.commons.lang3.tuple.Pair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



enum HandState {
    OFF_HOOK,
    ON_HOOK,
    CONNECTING,
    CONNECTED,
    ON_HOLD,
}

enum Trigger {
    CALL_DIALED,
    HUNG_UP,
    CALL_CONNECTED,
    PLACE_ON_HOLD,
    TAKEN_OFF_HOLD,
    LEFT_MESSAGE,
    STOP_USING_PHONE,
}

public class Demo {
    private static Map<HandState, List<Pair<Trigger, HandState>>> rules = new  HashMap<>();
    static {
        rules.put(HandState.OFF_HOOK, List.of(
                Pair.of(Trigger.CALL_DIALED, HandState.CONNECTING),
                Pair.of(Trigger.STOP_USING_PHONE, HandState.ON_HOOK)
        ));

        rules.put(HandState.CONNECTING, List.of(
                Pair.of(Trigger.HUNG_UP, HandState.OFF_HOOK),
                Pair.of(Trigger.CALL_CONNECTED, HandState.CONNECTED)
        ));

        rules.put(HandState.CONNECTED, List.of(
                Pair.of(Trigger.LEFT_MESSAGE, HandState.OFF_HOOK),
                Pair.of(Trigger.HUNG_UP, HandState.OFF_HOOK),
                Pair.of(Trigger.PLACE_ON_HOLD, HandState.ON_HOLD)
        ));

        rules.put(HandState.ON_HOLD, List.of(
                Pair.of(Trigger.TAKEN_OFF_HOLD, HandState.CONNECTED),
                Pair.of(Trigger.HUNG_UP, HandState.OFF_HOOK)
        ));
    }

    private static HandState currentState = HandState.OFF_HOOK;
    private static HandState exitState = HandState.ON_HOOK;

    public static void main(String[] args) {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            System.out.println("The Phone is Currently " + currentState);
            System.out.println("Select A Trigger: " );
            System.out.println(rules.get(currentState).get(0).getValue());
            for(int i = 0; i < rules.get(currentState).size(); i++) {
//               Trigger trigger = rules.get(currentState).get(i).getValue(0);
//               System.out.println("" + i + ". " + trigger);
            }

            boolean parseOK;
            int choice = 0;
            do {
                try {
                    System.out.println("Please enter your choice");
                    choice = Integer.parseInt(console.readLine());
                    parseOK = choice >= 0 && choice < rules.get(currentState).size();
                }
                catch(Throwable e) {
                    parseOK = false;
                    e.printStackTrace();
                }
            } while(!parseOK);

//            currentState = rules.get(currentState).get(choice).getValue(1);

            if(currentState == exitState) break;

        }
        System.out.println("And we are done");
    }
}

// Given Sufficient Complexity, it pays to formally define possible states and event/triggers

// Can define
// -> State entry/exit behaviors
// -> Action when a particular event causes transition
// -> Guard conditions enabling/disabling a transition
// -> Default actions when no particular transitions are found for an event


