/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordgenerator;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Alex
 */
public class Settings {
    private int maxLetters, caps, specs, nums;
    
    private SettingsUI settui;
    
    //position of buffer characters
    
    public Settings(){
        //set defalut values, will be overwritten if already exist
        maxLetters=20;  //max letters in words used
        caps=1; //capital letters
        specs=1;    //special characters
        nums=1; //numbers
        
        settui=new SettingsUI(this);
        
        loadSettings();
    }
    
    public JFrame getUI(){return settui.getFrame();}
    
    public int getMaxLetters(){return maxLetters;}
    public int getCaps(){return caps;}
    public int getSpecs(){return specs;}
    public int getNums(){return nums;}
    
    public int[] getSettings(){
        int setts[]={maxLetters, caps, specs, nums};    //make sure this order matches load and save
        return setts;
    }
    
    private void loadSettings(){
        if(FileLoader.settingsIs!=null){
            try {
                maxLetters=FileLoader.settingsIs.readInt();
                caps=FileLoader.settingsIs.readInt();
                specs=FileLoader.settingsIs.readInt();
                nums=FileLoader.settingsIs.readInt();
            } catch (IOException ex) {
                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        settui.setSpinners();
        saveSettings();
    }
    
    public void saveSettings(){
        maxLetters=(Integer) settui.getMaxSpin().getValue();
        caps=(Integer) settui.getCapSpin().getValue();
        specs=(Integer) settui.getSpecSpin().getValue();
        nums=(Integer) settui.getNumSpin().getValue();
        
        FileLoader.saveSettings(this.getSettings());
    }
}
