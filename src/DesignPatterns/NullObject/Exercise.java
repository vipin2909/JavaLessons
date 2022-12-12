package DesignPatterns.NullObject;


interface Log1 {
    // max# of element in the log
    int getRecordLimit();

    // number of elements already in the log
    int getRecordCount();

    // expected to increment record count
    void logInfo(String message);

}

class Account {
    private Log1 log;
    public Account(Log1 log) {
        this.log =  log;
    }
    public void someOperation() throws Exception {
        int c = log.getRecordCount();
        log.logInfo("Performing an operation");
        if(c+1 != log.getRecordCount()) {
            throw new Exception();
        }
        if(log.getRecordCount() >= log.getRecordLimit()) {
            throw new Exception();
        }
    }
}

class NullLog implements Log1 {

    @Override
    public int getRecordLimit() {
        return 0;
    }

    @Override
    public int getRecordCount() {
        return 0;
    }

    @Override
    public void logInfo(String message) {

    }
}
public class Exercise {

}
