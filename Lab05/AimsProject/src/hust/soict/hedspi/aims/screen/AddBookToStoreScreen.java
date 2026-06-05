package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart);
        setTitle("Add Book to Store");
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(4, 2, 10, 10));
        center.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        center.add(new JLabel("Title:"));
        JTextField tfTitle = new JTextField();
        center.add(tfTitle);

        center.add(new JLabel("Category:"));
        JTextField tfCategory = new JTextField();
        center.add(tfCategory);

        center.add(new JLabel("Cost:"));
        JTextField tfCost = new JTextField();
        center.add(tfCost);

        JButton btnAdd = new JButton("Add Book");
        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = tfCost.getText().isEmpty() ? 0.0f : Float.parseFloat(tfCost.getText());

            Book book = new Book(title, category, cost);
            store.addMedia(book);
            
            JOptionPane.showMessageDialog(null, "Book Added Successfully!");
            tfTitle.setText(""); tfCategory.setText(""); tfCost.setText("");
        });

        center.add(new JLabel());
        center.add(btnAdd);

        return center;
    }
}