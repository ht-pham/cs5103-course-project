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

  The initial requirement is to transform it to any different time zone. The secondary requirement is to add Daytime light Savings' start date and end date for all regions with an assumption that all regions start and end Daylight Time Savings. 
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
  </ol>
</div>
