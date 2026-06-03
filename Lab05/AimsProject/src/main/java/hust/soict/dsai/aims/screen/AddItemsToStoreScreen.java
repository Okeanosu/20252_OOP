package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class AddItemsToStoreScreen extends JDialog {
    private JTextField tfId, tfTitle, tfCategory, tfCost, tfSpecial;
    private JLabel lblSpecial;
    private String type;
    private Store store;

    public AddItemsToStoreScreen(JFrame parent, Store store, String type) {
        super(parent, "Add " + type + " to Store", true);
        this.store = store;
        this.type = type;

        this.setLayout(new BorderLayout(10, 10));
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        formPanel.add(new JLabel("ID:"));
        tfId = new JTextField();
        formPanel.add(tfId);

        formPanel.add(new JLabel("Title:"));
        tfTitle = new JTextField();
        formPanel.add(tfTitle);

        formPanel.add(new JLabel("Category:"));
        tfCategory = new JTextField();
        formPanel.add(tfCategory);

        formPanel.add(new JLabel("Cost ($):"));
        tfCost = new JTextField();
        formPanel.add(tfCost);

        lblSpecial = new JLabel("");
        tfSpecial = new JTextField();
        if (type.equals("Book")) {
            lblSpecial.setText("Author:");
        } else if (type.equals("CD")) {
            lblSpecial.setText("Artist:");
        } else if (type.equals("DVD")) {
            lblSpecial.setText("Director:");
        }
        formPanel.add(lblSpecial);
        formPanel.add(tfSpecial);

        JButton btnAdd = new JButton("Add Item");
        btnAdd.addActionListener(e -> addItemToStore());

        this.add(formPanel, BorderLayout.CENTER);
        this.add(btnAdd, BorderLayout.SOUTH);

        this.setSize(400, 300);
        this.setLocationRelativeTo(parent);
    }

    private void addItemToStore() {
        try {
            int id = Integer.parseInt(tfId.getText());
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());
            String special = tfSpecial.getText();

            Media media = null;
            if (type.equals("Book")) {
                Book book = new Book(id, title, category, cost);
                if (!special.isEmpty()) book.addAuthor(special);
                media = book;
            } else if (type.equals("CD")) {
                media = new CompactDisc(id, title, category, cost, "Unknown Director", 0, special);
            } else if (type.equals("DVD")) {
                media = new DigitalVideoDisc(id, title, category, cost, special, 120);
            }

            if (media != null) {
                store.addMedia(media);
                JOptionPane.showMessageDialog(this, "Successfully added " + title + " to store!");
                
                // GỌI LÀM MỚI MÀN HÌNH CHÍNH Ở ĐÂY
                if (getOwner() instanceof StoreScreen) {
                    ((StoreScreen) getOwner()).refreshStoreCenter();
                }
                
                this.dispose();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for ID and Cost.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}