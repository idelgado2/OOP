/*************************************************************************
 * Assignment_4(CAR)
 * Isaac Delgado
 * COSC3324
 * 10/7/2016
 * Purpose: Calculates Carbon Footprint of a Car fueled by different types
 *          of fuel using the method provided by the interface
 *          CarbonFootprint.
 *
 * Attributes: Consist of CO2/perMile for Gas, Hybrid, and Electric Car which
 *             will be recored in fuel_type and fuel_string. The amount of 
 *              miles will be recored in distance_Drivin. 
 **************************************************************************/

package assignment_4;
import java.lang.IllegalArgumentException;
/**
 *
 * @author Isaac
 */
public class Car implements CarbonFootprint{
    
  //kilogram of CO2 per MILE for each fuel type//////// /*options for switch case*/
    final private double GASOLINE_CAR = 0.41;  //////// //option 1
    final private double HYBRID_CAR = 0.14;    //////// //option 2
    final private double ELECTRICAL_CAR = 0.18;//////// //option 2
  /////////////////////////////////////////////////////
    
    final private int AVER_DRIVING_DISTANCE = 15000; //MILES per year
    
    private int distance_Drivin; //MILES this year
    private double fuel_type, totalCarbonEmission;
    private String fuel_string;
    
    Car(){
        distance_Drivin = AVER_DRIVING_DISTANCE;
        fuel_type = GASOLINE_CAR; //most homes are run by full electricity;
        fuel_string = "GASOLINE";
    }
    
    Car(int distance, int fuel_type){
        distance_Drivin = distance;
        switch(fuel_type){
            case 1:
                this.fuel_type = GASOLINE_CAR;
                fuel_string = "GASOLINE";
                break;
            case 2:
                this.fuel_type = HYBRID_CAR;
                fuel_string = "HYBRID";
                break;
            case 3:
                this.fuel_type = ELECTRICAL_CAR;
                fuel_string = "ELECTRICAL";
                break;
            default:
                this.fuel_type = GASOLINE_CAR;
                fuel_string = "GASOLINE";
                break;
        } 
    }

    @Override //overides method in implemented interface
    public String getCarbonFootprint() {
        /*kilogram of CO2 per MILE for specific fuel type equals CO2 emmisions*/
        totalCarbonEmission = (distance_Drivin * fuel_type); 
        return fuel_string + " run Car  ================> " + 
                    (int)totalCarbonEmission + " kg of CO2 emitted";
    }
    
    /*Setters and Getters for Values*///////////////////////////////////////////
    public void setDistance_Drivin(int distance)throws IllegalArgumentException{
        if(distance < 0){
            throw new IllegalArgumentException("Distance drivin cannot be negative");
        }
        distance_Drivin = distance;
    }
    public int getDistance_Drivin(){
        return distance_Drivin;
    }
    
    public void setFuel_type(int fuel_type )throws IllegalArgumentException{
        switch(fuel_type){
            case 1:
                this.fuel_type = GASOLINE_CAR;
                fuel_string = "GASOLINE";
                break;
            case 2:
                this.fuel_type = HYBRID_CAR;
                fuel_string = "HYBRID";
                break;
            case 3:
                this.fuel_type = ELECTRICAL_CAR;
                fuel_string = "ELECTRICAL";
                break;
            default:
                throw new IllegalArgumentException("You must choose a fuel type 1, 2, or 3");
                //this.fuel_type = GASOLINE_CAR;
                //fuel_string = "GASOLINE";
                //break;
        } 
    }
    public double getFuel_type(){
        return fuel_type;
    }
    
    public void setFuel_string(String fuelName){
        fuel_string = fuelName;
    }
    public String getFuel_string(){
        return fuel_string;
    }
    
    public double getTotalCarbonEmission(){
        return totalCarbonEmission;
    }
    ////////////////////////////////////////////////////////////////////////////
    
}
