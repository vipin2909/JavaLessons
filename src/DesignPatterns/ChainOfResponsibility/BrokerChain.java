package DesignPatterns.ChainOfResponsibility;

// COMMAND QUERY SEPRATION
// Commans => asking for an action or change(e.g. please set your attack v// alue to 2)
// Query => asking for information (e.g please give me your attack value)
// CQS => having seprate means of sending commands and queries e.g direct // field access


// cor + observer + mediator + (-) momento

//class Event<Args> {
//	private int index;
//	private Map<Integer, Consumer<Args>> handlers = new HashMap<>();
//
//	public int subscribe(Consumer<Args> handler) {
//		int i = index;
//		handlers.put(index++, handler);
//		return i;
//	}
//
//	public void unsubscribe(int key) {
//		handlers.remove(key);
//	}
//	public void fire(Args args) {
//		for(Consumer<Args> handler: handlers.values()) {
//			handler.accept(args);
//		}
//	}
//}
//
//class Query {
//	public String creatureName;
//	enum Argument {
//		ATTACK, DEFENSE;
//	}
//	public Argument argument;
//	public int result;
//	public Query(String creatureName, Argument argument, int result) {
//		this.creatureName = creatureName;
//		this.argument = argument;
//		this.result = result;
//	}
//
//}
//
//class Game {
//	public Event<Query> queries = new Event<>();
//}
//
//class Creature {
//	private Game game;
//	public String name;
//	public int baseAttack, baseDefense;
//	public Creature(Game game, String name, int baseAttack, int baseDefense) {
//		this.game = game;
//		this.name = name;
//		this.baseAttack = baseAttack;
//		this.baseDefense = baseDefense;
//	}
//
//	int getAttack() {
//		Query q = new Query(name, Query.Argument.ATTACK, baseAttack);
//		game.queries.fire(q);
//		return q.result;
//	}
//
//	int getDefense() {
//		Query q = new Query(name, Query.Argument.DEFENSE, baseDefense);
//		game.queries.fire(q);
//		return q.result;
//	}
//	@Override
//	public String toString() {
//		return "Creature{"+
//				"name='"+name+'\''+
//				", attack="+getAttack()+
//				", defense="+getDefense()+
//				"}";
//	}
//
//}
//
//class CreatureModifer {
//	protected Game game;
//	protected Creature creature;
//
//	public CreatureModifer(Game game, Creature creature) {
//		this.game = game;
//		this.creature = creature;
//	}
//}
//
//class DoubleAttackModifier extends CreatureModifier implements AutoCloseable {
//	private final int token;
//	public DoubleAttackModifier(Game game, Creature creature) {
//		super(game, creature);
//		token = game.queries.subscribe(q -> {
//			if(q.creatureName.equals(creature.name) && q.argument == Query.Argument.ATTACK) {
//				q.result *= 2;
//			}
//		});
//	}
//
//	@Override
//	public void close() throws Exception {
//		game.queries.unsubscribe(token);
//	}
//
//}


class Creature1 {
	public String name;
	public int attack, defense;

	public Creature1(String name,int attack, int defense) {
		this.name = name;
		this.attack = attack;
		this.defense = defense;
	}

	@Override
	public String toString() {
		return "Creature{"+
				"name='"+name+'\''+
				", attack="+attack+
				", defense="+defense+
				"}";
	}
}
class CreatureModifier1 {
	public Creature1 creature;
	public CreatureModifier1 next;

	public CreatureModifier1(Creature1 creature) {
		this.creature = creature;
	}

	public void add(CreatureModifier1 cm) {
		if(next != null) {
			next.add(cm);
		}
		else {
			this.next = cm;
		}
	}

	public void handle() {
		if(next != null) {
			next.handle();
		}
	}
}

class DoubleAttackModifier1 extends CreatureModifier1 {
	public DoubleAttackModifier1(Creature1 creature) {
		super(creature);
	}

	@Override
	public void handle() {
		System.out.println("Doubling the attack's value");
		creature.attack *= 2;
		super.handle();
	}
}

class IncreaseDefenseModifier1 extends CreatureModifier1 {
	public IncreaseDefenseModifier1(Creature1 creature) {
		super(creature);
	}

	@Override
	public void handle() {
		System.out.println("Increasing " + creature.name + "'s defense");
		creature.defense += 3;
		super.handle();
	}
}

public class BrokerChain {

	public static void main(String[] args) {
		Creature1 goblin = new Creature1("goblin", 2, 3);
		System.out.println(goblin);

		CreatureModifier1 root = new CreatureModifier1(goblin);

		System.out.println("Let's double goblins attack...");
		root.add(new DoubleAttackModifier1(goblin));

		System.out.println("Let's increase goblin's defense");
		root.add(new IncreaseDefenseModifier1(goblin));

		root.handle();
		System.out.println(goblin);
	}
}

