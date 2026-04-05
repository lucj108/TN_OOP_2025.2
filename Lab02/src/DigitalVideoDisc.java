public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    //getter
    public String getTitle()
    {
        return title;
    }
    public String getCategory()
    {
        return category;
    }
    public String getDirector()
    {
        return director;
    }
    public int getLength()
    {
        return length;
    }
    public float getCost()
    {
        return cost;
    }
    //setter
    public void setCategory(String category) {
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }


    //-----
    // Tạo DVD với tiêu đề
    public DigitalVideoDisc(String title) {
        this.title = title;
    }

    // Tạo DVD với tiêu đề và thể loại và giá
    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Tạo DVD với tiêu đề, thể loại, đạo diễn và giá
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    // Tạo DVD với đầy đủ thông tin
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    // 3. Getter
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getDirector() { return director; }
    public int getLength() { return length; }
    public float getCost() { return cost; }
}
