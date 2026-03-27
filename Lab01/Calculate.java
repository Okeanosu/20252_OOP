
public class Calculate {
    public static void main(String[] args) {
            String strNum1, strNum2;
            strNum1 = javax.swing.JOptionPane.showInputDialog(null,"Please input the first number: ", "Input the first number", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            strNum2 = javax.swing.JOptionPane.showInputDialog(null,"Please input the second number: ", "Input the second number", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            double num1 = Double.parseDouble(strNum1);
            double num2 = Double.parseDouble(strNum2);
            double sum = num1 + num2;
            double difference = num1 - num2;
            double product = num1 * num2;
            double quotient = num1 / num2;
            String strNotification = "The sum of " + num1 + " and " + num2 + " is: " + sum + "\n" +
                                     "The difference of " + num1 + " and " + num2 + " is: " + difference + "\n" +
                                     "The product of " + num1 + " and " + num2 + " is: " + product + "\n" +
                                     "The quotient of " + num1 + " and " + num2 + " is: " + quotient;
            javax.swing.JOptionPane.showMessageDialog(null, strNotification, "Calculate", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
    }
}
