package hust.soict.hedspi.aims.store;
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
}
