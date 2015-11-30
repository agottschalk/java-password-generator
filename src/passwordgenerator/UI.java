/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordgenerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;

/**
 *
 * @author Alex
 */
public class UI {
    //holds all gui components for main window
    private generator g;
    private Settings s;
    
    private JFrame frame, settingsFrame;
    private JPanel mainPanel;
    
    private JSpinner wordSpinner, junkSpinner;
    
    
    
    public UI(generator g, Settings s){
        this.g=g;
        this.s=s;
        settingsFrame=s.getUI();
        makeMainWindow();
    }
    
    
    private void makeMainWindow(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        
        
        //set up word selector
        JPanel panel1=new JPanel();
        panel1.add(new JLabel("How many words?"));
        
        wordSpinner=new JSpinner();
        wordSpinner.setValue(2);
        panel1.add(wordSpinner);
        mainPanel.add(panel1);
        
        
        //set up extra character selectors
        JPanel panel2=new JPanel();
        panel2.add(new JLabel("Total buffer characters?"));
        
        junkSpinner=new JSpinner();
        junkSpinner.setValue(3);
        panel2.add(junkSpinner);
        mainPanel.add(panel2);
        
        //add buttons
        JButton button = new JButton("Generate");
        button.addActionListener(new ButtonListener());
        mainPanel.add(button);
        
        JButton settingsB=new JButton("Settings");
        settingsB.addActionListener(new SettingsListener());
        mainPanel.add(settingsB);
        
        
        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }
    
    
    
    private class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            s.saveSettings();
            
            String password=g.generate((Integer) wordSpinner.getValue(), 
                (Integer) junkSpinner.getValue(), 
                s.getMaxLetters(), s.getCaps(), s.getSpecs(), s.getNums());
            

            JOptionPane passWDialog=new JOptionPane();
            passWDialog.showMessageDialog(frame, password, "Your Password:", 
                    JOptionPane.PLAIN_MESSAGE);
            
        }
        
    }
    
    private class SettingsListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //pull up settings window
            
            settingsFrame.setVisible(true);
        }
        
    }
}
