package JavaLesson15;

public class Vehicle extends Crashable implements Drivable, Cloneable {
   int noOfWheels = 2;
   double theSpeed = 0;
   int carStrength = 0;
    @Override
    public int getWheel() {
        return noOfWheels;
    }

    @Override
    public void setWheels(int numWheels) {
        this.noOfWheels = numWheels;
    }

    @Override
    public double getSpeed() {
        return theSpeed;
    }

    @Override
    public void setSpeed(double speed) {
        theSpeed = speed;
    }

    @Override
    public void setCarStrength(int carStrength) {
        this.carStrength = carStrength;
    }

    @Override
    public int getCarStrength() {
        return this.carStrength;
    }

    public Vehicle() {

    }

    public Vehicle(int wheels, double speed) {
        this.noOfWheels = wheels;
        this.theSpeed = speed;
    }

    @Override
    public String toString() {
        return "Num of Wheels: " + this.noOfWheels;
    }

    public Object clone() {
        Vehicle car;
        try {
            car = (Vehicle) super.clone();
        }
        catch(CloneNotSupportedException e) {
           return null;
        }

        return car;

    }
}
