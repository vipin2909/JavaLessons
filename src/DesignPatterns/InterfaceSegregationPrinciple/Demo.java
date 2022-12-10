package DesignPatterns.InterfaceSegregationPrinciple;

class Document {

}

// Absolute sticking everything into one interface is
// not so good, we should put minimum amount of code in
// interface, at no point do they have to implement certain method that they don't need

// Interface Segregation Principle -> states that how
// to split interfaces into smaller interfaces

// you don't put more code into your inteface then
// expected

interface Machine {
    void print(Document d);
    void fax(Document d);
    void scan(Document d);
}

class MultiFunctionalPrinter implements Machine {

    @Override
    public void print(Document d) {

    }

    @Override
    public void fax(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}

interface Printer {
    void print(Document d);
}

interface Scanner {
    void scan(Document d);
}


// YAGNI -> you ain't Going to need it

class JustAPrinter implements Printer {
    @Override
    public void print(Document d) {

    }
}

class OldFashionPrinter implements Machine {

    @Override
    public void print(Document d) {

    }

    @Override
    public void fax(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}


class Photocopier implements Printer, Scanner {
    @Override
    public void print(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}

interface MultiFunctionMachine extends Printer, Scanner {}

class MultiFunctionDevice implements MultiFunctionMachine {

    private Printer printer;
    private Scanner scanner;

    public MultiFunctionDevice(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }


    @Override
    public void print(Document d) {
        printer.print(d);
    }

    @Override
    public void scan(Document d) {
        scanner.scan(d);
    }
}


public class Demo {
    public static void main(String[] args) {
        System.out.println("Hello World!!");
    }
}