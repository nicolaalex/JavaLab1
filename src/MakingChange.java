// allows users to input a dollar amount and see the breakdown of denominations used to make change.


import javax.swing.*;
import java.awt.*;

public class MakingChange {
    public static void main(String[] args) {
        // Create the main application window
        JFrame frame = new JFrame("Making Change");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set preferred window size
        frame.setPreferredSize(new Dimension(850, 700));

        // Add the RegisterPanel (main GUI panel) to the frame
        frame.getContentPane().add(new RegisterPanel());

        // Size the frame to fit its contents
        frame.pack();

        // Display the window
        frame.setVisible(true);
    }
}
