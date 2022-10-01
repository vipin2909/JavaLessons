import javax.swing.*;
import java.awt.event.*;


public class Lesson24 extends JFrame {
    JComboBox favoriteShows;
    JButton button1;
    String infoOnComponent;

    public static void main(String[] args) {
        new Lesson24();
    }
    public Lesson24() {
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Forth Frame");
        JPanel thePanel = new JPanel();

        String[] shows = {"Breaking bad", "Life of Mars", "Doctor Who"};
        favoriteShows = new JComboBox(shows);
        favoriteShows.addItem("Pushing Daises");
        thePanel.add(favoriteShows);

        button1 = new JButton("Get Answer");
        ListenForButtons lForButtons = new ListenForButtons();
        button1.addActionListener(lForButtons);

        thePanel.add(button1);

        this.add(thePanel);
        this.setVisible(true);

        favoriteShows.insertItemAt("Dexter", 1);
        favoriteShows.setMaximumRowCount(3);
//        favoriteShows.removeItem("Dexter");
//        favoriteShows.removeItemAt(1);
    }

    private class ListenForButtons implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1) {
                favoriteShows.setEditable(true);
                infoOnComponent += "Item at 0: " + favoriteShows.getItemAt(0) + "\n";
                infoOnComponent += "Number Of Shows: " + favoriteShows.getItemCount() + "\n";
                infoOnComponent += "Selected ID: " + favoriteShows.getSelectedIndex() + "\n";
                infoOnComponent += "Selected Value: " + favoriteShows.getSelectedItem() + "\n";
                infoOnComponent += "Are Editable: " + favoriteShows.isEditable() + "\n";

                JOptionPane.showMessageDialog(Lesson24.this, infoOnComponent, "Information", JOptionPane.INFORMATION_MESSAGE);
                infoOnComponent = "";
            }
        }
    }
}
