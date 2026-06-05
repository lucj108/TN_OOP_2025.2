package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.hedspi.aims.exception.LimitExceededException;
import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {

	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = 
			FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }	
	public float totalCost() {
        float sum = 0;
        for (Media temp : itemsOrdered) {
        	sum += temp.getCost();
        }
        return sum;
    }
    
	public void addMedia(Media m) throws LimitExceededException {
	    if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
	        itemsOrdered.add(m);
	        System.out.println("The media has been added.");
	    } else {
	        throw new LimitExceededException("ERROR: The number of "
	        		+ "media has reached its limit");
	    }
	}
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media has been removed.");
        } else {
            System.out.println("The media is not in the cart.");
        }
    }
	/*
    // -----------------------------Lab03-------------------------------------------------------------
    // Thuc hanh nap chong phuong thuc - Phan 2
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) { // Khac biet kieu tham so
    	
    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) { // Khac biet SL tham so
    	
    }
    
    // In danh sach - Phan 6
    public void print() {
    	System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i=0; i<qtyOrdered; i++)
        {
        	System.out.println((i+1) + ". " + itemsOrdered[i].toString());
        }
        System.out.println("Totalcost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }
    
    // Tim kiem theo ID
    public void search(int id) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("Found match: " + itemsOrdered[i].toString());
                found = true;
                break; 
            }
        }
        if (!found) {
            System.out.println("No match found for ID: " + id);
        }
    }

    // Tim kiem theo Title
    public void search(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println("Found match: " + itemsOrdered[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match found for title: " + title);
        }
    }
    */
    
    // -----------------------------Lab04-------------------------------------------------------------
    // Test sort - Phan 12
    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("The Cart is sorted by Title!");
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("The Cart is sorted by Cost!");
    }
    
    public void print() {
    	if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is currently empty.");
            return;
    	}
    	int cnt = 1;
    	for (Media m : itemsOrdered) {
    		System.out.println(cnt + ". " + m.toString());
    		cnt++;
    	}
    }
    
    public Media searchByTitle(String title) {
    	for (Media m : itemsOrdered) {
    		if (title.equalsIgnoreCase(m.getTitle())) return m;
    	}
    	return null;
    }
    
   public List<Media> filterById(int id) {
        List<Media> filteredList = new ArrayList<Media>();
        for (Media m : itemsOrdered) {
            if (m.getId() == id) {
                filteredList.add(m);
            }
        }
        return filteredList;
    }

    public List<Media> filterByTitle(String title) {
        List<Media> filteredList = new ArrayList<Media>();
        
        for (Media m : itemsOrdered) {
            if (m.getTitle().toLowerCase().contains(title.toLowerCase())) {
                filteredList.add(m);
            }
        }
        
        if (filteredList.isEmpty()) {
            System.out.println("No media found with title containing: " + title);
        } else {
            System.out.println("Found " + filteredList.size() + " media(s) with title containing: " + title);
        }
        
        return filteredList;
    }
    public void emptyCart() {
        itemsOrdered.clear();
        System.out.println("The cart has been cleared.");
    }
}
