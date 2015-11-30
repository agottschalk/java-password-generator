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
import javax.swing.JPanel;
import javax.swing.JSpinner;

/**
 *
 * @author Alex
 */
public class SettingsUI {
    private Settings s;
    
    private JFrame settingsFrame;
    private JPanel settingsPanel;
    private JSpinner maxSpinner, specSpinner, numSpinner, capSpinner;
    
    private JButton saveB, cancelB;
    
    
    public SettingsUI(Settings s){
        this.s=s;
        
        makeUI();
    }
    
    private void makeUI(){
        //initial settings values will eventually be read off settings file
        settingsFrame=new JFrame("Settings");
        settingsPanel=new JPanel();
        settingsPanel.setLayout(new BoxLayout(
                settingsPanel, BoxLayout.PAGE_AXIS));
        
        
        JPanel panel2=new JPanel();
        panel2.add(new JLabel("Max letters per word:"));
        maxSpinner=new JSpinner();
        maxSpinner.setValue(s.getMaxLetters());
        panel2.add(maxSpinner);
        settingsPanel.add(panel2);
        
        
        settingsPanel.add(new JLabel("Buffer character breakdown"));
        
        
        JPanel panel3=new JPanel();
        panel3.add(new JLabel("Special Characters:"));
        specSpinner=new JSpinner();
        specSpinner.setValue(s.getSpecs());
        panel3.add(specSpinner);
        settingsPanel.add(panel3);
        
        
        JPanel panel4=new JPanel();
        panel4.add(new JLabel("Numbers:"));
        numSpinner=new JSpinner();
        numSpinner.setValue(s.getNums());
        panel4.add(numSpinner);
        settingsPanel.add(panel4);
        
        
        JPanel panel5=new JPanel();
        panel5.add(new JLabel("Capital Letters:"));
        capSpinner=new JSpinner();
        capSpinner.setValue(s.getCaps());
        panel5.add(capSpinner);
        settingsPanel.add(panel5);
        
        
        saveB=new JButton("Save");
        saveB.addActionListener(new SaveBListener());
        settingsPanel.add(saveB);
        
        settingsFrame.add(settingsPanel);
        settingsFrame.pack();
        settingsFrame.setVisible(false);    //do NOT set visible, there's a button for that
    }
    
    public void setSpinners(){
        maxSpinner.setValue(s.getMaxLetters());
        specSpinner.setValue(s.getSpecs());
        capSpinner.setValue(s.getCaps());
        numSpinner.setValue(s.getNums());
    }
    
    public JFrame getFrame(){return settingsFrame;}
    
    public JSpinner getMaxSpin(){return maxSpinner;}
    public JSpinner getSpecSpin(){return specSpinner;}
    public JSpinner getCapSpin(){return capSpinner;}
    public JSpinner getNumSpin(){return numSpinner;}
    
    
    private class SaveBListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            s.saveSettings();   
            
            settingsFrame.setVisible(false);
        }
    }
}
