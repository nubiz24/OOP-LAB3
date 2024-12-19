package hust.soict.hedspi.exception;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class PlayerException extends Exception {
    public PlayerException(String message) {
        super(message);

        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(null, message, "Playback Error", JOptionPane.ERROR_MESSAGE);
        });
    }
}



