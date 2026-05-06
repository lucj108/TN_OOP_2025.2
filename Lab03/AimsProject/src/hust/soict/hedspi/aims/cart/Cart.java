package hust.soict.hedspi.aims.cart;
<<<<<<< HEAD

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    // them 1 dia
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
        } else {
            System.out.println("The cart is already full. Cannot add: " + disc.getTitle());
        }
    }
    
    // nap chong: them mang dia
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            addDigitalVideoDisc(disc);
        }
    }
    
    // nap chong: them 2 dia
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1); 
        addDigitalVideoDisc(dvd2);
    }
    
    // xoa dia dua vao id
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == 0) {
            System.out.println("The cart is empty.");
            return;
        }
        int indexToRemove = -1;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == disc.getId()) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            for (int i = indexToRemove; i < qtyOrdered - 1; i++) {
                itemsOrdered[i] = itemsOrdered[i + 1];
            }
<<<<<<< HEAD
            itemsOrdered[qtyOrdered - 1] = null; // don rac bo nho
=======
            itemsOrdered[qtyOrdered - 1] = null; // don rac
>>>>>>> 139ca67a8c251aa34277a797cccc30cb8d2f1ae9
            qtyOrdered--;
            System.out.println("The disc \"" + disc.getTitle() + "\" has been removed.");
        } else {
            System.out.println("The disc \"" + disc.getTitle() + "\" was not found in the cart.");
        }
    }

    // tinh tong tien
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
    
    // in hoa don
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println(itemsOrdered[i].toString());
        }
        System.out.printf("Total Cost: %.2f $\n", totalCost());
        System.out.println("***************************************************");
    }
    
    // tim kiem theo id
    public void searchByID(int targetID) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(targetID)) {
                System.out.println("DVD Found: " + itemsOrdered[i].toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No DVD with ID " + targetID + " found!");
        }
    }
    
    // tim kiem theo tieu de
    public void searchByTitle(String targetTitle) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(targetTitle)) {
                System.out.println("DVD Found: " + itemsOrdered[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No DVD with title \"" + targetTitle + "\" found!");
        }
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 139ca67a8c251aa34277a797cccc30cb8d2f1ae9
=======
import hust.soict.hedspi.aims.disc.*;

public class Cart {

	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc; 
            qtyOrdered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) { 
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null; 
                qtyOrdered--; 
                System.out.println("The disc has been removed");
                return;
            }
        }
        System.out.println("The disc is not in the cart");
    }

    public float totalCost() {
        float sum = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            sum += itemsOrdered[i].getCost(); 
        }
        return sum;
    }
    
    // Lab03
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
}

>>>>>>> hotfix/redo-lab03
