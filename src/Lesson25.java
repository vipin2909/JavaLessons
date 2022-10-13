import javax.swing.*;
import java.awt.event.*;

public class Lesson25 extends JFrame {
    JButton button1;
    String infoOnComponent;
    JList favoriteMovies, favoriteColors;
    DefaultListModel defListModel = new DefaultListModel();
    JScrollPane scroller;
//    JScrollBar scrollBar = new JScrollBar();

    public static void main(String[] args) {
        new Lesson25();
    }

    public Lesson25() {
        this.setSize(400, 400);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("my Fifth Frame");
        JPanel thePanel = new JPanel();
        button1 = new JButton("Get Answer");
        ListenForButton lForButton = new ListenForButton();
        button1.addActionListener(lForButton);
        thePanel.add(button1);
        String[] movies = {"Matrix", "minority Report", "Big Ben"};
        favoriteMovies = new JList(movies);
        favoriteMovies.setFixedCellHeight(30);
        favoriteMovies.setFixedCellWidth(150);
        // SINGLE INTERVAL SELECTION Means you can select continuous elements inside list
        // EX. 1 2 3 4 5 6 -> can select 1 2 3 order not 1 3 4 5
        // For that you need to use MULTIPLE INTERVAL SELECTION
        favoriteMovies.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        /*
        * All the Methods for Lists
        *
        * getSelectedIndex(): returns the index for the first selected item
        * getSelectedIndexes(): returns every selection in list
        * getSelectedValue(): returns the value of the first selected item
        * getSelectedValues(): returns the values of the selected items
        * isSelectedIndex(): returns true if index is selected
        *
         */

        String[] colors = {"Black", "Blue", "White","Green", "Orange", "Gray"};
        for(String color: colors) {
            defListModel.addElement(color);
        }

        defListModel.add(2, "Purple");


        favoriteColors = new JList(defListModel);

        favoriteColors.setVisibleRowCount(4);
        scroller = new JScrollPane(favoriteColors, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        favoriteColors.setFixedCellHeight(30);
        favoriteColors.setFixedCellWidth(150);
        thePanel.add(favoriteMovies);
        thePanel.add(scroller);
        this.add(thePanel);
        this.setVisible(true);


    }

    private class ListenForButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1) {
                infoOnComponent = "";
                if(defListModel.contains("Black")) {
                    infoOnComponent += "Black is Here\n";
                }

                if(!defListModel.contains("Black")) {
                    infoOnComponent += "Black is not Here\n";
                }

                infoOnComponent += "Elements in the List " + defListModel.size() + "\n";
                infoOnComponent += "Last Element " + defListModel.lastElement() + "\n";
                infoOnComponent += "First Element " + defListModel.firstElement() + "\n";
                infoOnComponent += "In Index 1 " + defListModel.get(1) + "\n";

                JOptionPane.showMessageDialog(Lesson25.this, infoOnComponent, "INFoR", JOptionPane.INFORMATION_MESSAGE);
                infoOnComponent = "";
            }
        }
    }

}
