// This creates JFrame and adds a RegisterPanel

import java.awt.*;
import javax.swing.*;

public class MakingChange {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Making Change");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creates register Panel and adds to frame
        RegisterPanel registerPanel = new RegisterPanel();
        frame.setPreferredSize(new Dimension(850, 700));

        frame.getContentPane().add(registerPanel);
        frame.pack();
        frame.setVisible(true);
    }
}