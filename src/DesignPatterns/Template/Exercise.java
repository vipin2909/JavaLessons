package DesignPatterns.Template;

class Creature {
    public int attack, health;
    public Creature(int attack, int health) {
        this.attack = attack;
        this.health = health;
    }

}

abstract class CardGame {
    public Creature[] creatures;
    public CardGame(Creature[] creatures) {
        this.creatures = creatures;
    }

    public int combat(int creature1, int creature2) {
        Creature first = creatures[creature1];
        Creature second = creatures[creature2];
        hit(first, second);
        hit(second, first);
        if((first.health > 0 && second.health > 0) || (first.health <= 0 && second.health <= 0)) {
            return -1;
        }
        else {
            return first.health <= 0 ? 2 : 1;
        }
    }

    protected abstract void hit(Creature attacker, Creature other);
}

class TemporaryCardDamageGame extends CardGame {
    public TemporaryCardDamageGame(Creature[] creatures) {
        super(creatures);
    }
    @Override
    public void hit(Creature attacker, Creature other) {
        if(attacker.attack >= other.health) {
            other.health = 0;
        }
    }
}

class PermanentCardDamageGame extends CardGame {
    public PermanentCardDamageGame(Creature[] creatures) {
        super(creatures);
    }

    @Override
    public void hit(Creature attacker, Creature other) {
        other.health -= attacker.attack;
    }
}
public class Exercise {
    public static void main(String[] args) {
        Creature creature1 = new Creature(2, 2);
        Creature creature2 = new Creature(2, 3);
        PermanentCardDamageGame game = new PermanentCardDamageGame(new Creature[]{creature1, creature2});
        int winner = game.combat(0, 1);
        System.out.println("The Winner Player is " + winner);
    }
}

// Define an algorithm at high level
// Define constituent parts as abstract methods/properties
// inherit the algorithm class, providing necessary overrides

