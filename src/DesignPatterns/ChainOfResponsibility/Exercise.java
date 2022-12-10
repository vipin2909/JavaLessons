package DesignPatterns.ChainOfResponsibility;

import java.util.List;
import java.util.ArrayList;


abstract class Creature2 {
    public abstract int getAttack();
    public abstract int getDefense();

}

class Goblin extends Creature2 {
    public Game2 game;
    public RootModifier modifier;
    public Goblin(Game2 game) {
        this.game = game;
        this.modifier = new RootModifier(this, game);
        modifier.add(new GoblingKingAttackBuff(this, game));
        modifier.add(new GoblinDefenseBuff(this, game));
    }

    private int getBaseAttack() {
        return 1;
    }

    private int getBaseDefense() {
        return 1;
    }

    @Override
    public int getAttack() {
        return modifier.handle(getBaseAttack(), Statistic.ATTACK);
    }

    @Override
    public int getDefense() {
        return modifier.handle(getBaseDefense(), Statistic.DEFENSE);
    }

}
interface CreatureStatisticModifier {
    void add(CreatureStatisticModifier next);
    int handle(int value, Statistic attack);
}

class RootModifier implements CreatureStatisticModifier {
    CreatureStatisticModifier next = null;
    Creature2 creature;
    Game2 game;
    RootModifier(Creature2 creature, Game2 game) {
        this.creature = creature;
        this.game = game;
    }

    @Override
    public void add(CreatureStatisticModifier newMod) {
        if(next != null) {
            next = newMod;
        }
        else {
            next.add(newMod);
        }

    }
    @Override
    public int handle(int value, Statistic stat) {
        if(next != null) {
            return next.handle(value, stat);
        }
        return value;
    }
}

class GoblingKingAttackBuff extends RootModifier {
    GoblingKingAttackBuff(Creature2 creature, Game2 game) {
        super(creature, game);
    }

    @Override
    public int handle(int value, Statistic stat) {
        int newValue = value;
        if(stat.equals(Statistic.ATTACK)) {
            for(Creature2 c: this.game.creatures) {
                if(c instanceof GoblinKing && c != this.creature) {
                    newValue++;
                }
            }
        }
        return super.handle(newValue, stat);
    }

}

class GoblinDefenseBuff extends RootModifier {
    GoblinDefenseBuff(Creature2 creature, Game2 game) {
        super(creature, game);
    }

    @Override
    public int handle(int value, Statistic stat) {
//        int newValue = value;
//        if(stat.equals(Statistic.DEFENSE)) {
//            for(Creature2 c: this.game.creatures) {
//                if(c instanceof Goblin && c != this.creature) {
//                    newValue++;
//                }
//            }
//        }
//        return super.handle(newValue, game);
        return 10;
    }

}

class GoblinKing extends Goblin {
    public GoblinKing(Game2 game) {
        super(game);
    }
    @Override
    public int getAttack() {
        return 3;
    }
    @Override
    public int getDefense() {
        return 3;
    }
}

class Game2 {
    public List<Creature2> creatures = new ArrayList<>();
}


enum Statistic {
    ATTACK, DEFENSE
}
public class Exercise {
}
