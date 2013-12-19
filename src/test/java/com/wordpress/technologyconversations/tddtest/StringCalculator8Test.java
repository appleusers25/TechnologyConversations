package com.wordpress.technologyconversations.tddtest;

import junit.framework.Assert;

import org.junit.Test;

import com.wordpress.technologyconversations.tdd.StringCalculator8;

public class StringCalculator8Test {
	
	@Test
	public final void whenEmptyStringIsUsedThenReturnValueIs0() {
		Assert.assertEquals(0, StringCalculator8.add(""));
	}
	
	@Test
	public final void whenOneNumberIsUsedThenReturnValueIsThatSameNumber() {
		Assert.assertEquals(3, StringCalculator8.add("3"));
	}

	@Test
	public final void whenTwoNumbersAreUsedThenReturnValueIsTheirSum() {
		Assert.assertEquals(3+6, StringCalculator8.add("3,6"));
	}
	
	@Test
	public final void whenAnyNumberOfNumbersIsUsedThenReturnValuesAreTheirSums() {
		Assert.assertEquals(3+6+15+18+46+33, StringCalculator8.add("3,6,15,18,46,33"));
	}

	@Test
	public final void whenNewLineIsUsedBetweenNumbersThenReturnValuesAreTheirSums() {
		Assert.assertEquals(3+6+15, StringCalculator8.add("3,6\n,15"));
	}

	@Test(expected = RuntimeException.class)
	public final void whenOneOfNumbersIsEmptyStringThenExceptionIsThrown() {
		StringCalculator8.add("3,\n,15");
	}

	@Test
	public final void whenDelimitedIsSpecifiedThenItIsUsedToSeparateNumbers() {
		Assert.assertEquals(3+6+15, StringCalculator8.add("//;\n3;6;15"));
	}
	
	@Test(expected = RuntimeException.class)
	public final void whenNegativeNumberIsUsedThenRuntimeExceptionIsThrown() {
		StringCalculator8.add("3,-6,15,18,46,33");
	}

	@Test
	public final void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown() {
		RuntimeException exception = null;
		try {
			StringCalculator8.add("3,-6,15,-18,46,33");
		} catch (RuntimeException e) {
			exception = e;
		}
		Assert.assertNotNull(exception);
		Assert.assertEquals("Negatives not allowed: [-6, -18]", exception.getMessage());
	}

}