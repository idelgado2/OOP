/*************************************************************************
 * Assignment_3(SHAPE)
 * Isaac Delgado
 * COSC3324
 * 9/24/2016
 * Purpose: The purpose of this Abstract class is to create provide a 
 *          String name, method getName(), and , method setName() to child
 *          classes.
 **************************************************************************/

/**
 *
 * @author Isaac
 */
public abstract class Shape {
    private String name;
    
    Shape(){
    }
    public void setName(String shapeName){
        name = shapeName;
    }
    public String getName(){
        return name;
    }
}
