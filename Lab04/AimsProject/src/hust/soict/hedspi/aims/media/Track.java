package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable {
	private String title;
	private int length;
	
	
	public String getTitle() {
		return title;
	}


	public int getLength() {
		return length;
	}


	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	public void play() throws PlayerException {
	    if (this.getLength() > 0) {
	        System.out.println("Playing Track: " + this.getTitle());
	        System.out.println("Track length: " + this.getLength());
	    } else {
	        System.err.println("ERROR: Track length is non-positive!");
	        throw new PlayerException("ERROR: Track length is non-positive!");
	    }
	}
	
	@Override
	public boolean equals(Object tmp) {
		if (this == tmp) return true;
		if (tmp == null || !(tmp instanceof Track)) return false;
		Track other = (Track)tmp;
		return this.getLength() == other.getLength() &&
				this.getTitle() != null && this.getTitle().equalsIgnoreCase(other.getTitle());
		
		
	}

}
