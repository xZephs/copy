import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PersonEditorGUI1 extends JFrame {
    private JFrame frame;
    private JTextField AnameField, AageField, AemailField, AaddressField, ArealIDField;
    private JTextField InameField, IageField, IaddressField, IrealIDField;
    private JButton saveButton;
    private Document d;
    public Immigrant i;
    public Applicant a;
    public Workflow w;

    public PersonEditorGUI1(Document d) {
        this.d = d;
        i = d.getImmigrant();
        a = d.getApplicant();
        
        frame = new JFrame("Person Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setLayout(new GridLayout(12, 8));

        // Add review display for applicant 
        JLabel nameLabel = new JLabel("Applicant Name:");
        AnameField = new JTextField(a.getName());
        JLabel ageLabel = new JLabel("Applicant Age:");
        AageField = new JTextField(Integer.toString(a.getAge()));
        JLabel emailLabel = new JLabel("Applicant Email:");
        AemailField = new JTextField(a.getEmail());
        JLabel addressLabel = new JLabel("Applicant Address:");
        AaddressField = new JTextField(a.getAddress());
        JLabel realIDLabel = new JLabel("Applicant realID:");
        ArealIDField = new JTextField(Integer.toString(a.getRealID()));

        // Add review display for immigrant
        JLabel InameLabel = new JLabel("Immigrant Name:");
        InameField = new JTextField(i.getName());
        JLabel IageLabel = new JLabel("Immigrant Age:");
        IageField = new JTextField(Integer.toString(i.getAge()));
        JLabel IaddressLabel = new JLabel("Immigrant Address:");
        IaddressField = new JTextField(i.getAddress());
        JLabel IrealIDLabel = new JLabel("Immigrant realID:");
        IrealIDField = new JTextField(Integer.toString(i.getRealID()));

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveButtonClicked();
            }
        });

        frame.add(nameLabel);
        frame.add(AnameField);
        frame.add(ageLabel);
        frame.add(AageField);
        frame.add(emailLabel);
        frame.add(AemailField);
        frame.add(addressLabel);
        frame.add(AaddressField);
        frame.add(realIDLabel);
        frame.add(ArealIDField);

        frame.add(InameLabel);
        frame.add(InameField);
        frame.add(IageLabel);
        frame.add(IageField);
        frame.add(IaddressLabel);
        frame.add(IaddressField);
        frame.add(IrealIDLabel);
        frame.add(IrealIDField);

        frame.add(saveButton);

        frame.setVisible(true);
    }

    private void saveButtonClicked() {
        String aname = AnameField.getText();
        int aage = Integer.parseInt(AageField.getText());
        String aemail = AemailField.getText();
        String aaddress = AaddressField.getText();
        int arealID = Integer.parseInt(ArealIDField.getText());
        //System.out.println(name);

        a.setName(aname);
        a.setAge(aage);
        a.setEmail(aemail);
        a.setAddress(aaddress);
        a.setID(arealID);

        String iname = InameField.getText();
        int iage = Integer.parseInt(IageField.getText());
        String iaddress = IaddressField.getText();
        int irealID = Integer.parseInt(IrealIDField.getText());
        Workflow.updateData("Reivew", Workflow.getDoc(), true);

        i.setName(iname);
        i.setAge(iage);
        i.setAddress(iaddress);
        i.setID(irealID);
        // Add code to save the updated information here

        JOptionPane.showMessageDialog(frame, "Information saved successfully!");
    }

    public static void main(String[] args) {
        // Example usage
        Applicant a = Applicant.createApplicant("phu", "phu", 12, 12, "dkjbd");
        Immigrant i = Immigrant.createImmigrant("minh", "dcwefer", 23, 23);
        Document d  = Document.createDoc(i, a, 1,2);
        Workflow.createWorkflow(d);
        
        PersonEditorGUI1 gui = new PersonEditorGUI1(Workflow.getDoc());
        //System.out.println(Workflow.getDoc().getApplicant().getName());
 

    }
}
