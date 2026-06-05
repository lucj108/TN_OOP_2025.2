package hust.soict.hedspi.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {
    private Cart cart;
    private Store store;
    public CartScreen(Store store, Cart cart) {
        super();
        this.store = store;
        this.cart = cart;
        
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        
        this.setTitle("Cart");
        this.setVisible(true);
        this.setSize(1024, 768); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Platform.setImplicitExit(false); 
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass()
                            .getResource("cart.fxml"));
                    CartScreenController controller = 
                            new CartScreenController(store, cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }	
        });
    }
}
