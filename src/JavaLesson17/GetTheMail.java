package JavaLesson17;

public class GetTheMail implements Runnable {
    private int startTime;
    public GetTheMail(int startTime) {
        this.startTime = startTime;
    }
    public void run() {
        try {
            Thread.sleep(startTime * 1000L);
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Checking Mail");
    }
}
