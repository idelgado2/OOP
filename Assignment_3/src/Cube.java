/*************************************************************************
 * Assignment_3(CUBE)
 * Isaac Delgado
 * COSC3324
 * 9/24/2016
 * Purpose: The purpose of this class is to create an object of Cubes and
 *          inherits from super class Square, Shape, and implements 
 *          interface Volume.
 *
 * Attributes: Consist of a constructor that invokes parent constructor
 *             and inherited method getVolume
 **************************************************************************/

/**
 *
 * @author Isaac
 */
public class Cube extends Square implements Volume {
    Cube(){ 
        super();
        super.setName("Cube");
    }
    
    Cube(double s, String n){
        super(s, n); //calling parent constructor
    }
    
    @Override
    public double getVolume(){
        return super.getArea() * super.getSide();
    }
}
