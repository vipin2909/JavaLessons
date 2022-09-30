package JavaLesson18;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit.*;

public class Lesson18 {
    public static void main(String[] args) {
        addThreadsToPool();
    }

    public static void addThreadsToPool() {
        // this allows us to Schedule code execution at some time in the future and
        // also on top of that it gonna allowed you to have code execute repetatively based of
        // different time periods
        ScheduledThreadPoolExecutor eventPool = new ScheduledThreadPoolExecutor(5);
        eventPool.scheduleAtFixedRate(new CheckSystemTime(), 0, 2, TimeUnit.SECONDS);
        eventPool.scheduleAtFixedRate(new PerformSystemCheck("Mail"), 5, 5, TimeUnit.SECONDS);
        eventPool.scheduleAtFixedRate(new PerformSystemCheck("Calendar"), 10, 10, TimeUnit.SECONDS);

        System.out.println("number of threads " + Thread.activeCount());

        Thread[] listOfThreads = new Thread[Thread.activeCount()];

        Thread.enumerate(listOfThreads);
        for(Thread thread: listOfThreads) {
            System.out.println(thread);
        }

        for(Thread threadPriority: listOfThreads) {
            System.out.println(threadPriority.getPriority());
        }
        eventPool.shutdown();
        try {
            Thread.sleep(20000);
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
