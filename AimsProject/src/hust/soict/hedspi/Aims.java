package hust.soict.hedspi;

import hust.soict.hedspi.cart.Cart;
import hust.soict.hedspi.disc.DigitalVideoDisc;

import java.util.Scanner;



public class Aims {
	public static void main(String[] args) {

		Cart anOrder = new Cart();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
//		anOrder.addDigitalVideoDisc(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
//		anOrder.addDigitalVideoDisc(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
//		anOrder.addDigitalVideoDisc(dvd3);

//		anOrder.removeDigitalVideoDisc(dvd2);
//		anOrder.addDigitalVideoDisc(dvd2);

//		DigitalVideoDisc[] dvd = {dvd1, dvd2, dvd3};
//		anOrder.addDigitalVideoDisc(dvd);

//		anOrder.addDigitalVideoDisc(dvd2, dvd1);

//		System.out.println("Total Cost is: " + anOrder.totalCost());
//		System.out.println("The id of " + dvd1.getTitle() + " is " + dvd1.getId());

	}
}