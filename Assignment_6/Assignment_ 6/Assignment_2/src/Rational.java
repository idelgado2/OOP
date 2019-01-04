/*************************************************************************
 * Assignment_2(RATIONAL)
 * Isaac Delgado
 * COSC3324
 * 9/18/2016
 * Purpose: The purpose of this class is to create an object for individual
 *          fractions. Each fraction will be reduced as far as can be. This
 *          class allows for adding, subtracting, multiplying, and dividing
 *          two fractions. These computations are static methods and thus
 *          can be used without creating an object of this class.
 *
 * Attributes: Consist of a numerator and denominator with corresponding 
 *              getter methods. A constant list of primes under 100 is 
 *              initialized. Lastly adding, subtracting, multiplying,
 *              and dividing methods for any two fractions.
 **************************************************************************/

import java.text.DecimalFormat;
import java.lang.IllegalArgumentException;

public class Rational {
    private int numerator;
    private int denominator;
    private final int[] prime = {2,3,5,7,11,13,17,19,23,29,31,
                                    37,41,43,47,53,59,61,67,71,73,79,83,89,97};
    
    public boolean binarySearch(int key){
        /**
         *  modified binary search from "JAVA: How to Program" figure 19.3  
         */
        int low = 0;
        int high = prime.length - 1;
        int middle = (low + high + 1)/2;
        
        do{
            if(key == prime[middle])
                return true;
            else if(key < prime[middle]) // if key < middle prime -> must be in lower half
                high = middle - 1;
            else  //else -> must be in upper half
                low = middle + 1;
            
            middle = (low + high + 1) / 2; //recalculate middle position    
        }while(low <= high);
        
        return false; //if prime does not exist in array
    }
    
    public Rational(){ //default constructor
        numerator = 1;
        denominator = 1;
    }
    
    public Rational(int num, int den){
        for(int i = 0; i < prime.length; i++){
            //cycles through each prime under 100
            while(num % prime[i] == 0 && den % prime[i] == 0){
                //reduce fraction as low as possible with prime[i]
                num = num/prime[i];
                den = den/prime[i];
            }
        }
        //fraction is reduced as far as possible
        numerator = num;
        denominator = den;
    }
    
    public void setNumerator(int num){
        numerator = num;
    }
    
    public void setDenominator(int den)throws IllegalArgumentException{
        if(den == 0){
            throw new IllegalArgumentException("Cannot divide by 0!!");
        }
        
        denominator = den;
    }
    
    public int getNumerator(){
        return numerator;
    }
    public int getDenominator(){
        return denominator;
    }
    
    public static Rational addRationls(Rational fraction1, Rational fraction2){
        //get common multiple for denominator and cross multiple for numerators
        int denominator = (fraction1.getDenominator() * fraction2.getDenominator());
        int numerator = ((fraction1.getNumerator() * fraction2.getDenominator())
                           + (fraction2.getNumerator() * fraction1.getDenominator()));
        //send to reducing constructor
        Rational fraction = new Rational(numerator, denominator); 
        return fraction;
    }
    
    public static Rational subtractRationls(Rational fraction1, Rational fraction2){
        //get common multiple for denominator and cross multiple for numerators
        int numerator, denominator;
        int fraction1_num = fraction1.getNumerator() * fraction2.getDenominator();
        int fraction2_num = fraction2.getNumerator() * fraction1.getDenominator();
        int i  = fraction2_num - fraction1_num;
        
        //subtract biggest value first to avoid negative fraction occurs
        if(fraction1_num < fraction2_num) 
            numerator = (fraction2_num - fraction1_num);
        else
            numerator = (fraction1_num - fraction2_num);
        
        denominator = (fraction1.getDenominator() * fraction2.getDenominator());
        
        //send to reducing constructor
        Rational fraction = new Rational(numerator, denominator); 
        return fraction;
    }
    
    public static Rational multiplyRationals(Rational fraction1, Rational fraction2){
        //multiply across numerator and denomintor
        int denominator = (fraction1.getDenominator() * fraction2.getDenominator());
        int numerator = (fraction1.getNumerator() * fraction2.getNumerator());
        
        //send to reducing constructor
        Rational fraction = new Rational(numerator, denominator);
        return fraction;
    }
    
    public static Rational divideRationals(Rational fraction1, Rational fraction2){
        //multiply fraction1 with reciprocal (cross muliply across)
        int denominator = (fraction1.getDenominator() * fraction2.getNumerator());
        int numerator = (fraction1.getNumerator() * fraction2.getDenominator());
        
        //send to reducing constructor
        Rational fraction = new Rational(numerator, denominator);
        return fraction;
    }
    //@Override
    public String toString(int precision){
        //create DecimalFormat object for formating float
        DecimalFormat digit = new DecimalFormat();
        digit.setMinimumFractionDigits(precision);
        
        float decimal = ((float)numerator/(float)denominator);
        return String.format("%s/%s => %s", numerator, denominator, 
                                                digit.format(decimal), decimal);
    }
}
