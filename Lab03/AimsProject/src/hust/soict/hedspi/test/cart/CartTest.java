package hust.soict.hedspi.test.cart;
import hust.soict.hedspi.aims.cart.*;
import hust.soict.hedspi.aims.disc.*;

public class CartTest {

	public static void main(String[] args) {
		// Create a new cart
		Cart cart = new Cart();
			
		//Create new dvd object and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
				"Animation", "Roger Allers", 87, 19.95f);	
		cart.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
				"Science Fiction", "George Lucas", 87, 24.95f);
	    cart.addDigitalVideoDisc(dvd2);
		      
	    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
		      	"Animation", 18.99f);
		cart.addDigitalVideoDisc(dvd3);
		
		// Test the print method
		cart.print();
		
		// Test the search method
		System.out.println("---Test the search method---\n");
		cart.search(2);
		cart.search(5);
		cart.search("Aladin");
		cart.search("lion");
	}

}
