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
	
	public void removeAuthor(String authorName) throws Exception {
	    if (!authors.contains(authorName)) {
	        throw new Exception("ERROR: Author " + authorName + " is not listed in this book.");
	    }
	    authors.remove(authorName);
	}
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}

	@Override
	public String toString() {
    	return "Book - " + this.getTitle() + " - " + this.getCategory() + ": " + this.getCost() + " $";
    }
}
