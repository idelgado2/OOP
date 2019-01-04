/*************************************************************************
 * Assignment_4(BICYCLE)
 * Isaac Delgado
 * COSC3324
 * 10/7/2016
 * Purpose: Calculates Carbon Footprint of a biker who travels a certain 
 *          amount of miles using the method provided by the interface
 *          CarbonFootprint.
 *
 * Attributes: Consist of CO2/perMile for miles biked, distance of biked
 *              be recorded under distance_biked.
 **************************************************************************/

package assignment_4;
import java.lang.IllegalArgumentException;
/**
 *
 * @author Isaac
 */
public class Bicycle implements CarbonFootprint{
    
    /*kilogram of CO2 per mile*/////////////////
    final private double BICYCLING_CO2 = 0.04;//
    ////////////////////////////////////////////
    
    final private int BICYCLING_AVER = 15000; //MILES per year
    
    private int distance_Biked; //MILES this year 
    private double totalCarbonEmission;
    
    Bicycle(){
        distance_Biked = BICYCLING_AVER;
    }
    
    Bicycle(int distance){
        distance_Biked = distance;
    }

    @Override //overides method in implemented interface
    public String getCarbonFootprint() {
        /*kilogram of CO2 per MILE biked*/
        totalCarbonEmission = (distance_Biked * BICYCLING_CO2); 
        return "Biking for a distance of " + distance_Biked + " ===> " + 
                            (int)totalCarbonEmission + " kg of CO2 emitted";
    }
    
    /*Setters and Getters for Values*///////////////////////////////////////////
    public void setDistance_Biked(int distance) throws IllegalArgumentException{
        if(distance < 0){
            throw new IllegalArgumentException("Distance for BIKE cannot be negative\n");
        }
        distance_Biked = distance;
    }
    public int getDistance_Biked(){
        return distance_Biked;
    }
    
    public double getTotalCarbonEmission(){
        return totalCarbonEmission;
    }
    ////////////////////////////////////////////////////////////////////////////
}
