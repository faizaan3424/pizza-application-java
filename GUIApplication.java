import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class GUIApplication implements ActionListener {
    private JFrame frame;
    private Container contentPane;

    private JTextField textA;
    private JTextField textB;
    private JTextField textC;
    private JRadioButton one;
    private JRadioButton two;
    private JRadioButton three;
    private JCheckBox yes;
    private JCheckBox no;

    public static void main(String[] args) {
        GUIApplication gui = new GUIApplication();
    }

    public GUIApplication() {
        frame = new JFrame("Best Application");
        contentPane = (JPanel)frame.getContentPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane.setLayout(new GridLayout(2,2));

        makeMenus();
        makeOptions();

        frame.pack();
        frame.setVisible(true);
    }

    private void makeMenus() {
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu menuStuffz = new JMenu("Stuffz");
        menuStuffz.setMnemonic(KeyEvent.VK_S);
        menuBar.add(menuStuffz);

        JMenuItem menuItemSave = new JMenuItem("Save");
        menuItemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
        menuItemSave.addActionListener(this);
        menuStuffz.add(menuItemSave);

        JMenuItem menuItemExit = new JMenuItem("Exit");
        menuItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Event.CTRL_MASK));
        menuItemExit.addActionListener(this);
        menuStuffz.add(menuItemExit);
    }

    private void makeOptions() {
        makeTextFields();
        makeRadioButtons();
        makeCheckBoxes();
        makeImage();
    }

    private void makeTextFields() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JPanel subPanel = new JPanel();
        subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
        subPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        subPanel.add(new JLabel("A:"));
        subPanel.add(new JLabel("B:"));
        subPanel.add(new JLabel("C:"));

        panel.add(subPanel);

        subPanel = new JPanel();
        subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
        subPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        textA = new JTextField("ljahgjlwaekgnaelswdmhawekhawuoitbjqwkuetgjkadsbgjkobw4qejg");
        textB = new JTextField("");
        textC = new JTextField("...");

        JScrollPane scrollBarA = new JScrollPane(textA);
        scrollBarA.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollBarA.setMaximumSize(new Dimension(100,30));
        subPanel.add(scrollBarA);
        JScrollPane scrollBarB = new JScrollPane(textB);
        scrollBarB.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollBarB.setMaximumSize(new Dimension(100,30));
        subPanel.add(scrollBarB);
        JScrollPane scrollBarC = new JScrollPane(textC);
        scrollBarC.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollBarC.setMaximumSize(new Dimension(100,30));
        subPanel.add(scrollBarC);
        panel.add(subPanel);

        contentPane.add(panel);
    }

    private void makeRadioButtons() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        ButtonGroup buttonGroup = new ButtonGroup();
        one = new JRadioButton("one", true);
        two = new JRadioButton("two", false);
        three = new JRadioButton("three", false);

        buttonGroup.add(one);
        buttonGroup.add(two);
        buttonGroup.add(three);

        panel.add(one);
        panel.add(two);
        panel.add(three);

        contentPane.add(panel);
    }

    private void makeCheckBoxes() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        yes = new JCheckBox("yes", true);
        no = new JCheckBox("no", false);

        panel.add(yes);
        panel.add(no);

        contentPane.add(panel);
    }

    private void makeImage() {
        JPanel panel = new JPanel();
        JLabel image = new JLabel(new ImageIcon("cute_cat.jpg"), JLabel.CENTER);

        panel.add(image);
        contentPane.add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Save")) printToText();
        else if (e.getActionCommand().equals("Exit")) System.exit(0);
    }

    public void printToText() {
        try {
            PrintStream fileWriter = new PrintStream("no_u.txt");
            String output = "| Choice List |\n    Text Fields:\n       " + textA.getText() + "\n       " + textB.getText() + "\n       " + textC.getText() + "\n   Radio Button:\n";

            if (one.isSelected()) output += "         one\n";
            else if (two.isSelected()) output += "        two\n";
            else if (three.isSelected()) output += "      three\n";
            
            output += "    Check Boxes:\n";
            if (yes.isSelected()) output += "       yes\n";
            if (no.isSelected()) output += "       no\n";
            
            output += "\nDid you like the cat?";
            
            fileWriter.print(output);
            fileWriter.close();
        }
        catch (IOException e) {
            System.out.println("IO Exception: " + e);
        }
    }
}