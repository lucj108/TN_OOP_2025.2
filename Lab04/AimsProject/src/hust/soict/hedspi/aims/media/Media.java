package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = 
			new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = 
    			new MediaComparatorByCostTitle();
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public String getCategory() {
		return category;
	}


	public float getCost() {
		return cost;
	}

	public void setCost(float cost) throws IllegalArgumentException {
	    if (cost < 0) {
	        throw new IllegalArgumentException("ERROR: Cost cannot be negative.");
	    }
	    this.cost = cost;
	}
	
	public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
	
	@Override
	public boolean equals(Object tmp) {
		if (this == tmp) return true;
		if (tmp == null || !(tmp instanceof Media)) return false;
		Media other = (Media) tmp;
		return this.getTitle() != null && 
				this.getTitle().equalsIgnoreCase(other.getTitle());
	}
	
}
