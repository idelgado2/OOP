/*************************************************************************
 * Assignment_4(BULDING)
 * Isaac Delgado
 * COSC3324
 * 10/7/2016
 * Purpose: Calculates Carbon Footprint of a building using different 
 *          types of fuel using the method provided by the interface
 *          CarbonFootprint.
 *
 * Attributes: Consist of CO2/perkWH for amount of kWH used this year,
 *              kWH used this year will be recorded under kwh_usage
 **************************************************************************/

package assignment_4;
import java.lang.IllegalArgumentException;
/**
 *
 * @author Isaac
 */
public class Building implements CarbonFootprint{
    /*kWh = kiloWatts and hour*/
  //kilogram of CO2 per kWH for each fuel type//////// /*options for switch case*/
    final private double ELECTRICITY = 0.23;        // option 1
    final private double NATURAL_GAS = 0.198;       // option 2
    final private double HEATING_OIL = 0.198;       // option 3
  //////////////////////////////////////////////////// 
    
    final private int AVERAGE_ANNUAL_KWH = 10000; //default value if not provided
    
    private int kwh_usage;
    private double fuel_type, totalCarbonEmission;
    private String fuel_string;
    
    Building(){
        kwh_usage = AVERAGE_ANNUAL_KWH;
        fuel_type = ELECTRICITY; //most homes are run by full electricity;
        fuel_string = "ELECTRICITY";
    }
    
    Building(int kwh_usage, int fuel_type){
        
        this.kwh_usage = kwh_usage;
        switch(fuel_type){
            case 1:
                this.fuel_type = ELECTRICITY;
                fuel_string = "ELECTRICITY";
                break;
            case 2:
                this.fuel_type = NATURAL_GAS;
                fuel_string = "NATURAL_GAS";
                break;
            case 3:
                this.fuel_type = HEATING_OIL;
                fuel_string = "HEATING_OIL";
                break;
            default:
                this.fuel_type = ELECTRICITY;
                fuel_string = "ELECTRICITY";
                break;
        } 
        
    }

    @Override //overides method in implemented interface
    public String getCarbonFootprint() {
        /*kilogram of CO2 per kWH for specific fuel type equals CO2 emmisions*/
        totalCarbonEmission = (kwh_usage * fuel_type); 
        return "Building fueled by " + fuel_string + " ===> " + 
                            (int)totalCarbonEmission + " kg of CO2 emitted";
    }
    
    /*Setters and Getters for Values*///////////////////////////////////////////
    public void setKwh_usage(int kWH) throws IllegalArgumentException{
        if(kWH < 0){
            throw new IllegalArgumentException("kWH cannot be negative\n");
        }
            kwh_usage = kWH;
    }
    public int getKwh_usage(){
        return kwh_usage;
    }
    
    public void setFuel_type(int fuel_type ) throws IllegalArgumentException{
        switch(fuel_type){
            case 1:
                this.fuel_type = ELECTRICITY;
                fuel_string = "ELECTRICITY";
                break;
            case 2:
                this.fuel_type = NATURAL_GAS;
                fuel_string = "NATURAL_GAS";
                break;
            case 3:
                this.fuel_type = HEATING_OIL;
                fuel_string = "HEATING_OIL";
                break;
            default:
                throw new IllegalArgumentException("You must choose a Fuel type 1, 2, or 3");
                //this.fuel_type = ELECTRICITY;
                //fuel_string = "ELECTRICITY";
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
