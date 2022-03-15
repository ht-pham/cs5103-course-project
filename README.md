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
  The initial requirement is to transform it to any different time zone. The secondary requirement is to enable/disable Daylight Time Savings for all regions with an assumption that all regions start and end Daylight Time Savings. 
  <br>
</div>

<div>
  <b>Timeline/Logs of the project</b>
  <br>Mar 4th, 2022<br>
  The DateTimeWizard class is built with basic attributes: 
  <ol>
<li> String[] timeFormat = {"AM","PM","24HR"} for easy modification on time display & String timeDisplay is for the selected time format to be display with a default value as "24HR"; </li>
<li> Integer variables for date,month,year,hour,min; </li>
<li> private Calendar datetime //This attribute is for future use of default Java functions in Calendar class.</li>
<li> private TimeZone timezone = TimeZone.getTimeZone("GMT-6:00"); //Similar to the previous attribute, it is for future usage & default timezone value is Central time</li>
  </ol>
The main class temporarily display the midterm check point date only. 
</div>
