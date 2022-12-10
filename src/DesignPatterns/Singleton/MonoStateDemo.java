package DesignPatterns.Singleton;


// Monostate implementation is if you want this class to certainly become singleton
// all you do is make the data storage static due to this
// Monostate might work to some degree but it is not preferrable
class ChiefExecutiveOfficer {
    private static String name;
    private static int age;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        ChiefExecutiveOfficer.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        ChiefExecutiveOfficer.age = age;
    }
    @Override
    public String toString() {
        return "ChiefExecutiveOfficer{"+"name='"+name
                +'\''+", age="+age+"}";
    }

}
public class MonoStateDemo {
    public static void main(String[] args) {
        ChiefExecutiveOfficer ceo = new ChiefExecutiveOfficer();
        ceo.setName("Adam Smith");
        ceo.setAge(55);

        ChiefExecutiveOfficer ceo2 = new ChiefExecutiveOfficer();
        ceo2.setName("Black Brain");
        ceo2.setAge(90);

        System.out.println(ceo);
    }
}
