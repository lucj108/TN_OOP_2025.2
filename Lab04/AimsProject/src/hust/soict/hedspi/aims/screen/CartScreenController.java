package hust.soict.hedspi.aims.screen;

import javax.swing.SwingUtilities;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    
    private Cart cart;
    private Store store; 

    public CartScreenController(Store store, Cart cart) {
        super();
        this.store = store;
        this.cart = cart;
    }
    
    @FXML
    private TableView<Media> tblMedia;
    
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    
    @FXML
    private TableColumn<Media, String> colMediacategory;
    
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    
    public CartScreenController(Cart cart, Store store) {
        super();
        this.cart = cart;
        this.store = store;
    }
    
    @FXML
    private Button btnPlay;
    
    @FXML
    private Button btnRemove;
    
    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;
    
    @FXML
    private Label lblCost;
    
    @FXML
    private void initialize() {
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());
        
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    
                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue,
                            Media newValue) {
                        if(newValue!=null) {
                            updateButtonBar(newValue);
                        }
                    }
                });
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                    String newValue) {
                showFilteredMedia(newValue);
            }
        });
        
        cart.getItemsOrdered().addListener((javafx.collections.ListChangeListener.Change<? extends Media> c) -> {
            lblCost.setText(cart.totalCost() + " $");
        });

        lblCost.setText(cart.totalCost() + " $");
    }
    
    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if(media instanceof Playable) {
            btnPlay.setVisible(true);
        }
        else {
            btnPlay.setVisible(false);
        }
    }
    
    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }
    
    void showFilteredMedia(String filter) {
        FilteredList<Media> filteredData = new FilteredList<>(this.cart.getItemsOrdered(), p -> true);

        filteredData.setPredicate(media -> {
            if (filter == null || filter.isEmpty()) {
                return true;
            }

            if (radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).contains(filter);
            }

            if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(filter.toLowerCase());
            }

            return false;
        });

        tblMedia.setItems(filteredData);
    }
    
    @FXML
    void btnPlaceOrderPressed(javafx.event.ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.WARNING);
            alert.setTitle("Empty Cart");
            alert.setHeaderText(null);
            alert.setContentText("Your cart is empty!");
            alert.showAndWait();
            return;
        }
        
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle("Order Notification");
        alert.setHeaderText("Order Created");
        alert.setContentText("Your order has been placed successfully. Cart will be emptied.");
        alert.showAndWait();
        
        cart.getItemsOrdered().clear();
    }
    
    @FXML
    void btnPlayPressed(javafx.event.ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            String playingInfo = "Playing: " + media.getTitle();
            
            if (media instanceof hust.soict.hedspi.aims.media.Playable) {
                if (media instanceof hust.soict.hedspi.aims.media.Disc) {
                    hust.soict.hedspi.aims.media.Disc disc = (hust.soict.hedspi.aims.media.Disc) media;
                    playingInfo += "\nLength: " + disc.getLength();
                } else if (media instanceof hust.soict.hedspi.aims.media.DigitalVideoDisc) {
                    hust.soict.hedspi.aims.media.DigitalVideoDisc dvd = (hust.soict.hedspi.aims.media.DigitalVideoDisc) media;
                    playingInfo += "\nLength: " + dvd.getLength();
                }
                
                javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
                alert.setTitle("Media Player");
                alert.setHeaderText("Media is playing...");
                alert.setContentText(playingInfo);
                alert.showAndWait();
            } else {
                javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("This media type cannot be played!");
                alert.showAndWait();
            }
        }
    }
    
    @FXML
    void btnAddBookPressed(ActionEvent event) {
        new AddBookToStoreScreen(store, cart); 
    }

    @FXML
    void btnAddCDPressed(ActionEvent event) {
        new AddCompactDiscToStoreScreen(store, cart);
    }

    @FXML
    void btnAddDVDPressed(ActionEvent event) {
        new AddDigitalVideoDiscToStoreScreen(store, cart);
    }
    
    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StoreScreen(store, cart);
            }
        });

        try {
            javafx.stage.Stage stage = (javafx.stage.Stage) tblMedia.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            System.out.println("Cửa sổ JFX đã được ẩn");
        }
    }
}