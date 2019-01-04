/*************************************************************************
 * Assignment_1(EMPLOYEE)
 * Isaac Delgado
 * COSC3324
 * 9/9/2016
 * Purpose: This class implements an employee profile.
 *
 * Attributes: Consist of first and last name of employee with the monthly 
 *              salary, as well as basic setters and getters. 
 **************************************************************************/
package Employee_Pkg;

import java.lang.IllegalArgumentException;
/**
 *
 * @author Isaac
 */
public class Employee {
    private String firstName;
    private String lastName;
    private double monthlySalary;
    
    public Employee(){
        firstName = "";
        lastName = "";
        monthlySalary = 1;
    }
    
    public Employee(String fName, String lName, double salary){
        firstName = fName;
        lastName = lName;
        monthlySalary = salary;
    }
    
    public void setFirstName(String fName){
        firstName = fName;
    }
    public String getFirstName(){
        return firstName;
    }
    
    public void setLastName(String lName){
        lastName = lName;
    }
    public String getLastName(){
        return lastName;
    }
    
    public void setMonthlySalary(double salary) throws IllegalArgumentException{
        if(salary > 0){
            monthlySalary = salary;            
        }else{
            throw new IllegalArgumentException("salary cannot be negative or zero");
        }
    }
    public double getMonthlySalary(){
        return monthlySalary;
    }
}
