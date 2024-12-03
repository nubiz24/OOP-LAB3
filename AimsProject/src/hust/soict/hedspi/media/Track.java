package hust.soict.hedspi.media;
public class Track implements Playable {
    private String title;
    private int length;
    // Constructor to initialize fields
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    // Getter for title
    public String getTitle() {
        return title;
    }
    // Getter for length
    public int getLength() {
        return length;
    }
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Kiểm tra tham chiếu
        if (obj == null || getClass() != obj.getClass()) return false; // Kiểm tra kiểu đối tượng
        Track track = (Track) obj; // Ép kiểu
        return this.title.equals(track.title) && this.length == track.length; // So sánh title và length
    }
}