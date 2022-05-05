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
    public int day,month,year,hour,min;
    public final String[] timeFormat = {"AM","PM","24HR"};
    public String timeDisplay = timeFormat[2]; 
    
    public TimeZone timezone = TimeZone.getTimeZone("America/Chicago");//default
    public ZoneId zone= timezone.toZoneId();
    
    public LocalDate date;
    public LocalTime time;
    
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
        /*This step is to save user preference on time displays: AM/PM or 24H
        if ((formatID<3)&&(formatID>=0)){
            this.timeDisplay = this.timeFormat[formatID];
        }*/
        
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
        
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        String weekDay = dayOfWeek.toString().toLowerCase();
        
        Integer hourVal = localDate.getHour();
        Integer minVal = localDate.getMinute();
        
        String hourDisplay;
        if(hourVal<10){
            hourDisplay = "0"+minVal.toString();
        }else{
            hourDisplay = minVal.toString();
        }
        String minDisplay;
        if(minVal<10){
            minDisplay = "0"+minVal.toString();
        }else{
            minDisplay = minVal.toString();
        }
     
        String timeString = hourDisplay+":"+minDisplay;
        
        String zoneID = this.zone.toString();
        Integer monthVal = localDate.getMonthValue();
        Integer dayVal = localDate.getDayOfMonth();
        Integer yearVal = localDate.getYear();
        
        String defaultOp = dateString+" "+weekDay+" "+timeString+" in "+zoneID;                   
        String optionOne = monthVal+"/"+dayVal+"/"+yearVal+" "+weekDay;
        String optionTwo = dayVal+"/"+monthVal+"/"+yearVal+" "+weekDay;
        
        String monthString = this.getStringMonth(monthVal);
        String dayString = this.getFormalDay(dayVal);
        String yearString = Integer.toString(this.year);
        String optionThree = monthString+" "+dayString+","+yearString+" "+weekDay;
        
        String hourMin;
        if(this.timeDisplay.matches(timeFormat[2])){
            hourMin = timeString;
        }else if(this.timeDisplay.matches(timeFormat[1])&&(hourVal>=12)){
            hourMin = (hourVal-12)+":"+minDisplay+this.timeDisplay+" in "+zoneID;     
        }else{
            hourMin = hourVal+":"+minDisplay+"AM in "+zoneID;
        }
        
        
        String displayString;
        switch(displayOption){
            case 1:
                displayString = optionOne+" at "+hourMin;
                break;
            case 2:
                displayString = optionTwo+" at "+hourMin;
                break;
            case 3:
                displayString = optionThree+" at "+hourMin;
                break;
            default:
                displayString = defaultOp;
                break;
        }
        
        return displayString;  
    }
    /*@param args the command line arguments*/
     
    public static void main(String[] args) {
        
        DateTimeWizard dtWizard = new DateTimeWizard();
        
        //Set a temporary Date-Time for testing the ability of conversing time of the program
        /*
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
        */
        Scanner userinput = new Scanner(System.in);
        boolean exit = false;
        while(!exit){
            System.out.println("Select one of the number to change to a new timezone if applicable:\n"
                    + "(1) New York \n(2) Denver \n(3) Los Angeles \n(4) Chicago\n");
            
            Integer userChoice = userinput.nextInt();
            String newZone="America/Chicago";
            switch(userChoice){
                    case 1:
                        newZone = "America/New_York";
                        break;
                    case 2:
                        newZone = "America/Denver";
                        break;
                    case 3:
                        newZone = "America/Los_Angeles";
                        break;
                    case 4:
                        newZone = "America/Chicago";
                        break;
                    default:
                        System.out.println("No zone was selected.");
                        System.out.println("Default zone is Chicago time.");
                        break;
            }
            //Ask the user on their preferences on date time display
            System.out.println("Select a display setting for date:\n"
                    + "(1) MM/DD/YYYY \n(2) DD/MM/YYYY \n"
                    + "(3) Month Day, Year (e.g. January 1st,2022)\n"
                    + "(4) Default: YYYY-MM-DD");
            userChoice = userinput.nextInt();
            System.out.println("Select a display setting for time:\n"
                    + "(1) AM/PM \n(2) 24HR \n");
            
            Integer timeChoice = userinput.nextInt();
            switch(timeChoice){
                    case 1:
                        dtWizard.timeDisplay = dtWizard.timeFormat[timeChoice];
                        break;
                    case 2:
                        dtWizard.timeDisplay = dtWizard.timeFormat[timeChoice];
                        break;
                    default:
                        System.out.println("No time display setting was selected.");
                        System.out.println("Default choice is 24HR.");
                        break;
            }
           
            //this is to use the current time in the [expected] local CST time zone 
            LocalDateTime now = LocalDateTime.now();
            ZonedDateTime local = ZonedDateTime.of(now,ZoneId.of("America/Chicago"));
            dtWizard.setDate(now.getDayOfMonth(),now.getMonthValue(),now.getYear());
            dtWizard.setTime(now.getHour(),now.getMinute(),2);
            
            //This is to convert the current time in local to the preferred time zone selected by the user
            dtWizard.setTimeZone(TimeZone.getTimeZone(newZone).toZoneId());
            ZonedDateTime userSelectedZone = local.withZoneSameInstant(ZoneId.of(newZone));
            
            System.out.println("Current Time at "+dtWizard.zone.toString()+": \n"
                            +dtWizard.returnDateTime(userSelectedZone,userChoice));
            
            boolean obsDST = dtWizard.timezone.useDaylightTime();
            boolean inDST = dtWizard.timezone.inDaylightTime(new Date());
            dtWizard.startDSTdate = LocalDate.of(2022, 3, 13);
            dtWizard.endDSTdate = LocalDate.of(2022, 11, 6);
            Integer days;
            
            
            System.out.println("How can we help you here?\n"
                    + "(1) Check out the time at another zone\n"
                    + "(2) Check if the current time zone is in DST\n"
                    + "(3) How many days until DST starts/ends\n"
                    + "(4) Exit"
            );
            userChoice = userinput.nextInt();
            
            switch(userChoice){
                    case 1:
                        break;
                    case 2:
                        System.out.println("It is "+obsDST+" that "+dtWizard.zone
                                +" use Daylight Savings Time");
                        System.out.println("It is "+inDST+" that "
                                +dtWizard.zone+" in Daylight Savings Time");
                        break;
                    case 3:
                        boolean passed = now.toLocalDate().isAfter(dtWizard.startDSTdate);
                        if(passed&&obsDST){
                            days = now.getDayOfYear()-dtWizard.startDSTdate.getDayOfYear();
                            System.out.println("It has been "+days+" days since DST started");
                            days = dtWizard.endDSTdate.getDayOfYear()-now.getDayOfYear();
                            System.out.println("It is "+days+" days until DST ends");
                        }else{
                            System.out.println("It may be false that "+dtWizard.zone
                                +" use Daylight Savings Time or the");
                        }
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("No choice was selected.");
                        System.out.println("Default choice is 1.");
                        break;
            }
        }
        
    }
}
