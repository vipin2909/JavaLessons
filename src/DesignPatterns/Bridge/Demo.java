package DesignPatterns.Bridge;

// Shape -> Circle, Square
// Rendering -> Vector, Raster

// VectorCircleRenderer, VectorSquareRenderer, RasterCircleRenderer

interface Renderer {
    void renderCircle(float radius);
}

class VectorRenderer implements Renderer {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing a circle of radius " + radius);
    }
}

class RasterRender implements Renderer {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing pixels for a circle " + " of radius ");
    }
}

abstract class Shape {
    protected Renderer renderer;
    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract void draw();
    public abstract void resize(float factor);
}

class Circle extends Shape {

    public float radius;

    public Circle(Renderer renderer) {
        super(renderer);
    }

    public Circle(Renderer renderer, float radius) {
        super(renderer);
        this.radius = radius;
    }
    @Override
    public void draw() {
        renderer.renderCircle(radius);
    }
    @Override
    public void resize(float factor) {
        radius *= factor;
    }
}

//class ShapeModule extends AbstractModule {
//    @Override
//    protected void configure() {
//        bind(Renderer.class).to(VectorRenderer.class);
//    }
//}
public class Demo {
    public static void main(String[] args) {
        RasterRender raster = new RasterRender();
        VectorRenderer vector = new VectorRenderer();
        Circle circle = new Circle(vector, 5);
        circle.draw();
        circle.resize(2);
        circle.draw();

        //Injector injector = Guice.createInjector(new ShapeModule());
        //Circle instance = injector.getInstance(Circle.class);
        // instance.radius = 3;
        // instance.draw();
        // instance.resize(2
;    }
}