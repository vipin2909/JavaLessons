package DesignPatterns.ChainOfResponsibility;


import java.util.Scanner;

class Currency1 {
    private int amount;
    public Currency1(int amount) {
        this.amount = amount;
    }
    public int getAmount() {
        return amount;
    }
}

interface Dispenser {


    void setNextChain(Dispenser nextChain);


    void dispense(Currency1 curr);
}

class Dollar50 implements Dispenser {
    private Dispenser chain;
    @Override
    public void setNextChain(Dispenser nextChain) {
        this.chain = nextChain;
    }
    @Override
    public void dispense(Currency1 curr) {
        if(curr.getAmount() >= 50) {
            int num = curr.getAmount() / 50;
            int remainder = curr.getAmount() % 50;
            System.out.println("Dispensing " + num + "$ 50 note");
            if(remainder != 0) this.chain.dispense(new Currency1(remainder));
        }
        else {
            this.chain.dispense(curr);
        }
    }

    public void handle() {

    }
}

class Dollar20 implements Dispenser {
    private Dispenser chain;
    @Override
    public void setNextChain(Dispenser nextChain) {
        this.chain = nextChain;
    }
    @Override
    public void dispense(Currency1 curr) {
        if(curr.getAmount() >= 20) {
            int num = curr.getAmount() / 20;
            int remainder = curr.getAmount() % 20;
            System.out.println("Dispensing " + num + "$ 20 note");
            if(remainder != 0) this.chain.dispense(new Currency1(remainder));
        }
        else {
            this.chain.dispense(curr);
        }
    }
}

class Dollar10 implements Dispenser {
    private Dispenser chain;
    @Override
    public void setNextChain(Dispenser nextChain) {
        this.chain = nextChain;
    }
    @Override
    public void dispense(Currency1 curr) {
        if(curr.getAmount() >= 10) {
            int num = curr.getAmount() / 10;
            int remainder = curr.getAmount() % 10;
            System.out.println("Dispensing " + num + "$ 10 note");
            if(remainder != 0) this.chain.dispense(new Currency1(remainder));
        }
        else {
            this.chain.dispense(curr);
        }
    }
}
public class AtmDispenseChain {
    private Dispenser chain;
    public AtmDispenseChain() {
        this.chain = new Dollar50();
        Dispenser chain2 = new Dollar20();
        Dispenser chain3 = new Dollar10();

        chain.setNextChain(chain2);
        chain2.setNextChain(chain3);
    }

    public static void main(String[] args) {
        AtmDispenseChain atmDispenser = new AtmDispenseChain();
        while(true) {
            int amount = 0;
            System.out.println("Enter amount to dispense");
            Scanner input = new Scanner(System.in);
            amount = input.nextInt();
            if(amount % 10 != 0) {
                System.out.println("Amount should be entered in multiple of 10's ");
                return;
            }
            atmDispenser.chain.dispense(new Currency1(amount));


        }
    }
}
