package Lab05.OtherProjects.hust.soict.dsai.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class AWTAccumulator extends JFrame {
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0;
    
    public AWTAccumulator() {
        setLayout(new GridLayout(2, 2));
        add(new Label("Enter an integer:"));
        tfInput = new TextField(10);
        add(tfInput);
        tfInput.addActionListener(new TFInputListener());
        add(new Label("The accumulated sum is:"));

        tfOutput = new TextField(10);
        tfOutput.setEditable(false);
        add(tfOutput);

        setTitle("AWT Accumulator");
        setSize(350, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new AWTAccumulator();
    }
    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;
            tfInput.setText("");
            tfOutput.setText(sum + "");
        }
    }
}
