package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;

public class Cart  {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    private int qtyOrdered = 0;
    //Constructor
    public Cart() {
    
    }
    // add media to cart
    public void addMedia(Media media) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            qtyOrdered++;
            System.out.println("The media has been added");
        } else {
            System.out.println("The cart is full. Cannot add more media.");
        }
    }
    // remove media from cart
    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            qtyOrdered--;
            System.out.println("The media has been removed");
        } else {
            System.out.println("The media is not in the cart.");
        }
    }
    // calculate total cost of items in cart
    public float totalCost() {
        float total = 0.0f;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }
    // Sort by Title then Cost
    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.BY_TITLE_COST);
        System.out.println("The cart has been sorted by title.");
    }
    // Sort by Cost then Title
    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.BY_COST_TITLE);
        System.out.println("The cart has been sorted by cost.");
    }
    // print the contents of the cart
    public void printCart() {
        System.out.println("***********************CART***********************");
        for (Media media : itemsOrdered) {
            System.out.println(media.getTitle() + " - " + media.getCategory() + " - " + media.getCost());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("************************************************");
    }
    // search for media in cart by title
    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null; // not found
    }
    // search for media in cart by id
    public Media searchById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null; // not found
    }

}
