/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package datetimewizard;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author huongpham
 */
public class DateTimeWizardTest {
    
    public DateTimeWizardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("* JUnit4Test: @BeforeClass method");
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("* JUnit4Test: @AfterClass method");
    }

    /**
     * Test of setDate method, of class DateTimeWizard.
     */
    @Test
    public void testSetDate() {
        System.out.println("JUnit4 Testing setDate() method");
        int day = 1;
        int month = 1;
        int year = 2022;
        DateTimeWizard instance = new DateTimeWizard();
        instance.setDate(day, month, year);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        
    }

    /**
     * Test of setTime method, of class DateTimeWizard.
     */
    @Test
    public void testSetTime() {
        System.out.println("setTime");
        int hour = 0;
        int minute = 0;
        int formatID = 0;
        DateTimeWizard instance = new DateTimeWizard();
        instance.setTime(hour, minute, formatID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTimeZone method, of class DateTimeWizard.
     */
    @Test
    public void testSetTimeZone() {
        System.out.println("setTimeZone");
        ZoneId zone = null;
        DateTimeWizard instance = new DateTimeWizard();
        instance.setTimeZone(zone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStringMonth method, of class DateTimeWizard.
     */
    @Test
    public void testGetStringMonth() {
        System.out.println("JUnit4 Testing getStringMonth() method");
        
        int monthParam = 0;
        DateTimeWizard instance = new DateTimeWizard();
        String expResult = "Invalid month";
        String result = instance.getStringMonth(monthParam);
        
        assertEquals(expResult, result);
        assertEquals("November",instance.getStringMonth(11));
        assertEquals("January",instance.getStringMonth(1));
        assertEquals("May",instance.getStringMonth(5));
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFormalDay method, of class DateTimeWizard.
     */
    @Test
    public void testGetFormalDay() {
        System.out.println("JUnit4 Testing getFormalDay() method");
        int dayParam = 0;
        DateTimeWizard instance = new DateTimeWizard();
        String expResult = "Invalid Day";
        String result = instance.getFormalDay(dayParam);
        
        assertEquals(expResult, result);
        assertEquals("31st",instance.getFormalDay(31));
        assertEquals("3rd",instance.getFormalDay(3));
        assertEquals("22nd",instance.getFormalDay(22));
 
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnDateTime method, of class DateTimeWizard.
     */
    @Test
    public void testReturnDateTime() {
        System.out.println("JUnit4 testing: returnDateTime() method");
        DateTimeWizard instance = new DateTimeWizard();
        int displayOption = 2;
        instance.setTimeZone(TimeZone.getTimeZone("America/Chicago").toZoneId());
        instance.date = LocalDate.now();
        
        ZonedDateTime localDate = null;
        String expResult = "No date found";
        String result = instance.returnDateTime(localDate, displayOption);
        assertEquals(expResult, result);
        
        
        
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class DateTimeWizard.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        DateTimeWizard instance = new DateTimeWizard();
        LocalDate expResult = null;
        LocalDate result = instance.getDate();
        assertEquals(expResult, result);
        
        expResult = LocalDate.now();
        instance.setDate(expResult.getDayOfMonth(), expResult.getMonthValue(),expResult.getYear());
        
        assertEquals(LocalDate.now(),instance.getDate());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    

    /**
     * Test of getTime method, of class DateTimeWizard.
     */
    @Test
    public void testGetTime() {
        System.out.println("getTime");
        ZonedDateTime localDate = null;
        DateTimeWizard instance = new DateTimeWizard();
        Integer[] expResult = null;
        Integer[] result = instance.getTime(localDate);
        assertArrayEquals(expResult, result);
        assertArrayEquals(new Integer[]{11,28}, instance.getTime(ZonedDateTime.of(LocalDate.of(2022,5,8), LocalTime.of(11, 28), instance.zone)));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDayOfWeek method, of class DateTimeWizard.
     */
    @Test
    public void testGetDayOfWeek() {
        System.out.println("getDayOfWeek");
        ZonedDateTime localDate = null;
        DateTimeWizard instance = new DateTimeWizard();
        DayOfWeek expResult = null;
        DayOfWeek result = instance.getDayOfWeek(localDate);
        assertEquals(expResult, result);
        assertEquals("sunday",instance.getDayOfWeek(ZonedDateTime.of(LocalDate.of(2022,5,8), LocalTime.of(12, 0), instance.zone)));
        assertEquals("wednesday",instance.getDayOfWeek(ZonedDateTime.of(LocalDate.of(2022,3,9), LocalTime.of(12, 10), instance.zone)));
        assertEquals("monday",instance.getDayOfWeek(ZonedDateTime.of(LocalDate.of(2022,5,30), LocalTime.of(12, 0), instance.zone)));         
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClockTime method, of class DateTimeWizard.
     */
    @Test
    public void testGetClockTime() {
        System.out.println("getClockTime");
        Integer[] timeClock = null;
        DateTimeWizard instance = new DateTimeWizard();
        String expResult = "";
        String result = instance.getClockTime(timeClock);
        
        assertEquals(expResult, result);
        assertEquals("10:55",instance.getClockTime(new Integer[]{10,55}));
        assertEquals("3:45",instance.getClockTime(new Integer[]{3,45}));
        assertEquals("19:20",instance.getClockTime(new Integer[]{19,20}));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    /**
     * Test of main method, of class DateTimeWizard.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        DateTimeWizard.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDSTdates method, of class DateTimeWizard.
     */
    @Test
    public void testSetDSTdates() {
        System.out.println("setDSTdates");
        LocalDate startDt = null;
        LocalDate endDt = null;
        DateTimeWizard instance = new DateTimeWizard();
        instance.setDSTdates(startDt, endDt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimeZone method, of class DateTimeWizard.
     */
    @Test
    public void testGetTimeZone() {
        System.out.println("getTimeZone");
        DateTimeWizard instance = new DateTimeWizard();
        String expResult = "America/Chicago";
        String result = instance.getTimeZone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDSTdates method, of class DateTimeWizard.
     */
    @Test
    public void testGetDSTdates() {
        System.out.println("getDSTdates");
        DateTimeWizard instance = new DateTimeWizard();
        LocalDate[] expResult = null;
        LocalDate[] result = instance.getDSTdates();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
