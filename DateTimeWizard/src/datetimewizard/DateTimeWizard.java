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
    private int day,month,year,hour,min;
    private final String[] timeFormat = {"AM","PM","24HR"};
    private String timeDisplay = timeFormat[2]; 
    
    private TimeZone timezone = TimeZone.getTimeZone("America/Chicago");//default
    private ZoneId zone= timezone.toZoneId();
    
    private LocalDate date;
    private LocalTime time;
    
    //Stuct
    public DateTimeWizard(){
        TimeZone.setDefault(this.timezone);      
    }
    
    public void setDate(int day, int month, int year){
        this.date = LocalDate.of(year, month, day);
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public void setTime(int hour,int minute,int formatID){
        //This step is to save user preference on time displays: AM/PM or 24H
        if ((formatID<3)&&(formatID>=0)){
            this.timeDisplay = this.timeFormat[formatID];
        }
        
        //This step is to ensure we understand correctly user input for time
        if(this.timeFormat[formatID].matches("PM")){
            this.hour = hour+12;
        }else{
            this.hour = hour;
        }
        this.min = minute;
        /*This step is to create a LocalTime object which only understands daily
        hour ranging from 00:00 to 23:59 */
        this.time = LocalTime.of(this.hour, this.min);
        
    }
    //This function is to change the current time zone to a new one
    public void setTimeZone(ZoneId zone){
        this.zone = zone;
        this.timezone = TimeZone.getTimeZone(zone);
    }
    
    public String getStringMonth(int monthParam){
        String monthString;
        
        switch (monthParam) {
            case 1:  monthString = "January";
                     break;
            case 2:  monthString = "February";
                     break;
            case 3:  monthString = "March";
                     break;
            case 4:  monthString = "April";
                     break;
            case 5:  monthString = "May";
                     break;
            case 6:  monthString = "June";
                     break;
            case 7:  monthString = "July";
                     break;
            case 8:  monthString = "August";
                     break;
            case 9:  monthString = "September";
                     break;
            case 10: monthString = "October";
                     break;
            case 11: monthString = "November";
                     break;
            case 12: monthString = "December";
                     break;
            default: monthString = "Invalid month";
                     break;
        }
        
        return monthString;
    }
    
    public String getFormalDay(int dayParam){
        String dateNumber = Integer.toString(dayParam);
        switch (dayParam) {
            case 1: case 21: case 31:
                dateNumber = dateNumber.concat("st");
                break;
            case 2: case 22:
                dateNumber = dateNumber.concat("nd");
                break;
            case 3: case 23:
                dateNumber = dateNumber.concat("st");
                break;
            default: 
                dateNumber = dateNumber.concat("th");
                break;
        }
        return dateNumber;
    }
    
    public String returnDate(ZonedDateTime localDate, int displayOption){
        String dateString = localDate.toLocalDate().toString();
        String timeString = localDate.toLocalTime().toString();
        String zoneID = localDate.getZone().getId();
        Integer monthVal = localDate.getMonthValue();
        Integer dayVal = localDate.getDayOfMonth();
        Integer yearVal = localDate.getYear();
        
        String defaultOp = dateString+" "+timeString+" "+zoneID+" Time Zone";                   
        String optionOne = monthVal+"/"+dayVal+"/"+yearVal;
        String optionTwo = dayVal+"/"+monthVal+"/"+yearVal;
        
        String monthString = this.getStringMonth(monthVal);
        String dayString = this.getFormalDay(dayVal);
        String yearString = Integer.toString(this.year);
        String optionThree = monthString+" "+dayString+","+yearString;
        
        String hourMin;
        Integer hourVal = localDate.getHour();
        Integer minVal = localDate.getMinute();
        
        if(this.timeDisplay.matches(timeFormat[2])){
            hourMin = timeString;
        }else if(this.timeDisplay.matches(timeFormat[1])&&(hourVal>=12)){
            hourMin = (hourVal-12)+":"+minVal+this.timeDisplay+" "+zoneID;     
        }else{
            hourMin = hourVal+":"+minVal+"AM"+" "+zoneID;
        }
        
        String displayString;
        switch(displayOption){
            case 1:
                displayString = optionOne+" "+hourMin+" Time Zone";
                break;
            case 2:
                displayString = optionTwo+" "+hourMin+" Time Zone";
                break;
            case 3:
                displayString = optionThree+" "+hourMin+" Time Zone";
                break;
            default:
                displayString = defaultOp;
                break;
        }
        
        return displayString;  
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DateTimeWizard dtWizard = new DateTimeWizard();
        
        //Set a temporary Date-Time for testing the ability of conversing time of the program
        dtWizard.setDate(24,3,2022);
        dtWizard.setTime(11,59,1);
        LocalDateTime dueDate = LocalDateTime.of(dtWizard.date,dtWizard.time);
        
        //The date-time at the default time zone (Central Time Zone)
        ZonedDateTime zdtChicago = ZonedDateTime.of(dueDate, dtWizard.zone);
        System.out.println("Midterm checkpoint date: \n"
                            +dtWizard.returnDateTime(zdtChicago,-1));
        //check if the region use DST
        boolean useDST = dtWizard.timezone.useDaylightTime();
        System.out.println("It is "+useDST+" that "+dtWizard.zone+" use Daylight Savings Time");
        
        System.out.println();
        
        // The corresponding Date-Time in New York/Eastern Time Zone
        ZonedDateTime zdtNY = zdtChicago.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(dtWizard.returnDateTime(zdtNY,3));
        //check if the region use DST
        dtWizard.setTimeZone(zdtNY.getZone());
        useDST = TimeZone.getTimeZone(zdtNY.getZone()).observesDaylightTime();
        System.out.println("It is "+useDST+" that "+dtWizard.zone+" use Daylight Savings Time");
        System.out.println();
        
        //The corresponding Date-Time in Mountain Time Zome
        ZonedDateTime zdtAZ = zdtChicago.withZoneSameInstant(ZoneId.of("America/Denver"));
        System.out.println(dtWizard.returnDateTime(zdtAZ,1));
        //check if the region use DST
        dtWizard.setTimeZone(zdtAZ.getZone());
        useDST = TimeZone.getTimeZone(zdtAZ.getZone()).observesDaylightTime();
        System.out.println("It is "+useDST+" that "+dtWizard.zone+" use Daylight Savings Time");
        System.out.println();
        
        //The corresponding Date-Time in Pacific Time Zone
        ZonedDateTime zdtLA = zdtChicago.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));
        System.out.println(dtWizard.returnDateTime(zdtLA,2));
        //check if the region use DST
        dtWizard.setTimeZone(zdtLA.getZone());
        useDST = TimeZone.getTimeZone(zdtLA.getZone()).observesDaylightTime();
        System.out.println("It is "+useDST+" that "+dtWizard.zone+" use Daylight Savings Time");
        System.out.println();
        
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
