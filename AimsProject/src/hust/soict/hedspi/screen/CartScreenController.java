package hust.soict.hedspi.screen;

import hust.soict.hedspi.cart.Cart;
import hust.soict.hedspi.media.CompactDisc;
import hust.soict.hedspi.media.DigitalVideoDisc;
import hust.soict.hedspi.media.Media;
import hust.soict.hedspi.media.Playable;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.awt.*;


public class CartScreenController {
    private Cart cart;


    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    public void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());
        lblTotalCost.textProperty().bind(Bindings.format("$%.2f", cart.totalCostProperty()));
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                        if (newValue != null) {
                            updateButtonBar(newValue);
                        }
                    }
                }

        );
    }

    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        // Lấy phương tiện (media) được chọn từ bảng
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof DigitalVideoDisc) {
            DigitalVideoDisc dvd = (DigitalVideoDisc) media;
            String message = String.format(
                    "Playing...%s\nCost: %.2f\nLength: %d minutes",
                    dvd.getTitle(),
                    dvd.getCost(),
                    dvd.getLength()
            );
            // Hiển thị dialog thông báo
            Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
            alert.setTitle("Playing Media");
            alert.setHeaderText("Now Playing.....");
            alert.showAndWait();
        } else if (media instanceof CompactDisc) {
            CompactDisc cd = (CompactDisc) media;
            String message = String.format(
                    "Playing...%s\nCost: %.2f\nLength: %d minutes\nArtist: %s",
                    cd.getTitle(),
                    cd.getCost(),
                    cd.getLength(),
                    cd.getArtist()
            );
            // Hiển thị dialog thông báo
            Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
            alert.setTitle("Playing Media");
            alert.setHeaderText("Now Playing");
            alert.showAndWait();
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        // Xử lý khi người dùng nhấn nút "Place Order"
        // Ví dụ, hiển thị thông báo xác nhận hoặc đặt hàng thực tế
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Placed");
        alert.setHeaderText("Your order has been placed successfully.");
        alert.setContentText("Thank you for your purchase!");
        alert.showAndWait();
    }
    @FXML
    private Label lblTotalCost;

}

