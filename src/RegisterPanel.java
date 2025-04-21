// RegisterPanel class: Handles user interaction to enter amount and display the change
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

    // Constructor initializes components and sets up the layout
    public RegisterPanel() {
        register = new Register();
        inputPanel = new JPanel();
        input = new JTextField(10);
        changePanel = new PursePanel();
        changeLabel = new JLabel("Amount in Purse");
        inputLabel = new JLabel("Please enter the amount of money: "); // Label for user input
        input.addActionListener(new InputListener());

        // Adds input field and label to the input panel
        input.setFont(new Font("Arial", Font.PLAIN, 22));
        inputLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        inputPanel.add(inputLabel);
        inputPanel.add(input);

        // Set up the layout of the panels
        this.setLayout(new BorderLayout());
        this.add(inputPanel, BorderLayout.NORTH);
        this.add(changePanel, BorderLayout.CENTER);
    }

    // Action listener for when user submits an amount
    private class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double amount = Double.parseDouble(input.getText());
            Purse purse = register.makeChange(amount);

            // Display the purse total in the label
            inputLabel.setText("$" + String.format("%.2f", purse.getValue()));
            System.out.println("Total amount in the purse: $" + String.format("%.2f", purse.getValue()));

            // If amount is too small, show that the purse is empty
            if (amount <= 0.001) {
                inputLabel.setText("This Purse is empty.");
            }

            // Modify the panels for displaying the contents of the purse
            changePanel.setPurse(purse);
            changeLabel.setForeground(Color.black);
            changeLabel.setFont(new Font("Arial", Font.BOLD, 40));
            changePanel.add(changeLabel);
            changePanel.revalidate();
            changePanel.repaint();
        }
    }
}
