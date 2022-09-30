import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

public class Lesson20 extends JFrame {
    public static void main(String[] args) {
        new Lesson20();
    }
    public Lesson20() {
        this.setSize(400, 400);

        // For centering the frame or window there are two options
        // either use a Toolkit and set Dimensions using Dimension
        // and another one is by using setLocationRelativeTo(null)

        // Now below is the implementation for both ways to center the frame
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width / 2) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getHeight() / 2);
        this.setLocation(xPos, yPos);
        // if you want to make your frame resizable then setResizable to false
        // by default it is set to true
//        this.setResizable(false);
//        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My First Frame");
        JPanel thePanel = new JPanel();
        JLabel label1 = new JLabel("Tell Me Something");
        thePanel.add(label1);
        label1.setText("New Text");
        label1.setToolTipText("doesn't do anything");
        JButton button1 = new JButton("Send");
//        button1.setBorderPainted(false);
//        button1.setContentAreaFilled(false);
        button1.setText("New Button");

        button1.setToolTipText("This is a button");
        thePanel.add(button1);
        JTextField textField1 = new JTextField("type here", 15);
        textField1.setColumns(10);
        textField1.setText("type Again");
        textField1.setToolTipText("it's a field");
        thePanel.add(textField1);

        JTextArea textArea1 = new JTextArea(15, 20 );
        textArea1.setText("Just a whole bunch of random text that is important\n\n");
//        textArea1.setLineWrap(true);
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        int numOfLines = textArea1.getLineCount();
        textArea1.append("number of lines: " + numOfLines);
        JScrollPane scrollBar1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        thePanel.add(scrollBar1);
//        thePanel.add(textArea1);
        this.add(thePanel);

        this.setVisible(true);

        // this will make focus on the field that we want to get focused
        textArea1.requestFocus();

    }
}
