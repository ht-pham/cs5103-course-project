/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package datetimewizard;
import java.util.*;

import java.time.*;
import java.util.Scanner;
/**
 *
 * @author huongpham
 */
public class DateTimeWizard {
    private final String[] timeFormat = {"AM","PM","24HR"};
    private String timeDisplay = timeFormat[2];
    private int date,month,year,hour,min;
    private Calendar datetime;
    private TimeZone timezone = TimeZone.getTimeZone("GMT-6");//default
    //Stuct
    public DateTimeWizard(){
        //the current date at the default timezone
        this.datetime = Calendar.getInstance(timezone);
        
    }
    
    public void setDate(int day, int month, int year){
        this.datetime.set(year, month, day);
        this.date = day;
        this.month = month;
        this.year = year;
    }
    
    public void setTime(int hour,int minute,int formatID){
        this.hour = hour;
        this.min = minute;
        if ((formatID<3)&&(formatID>=0)){
            this.timeDisplay = timeFormat[formatID];
        }
    }
    //This function is to change the current time zone to a new one
    public void setTimeZone(TimeZone currentTimeZone,int change,boolean toEast){
        String TimeZoneID = currentTimeZone.getID();
        String zone = TimeZoneID.substring(4,6);
        
        int newZone = Integer.parseInt(zone);
        
        int newHour;
        if(toEast==true){
            newHour = newZone-change;
        }else{
            newHour = newZone+change;
        }
        String newZoneHour = String.valueOf(newHour);
        TimeZoneID=TimeZoneID.replace(zone, newZoneHour);
        
        this.timezone = TimeZone.getTimeZone(TimeZoneID);
    }
    
    public String returnDate(){
        String defaultDateFormat = this.month+"/"+this.date+"/"+this.year;
        String defaultTimeFormat ;
        if (this.timeDisplay.matches(timeFormat[2])){
            defaultTimeFormat = this.hour+"H"+this.min+"M";
        }else{    
            defaultTimeFormat = this.hour+":"+this.min+" "+this.timeDisplay;
        }
            
        return defaultDateFormat+" "+defaultTimeFormat;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /** The following block of code is to show default examples of three different types of hour display
        ** will come back to clean this block of code **
        **/
        DateTimeWizard dueDate = new DateTimeWizard();
        dueDate.setDate(17,3,2022);
        dueDate.setTime(11,59,1);
        System.out.println("Midterm checkpoint date: "+dueDate.returnDate()
                            +" "+dueDate.timezone.getDisplayName());
        
        //Convert the deadline as on Pacific Time Zone
        dueDate.setTimeZone(dueDate.timezone,2,false);
        System.out.println("New timezone: "+dueDate.timezone.getDisplayName());
        dueDate.setTime(21,59,2);
        System.out.println("Midterm checkpoint date: "+dueDate.returnDate()
                            +" "+dueDate.timezone.getDisplayName());

        //Convert the deadline as on Eastern Time Zone
        dueDate.setTimeZone(dueDate.timezone,3,true);
        System.out.println("New timezone: "+dueDate.timezone.getDisplayName());
        dueDate.setDate(18,3,2022);
        dueDate.setTime(0,59,0);
        System.out.println("Midterm checkpoint date: "+dueDate.returnDate()
                            +" "+dueDate.timezone.getDisplayName());
        
        
        //This is for user input when the project is run in terminal
        //Command: java $PATH/DateTimeWizard.java [Date] [HourAM/PM/24H] [TimeZone]
        //Current expected result: User's orignal input 
        if (args.length>0){
            for (String s: args) {
                System.out.print(s+" ");
            }
        }
    }
}
