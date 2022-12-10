package DesignPatterns.Builder;


// Fluent Builder Inheritance With Recursive Generics
// in this there is great use of recursive generics
class Person {
    public String name;
    public String position;

    @Override
    public String toString() {
        return "Person{"+"name='"+name+'\''+", position='"+position+'\''+'}';
    }
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
    public EmployeeBuilder worksAt(String position) {
        person.position = position;
        return self();
    }

    @Override
    protected EmployeeBuilder self() {
        return this;
    }
}
class PersonBuilder<SELF extends PersonBuilder<SELF>> {
    protected Person person = new Person();
    public SELF withName(String name) {
        person.name = name;
        return  self();
    }

    public Person build() {
        return person;
    }

    protected SELF self() {
        return (SELF) this;
    }
}

public class PersonTest {
    public static void main(String[] args) {
        EmployeeBuilder pb = new EmployeeBuilder();
        Person dimitri = pb.withName("Dimitri").worksAt("Developer").build();
        System.out.println(dimitri);
    }

}
