/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Isaac
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Car myCar = new Car("Nissan", "Altima", 4);
        
        myCar.setSpeed(65); //intial speed of 65 MPH
        
        myCar.Accelerate();  //car accelerates additional 5 MPH
        myCar.Accelerate();
        
        System.out.println(myCar.toString());
        
        System.out.println("This is using getter : " + myCar.getSpeed() + "\n");
    }
    
}
