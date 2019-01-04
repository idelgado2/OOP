/*************************************************************************
 * Assignment_1(EMPLOYEE)
 * Isaac Delgado
 * COSC3324
 * 9/9/2016
 * Purpose: This class implements two objects of Employee class and utilises
 *          both set and getter functionality.
 *
 * 
 **************************************************************************/
package Employee_Pkg;

import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *
 * @author Isaac
 */
public class EmployeeTest {
    
    public static void setEverything(Employee employee) throws InputMismatchException{
        
        Scanner scanner = new Scanner(System.in); //for input from user
        
        System.out.println("First Name: ");
            employee.setFirstName(scanner.nextLine());
            
        System.out.println("Last Name: ");
            employee.setLastName(scanner.nextLine());
            
        System.out.println("Salary: ");
            employee.setMonthlySalary(scanner.nextDouble());
    }
    
    public static void main(String args[]){
        //Employee Dwight = new Employee("Dwight", "Schrute", 5000);
        //Employee Micheal = new Employee("Micheal", "Scote", 6000);
        
        Employee Dwight = new Employee();
        Employee Micheal = new Employee();
        
        
        try{
            
            System.out.println("Please input First & Last, as well as Salaray for FIRST Employee");
            setEverything(Dwight);
            
            System.out.println("Please input First & Last, as well as Salaray for SECOND Employee");
            setEverything(Dwight);
            
        }catch(InputMismatchException | IllegalArgumentException e){
            
            System.out.println(e);
            System.out.println("Try again, Error occured!!\n");
            
            System.out.println("Please input First & Last, as well as Salaray for FIRST Employee");
            setEverything(Dwight);
            
            System.out.println("Please input First & Last, as well as Salaray for SECOND Employee");
            setEverything(Dwight);
            
        }
    
        System.out.println(Dwight.getFirstName() +" "+Dwight.getLastName() +
                    " --> monthly salary: " + Dwight.getMonthlySalary());
        
        System.out.println(Micheal.getFirstName() +" "+Micheal.getLastName() +
                    " --> monthly salary: " + Micheal.getMonthlySalary() + "\n");
        
        /*Apply a 10% increase on salary of both employees(objects)*/
        Dwight.setMonthlySalary(Dwight.getMonthlySalary() +
                                                (Dwight.getMonthlySalary() * 0.1));
        Micheal.setMonthlySalary(Micheal.getMonthlySalary() + 
                                                (Micheal.getMonthlySalary() * 0.1));
        
        System.out.println(Dwight.getFirstName() +" "+Dwight.getLastName() +
                    " --> monthly salary WITH 10% RAISE: " + 
                                                Dwight.getMonthlySalary());
        
        System.out.println(Micheal.getFirstName() +" "+Micheal.getLastName() +
                    " --> monthly salary WITH 10% RAISE: " + 
                                            Micheal.getMonthlySalary());
    }

}
