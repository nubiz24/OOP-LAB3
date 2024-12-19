package hust.soict.hedspi.screen;

import hust.soict.hedspi.media.Book;
import hust.soict.hedspi.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField titleField, categoryField, authorField, costField;

    public AddBookToStoreScreen(Store store) {
        super(store);
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(5, 2));

        center.add(new JLabel("Title:"));
        titleField = new JTextField();
        center.add(titleField);

        center.add(new JLabel("Category:"));
        categoryField = new JTextField();
        center.add(categoryField);

        center.add(new JLabel("Author:"));
        authorField = new JTextField();
        center.add(authorField);

        center.add(new JLabel("Cost:"));
        costField = new JTextField();
        center.add(costField);

        return center;
    }

    @Override
    protected void addItemToStore() {
        String title = titleField.getText();
        String category = categoryField.getText();
        String author = authorField.getText();
        float cost = Float.parseFloat(costField.getText());

        Book book = new Book(0, title, category, cost, author);
        store.addMedia(book);

        JOptionPane.showMessageDialog(this, "Book added successfully!");
        new StoreScreen(store); // Quay lại màn hình cửa hàng
        dispose(); // Đóng màn hình hiện tại
    }
}
