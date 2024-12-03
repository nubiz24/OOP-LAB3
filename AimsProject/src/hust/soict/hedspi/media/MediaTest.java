package hust.soict.hedspi.media;
import java.util.ArrayList;
public class MediaTest {
    public static void main(String[] args) {
        // Tạo một ArrayList chứa các phương tiện Media
        ArrayList<Media> mediaList = new ArrayList<Media>();
        // Thêm các phương tiện vào danh sách
        mediaList.add(new CompactDisc(1, "CD Title", "Music", 15.99f, 60, "Director", "Artist"));
        mediaList.add(new DigitalVideoDisc("DVD Title", "Movies", 20.99f, 120, "Director"));
        mediaList.add(new Book(1, "The Da Vinci Code", "Mystery", 12.50f, "Dan Brown"));
        // Duyệt qua danh sách và in thông tin của các phương tiện
        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
    }
}