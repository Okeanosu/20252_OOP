package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.lineSeparator());
    private static boolean exit = false;

    public static void main(String[] args) {
        // Create some media items
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, "Roger Allers", 87);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, "George Lucas", 124);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladdin", "Animation", 18.99f, "John Musker", 90);
        Book book1 = new Book(4, "The Great Gatsby", "Novel", 10.99f);
        book1.addAuthor("F. Scott Fitzgerald");
        Book book2 = new Book(5, "To Kill a Mockingbird", "Novel", 12.99f);
        book2.addAuthor("Harper Lee");
        CompactDisc cd1 = new CompactDisc(6, "Thriller", "Pop", 14.99f, "Michael Jackson", 12, "Pop");
        cd1.addTrack(new Track("Wanna Be Startin' Somethin'", 6));
        cd1.addTrack(new Track("Thriller", 5));
        cd1.addTrack(new Track("Beat It", 4));
        CompactDisc cd2 = new CompactDisc(7, "Back in Black", "Rock", 13.99f, "AC/DC", 10, "Rock");
        cd2.addTrack(new Track("Hells Bells", 5));
        cd2.addTrack(new Track("Shoot to Thrill", 4));
        cd2.addTrack(new Track("Back in Black", 4));

        // Add media items to the store
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(cd1);
        store.addMedia(cd2);

        initData();
        while (!exit){
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: System.out.println("Viewing store...");
                    break;
                case 2: System.out.println("Updating store...");
                    break;
                case 3: {
                    System.out.println("Current cart:");
                    cart.printCart();
                }
                case 0: {
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                }
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    // --Menu methods--
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3");
    }
    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back to main menu");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4");
    }
    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back to main menu");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2");
    }
    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back to main menu");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5");
    }

    public static void initData() {
        // Initialize any necessary data for the application
    }

}
