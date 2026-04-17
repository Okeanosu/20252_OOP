import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String[] args) {
            Scanner keyboard = new Scanner(System.in);
            System.out.print("What's your name: ");
            String strName = keyboard.nextLine();
            System.out.println("How old are you: ");
            int age = keyboard.nextInt();
            System.out.println("How tall are you (m)?");
            double height = keyboard.nextDouble();
            System.out.println("Mrs/Ms " + strName + ", you are " + age + " years old and " + height + " m tall.");
    }
}
