public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);
        cart.addDigitalVideoDisc(dvd1, dvd2);
        cart.addDigitalVideoDisc(dvd3);
        cart.printCart();
        cart.removeDigitalVideoDisc(dvd2);
        cart.printCart();
        // test the search methods
        System.out.println("Search for 'Lion': " + dvd1.search("Lion"));
        System.out.println("Search for 'Star': " + dvd2.search("Star"));
        System.out.println("Search for 'Aladdin': " + dvd3.search("Aladdin"));
    }
}
