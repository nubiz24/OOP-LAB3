package hust.soict.hedspi.cart;
import hust.soict.hedspi.media.Media;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    private DoubleProperty totalCost;

    public Cart() {
        this.itemsOrdered = FXCollections.observableArrayList();
        this.totalCost = new SimpleDoubleProperty(0);  // Khởi tạo tổng chi phí là 0
    }

    public DoubleProperty totalCostProperty() {
        return totalCost;
    }

    public float getTotalCost() {
        return (float) totalCost.get();  // Trả về giá trị tổng chi phí
    }
    // Constructor không tham số
    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println(media.getTitle() + " has been added to the cart.");
        } else {
            System.out.println(media.getTitle() + " is already in the cart.");
        }
        updateTotalCost();
    }
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println(media.getTitle() + " has been removed from the cart.");
        } else {
            System.out.println(media.getTitle() + " is not in the cart.");
        }
        updateTotalCost();
    }
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }
    // Cập nhật tổng chi phí mỗi khi có sự thay đổi trong giỏ hàng
    private void updateTotalCost() {
        double newTotalCost = 0;
        for (Media media : itemsOrdered) {
            newTotalCost += media.getCost();  // Giả sử getCost() trả về giá trị chi phí của media
        }
        totalCost.set(newTotalCost);  // Cập nhật tổng chi phí vào DoubleProperty
    }
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (Media media : itemsOrdered) {
            System.out.println(media.toString());
        }
        System.out.println("Total cost: " + totalCost() + "$");
        System.out.println("**************************************************");
    }
    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equals(title))
                return media;
        }
        return null;
    }

    public boolean searchByTitle2(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equals(title)) return true;
        }

        return false;
    }

    public Media searchById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id)
                return media;
        }
        return null;
    }
    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        Iterator<Media> iterator = itemsOrdered.iterator();
        while (iterator.hasNext()) {
            System.out.println((iterator.next()).toString());
        }
    }
    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        Iterator<Media> iterator = itemsOrdered.iterator();
        while (iterator.hasNext()) System.out.println((iterator.next()).toString());
    }
    public void empty() {
        itemsOrdered.clear();
    }

    public ObservableList<Media> getItemsOrdered() {
        return (ObservableList<Media>) itemsOrdered;
    }
}