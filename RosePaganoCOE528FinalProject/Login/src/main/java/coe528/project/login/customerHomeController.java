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
public class customerHomeController {
    /**
     * Overview: This class is the controller class for the customerHome Scene (fxml file).
     * This class also provides all the methods needed for the functions of the buttons on the customerHome scene.
     * This is an immutable class and is not meant to be instantiated. 
     */
    
    @FXML
    private Label balenceText;

    @FXML
    private TextField customerNum;
    
    @FXML
    private Label levelText;
    
    @FXML
    private Label taskMessage;

    @FXML
    private Label welcomeText;
    
    
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    @FXML
    public void initialize()throws IOException{
        welcomeText.setText("hello " + UserInfo.username+"!");
        double bal;
        String lev;
        bal = Manager.customers.get(Manager.getCustomerIndex(UserInfo.username)).getBankAccount().balence;
        lev = Manager.customers.get(Manager.getCustomerIndex(UserInfo.username)).getBankAccount().leveltoString();
        balenceText.setText("Account Balence:  " + bal);
        levelText.setText("Account Level:  " + lev);
    }
    @FXML
    private void deposit() throws IOException {
        if(Manager.customers.get(Manager.getCustomerIndex(UserInfo.username)).getBankAccount().deposit(Double.parseDouble(customerNum.getText()))){
            initialize();
            taskMessage.setText("Success!");
        }
        else{
            taskMessage.setText("You must deposit a number greater than 0");
        }
        
    }
    @FXML
    private void withdraw() throws IOException {
        if(Manager.customers.get(Manager.getCustomerIndex(UserInfo.username)).getBankAccount().withdraw(Double.parseDouble(customerNum.getText()))){
            initialize();
            taskMessage.setText("Success!");
        }
        else{
            taskMessage.setText("Unable to withdraw funds.");
        }
        
    }
    @FXML
    private void makeOnlinePurchase() throws IOException {
        int fee = Manager.customers.get(Manager.getCustomerIndex(UserInfo.username)).getBankAccount().level.getFee();
        if(Manager.customers.get(Manager.getCustomerIndex(UserInfo.username)).getBankAccount().doOnlinePurchase(Double.parseDouble(customerNum.getText()))){
            initialize();
            taskMessage.setText("Purchase Complete with a Fee of "+ fee);
        }
        else{
            taskMessage.setText("Unable to complete purchase.");
        }
    }
    
}
