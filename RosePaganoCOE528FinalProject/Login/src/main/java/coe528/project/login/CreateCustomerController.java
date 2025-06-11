/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.project.login;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author rosepagano
 */
public class CreateCustomerController {
    /**
     * Overview: This class is the controller class for the CreateCustomerController Scene (fxml file).
     * This class also provides all the methods needed for the functions of the buttons on the CreateCustomer scene.
     * This is an immutable class and is not meant to be instantiated. 
     */
    @FXML
    private TextField customerPassword;
    
    @FXML
    private Label taskMessage;
    
    @FXML
    private Label welcomeText;
    
    @FXML
    public void initialize(){
        welcomeText.setText("Password Creation for " + UserInfo.username);
    }
    @FXML
    private void backToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    @FXML
    private void createPassword() throws IOException {
        if(customerPassword.getText().equals("")||customerPassword.getText().contains(" ")){
            taskMessage.setText("Please enter a valid password.");
        }else if(Manager.containsName(UserInfo.username)){
            taskMessage.setText("This account already has a password!");
        }
        else{
        UserInfo.password = customerPassword.getText();
        Manager.addCustomer(UserInfo.username, UserInfo.password);
        taskMessage.setText("Account Created.");
        }
    }
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    
}
