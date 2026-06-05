package hust.soict.hedspi.aims.screen;

import javax.swing.SwingUtilities;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class MainGUI {
    
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Ron Clements", 90, 18.99f);
        Book book1 = new Book("Harry Potter", "Fantasy", 20.00f);
        CompactDisc cd1 = new CompactDisc("Adele 21", "Music", "Unknown", "Adele", 15.50f);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(cd1);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StoreScreen(store, cart);
            }
        });
    }
}