package JavaLesson17;

public class Lesson17 {
    public static void main(String[] args) {
        Thread getTime = new GetTime20();
        Runnable getMail = new GetTheMail(10);
        Runnable getMailAgain = new GetTheMail(20);

        new Thread(getMail).start();
        new Thread(getMailAgain).start();
        getTime.start();
    }
}
