/*************************************************************************
 * Assignment_3(SPHERE)
 * Isaac Delgado
 * COSC3324
 * 9/24/2016
 * Purpose: The purpose of this class is to create an object of Sphere and
 *          inherits from super class Circle, Shape, and implements 
 *          interface Volume.
 *
 * Attributes: Consist of a constructor that invokes parent constructor
 *             and inherited method getVolume
 **************************************************************************/

/**
 *
 * @author Isaac
 */
public class Sphere extends Circle implements Volume{
    
    Sphere(){
        super();
        super.setName("Sphere");
    }
    
    Sphere(double r, String n){
        super(r, n);
    }
    
    public double getVolume(){
        return (4/3)* super.getRadius() * super.getArea();
        //(4/3)*PI*radius^3
    }
}
