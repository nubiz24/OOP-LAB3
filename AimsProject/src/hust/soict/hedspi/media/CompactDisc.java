package hust.soict.hedspi.media;
import hust.soict.hedspi.exception.PlayerException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();
    public CompactDisc(String cdTitle, String cdCategory, String cdArtist, float cdCost) {
        super();
    }
    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }
    public String getArtist() {
        return artist;
    }
    // Phương thức thêm track vào danh sách
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track " + track.getTitle() + " is already in the list.");
        } else {
            tracks.add(track);
            System.out.println("Track " + track.getTitle() + " added to the list.");
        }
    }
    // Phương thức xóa track khỏi danh sách
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track " + track.getTitle() + " removed from the list.");
        } else {
            System.out.println("Track " + track.getTitle() + " is not in the list.");
        }
    }
    @Override
    public void play() throws PlayerException {
        // Kiểm tra độ dài của CD
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: CD length is non-positive");
        }

        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());

        // Lặp qua các track và phát
        Iterator<Track> iter = tracks.iterator();
        Track nextTrack;
        boolean trackErrorOccurred = false; // Cờ để kiểm tra có lỗi xảy ra khi phát track

        while (iter.hasNext()) {
            nextTrack = iter.next();
            try {
                nextTrack.play(); // Phát từng track
            } catch (PlayerException e) {
                // Nếu có lỗi với track này, thông báo lỗi và tiếp tục phát các track tiếp theo
                System.err.println("Error occurred while playing track: " + nextTrack.getTitle());
                JOptionPane.showMessageDialog(null, "Error playing track: " + nextTrack.getTitle() + "\n" + e.getMessage(),
                        "Track Playback Error", JOptionPane.ERROR_MESSAGE);
                trackErrorOccurred = true;
            }
        }

        // Nếu có lỗi xảy ra trong quá trình phát track, bạn có thể thông báo lại cho người dùng
        if (trackErrorOccurred) {
            System.err.println("Some tracks could not be played successfully.");
        }
    }
    @Override
    public String toString() {
        // Gọi phương thức getLength() từ lớp cha Disc, tránh đệ quy
        return "CD - " + this.getTitle() + " - " +
                this.getCategory() + " - " + getArtist() + " - " +
                super.getLength() + " mins: " + this.getCost() + " $";
    }
}