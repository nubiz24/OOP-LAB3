package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    @FXML
    private RadioButton penRadioButton, eraserRadioButton;

    private Color penColor = Color.BLACK;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, penColor);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void switchPenColor(ActionEvent event) {
        if (penRadioButton.isSelected()) {
            penColor = Color.BLACK;
        } else if (eraserRadioButton.isSelected()) {
            penColor = Color.WHITE;
        }
    }
}
