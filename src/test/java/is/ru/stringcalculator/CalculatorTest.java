package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }
    @Test
    public void testUnknownNumberOf(){
    	assertEquals(20, Calculator.add("1,1,1,1,2,2,2,2,2,2,2,2"));
    }
    @Test
    public void testNewLine(){
    	assertEquals(3, Calculator.add("1/n2"));
    }
    @Test
    public void testDelimiter(){
    	assertEquals(6, Calculator.add("//;/n1;2;3"));
    }
    @Test
    public void testNegativeNumbers(){
    	assertEquals(4, Calculator.add("3,5,-3,3,-4"));
    }
    @Test
    public void testNumbersHigherThan1000(){
    	assertEquals(3, Calculator.add("1000,1,2,1043"));
    }

}