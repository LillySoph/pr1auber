package uebung06;

import static org.junit.Assert.*;

import org.junit.Test;

import pr.MakeItSimple.PRException;

public class SearchInRandomNumbers1stTest {

	@Test
	public void positiveArrayLength() {
		assertEquals(5, SearchInRandomNumbersExy.generate(5).length);
	}

	@Test(expected = PRException.class)
	public void negativeArrayLength() {
		SearchInRandomNumbersExy.generate(-1);
	}

	/*
	 * searchAll
	 */

	@Test
	public void searchAllEmptyArray() throws Exception {
		int[] numbers = new int[0];
		assertEquals(0, SearchInRandomNumbersExy.searchAll(numbers, 43).length);
	}

	@Test
	public void searchAllExistingTwice() throws Exception {
		int[] numbers = new int[] { 42, 42, 1 };
		int[] positions = SearchInRandomNumbersExy.searchAll(numbers, 42);
		assertEquals(2, positions.length);
		assertEquals(0, positions[0]);
		assertEquals(1, positions[1]);
	}

	/*
	 * searchLast
	 */

	@Test
	public void searchLastExistingTwice() throws Exception {
		int[] numbers = new int[] { 42, 42, 43 };
		assertEquals(1, SearchInRandomNumbersExy.searchLast(numbers, 42));
	}

	@Test(expected = PRException.class)
	public void searchLastNotContained() throws Exception {
		int[] numbers = new int[] { 1, 2, 3, 4, 5 };
		SearchInRandomNumbersExy.searchLast(numbers, 43);
	}

}