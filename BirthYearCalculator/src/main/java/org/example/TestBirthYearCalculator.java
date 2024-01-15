package org.example;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import java.util.Calendar;

public class TestBirthYearCalculator {
    @Test
    public void TestBirthYearWhenPassValidAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        YearCalculator testCalculator = new YearCalculator();
        int result = testCalculator.calculateBirthYear(currentYear, "40");
        assertEquals(currentYear-40, result);
    }

    @Test
    public void TestBirthYearWhenPassNegativeAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        YearCalculator testCalculator = new YearCalculator();
        int result = testCalculator.calculateBirthYear(currentYear, "-40");
        assertEquals(-1, result);
    }

    @Test
    public void TestPrintGreetings() {
        YearCalculator testCalculator = new YearCalculator();
        String result = testCalculator.printGreetings("Dipti", 1983);
        assertEquals("Hi Dipti, Your were born in 1983.", result);
    }

    @Test
    public void TestPrintGreetingsWithEmptyName() {
        YearCalculator testCalculator = new YearCalculator();
        String result = testCalculator.printGreetings("", 1983);
        assertEquals("name is required", result);
    }

    @Test
    public void TestBirthYearWhenPassAgeGreaterThenCurrentYear() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        YearCalculator testCalculator = new YearCalculator();
        int result = testCalculator.calculateBirthYear(currentYear, "5000");
        assertEquals(-1, result);
    }
@Test
    public void TestBirthYearWhenPassStringAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        YearCalculator testCalculator = new YearCalculator();
        int result = testCalculator.calculateBirthYear(currentYear, "abc");
        assertEquals(-1, result);

    }
    @Test
    public void TestPrintGreetingsInvalidLengthOfName() {
        YearCalculator testCalculator = new YearCalculator();
        String result = testCalculator.printGreetings("Hi im Dipti .I am going to show a very big name, which contains more then 200 charecters and will show you a massage .Hi i am Dipti .I am going to show a very big name, which contains more then 200 charecters and will show you  a massage ", 1983);
        assertEquals("It is too long", result);
    }

}




