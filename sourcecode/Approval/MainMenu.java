import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

/**
 * Main Menu for Approval
 * @author M. Phan
 */
public class MainMenu {
    private JFrame frame;

    public MainMenu() {
        frame = new JFrame("Main Menu");
        frame.setSize(400, 300);

        JButton viewDocumentButton = new JButton("View Document");

        //retrieve from workflow to view document
        viewDocumentButton.addActionListener(e -> {
            Document d = Workflow.getDoc();
            ArrayList<String> info = new ArrayList<>();
            info.add(d.getApplicant().getName());
            info.add(d.getApplicant().getAddress());
            info.add(Integer.toString(d.getApplicant().getAge()));
            info.add(Integer.toString(d.getApplicant().getID()));
            info.add(d.getApplicant().getEmail());

            info.add(d.getImmigrant().getName());
            info.add(d.getImmigrant().getAddress());
            info.add(Integer.toString(d.getImmigrant().getAge()));
            info.add(Integer.toString(d.getImmigrant().getID()));

            info.add(Integer.toString(d.getId()));
            
            frame.dispose();
            ViewDocument viewDocument = new ViewDocument(info);
            viewDocument.showViewDocument();
        });

        
        //exit button
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e ->{
            frame.dispose();
            
        });

        //organizing buttons in space.
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

