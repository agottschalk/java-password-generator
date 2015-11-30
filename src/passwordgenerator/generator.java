/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordgenerator;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Alex
 */
public class generator {
    private WordHandler wordHandler;
    private Random rand;
    
    private ArrayList<String> elements;
    
    public generator(WordHandler w){
        wordHandler=w;
        elements=new ArrayList();
        rand=new Random();
    }
    
    public String generate(
            int words, int junk, int max, int caps, int specs, int nums){
        //error check empty password and number of buffer characters
        elements.clear();
        
        getElements(words, junk, max, caps, specs, nums);
        return writePassword();
    }
    
    private String specialChar(){
        int i=33+rand.nextInt(12);
        switch(i){
            case 34: 
                return String.valueOf('?');
            case 39:
                return String.valueOf('@');
            case 44:
                return String.valueOf('=');
            default:
                return String.valueOf((char) i);
        }
    }
    
    private String lowercaseLetter(){
        return String.valueOf((char) (97+rand.nextInt(26)));
    }
    
    private String uppercaseLetter(){
        return String.valueOf((char) (65+rand.nextInt(26)));
    }
    
    private String number(){return String.valueOf(rand.nextInt(9));}
    
    private void getElements(
        int words, int junk, int max, int caps, int specs, int nums){
        
        int bufferChars=junk-(specs+nums+caps);
        if(bufferChars<0){
            System.out.println("not enough buffer characters");
        }else if(words==0 && junk==0 && specs==0 && nums==0 && caps==0){
            System.out.println("hey, there's nothing to build!");
        }else{
            //set up password elements
            for(int i=0; i<words; i++){
                elements.add(wordHandler.getWord(max));
            }
            for(int i=0; i<specs; i++){
                elements.add(specialChar());
            }
            for(int i=0; i<nums; i++){
                elements.add(number());
            }
            for(int i=0; i<caps; i++){
                elements.add(uppercaseLetter());
            }
            for(int i=0; i<bufferChars; i++){
                elements.add(lowercaseLetter());
            }
        }
    }
    
    private String writePassword(){        //put everything together for complete password
        String password=new String();
        int position;
        
        while(!elements.isEmpty()){
            position=rand.nextInt(elements.size());
            password+=elements.get(position);
            elements.remove(position);
        }
        
        return password;
    }
}
