package hust.soict.dsai.aims.media;
import java.util.Comparator;

public class Media {
    public  int id;
    public  String title;
    public  String category;
    public  float cost;

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // add comparator for sorting by title and cost
    public static final Comparator<Media> BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> BY_COST_TITLE = new MediaComparatorByCostTitle();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Media other = (Media) obj;
        return title.equals(other.title) && category.equals(other.category) && cost == other.cost;
    }

    // Getters and setters
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public float getCost() {
        return cost;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
}
