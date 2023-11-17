package org.javafx;
import javafx.collections.*;
import javafx.event.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class displayDataController implements Initializable{
    @FXML
    private TableView<Immigrant> table;
    @FXML
    private TableColumn<Immigrant, String> immigrantAddress;
    @FXML
    private TableColumn<Applicant, String> appAddress;
    @FXML
    private TableColumn<Applicant, Integer> appAge;
    @FXML
    private TableColumn<Applicant, String> appEmail;
    @FXML
    private TableColumn<Applicant, Integer> appID;
    @FXML
    private TableColumn<Applicant, String> appName;
    @FXML
    private TableView<Applicant> appTable;
    @FXML
    private TableColumn<Immigrant, Integer> immigrantAge;
    @FXML
    private TableColumn<Immigrant, Integer> immigrantID;
    @FXML
    private TableColumn<Immigrant, String> immigrantName;
    @FXML
    private Button backButton;
     @FXML
    private AnchorPane mainPane;
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @Override   
    public void initialize(URL url, ResourceBundle resourceBundle) {
        immigrantName.setCellValueFactory(new PropertyValueFactory<Immigrant,String>("name"));
        immigrantAge.setCellValueFactory(new PropertyValueFactory<Immigrant,Integer>("age"));
        immigrantAddress.setCellValueFactory(new PropertyValueFactory<Immigrant,String>("address"));
        immigrantID.setCellValueFactory(new PropertyValueFactory<Immigrant,Integer>("realID"));
        appName.setCellValueFactory(new PropertyValueFactory<Applicant,String>("name"));
        appAge.setCellValueFactory(new PropertyValueFactory<Applicant,Integer>("age"));
        appAddress.setCellValueFactory(new PropertyValueFactory<Applicant,String>("address"));
        appID.setCellValueFactory(new PropertyValueFactory<Applicant,Integer>("realID"));
        appEmail.setCellValueFactory(new PropertyValueFactory<Applicant,String>("name"));
        
    }
    public void addItemImm(String immName, String immAddress, int immAge, int immID)
    {
        Immigrant immigrant = Immigrant.createImmigrant(immName,immAddress,(Integer)(immAge),(Integer)(immID));
        ObservableList<Immigrant> list = FXCollections.observableArrayList();
        list.add(immigrant);
        table.setItems(list);   
    }
    public void addItemApp(String appName, String appAddress, int appAge, int appID, String appEmail)
    {
        Applicant applicant = Applicant.createApplicant(appName,appAddress,(Integer)(appAge),(Integer)(appID),appEmail);
        ObservableList<Applicant> newList = FXCollections.observableArrayList();
        newList.add(applicant);
        appTable.setItems(newList);  
    }
    public void back(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dataEntry.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

} 
