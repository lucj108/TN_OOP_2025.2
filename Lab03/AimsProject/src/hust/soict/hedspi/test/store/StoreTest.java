package hust.soict.hedspi.test.store;
import hust.soict.hedspi.aims.store.*;
import hust.soict.hedspi.aims.disc.*;

public class StoreTest {

	public static void main(String[] args) {
		// Create a new Store
		Store store = new Store();
		
		// Test the add method
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
				"Animation", "Roger Allers", 87, 19.95f);	
		store.addDVD(dvd1);
				
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
				"Science Fiction", "George Lucas", 87, 24.95f);
		store.addDVD(dvd2);
		      
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
				 "Animation", 18.99f);
		store.addDVD(dvd3);
				
		// Test the remove method
		store.removeDVD(dvd2);
		store.removeDVD(dvd2);
	}

}