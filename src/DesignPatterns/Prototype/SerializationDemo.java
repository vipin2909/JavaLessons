package DesignPatterns.Prototype;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

class Foo implements Serializable {
    public int stuff;
    public String whatever;

    public Foo(int stuff, String whatever) {
        this.stuff = stuff;
        this.whatever = whatever;
    }

    @Override
    public String toString() {
        return "Foo{"+
                "stuff="+stuff+
                ", whatever='"+whatever+'\''+
                "}";
    }
}
public class SerializationDemo {
    public static void main(String[] args) {
        Foo foo = new Foo(42, "life");
        Foo foo2 = SerializationUtils.clone(foo);

        foo2.whatever = "xyz";
        System.out.println(foo);
        System.out.println(foo2);
    }

}
