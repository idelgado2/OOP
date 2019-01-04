/*************************************************************************
 * Assignment_3(GLOME)
 * Isaac Delgado
 * COSC3324
 * 9/24/2016
 * Purpose: The purpose of this class is to create an object of Glome and
 *          inherits from super class Circle, Sphere, Shape, and implements 
 *          interface Volume.
 *
 * Attributes: Consist of a constructor that invokes parent constructor
 *             and inherited method getVolume
 **************************************************************************/

/**
 *
 * @author Isaac
 */
public class Glome extends Sphere implements Volume {
    
    Glome(){
        super();
        super.setName("Glome");
    }
    
    Glome(double r, String n){
       super(r,n);
    }
    
    @Override
    public double getVolume(){
        return (2 * super.PI * super.getRadius() * super.getArea());
        //2*P^2*r^3 
    }
}
