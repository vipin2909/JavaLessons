import JavaLesson15.Vehicle;

public class Lesson16 {
    public static void main(String[] args) {
        Object superCar = new Vehicle();
        System.out.println(((Vehicle)superCar).getSpeed());

        Vehicle superTruck = new Vehicle();
        System.out.println(superCar.equals(superTruck));

        // every time we create a object we create a unique identifier
        // is called hashCode();


//        Vehicle superBus = new Vehicle();
//        System.out.println(superBus.equals(superTruck));  result-> false

        System.out.println(superCar.hashCode());
        // there is another function called finalize inside java
        // and what is does is it actually a method that tha java garbage collector calls
        // whenever you not longer need an object in memory
        // and it goes and cleans it up and get rid of extra space


        System.out.println(superCar.getClass());
        System.out.println(superCar.getClass().getName());
        if(superCar.getClass() == superTruck.getClass()) {
            System.out.println("The Same");
        }
        System.out.println();
        System.out.println(superCar.getClass().getSuperclass());

        System.out.println(superCar.toString());
        int randNum = 100;
        System.out.println(Integer.toString(randNum));

        // Clone Method
        // what clone allows us to do is to copy the current values and
        // everything of an object at a certain point of time and assign it to another
        // if we make change in new cloned object it is not gonna affect
        // the previous object properties

        // it is exactly what it is its a clone

        superTruck.setWheels(6);
        Vehicle superTruck2 = (Vehicle)superTruck.clone();
        System.out.println(superTruck.getWheel());
        System.out.println(superTruck2.getWheel());

        superTruck2.setWheels(89);
        System.out.println(superTruck2.getWheel());
        System.out.println(superTruck.getWheel());

        System.out.println();
        System.out.println(superTruck2.hashCode());
        System.out.println(superTruck.hashCode());
    }
}
