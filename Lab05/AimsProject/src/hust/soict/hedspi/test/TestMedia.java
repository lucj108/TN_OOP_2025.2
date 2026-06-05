package hust.soict.hedspi.test;

import java.util.ArrayList;
import java.util.List;
import hust.soict.hedspi.aims.media.*; 

public class TestMedia {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        CompactDisc cd = new CompactDisc("Music Album", "Music", 15.5f, 30, "Director", "Artist");
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Book book = new Book("Clean Code", "Education", 25.0f);

        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}