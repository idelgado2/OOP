/*************************************************************************
 * Assignment_1(CHARACTER)
 * Isaac Delgado
 * COSC3324
 * 9/9/2016
 * Purpose: This class implements a character description regarding the
 *          character's values of attributes
 *
 * Attributes: Consist of strength, dexterity, constitution, intelligence
 *              wisdom, charisma, and totalStats along with basic setters
 *              and getters. Where totaStats is the total of all values
 *              together.
 **************************************************************************/
package Character_Pkg;
import java.lang.IllegalArgumentException;

public class Character {
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int totalStats;
    
    public Character(){
        strength = 0;
        dexterity = 0;
        constitution = 0;
        intelligence = 0;
        wisdom = 0;
        charisma = 0;
    }
    
    public void setStrength(int strengthValue) throws IllegalArgumentException{
        if(strengthValue < 0){ //value cannot be negative
            throw new IllegalArgumentException("Strength Cannot be negative");
        }
        strength = strengthValue;
    }
    public int getStrength(){
        return strength;
    }
    
    public void setDexterity(int dexterityValue)throws IllegalArgumentException{
        if(dexterityValue < 0){ //value cannot be negative
            throw new IllegalArgumentException("Dexterity Cannot be negative");
        }
        dexterity = dexterityValue;
    }
    public int getDexterity(){
        return dexterity;
    }
    
    public void setConstitution(int constitutionValue)throws IllegalArgumentException{
        if(constitutionValue < 0){ //value cannot be negative
            throw new IllegalArgumentException("Constitution Cannot be negative");
        }
        constitution = constitutionValue;
    }
    public int getConstitution(){
        return constitution;
    }
    
    public void setIntelligence(int intelligenceValue)throws IllegalArgumentException{
        if(intelligenceValue < 0){ //value cannot be negative
            throw new IllegalArgumentException("Intelligence Cannot be negative");
        }
        intelligence = intelligenceValue;
    }
    public int getIntelligence(){
        return intelligence;
    }
    
    public void setWisdom(int wisdomValue)throws IllegalArgumentException{
        if(wisdomValue < 0){ //value cannot be negative
            throw new IllegalArgumentException("Wisdom Cannot be negative");
        }
        wisdom = wisdomValue;
    }
    public int getWisdom(){
        return wisdom;
    }
    
    public void setCharisma(int charismaValue)throws IllegalArgumentException{
        if(charismaValue < 0){ //value cannot be negative
            throw new IllegalArgumentException("Charisma Cannot be negative");
        }
        charisma = charismaValue;
    }
    public int getCharisma(){
        return charisma;
    }
    
    public int getStatsTotal(){
        //add all valued characteristics together
        //totalStats should be positive
        totalStats = strength + dexterity + 
                        constitution + intelligence + 
                                wisdom + charisma;
        if(totalStats < 0 ){
            //if all values added together is negative return 0
            return 0;
        }else{
            return totalStats;
        }
    }
}
