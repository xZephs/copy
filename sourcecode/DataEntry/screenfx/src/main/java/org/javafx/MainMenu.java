package org.javafx;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class MainMenu {
    private JFrame frame;

    public MainMenu() {
        frame = new JFrame("Main Menu");
        frame.setSize(400, 300);

        JButton viewDocumentButton = new JButton("View Document");
        viewDocumentButton.addActionListener(e -> {
            Document d = Workflow.getDoc();
            
            ArrayList<String> info = new ArrayList<>();
            info.add(d.getApplicant().getName());
            info.add(d.getApplicant().getAddress());
            info.add(Integer.toString(d.getApplicant().getAge()));
            info.add(Integer.toString(d.getApplicant().getRealID()));
            info.add(d.getApplicant().getEmail());

            info.add(d.getImmigrant().getName());
            info.add(d.getImmigrant().getAddress());
            info.add(Integer.toString(d.getImmigrant().getAge()));
            info.add(Integer.toString(d.getImmigrant().getRealID()));
            

            ViewDocument viewDocument = new ViewDocument(info);
            viewDocument.showViewDocument();
        });

        

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e ->{
            frame.dispose();
            
        });

        JPanel panel = new JPanel();
        panel.add(viewDocumentButton);
        panel.add(exitButton);

        frame.add(panel);
    }

    public void showMainMenu() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.showMainMenu();
    }
}

