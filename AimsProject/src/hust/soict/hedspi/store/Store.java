package hust.soict.hedspi.store;
import java.util.ArrayList;
import hust.soict.hedspi.media.Media;
public class Store {
    // Thuộc tính: mảng chứa các DVD trong cửa hàng
    private static ArrayList<Media> itemsInStore = new ArrayList<Media>();
    // Phương thức thêm DVD vào cửa hàng
    public static void addMedia(Media media) {
        boolean existed = false;
        for (Media item : itemsInStore) {
            if (item.getTitle().equals(media.getTitle())) {
                existed = true;
                break;
            }
        }

        if (!existed) {
            itemsInStore.add(media);
            System.out.println("The media has been added in Store.");
        } else {
            System.out.println("The media is already in the store.");
        }
    }
    // Phương thức xóa DVD khỏi cửa hàng
    public void removeMedia(Media media) {
        boolean existed = false;
        for (Media item : itemsInStore) {
            if (item.getTitle().equals(media.getTitle())) {
                itemsInStore.remove(item);
                System.out.println("The media has been removed from Store.");
                existed = true;
                break;
            }
        }
        if (!existed) {
            System.out.println("The media is not in the store.");
        }
    }

    public static ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    // Hiển thị tất cả các phương tiện trong cửa hàng
    public void printStore() {
        for (Media media : itemsInStore) {
            System.out.println(media.toString());
        }
    }
    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equals(title)) {
                return media;
            }
        }
        return null;
    }
}