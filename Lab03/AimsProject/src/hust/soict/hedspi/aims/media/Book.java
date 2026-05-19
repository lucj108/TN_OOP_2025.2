package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();

	
	public void addAuthor(String name) {
		if (!authors.contains(name)) {
			authors.add(name);
			System.out.println("Author has been added!");
		} else {
			System.out.println("The author already existed!");
		}
	}
	
	public void removeAuthor(String name) {
		if (authors.contains(name)) {
			authors.remove(name);
			System.out.println("Author has been removed!");
		} else {
			System.out.println("The author does not exist!");
		}
	}
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}

}
