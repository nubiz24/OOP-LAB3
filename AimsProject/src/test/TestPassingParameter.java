//package test;
//import hust.soict.hedspi.media.DigitalVideoDisc;
//
//public class TestPassingParameter {
//    public static void main(String[] args) {
//        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
//        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
//
//        swap(jungleDVD, cinderellaDVD);
//        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
//        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
//        changeTitle(jungleDVD, cinderellaDVD.getTitle());
//        System.out.println("jungle DVD title: " + jungleDVD.getTitle());
//    }
//
//    public static void swap(DigitalVideoDisc o1, DigitalVideoDisc o2){
//        String tmp1 = o1.getTitle();
//        String tmp2 = o1.getCategory();
//        String tmp3 = o1.getDirector();
//        String tmp4 = o2.getTitle();
//        String tmp5 = o2.getCategory();
//        String tmp6 = o2.getDirector();
//        o1.setTitle(tmp4);
//        o1.setCategory(tmp5);
//        o1.setDirector(tmp6);
//        o2.setTitle(tmp1);
//        o2.setCategory(tmp2);
//        o2.setDirector(tmp3);
//    }
//
//    public static void changeTitle(DigitalVideoDisc dvd, String title) {
//        String oldTitle = dvd.getTitle();
//        dvd.setTitle(title);
//        dvd = new DigitalVideoDisc(oldTitle);
//    }
//}
