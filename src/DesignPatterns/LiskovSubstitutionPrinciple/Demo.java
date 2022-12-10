package DesignPatterns.LiskovSubstitutionPrinciple;

// For explicit construction of Ractangle and Square we need to use Factory Method

// Liskov Substitution Principle is you should be able
// to substitute subclass as base class
// In this example square is subclass which need to be replaced in place of
// Ractangle
class Ractangle {
    protected int width, height;
    public Ractangle() {

    }
    public Ractangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return height * width;
    }


    @Override
    public String toString() {
        return "Ractangle{"+"width="+width+"height="+height+"}";
    }

    public boolean isSquare() {
        return width == height;
    }
}


class Square extends Ractangle {
    public Square() {
    }
    public Square(int size) {
        width = height = size;
    }
    @Override
    public void setWidth(int width) {
        super.setHeight(width);
        super.setWidth(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }
}

class RactangleFactory {
    public static Ractangle newRactangle(int width, int height) {
        return new Ractangle(width, height);
    }

    public static Ractangle newSquare(int side) {
        return new Ractangle(side, side);
    }
}

public class Demo {
    static void useIt(Ractangle r) {
        int width = r.getWidth();
        r.setHeight(10);

        // area = width * 10;
        System.out.println("Expected area of " + (width * 10) + ", got " + r.getArea());
    }

    public static void main(String[] args) {
        Ractangle rc = new Ractangle(2, 3);
        useIt(rc);

        Ractangle sq = new Square();
        sq.setWidth(5);
        useIt(sq);
    }
}

