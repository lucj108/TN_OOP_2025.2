package hust.soict.hedspi.aims.store;
<<<<<<< HEAD

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_CAPACITY = 1000;
    private int qtyInStore = 0;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_CAPACITY];
    
    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < MAX_CAPACITY) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("The disc \"" + dvd.getTitle() + "\" has been added to the store.");
        } else {
            System.out.println("The store is already full. Cannot add \"" + dvd.getTitle() + "\".");
        }
    }
    
    // xoa dia khoi cua hang bang id
    public void removeDVD(DigitalVideoDisc dvd) {
        if (qtyInStore == 0) {
            System.out.println("The store is empty.");
            return;
        }
        int indexToRemove = -1;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i].getId() == dvd.getId()) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            for (int i = indexToRemove; i < qtyInStore - 1; i++) {
                itemsInStore[i] = itemsInStore[i + 1];
            }
            itemsInStore[qtyInStore - 1] = null; // don rac bo nho

            qtyInStore--;
            System.out.println("The disc \"" + dvd.getTitle() + "\" has been removed from the store.");
        } else {
            System.out.println("The disc \"" + dvd.getTitle() + "\" was not found in the store.");
        }
    }
=======
import hust.soict.hedspi.aims.disc.*;

public class Store {
	
	public static final int MAX_NUMBERS_STORE = 1000;
	private DigitalVideoDisc itemsInStore[] =
			new DigitalVideoDisc[MAX_NUMBERS_STORE];
	
	private int qtyInStore=0;
	
	public void addDVD(DigitalVideoDisc dvd) {
		if (qtyInStore < MAX_NUMBERS_STORE) {
			itemsInStore[qtyInStore++] = dvd;
			System.out.println("The disc has been added!");
		}
		else {
            System.out.println("The Store is almost full!");
        }
	}
	
	public void removeDVD(DigitalVideoDisc dvd) {
		for (int i = 0; i < qtyInStore; i++) {
			if (dvd == itemsInStore[i]) {
				for (int j = i; j < qtyInStore-1; j++) {
					itemsInStore[j] = itemsInStore[j+1];
				}
				itemsInStore[--qtyInStore] = null;
                System.out.println("The disc has been removed");
				return;
			}
		}
		System.out.println("The disc is not in the Store!");
	}
>>>>>>> hotfix/redo-lab03
}

