package hust.soict.hedspi.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {
    private Cart cart;

    public CartScreen(Cart cart) {
        super();
        
        this.cart = cart;
        
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        
        this.setTitle("Cart");
        this.setVisible(true);
        this.setSize(1024, 768); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass()
                            .getResource("cart.fxml"));
                    CartScreenController controller = 
                            new CartScreenController(cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    
    // Test
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc media1 = new DigitalVideoDisc("DVD1's Title", "category 1", "Director", 100, 7.87f);
        DigitalVideoDisc media2 = new DigitalVideoDisc("CD2's Title", "category 2", "Director", 100, 19.21f);
        DigitalVideoDisc media3 = new DigitalVideoDisc("Book3's Title", "category 3", "Director", 100, 14.61f);

        cart.addMedia(media1);
        cart.addMedia(media2);
        cart.addMedia(media3);

        new CartScreen(cart);
    }
}
