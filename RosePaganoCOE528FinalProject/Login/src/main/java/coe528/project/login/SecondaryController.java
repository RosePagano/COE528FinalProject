package coe528.project.login;

import static coe528.project.login.App.scene;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
public class SecondaryController {
    /**
     * Overview: This class is the controller class for the Primary Scene (fxml file).
     * This class also provides all the methods needed for the functions of the buttons on the secondary scene.
     * This is an immutable class and is not meant to be instantiated. 
     */
    @FXML
    private Label welcomeText;
    
    @FXML
    private TextField customerUsername;
    
    @FXML
    private Label taskMessage;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    @FXML
    public void initialize()throws IOException{
        welcomeText.setText("hello " + UserInfo.username+"!");
    }
    @FXML
    private void addCustomer() throws IOException{
        if(customerUsername.getText().equals("")||customerUsername.getText().contains(" ")){
            taskMessage.setText("Usernames can't be empty or contain spaces");
        }else if(Manager.containsName(customerUsername.getText())||customerUsername.getText().equals("manager")){
            taskMessage.setText("This username already exists!");
        }
        else{
            UserInfo.username = customerUsername.getText();
            App.setRoot("CreateCustomer");
        }

    }
    @FXML
    private void delete() throws IOException{
        if(Manager.containsName(customerUsername.getText())){
            taskMessage.setText("successfully deleted!");
        }
        else{
            taskMessage.setText("This accound cannot be deleted because it does not exist.");
        }
        Manager.deleteCustomer(customerUsername.getText());
        
    }
   
}