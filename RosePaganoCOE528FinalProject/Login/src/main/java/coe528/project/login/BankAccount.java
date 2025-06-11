/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.project.login;

/**
 *
 * @author rosepagano
 */
public class BankAccount {
    /**
     * Overview: This class uses data abstraction to create a new data type "BankAccount", which is every customer is intended to have. 
     * This is a mutable class since the instance variables "balance" and "level" can be changed after the creation of the BankAccount.
     * Abstraction function: A typical Bank Account has a balance and a level
     * AF(balance, level) = A Bank Account with a balance and level. 
     * Rep Invariant:
     * balance > 0 
     */
    double balence;
    Level level;
    /**
     * Constructor
     * @effects: initialized balance and level.
     */
    BankAccount(){
        balence = 100.0;
        level = new Level();
        level.setState(new Silver());
    }
    /**
     * @param n
     * @return
     * Method to deposit money into the BankAccount
     * @effects if n > 0, balance increases n and true is returned. Otherwise 
     * false is returned. The setLevel function is called to adjust the level 
     * after the balance has changed.
     * @modifies balance, level
     */
    public boolean deposit(double n){
        if(n>0){
        balence = balence + n;
        this.setLevel(balence);
        return true;
        }
        else{
            return false;
        }
    }
    /**
     * @param n
     * @return
     * Method to withdraw money out of the BankAccount
     * @effects if balance >= n, balance decreases by n and true is returned. 
     * Otherwise false is returned.The setLevel function is called to adjust the 
     * level after the balance has changed.
     * @modifies balance, level
     */
    public boolean withdraw(double n){
        if(balence>=n){
        balence = balence - n;
        this.setLevel(balence);
        return true;
        }
        else{
            return false;
        }
    }
    /**
     * @param x
     * @return
     * Method to adjust the BankAccounts level based on the balance.
     * @effects if 10000>x, level is changed to Silver. if x>100000 and 200000>x, 
     * level is changed to Gold. Otherwise, level is Platinum.
     * @modifies level
     */
    private void setLevel(double x){
        if(x<10000){
            level.setState(new Silver());
        }
        else if(x>=10000 && x<20000){
            level.setState(new Gold());
        }
        else if(x>=20000){
            level.setState(new Platinum());
        }
    }
    /**
     * @return 
     * Method to convert a level object to its String representation
     * @effects depending on the fee of the level its associated state is returned
     */
    public String leveltoString(){
        int z = this.level.getFee();
        switch(z){
            case 20:
                return "Silver";
            case 10:
                return "Gold";
            case 0:
                return "Platinum";
            default:
                return "";
        }
    }
    /**
     * @param amount
     * @return
     * Method to place an online purchase.
     * @effects if 50>amount, or the amount is more than the balance false is 
     * returned, and the purchase isn't completed. Otherwise, The purchase amount 
     * is withdrawn as well as the associated fee based on the account level. 
     * After the balance is changed the account level is updated.
     * If the purchase is completed it will return true
     * @modifies balance, level
     */
    public boolean doOnlinePurchase(double amount){ 
    if(amount<50 || balence<amount + level.getFee()){
        return false;
    }
    balence = balence - amount - level.getFee();
    this.setLevel(balence);
    return true;
}
    /**
     * 
     * @return 
     * repOk checks whether the instance variables are valid.
     * @effects returns true if the balance is greater than or equal to zero 
     */
    public boolean repOk(){
        if(balence>=0){
        }
        return false;
    }
    /**
     * 
     * @return 
     * toString converts an object to String.
     * @effects returns BankAccount with its balance and level shown. 
     */
    @Override
    public String toString(){
        return "Balance: "+balence+"Level: "+this.leveltoString(); //The string representation contains the balence and level (the AF).
    }
}
