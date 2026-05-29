package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    // Constructor
    public CompactDisc(int id, String title, String category, float cost, String director, int length, String artist) {
        super(id, title, category, cost, director, length);
        this.artist = artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        }
    }
    public void removeTrack(Track track) {
        tracks.remove(track);
    }

    // Override getLength()
    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    // Getters
    public String getArtist() {
        return artist;
    }

    public int getNumberOfTracks() {
        return tracks.size();
    }

    public void play() {
        System.out.println("Playing compact disc: " + this.title);
        System.out.println("Artist: " + this.artist);
        System.out.println("Number of tracks: " + this.getNumberOfTracks());
        System.out.println("Total length: " + this.getLength());
    }

    // Override toString()
    @Override
    public String toString() {
        return "CD - " + title + " - " + category + " - " + director + " - " + artist + ": " + cost + "$";
    }
}
