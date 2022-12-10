package DesignPatterns.ChainOfResponsibility;


// in this example next field works like Linked List examples
// because same in linked list the next filed stored a complete
// new Linked List where in this example this stores CreatureModifier

class Creature {
	
	public String name;
	public int attack, defense;

	public Creature(String name, int attack, int defense) {
		this.name = name;
		this.attack = attack;
		this.defense = defense;
	}

	@Override 
	public String toString() {
		return "Creature{" + 
			"name='" + name + '\'' + 
			", attack=" + attack + 
			", defense=" + defense + 
			"}";
	}
}

class CreatureModifier {
	
	protected Creature creature;
	protected CreatureModifier next;

	public CreatureModifier(Creature creature) {
		this.creature = creature;
	}

	public void add(CreatureModifier cm) {
		if(next != null) {
			next.add(cm);
		}
		else next = cm;
	}
	public void handle() {
		
		if(next != null) {
			next.handle();
		}
	}
}

class DoubleAttackModifier extends CreatureModifier {
	
	public DoubleAttackModifier(Creature creature) {	
		super(creature);
	}

	@Override
	public void handle() {
		System.out.println("Doubling " + creature.name + "'s attack");
		creature.attack *= 2;
		super.handle();
	}
}
class IncreaseDefenseModifier extends CreatureModifier {
	
	public IncreaseDefenseModifier(Creature creature) {		
		super(creature);
	}
	@Override 
	public void handle() {
		System.out.println("Increasing " + creature.name + "'s defense");
		creature.defense += 3;
		super.handle();
	}

}


class NoBonusesModifier extends CreatureModifier {
	public NoBonusesModifier(Creature creature) {
		super(creature);
	}

	@Override
	public void handle() {
		// nothing
		System.out.println("No Bonuses for you");
		// you have to call it to apply entire chain of responsibility
		//		super.handle();
	}
}

	
public class MethodChain {
	
	public static void main(String[] args) {
		Creature goblin = new Creature("goblin", 2, 3);
		System.out.println(goblin);

		CreatureModifier root = new CreatureModifier(goblin);

		root.add(new NoBonusesModifier(goblin));
		System.out.println("Let's double goblin's attack...");

		root.add(new DoubleAttackModifier(goblin));

		System.out.println("Let's increase goblin's defense");
		root.add(new IncreaseDefenseModifier(goblin));
		
		root.handle();
		System.out.println(goblin);


	}

}

			
