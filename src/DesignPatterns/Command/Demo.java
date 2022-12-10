package DesignPatterns.Command;
import java.util.Collections;
import java.util.List;
// Ordinary java statements are perishable

// can't undo a field assignment
// can't directly serialize a sequence of actions(calls)

// Want an object that represents an operations

// X should change its Y to value Z
// X should do w()

// Uses: GUI commands, multi-level undo/redo, macro reading and more

// An Object which represents an instruction to perform a particular action.
// Contains all the information necessary for the action to be taken

class BankAccount {
    private int balance;
    private int overDraftLimit = -500;

    public void deposite(int amount) {
        balance += amount;
        System.out.println("Deposited " + amount + ", balance is now " + balance);
    }

    public boolean withdrawl(int amount) {
        if(balance - amount >= overDraftLimit) {
            balance -= amount;
            System.out.println("Withdraw " + amount + ", balance is now " + balance);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", overDraftLimit=" + overDraftLimit +
                "}";
    }
}

interface CommandMain {
    void call();
    void undo();
}
class BankAccountCommand implements CommandMain {
    private BankAccount account;
    private boolean succeded;



    @Override
    public void call() {

        switch(action) {
            case DEPOSIT:
                succeded = true;
                account.deposite(amount);
                break;
            case WITHDRAW:
                succeded = account.withdrawl(amount);
                break;
        }
    }

    @Override
    public void undo() {
        if(!succeded) return;
        switch(action) {
            case DEPOSIT:
                account.withdrawl(amount);
                break;
            case WITHDRAW:
                account.deposite(amount);
                break;
        }
    }
    public enum Action {
        DEPOSIT, WITHDRAW
    }
    private Action action;
    private int amount;
    public BankAccountCommand(BankAccount account, Action action, int amount) {
        this.account = account;
        this.action = action;
        this.amount = amount;
    }
}

public class Demo {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount();
        System.out.println(ba);

        List<BankAccountCommand> commands = new java.util.ArrayList<>(List.of(
                new BankAccountCommand(ba, BankAccountCommand.Action.DEPOSIT, 100),
                new BankAccountCommand(ba, BankAccountCommand.Action.WITHDRAW, 1000)
        ));

        // can use CommandMain instead of BankAccountCommand
        // because it implements CommandMain so it is able to substitute where
        // BankAccountCommand is used
        for(BankAccountCommand c: commands) {
            c.call();
            System.out.println(ba);
        }

        Collections.reverse(commands);
        for(CommandMain c: commands) {
            c.undo();
            System.out.println(ba);
        }
    }
}


// Summary => Encapsulate all details of an operation in a separate object
// Define instruction for applying the command (either in the command itself, or elsewhere).
// Optionally define instructions for undoing the command
// Can create composite commands (a.k.a macros)

