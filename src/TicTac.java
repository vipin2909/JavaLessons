import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class TicTac implements ActionListener {

    JFrame frame = new JFrame();
    JButton[] bton = new JButton[9];
    JPanel t_panel = new JPanel();
    JPanel bt_panel = new JPanel();
    JLabel textField = new JLabel();
    int chance_flag = 0;
    Random random = new Random(100);
    boolean pl1_chance;

    int count = 0;

    public TicTac() {

        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setTitle("Tic Tac Toe");
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(120, 20, 124));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setText("Tic Tac Toe");

        t_panel.setBounds(0, 0, 800, 100);
        t_panel.setLayout(new BorderLayout());

        bt_panel.setLayout(new GridLayout(3, 3));
        bt_panel.setBackground(new Color(150, 150, 150));

        for(int i = 0; i < 9; i++) {
            bton[i] = new JButton();
            bt_panel.add(bton[i]);
//            bton[i].setBackground(new Color(0, 255, 0));
            bton[i].setFocusable(false);
            bton[i].setFont(new Font("Ink Free", Font.BOLD, 120));
            bton[i].addActionListener(this);
        }

        t_panel.add(textField);
        frame.add(t_panel, BorderLayout.NORTH);
        frame.add(bt_panel);

        startGame();

    }


    public void startGame() {
        try {
            textField.setText("Loading....");
            Thread.sleep(4000);
        }
        catch(Throwable e) {
            e.printStackTrace();
        }

        int chance = random.nextInt(100);
        if(chance%2 == 0) {
            pl1_chance = true;
            textField.setText("X turn");
        }
        else {
            pl1_chance = false;
            textField.setText("O Turn");
        }
    }

    public void gameOver(String s) {
        chance_flag = 0;
        Object[] option = {"Restart", "Exit"};
        int n = JOptionPane.showOptionDialog(frame, "Game Over\n" + s, "Game Over", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
        if(n == 0) {
            frame.dispose();
            new TicTac();
        }
        else {
            frame.dispose();
        }
    }

    public void matchCheck() {
        if ((bton[0].getText() == "X") && (bton[1].getText() == "X") && (bton[2].getText() == "X")) {
            xWins(0, 1, 2);
        }
        else if ((bton[0].getText() == "X") && (bton[4].getText() == "X") && (bton[8].getText() == "X")) {
            xWins(0, 4, 8);
        }
        else if ((bton[0].getText() == "X") && (bton[3].getText() == "X") && (bton[6].getText() == "X")) {
            xWins(0, 3, 6);
        }
        else if ((bton[1].getText() == "X") && (bton[4].getText() == "X") && (bton[7].getText() == "X")) {
            xWins(1, 4, 7);
        }
        else if ((bton[2].getText() == "X") && (bton[4].getText() == "X") && (bton[6].getText() == "X")) {
            xWins(2, 4, 6);
        }
        else if ((bton[2].getText() == "X") && (bton[5].getText() == "X") && (bton[8].getText() == "X")) {
            xWins(2, 5, 8);
        }
        else if ((bton[3].getText() == "X") && (bton[4].getText() == "X") && (bton[5].getText() == "X")) {
            xWins(3, 4, 5);
        }
        else if ((bton[6].getText() == "X") && (bton[7].getText() == "X") && (bton[8].getText() == "X")) {
            xWins(6, 7, 8);
        }

        else if ((bton[0].getText() == "O") && (bton[1].getText() == "O") && (bton[2].getText() == "O")) {
            oWins(0, 1, 2);
        }
        else if ((bton[0].getText() == "O") && (bton[3].getText() == "O") && (bton[6].getText() == "O")) {
            oWins(0, 3, 6);
        }
        else if ((bton[0].getText() == "O") && (bton[4].getText() == "O") && (bton[8].getText() == "O")) {
            oWins(0, 4, 8);
        }
        else if ((bton[1].getText() == "O") && (bton[4].getText() == "O") && (bton[7].getText() == "O")) {
            oWins(1, 4, 7);
        }
        else if ((bton[2].getText() == "O") && (bton[4].getText() == "O") && (bton[6].getText() == "O")) {
            oWins(2, 4, 6);
        }
        else if ((bton[2].getText() == "O") && (bton[5].getText() == "O") && (bton[8].getText() == "O")) {
            oWins(2, 5, 8);
        }
        else if ((bton[3].getText() == "O") && (bton[4].getText() == "O") && (bton[5].getText() == "O")) {
            oWins(3, 4, 5);
        } else if ((bton[6].getText() == "O") && (bton[7].getText() == "O") && (bton[8].getText() == "O")) {
            oWins(6, 7, 8);
        }
        else if(chance_flag==9) {
            textField.setText("Match Tie");
            gameOver("Match Tie");
        }
    }

    public void xWins(int x1, int x2, int x3) {
        bton[x1].setBackground(Color.RED);
        bton[x2].setBackground(Color.RED);
        bton[x3].setBackground(Color.RED);

        for(int i = 0; i < 9; i++) {
            bton[i].setEnabled(false);
        }
        textField.setText("X Wins");
        gameOver("X Wins");
    }
    public void oWins(int o1, int o2, int o3) {
        bton[o1].setBackground(Color.RED);
        bton[o2].setBackground(Color.RED);
        bton[o3].setBackground(Color.RED);

        for(int i = 0; i < 9; i++) {
            bton[i].setEnabled(false);
        }
        textField.setText("O Wins");
        gameOver("O Wins");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Inside Action Listener " + (++count) + " times");
        for(int i = 0; i < 9; i++) {
           if(e.getSource() == bton[i]) {
               if(pl1_chance) {
                   if(bton[i].getText() == "") {
                       bton[i].setForeground(new Color(255, 0, 0));
                       bton[i].setText("X");
                       pl1_chance = false;
                       textField.setText("O Turn");
                       chance_flag++;
                       matchCheck();
                   }
               }
               else {
                   if(bton[i].getText() == "") {
                       bton[i].setForeground(new Color(0, 0, 255));
                       bton[i].setText("O");
                       pl1_chance = true;
                       textField.setText("X Turn");
                       chance_flag++;
                       matchCheck();
                   }
               }
           }
        }

    }

    public static void main(String[] args) {
        new TicTac();
    }

}
