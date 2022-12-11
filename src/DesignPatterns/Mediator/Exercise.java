package DesignPatterns.Mediator;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class Partcipant {
    public int value;
    public Mediator mediator;

    public Partcipant(Mediator mediator) {
        this.value = 0;
        this.mediator = mediator;
        mediator.join(this);
    }

    public void say(int n) {
        mediator.broadCast(this, n);
    }

    public void message(int n) {
        this.value += n;
    }

}

class Mediator {
    List<Partcipant> list = new ArrayList<>();

    public void join(Partcipant p) {
        list.add(p);
    }

    public void broadCast(Partcipant p, int value) {
        list.stream().filter(pe -> !pe.equals(p)).forEach(pa -> pa.message(value));
    }
}
public class Exercise {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        Partcipant p1 = new Partcipant(mediator);
        Partcipant p2 = new Partcipant(mediator);
        Partcipant p3 = new Partcipant(mediator);

        p1.say(3);
        p2.say(2);
        p3.say(1);

        System.out.println("p1 value " + p1.value);
        System.out.println("p2 value " + p2.value);
        System.out.println("p3 value " + p3.value);
    }

    @Test
    public void test() {
        Mediator mediator = new Mediator();
        Partcipant p1 = new Partcipant(mediator);
        Partcipant p2 = new Partcipant(mediator);
        Partcipant p3 = new Partcipant(mediator);
        p1.say(10);
        p2.say(20);
        p3.say(30);
        Assert.assertEquals(50, p1.value);
        Assert.assertEquals(40, p2.value);
        Assert.assertEquals(30, p3.value);
    }
}
