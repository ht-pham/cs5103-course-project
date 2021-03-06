# CS5103 Course Project: Software Engineering Practice
### Overview
<div>
  This is a programming project for the graduate-level course CS5103 Software Engineering @UTSA. The project is written in Java language. 
</div>

### Goal of the project
<div>
  The goal of this project is to transform the given date time string to different formats.     
</div>

<!---
  1. Requirement Engineering: Write user stories and test cases of the program you are writing.
  2. Design: Adapt your software design based on new requirements posted later.
  3. Implementation: Implement your code based on version control system and make changes to implementation based on new requirements.
  4. Testing: Write unit tests for your classes.
  5. Tool Application: Apply code clone detection, static bug detection on your code base and report results.
--->
### System Requirement
  Need to have JDK8 or JDK11 installed on the laptop
  #### How to run
  
  In terminal, run following commands: 
  ```
  cd localpath
  javac DateTimeWizard.java
  java DateTimeWizard
  ```
  In any IDE, just hit run button<br>
  
### Requirements

  The initial requirement is to transform it to any different time zone. The secondary requirement is to add Daytime light Savings' start date and end date for all regions with an assumption that all regions start and end Daylight Time Savings. The third requirement is to have Day of Week (Sunday, Monday, Tuesday, etc.) shown on the output.
  <br>

<div>
  <b>Architecture</b>
  <br>
  The project has two options for time display and one option for date display. The DateTimeWizard class is built with basic attributes: 
  <ol>
    <li> Integer variables for date,month,year,hour,min; They are crucial for most of setX() & getX() functions as well as creating LocalDate,LocalTime, and LocalDateTime objects</li>
    <li> String[] timeFormat = {"AM","PM","24HR"} used a mediator to ensure user input for hour:min to be understood correctly </li>
    <li> String timeDisplay is for the selected time format to be display with a default value as "24HR" </li>
    <li> private TimeZone timezone = TimeZone.getTimeZone("GMT-6:00"); //Similar to the previous attribute, it is for future usage & default timezone value is Central time</li>
    <li> private ZoneId zone</li>
    <li> private LocalDate date</li>
    <li> private LocalTime time</li>
    <li> private LocalDate startDSTdate</li>
    <li> private LocalDate endDSTdate</li>
  </ol>
  
  The DateTimeWizard class is built with basic behaviors: 
  <ol>
    <li> Setters: setDate() -> void, setTime() -> void, setTimeZone() -> void: to change the current time zone to another one</li>
    <li> Getters: getStringMonth() -> String, getFormalDay() -> String, getDate() -> LocalDate, getTime() -> Integer[], getClockTime() ->String, getDayOfWeek() -> DayOfWeek </li>
    <li> Others: returnDateTime() -> String: to return date & time in a timezone </li>
  </ol>
  <b>How the system was built to make requirements</b>
  <ol>
    <li> Requirement 1 - Change the timezone: setTimeZone(ZoneId zone) was built to change the current timezone to new one by the param 'zone'. Updated on May 8th: new method getTimeZone() to return TimeZone info</li>
    <li> Requirement 2 - Add DST info: DateTimeWizard has two new attributes: startDST and endDST of LocalDate => performed in main function. Updated on May 8th: setDSTdates() is added to set up the records for DST info & getDSTDates() to return start & end date of DST.</li>
    <li> Requirement 3 - Display Day of Week: new method called getDayOfWeek(ZonedDateTime localDate)</li>
  </ol>
</div>

### Testing
<ul>
    <li> Console: User interacts/tests in the command prompts by following steps and the current date time will be displayed. If interested more, user can continue selecting 4 options: (1) Check time in another time zone, (2) Check if the current zone uses DST, (3) Dates after DST starts and until DST ends, (4) Exit</li>
    <li> Unit Testing: find in test folder the test class - DateTimeWizardTest.java. The unit tests are run for all getter functions and returnDateTime() function</li>
</ul>
