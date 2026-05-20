package hust.soict.hedspi.aims.store;
import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;

public class Store {
	
	public static final int MAX_NUMBERS_STORE = 1000;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		if (itemsInStore.contains(media)) {
            System.out.println("The media already exists!");
        } else {
            itemsInStore.add(media);
            System.out.println("The media has been added!");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("The media has been removed!");
        } else {
            System.out.println("The media is not in the store.");
        }
    }
}