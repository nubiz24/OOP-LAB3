package hust.soict.hedspi.media;

public class DigitalVideoDisc extends Disc implements Playable {
	private static int nbDigitalVideoDiscs = 0;

	public DigitalVideoDisc(String title, String category, float cost, int length, String director) {
		super(nbDigitalVideoDiscs++, title, category, cost, length, director);
	}

	// Ghi đè phương thức equals
	@Override
	public boolean equals(Object obj) {
		// Kiểm tra nếu đối tượng so sánh chính là đối tượng hiện tại
		if (this == obj) return true;
		// Kiểm tra nếu obj là null hoặc không cùng kiểu
		if (obj == null || getClass() != obj.getClass()) return false;
		// Ép kiểu obj thành DigitalVideoDisc
		DigitalVideoDisc disc = (DigitalVideoDisc) obj;
		// So sánh các thuộc tính
		return this.getTitle().equals(disc.getTitle()) &&
				this.getCategory().equals(disc.getCategory()) &&
				this.getDirector().equals(disc.getDirector()) &&
				this.getCost() == disc.getCost() &&
				this.getLength() == disc.getLength();
	}


	@Override
	public String toString() {
		return "DVD - " + this.getTitle() + " - " +
				this.getCategory() + " - " + getDirector() + " - " +
				getLength() + " mins: " + this.getCost() + " $";
	}

	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

	@Override
	public int compareTo(Media other) {
		if (other instanceof DigitalVideoDisc) {
			DigitalVideoDisc dvd = (DigitalVideoDisc) other;
			int titleCompare = this.getTitle().compareTo(dvd.getTitle());
			if (titleCompare != 0) {
				return titleCompare;
			}
			int lengthCompare = Integer.compare(dvd.getLength(), this.getLength()); // Sắp xếp theo chiều dài giảm dần
			if (lengthCompare != 0) {
				return lengthCompare;
			}
			return Float.compare(dvd.getCost(), this.getCost()); // Sắp xếp theo giá giảm dần
		}
		return super.compareTo(other); // Nếu không phải DVD, sử dụng phương thức compareTo trong Media
	}
}
