import java.awt.*;
import java.awt.event.*;
import java.io.*;
//import java.util.Scanner;
import javax.swing.*;

public class GUIPizza {
    private JFrame frame;
    private JMenuBar pMenuBar;
    private Container contentPane;

    // radio buttons and button group
    private JRadioButton regularCrustButton;
    private JRadioButton thinCrustButton;
    private JRadioButton handCrustButton;
    private JRadioButton deepCrustButton;
    private ButtonGroup crustButtonGroup;

    // check boxes
    private JCheckBox pepperoniBox;
    private JCheckBox sausageBox;
    private JCheckBox cheeseBox;
    private JCheckBox pepperBox;
    private JCheckBox onionBox;
    private JCheckBox mushroomBox;
    private JCheckBox oliveBox;
    private JCheckBox anchovyBox;

    // text fields
    private JTextField breadSticksText;
    private JTextField buffaloWingsText;
    private JTextField nameText;
    private JTextField addressText;
    private JTextField cityText;

    public static void main(String[] args) { 
        GUIPizza application = new GUIPizza();
        application.startApp();
    }

    private void startApp() {
        frame = new JFrame("The Best Pizza Application Ever!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        makeMenus();
        makeContent();

        frame.pack();
        frame.setVisible(true);
    }

    private void makeMenus() {
        pMenuBar = new JMenuBar();
        frame.setJMenuBar(pMenuBar);

        makePFileMenu();
        makePHelpMenu();
    }

    private void makePFileMenu() {
        JMenu pMenuFile = new JMenu("File");
        pMenuFile.setMnemonic(KeyEvent.VK_F);
        pMenuBar.add(pMenuFile);

        JMenuItem pMenuItemNewOrder = new JMenuItem("New Order");
        pMenuItemNewOrder.setMnemonic(KeyEvent.VK_N);
        pMenuFile.add(pMenuItemNewOrder);
        pMenuItemNewOrder.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK));
        pMenuItemNewOrder.addActionListener(new pNewOrderListener());
        JMenuItem pMenuItemSaveOrder = new JMenuItem("Save Order");
        pMenuItemSaveOrder.setMnemonic(KeyEvent.VK_S);
        pMenuFile.add(pMenuItemSaveOrder);
        pMenuItemSaveOrder.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
        pMenuItemSaveOrder.addActionListener(new pSaveOrderListener());
        pMenuFile.addSeparator();
        JMenuItem pMenuItemExit = new JMenuItem("Exit");
        pMenuItemExit.setMnemonic(KeyEvent.VK_X);
        pMenuItemExit.setDisplayedMnemonicIndex(1);
        pMenuItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Event.CTRL_MASK));
        pMenuItemExit.addActionListener(new pExitListener());
        pMenuFile.add(pMenuItemExit);
    }

    private void makePHelpMenu() {
        JMenu pMenuHelp = new JMenu("Help");
        pMenuHelp.setMnemonic(KeyEvent.VK_H);
        pMenuBar.add(pMenuHelp);

        JMenuItem pMenuItemAboutGUIPizza = new JMenuItem("About GUI Pizza");
        pMenuItemAboutGUIPizza.setMnemonic(KeyEvent.VK_A);
        pMenuItemAboutGUIPizza.addActionListener(new pAboutGUIPizzaListener());
        pMenuHelp.add(pMenuItemAboutGUIPizza);
    }

    private void makeContent() {
        contentPane = (JPanel)frame.getContentPane();
        contentPane.setLayout(new BorderLayout(6,6));

        makeNorthRegion();
        makeWestRegion();
        makeCenterRegion();
        makeEastRegion();
        makeSouthRegion();
    }

    private void makeNorthRegion() {
        JLabel pMainImage = new JLabel(new ImageIcon("main_pizza.jpg"), JLabel.CENTER);
        contentPane.add(pMainImage, BorderLayout.NORTH);
    }

    private void makeWestRegion() {
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
        westPanel.setBorder(BorderFactory.createTitledBorder("Choose a Crust"));
        crustButtonGroup = new ButtonGroup();

        regularCrustButton = new JRadioButton("Regular Crust", true);
        crustButtonGroup.add(regularCrustButton);
        westPanel.add(regularCrustButton);
        thinCrustButton = new JRadioButton("Thin Crust",false);
        crustButtonGroup.add(thinCrustButton);
        westPanel.add(thinCrustButton);    
        handCrustButton = new JRadioButton("Hand-Tossed Crust",false);
        crustButtonGroup.add(handCrustButton);
        westPanel.add(handCrustButton);    
        deepCrustButton = new JRadioButton("Deep-Dish Crust",false);
        crustButtonGroup.add(deepCrustButton);
        westPanel.add(deepCrustButton);

        contentPane.add(westPanel, BorderLayout.WEST);
    }

    private void makeCenterRegion() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createTitledBorder("Select Toppings"));

        pepperoniBox = new JCheckBox("Pepperoni", false);
        centerPanel.add(pepperoniBox);
        sausageBox = new JCheckBox("Sausage", false);
        centerPanel.add(sausageBox);
        cheeseBox = new JCheckBox("Extra Cheese", false);
        centerPanel.add(cheeseBox);
        pepperBox = new JCheckBox("Bell Peppers", false);
        centerPanel.add(pepperBox);
        onionBox = new JCheckBox("Onions", false);
        centerPanel.add(onionBox);
        mushroomBox = new JCheckBox("Mushrooms", false);
        centerPanel.add(mushroomBox);
        oliveBox = new JCheckBox("Olives", false);
        centerPanel.add(oliveBox);
        anchovyBox = new JCheckBox("Anchovies", false);
        centerPanel.add(anchovyBox);

        contentPane.add(centerPanel, BorderLayout.CENTER);
    }

    private void makeEastRegion() {
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
        eastPanel.setBorder(BorderFactory.createTitledBorder("Sides (Enter Quantity)"));
        eastPanel.setPreferredSize(new Dimension(150,0));

        JPanel smallEastPanel = new JPanel();
        smallEastPanel.setLayout(new BoxLayout(smallEastPanel, BoxLayout.X_AXIS));
        breadSticksText = new JTextField("",99999);
        smallEastPanel.add(breadSticksText);
        smallEastPanel.add(new JLabel(" Bread Sticks"));
        breadSticksText.setMaximumSize(new Dimension(20,24));
        smallEastPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        eastPanel.add(smallEastPanel);

        smallEastPanel = new JPanel();
        smallEastPanel.setLayout(new BoxLayout(smallEastPanel,BoxLayout.X_AXIS));
        buffaloWingsText = new JTextField("", 2);
        buffaloWingsText.setMaximumSize(new Dimension(20,24));
        smallEastPanel.add(buffaloWingsText);
        smallEastPanel.add(new JLabel(" Buffalo Wings"));
        smallEastPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        eastPanel.add(smallEastPanel);

        contentPane.add(eastPanel, BorderLayout.EAST);
    }

    private void makeSouthRegion() {
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
        southPanel.setBorder(BorderFactory.createTitledBorder("Deliver To:"));

        JPanel smallSouthPanel = new JPanel();
        smallSouthPanel.setLayout(new BoxLayout(smallSouthPanel, BoxLayout.Y_AXIS));
        smallSouthPanel.add(new JLabel("Name:"));
        smallSouthPanel.add(new JLabel("Address:"));
        smallSouthPanel.add(new JLabel("City, St, Zip:"));
        smallSouthPanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        southPanel.add(smallSouthPanel);

        smallSouthPanel = new JPanel();
        smallSouthPanel.setLayout(new BoxLayout(smallSouthPanel,BoxLayout.Y_AXIS));
        nameText = new JTextField();
        addressText = new JTextField();
        cityText = new JTextField();
        smallSouthPanel.add(nameText);
        smallSouthPanel.add(addressText);
        smallSouthPanel.add(cityText);
        smallSouthPanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        southPanel.add(smallSouthPanel);

        contentPane.add(southPanel, BorderLayout.SOUTH);
    }

    private class pExitListener implements ActionListener {public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }}
    private class pAboutGUIPizzaListener implements ActionListener {public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(frame, "GUI Pizza\n\n Version 1.0\n Build B20080226-1746\n\n(c) Copyright Merril Hall 2008\n All rights reserved\n\n Visit http://www.ed2go.com/\nEducation To Go\nIntermediate Java Course",
                "About GUI Pizza", JOptionPane.INFORMATION_MESSAGE);
        }}
    private class pNewOrderListener implements ActionListener {public void actionPerformed(ActionEvent e) {
            regularCrustButton.setSelected(true);
            pepperoniBox.setSelected(false);
            sausageBox.setSelected(false);
            cheeseBox.setSelected(false);
            pepperBox.setSelected(false);
            onionBox.setSelected(false);
            mushroomBox.setSelected(false);
            oliveBox.setSelected(false);
            anchovyBox.setSelected(false);
            breadSticksText.setText("");
            buffaloWingsText.setText("");
            nameText.setText("");
            addressText.setText("");
            cityText.setText("");
        }}
    private class pSaveOrderListener implements ActionListener {public void actionPerformed(ActionEvent e) {
            String order = "Pizza Order\n===========\nCrust:\n";
            if (regularCrustButton.isSelected()) order += "     Regular\n";
            else if (thinCrustButton.isSelected()) order += "     Thin\n";
            else if (deepCrustButton.isSelected()) order += "     Deep-Dish\n";
            else if (handCrustButton.isSelected()) order += "     Hand-Tossed\n";

            order += "Toppings:\n";
            if (pepperoniBox.isSelected())
                order += "     Pepperoni\n";
            if (sausageBox.isSelected())
                order += "     Sausage\n";
            if (cheeseBox.isSelected())
                order += "     Extra Cheese\n";
            if (pepperBox.isSelected())
                order += "     Peppers\n";
            if (onionBox.isSelected())
                order += "     Onions\n";
            if (mushroomBox.isSelected())
                order += "     Mushrooms\n";
            if (oliveBox.isSelected())
                order += "     Olives\n";
            if (anchovyBox.isSelected())
                order += "     Anchovies\n";

            int bs = 0;
            int bw = 0;
            try
            {
                if (!breadSticksText.getText().isEmpty())
                    bs = Integer.parseInt(breadSticksText.getText());
                if (!buffaloWingsText.getText().isEmpty())
                    bw = Integer.parseInt(buffaloWingsText.getText());
            }
            catch (NumberFormatException nfe)
            {
                JOptionPane.showMessageDialog(frame, 
                    "Side order entries must be numeric,\n" +
                    "and must be whole numbers", 
                    "Side Order Error", 
                    JOptionPane.ERROR_MESSAGE);
            }

            if (bs > 0 || bw > 0)
            {
                order += "Sides:\n";
                if (bs > 0)
                    order += "     " + bs + " Bread Sticks\n";
                if (bw > 0)
                    order += "     " + bw + " Buffalo Wings\n";
            }
            
            if (nameText.getText().isEmpty() ||
            addressText.getText().isEmpty() ||
            cityText.getText().isEmpty())
                JOptionPane.showMessageDialog(frame, 
                    "Address fields may not be empty.",
                    "Address Error", 
                    JOptionPane.ERROR_MESSAGE);
            else
            {
                order += "Deliver To:\n";
                order += "     " + nameText.getText() + "\n";
                order += "     " + addressText.getText() + "\n";
                order += "     " + cityText.getText() + "\n";
            }
            order += "\n***END OF ORDER ***\n";
            try {
                PrintStream fileWriter = new PrintStream("pizza_order.txt");
                fileWriter.print(order);
                fileWriter.close();
            }
            catch (IOException ioe){System.out.println("\n*** I/O Error ***\n" + ioe);}
        }}

}