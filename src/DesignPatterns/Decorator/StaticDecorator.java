package DesignPatterns.Decorator;

import java.util.function.Supplier;

interface Shape1 {
    String info();
}


class Circle1 implements Shape1 {
    private float radius;

    public Circle1() { }

    public Circle1(float radius) {
        this.radius = radius;
    }

    void resize(float factor) {
        radius *= factor;
    }

    @Override
    public String info() {
        return "A Circle1 of radius " + radius;
    }
}

class Square1 implements Shape1 {
    private float side;

    public Square1() {
    }

    public Square1(float side) {
        this.side = side;
    }

    @Override
    public String info() {
        return "A Square1 of side " + side;
    }
}

class ColoredShape1<T extends Shape1> implements  Shape1 {
    private Shape1 Shape1;
    private String color;

    public ColoredShape1(Supplier<? extends T> ctor, String color) {
        Shape1 = ctor.get();
        this.color = color;
    }

    @Override
    public String info() {
        return Shape1.info() + " has the color " + color;
    }
}

class TransparentShape1<T extends Shape1> implements Shape1 {
    private Shape1 Shape1;
    private int transparency;

    public TransparentShape1(Supplier<? extends T> ctor, int transparency) {
        Shape1 = ctor.get();
        this.transparency = transparency;
    }
    @Override
    public String info() {
        return Shape1.info() + " has " + transparency + " % transparency";
    }
}

public class StaticDecorator {
    public static void main(String[] args) {
        ColoredShape1<Square1> blueSquare = new ColoredShape1<>(() -> new Square1(20), "Blue");
        System.out.println(blueSquare.info());

        TransparentShape1<ColoredShape1<Circle1>> myCircle = new TransparentShape1<>(() -> new ColoredShape1<>(() -> new Circle1(5), "Green"), 90);
        System.out.println(myCircle.info());
    }
}
