package org.javafx;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ViewDocument {
    private JFrame frame;
    private JTextArea documentTextArea;

    public ViewDocument(ArrayList<String> info) {
        frame = new JFrame("View Document");
        frame.setSize(400, 300);

        documentTextArea = new JTextArea();
        documentTextArea.setEditable(false);

        // Format the information from the ArrayList
        StringBuilder documentContent = new StringBuilder();
        documentContent.append("APPLICANT INFO\n");
        documentContent.append("Name: ").append(info.get(0)).append("\n");
        documentContent.append("Age: ").append(info.get(2)).append("\n");
        documentContent.append("ID: ").append(info.get(3)).append("\n");
        documentContent.append("Address: ").append(info.get(1)).append("\n");
        documentContent.append("Email: ").append(info.get(4)).append("\n\n");

        documentContent.append("IMMIGRANT INFO\n");
        documentContent.append("Name: ").append(info.get(5)).append("\n");
        documentContent.append("Age: ").append(info.get(7)).append("\n");
        documentContent.append("ID: ").append(info.get(8)).append("\n");
        documentContent.append("Address: ").append(info.get(6)).append("\n");

        documentTextArea.setText(documentContent.toString());

        JButton sendBackButton = new JButton("Send Back");
        JButton approveButton = new JButton("Approve");

        sendBackButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Document has been sent back to Reviewer.");
            frame.dispose();
        });

        approveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Open the EmailSenderGUI window
                frame.dispose(); 
                new EmailSenderGUI();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(sendBackButton);
        buttonPanel.add(approveButton);

        frame.add(new JScrollPane(documentTextArea), BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public void showViewDocument() {
        frame.setVisible(true);
    }

    
}
