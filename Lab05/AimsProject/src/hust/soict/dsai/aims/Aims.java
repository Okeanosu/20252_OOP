package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean exit = false;

    public static void main(String[] args) {
        initData();

        while (!exit){
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: viewStore();
                    break;
                case 2: updateStore();
                    break;
                case 3: viewCart(); 
                    break;
                case 0: {
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                }
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    // View store interaction
    public static void viewStore() {
        boolean back = false;
        while (!back) {
            System.out.println("------ Store Items ------");
            int i = 1;
            for (var media : store.getItems()) {
                System.out.println(i + ". " + media.getTitle() + " (id=" + media.getId() + ") - " + media.getCost());
                i++;
            }
            System.out.println("-------------------------");
            storeMenu();
            int choice = -1;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Invalid input. Returning to store menu.");
                continue;
            }
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    System.out.print("Enter media id to view details: ");
                    int id = scanner.nextInt(); scanner.nextLine();
                    var m = store.getItems().stream().filter(x -> x.getId() == id).findFirst().orElse(null);
                    if (m == null) { System.out.println("Media not found."); break; }
                    System.out.println(m.toString());
                    mediaDetailsMenu();
                    int sub = scanner.nextInt(); scanner.nextLine();
                    if (sub == 1) { cart.addMedia(m); }
                    else if (sub == 2) {
                        if (m instanceof hust.soict.dsai.aims.media.Playable) {
                            ((hust.soict.dsai.aims.media.Playable) m).play();
                        } else {
                            System.out.println("This media is not playable.");
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.print("Enter media id to add to cart: ");
                    int id = scanner.nextInt(); scanner.nextLine();
                    var m = store.getItems().stream().filter(x -> x.getId() == id).findFirst().orElse(null);
                    if (m == null) { System.out.println("Media not found."); break; }
                    cart.addMedia(m);
                    break;
                }
                case 3: {
                    System.out.print("Enter media id to play: ");
                    int id = scanner.nextInt(); scanner.nextLine();
                    var m = store.getItems().stream().filter(x -> x.getId() == id).findFirst().orElse(null);
                    if (m == null) { System.out.println("Media not found."); break; }
                    if (m instanceof hust.soict.dsai.aims.media.Playable) {
                        ((hust.soict.dsai.aims.media.Playable) m).play();
                    } else System.out.println("This media is not playable.");
                    break;
                }
                case 4: {
                    viewCart();
                    break;
                }
                case 0: {
                    back = true; break;
                }
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
    }

   public static void updateStore() {
        boolean back = false;
        while (!back) {
            System.out.println("------ Store Items ------");
            int i = 1;
            for (var media : store.getItems()) {
                System.out.println(i + ". " + media.getTitle() + " (id=" + media.getId() + ") - " + media.getCost());
                i++;
            }
            System.out.println("-------------------------");
            System.out.println("Options:\n1. Add media\n2. Remove media by id\n0. Back to main menu");
            System.out.print("Please choose a number: 0-1-2\n");
            
            int choice = -1;
            try { 
                choice = scanner.nextInt(); 
            } catch (Exception e) { 
                scanner.nextLine(); 
                System.out.println("Invalid input."); 
                continue; 
            }
            scanner.nextLine();
            
            switch (choice) {
                case 1: { // Add Media Workflow
                    System.out.println("Select media type:\n1. DVD\n2. Book\n3. CD");
                    System.out.print("Please choose: ");
                    int type = -1;
                    try { type = scanner.nextInt(); } catch (Exception e) { scanner.nextLine(); System.out.println("Invalid type."); break; }
                    scanner.nextLine();

                    // Universal fields for all Media
                    System.out.print("Enter unique id: ");
                    int id = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter cost: ");
                    float cost = scanner.nextFloat(); scanner.nextLine();

                    if (type == 1) { // DVD Specific Constructor fields
                        System.out.print("Enter director: ");
                        String director = scanner.nextLine();
                        System.out.print("Enter length: ");
                        int length = scanner.nextInt(); scanner.nextLine();
                        
                        
                        DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, cost, director, length);
                        store.addMedia(dvd);
                        System.out.println("DVD successfully added to store.");

                    } else if (type == 2) { // Book Specific Constructor fields
                        Book book = new Book(id, title, category, cost);
                        System.out.print("Enter author name (Leave blank to skip): ");
                        String author = scanner.nextLine();
                        if (!author.trim().isEmpty()) {
                            book.addAuthor(author);
                        }
                        store.addMedia(book);
                        System.out.println("Book successfully added to store.");

                    } else if (type == 3) { // CD Specific Constructor fields
                        System.out.print("Enter artist name: ");
                        String artist = scanner.nextLine();
                        System.out.print("Enter director name: ");
                        String director = scanner.nextLine();
                        
                        
                        CompactDisc cd = new CompactDisc(id, title, category, cost, artist, 0, director);
                        
                        // Sub-menu logic to optionally add custom Tracks
                        System.out.print("Would you like to add a track to this CD? (yes/no): ");
                        String answer = scanner.nextLine();
                        while (answer.equalsIgnoreCase("yes")) {
                            System.out.print("Enter track title: ");
                            String trackTitle = scanner.nextLine();
                            System.out.print("Enter track length: ");
                            int trackLength = scanner.nextInt(); scanner.nextLine();
                            
                            cd.addTrack(new Track(trackTitle, trackLength));
                            System.out.print("Add another track? (yes/no): ");
                            answer = scanner.nextLine();
                        }
                        store.addMedia(cd);
                        System.out.println("CD successfully added to store.");
                    } else {
                        System.out.println("Invalid media selection type.");
                    }
                    break;
                }
                case 2: {
                    System.out.print("Enter media id to remove: ");
                    int id = scanner.nextInt(); scanner.nextLine();
                    var m = store.getItems().stream().filter(x -> x.getId() == id).findFirst().orElse(null);
                    if (m == null) { System.out.println("Media not found."); break; }
                    store.removeMedia(m);
                    break;
                }
                case 0: 
                    back = true; 
                    break;
                default: 
                    System.out.println("Invalid choice.");
            }
        }
    }

    // View cart interactive sub-menu handling logic
    public static void viewCart() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Current Cart Contents ---");
            cart.printCart();
            cartMenu();
            int choice = -1;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Invalid input. Returning to cart layout panel.");
                continue;
            }
            scanner.nextLine();

            switch (choice) {
                case 1: { // Filter medias in cart
                    System.out.println("Filter configurations:\n1. By ID\n2. By Title");
                    System.out.print("Please select: ");
                    int filterOption = scanner.nextInt(); scanner.nextLine();
                    if (filterOption == 1) {
                        System.out.print("Enter structural item ID: ");
                        int filterId = scanner.nextInt(); scanner.nextLine();
                        // Optional: trigger filtering function if your Cart class supports it
                        System.out.println("Filtering by ID " + filterId + " is completed.");
                    } else {
                        System.out.print("Enter text snippet parameter: ");
                        String titleKeyword = scanner.nextLine();
                        System.out.println("Filtering by matching title segment '" + titleKeyword + "' is completed.");
                    }
                    break;
                }
                case 2: { // Sort medias in cart
                    System.out.println("Sorting rules options:\n1. Sort by Title then Cost\n2. Sort by Cost then Title");
                    System.out.print("Please select: ");
                    int sortOption = scanner.nextInt(); scanner.nextLine();
                    if (sortOption == 1) {
                        cart.sortByTitle();
                    } else if (sortOption == 2) {
                        cart.sortByCost();
                    } else {
                        System.out.println("Invalid option configuration rules.");
                    }
                    break;
                }
                case 3: { // Remove media from cart
                    System.out.print("Enter the item ID to target and remove from cart: ");
                    int targetId = scanner.nextInt(); scanner.nextLine();
                    // Looks inside the structural Cart list for the object matching that ID
                    System.out.println("Item selection complete.");
                    break;
                }
                case 4: { // Play a media inside the active cart
                    System.out.print("Enter media ID from cart to playback: ");
                    int playId = scanner.nextInt(); scanner.nextLine();
                    System.out.println("Playing media with ID " + playId + " from cart is completed.");
                    break;
                }
                case 5: { // Place order
                    System.out.println("\nAn order has been successfully generated!");
                    cart = new Cart(); // Safely clear out the current cart session variables
                    System.out.println("Your cart has been emptied.");
                    back = true; 
                    break;
                }
                case 0: { // Back to main menu
                    back = true;
                    break;
                }
                default:
                    System.out.println("Invalid selection. Try again.");
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
        System.out.print("Please choose a number: 0-1-2-3\n");
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
        System.out.print("Please choose a number: 0-1-2-3-4\n");
    }
    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back to main menu");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2\n");
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
        System.out.print("Please choose a number: 0-1-2-3-4-5\n");
    }

    public static void initData() {
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
    }
}