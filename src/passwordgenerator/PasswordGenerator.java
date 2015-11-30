/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordgenerator;

/**
 *
 * @author Alex
 */
public class PasswordGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PasswordGenerator pg=new PasswordGenerator();
        //FileLoader.load();
        //pg.start();
    }
    
    private generator g;
    private Settings s;
    private UI ui;
    
    
    public PasswordGenerator(){
        FileLoader.load();
        g=new generator(new WordHandler());
        s=new Settings();
        ui=new UI(g, s);
    }
    
    public void start(){
        
    }
}
