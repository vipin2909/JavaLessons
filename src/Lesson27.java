import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.util.Enumeration;
import javax.swing.tree.*;

public class Lesson27  extends JFrame {
    JButton button1;
    String outputString = "";
    JTree theTree;
    DefaultMutableTreeNode documents, work, games, emails;
    DefaultMutableTreeNode fileSystem = new DefaultMutableTreeNode("C Drive");
    public static void main(String[] args) {
        new Lesson27();
    }

    public Lesson27() {
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Sixth Frame");
        JPanel thePanel = new JPanel();

        // Create a button
        button1 = new JButton("Get Answer");
        ListenForButton lForButton = new ListenForButton();
        button1.addActionListener(lForButton);
        thePanel.add(button1);

        theTree = new JTree(fileSystem);
        theTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        theTree.setVisibleRowCount(8);
        documents = addAFile("Docs", fileSystem);
        addAFile("Taxes.exl", documents);
        addAFile("Story.txt", documents);

        emails = addAFile("Emails", documents);
        addAFile("Scheduled.txt", emails);
        work = addAFile("Work Application", fileSystem);
        addAFile("Work.txt", work);
        addAFile("SpreadSheet.exe", work);

        JScrollPane scrollBox = new JScrollPane(theTree);
        thePanel.add(scrollBox);
        Dimension d = scrollBox.getPreferredSize();
        d.width = 200;
        scrollBox.setPreferredSize(d);
        this.add(thePanel);
        this.setVisible(true);
    }

    private class ListenForButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1) {
                Object treeObject  = theTree.getLastSelectedPathComponent();
                DefaultMutableTreeNode theFile = (DefaultMutableTreeNode) treeObject;
                String treeNode = (String) theFile.getUserObject();
                outputString += "The Selected Node: " + treeNode + "\n";
                outputString += "Number of children: " + theFile.getChildCount() + "\n";
                outputString += "Number of Sibling: " + theFile.getSiblingCount() + "\n";

                outputString += "Parent: " + theFile.getParent() + "\n";

                outputString += "Next Node: " + theFile.getNextNode() + "\n";

                outputString += "\nChildren of Node\n";

                for(Enumeration enumValue = theFile.children(); enumValue.hasMoreElements();) {
                    outputString += enumValue.nextElement() + "\n";
                }

                outputString += "\nPath From root\n";
                TreeNode[] pathNods = theFile.getPath();
                for(TreeNode indivNodes: pathNods) {
                    outputString += indivNodes + "\n";
                }
                JOptionPane.showMessageDialog(Lesson27.this, outputString, "Information", JOptionPane.INFORMATION_MESSAGE);
                outputString = "";
            }
        }
    }

    private DefaultMutableTreeNode addAFile(String fileName, DefaultMutableTreeNode parentFolder) {
        DefaultMutableTreeNode newFile = new DefaultMutableTreeNode(fileName);
        parentFolder.add(newFile);

        return newFile;
    }
}
