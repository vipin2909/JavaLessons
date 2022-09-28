package JavaLesson14;

public class Lesson14 {
    public static void main(String[] args) {
        Animals genericAnimal = new Animals();
        System.out.println(genericAnimal.getName());
        System.out.println(genericAnimal.favFood);

        Cats morris = new Cats("morris", "Tuna", "Rubber Duck");
        System.out.println();
        System.out.println(morris.getName());
        System.out.println(morris.favFood);
        System.out.println(morris.favToy);

        // Every Cat is an Animal
        // Because Every Method and Field in Animals is in
        // the Class Cats

        // not every Animal is a Cat

        Animals tabby = new Cats("Tabby", "Salmon", "Ball");

        acceptAnimals(tabby);

    }

    public static void acceptAnimals(Animals randAnimal) {
        System.out.println();
        System.out.println(randAnimal.getName());
        System.out.println(randAnimal.favFood);
        System.out.println();

        randAnimal.walkAround();

        // if we want to access a field that is not present
        // in the parent class then you have to type cast
        // it into the respective class to acess that field

        // Ex.
        // Cats tempCats = ((Cats)randAnimal);
        // System.out.println(tempCat.favToy);
        // OR
        System.out.println(((Cats)randAnimal).favToy);

        if(randAnimal instanceof Cats) {
            System.out.println(randAnimal.getName() + " is a Cat");
        }
    }
}
