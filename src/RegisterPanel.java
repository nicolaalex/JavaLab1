import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    private final Register register;
    private final JPanel inputPanel;
    private final JTextField input;
    private final JLabel inputLabel;
    private final PursePanel changePanel;
    private final JLabel changeLabel;

    public RegisterPanel() {
        register = new Register(new GreedyChangeStrategy());

        inputPanel = new JPanel();
        input = new JTextField(10);
        input.setFont(new Font("Arial", Font.PLAIN, 22));
        inputLabel = new JLabel("Please enter the amount of money: ");
        inputLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        input.addActionListener(new InputListener());

        inputPanel.add(inputLabel);
        inputPanel.add(input);

        changePanel = new PursePanel();
        changeLabel = new JLabel("Amount in Purse");
        changeLabel.setForeground(Color.black);
        changeLabel.setFont(new Font("Arial", Font.BOLD, 40));

        this.setLayout(new BorderLayout());
        this.add(inputPanel, BorderLayout.NORTH);
        this.add(changePanel, BorderLayout.CENTER);
    }

    private class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double amount = Double.parseDouble(input.getText());
            Purse purse = register.makeChange(amount);

            inputLabel.setText("$" + String.format("%.2f", purse.getValue()));
            if (amount <= 0.001) inputLabel.setText("This Purse is empty.");

            inputPanel.setBackground(Color.gray);
            changePanel.setPreferredSize(new Dimension(800, 750));
            changePanel.setBackground(Color.WHITE);
            changePanel.setPurse(purse);
            changePanel.add(changeLabel);

            changePanel.revalidate();
            changePanel.repaint();
        }
    }
}
