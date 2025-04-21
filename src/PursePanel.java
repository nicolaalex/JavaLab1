import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Objects;

public class PursePanel extends JPanel {
    private Purse purse = new Purse();

    public void setPurse(Purse purse) {
        this.purse = purse;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 10;  // start X position
        int y = 50;  // start Y position

        if (purse == null) return;

        for (HashMap.Entry<Denomination, Integer> entry : purse.cash.entrySet()) {
            Denomination d = entry.getKey();
            int count = entry.getValue();
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource(d.img())));
            Image img = icon.getImage();
            int imgHeight = img.getHeight(this);
            int imgWidth = img.getWidth(this);

            // stack vertically
            for (int i = 0; i < count; i++) {
                g.drawImage(img, x, y + (i * (imgHeight + 5)), this);
            }

            // move to next column after this denomination
            x += imgWidth + 15;
        }
    }
}