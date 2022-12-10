package DesignPatterns.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class GraphObject {
    protected String name = "Group";

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public GraphObject() {

    }
    public String color;
    // when any class has list of its objects
    // it become recursive object class
    public List<GraphObject> children = new ArrayList<>();

    private void print(StringBuilder stringBuilder, int depth) {
        stringBuilder.append(String.join("", Collections.nCopies(depth, "*"))).append(depth > 0 ? " " : "")
                .append((color == null || color.isEmpty()) ? "" : color + " ")
                .append(getName())
                .append(System.lineSeparator());
        for(GraphObject child: children) {
            child.print(stringBuilder, depth+1);
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        print(sb, 0);
        return sb.toString();
    }
}

class Circle extends GraphObject {
    public Circle(String color) {
        name = "Circle";
        this.color = color;
    }
}

class Square extends GraphObject {
    public Square(String color) {
        name = "Square";
        this.color = color;
    }
}
public class Geometry {
    public static void main(String[] args) {
        GraphObject drawing = new GraphObject();
        drawing.setName("My Drawing");
        drawing.children.add(new Square("Red"));
        drawing.children.add(new Circle("Yellow"));

        GraphObject group = new GraphObject();
        group.children.add(new Circle("Blue"));
        group.children.add(new Square("Blue"));
        drawing.children.add(group);

        System.out.println(drawing);

    }
}