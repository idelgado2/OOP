/*************************************************************************
 * Assignment_1(TIME)
 * Isaac Delgado
 * COSC3324
 * 9/9/2016
 * Purpose: This class implements an Time class that will display a time in 
 *          a hours:minutes:seconds formate.
 *
 * Attributes: Consist of hours, minutes, and seconds with the 
 *             as well as basic setters and getters and display method for
 *              displaying the time. 
 **************************************************************************/
package Time_Pkg;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;
    
    public Time(int hr, int min, int sec){
        hours = hr;
        minutes = min;
        seconds = sec;
    }
    
    public void setHours(int hr){
        if(hr <= 24 && hr >= 1){
            hours = hr;
        }else{ //throw exception in case input is out of range
            throw new IllegalArgumentException("Hours/Minutes/Seconds is out of acceptable range");
        }
    }
    public int getHours(){
        return hours;
    }
    
    public void setMinutes(int min){
        if(min <= 59 && min >= 0){
            minutes = min;
        }else{//throw exception in case input is out of range
            throw new IllegalArgumentException("Hours/Minutes/Seconds is out of acceptable range");
        }
    }
    public int getMinutes(){
        return minutes;
    }
    
    public void setSeconds(int sec){
        if(sec <= 59 && sec >= 0){
            seconds = sec;
        }else{//throw exception in case input is out of range
            throw new IllegalArgumentException("Hours/Minutes/Seconds is out of acceptable range");
        }
    }
    public int getSeconds(){
        return seconds;
    }
    
    public void displayTime(){ //displays the Time in user foramt
        System.out.println(hours + ":" + minutes + ":" + seconds + "\n");
    }
}
