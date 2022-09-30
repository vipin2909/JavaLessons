package JavaLesson18;

import java.util.concurrent.locks.ReentrantLock;

public class PerformSystemCheck implements Runnable {
    private String checkWhat;
    ReentrantLock lock = new ReentrantLock();
    public PerformSystemCheck(String checkWhat) {
        this.checkWhat = checkWhat;
    }

    // whenever we want to protect run method to be accessed by two different Threads
    // at same time we can do it multiple ways
    // in this way we can see how we do do this by using ReentrantLock
    // and how do it with synchronized
    // below is the synchronized implementation
    // However we can't use synchronized for every method because it slows down java

//    synchronized public void run() {
//
//    }

    // another method using ReentrantLock
    public void run() {
        lock.lock();
        System.out.println("Checking... " + this.checkWhat);
        lock.unlock();
    }
}
