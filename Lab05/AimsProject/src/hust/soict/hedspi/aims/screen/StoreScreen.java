package hust.soict.hedspi.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class StoreScreen extends JFrame {
	private Store store;
	private Cart cart;
	
	public StoreScreen(Store store, Cart cart) {
        this.store = store; 
        this.cart = cart;
        Container cp = getContentPane();  
        cp.setLayout(new BorderLayout()); 

        cp.add(createNorth(), BorderLayout.NORTH); 
        cp.add(createCenter(), BorderLayout.CENTER); 

        setVisible(true);
        setTitle("Store");	
        setSize(1024, 768);
    }
	
	JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
    	JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> {
            new AddBookToStoreScreen(store, cart); 
            dispose(); 
        });
        smUpdateStore.add(addBook);
        
        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> {
            new AddCompactDiscToStoreScreen(store, cart); 
            dispose();
        });
        smUpdateStore.add(addCD);
        
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> {
            new AddDigitalVideoDiscToStoreScreen(store, cart); 
            dispose();
        });
        smUpdateStore.add(addDVD);

        menu.add(smUpdateStore);
        
        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(e -> {
            new StoreScreen(store, cart); 
            dispose();
        });
        menu.add(viewStore);
        
        JMenuItem viewCart = new JMenuItem("View cart");
        viewCart.addActionListener(e -> {
            new CartScreen(store, cart); 
            dispose();
        });
        menu.add(viewCart);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }
    
    JPanel createCenter() {
    	JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        java.util.ArrayList<Media> mediaInStore = store.getItemsInStore();

        for (int i = 0; i < 9; i++) {
            if (i >= mediaInStore.size()) break;

            MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
            center.add(cell);
        }

        return center;
    }
}
