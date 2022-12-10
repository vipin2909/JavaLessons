package DesignPatterns.Prototype;



// To implement a prototype partially construct
// an object and store it somewhere
// Call the Prototype
// - Implement your own deep copy functionality; or
// - Seriaize and Deserialize
import java.util.Arrays;
class Address implements Cloneable {
    public String streetName;
    public int houseNumber;

    public Address(String streetName, int houseNumber) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "Address{"+
                "streetName='"+streetName+'\''+
                ", houseNumber='"+houseNumber+'\''+"}";
    }

    // deep copy
    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Address(streetName, houseNumber);
    }
}

class Person implements Cloneable {
    public String[] names;
    public Address address;

    public Person(String[] names, Address address) {
        this.names = names;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{"+"names="+ Arrays.toString(names)+", address="+address+"}";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Person(names.clone(), (Address)address.clone());
    }
}

public class Demo {
    public static void main(String[] args)  throws Exception {
        Person john = new Person(new String[]{"john", "smith"}, new Address("London Road", 123));

        // We are overriding john by doing so
        Person jane = (Person) john.clone();
        jane.names[0] = "jane";
        jane.address.houseNumber = 124;

        System.out.println(john);
        System.out.println(jane);

    }
}