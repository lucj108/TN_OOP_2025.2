package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}
	public CompactDisc(String title, String category, float cost, int length, String director, String artist) {
		super(title, category, cost, length, director);
		this.artist = artist;
	}
	
	public CompactDisc(String title, String category, String director, String artist, float cost) {
		super(title, category, cost, 0, director); 
		this.artist = artist;
	}
	
	public void addTrack(Track track) {
		if (!tracks.contains(track)) {
			tracks.add(track);
			System.out.println("Done! Has been added.");
		} else {
			System.out.println("This track already existed!");
		}
	}
	
	public void removeTrack(Track track) {
		if(tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("Done! Has been removed.");
		} else {
			System.out.println("This track don't existed!");
		}
	}

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            java.util.Iterator<Track> iter = tracks.iterator();
            Track nextTrack;
            
            while (iter.hasNext()) {
                nextTrack = iter.next();
                try {
                    nextTrack.play();
                } catch (PlayerException e) {
                    throw e; 
                }
            }
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }
    
    @Override
	public String toString() {
    	return "CD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getArtist	() + " - " + this.getLength() + ": " + this.getCost() + " $";
    }
}
