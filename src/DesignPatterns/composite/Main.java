package DesignPatterns.composite;


import java.util.ArrayList;
import java.util.List;

interface Employee {
    public void showEmployeeDetails();
}

class Developer implements Employee {
    private String name;
    private long empId;
    private String position;

    public Developer(long empId, String name, String position) {
        // assign employee id, name and the position
        this.empId = empId;
        this.name = name;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println(empId + " " + name + " " + position);
    }
}

class Manager implements Employee {
    private String name;
    private long empId;
    private String position;

    public Manager(long empId, String name, String position) {
        this.empId = empId;
        this.name = name;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println(empId + " " + name + " " + position);
    }
}


class CompositeDirectory implements Employee {
    private List<Employee> employeeList = new ArrayList<>();
    @Override
    public void showEmployeeDetails() {
        for(Employee emp: employeeList) {
            emp.showEmployeeDetails();
        }
    }

    public void addEmployee(Employee emp) {
        employeeList.add(emp);
    }

    public void removeEmployee(Employee emp) {
        employeeList.remove(emp);
    }
}

// Driver Class
public class Main {
    public static void main(String[] args) {
        Developer dev1 = new Developer(100, "Lokesh Sharma", "Pro Developer");
        Developer dev2 = new Developer(101, "Vipin Sharma", "Developer");
        CompositeDirectory engDirectory = new CompositeDirectory();
        engDirectory.addEmployee(dev1);
        engDirectory.addEmployee(dev2);

        Manager man1 = new Manager(200, "Kushgara Garg", "SEO Manager");
        Manager man2 = new Manager(201, "Vikram Sharma", "Kushargra's Manager");

        CompositeDirectory accDirectory = new CompositeDirectory();
        accDirectory.addEmployee(man1);
        accDirectory.addEmployee(man2);

        CompositeDirectory directory = new CompositeDirectory();
        directory.addEmployee(engDirectory);
        directory.addEmployee(accDirectory);
        directory.showEmployeeDetails();
    }
}