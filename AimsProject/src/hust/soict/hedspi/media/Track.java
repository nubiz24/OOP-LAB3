package hust.soict.hedspi.media;

import hust.soict.hedspi.exception.PlayerException;

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
    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            throw new PlayerException("ERROR: Track's Length is non-positive!!");
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Kiểm tra tham chiếu
        if (obj == null || getClass() != obj.getClass()) return false; // Kiểm tra kiểu đối tượng
        Track track = (Track) obj; // Ép kiểu
        return this.title.equals(track.title) && this.length == track.length; // So sánh title và length
    }
}