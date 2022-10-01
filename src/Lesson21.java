import java.awt.*;
import javax.swing.*;
import javax.tools.Tool;

import java.awt.datatransfer.Clipboard;
import java.awt.event.*;


// By extending JFrame we can create frames and this can also be done by using JFrame
// Object without extending JFarme class
public class Lesson21 extends JFrame {
    JButton button1;
    JTextField textField1;
    JTextArea textArea1;
    int buttonClicked;

    public static void main(String[] args) {
        new Lesson21();
    }

    public Lesson21() {
        this.setSize(500, 500);

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
//        int xPos = (dim.width / 2) - (this.getWidth() / 2);
//        int yPos = (dim.height / 2) - (this.getHeight() / 2);
        int xPos = (dim.width / 2) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getHeight() / 2);
        this.setLocation(xPos, yPos);


        this.setLocation(xPos, yPos);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My second Frame");
        JPanel thePanel = new JPanel();
        button1 = new JButton("Click Here");
        ListenForButton listenForButton = new ListenForButton();
        button1.addActionListener(listenForButton);
        thePanel.add(button1);
        textField1 = new JTextField("Type Here", 15);
        ListenForKeys lForKeys = new ListenForKeys();
        textField1.addKeyListener(lForKeys);
        thePanel.add(textField1);
         textArea1 = new JTextArea(15, 20);
        textArea1.setText("Tracking Events\n");
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        JScrollPane scrollBar1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        thePanel.add(scrollBar1);

        this.add(thePanel);

        ListenForWindow lForWindow = new ListenForWindow();
        this.addWindowListener(lForWindow);
        this.setVisible(true);

        ListenForMouse lForMouse = new ListenForMouse();
        thePanel.addMouseListener(lForMouse);

        ListenForFocus lForFocus = new ListenForFocus();
        textField1.addFocusListener(lForFocus);
    }

    // Implement Listeners
    private class ListenForButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1) {
                buttonClicked++;
                textArea1.append("Button Clicked " + buttonClicked + "\n");
                e.getSource().toString();
            }
        }
    }

    private class ListenForKeys implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            // this gets called when a key is pressed
            textArea1.append("Key Hit: " + e.getKeyChar() + "\n");
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    private class ListenForWindow implements WindowListener {

        @Override
        public void windowOpened(WindowEvent e) {
            textArea1.append("Window Created\n");
        }

        @Override
        public void windowClosing(WindowEvent e) {

        }

        @Override
        public void windowClosed(WindowEvent e) {
            // this.disposed()
            textArea1.append("Window is closed\n");
        }

        @Override
        public void windowIconified(WindowEvent e) {
            textArea1.append("Window is Minimized\n");
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            textArea1.append("Window in Normal State\n");
        }

        @Override
        public void windowActivated(WindowEvent e) {
            // This is called when the window is active
            textArea1.append("Window is active\n");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            textArea1.append("Window is not Active\n");
        }
    }

    private class ListenForMouse implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            textArea1.append("Mouse Panel pos: " + e.getX() + " " + e.getY() + "\n");
            textArea1.append("Mouse Screen pos: " + e.getXOnScreen() + " " + e.getYOnScreen() + "\n");
            textArea1.append("Mouse button " + e.getButton() + "\n");
            textArea1.append("Mouse Clicks " + e.getClickCount() + "\n");

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private class ListenForFocus implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            textArea1.append("Focus Gained\n");
        }

        @Override
        public void focusLost(FocusEvent e) {
            textArea1.append("Focus Lost\n");
        }
    }
}


