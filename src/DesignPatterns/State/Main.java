package DesignPatterns.State;
//
//// Fun with finite state machine
//// Example: Consider an ordinary telephone
//// What u do with it depends on the state of the phone/line
//// -> if it is ringing or u want to make a call, u can pick it up
//// -> phone must be off the hook to talk/make a call
//// -> if u try to call someone and line is busy then put the phone down
//// Changes in state can be explicit or in response to event (Observer Pattern)
//
///*
// A Pattern which the object's behavior is determined by its state. An Object transitions
// From one state to another(Something needs to trigger a transition).
//
// A Formalized construct which manages state and transitions is called state Machine.
//
// */
//
//// Classical Implementation
//class State {
//    void on(LightSwitch ls) {
//        System.out.println("Light is already On!!");
//    }
//
//    void off(LightSwitch ls) {
//        System.out.println("Light is already off!!");
//    }
//}
//
//class OnState extends State {
//    public OnState() {
//        System.out.println("Light turned on");
//    }
//
//    @Override
//    public void off(LightSwitch ls) {
//        System.out.println("Switching light off..");
//        ls.setState(new OffState());
//
//    }
//}
//
//class OffState extends State {
//    public OffState() {
//        System.out.println("Light Turned Off");
//    }
//
//    @Override
//    public void on(LightSwitch ls) {
//        System.out.println("Switching light on..");
//        ls.setState(new OnState());
//    }
//}
//
//class LightSwitch {
//    private State state; // OnState, OffState
//
//    public void setState(State state) {
//        this.state = state;
//    }
//    public LightSwitch() {
//        this.state = new OffState();
//    }
//
//    void on() {
//        state.on(this);
//    }
//
//    void off() {
//        state.off(this);
//    }
//
//}
//
//public class Main {
//    public static void main(String[] args) {
//        LightSwitch lightSwitch = new LightSwitch();
//        lightSwitch.on();
//        lightSwitch.off();
//        lightSwitch.off();
//    }
//}


class Light {
    private State state;
    public void setState(State state) {
        this.state = state;
    }

    public Light() {
        state = new OffState();
    }

    public void on() {
        state.on(this);
    }

    public void off() {
        state.off(this);
    }
}

class State {
    public void off(Light l) {
        System.out.println("Light Switch is Off Already!!");
    }
    public void on(Light l) {
        System.out.println("Light Siwtched Is On Already");
    }
}

class OnState extends State {
    public OnState() {
        System.out.println("Light is ON");

    }

    @Override
    public void off(Light l) {
        System.out.println("Light Switch Is Off");
        l.setState(new OffState());
    }
}

class OffState extends State {
    public OffState() {
        System.out.println("Light is off");
    }

    public void on(Light l) {
        System.out.println("Switching Light on");
        l.setState(new OnState());
    }
}
public class Main {
    public static void main(String[] args) {
        Light l = new Light();
        l.on();
        l.off();
        l.on();
        l.on();
    }
}