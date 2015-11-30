/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordgenerator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */

public class FileLoader {
    public static File sourceWordList;
    public static ObjectInputStream settingsIs;
    public static Scanner wordInput;
    
    public static ArrayList<String> wordList;
    
    
    public static void load(){
        //load word list
        sourceWordList=new File("wordList.txt");
        try{
            wordInput=new Scanner(FileLoader.sourceWordList);   
        } catch (IOException ex) {
            Logger.getLogger(FileLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //load file with words
        wordList=new ArrayList();
        while(FileLoader.wordInput.hasNextLine()){
            wordList.add(FileLoader.wordInput.nextLine());
        }
        
        
        
        //load settings
        try {
            settingsIs=new ObjectInputStream(new FileInputStream("settings.bin"));
        } catch (FileNotFoundException ex) {
            //if there is no settings file, the settings object will have one made
        } catch (IOException ex) {
            Logger.getLogger(FileLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    //no arguments version sets up default settings
    public static void saveSettings(){
        //write file with settings
        try {
            ObjectOutputStream settingsOs=
                    new ObjectOutputStream(new FileOutputStream("settings.bin"));
            settingsOs.close();
        } catch (IOException ex) {
            Logger.getLogger(FileLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void saveSettings(int[] setts){
        //writes settings file to match values in settings object
        try {
            ObjectOutputStream settingsOs=
                    new ObjectOutputStream(new FileOutputStream("settings.bin"));
            
            for(int i=0; i<setts.length; i++){
                settingsOs.writeInt(setts[i]);
            }
            
            settingsOs.close();
            
        } catch (IOException ex) {
            Logger.getLogger(FileLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
