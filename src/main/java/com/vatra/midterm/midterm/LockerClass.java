package com.vatra.midterm.midterm;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LockerClass {
    private static String storedPassword = null;

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Locker Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Center the frame

        // Create the panel and add it to the frame
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        placeComponents(panel);

        // Make the frame visible
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        // Label to prompt user to enter passcode
        JLabel passcodeLabel = new JLabel("Enter Passcode:");
        passcodeLabel.setBounds(10, 20, 150, 25);
        panel.add(passcodeLabel);

        // Text field for entering the passcode
        JPasswordField passcodeField = new JPasswordField(20);
        passcodeField.setBounds(150, 20, 200, 25);
        panel.add(passcodeField);

        // Button to submit the passcode
        JButton enterButton = new JButton("Enter");
        enterButton.setBounds(150, 60, 80, 25);
        panel.add(enterButton);

        // Button to clear the passcode field
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(240, 60, 80, 25);
        panel.add(clearButton);

        // Label to display status messages
        JLabel statusLabel = new JLabel("");
        statusLabel.setBounds(10, 100, 300, 25);
        panel.add(statusLabel);

        // Action listener for the Enter button
        enterButton.addActionListener(e -> {
            String enteredPassword = new String(passcodeField.getPassword());

            // Check if the password is being set for the first time
            if (storedPassword == null) {
                storedPassword = enteredPassword;
                statusLabel.setText("Password Set");
            } else {
                // Verify the entered password
                if (enteredPassword.equals(storedPassword)) {
                    statusLabel.setText("Correct Password");
                } else {
                    statusLabel.setText("Incorrect Password");
                }
            }

            // Clear the password field after submission
            passcodeField.setText("");
        });

        // Action listener for the Clear button
        clearButton.addActionListener(e -> {
            passcodeField.setText("");
            statusLabel.setText("");
        });

        // Add number buttons
        addNumberButtons(panel, passcodeField);
    }

    private static void addNumberButtons(JPanel panel, JPasswordField passcodeField) {
        ActionListener numberButtonListener = e -> {
            JButton source = (JButton) e.getSource();
            passcodeField.setText(new String(passcodeField.getPassword()) + source.getText());
        };

        int x = 150;
        int y = 140;
        int width = 50;
        int height = 50;
        int gap = 10;

        // Create number buttons
        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.setBounds(x + ((i - 1) % 3) * (width + gap), y + ((i - 1) / 3) * (height + gap), width, height);
            button.addActionListener(numberButtonListener);
            panel.add(button);
        }

        // Create button for 0
        JButton zeroButton = new JButton("0");
        zeroButton.setBounds(x + width + gap, y + 3 * (height + gap), width, height);
        zeroButton.addActionListener(numberButtonListener);
        panel.add(zeroButton);
    }
}
