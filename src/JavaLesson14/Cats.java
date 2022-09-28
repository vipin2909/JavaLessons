package JavaLesson14;

public class Cats extends Animals {
    public String favToy = "Yarn";

    public void playwith() {
        System.out.println("Yeah " + favToy);
    }

    @Override
    public void walkAround() {
        System.out.println(getName() + " stalks around");
    }

    public String getFavToy() {
        return this.favToy;
    }

    public Cats() {

    }
    public Cats(String name, String favFood, String favToy) {
        super(name, favFood);
        this.favToy = favToy;
    }
}
