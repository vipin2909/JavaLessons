package DesignPatterns.Decorator;

interface Shape {
    String info();
}


class Circle implements Shape {
    private float radius;

    public Circle() { }

    public Circle(float radius) {
        this.radius = radius;
    }

    void resize(float factor) {
        radius *= factor;
    }

    @Override
    public String info() {
        return "A Circle of radius " + radius;
    }
}

class Square implements Shape {
    private float side;
    public Square() {
    }

    public Square(float side) {
        this.side = side;
    }

    @Override
    public String info() {
        return "A square of side " + side;
    }
}

class ColorShape implements Shape {
    private Shape shape;
    private String color;

    public ColorShape(Shape shape, String color) {
        this.shape = shape;
        this.color = color;
    }
    @Override
    public String info() {
        return shape.info() + " has the color " + color;
    }
}

class TransparentShape implements Shape {
    private Shape shape;
    private int transparency;

    public TransparentShape(Shape shape, int transparency) {
        this.shape = shape;
        this.transparency = transparency;
    }
    @Override
    public String info() {
        return shape.info() + " has " + transparency + "% transparency";
    }
}
public class DynamicDecorator {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        System.out.println(circle.info());

        ColorShape blueSquare = new ColorShape(new Square(20), "BLUE");
        System.out.println(blueSquare.info());

        TransparentShape greenCircle = new TransparentShape(new ColorShape(new Circle(5), "GREEN"), 50);
        System.out.println(greenCircle.info());
    }
}
