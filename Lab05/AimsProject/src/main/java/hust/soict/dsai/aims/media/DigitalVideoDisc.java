package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDisc = 0;

    // Constructor
    public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost, director, length);
        nbDigitalVideoDisc++;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public static int getNbDigitalVideoDisc() {
        return nbDigitalVideoDisc;
    }
    public boolean search(String title) {
        String[] words = title.split(" ");
        for (String word : words) {
            if (!this.title.toLowerCase().contains(word.toLowerCase())) {
                return false;
            }
        }
        return true;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DigitalVideoDisc other = (DigitalVideoDisc) obj;
        return title.equals(other.title) && category.equals(other.category) && director.equals(other.director) && length == other.length && cost == other.cost;
    }

    @Override
    public void play() throws PlayerException {
        if (length <= 0) {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
        System.out.println("Playing DVD: " + this.title);
        System.out.println("DVD length: " + this.length);
    }

    // override toString()
    @Override
    public String toString() {
        return "DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + "$";
    }

}
