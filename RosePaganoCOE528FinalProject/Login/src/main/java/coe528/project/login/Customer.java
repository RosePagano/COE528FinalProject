/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.project.login;

/**
 *
 * @author rosepagano
 */
public class Customer {
    /**
     * Overview: This class uses data abstraction to create a new data type "Customer", which is meant to store the login information and bank account information. 
     * This is a immutable class since the instance variables "username", "password" and "acc" cannot be changed after the creation of the Customer.  
     */
    private BankAccount acc;
    private String username;
    private String password;
    
    Customer(String username, String password){
        this.username = username;
        this.password = password;
        acc = new BankAccount();
    }
    public String getUsername(){
        return username;
    }
    public BankAccount getBankAccount(){
        return acc;
    }
    public String getPassword(){
        return password;
    }
}
