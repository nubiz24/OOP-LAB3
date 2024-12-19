package hust.soict.hedspi.screen;

import hust.soict.hedspi.store.Store;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        cp.add(createFooter(), BorderLayout.SOUTH);
        setVisible(true);
        setTitle("Add Item to Store");
        setSize(600, 400);
    }

    // Tạo phần trên (Menu và tiêu đề)
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        return north;
    }
    // Tạo phần trung tâm (Nhập thông tin món hàng)
    abstract JPanel createCenter();

    // Tạo phần dưới (Nút Thêm vào cửa hàng và quay lại)
    JPanel createFooter() {
        JPanel footer = new JPanel();
        footer.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addButton = new JButton("Add to Store");
        addButton.addActionListener(e -> addItemToStore());

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> cancel());

        footer.add(addButton);
        footer.add(cancelButton);
        return footer;
    }

    // Phương thức thêm món hàng vào cửa hàng (chưa xử lý nhập liệu)
    protected abstract void addItemToStore();

    // Phương thức huỷ và quay lại
    private void cancel() {
        new StoreScreen(store); // Quay lại màn hình cửa hàng
        dispose(); // Đóng màn hình hiện tại
    }
}
