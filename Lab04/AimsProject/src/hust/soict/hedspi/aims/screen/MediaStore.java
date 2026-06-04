package hust.soict.hedspi.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable; 

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAddToCart = new JButton("Add to cart");
        btnAddToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Thông báo khi thêm vào giỏ
                JOptionPane.showMessageDialog(null, media.getTitle() + " has been added to the cart!");
            }
        });
        container.add(btnAddToCart);
        
        // Nút Play
        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            btnPlay.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JDialog playDialog = new JDialog();
                    playDialog.setTitle("Playing Media");
                    playDialog.setSize(300, 200);
                    playDialog.setLayout(new BorderLayout());
                    
                    JLabel playLabel = new JLabel("Currently playing: " + media.getTitle());
                    playLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    playDialog.add(playLabel, BorderLayout.CENTER);
                    
                    playDialog.setLocationRelativeTo(null);
                    playDialog.setVisible(true);
                }
            });
            container.add(btnPlay);
        }
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
