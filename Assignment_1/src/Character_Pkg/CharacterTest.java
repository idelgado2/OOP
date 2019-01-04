/*************************************************************************
 * Assignment_1(CHARCATER)
 * Isaac Delgado
 * COSC3324
 * 9/9/2016
 * Purpose: This class implements functionality of Character class by updating
 *          character attributes with setters and getters.
 **************************************************************************/
package Character_Pkg;

import java.util.Scanner;
import java.util.InputMismatchException;

public class CharacterTest {
    
    public static void setEverything(Character bob) throws InputMismatchException{
        
        Scanner scanner = new Scanner(System.in); //for input from user
        System.out.println("Strength: ");
            bob.setStrength(scanner.nextInt());
            
        System.out.println("Dexterity: ");
            bob.setDexterity(scanner.nextInt());
            
        System.out.println("Constitution: ");
            bob.setConstitution(scanner.nextInt());
            
        System.out.println("Intelligence: ");
            bob.setIntelligence(scanner.nextInt());
            
        System.out.println("Wisdom: ");
            bob.setWisdom(scanner.nextInt());
            
        System.out.println("Charisma: ");
            bob.setCharisma(scanner.nextInt());
    }
    
    public static void main(String[] args){
        System.out.println("I am creating Bob ....\n");
        
        Character bob = new Character(); //create class
        
        String input;
       
        try{
            
            System.out.println("Please input the following characteristics of your Bob\n");
            setEverything(bob);
            
        }catch(InputMismatchException | IllegalArgumentException e){
            System.out.println(e);
            System.out.println("Try again, No Negatives and ONLY Integers please!!\n");
            setEverything(bob);
        }
        
        ////////////////////////// replaced for exception
        //bob.setCharisma(50);
        //bob.setIntelligence(10);
        //bob.setStrength(25);
        //////////////////////////
        
        //set wisdome attribute with computation/////////////////// replaced for exception
        //bob.setWisdom(bob.getStrength() + bob.getIntelligence());
        ///////////////////////////////////////////////////////////
        
        System.out.println("Bob's Strength: " + bob.getStrength());
        System.out.println("Bob's Dexterity: " + bob.getDexterity());
        System.out.println("Bob's Constitution: " + bob.getConstitution());
        System.out.println("Bob's Intelligence: " + bob.getIntelligence());
        System.out.println("Bob's Wisdom: " + bob.getWisdom());
        System.out.println("Bob's Charisma: " + bob.getCharisma() + "\n");
        
        System.out.println("Total Stats for Bob: " + bob.getStatsTotal());
    }
}
