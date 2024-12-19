package hust.soict.hedspi.screen;

import hust.soict.hedspi.media.*;
import hust.soict.hedspi.store.Store;
import hust.soict.hedspi.media.Book;
import hust.soict.hedspi.media.CompactDisc;
import hust.soict.hedspi.media.DigitalVideoDisc;
import hust.soict.hedspi.media.Track;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StoreScreen extends JFrame {
    private Store store;

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");

        // Thêm các mục vào menu
        JMenuItem addBookItem = new JMenuItem("Add Book");
        JMenuItem addCDItem = new JMenuItem("Add CD");
        JMenuItem addDVDItem = new JMenuItem("Add DVD");

        // Gắn hành động vào các mục menu
        addBookItem.addActionListener(e -> {
            // Đóng màn hình hiện tại và mở màn hình AddBook
            new AddBookToStoreScreen(store);
            dispose();
        });
        addCDItem.addActionListener(e -> {
            // Đóng màn hình hiện tại và mở màn hình AddCompactDisc
            new AddCompactDiscToStoreScreen(store);
            dispose();
        });
        addDVDItem.addActionListener(e -> {
            // Đóng màn hình hiện tại và mở màn hình AddDigitalVideoDisc
            new AddDigitalVideoDiscToStoreScreen(store);
            dispose();
        });

        smUpdateStore.add(addBookItem);
        smUpdateStore.add(addCDItem);
        smUpdateStore.add(addDVDItem);

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View Store"));
        menu.add(new JMenuItem("View Cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cart = new JButton("View Cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2,2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        int numberOfItems = mediaInStore.size(); // Lấy kích thước danh sách
        for (int i = 0; i < numberOfItems; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    public StoreScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(800, 600);
    }

    public static void main(String[] args) {
        Store store = new Store();
        // DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc( "Frozen", "Animation", 22.50f, 102, "Chris Buck");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc( "The Matrix", "Science Fiction", 29.99f, 136, "Wachowski Sisters");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Beauty and the Beast", "Animation", 17.99f, 84, "Gary Trousdale");
        Store.addMedia(dvd1); Store.addMedia(dvd2); Store.addMedia(dvd3);
        // CD + Track
        CompactDisc cd1 = new CompactDisc(4, "Back in Black", "Rock", 19.99f, 41, "AC/DC", "AC/DC");
        Track track1 = new Track("Hells Bells", 312);
        Track track2 = new Track("Back in Black", 255);
        Track track3 = new Track("You Shook Me All Night Long", 232);
        cd1.addTrack(track1); cd1.addTrack(track2); cd1.addTrack(track3);
        CompactDisc cd2 = new CompactDisc(5, "The Dark Side of the Moon", "Progressive Rock", 23.50f, 43, "Pink Floyd", "Pink Floyd");
        Track track4 = new Track("Speak to Me", 130);
        Track track5 = new Track("Breathe", 212);
        cd2.addTrack(track4); cd2.addTrack(track5);
        CompactDisc cd3 = new CompactDisc(6, "Abbey Road", "Rock", 21.99f, 47, "The Beatles", "The Beatles");
        Track track6 = new Track("Come Together", 259);
        Track track7 = new Track("Something", 182);
        Track track8 = new Track("Here Comes the Sun", 185);
        cd3.addTrack(track6); cd3.addTrack(track7); cd3.addTrack(track8);
        Store.addMedia(cd1); Store.addMedia(cd2); Store.addMedia(cd3);
        // Book
        Book book1 = new Book(7, "The Da Vinci Code", "Mystery", 12.50f, "Dan Brown");
        Book book2 = new Book(8, "Angels & Demons", "Thriller", 11.95f, "Dan Brown");

        Store.addMedia(book1); Store.addMedia(book2);
        new StoreScreen(store);
    }
}