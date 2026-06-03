package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        initData();
        
        javax.swing.SwingUtilities.invokeLater(() -> {
            new StoreScreen(store, cart);
        });
    }

    public static void initData() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, "Roger Allers", 87);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, "George Lucas", 124);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladdin", "Animation", 18.99f, "John Musker", 90);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        Book book1 = new Book(4, "The Great Gatsby", "Novel", 10.99f);
        book1.addAuthor("FFS");
        Book book2 = new Book(5, "AAAAAAAAAAAAAAAAAA", "Novel", 12.99f);
        book2.addAuthor("Hai Dang");
        store.addMedia(book1);
        store.addMedia(book2);

        CompactDisc cd1 = new CompactDisc(6, "Thriller", "Pop", 14.99f, "Michael Jackson", 12, "Pop");
        cd1.addTrack(new Track("Michael Jackson", 6));
        cd1.addTrack(new Track("Thriller", 5));
        cd1.addTrack(new Track("Beat It", 4));
        store.addMedia(cd1);

        // Error DVD for testing exception
        DigitalVideoDisc errorDvd = new DigitalVideoDisc(8, "Error DVD Testing", "Testing", 15.0f, "Unknown", -5);
        store.addMedia(errorDvd);
    }
}