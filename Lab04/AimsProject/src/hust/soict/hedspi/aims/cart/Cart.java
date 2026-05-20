package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class Cart {

	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public float totalCost() {
        float sum = 0;
        for (Media temp : itemsOrdered) {
        	sum += temp.getCost();
        }
        return sum;
    }
    
	public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("The media has been added.");
        } else {
            System.out.println("The media is already in the cart.");
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
}
