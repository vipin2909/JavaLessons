package DesignPatterns.Template;

class A {
    protected int attack;
    protected int health;
    public A(int attack, int health) {
        this.attack = attack;
        this.health = health;
    }
//    public A() {
//
//    }
    @Override
    public String toString() {
        return "{Attack="+attack+", Health="+health+"}";
    }
}

class B extends A {
    public B(int attack, int health) {
        super(attack, health);
    }

    private void printHello() {
        System.out.println("Hello");
    }

}
public class Demo {
    public static void main(String[] args) {
        A aObj = new B(30, 20);
        System.out.println(aObj);
    }
}
