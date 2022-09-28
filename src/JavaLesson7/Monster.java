package JavaLesson7;

public class Monster {
    public final String TOMBSTONE = "Here Lies a Dead Monster";

    private int health = 500;
    private int attack = 20;
    private int movement = 2;
    private int xPosition = 0;
    private int yPosition = 0;
    private boolean alive = true;

    public String name = "Big Monster";

    public int getAttack() {
        return attack;
    }

    public int getMovement() {
        return movement;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int decreaseHealth) {
        health = health - decreaseHealth;
        if(health < 0) {
            alive = false;
        }
    }

    public void setHealth(double decrease) {
        int decreaseHealth = (int) decrease;
        health = health = decreaseHealth;
        if(health < 0) {
            alive = false;
        }
    }

    public Monster(int newHealth, int newAttack, int newMovement) {
        health = newHealth;
        attack = newAttack;
        movement = newMovement;
    }
    // Default constructor -> method exists but doesn't do anything
    public Monster() {

    }

    public Monster(int newHealth) {
        health = newHealth;
    }

    public Monster(int newHealth, int newAttack) {
        // the below call calls the above constructor
        // this keyword is a reference to the constructor inside
        // a class
        this(newHealth);
        attack = newAttack;
    }

    public static void main(String[] args) {
        Monster frank = new Monster();

        // here we can access attack instance variable which is private
        // because we are accessing it in same class
        System.out.println(frank.attack);
    }

}
