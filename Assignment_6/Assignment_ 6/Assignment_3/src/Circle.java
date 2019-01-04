/*************************************************************************
 * Assignment_3(CIRCLE)
 * Isaac Delgado
 * COSC3324
 * 9/24/2016
 * Purpose: The purpose of this class is to create an object of Circle and
 *          inherits from super class Shape and implements interface Area
 *
 * Attributes: Consist of a double radius, final PI and inherited 
 *              method getArea
 **************************************************************************/

import java.lang.IllegalArgumentException;

/**
 *
 * @author Isaac
 */
public class Circle extends Shape implements Area{
    private double radius;
    final double PI = 3.14159;
    
    Circle(){
        radius = 0;
        super.setName("Circle");
    }
    
    Circle(double r, String n){
        this.setRadius(r);
        super.setName(n); //shape name
    }
    
    public void setRadius(double r) throws IllegalArgumentException{
        if(r <= 0){
            throw new IllegalArgumentException("radius of CIRCLE must be greater than 0");
        }
        radius = r;
    }
    
    public double getRadius(){
        return radius;
    }
    
    public double getArea(){
        return (PI * ( radius* radius));
    }
}
