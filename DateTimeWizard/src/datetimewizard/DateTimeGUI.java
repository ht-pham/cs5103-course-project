/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datetimewizard;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author huongpham
 */
public class DateTimeGUI {
    public JFrame frame;
    public Label currentTime; 
    public Label location;
    public Label question1;
    public Label dayCount1;
    public Label dayCount2;
    
    public DateTimeGUI(){
        //Create a container
        this.frame = new JFrame("Date Time Wizard");
        ImageIcon image = new ImageIcon("logo.png");
        
        
        //Create components
        this.location = new Label();
        this.location.setAlignment(Label.LEFT);
        this.location.setBounds(10,0,600,20);
        
        this.currentTime = new Label();
        this.currentTime.setAlignment(Label.LEFT);
        this.currentTime.setBounds(10,20,600,20);
        
        this.question1 = new Label("How can we help you?");
        this.currentTime.setAlignment(Label.LEFT);
        this.question1.setBounds(10, 40, 600, 20);
        
        this.dayCount1 = new Label();
        this.dayCount1.setAlignment(Label.LEFT);
        this.dayCount1.setBounds(10, 40, 600, 20);
        
        this.dayCount2 = new Label();
        this.dayCount2.setAlignment(Label.LEFT);
        this.dayCount2.setBounds(10, 60, 600, 20);
        //Add components
        frame.add(this.location);
        frame.add(this.currentTime);
        //frame.add(this.question1);
        frame.add(this.dayCount1);
        frame.add(this.dayCount2);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600);
        frame.setIconImage(image.getImage());
        frame.setResizable(true);
        
        frame.getContentPane().setBackground(new Color(179, 206, 229));
        frame.pack();
        frame.setVisible(true);
        
        
    }
    public static void main(String[] args) { 
        //Set a temporary Date-Time for testing the ability of conversing time of the program
        /*
        dtWizard.setDate(24,3,2022);
        dtWizard.setTime(11,59,1);
        LocalDateTime dueDate = LocalDateTime.of(dtWizard.date,dtWizard.time);
        
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
        useDST = TimeZone.getTimeZone(zdtNY.getZone()).inDaylightTime(new Date());
        System.out.println("It is "+useDST+" that "+dtWizard.zone+"is in Daylight Savings Time");
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
        useDST = TimeZone.getTimeZone(zdtLA.getZone()).inDaylightTime(new Date());
        System.out.println("It is "+useDST+" that "+dtWizard.zone+"is in Daylight Savings Time");
        System.out.println();
        */
        
        DateTimeWizard dtWizard = new DateTimeWizard();
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
            
            System.out.println("Current Time in "+dtWizard.zone.toString()+": \n"
                            +dtWizard.returnDateTime(userSelectedZone,userChoice));
            
            //Display the date time in pop-up window
            DateTimeGUI window = new DateTimeGUI();
            window.location.setText("Current Time in "+dtWizard.zone.toString()+":");
            window.currentTime.setText(dtWizard.returnDateTime(userSelectedZone,userChoice));
            
            boolean obsDST = dtWizard.timezone.useDaylightTime();
            boolean inDST = dtWizard.timezone.inDaylightTime(new Date());
            dtWizard.startDSTdate = LocalDate.of(2022, 3, 13);
            dtWizard.endDSTdate = LocalDate.of(2022, 11, 3);
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
                            window.dayCount1.setText("It has been "+days+" days since DST started");
                            days = dtWizard.endDSTdate.getDayOfYear()-now.getDayOfYear();
                            System.out.println("It is "+days+" days until DST ends");
                            window.dayCount2.setText("It is "+days+" days until DST ends");
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
