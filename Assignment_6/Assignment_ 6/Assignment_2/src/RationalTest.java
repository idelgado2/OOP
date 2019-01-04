/*************************************************************************
 * Assignment_2(RATIONAL_TEST)
 * Isaac Delgado
 * COSC3324
 * 9/18/2016
 * Purpose: This class test the functionality of the class Rational by
 *          creating an object for two fractions (3/9 & 12/54) and creating
 *          objects for all computations associated with these two fractions.
 **************************************************************************/
import java.util.Scanner;
import java.util.InputMismatchException;


public class RationalTest {
    
    public static void setEverything(Rational ratio){
        Scanner reader = new Scanner(System.in);
        
        System.out.print("Denominator: ");
        ratio.setDenominator(reader.nextInt());
            
        System.out.print("Numerator: ");
        ratio.setDenominator(reader.nextInt());
    }
    
    public static void setPrecision(int precision) throws IllegalArgumentException{
        Scanner reader = new Scanner(System.in);
        precision = reader.nextInt();
            if(precision < 1){
                throw new IllegalArgumentException("Precision has to be atleast 1 or greater");
            }
    }
    
    public static void main(String [] args){
        int precision = 0;
        
        try{
            System.out.print("How many #'s of digits to the right decimal point: ");
            setPrecision(precision);
            
        }catch(InputMismatchException | IllegalArgumentException e){
            System.out.println(e + "\nPlease try again");
            
            System.out.print("How many #'s of digits to the right decimal point: ");
            setPrecision(precision);
        }
        
        //Rational ratio1 = new Rational(5, 10); //creating two fractions
        //Rational ratio2 = new Rational(25, 100); 
        
        Rational ratio1 = new Rational();
        Rational ratio2 = new Rational();
        
        System.out.println(" Please input the numerator & denominator for for rationals");
        
        try{  
            System.out.println("Rational 1");
            setEverything(ratio1);
            
            System.out.println("Rational 2");
            setEverything(ratio2);
            
        }catch(InputMismatchException | IllegalArgumentException e){
            
            System.out.println("Try again " + e);
            
            System.out.println("Rational 1");
            setEverything(ratio1);
            
            System.out.println("Rational 2");
            setEverything(ratio2);
        }
        
        
        
        System.out.println("\n**** Calculations ****\n");
        
        //creating object fractions for all computations for reducing
        Rational addedRatios = Rational.addRationls(ratio1, ratio2);
        Rational subtractedRatios = Rational.subtractRationls(ratio1, ratio2);
        Rational multipliedRatios = Rational.multiplyRationals(ratio1, ratio2);
        Rational dividedRatios = Rational.divideRationals(ratio1, ratio2);
        
        //ouptut
        System.out.println("Ratio 1 => " + ratio1.toString(precision));
        System.out.println("Ratio 2 => " + ratio2.toString(precision));
        System.out.println("Added ratios => " + addedRatios.toString(precision));
        System.out.println("Subtracted ratios => " + subtractedRatios.toString(precision));
        System.out.println("Multiplied ratios => " + multipliedRatios.toString(precision));
        System.out.println("Divided ratios => " + dividedRatios.toString(precision));
        
    }
}
