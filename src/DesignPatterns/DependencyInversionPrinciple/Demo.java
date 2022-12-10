//package DesignPatterns.DependencyInversionPrinciple;
//
//
//// A. High-level modules should not depend on low-level modules.
//// Both should depend on abstractions.
//
//// B. Abstractions should not depend on details.
//// Details should depend on abstractions.
////import org.springframework.stereotype.Component;
//
////import org.javatuples.Triplet;
//
//import javax.management.relation.Relation;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//enum Relationship {
//    PARENT,
//    CHILD,
//    SIBLING,
//}
//
//class Person {
//    public String name;
//
//    public Person(String name) {
//        this.name = name;
//    }
//}
//
//
//interface RelationshipBrowser {
//    List<Person> findAllChildrenOf(String name);
//}
//
//class Relationships implements RelationshipBrowser { // low-level
//    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();
//
//    public List<Triplet<Person, Relationship, Person>> getRelations() {
//        return relations;
//    }
//
//    @Override
//    public List<Person> findAllChildrenOf(String name) {
//      return relations.stream().filter(x -> Objects.equals(x.getValue0().name, name) && x.getValue1() == Relationship.PARENT).map(Triplet::getValue2).collect(Collectors.toList());
//    }
//
//    public void addParentAndChild(Person parent, Person child) {
//        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
//        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
//    }
//}
//
//
//class Research { // high-level
//    public Research(RelationshipBrowser browser) {
////        List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
////        relations.stream().filter(x -> x.getValue(0).name.equals("john") && x.getValue(1) == Relationship.PARENT).forEach(ch -> System.out.println("John has a child called " + ch.getValue(2).name));
//
//        List<Person> children = browser.findAllChildrenOf("john");
//        for(Person child: children) {
//            System.out.println("John has child called: " + child.name);
//        }
//    }
//}
//
//public class Demo {
//    public static void main(String[] args) {
//       Person parent = new Person("john");
//       Person child1 = new Person("chris");
//       Person child2 = new Person("matt");
//
//       Relationships relationships = new Relationships();
//       relationships.addParentAndChild(parent, child1);
//       relationships.addParentAndChild(parent, child2);
//
//       new Research(relationships);
//    }
//}