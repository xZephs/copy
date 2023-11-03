package org.javafx;
import javafx.event.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class dataEntryController {
@FXML
 TextField appnameText;
 @FXML
 TextField appaddressText;
 @FXML
 TextField appageText;
 @FXML
 TextField appidText;
 @FXML
 TextField appemailText;
 @FXML
 TextField immnameText;
 @FXML
 TextField immaddressText;
 @FXML
 TextField immageText;
 @FXML
 TextField immidText;
 @FXML
 private Button exitButton;
 @FXML
 private AnchorPane mainPane;
 private Stage stage;
 private Scene scene;
 private Parent root;
 
 public void login(ActionEvent event) throws IOException {
   String appname = appnameText.getText();
   String appaddress = appaddressText.getText();
   String appemail = appemailText.getText();
   String immname = immnameText.getText();
   String immaddress = immaddressText.getText();
   int appage = 0;
   int appid = 0;
   int immage = 0;
   int immid = 0;
   try{
       appage = Integer.parseInt(appageText.getText());
       appid = Integer.parseInt(appidText.getText());
       immage = Integer.parseInt(immageText.getText());
       immid = Integer.parseInt(immidText.getText());
   }
   catch(Exception e)
   {
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Empty fields!");
      alert.setHeaderText("One of your fields is empty!");
      alert.setContentText("Cannot proceed. Field is empty!");
      alert.show();
   }
   FXMLLoader loader = new FXMLLoader(getClass().getResource("displayData.fxml"));
    root = loader.load();
    displayDataController displayDataController = loader.getController();
    if(appname==""||appaddress==""||appage==0||appid == 0 || appemail == "" || immname == "" || immaddress == "" || immage == 0 || immid == 0)
    {
      //alert
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Empty fields!");
      alert.setHeaderText("One of your fields is empty!");
      alert.setContentText("Cannot proceed. Field is empty!");
      alert.show();
    }
    else
    {
      displayDataController.addItemImm(immname, immaddress, immage, immid);
      displayDataController.addItemApp(appname, appaddress, appage, appid, appemail);
      stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
    }
   }
   
 public void exitScreen(ActionEvent event) throws IOException
 {
   Alert alert = new Alert(AlertType.CONFIRMATION);
   alert.setTitle("Exiting");
   alert.setHeaderText("You will exit soon.");
   alert.setContentText("Are you sure you want to do this? Your application will be lost!");
   if(alert.showAndWait().get() == ButtonType.OK) //want to exit
   {
      stage = (Stage)mainPane.getScene().getWindow();
      System.out.println("Exiting window...");
      stage.close();
   }
   else
   {
      System.out.println("Stopped closing.");
   }
   
 }
 

}
