package JavaLesson15;

public interface Drivable {
    // interfaces are adjectives
    // because objects are nouns and if we want to
    // modify nouns we use adjectives
    // Basically interface is an empty class
    // that tells someone or provides some one what methods
    // they must implement

    // fields are final inside interface

    // methods are by default are
    // public abstract int getWheel();

    double PI = 3.14;
    int getWheel();
    double getSpeed();
    void setWheels(int numWheels);
    void setSpeed(double speed);
}
