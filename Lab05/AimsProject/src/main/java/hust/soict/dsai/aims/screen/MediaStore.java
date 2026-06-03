package hust.soict.dsai.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartBtn = new JButton("Add to cart");
        container.add(addToCartBtn);
        
        addToCartBtn.addActionListener(e -> {
            cart.addMedia(media);
            JOptionPane.showMessageDialog(null, "Added " + media.getTitle() + " to cart!");
        });

        if (media instanceof Playable) {
            JButton playBtn = new JButton("Play");
            container.add(playBtn);
            
            playBtn.addActionListener(e -> {
                try {
                    ((Playable) media).play();
                    
                    JDialog dialog = new JDialog((Frame) null, "Playing Media", true);
                    dialog.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
                    JLabel playLabel = new JLabel("Now Playing: " + media.getTitle());
                    playLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                    dialog.add(playLabel);
                    dialog.setSize(300, 150);
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
                } catch (PlayerException ex) {
                    JOptionPane.showMessageDialog(null, 
                        ex.getMessage(), 
                        "Player Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            });
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}