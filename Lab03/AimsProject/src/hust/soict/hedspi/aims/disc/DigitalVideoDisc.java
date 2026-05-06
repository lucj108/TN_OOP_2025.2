package hust.soict.hedspi.aims.disc;

public class DigitalVideoDisc {
<<<<<<< HEAD
    // bien static dem so luong dia
    private static int nbDigitalVideoDiscs = 0;
    
    // thuoc tinh doi tuong luu id doc nhat
    private int id;
    
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getDirector() { return director; }
    public int getLength() { return length; }
    public float getCost() { return cost; }
    
    public void setTitle(String title) { this.title = title; }
    public void setCategory(String category) { this.category = category; }
    public void setDirector(String director) { this.director = director; }
    public void setLength(int length) { this.length = length; }
    public void setCost(float cost) { this.cost = cost; }

    public DigitalVideoDisc(String title) {
        this.title = title;
        this.id = ++nbDigitalVideoDiscs; // tu dong tang va gan id
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this(title); 
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this(title, category, cost);
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this(title, category, director, cost);
        this.length = length;
    }

    @Override
    public String toString() {
        return id + ". DVD - [" + title + "] - [" + category + "] - [" + director + "] - [" + length + "]: " + cost + " $";
    }
    
    // tim kiem tuong doi, khong phan biet hoa thuong
    public boolean isMatch(String title) {
        if (this.title == null || title == null) return false;
        return this.title.toLowerCase().contains(title.toLowerCase());
    }

    // tim kiem chinh xac theo id
    public boolean isMatch(int id) {
        return this.id == id;
    }
}
=======
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private static int nbDigitalVideoDiscs = 0;
	private int id;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	
	
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	
	// Lab 03
	// Phan 6
	public String toString() {
    	return "DVD - " + this.title + " - " + this.category + " - " + this.director + " - " + this.length + ": " + this.cost + " $";
    }
	
	// Them phuong thuc isMatch
	public boolean isMatch(String title) {
	    String lowerTitle = this.title.toLowerCase();
	    
	    String[] keywords = title.toLowerCase().split(" ");
	    
	    for (String word : keywords) {
	        if (lowerTitle.contains(word)) {
	            return true; 
	        }
	    }
	    return false; 
	}
	
	// Them phuong thuc GetID
	public int getId() {
		return id;
	}
	
}
>>>>>>> hotfix/redo-lab03
