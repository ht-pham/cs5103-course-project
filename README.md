# CS5103 Course Project: Software Engineering Practice

<div>
  <b>Overview</b>
  <br> 
  This is a programming project for the graduate-level course CS5103 Software Engineering @UTSA. The project is written in Java language. 
</div>

<div>
  <b>Goal of the project</b>
  <br>
  The goal of this project is to transform the given date time string to different formats.     
</div>

<!---
  1. Requirement Engineering: Write user stories and test cases of the program you are writing.
  2. Design: Adapt your software design based on new requirements posted later.
  3. Implementation: Implement your code based on version control system and make changes to implementation based on new requirements.
  4. Testing: Write unit tests for your classes.
  5. Tool Application: Apply code clone detection, static bug detection on your code base and report results.
--->

<div>
  <b>Requirements</b>
  <br>
  The initial requirement is to transform it to any different time zone. The secondary requirement is to add Daytime light Savings' start date and end date for all regions with an assumption that all regions start and end Daylight Time Savings. 
  <br>
</div>

<div>
  <b>Major timelines of the project</b>
  <br><i>Mar 4th, 2022</i><br>
  The project only have two options for time display and one option for date display. The DateTimeWizard class is built with basic attributes: 
  <ol>
    <li> String[] timeFormat = {"AM","PM","24HR"} for easy modification on time display & String timeDisplay is for the selected time format to be display with a default value as "24HR"; </li>
    <li> Integer variables for date,month,year,hour,min; </li>
    <li> private Calendar datetime //This attribute is for future use of default Java functions in Calendar class.</li>
    <li> private TimeZone timezone = TimeZone.getTimeZone("GMT-6:00"); //Similar to the previous attribute, it is for future usage & default timezone value is Central time</li>
  </ol>
  <i>Mar 16th, 2022</i>
  <p>The date time display is now updated with 3 different options for date as well as 3 options for time (hour:min). This means, the program has 6 variations of date time display.</p>
  <ol>
    <li> MM/DD/YYYY HH'H':MM'M' GMT-??:00 &emsp;OR&emsp; MM/DD/YYYY HH:MM AM/PM GMT-??:00</li>
    <li> DD/MM/YYYY HH'H':MM'M' GMT-??:00 &emsp;OR&emsp; DD/MM/YYYY HH:MM AM/PM GMT-??:00</li>
    <li> MonthName Day'th/st/nd/rd', Year HH'H':MM'M' GMT-??:00  &emsp;OR&emsp; MonthName Day'th/st/nd/rd', Year HH:MM AM/PM GMT-??:00</li>
  </ol>
</div>
