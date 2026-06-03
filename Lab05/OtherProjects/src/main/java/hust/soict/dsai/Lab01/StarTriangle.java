public class StarTriangle {
    public static void main(String[] args) {
        int n = Integer.parseInt(javax.swing.JOptionPane.showInputDialog(null, "Enter the height of the triangle: ", "Input Triangle Height", javax.swing.JOptionPane.INFORMATION_MESSAGE));
        StringBuilder triangle = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                triangle.append("*");
            }
            triangle.append("\n");
        }
        javax.swing.JOptionPane.showMessageDialog(null, triangle.toString(), "Star Triangle", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
