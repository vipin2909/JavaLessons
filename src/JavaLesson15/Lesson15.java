package JavaLesson15;

// java does not allow you to inherit from multiple classes
// in this case we are using interface
public class Lesson15 {
    public static void main(String[] args) {
        Vehicle car = new Vehicle(4, 100.00);

        System.out.println("Cars Max Speed. " + car.getSpeed());
        System.out.println("Num Of Wheels " + car.getWheel());

        car.setCarStrength(10);
        System.out.println("Strength: " + car.getCarStrength());
    }
}
