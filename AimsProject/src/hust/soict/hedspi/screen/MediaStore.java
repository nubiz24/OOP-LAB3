package hust.soict.hedspi.screen;

import hust.soict.hedspi.cart.Cart;
import hust.soict.hedspi.media.CompactDisc;
import hust.soict.hedspi.media.DigitalVideoDisc;
import hust.soict.hedspi.media.Media;
import hust.soict.hedspi.media.Playable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;
    private CompactDisc cd;
    private DigitalVideoDisc dvd;
    public MediaStore(Media media){

        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel((media.getTitle()));
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel((""+media.getCost()+ " $"));
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Nút Add to Cart
        JButton addToCartButton = new JButton("Add to cart");
        addToCartButton.addActionListener(e -> {
            Cart cart = new Cart();
            cart.addMedia(media);
            JOptionPane.showMessageDialog(MediaStore.this,
                    media.getTitle() + " has been added to the cart!");
        });
        container.add(addToCartButton);

        // Button Play (chỉ khi media là Playable)
        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Tạo JDialog để phát media
                    JDialog playDialog = new JDialog((Frame) null, "Playing Media", true);
                    playDialog.setSize(400, 200);  // Kích thước cửa sổ
                    playDialog.setLocationRelativeTo(null);  // Hiển thị ở giữa màn hình

                    // Tạo một panel để hiển thị thông tin về media
                    JPanel playPanel = new JPanel();
                    playPanel.setLayout(new BoxLayout(playPanel, BoxLayout.Y_AXIS));

                    JLabel playingLabel = new JLabel("Now playing: " + media.getTitle());
                    JLabel mediaInfoLabel = new JLabel("Cost: " + media.getCost() + " $");

                    // Nếu media có thể phát, kiểm tra và hiển thị thông tin
                    if (media instanceof DigitalVideoDisc) {
                        DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                        playPanel.add(new JLabel("Playing DVD..."));
                        playPanel.add(new JLabel("Length: " + dvd.getLength() + " minutes"));
                    } else if (media instanceof CompactDisc) {
                        CompactDisc cd = (CompactDisc) media;
                        playPanel.add(new JLabel("Playing CD..."));
                        playPanel.add(new JLabel("Artist: " + cd.getArtist()));
                        playPanel.add(new JLabel("Length: " + cd.getLength() + " minutes"));
                    }

                    // Thêm các label vào panel
                    playPanel.add(playingLabel);
                    playPanel.add(mediaInfoLabel);

                    playDialog.add(playPanel);
                    playDialog.setVisible(true);  // Hiển thị JDialog
                }
            });
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }


}
