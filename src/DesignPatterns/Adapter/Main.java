package DesignPatterns.Adapter;

class A {
    public void print() {
        System.out.println("PRINT A");
    }
}

class B extends A {
    public void print() {
        System.out.println("PRINT B");
    }
}

class C extends B {
    public void print() {
        System.out.println("PRINT C");
    }
}

public class Main {
    public static void main(String[] args) {
        C c = new C();
        c.print();
        B b = new B();
        b.print();
        A a = new A();
        a.print();
        A ab = new B();
        ab.print();
        B bc = new C();
        bc.print();
//        C ca = new A();
//        ((C)ca).print();
    }
}