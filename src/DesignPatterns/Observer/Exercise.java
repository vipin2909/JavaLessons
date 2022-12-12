package DesignPatterns.Observer;


import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class Game {
    private List<Rat> rats = new ArrayList<>();

    Consumer<List<Rat>> modifyAttackValues = list -> list.stream().forEach(rat -> {
        rat.attack = list.size();
    });
    public void subscribe(Rat rat) {
        rats.add(rat);
        modifyAttackValues.accept(rats);
    }

    public void unsubscribe(Rat rat) {
        rats.remove(rat);
        modifyAttackValues.accept(rats);
    }

}

class Rat implements Closeable {
    private Game game;
    public int attack = 1;

    public Rat(Game game) {
        // todo: rat enters game here
        this.game = game;
        game.subscribe(this);
    }

    @Override
    public void close() throws IOException {
        game.unsubscribe(this);
    }
}
public class Exercise {
    public static void main(String[] args) {

        Game game = new Game();
        Rat r1 = new Rat(game);
        System.out.println(" r1 = " + r1.attack);
        Rat r2 = new Rat(game);
        System.out.println(" r1 = " + r1.attack + " r2 = " + r2.attack);
        try {
            r2.close();
        }
        catch(Throwable e) {
            e.printStackTrace();
        }

        System.out.println(" r1 = " + r1.attack);

    }
}

// Summary ->
// Observer is an intrusive approach: an observable must provid an event to subscribe to
// Special care must be taken to prevent issues in multithreaded scenarios
// Rx Uses -> (Reactive extensions)
// Obervable<T> / Observer<T>

