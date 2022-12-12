package DesignPatterns.Observer;

// This code is of an Event class

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

class Event<TArgs> {
    private int count = 0;
    private Map<Integer, Consumer<TArgs>> handlers = new HashMap<>();
    public Subscription addHanlder(Consumer<TArgs> handler) {
        int i = count;
        handlers.put(count++, handler);
        return new Subscription(this, i);
    }

    public void fire(TArgs args) {
        for(Consumer<TArgs> handler: handlers.values()) {
            handler.accept(args);
        }
    }

    public class Subscription implements AutoCloseable {
        private Event<TArgs> event;
        private int id;

        public Subscription(Event<TArgs> event, int id) {
            this.event = event;
            this.id = id;
        }
        @Override
        public void close() /* throws Exception */ {
            event.handlers.remove(id);
        }
    }
}

class PropertyChangedEventArgs {
    public Object source;
    public String propertyName;
    public PropertyChangedEventArgs(Object source, String propertyName) {
        this.source = source;
        this.propertyName = propertyName;
    }

}

class Person1 {
    public Event<PropertyChangedEventArgs> propertyChanged = new Event<>();
    private int age;
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if(this.age ==  age) {
            return;
        }
        boolean oldCanVote = getCanVote();
        this.age = age;
        propertyChanged.fire(new PropertyChangedEventArgs(this, "age"));

        if(oldCanVote != getCanVote()) {
            propertyChanged.fire(new PropertyChangedEventArgs(this, "canVote"));
        }
    }
    public boolean getCanVote() {
        return age >= 18;
    }
}

public class Demo {
    public static void main(String[] args) {
        Person1 person = new Person1();
        Event<PropertyChangedEventArgs>.Subscription sub = person.propertyChanged.addHanlder(x -> {
            System.out.println("Person's " + x.propertyName + " has changed!");
        });
        person.setAge(17);
        person.setAge(18);
        sub.close();
        person.setAge(19);


    }
}