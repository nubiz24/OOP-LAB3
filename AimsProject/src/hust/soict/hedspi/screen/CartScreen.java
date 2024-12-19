package hust.soict.hedspi.screen;

import hust.soict.hedspi.media.Book;
import hust.soict.hedspi.media.CompactDisc;
import hust.soict.hedspi.media.DigitalVideoDisc;
import hust.soict.hedspi.media.Track;
import hust.soict.hedspi.screen.CartScreenController;
import hust.soict.hedspi.store.Store;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import hust.soict.hedspi.cart.Cart;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class CartScreen extends JFrame {
    private Cart cart;

    public CartScreen(Cart cart) {
        super();

        this.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setVisible(true);
        this.setSize(1024, 768);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/hedspi/screen/cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }

    public static void main(String[] args) {
        Cart cart = new Cart();
        Book book1 = new Book(7, "The Da Vinci Code", "Mystery", 12.50f, "Dan Brown");
        Book book2 = new Book(8, "Angels & Demons", "Thriller", 11.95f, "Dan Brown");
        Book book3 = new Book(9, "Dune", "Science Fiction", 14.20f, "Frank Herbert");
        cart.addMedia(book1); cart.addMedia(book2); cart.addMedia(book3);
        DigitalVideoDisc dvd1 = new DigitalVideoDisc( "Frozen", "Animation", 22.50f, 102, "Chris Buck");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc( "The Matrix", "Science Fiction", 29.99f, 136, "Wachowski Sisters");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Beauty and the Beast", "Animation", 17.99f, 84, "Gary Trousdale");
        cart.addMedia(dvd1); cart.addMedia(dvd2); cart.addMedia(dvd3);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lion King", "Animation", 50, 87, "Duong");
        cart.addMedia(dvd4);
        CompactDisc cd1 = new CompactDisc(4, "Back in Black", "Rock", 19.99f, 41, "AC/DC", "AC/DC");
        Track track1 = new Track("Hells Bells", 312);
        Track track2 = new Track("Back in Black", 255);
        Track track3 = new Track("You Shook Me All Night Long", 232);
        cd1.addTrack(track1); cd1.addTrack(track2); cd1.addTrack(track3);
        cart.addMedia(cd1);
        new CartScreen(cart);
    }
}