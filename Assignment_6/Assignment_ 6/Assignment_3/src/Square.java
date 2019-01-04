/*************************************************************************
 * Assignment_3(SQUARE)
 * Isaac Delgado
 * COSC3324
 * 9/24/2016
 * Purpose: The purpose of this class is to create an object of Squares and
 *          inherits from super class Shape and implements interface Area
 *
 * Attributes: Consist of a double side and inherited method getArea
 **************************************************************************/

import java.lang.IllegalArgumentException;


/**
 *
 * @author Isaac
 */
public class Square extends Shape implements Area{
    private double side;
    
    Square(){
        side = 0;
        super.setName("Square");
    }
    
    Square(double s, String n){
        this.setSide(s);
        super.setName(n);
    }
    
    public void setSide(double s) throws IllegalArgumentException{
        if(s <= 0){
            throw new IllegalArgumentException("Side of SQUARE must be greater than 0");
        }
        side = s;
    }
    
    public double getSide(){
        return side;
    }
    
    @Override
    public double getArea(){
        return (side * side);
    }
}
