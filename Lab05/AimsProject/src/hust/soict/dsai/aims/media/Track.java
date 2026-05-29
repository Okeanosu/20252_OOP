package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    // Constructor
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Track other = (Track) obj;
        return title.equals(other.title) && length == other.length;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public void play() {
        System.out.println("Playing track: " + this.title);
        System.out.println("Track length: " + this.length);
    }
}
