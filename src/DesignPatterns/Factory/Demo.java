package DesignPatterns.Factory;

// Object Creation logic becomes too convoluted
// Constructors are not descriptive enough
// - Name mandated by name of containing type
// - Cannot overload with same sets of arguments with different names
// - can turn into overloading hell
// Wholesale Object creation (non-piecewise, unlike Builder) can be outsourced
// - A Seprate function (Factory Method)
// - That may exist in a seprate class (Factory)
// - Can be heirarchy of factories with abstract Factory



// Factory -> A component responsible solely for the wholesale
// (not piecewise) creation of objects.

enum CoordinateSystem {
    CARTESIAN,
    POLAR
}

class Point {
    private double x, y;

    /**
     *
     * @param x is x if cartesian and rho if polar
     * @param y
     * @param cs
     */
    private Point(double x, double y, CoordinateSystem cs) {
        switch(cs) {
            case CARTESIAN:
                this.x = x;
                this.y = y;
                break;
            case POLAR:
                this.x = x * Math.cos(y);
                this.y = x * Math.sin(y);
                break;
        }
    }

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point newCartesianPoint(double x, double y) {
        return new Point(x, y);
    }

    public static Point newPolarPoint(double rho, double theta) {
        return new Point(rho * Math.cos(theta),
                rho * Math.sin(theta));
    }



//    @Override
//    public String toString() {
//
//    }


//    public Point(double rho, double theta) {
//        x = rho * Math.cos(theta);
//        y = rho * Math.sin(theta);
//    }

}
public class Demo {
    public static void main(String[] args) {
        Point point = Point.newPolarPoint(2, 3);
    }
}


class PointFactory {
//    public static Point newCartesianPoint(double x, double y) {
//        return new Point(x, y);
//    }
//
//    public static Point newPolarPoint(double rho, double theta) {
//        return new Point(rho * Math.cos(theta),
//                rho * Math.sin(theta));
//    }
}