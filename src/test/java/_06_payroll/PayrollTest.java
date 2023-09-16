package _06_payroll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PayrollTest {

    Payroll payroll = new Payroll();

    @Test
    void itShouldCalculatePaycheck() {
    	Double hourlyWage = 15.0;
    	int numHours = 8;
    	int expected = 120;
    	
        //when
    	Double actual = payroll.calculatePaycheck(hourlyWage, numHours);
        //then
    	assertEquals(expected, actual);
    }

    @Test
    void itShouldCalculateMileageReimbursement() {
        //given
    	Double centsPerMile = .575;
    	int mileage = 100;
    	Double expected = 57.5;
    	
        //when
    	double actual = payroll.calculateMileageReimbursement(mileage);

        //then
    	assertEquals(expected, actual);
    }

    @Test
    void itShouldCreateOfferLetter() {
    	String employeeName = "John";
    	Double hourlyWage = 15.5;
 
        //given
    	String expected = "Hello " + employeeName + ", We are pleased to offer you an hourly wage of " + hourlyWage;
    	
    	String actual = payroll.createOfferLetter("John", 15.5);
    	
        //when
    	assertEquals(expected, actual);
        //then
    }

}