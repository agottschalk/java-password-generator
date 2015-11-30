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
public class WordHandler {
    private ArrayList <String> words;
    private Random rand;
    
    public WordHandler(){
        words=FileLoader.wordList;
        rand=new Random();
        
        
    }
    
    public String getWord(int max){
        String outputWord;
        
        do{
        outputWord=words.get(rand.nextInt(words.size()));
        }while(outputWord.length()>max);
        
        return outputWord;
    }
}
