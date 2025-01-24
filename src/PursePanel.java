import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Objects;

public class PursePanel extends JPanel {
    //creat purse
    private Purse purse = new Purse();

    //set the purse
    public void setPurse(Purse purse) {
        this.purse = purse;
    }

    //Draws the images
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 0;
        int y = 50;
        //if empty display nothing
        if (purse == null) {
            return;
        }

        // update y value for overflow
        int new_y = 0;

        //For each denomination print the number of images
        for (HashMap.Entry<Denomination, Integer> entry : purse.cash.entrySet()) {

            // denomination and count
            Denomination money = entry.getKey();
            int count = entry.getValue();

            // image for the denomination
            ImageIcon icon= new ImageIcon(Objects.requireNonNull(getClass().getResource(money.img())));
            Image image = icon.getImage();

            // shoews each image for denomination
            for (int i = 0; i < count; i++) {
                g.drawImage(image, x, y, this);
                y += 30;

            }

            // new line of images with new y value
            if (x + image.getWidth(this) > 700)
            {
                x = 0;
                y = image.getHeight(this) + 70;
                new_y = y;
            }
            //increment x value
            else
            {
                x += image.getWidth(this);
                y = 50 + new_y;
            }


        }


    }


}