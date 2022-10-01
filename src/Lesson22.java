import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.text.NumberFormat;
import javax.swing.border.*;
import javax.tools.Tool;

public class Lesson22 extends JFrame {
    JButton button1;
    JLabel label1, label2, label3;
    JTextField textField1, textField2;
    JCheckBox dollarSign, commaSeprator;
    JRadioButton addNums, subtractNums, multNums, divideNums;
    JSlider howManyTimes;

    double number1, number2, number3, number4, totalCalc;

    public static void main(String[] args) {
        new Lesson22();
    }

    public Lesson22() {
        this.setSize(400, 400);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width / 2) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getHeight() / 2);

        this.setLocation(xPos, yPos);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Third Frame");
        JPanel thePanel = new JPanel();
        button1 = new JButton("Calculate");
        ListenForButton lForButton = new ListenForButton();
        button1.addActionListener(lForButton);
        thePanel.add(button1);
        label1 = new JLabel("Number 1");
        thePanel.add(label1);

        textField1 = new JTextField("", 5);
        thePanel.add(textField1);

        label2 = new JLabel("Number 2");
        thePanel.add(label2);

        textField2 = new JTextField("", 5);
        thePanel.add(textField2);

        dollarSign = new JCheckBox("Dollars");
        commaSeprator = new JCheckBox("Commas");
        thePanel.add(dollarSign);
        thePanel.add(commaSeprator, true);

        addNums = new JRadioButton("Add");
        subtractNums = new JRadioButton("Subtract");
        multNums = new JRadioButton("Multiply");
        divideNums = new JRadioButton("Divide");

//        ButtonGroup operation = new ButtonGroup();
//        operation.add(addNums);
//        operation.add(subtractNums);
//        operation.add(multNums);
//        operation.add(divideNums);

        JPanel operPanel = new JPanel();
        Border operBorder = BorderFactory.createTitledBorder("Operation");

        operPanel.setBorder(operBorder);
        operPanel.add(addNums);
        operPanel.add(subtractNums);
        operPanel.add(multNums);
        operPanel.add(divideNums);

        addNums.setSelected(true);
        thePanel.add(operPanel);

        label3 = new JLabel("Perform How Many Times");
        thePanel.add(label3);

        howManyTimes = new JSlider(0, 99, 1);
        howManyTimes.setMinorTickSpacing(1);
        howManyTimes.setMajorTickSpacing(10);
        howManyTimes.setPaintTicks(true);
        howManyTimes.setPaintLabels(true);
        ListenForSlider lForSlider = new ListenForSlider();
        howManyTimes.addChangeListener(lForSlider);
        thePanel.add(howManyTimes);
        this.add(thePanel);
        this.setVisible(true);
        textField1.requestFocus();
    }

    private class ListenForButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1) {
                try {
                    number1 = Double.parseDouble(textField1.getText());
                    number2 = Double.parseDouble(textField2.getText());
                }

                catch(NumberFormatException exce) {
                    JOptionPane.showMessageDialog(Lesson22.this, "please enter the right info", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }

                if(addNums.isSelected()) {
                    totalCalc = addNumber(number1, number2, howManyTimes.getValue());
                }
                else if(subtractNums.isSelected()) {
                    totalCalc = subtractNumber(number1, number2, howManyTimes.getValue());
                }

                else if(multNums.isSelected()) {
                    totalCalc = multiplyNumber(number1, number2, howManyTimes.getValue());
                }

                else {
                    totalCalc = divideNumber(number1, number2, howManyTimes.getValue());
                }

                if(dollarSign.isSelected()) {
                    NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
                    JOptionPane.showMessageDialog(Lesson22.this, numberFormat.format(totalCalc), "Solution", JOptionPane.INFORMATION_MESSAGE);

                }
                else if(commaSeprator.isSelected()) {
                    NumberFormat numberFormat = NumberFormat.getNumberInstance();
                    JOptionPane.showMessageDialog(Lesson22.this, numberFormat.format(totalCalc), "Solution", JOptionPane.INFORMATION_MESSAGE);

                }
                else {
                    JOptionPane.showMessageDialog(Lesson22.this, totalCalc, "Solution", JOptionPane.INFORMATION_MESSAGE );
                }
            }
        }
    }

    private class ListenForSlider implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            if(e.getSource() == howManyTimes) {
                label3.setText("Perform How Many Times? " + howManyTimes.getValue());
            }
        }
    }

    public static double addNumber(double number1, double number2, int howManyTimes) {
        double total = 0;
        int i = 1;
        while(i <= howManyTimes) {
            total += (number1 + number2);
            i++;
        }
        return total;
    }
    public static double subtractNumber(double number1, double number2, int howManyTimes) {
        double total = 0;
        int i = 1;
        while(i <= howManyTimes) {
            total += (number1 + number2);
            i++;
        }
        return total;
    }
    public static double multiplyNumber(double number1, double number2, int howManyTimes) {
        double total = 0;
        int i = 1;
        while(i <= howManyTimes) {
            total += (number1 + number2);
            i++;
        }
        return total;
    }
    public static double divideNumber(double number1, double number2, int howManyTimes) {
        double total = 0;
        int i = 1;
        while(i <= howManyTimes) {
            total += (number1 + number2);
            i++;
        }
        return total;
    }
}
