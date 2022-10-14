import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import javax.swing.SpinnerDateModel;
import java.util.Calendar;


public class Lesson26 extends JFrame {
    JButton button1;
    JSpinner spinner1, spinner2, spinner3, spinner4;
    String outputString = "";

    public static void main(String[] args) {
        new Lesson26();
    }

    public Lesson26() {
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Fifth Frame");
        JPanel thePanel = new JPanel();

        // Create a button
        button1 = new JButton("Get Answer");
        ListenForButton lForButton = new ListenForButton();
        button1.addActionListener(lForButton);
        thePanel.add(button1);

        spinner1 = new JSpinner();
        thePanel.add(spinner1);

        spinner2  = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        thePanel.add(spinner2);

        String[] weekDays = {"Mon", "Tue", "Wed", "Thru", "Fri", "Sat", "Sun"};
        spinner3 = new JSpinner(new SpinnerListModel(weekDays));

        thePanel.add(spinner3);

        Dimension d = spinner3.getPreferredSize();
        d.width = 80;
        spinner3.setPreferredSize(d);

        Date todayDate = new Date();
        spinner4 = new JSpinner(new SpinnerDateModel(todayDate, null, null, Calendar.DAY_OF_MONTH));

        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner4, "dd/MM/yy");
        spinner4.setEditor(dateEditor);

        thePanel.add(spinner4);

        // This could be done as homework
//        ListenForSpinner listenForSpinner = new ListenForSpinner();
//        spinner4.addChangeListener(listenForSpinner);

        this.add(thePanel);
        this.setVisible(true);
    }

    private class ListenForButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1) {
                outputString += "Spinner 1 Value: " + spinner1.getValue() + "\n";
                outputString += "Spinner 2 Value: " + spinner2.getValue() + "\n";
                outputString += "Spinner 3 Value: " + spinner3.getValue() + "\n";
                outputString += "Spinner 4 Value: " + spinner4.getValue() + "\n";

                JOptionPane.showMessageDialog(Lesson26.this, outputString, "Informattion", JOptionPane.INFORMATION_MESSAGE);

                outputString = "";
            }
        }
    }
}