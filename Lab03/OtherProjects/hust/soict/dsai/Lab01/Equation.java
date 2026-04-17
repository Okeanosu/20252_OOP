public class Equation {
    public static void main(String[] args) {
        String strA, strB;
        strA = javax.swing.JOptionPane.showInputDialog(null,"Please input a: ", "Input a", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        strB = javax.swing.JOptionPane.showInputDialog(null,"Please input b: ", "Input b", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(strA);
        double b = Double.parseDouble(strB);
        if (a == 0) {
            if (b == 0) {
                javax.swing.JOptionPane.showMessageDialog(null, "Infinite solutions", "Equation", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "No solution if a = 0 and b !=0", "Equation", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            double solution = -b / a;
            javax.swing.JOptionPane.showMessageDialog(null, "Result: " + solution, "Equation", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
        System.exit(0);
    }
}
