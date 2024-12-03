package hust.soict.hedspi.cart;

import hust.soict.hedspi.media.DigitalVideoDisc;

import java.util.Scanner;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 69f, 87, "duong gay");
//        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 88f, 87, "son tung");
//        cart.addDigitalVideoDisc(dvd2);

//        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
//        cart.addDigitalVideoDisc(dvd3);

//        cart.printCart();


        System.out.println("Enter the title of DVD you want to search: ");

        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();

       //  Tìm kiếm DVD theo title
        if (cart.searchByTitle2(title)) {
            System.out.println("Found DVD with title \"" + title + "\"");
        } else {
            System.out.println("Not found DVD with title \"" + title + "\"");
        }

//        System.out.println("Enter the ID of DVD you want to search: ");
//
//        Scanner sc = new Scanner(System.in);
//        int idForSearch = sc.nextInt();
//
//        if (cart.searchById(idForSearch)) {
//            System.out.println("Found DVD with ID " + idForSearch);
//        } else {
//            System.out.println("Not found DVD with ID " + idForSearch);
//        }

        sc.close();

    }
}