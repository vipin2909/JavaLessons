package DesignPatterns.Proxy;

class Person {

	private int age;

	public Person(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String drink() {
		return "drinking";
	}

	public String drive() {
		return "driving";
	}

	public String drinkAndDrive() {
		return "driving while drinking";
	}

}

class ResponsiblePerson extends Person {
	
	private Person person;
	
	public ResponsiblePerson(Person person) {
		
		// to do
		super(person.getAge());
		this.person = person; 
	}

	@Override
	public void setAge(int age) {
		person.setAge(age);
	}

	@Override 
	public int getAge() {
		return person.getAge();
	}

	@Override
	public String drink() {
		return (person.getAge() >= 10) ? person.drink() : "too young";
	}

	public String drive() {
		return (person.getAge() >= 18) ? 
			person.drive() : "too young";
	}

	@Override 
	public String drinkAndDrive() {
		return "dead";
	}
}


public class Exercise {
	
	public static void main(String[] args) {
		ResponsiblePerson person = new ResponsiblePerson(new Person(10));
	
		System.out.println(person.drive());
		person.drinkAndDrive();
	}
	
}
