package DesignPatterns.Observer;


import java.util.ArrayList;
import java.util.List;


//// I am watching you
//// We need to be informed when certain things happens
//// -> Object's field changes
//// -> Object does something
//// -> Some external event occurs
//
//// We want to listen to events and notified when they occur
//// Typical pattern involves addXxxListener()
//// Java now has functional objects
//// -> Supplier<T>, Consumer<T>, Function<T>
//
///*
//An Observer is an object that wishes to be informed about events happening in the\
//system. The entity generating the events is an observable
// */
class PropertyChangeEventArgs<T> {
    public T source;
    public String propertyName;
    public Object newValue;
    public PropertyChangeEventArgs(T source, String propertyName, Object newValue) {
        this.source = source;
        this.propertyName = propertyName;
        this.newValue = newValue;
    }
}

interface Observer<T> {
    public void handle(PropertyChangeEventArgs<T> args);
}
class Observable<T> {
    private List<Observer<T>> observerList = new ArrayList<>();
    public void subscribe(Observer<T> observer) {
        observerList.add(observer);
    }
    public void propertyChanged(T source, String propertyName, Object newValue) {
        System.out.println("Ths is the number of propertyChanged Observers " + observerList.size());
        for(Observer<T> o: observerList) {
            o.handle(new PropertyChangeEventArgs<T>(source, propertyName, newValue));
        }
    }
}

class Person extends Observable<Person> {
    private int age;
    public void setAge(int age) {
        // if no change occurred for this case
        if(this.age == age) return;
        this.age = age;
        propertyChanged(this, "age", age);
    }

    public int getAge() {
        return age;
    }
}
public class Main implements Observer<Person> {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        Person person = new Person();
        person.subscribe(this);
        for(int i = 20; i < 24; i++) {
            person.setAge(i);
        }
    }
    @Override
    public void handle(PropertyChangeEventArgs<Person> args) {
            System.out.println("Property " + args.propertyName + " has changed to value "  + args.newValue);
    }

}
