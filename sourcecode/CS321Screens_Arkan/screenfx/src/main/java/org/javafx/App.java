package org.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.event.*;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application{
    Button button;
    @Override
    public void start(Stage stage) throws IOException {
        //scene = new Scene(loadFXML("primary"), 640, 480);
        Parent root = FXMLLoader.load(getClass().getResource("dataEntry.fxml"));
        stage.setTitle("Tester");
        StackPane layout = new StackPane(); 
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event->
        {
            event.consume();
            exitScreen(stage);
        });
    }
   
    public void exitScreen(Stage stage) 
    {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Exiting");
        alert.setHeaderText("You will exit soon.");
        alert.setContentText("Are you sure you want to do this? Your application will be lost!");
        if(alert.showAndWait().get() == ButtonType.OK) //want to exit
        {
            System.out.println("Exiting window...");
            stage.close();
        }
        else
        {
            System.out.println("Stopped closing.");
        }
   
    }
    public static void main(String[] args) {
        launch();
        PersonEditorGUI gui = new PersonEditorGUI(Workflow.getDoc());
        // MainMenu mainMenu = new MainMenu();
        // mainMenu.showMainMenu();
    }

}