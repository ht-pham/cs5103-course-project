# Major timelines of the project
  <i>Mar 4th, 2022</i><br>
  The project only has two options for time display and one option for date display. The DateTimeWizard class is built with basic attributes: 
  <ol>
    <li> String[] timeFormat = {"AM","PM","24HR"} for easy modification on time display & String timeDisplay is for the selected time format to be display with a default value as "24HR"; </li>
    <li> Integer variables for date,month,year,hour,min; </li>
    <li> private Calendar datetime //This attribute is for future use of default Java functions in Calendar class.</li>
    <li> private TimeZone timezone = TimeZone.getTimeZone("GMT-6:00"); //Similar to the previous attribute, it is for future usage & default timezone value is Central time</li>
  </ol>
  <i>Mar 9th, 2022</i>
  <p>The project is now enabled to change to a different time zone with newly added function setTimeZone(currentTimeZoneID,numberOfChangedHours,toTheEastSide) where currentTimeZoneID indicates current time zone, numberOfChangedHours means the number of different hours compared to the current time zone (e.g. Central Time Zone is 2 hours ahead from Pacific Time Zone), the boolean toTheEastSide helps the indication whether to increase or decrease the hour according to the East/West side related to the current location. This setTimeZone function is to change the time zone to a new one according to the new hour calculated via params numberOfChangedHours and toTheEastSide as well as the GMT+hour or GMT-hour.</p>
  <i>Mar 16th, 2022</i>
  <p>The date time display is now updated with 3 different options for date as well as 3 options for time (hour:min). This means, the program has 6 variations of date time display.</p>
  <ol>
    <li> MM/DD/YYYY HH'H':MM'M' GMT-??:00 &emsp;OR&emsp; MM/DD/YYYY HH:MM AM/PM GMT-??:00</li>
    <li> DD/MM/YYYY HH'H':MM'M' GMT-??:00 &emsp;OR&emsp; DD/MM/YYYY HH:MM AM/PM GMT-??:00</li>
    <li> MonthName Day'th/st/nd/rd', Year HH'H':MM'M' GMT-??:00  &emsp;OR&emsp; MonthName Day'th/st/nd/rd', Year HH:MM AM/PM GMT-??:00</li>
  </ol>

  <i>Mar 17th, 2022</i>
  <div>Changed the approach to converse the date time to different time zones from using manual self-built mathematical approach to using the built-in java class ZonedDateTime with its built-in function ZonedDateTime.withZoneSameInstant(), which directly creates an instant copy of the current date time at the selected region and returns the date and time reflected at the newly selected region. There are 2 reasons for this major change: (1) it makes codes to be less complicated and more accurate; (2) ZonedDateTime supports more general ZoneId names (e.g. "America/Chicago", "Japan", "China", etc.) instead of "UTC" or "GMT-6", which is an advanced point when general region names is acceptable/workable for TimeZone.useDaylightTime(ZoneId) while GMT/UTC will always return 'false' for checking if the region uses DST. </div>
  <div>This major change in date time conversion approach caused changes in 4 other functions: setTimeZone() (be less complicated), getStringMonth() & getFormalDay() (now receive ZonedDateTime object as a param), and returnDateTime() (be more complicated with the ZonedDateTime object as param1 for date time input and integer displayOption as param2 for output's display options. Also, the DateTimeWizard class now has 2 new attributes: LocalDate date, LocalTime time to ease of separate uses/calls for each part of info: date and time as well as serve the creation(s) of ZonedDateTime object(s).</div>
  <div>The project still has two options for time display and one option for date display. The DateTimeWizard class is built with basic attributes: 
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
 </div>

