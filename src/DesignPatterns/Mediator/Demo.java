package DesignPatterns.Mediator;

// communication between two components

// Components may go in and out of a system at any time
// -> // Chat room participants
// -> // Players in MMORPG

// It Makes no sense for them to have direct reference to one another
// -> // Those references may go dead

// Solution: have then all refer to some central component that facilitates communication


// A Mediator is A Component that facilitates communication between other components without them necessarily being aware of each other or having direct (reference) access to each other

// This code is chat room code


// Create the mediator and have each object in the system refer to it
// Mediator engages in bidirectional communication with its connected components
// Mediator has functions that components can call
// Components have functions mediators can call
// Event processing (Reactive) libraries make communication easier to implement



import java.util.ArrayList;
import java.util.List;

class Person {
    public String name;
    public ChatRoom room;
    private List<String> chatLog = new ArrayList<>();
    public Person(String name) {
        this.name = name;
    }
    public void receive(String sender, String message) {
        String s = sender + ": '" + message + "'";
        System.out.println("["+name+"'s Chat Session] "+ s);
        chatLog.add(s);
    }

    public void say(String message) {
        room.broadCast(name, message);
    }

    public void privateMessage(String who, String message) {
        room.message(name, who, message);
    }
}

class ChatRoom {
    private List<Person> people = new ArrayList<>();

    public void join(Person p) {
        String joinMessage = p.name + " joins the room";
        broadCast("room", joinMessage);
        p.room = this;
        people.add(p);
    }
    public void broadCast(String source, String message) {
        for(Person person: people) {
            if(!person.name.equals(source)) {
                person.receive(source, message);
            }
        }
    }
    public void message(String source, String destination, String message) {
        people.stream().filter(p -> p.name.equals(destination)).findFirst().ifPresent(person -> person.receive(source, message));
    }
}
public class Demo {
    public static void main(String[] args) {
        ChatRoom room = new ChatRoom();
        Person john = new Person("john");
        Person jane = new Person("jane");
        room.join(john);
        room.join(jane);
        john.say("hi room");
        jane.say("oh, hey john");
        Person simon = new Person("simon");
        room.join(simon);
        simon.say("hi everyone");

        jane.privateMessage("simon", "Glad, you could join us");
    }


}
