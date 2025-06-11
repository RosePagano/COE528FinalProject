/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.project.login;
import java.util.ArrayList;

/**
 *
 * @author rosepagano
 */
public class Manager {
    /**
     * Overview: This class uses data abstraction to create a new data type "Manager", which is meant to store all of the customers information, and carries the same information for all instances of Manager. This is due to all variables and methods being static. 
     * This is a mutable class since the static variable "customers" can be changed after the creation of the Manager.  
     */
    static ArrayList<Customer> customers = new ArrayList<Customer>();
    public static void addCustomer(String username, String password){
        customers.add(new Customer(username, password));
    }
    public static boolean deleteCustomer(String name){ //returns true if successfully deleted, returns false if element isn't in list
        boolean b = false;
        for(Customer i: customers){
            if(i.getUsername().equals(name)){
                customers.remove(i);
                b = true;
            }
        }
        return b;
    }
    public static boolean containsName(String name){ 
        boolean b = false;
        for(Customer i: customers){
            if(i.getUsername().equals(name)){
                b = true;
            }
        }
        return b;
    }
    public static boolean checkPassword(String name, String pass){ 
        boolean b = false;
        for(Customer i: customers){
            if(i.getUsername().equals(name) && i.getPassword().equals(pass)){
                b = true;
            }
        }
        return b;
    }
    
    public static int getCustomerIndex(String name){ 
        int x = -1;
        for(Customer i: customers){
            x++;
            if(i.getUsername().equals(name)){
                return x;
            }
        }
        return x;
    }
    
    @Override
    public String toString(){
        String s = "";
        for(Customer i: customers){
           s = s +"Username: "+ i.getUsername() + " Password: "+i.getPassword() + "\n"; 
        }
        return s;
    }
}
