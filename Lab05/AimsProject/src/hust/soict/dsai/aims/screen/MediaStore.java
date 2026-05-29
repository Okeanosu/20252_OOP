package hust.soict.dsai.aims.screen;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {
    private Media media;
    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JLabel titleLabel = new JLabel(media.getTitle());
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 20));
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(""+media.getCost()+" $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        container.add(new JButton("Add to cart"));
        if(media instanceof Playable) {
            container.add(new JButton("Play"));
        }
        
        this.add(Box.createVerticalGlue());
        this.add(titleLabel);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
