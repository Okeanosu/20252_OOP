package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;
    private JPanel centerPanel;

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        
        cp.add(createNorth(), BorderLayout.NORTH);
        
        centerPanel = new JPanel();
        cp.add(centerPanel, BorderLayout.CENTER);
        refreshStoreCenter();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void refreshStoreCenter() {
        centerPanel.removeAll();
        
        ArrayList<Media> mediaInStore = store.getItemsOrdered();

        int totalItems = mediaInStore.size();
        int rows = (int) Math.ceil(totalItems / 3.0);
        if (rows < 3) rows = 3;
        
        centerPanel.setLayout(new GridLayout(rows, 3, 9, 9));
        
        for (Media media : mediaInStore) {
            MediaStore cell = new MediaStore(media, cart);
            centerPanel.add(cell);
        }
        
        centerPanel.revalidate();
        centerPanel.repaint();
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
        
        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(e -> new AddItemsToStoreScreen(this, store, "Book").setVisible(true));
        
        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(e -> new AddItemsToStoreScreen(this, store, "CD").setVisible(true));
        
        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(e -> new AddItemsToStoreScreen(this, store, "DVD").setVisible(true));

        smUpdateStore.add(addBookItem);
        smUpdateStore.add(addCDItem);
        smUpdateStore.add(addDVDItem);
        
        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        
        JMenuItem viewCartItem = new JMenuItem("View cart");
        viewCartItem.addActionListener(e -> {
            new CartScreen(store, cart); // Matches updated parameter list
            this.dispose();
        });
        menu.add(viewCartItem);
        
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
        
        JButton viewCart = new JButton("View cart");
        viewCart.setPreferredSize(new Dimension(100, 50));
        viewCart.setMaximumSize(new Dimension(100, 50));
        viewCart.addActionListener(e -> {
            new CartScreen(store, cart); // Matches updated parameter list
            this.dispose();
        });

        header.add(Box.createRigidArea(new Dimension(10, 0)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(viewCart);
        header.add(Box.createRigidArea(new Dimension(10, 0)));
        return header;
    }
}