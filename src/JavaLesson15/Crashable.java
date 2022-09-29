package JavaLesson15;

// an abstract class is used when we don't have to implement
// every method necessarily to use the abstract class
public abstract class Crashable {
    // this is not constant like interface i.e this is a value that can change
    boolean carDrivable = true;

    public void youCrashed() {
        this.carDrivable = false;
    }

    public abstract void setCarStrength(int carStrength);

    public abstract int getCarStrength();

}
