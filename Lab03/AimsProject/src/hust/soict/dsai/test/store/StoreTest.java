public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);
        store.addDigitalVideoDisc(dvd1);
        store.addDigitalVideoDisc(dvd2);
        store.addDigitalVideoDisc(dvd3);
        store.removeDigitalVideoDisc(dvd2);
        // Remove a disc not in Store
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Matrix", "Science Fiction", "The Wachowskis", 136, 14.99f);
        store.removeDigitalVideoDisc(dvd4);
        // print the remaining discs
        System.out.println("Remaining discs:");
        for (int i = 0; i < store.numberOfItems; i++) {
            System.out.println(store.itemInStore[i].getTitle());
        }
    }
}
