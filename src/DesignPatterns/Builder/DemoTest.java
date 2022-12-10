package DesignPatterns.Builder;

class PersonFacade {
    // address Information
    String streetAddress, postCode, city;

    // Employement
    public String companyName, position;
    public int annualIncome;

    @Override
    public String toString() {
        return "Person{"+"streetAddress'"+streetAddress+'\''+
                ", postCode='"+postCode+'\''+
                ", city='"+city+'\''+
                ", companyName="+companyName+'\''+
                ", position="+position+'\''+
                ", annualIncome="+annualIncome+
                "}";
    }

}

// builder facade
// why the both PersonAddressBuilderFacade, PersonJobBuilderFacade
// extends From PersonFacade
class PersonBuilderFacade {
    protected PersonFacade person = new PersonFacade();

    public PersonAddressBuilderFacade lives() {
        return new PersonAddressBuilderFacade(person);
    }

    public PersonJobBuilderFacade works() {
        return new PersonJobBuilderFacade(person);
    }

    public PersonFacade build() {
        return person;
    }

}

class PersonAddressBuilderFacade extends PersonBuilderFacade {
    public PersonAddressBuilderFacade(PersonFacade person) {
        this.person = person;
    }
    public PersonAddressBuilderFacade at(String streetAddress) {
        person.streetAddress = streetAddress;
        return this;
    }

    public PersonAddressBuilderFacade withPostCode(String postCode) {
        person.postCode = postCode;
        return this;
    }

    public PersonAddressBuilderFacade in(String city) {
        person.city = city;
        return this;
    }

}

class PersonJobBuilderFacade extends PersonBuilderFacade {
    public PersonJobBuilderFacade(PersonFacade person) {
        this.person = person;
    }

    public PersonJobBuilderFacade at(String companyName) {
        person.companyName = companyName;
        return this;
    }
    public PersonJobBuilderFacade asA(String position) {
        person.position = position;
        return this;
    }

    public PersonJobBuilderFacade earning(int annualIncome) {
        person.annualIncome = annualIncome;
        return this;
    }

}



public class DemoTest {
    public static void main(String[] args) {
        PersonBuilderFacade pbf = new PersonBuilderFacade();
        PersonFacade person = pbf.lives()
                                    .at("123 London Road")
                                    .in("London")
                                    .withPostCode("SW12BC")
                                .works()
                                    .at("Fabrikam")
                                    .asA("Enginner")
                                    .earning(123000)
                                .build();
        System.out.println(person);
    }
}
