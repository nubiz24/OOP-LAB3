package hust.soict.hedspi.store;
import java.util.LinkedList;
import hust.soict.hedspi.disc.DigitalVideoDisc;

public class Store {
    private LinkedList<DigitalVideoDisc> itemsInStore = new LinkedList<>();

    private boolean checkDVD(DigitalVideoDisc disc) {
        for (DigitalVideoDisc dvd : itemsInStore) {
            if (dvd.equals(disc)) {
                return true;
            }
        }
        return false;
    }

    public void addDVD(DigitalVideoDisc disc) {
        if (!checkDVD(disc)) {
            itemsInStore.add(disc);
            System.out.println(disc.getTitle() + " has been added to the store!");
        } else {
            System.out.println(disc.getTitle() + " already exists in the store!");
        }
    }

    public void removeDVD(DigitalVideoDisc disc) {
        if (checkDVD(disc)) {
            itemsInStore.remove(disc);
            System.out.println(disc.getTitle() + " has been deleted from the store!");
        } else {
            System.out.println("There is no " + disc.getTitle() + " in the store!");
        }
    }

    public void displayStore() {
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
        } else {
            System.out.println("DVDs in store:");
            for (DigitalVideoDisc dvd : itemsInStore) {
                System.out.println("- " + dvd.getTitle());
            }
        }
    }

}
