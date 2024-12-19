package hust.soict.hedspi.screen;

import hust.soict.hedspi.media.DigitalVideoDisc;
import hust.soict.hedspi.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField titleField, categoryField, directorField, costField, lengthField;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(6, 2));

        center.add(new JLabel("Title:"));
        titleField = new JTextField();
        center.add(titleField);

        center.add(new JLabel("Category:"));
        categoryField = new JTextField();
        center.add(categoryField);

        center.add(new JLabel("Director:"));
        directorField = new JTextField();
        center.add(directorField);

        center.add(new JLabel("Cost:"));
        costField = new JTextField();
        center.add(costField);

        center.add(new JLabel("Length:"));
        lengthField = new JTextField();
        center.add(lengthField);

        return center;
    }

    @Override
    protected void addItemToStore() {
        String title = titleField.getText();
        String category = categoryField.getText();
        String director = directorField.getText();
        float cost = Float.parseFloat(costField.getText());
        int length = Integer.parseInt(lengthField.getText());

        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost, length, director);
        store.addMedia(dvd);

        JOptionPane.showMessageDialog(this, "DVD added successfully!");
        new StoreScreen(store); // Quay lại màn hình cửa hàng
        dispose(); // Đóng màn hình hiện tại
    }
}
