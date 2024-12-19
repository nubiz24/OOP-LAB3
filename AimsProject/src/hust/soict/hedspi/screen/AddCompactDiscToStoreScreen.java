package hust.soict.hedspi.screen;

import hust.soict.hedspi.media.CompactDisc;
import hust.soict.hedspi.media.Track;
import hust.soict.hedspi.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField titleField, categoryField, artistField, costField, lengthField;

    public AddCompactDiscToStoreScreen(Store store) {
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

        center.add(new JLabel("Artist:"));
        artistField = new JTextField();
        center.add(artistField);

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
        String artist = artistField.getText();
        float cost = Float.parseFloat(costField.getText());
        int length = Integer.parseInt(lengthField.getText());

        CompactDisc cd = new CompactDisc(0, title, category, cost, length, artist, artist);

        store.addMedia(cd);

        JOptionPane.showMessageDialog(this, "CD added successfully!");
        new StoreScreen(store); // Quay lại màn hình cửa hàng
        dispose(); // Đóng màn hình hiện tại
    }
}
