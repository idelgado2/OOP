/*************************************************************************
 * Assignment_1(HEALTH)
 * Isaac Delgado
 * COSC3324
 * 9/9/2016
 * Purpose: This class implements the functionality of HealthProfile class
 *          with and added method called format to format BMI to 1 decimal
 *          places.
 **************************************************************************/
package Health_Pkg;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Calendar;
import java.util.InputMismatchException;


public class HealthProfileTest {
    
    public static String format(double doubleValue)
    /*method for formating BMI value to 1 decimal places*/
    {
        DecimalFormat df = new DecimalFormat("#.##"); 
        String formatted = df.format(doubleValue);
        return formatted;
    }
    
    public static void displayBMIchart()
        /*method for displaying BMI value*/
    {
        double initial = 15;
        System.out.println("***BMI value Chart***\n");
        System.out.println("BMI\t" + "\tCategory");
        System.out.println(0 +" - "+ 15 + " ----> Very severely underweight");
        System.out.println(15 +" - "+ 16 + " ----> Severly underweight");
        System.out.println(16 +" - "+ 18.5 + " ----> Underweight");
        System.out.println(18.5 +" - "+ 25 + " ----> Normal (healthy weight)");
        System.out.println(25 +" - "+ 30 + " ----> Overweight");
        System.out.println(30 +" - "+ 35 + " ----> Obese Class I (Moderately obese)");
        System.out.println(35 +" - "+ 40 + " ----> Obese Class II (Severely obese)");
        System.out.println(40 +" - 40+" + " ----> Obese Class III (Very severely obese)");

    }
    
    public static void setEverything(HealthProfile Pam, int currentYear) throws InputMismatchException{
        
        Scanner reader = new Scanner(System.in);
        System.out.print("First Name: ");
        Pam.setFirstName(reader.nextLine());
        
        System.out.print("Last Name: ");
        Pam.setLastName(reader.nextLine());
        
        System.out.print("Gender: ");
        Pam.setGender(reader.nextLine());
                
        System.out.print("Height(in): ");
        Pam.setHeight(reader.nextInt());
        
        System.out.print("weight(lbs): ");
        Pam.setWeight(reader.nextInt());
        
        System.out.println("**Birthdate**");
        System.out.print("Month: ");
        Pam.setBirthMonth(reader.nextInt());
        
        System.out.print("Day: ");
        Pam.setBirthDay(reader.nextInt());
        
        System.out.print("Year: ");
        Pam.setBirthYear(reader.nextInt(), currentYear);
    }
    
    public static void main(String[] args){
        String firstName, lastName;
        String gender = null;
        int month, day, year, height, weight, age; 
        double bmi;
        
        //get current date for calculating age
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        
        System.out.println("Welcome to your Health profile, let's get started!\n"
                + "please provide the following information\n");
        
        HealthProfile Pam = new HealthProfile();
        
        try{
            setEverything(Pam, currentYear);
        }catch(InputMismatchException | IllegalArgumentException e){
            System.out.println(e);
            System.out.println("Please try again");
            setEverything(Pam, currentYear);
        }

        
        //HealthProfile Pam = new HealthProfile(firstName, lastName, gender, 
        //        month, day, year, height, weight, currentYear);
        
        age = Pam.Age(currentMonth, currentDay, currentYear); //calculate age
        
        Pam.MaxTargetHeartRate(age);//clalculate max and target heart rates
        
        bmi = Pam.BMI(Pam.getWeight(), Pam.getHeight()); //calculate BMI
        
        System.out.println("\n**Basic information**");
        System.out.println("First Name: " + Pam.getFirstName());
        System.out.println("Gender: " + Pam.getGender());
        System.out.println("Age: " + age);
        System.out.println("Target Heart Rate: " + Pam.getTargetHeartRateLower()
                                + "-" + Pam.getTargetHeartRateHigh()
                                    + " beats per minute");
        System.out.println("Maximum Heart Rate: " + Pam.getMaximumHeartRate()
                                 + " beats per minute");
        System.out.printf("Body Mass Index(BMI): " 
                                + format(bmi) + "\n\n");
        
        displayBMIchart();
        
    }
}
