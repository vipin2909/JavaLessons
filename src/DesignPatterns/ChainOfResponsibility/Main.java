package DesignPatterns.ChainOfResponsibility;


// cor + observer + mediator + (-) memento

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

// think everything like a real world entity
// creature -> think of its associated properties

class Event<Args> {
    // which is going to notify us on queries
    // ability to subscribe to an event unsubscribe to an event and fire an event
    private int index = 0;
    private Map<Integer, Consumer<Args>> handlers = new HashMap<>();
    public int subscribe(Consumer<Args> handler) {
        int i = index;
        handlers.put(index++, handler);
        return i;
    }

    public void unsubscribe(int key) {
        handlers.remove(key);
    }

    public void fire(Args args) {
        for(Consumer<Args> handler: handlers.values()) {
            handler.accept(args);
        }
    }
}

class Query {
    public String creatureName;
    enum Argument {
        ATTACK, DEFENSE
    }
    public Argument argument;
    public int result;

    public Query(String creatureName, Argument argument, int result) {
        this.creatureName = creatureName;
        this.argument = argument;
        this.result = result;
    }
}

// all creatures are participating in some kind of game

class Game {
    // this is a class which accepts arguments
    public Event<Query> queries = new Event<>();

}
class Creature01 {
    private Game game;
    public String name;
    public int baseAttack, baseDefense;

    public Creature01(Game game, String name, int baseAttack, int baseDefense) {
        this.game = game;
        this.name = name;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
    }

    int getAttack() {
        Query q = new Query(name, Query.Argument.ATTACK, baseAttack);
        game.queries.fire(q);
        return q.result;
    }

    int getDefense() {
        Query q = new Query(name, Query.Argument.DEFENSE, baseDefense);
        game.queries.fire(q);
        return q.result;
    }



}



public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
