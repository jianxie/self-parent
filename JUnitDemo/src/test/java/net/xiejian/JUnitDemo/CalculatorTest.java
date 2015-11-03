package net.xiejian.JUnitDemo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testEvaluate() {
		Calculator calculator = new Calculator();
		int sum = calculator.evaluate("1+2+3+4");
		assertEquals(10, sum);
	}

}
