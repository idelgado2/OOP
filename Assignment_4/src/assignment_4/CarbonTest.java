/*************************************************************************
 * Assignment_4(CARBON_TEST)
 * Isaac Delgado
 * COSC3324
 * 10/7/2016
 * Purpose: This class polymorphically implements the getCarbonFootprint 
 *          method in the interface CarbonFootprint that is implemented by
 *          the Classes Building, Car, and Bicycle by using an ArrayList
 **************************************************************************/

package assignment_4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Isaac
 */
public class CarbonTest {
    
    public static void setEverything(int fueltype, Object obj) throws InputMismatchException{
        Scanner reader = new Scanner(System.in);
        
        if(obj instanceof Building){
            
            try{
                System.out.println("*** Enter properties for your Building ***");
                
                System.out.print("Fuel Type (type 1 - 3): ");
                ((Building) obj).setFuel_type(reader.nextInt());
                
                System.out.print("kwh_usage: ");
                ((Building) obj).setKwh_usage(reader.nextInt());

                
            }catch(IllegalArgumentException e){
                System.out.println(e + "Please try again\n");
                System.out.println("*** Enter properties for your Building ***");
                
                System.out.print("Fuel Type (type 1 - 3): ");
                ((Building) obj).setFuel_type(reader.nextInt());
                
                System.out.print("kwh_usage: ");
                ((Building) obj).setKwh_usage(reader.nextInt());
            }

        }else if(obj instanceof Car){
            
            try{
                System.out.println("*** Enter properties for your Car ***");
                System.out.print("Fuel Type (type 1 - 3): ");
                ((Car) obj).setFuel_type(reader.nextInt());
            
                System.out.print("Distance Driven: ");
                ((Car) obj).setDistance_Drivin(reader.nextInt());
                
            }catch(IllegalArgumentException e){
                System.out.println(e + "Please try again\n");
                
                System.out.println("*** Enter properties for your Car ***");
                System.out.print("Fuel Type (type 1 - 3): ");
                ((Car) obj).setFuel_type(reader.nextInt());
            
                System.out.print("Distance Driven: ");
                ((Car) obj).setDistance_Drivin(reader.nextInt());
            }  
            
        }else if(obj instanceof Bicycle){
            
            try{
                System.out.println("*** Enter properties for your Bicycle ***");
                System.out.print("Distance: ");
                ((Bicycle) obj).setDistance_Biked(reader.nextInt());
                
            }catch(IllegalArgumentException e){
                System.out.println(e + "Please try again\n");
                
                System.out.println("*** Enter properties for your Bicycle ***");
                System.out.print("Distance: ");
            ((Bicycle) obj).setDistance_Biked(reader.nextInt());
            }
            
        }
        
        
    }
    
    public static void main(String [] args){
        
        ArrayList<CarbonFootprint> list = new ArrayList<CarbonFootprint>();
        
        int fuelType = 0;
        
        /*Building elec_Building = new Building(15000, 1); //run by electricity
        Building gas_Building = new Building(10000, 2);  //run by natural gas
        Building oil_Building = new Building(17500, 3);  //run by heating oil
        
        Car gas_Car = new Car(10000, 1);      //run by gasoline
        Car hybrid_Car = new Car(13500, 2);   //run by electricity and gas
        Car electric_Car = new Car(17000, 3); //run by electricity
        
        Bicycle bike = new Bicycle(10000); //Biked 10,000 miles
        */
        
        Building building = new Building();
        Car car = new Car();
        Bicycle bike = new Bicycle();
        
        
        try{
            setEverything(fuelType, building);
        }catch(InputMismatchException e){
            System.out.println(e + "Please try again\n");
            setEverything(fuelType, building);
        }
        
        try{
            setEverything(fuelType, car);
        }catch(InputMismatchException e){
            System.out.println(e + "Please try again\n");
            setEverything(fuelType, car);
        }
        
        try{
            setEverything(fuelType, bike);
        }catch( InputMismatchException e){
            System.out.println(e + "Please try again\n");
            setEverything(fuelType, bike);
        }
        //*adding objects to arraylist*//
        //list.add(elec_Building);       //
        //list.add(gas_Building);        //
        //list.add(oil_Building);        //
        //list.add(gas_Car);             //
        //list.add(hybrid_Car);          //
        //list.add(electric_Car);        //
        //list.add(bike);                //
        /////////////////////////////////
        
        list.add(building);
        list.add(car);
        list.add(bike);
        
        System.out.println("Annual Carbon Footprint");
        System.out.println("-----------------------\n");
        
        for(int i = 0; i < list.size(); i++){ //polymorphically implement interface fuction 
            System.out.println(list.get(i).getCarbonFootprint());
        }
        
        System.out.println("-----------------------");
        System.out.println("****It must be noted that many variables are "
                + "un-accounted for*********** ");
                System.out.println("****(e.g type of Gasoline in Car or "
                + "what has been eaten for a biker)****");
    }
    
}
