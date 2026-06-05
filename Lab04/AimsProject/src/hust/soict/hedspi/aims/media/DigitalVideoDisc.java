package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

	private static int nbDigitalVideoDiscs = 0;
	public DigitalVideoDisc(String title) {
		super(title, null, 0, 0, null);
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs);
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost, 0, null);
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs);
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, cost, 0, director);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, cost, length, director);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
	}
	
	// Lab 03
	// Phan 6
	@Override
	public String toString() {
    	return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + " $";
    }
	
	// Them phuong thuc isMatch
	public boolean isMatch(String title) {
	    String lowerTitle = this.getTitle().toLowerCase();
	    
	    String[] keywords = title.toLowerCase().split(" ");
	    
	    for (String word : keywords) {
	        if (lowerTitle.contains(word)) {
	            return true; 
	        }
	    }
	    return false; 
	}
	
	public void play() throws PlayerException {
	    if (this.getLength() > 0) {
	        System.out.println("Playing DVD: " + this.getTitle());
	        System.out.println("DVD length: " + this.getLength());
	    } else {
	        System.err.println("ERROR: DVD length is non-positive!");
	        throw new PlayerException("ERROR: DVD length is non-positive!");
	    }
	}
}
