package uebung04;

import static pr.MakeItSimple.*;

import pr.MakeItSimple.PRException;

public class Palindrome {

	static boolean isPalindrome(int number) {

		if (number < 0)
			throw new PRException("Invalid input: " + number);

		int modulo = 0;
		int reverse = 0;

		int compareNumber = number;

		while (compareNumber != 0) {
			modulo = compareNumber % 10;
			reverse = reverse * 10 + modulo;
			compareNumber = compareNumber / 10;
		}
		
		return (number == reverse);
	}

	public static void main(String[] args) {
		print("Please enter a number: ");
		int number = readInt();

		if (isPalindrome(number)) {
			println("It's a Palindrome.");
		} else
			println("It's not a Palindrome.");

	}
}
