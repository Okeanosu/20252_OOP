package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Store {
    private ArrayList<Media> itemInStore;
    public int numberOfItems;

    public Store() {
        itemInStore = new ArrayList<>();
        numberOfItems = 0;
    }
    // Add media to the store
    public void addMedia(Media media) {
        itemInStore.add(media);
        numberOfItems++;
    }
    // Remove media from the store
    public void removeMedia(Media media) {
        if (itemInStore.remove(media)) {
            numberOfItems--;
            System.out.println("The media has been removed from the store.");
        } else {
            System.out.println("The media is not in the store.");
        }
    }

    // Expose items for read-only operations
    public ArrayList<Media> getItemsOrdered() {
        return itemInStore;
    }
}

