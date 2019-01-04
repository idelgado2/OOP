/*************************************************************************
 * Assignment_1(TIME)
 * Isaac Delgado
 * COSC3324
 * 9/9/2016
 * Purpose: This class implements functionality of the Time class using object 
 *          clock and setter methods as well as showing exception handling.
 **************************************************************************/
package Time_Pkg;

import java.util.Scanner;
import java.util.InputMismatchException;



public class TimeTest {
    
    public static void setEverything(Time clock) throws InputMismatchException{
       Scanner scanner = new Scanner(System.in);
       
       System.out.println("Hours: ");
       clock.setHours(scanner.nextInt());
       
       System.out.println("Minutes: ");
       clock.setMinutes(scanner.nextInt());
       
       System.out.println("Seconds: ");
       clock.setSeconds(scanner.nextInt());
    }
    
    public static void main(String [] args){
       Time clock = new Time(5, 45, 32);
       clock.displayTime();
       
       System.out.println("You can now reset the clock to your desired time\n");
       
       try{
       setEverything(clock);
       
       }catch(IllegalArgumentException | InputMismatchException e){
                //if one of the values in out of bounds print error message
           System.out.println("Error: " + e + "\n");
           System.out.println("Please try again");
           setEverything(clock);
       }
       
       clock.displayTime(); //display time after setting new values
    }
}
