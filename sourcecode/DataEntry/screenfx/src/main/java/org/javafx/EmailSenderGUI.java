package org.javafx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmailSenderGUI {
    private JFrame frame;
    private JTextArea emailContent;

    public EmailSenderGUI() {
        frame = new JFrame("Email Sender");
        frame.setSize(400, 300);

        emailContent = new JTextArea();
        emailContent.setLineWrap(true);
        emailContent.setWrapStyleWord(true);

        JButton sendButton = new JButton("Send");

        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Simulate sending email (replace this with actual email sending code)
                boolean emailSent = true;

                if (emailSent) {
                    JOptionPane.showMessageDialog(frame, "Email sent successfully!");
                    openMainMenu(); // Open the main menu after message is shown
                }
            }
        });

        frame.add(new JScrollPane(emailContent), BorderLayout.CENTER);
        frame.add(sendButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void openMainMenu() {
        frame.dispose(); // Close the current window

        // Create and show the main menu window
        MainMenu mainMenu = new MainMenu();
        mainMenu.showMainMenu();
    }

   /*  public static void main(String[] args) {
        new EmailSenderGUI();
    } */
}
