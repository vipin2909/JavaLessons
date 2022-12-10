package DesignPatterns.CommandPattern;

interface Command {
    public void execute();
}

class Light {
    public void on() {
        System.out.println("light is on");
    }
    public void off() {
        System.out.println("light is off");
    }
}

class LightOnCommand implements Command {
    Light light;
    public LightOnCommand(Light light) {
        this.light = light;
    }
    @Override
    public void execute() {
        light.on();
    }

}

class LightOffCommand implements Command {
    Light light;
    public LightOffCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.off();
    }
}

class Stereo {
    public void on() {
        System.out.println("Stereo is on");
    }
    public void off() {
        System.out.println("Stereo is off");
    }

    public void setCD() {
        System.out.println("Stereo is set " + "for CD input");
    }

    public void setDVD() {
        System.out.println("Stereo is set " + "for DVD input");
    }

    public void setRadio() {
        System.out.println("Stereo is set " + "for Radio");
    }

    public void setVolume(int volume) {
        System.out.println("Stereo is set" + " to " + volume);
    }

}

class StereoOffCommand implements Command {
    Stereo stereo;
    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }
    public void execute() {
        stereo.off();
    }
}

class StereoOnWithCDCommand implements Command {
    Stereo stereo;
    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }
    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }
}

// A Simple remote Control with One Button

class SimpleRemoteControl {
    Command slot; // only one button
    public SimpleRemoteControl() {

    }
    public void setCommand(Command command) {
        // Set the command to remote will
        // execute
        this.slot = command;
    }
    public void buttonWasPressed() {
        slot.execute();
    }
}
public class CommandPattern {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light();
        Stereo stereo = new Stereo();

        // after setting up the command in simple
        // simpleremoteobject we have command assigned to
        // its implemented classes
        // afer that we can execute the appropriate overridden method

        // we can change the command dynamically
        remote.setCommand(new LightOnCommand(light));
        remote.buttonWasPressed();
        remote.setCommand(new StereoOnWithCDCommand(stereo));
        remote.buttonWasPressed();
        remote.setCommand(new StereoOffCommand(stereo));
        remote.buttonWasPressed();
    }
}
