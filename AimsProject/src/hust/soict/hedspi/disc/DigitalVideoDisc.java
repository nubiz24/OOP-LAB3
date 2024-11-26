package hust.soict.hedspi.disc;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private int id;

	private static int nbDigitalVideoDiscs = 0;

	public String getTitle() {
		return title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	    this.title = title;

		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
	    this.title = title;
	    this.category = category;
	    this.cost = cost;

		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
	    this.title = title;
	    this.category = category;
	    this.director = director;
	    this.cost = cost;

		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
	    this.title = title;
	    this.category = category;
	    this.director = director;
	    this.length = length;
	    this.cost = cost;

		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}

	public boolean isMatch(int id) {
		return this.id == id; // Kiểm tra ID
	}

	public boolean isMatch(String title) {
		return this.title.equalsIgnoreCase(title); // Kiểm tra title (không phân biệt hoa thường)
	}


	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(String category) {
		this.category = category;
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
}
