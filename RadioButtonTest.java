import java.awt.*;
import javax.swing.*;

public class RadioButtonTest {
    private JFrame frame;

    public static void main(String[] args) {
        RadioButtonTest test = new RadioButtonTest();
        test.start();
    }

    private void start() {
        frame = new JFrame("This is just a test!");
        Container contentPane = (JPanel)frame.getContentPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Deez nuts"));
        panel.setPreferredSize(new Dimension(100,100));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        ButtonGroup buttonGroup = new ButtonGroup();
        
        for (JRadioButton jrd : makeButtons()) {
            buttonGroup.add(jrd);
            panel.add(jrd);
        }

        contentPane.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private JRadioButton[] makeButtons() {
        JRadioButton[] buttonArray = new JRadioButton[4];
        buttonArray[0] = new JRadioButton("A", true);
        buttonArray[1] = new JRadioButton("B", false);
        buttonArray[2] = new JRadioButton("C", false);
        buttonArray[3] = new JRadioButton("D", false);

        return buttonArray;
    }
}