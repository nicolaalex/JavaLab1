// PursePanel class: Displays images of the denominations in the purse.
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Objects;

public class PursePanel extends JPanel {
    private Purse purse = new Purse();

    // Sets the purse object that contains the denominations
    public void setPurse(Purse purse) {
        this.purse = purse;
    }

    // Draws the denominations as images in the panel
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 10; // Starting x coordinate
        int y = 50; // Starting y coordinate
        int maxWidth = getWidth(); // Max width of the panel
        int rowHeight = 0; // The height of the current row

        // Iterate over each denomination in the purse
        for (HashMap.Entry<Denomination, Integer> entry : purse.cash.entrySet()) {
            Denomination money = entry.getKey();
            int count = entry.getValue();
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource(money.img())));
            Image image = icon.getImage();
            int imgWidth = image.getWidth(this);
            int imgHeight = image.getHeight(this);

            // Draw each denomination image for the number of times it appears
            for (int i = 0; i < count; i++) {
                if (x + imgWidth > maxWidth) {  // Check if the current item exceeds panel width
                    x = 10;  // Reset x to the beginning
                    y += rowHeight + 10;  // Move to the next row
                    rowHeight = 0;  // Reset row height
                }

                // Draw the current denomination image at the specified coordinates
                g.drawImage(image, x, y, this);

                // Update x coordinate for the next item
                x += imgWidth + 10;  // Add spacing between images

                // Update row height
                rowHeight = Math.max(rowHeight, imgHeight);
            }
        }
    }
}
