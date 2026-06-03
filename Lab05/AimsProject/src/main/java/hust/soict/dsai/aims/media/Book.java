package hust.soict.dsai.aims.media;

import java.util.List;
import java.util.ArrayList;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    // Constructor
    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }
    // book specific methods
    public List<String> getAuthors() {
        return authors;
    }

    public void addAuthor(String authorNameString) {
        if (!authors.contains(authorNameString)) {
            authors.add(authorNameString);
        }
    }

    public void removeAuthor(String authorNameString) {
        authors.remove(authorNameString);
    }

    // Override toString()
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", cost=" + cost +
                ", authors=" + authors +
                '}';
    }
    
}
