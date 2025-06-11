/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.project.login;

/**
 *
 * @author rosepagano
 */
public class Level {
    private LevelState state;
    public void setState(LevelState state) {
        this.state = state;
    }
    public int getFee(){
        return state.handleGetFee();
    }
    
}
