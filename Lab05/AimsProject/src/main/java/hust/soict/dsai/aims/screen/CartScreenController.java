package hust.soict.dsai.aims.screen;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.exception.PlayerException;

public class CartScreenController {
    private Cart cart;
    private Store store;

    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediaCategory;
    @FXML private TableColumn<Media, Float> colMediaCost;

    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    @FXML private Label lblTotal;
    
    @FXML private TextField tfFilter; 
    @FXML private RadioButton radioBtnFilterId;
    @FXML private RadioButton radioBtnFilterTitle;

    private FilteredList<Media> filteredList;

    public CartScreenController(Store store, Cart cart) {
        super();
        this.store = store;
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        
        filteredList = new FilteredList<>(this.cart.getItemsOrdered(), p -> true);
        tblMedia.setItems(filteredList);

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                if (newValue != null) {
                    btnRemove.setVisible(true);
                    btnPlay.setVisible(newValue instanceof Playable);
                }
            }
        });

        // Live search
        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            showFilteredMedia(newValue);
        });

        updateTotalCost();
    }

    private void showFilteredMedia(String value) {
        filteredList.setPredicate(media -> {
            if (value == null || value.isEmpty()) {
                return true;
            }
            String lowerCaseFilter = value.trim().toLowerCase();
            
            // ID and Title filtering
            if (radioBtnFilterId != null && radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).contains(lowerCaseFilter);
            } else {
                return media.getTitle().toLowerCase().contains(lowerCaseFilter);
            }
        });
    }

    private void updateTotalCost() {
        lblTotal.setText(String.format("%.2f $", cart.totalCost()));
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        updateTotalCost();
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        try {
            ((Playable) media).play();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Playing: " + media.getTitle());
            alert.showAndWait();
        } catch (PlayerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.setTitle("Player Exception");
            alert.setHeaderText("An error occurred during playback");
            alert.showAndWait();
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Order placed successfully!");
        alert.showAndWait();
        cart.getItemsOrdered().clear();
        updateTotalCost();
    }

    @FXML
    void viewStoreSelected(ActionEvent event) {
        java.awt.Window[] windows = java.awt.Window.getWindows();
        for (java.awt.Window window : windows) {
            if (window instanceof javax.swing.JFrame && "Cart".equals(((javax.swing.JFrame) window).getTitle())) {
                window.dispose();
                break;
            }
        }
        
        javax.swing.SwingUtilities.invokeLater(() -> {
            new StoreScreen(store, cart);
        });
    }
}