public class Store {
    public DigitalVideoDisc[] itemInStore;
    public int numberOfItems;

    public Store() {
        itemInStore = new DigitalVideoDisc[100]; // Assuming a maximum of 100 items in the store
        numberOfItems = 0;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (numberOfItems < itemInStore.length) {
            itemInStore[numberOfItems] = disc;
            numberOfItems++;
        } else {
            System.out.println("The store is full. Cannot add more discs.");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < numberOfItems; i++) {
            if (itemInStore[i].equals(disc)) {
                for (int j = i; j < numberOfItems - 1; j++) {
                    itemInStore[j] = itemInStore[j + 1];
                }
                itemInStore[numberOfItems - 1] = null;
                numberOfItems--;
                System.out.println("The disc has been removed from the store.");
                return;
            }
        }
        System.out.println("The disc is not in the store.");
    }
}

