package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart);
        setTitle("Add CD to Store");
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(6, 2, 10, 10));
        center.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        center.add(new JLabel("Title:"));
        JTextField tfTitle = new JTextField();
        center.add(tfTitle);

        center.add(new JLabel("Category:"));
        JTextField tfCategory = new JTextField();
        center.add(tfCategory);

        center.add(new JLabel("Director:"));
        JTextField tfDirector = new JTextField();
        center.add(tfDirector);

        center.add(new JLabel("Artist:"));
        JTextField tfArtist = new JTextField();
        center.add(tfArtist);

        center.add(new JLabel("Cost:"));
        JTextField tfCost = new JTextField();
        center.add(tfCost);

        JButton btnAdd = new JButton("Add CD");
        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            String director = tfDirector.getText();
            String artist = tfArtist.getText();
            float cost = tfCost.getText().isEmpty() ? 0.0f : Float.parseFloat(tfCost.getText());

            CompactDisc cd = new CompactDisc(title, category, director, artist, cost);
            store.addMedia(cd);
            
            JOptionPane.showMessageDialog(null, "CD Added Successfully!");
            tfTitle.setText(""); tfCategory.setText(""); tfDirector.setText(""); tfArtist.setText(""); tfCost.setText("");
        });

        center.add(new JLabel());
        center.add(btnAdd);

        return center;
    }
}