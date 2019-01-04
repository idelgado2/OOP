/*************************************************************************
 * Assignment_1(HEALTH)
 * Isaac Delgado
 * COSC3324
 * 9/9/2016
 * Purpose: This class implements a Health Profile which will ask personal
 *          informations and then will return your age, target heart rate zone,
 *          maximum heart rate, and body mass index(BMI).
 *
 * Attributes: Consist of first and last name, gender, birth date in month,
 *              day, and year, height(inches), and weight(lbs). 
 *             all attributes will be accompanied with setters and getters.
 *             3 additional methods will be added AGE, BMI, and
 *             MaxTargetHeartRate to calculate the user's age, BMI, and
 *             maximum and target heart rate.
 **************************************************************************/
package Health_Pkg;

import java.lang.IllegalArgumentException;


public class HealthProfile {
    private String firstName, lastName, gender;
    private int month, day, year;
    private int height, weight;
    private int MaximumHeartRate, TargetHeartRateLow, TargetHeartRateHigh;
    
    public HealthProfile()
    {
        firstName = null;
        lastName = null;
        gender = null;
        month = 0;
        day = 0;
        year = 0;
        height = 0;
        weight = 0;
    }

    public HealthProfile(String fName, String lName, String sex,
            int birthMonth, int birthDay, int birthYear, int height, int weight, int currentYear)
    {
        this.setFirstName(fName);
        this.setLastName(lName);
        this.setGender(sex);
        this.setBirthMonth(birthMonth);
        this.setBirthDay(birthDay);
        this.setBirthYear(birthYear, currentYear);
        this.setHeight(height);
        this.setWeight(weight);
    }
    
    public void setFirstName(String fName){
        firstName = fName;
    }
    public void setLastName(String lName){
        lastName = lName;
    }
    public void setGender(String sex){
        gender = sex;
    }
    public void setBirthMonth(int birthMonth) throws IllegalArgumentException{
        if(birthMonth < 1 || birthMonth > 12 ){
            throw new IllegalArgumentException("Month does not exist");
        }
        month = birthMonth;
    }
    public void setBirthDay(int birthDay) throws IllegalArgumentException{
        if(birthDay < 1 || birthDay > 31){
            throw new IllegalArgumentException("day does not exist");
        }
        day = birthDay;
    }
    public void setBirthYear(int birthYear, int currentYear) throws IllegalArgumentException{
        if(birthYear < 1866 || birthYear > currentYear){
            throw new IllegalArgumentException("Your must be dead or not alive just yet, please fix your birth Year");
        }
        year = birthYear;
    }
    public void setHeight(int height) throws IllegalArgumentException{
        if(height < 12 || height > 89){ //you cant be shorter than a foot or taller than 7'5"
            throw new IllegalArgumentException("PLease fix your height");
        }
        this.height = height;
    }
    public void setWeight(int weight) throws IllegalArgumentException{
        if(weight < 1 || weight > 500){
            throw new IllegalArgumentException("Unrealistic weight");
        }
        this.weight = weight;
    }
    
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getGender(){
        return gender;
    }
    public int getBirthMonth(){
        return month;
    }
    public int getBirthDay(){
        return day;
    }
    public int getBirthYear(){
        return year;
    }
    public int getHeight(){
        return height;
    }
    public int getWeight(){
        return weight;
    }
    
    public int Age(int currentMonth, int currentDay, int currentYear)
    /*Calculates the age useing today's date and users birth_date*/
    {
        int age = (currentYear) - year;
        if(month < currentMonth){
            return age;
        }else if(month > currentMonth){
            age--;
            return age;
        }else{ //month is equal to currentMonth
            if(day <= currentDay){
                return age;
            }
            else{
                age--;
                return age;
            }
        }
    }
    public double BMI(int wieght, int height)
    /*Calculates the BMI, height/weight*weight*/
    {
        double meterHeight = (double)height * 0.0254; //must convert inches to mneters
        double kilogramWeight = (double)weight * 0.453592; //must convert lbs to kilograms
        double bmi = kilogramWeight/(meterHeight * meterHeight); //formula for BMI
        
        return bmi;
    }
    public void MaxTargetHeartRate(int age)
    /*Calculates the Max and target heart rate*/
    {
        MaximumHeartRate = 220 - age; //formula for Max Heart Rate
        TargetHeartRateLow = (int)(MaximumHeartRate * 0.5); //50% of Max heart rate 
        TargetHeartRateHigh = (int)(MaximumHeartRate * 0.85); //85% of Max heart rate
    }
    public int getMaximumHeartRate(){
        return MaximumHeartRate;
    }
    public int getTargetHeartRateLower(){
        return TargetHeartRateLow;
    }
    public int getTargetHeartRateHigh(){
        return TargetHeartRateHigh;
    }
}
