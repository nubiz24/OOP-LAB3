//package hust.soict.hedspi.store;
//
//import hust.soict.hedspi.media.DigitalVideoDisc;
//
//public class StoreTest {
//    public static void main(String[] args) {
//        // Kiểm tra chương trình
//        Store store = new Store();
//
//        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Avengers: Endgame");
//        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Matrix");
//        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Inception");
//
//        // Thêm DVD
//        store.addDVD(dvd1);
//        store.addDVD(dvd2);
//        store.addDVD(dvd3);
//
//        // Thêm trùng lặp
//        store.addDVD(dvd2);
//
//        // Hiển thị cửa hàng
//        store.displayStore();
//
//        // Xóa DVD
//        store.removeDVD(dvd2);
//        store.removeDVD(new DigitalVideoDisc("Avatar"));
//
//        // Hiển thị lại sau khi xóa
//        store.displayStore();
//    }
//
//}
