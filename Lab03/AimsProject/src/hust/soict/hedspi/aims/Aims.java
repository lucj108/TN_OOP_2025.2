package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        // tao gio hang moi
        Cart anOrder = new Cart();

        // tao cac doi tuong dvd
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        // them dvd vao gio hang
        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);
        anOrder.addDigitalVideoDisc(dvd3);

        // in thong tin gio hang hien tai
        anOrder.print();
        
        // thu xoa 1 dia khoi gio hang
        anOrder.removeDigitalVideoDisc(dvd2);
        
        // in lai gio hang sau khi xoa
        System.out.println("\n--- sau khi xoa dvd ---");
        anOrder.print();
    }
}