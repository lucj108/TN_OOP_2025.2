package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private int id;
	private String title;
	private String category;
	private float cost;
	private List<String> authors = new ArrayList<String>();

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
			this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}

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
	public Book() {
		
	}

}
