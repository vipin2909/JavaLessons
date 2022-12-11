package DesignPatterns.Momento;

// Keep a memento of an object's state to return to that state

// Motivation ->
// An object system goes through changes
// -> // bank accounts get deposits and withdrawals

// There are different ways of navigating those changes
// One way is to record every change(Command) and teach a command to 'undo' itself
// Another is so simple save snapshots of the system


// Memento -> A Token/Handle representing the system state.
// Lets us roll back to the state when the token was generated.
// May or may not directly expose state information


class Memento {
    private int balance;
    public int getBalance() {
        return balance;
    }
    public Memento(int balance) {
        this.balance = balance;
    }
}
class BankAccount {
    private int balance;
    public BankAccount(int balance) {
        this.balance = balance;
    }

    public Memento deposite(int amount) {
        balance += amount;
        return new Memento(balance);
    }

    public void restore(Memento m) {
        balance = m.getBalance();
    }

    @Override
    public String toString() {
        return "BankAccount{"+"balance="+balance+"}";
    }
}
public class Demo {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount(100);
        Memento m1 = ba.deposite(50); // 150
        Memento m2 = ba.deposite(25); // 175

        System.out.println(ba);

        // restore to m1
        ba.restore(m1);
        System.out.println(ba);

        ba.restore(m2);
        System.out.println(ba);


    }
}

// Memento should be read only because if it is able to make changements in memento
// this will not break its principle of storing the snapshots


