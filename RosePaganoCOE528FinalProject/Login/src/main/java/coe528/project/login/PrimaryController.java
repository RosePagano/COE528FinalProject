package coe528.project.login;

import javafx.scene.control.TextField;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;

public class PrimaryController {
    /**
     * Overview: This class is the controller class for the Primary Scene (fxml file).
     * This class also provides all the methods needed for the functions of the buttons on the primary scene.
     * This is an immutable class and is not meant to be instantiated. 
     */
    @FXML
    private PasswordField passwordTextField;

    @FXML
    private TextField usernameTextField;
    
    @FXML
    private Label message;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    @FXML
    private void authenticate() throws IOException {
        UserInfo.username = usernameTextField.getText();
        UserInfo.password = passwordTextField.getText();
        if(UserInfo.username.equals("admin") && UserInfo.password.equals("admin")){	
            App.setRoot("secondary");
        }
        else if(Manager.containsName(UserInfo.username)){
            if(Manager.checkPassword(UserInfo.username, UserInfo.password)){
                App.setRoot("customerHome");
            }
            else{
                message.setText("Incorrect password, try again");
            }
            
        }
        else{
            message.setText("No account found, try again");
        }
    }
}
