package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();
        
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        
        // kiem tra nap chong
        cart.addDigitalVideoDisc(dvd1, dvd2);
        cart.addDigitalVideoDisc(dvd3);
        
        // kiem tra in hoa don
        cart.print();
        
        // kiem tra tim kiem
        System.out.println("\n--- Testing Search ---");
        cart.searchByID(2); 
        cart.searchByTitle("aladin"); 
        cart.searchByTitle("Cinderella"); 
    }
}