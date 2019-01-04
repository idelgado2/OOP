/*************************************************************************
 * Assignment_3(CYLINDER)
 * Isaac Delgado
 * COSC3324
 * 9/24/2016
 * Purpose: The purpose of this class is to create an object of Cylinder and
 *          inherits from super class Circle, Shape, and implements 
 *          interface Volume.
 *
 * Attributes: Consist of a constructor that invokes parent constructor
 *             and inherited method getVolume
 **************************************************************************/

import java.lang.IllegalArgumentException;


/**
 *
 * @author Isaac
 */
public class Cylinder extends Circle implements Volume {
    private double height;
    
    Cylinder(){
        super();
        super.setName("Cylinder");
        height = 0;
    }
    
    Cylinder(double h, double r, String n){
        super(r, n); //calling Circle constructor
        this.setHeight(h);
    }
    
    public void setHeight(double h)throws IllegalArgumentException{
        if(h <= 0){
            throw new IllegalArgumentException("radius of CIRCLE must be greater than 0");
        }
        height = h;
    }
    
    public double getVolume(){
        return height * super.getArea();
        //area of base(circle) * hiehgt
    }
}
