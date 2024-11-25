package hust.soict.hedspi.cart;

import hust.soict.hedspi.disc.DigitalVideoDisc;

public class Cart {
  private int qtyOrdered = 0;
  public static final int MAX_NUMBERS_ORDERD = 20;
  private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERD];
  private int itemQuantity = 0;

  public void addDigitalVideoDisc(DigitalVideoDisc disc) {
    if (qtyOrdered <= 20) {
      if (qtyOrdered < 20) {
        itemsOrdered[qtyOrdered] = disc;
        qtyOrdered++;
        System.out.println("The disc has been added");
      } else
        System.out.println("The cart is almost full");
    }
  }

  public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
	  for (DigitalVideoDisc item : dvdList) {
		  this.addDigitalVideoDisc(item);
      }
  }

  public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
      if (itemQuantity == MAX_NUMBERS_ORDERD) {
        System.out.println("The cart is almost full");
        return;
      }

      itemsOrdered[itemQuantity++] = dvd1;
      itemsOrdered[itemQuantity++] = dvd2;
      System.out.println("The disc has been added");
  }

  public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
    if (itemQuantity == 0) {
      System.out.println("The cart is almost empty");
      return;
    }

    boolean removed = false;

    for (int i = 0; i < itemsOrdered.length; i++) {
      if (itemsOrdered[i] != null && itemsOrdered[i].equals(disc)) {
        for (int j = i; j < itemQuantity - 1; j++) {
          itemsOrdered[j] = itemsOrdered[j + 1];
        }
        itemsOrdered[itemQuantity - 1] = null;
        removed = true;
        break;
      }
    }

    if (!removed) {
      System.out.println("Could not find the searched disc in cart!");
      return;
    }

    itemQuantity--;
    System.out.println("The disc has been removed!");
  }

  public float totalCost() {
    float total = 0f;
    for (int i = 0; i < itemsOrdered.length; i++) {
      if(itemsOrdered[i] != null)
        total += itemsOrdered[i].getCost();
    }
    return total;
  }

  public void printCart() {
    System.out.println("********************CART***********************\nOrdered Items:");
    double total = 0;
    for (int i = 0; i < qtyOrdered; i++) {
      total += this.itemsOrdered[i].getCost();
      System.out.println((i + 1) + ".DVD - " + this.itemsOrdered[i].getTitle() + " - "
              + this.itemsOrdered[i].getCategory() + " - " +
              this.itemsOrdered[i].getDirector() + " - " + this.itemsOrdered[i].getLength() + " : " +
              +this.itemsOrdered[i].getCost());
    }
    System.out.println("Total Cost : " + total);
    System.out.println("***********************************************");

  }
}