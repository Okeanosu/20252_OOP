public class Equation2 {
    public static void main(String[] args) {
        String strA, strB, strC;
        strA = javax.swing.JOptionPane.showInputDialog(null,"Please input a: ", "Input a", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        strB = javax.swing.JOptionPane.showInputDialog(null,"Please input b: ", "Input b", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        strC = javax.swing.JOptionPane.showInputDialog(null,"Please input c: ", "Input c", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(strA);
        double b = Double.parseDouble(strB);
        double c = Double.parseDouble(strC);
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Infinite solutions", "Equation2", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "No solution if a = 0 and b = 0 but c != 0", "Equation2", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                double solution = -c / b;
                javax.swing.JOptionPane.showMessageDialog(null, "Result: " + solution, "Equation2", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                javax.swing.JOptionPane.showMessageDialog(null, "No solution if delta < 0", "Equation2", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } else if (delta == 0) {
                double solution = -b / (2 * a);
                javax.swing.JOptionPane.showMessageDialog(null, "Result: " + solution, "Equation2", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } else {
                double solution1 = (-b + Math.sqrt(delta)) / (2 * a);
                double solution2 = (-b - Math.sqrt(delta)) / (2 * a);
                javax.swing.JOptionPane.showMessageDialog(null, "Result: " + solution1 + " and " + solution2, "Equation2", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        }
        System.exit(0);
    }
}
