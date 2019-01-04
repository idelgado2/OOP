/*************************************************************************
 * Assignment_3(SHAPETESTER_TEST)
 * Isaac Delgado
 * COSC3324
 * 9/24/2016
 * Purpose: This class test the functionality of the classes Square, Cube
 *          and their subsequent children by creating an object of each shape
 *          and utilizing getName which is inherited by super class shape and
 *          getArea and getVolume for individual shapes.
 **************************************************************************/
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *
 * @author Isaac
 */
public class ShapeTester {
    
    public static void setEverything(Shape shape) throws InputMismatchException{
        Scanner reader = new Scanner(System.in);
        System.out.println("Please input properties of your " + shape.getName());
        
        if(shape instanceof Square || shape instanceof Cube){
            try{
                System.out.print("Side: ");
                ((Square) shape).setSide(reader.nextDouble());
            }catch(IllegalArgumentException | InputMismatchException e){
                System.out.println(e + "\nPlease try again, Error in Square\n");
                System.out.print("Side: ");
                ((Square) shape).setSide(reader.nextDouble());
            }
            
        }else if(shape instanceof Cylinder){
            try{
                System.out.print("radius: ");
                ((Circle) shape).setRadius(reader.nextDouble());
                System.out.print("Height: ");
                ((Cylinder) shape).setHeight(reader.nextDouble());
                
            }catch(IllegalArgumentException | InputMismatchException e){
                System.out.println(e + "\nPlease try again, Error in Cylinder\n");
                
                System.out.print("radius: ");
                ((Circle) shape).setRadius(reader.nextDouble());
                System.out.print("Height: ");
                ((Cylinder) shape).setHeight(reader.nextDouble());
            }
            
        }else if(shape instanceof Circle || shape instanceof Sphere || shape instanceof Glome){
            try{
                System.out.print("radius: ");
                ((Circle) shape).setRadius(reader.nextDouble());
            }catch(IllegalArgumentException | InputMismatchException e){
                System.out.println(e + "\nPlease try again, Error in Circle children of Circle\n");
                System.out.print("radius: ");
                ((Circle) shape).setRadius(reader.nextDouble());
            }
            
        }
        
    }
    
    public static void main(String [] args){
        /*
        Square s = new Square(5, "Square");
        Circle c = new Circle(2, "Circle");
        
        Cube cu = new Cube(5, "Cube");
        
        Cylinder cy = new Cylinder(5, 2, "Cylinder");
        Sphere sph = new Sphere(2, "Sphere");
        
        Glome gl = new Glome(2, "Glome");
        
        */  //replaced for adding try and catch block
        
        Square s = new Square();
        Circle c = new Circle();
        Cube cu = new Cube();
        
        Cylinder cy = new Cylinder();
        Sphere sph = new Sphere();
        
        Glome gl = new Glome();
        
            setEverything(s);
            setEverything(c);
            setEverything(cu);
            setEverything(cy);
            setEverything(sph);
            setEverything(gl);
        
        
        
        System.out.println("Shape: " + s.getName());
        System.out.println("Area: " + s.getArea() + "\n");
        
        System.out.println("Shape: " + c.getName());
        System.out.println("Area: " + c.getArea() + "\n");
        
        System.out.println("2D-Shape: " + cu.getName());
        System.out.println("Volume: " + cu.getVolume() + "\n");
        
        System.out.println("2D-Shape: " + cy.getName());
        System.out.println("Volume: " + cy.getVolume() + "\n");
        
        System.out.println("2D-Shape: " + sph.getName());
        System.out.println("Volume: " + sph.getVolume() + "\n");
        
        System.out.println("4D-Shape: " + gl.getName());
        System.out.println("Volume: " + gl.getVolume() + "\n");
    }
}
