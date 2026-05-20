package hust.soict.dsai.aims.media;

public class Disc extends Media {
    public  String director;
    public  int length;

    // Constructor
    public Disc(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    // Getters
    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }
}
