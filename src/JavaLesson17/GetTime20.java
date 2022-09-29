package JavaLesson17;

import java.util.*;
import java.text.DateFormat;

public class GetTime20 extends Thread {
    // extending Thread class will allow us to access all the different method
    // that come in the Thread class

    // Now all the code that a Thread executes must be inside run method
    @Override
    public void run() {
        Date rightNow;
        Locale currentLocale;
        DateFormat timeFormatter;
        DateFormat dateFormatter;
        String timeOutput;
        String dateOutput;

        for(int i = 1; i <= 20; i++) {
            rightNow = new Date();
            currentLocale = new Locale("es");

            // change DEFAULT in below line to SHORT MEDIUM, LONG and FULL and see the changes
            timeFormatter = DateFormat.getTimeInstance(DateFormat.LONG, currentLocale);
            dateFormatter = DateFormat.getDateInstance(DateFormat.LONG, currentLocale);

            timeOutput = timeFormatter.format(rightNow);
            dateOutput = dateFormatter.format(rightNow);

            System.out.println(timeOutput);
            System.out.println(dateOutput);
            System.out.println();

            try {
                Thread.sleep(2000);

            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
