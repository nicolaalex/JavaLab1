import javax.swing.*;
import java.awt.*;

public class MakingChange {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Making Change");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(850, 700));
        frame.getContentPane().add(new RegisterPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
