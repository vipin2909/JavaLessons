package DesignPatterns.State;


import org.junit.Assert;
import org.junit.Test;

class CombinationLock {
    enum State {
        LOCKED,
        OPEN,
        ATTEMPTING,
        ERROR,

    }

    private int[] combination;
    private String combo;
    public String status;
    private State state;

    public CombinationLock(int[] combination) {
        this.combination = combination;
        comboToString();
        state = State.LOCKED;
        status = "LOCKED";
    }

    public void enterDigit(int digit) {
        switch(state) {
            case OPEN:
            case ERROR:
                return;
            case LOCKED:
                state = State.ATTEMPTING;
                status = "" + digit;
                check();
                break;
            case ATTEMPTING:
                status += digit;
                check();
                break;
        }
    }

    private void comboToString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < combination.length; i++) {
            sb.append(combination[i]);
        }
        this.combo = sb.toString();
    }

    public void check() {
        if(status.length() == combo.length()) {
            if(status.equals(combo)) {
                state = State.OPEN;
                status = "OPEN";
            }
            else {
                state = State.ERROR;
                status = "ERROR";
            }
        }
    }


}
public class Exercise {
    CombinationLock lock = new CombinationLock(new int[]{1, 2, 3, 4});

    public static void main(String[] args) {

    }

    @Test
    public void test1() {
        Assert.assertEquals("LOCKED", lock.status);
        lock.enterDigit(1);
        Assert.assertEquals("1", lock.status);
        lock.enterDigit(2);
        Assert.assertEquals("12", lock.status);
        lock.enterDigit(3);
        Assert.assertEquals("123", lock.status);
        lock.enterDigit(4);
        Assert.assertEquals("OPEN", lock.status);
    }
}
