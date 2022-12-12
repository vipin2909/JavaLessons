package DesignPatterns.NullObject;


// When component A uses component B, it typically assumes that B is not null
// -> you inject B, not some Option<B> Type
// -> you do not check for null on every call

// There is no option of telling A not to use an instance of B
// -> Its use is hard coded

// Thus, we build a no-op, non-functioning inheritor of B (or some interface that B implements) and pass it into A


import java.lang.reflect.Proxy;

// A no-op object that conforms to the required interface, satisfying a dependency requirement of some other object.
interface Log {
    void info(String msg);
    void warn(String msg);
}

class ConsoleLog implements Log {
    @Override
    public void info(String message) {
        System.out.println(message);
    }

    @Override
    public void warn(String message) {
        System.out.println("WARNING: " + message);
    }
}

class NullLog implements Log {
    @Override
    public void info(String message) {

    }

    @Override
    public void warn(String message) {

    }

    @Override
    public String toString() {
        return this == null ? "Really null" : "inside NullLog";
    }
}
class BankAccount {
    private Log log;
    private int balance;
    public BankAccount(Log log) {
        this.log = log;
    }

    public void desposit(int amount) {
        balance += amount;
//        log.info("Deposited " + amount);
        // check for null everywhere
        if(log != null) {
            log.info("Deposited " + amount + ", balance is now " + balance);
        }
    }

    public void withdraw(int amount) {
        if(balance >= amount) {
            balance -= amount;
            if(log != null) {
                System.out.println("Withdraw " + amount + ", we have " + balance + " left.");
            }
        }
        else {
            if(log != null) {
                System.out.println("Could not withdraw " + amount + " because balance is only " + balance);
            }
        }
    }
}

public class Demo {

    // parameterized on type and going to return type t

    @SuppressWarnings("unchecked")
    public static <T> T noOp(Class<T> itf) {
        return (T) Proxy.newProxyInstance(
                itf.getClassLoader(),
                new Class<?>[]{itf},
                (proxy, method, args) -> {
                    if(method.getReturnType().equals(Void.TYPE))
                        return null;
                    else
                        return method.getReturnType().getConstructor().newInstance();
                }
        );
    }
    public static void main(String[] args) {
//        ConsoleLog log = new ConsoleLog();
//        NullLog log = new NullLog();

        Log log = noOp(Log.class);
        BankAccount account = new BankAccount(log);
        account.desposit(100);
        System.out.println(log.getClass());
    }

}


// Summary

// Implement the required interface
// Rewrite the methods with empty bodies
// -> if methods is non-void, return default value for given type
// -> If these values are ever used, you are in trouble
// Supply an instance object in place of actual object
// Cross your fingers

