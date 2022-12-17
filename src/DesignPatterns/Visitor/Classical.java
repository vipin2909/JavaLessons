package DesignPatterns.Visitor;


interface ExpressionVisitor {
    void visit(DoubleExpression e);
    void visit(AdditionExpression e);
    void visit(SubtractionExpression e);
}
// every single element in hierarchy now has to accept ExpressionVisitor
abstract class Expression {
    public abstract void accept(ExpressionVisitor visitor);
}

class DoubleExpression extends Expression {
    public double value;
    public DoubleExpression(double value) {
        this.value = value;
    }
    @Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }
}

class AdditionExpression extends Expression {
    public Expression left, right;
    public AdditionExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }

}


// try to do things on your own so that u can understand the code better
// try to implement codes and do things on your own
class SubtractionExpression extends Expression {
    Expression left, right;
    public SubtractionExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }
}

//class ExpressionPrinter {
//    public static void print(Expression e, StringBuilder sb) {
//        if(e.getClass() == DoubleExpression.class) {
//            sb.append(((DoubleExpression)e).value);
//        }
//        else if(e.getClass() == AdditionExpression.class) {
//            AdditionExpression ae = (AdditionExpression)e;
//            sb.append("(");
//            print(ae.left, sb);
//            sb.append("+");
//            print(ae.right, sb);
//            sb.append(")");
//
//            //
//        }
//    }
////    public static void print(AdditionExpression ae, StringBuilder sb) {
////
////    }
//}


class ExpressionPrinter implements ExpressionVisitor {

    private StringBuilder sb = new StringBuilder();

    @Override
    public void visit(DoubleExpression e) {
        sb.append(e.value);
    }
    @Override
    public void visit(AdditionExpression e) {
        sb.append("(");
        e.left.accept(this);
        sb.append("+");
        e.right.accept(this);
        sb.append(")");
    }

    @Override
    public void visit(SubtractionExpression e) {
        sb.append("(");
        e.left.accept(this);
        sb.append("-");
        e.right.accept(this);
        sb.append(")");
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}

class ExpressionCalculator implements ExpressionVisitor {
    public double result;
    @Override
    public void visit(DoubleExpression e) {
        result = e.value;
    }
    public void visit(AdditionExpression e) {
        e.left.accept(this);
        double a = result;
        e.right.accept(this);
        double b = result;
        result = a+b;
    }

    public void visit(SubtractionExpression e) {
        e.left.accept(this);
        double a = result;
        e.right.accept(this);
        double b = result;
        result = a - b;
    }

    @Override
    public String toString() {
        return "" + result;
    }
}
public class Classical {
    public static void main(String[] args) {
        // 1 + (2+3)
        AdditionExpression e = new AdditionExpression(new DoubleExpression(1), new AdditionExpression(
                new DoubleExpression(2),
                new DoubleExpression(3)
        ));

//        StringBuilder sb = new StringBuilder();
//        ExpressionPrinter ep = new ExpressionPrinter();
//        ep.print(e, sb);
//        System.out.println(sb.toString());

//        ExpressionPrinter ep = new ExpressionPrinter();
//        ep.visit(e);
//        System.out.println(ep);

        // (1+(2-(3+4)));
        ExpressionCalculator ec = new ExpressionCalculator();
        AdditionExpression additionExpression = new AdditionExpression(
                new DoubleExpression(1), new SubtractionExpression(new DoubleExpression(2), new AdditionExpression(
                        new DoubleExpression(3), new DoubleExpression(4)
        ))
        );
        ExpressionPrinter ep = new ExpressionPrinter();
        ep.visit(additionExpression);
        System.out.println(ep);
        ec.visit(additionExpression);
        System.out.println(ec);
    }
}

