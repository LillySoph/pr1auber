package uebung04;

import static pr.MakeItSimple.*;

public class PalindromeLilly {

	static boolean isPalindrome2(int input) {

		// Fehlermeldung, falls eine negative Zahl eingeben wird
		if (input < 0)
			throw new PRException("Invalid input. ");

		// Größten Multiplikator ermitteln
		int multiplier = 1;
		while (multiplier < (input / 10)) {
			multiplier = multiplier * 10;
		}

		// Zahl umdrehen
		int reverseInput = 0;
		int compareInput = input;
		while (compareInput > 0) {
			int number = (compareInput - ((compareInput / 10) * 10)) * multiplier;
			reverseInput = reverseInput + number;
			compareInput = compareInput / 10;
			multiplier = multiplier / 10;
		}

		// Beispiel-Rechnung: input: 12345
		// (12345 - ((12345 / 10) * 10) * 10000 = 50000
		// (1234 - ((1234 / 10) * 10) * 1000 = 4000
		// (123 - ((123 / 10)* 10) * 100 = 300
		// (12 - ((12 / 10) * 10) * 10 = 20
		// (1 - ((1 / 10) * 10) * 1 = 1
		// 50000 + 4000 + 300 + 20 + 1 = 54321
		// 12345 und 54321 sind nicht gleich, daher false

		// eingegebene & umgedrehte Zahl vergleichen
		return (reverseInput == input);
	}

	static boolean isPalindrome(int input) {

		// Fehlermeldung, falls eine negative Zahl eingeben wird
		if (input < 0)
			throw new PRException("Invalid input. ");

		// Anzahl der Ziffern ermitteln
		int numberDigits = 0;
		int modInput = input;
		while (modInput > 0) {
			modInput = modInput / 10;
			numberDigits++;
		}
		// Größten Teiler ermitteln
		int divisor = 1;
		while (divisor < (input / 10)) {
			divisor = divisor * 10;
		}
		// Eingegebene Zahl umdrehen
		int multiplier = 1;
		int reverseInput = 0;
		int digit;
		modInput = input;
		while (numberDigits > 0) {
			digit = (modInput / divisor) * multiplier;
			reverseInput = reverseInput + digit;
			modInput = modInput - (digit / multiplier) * divisor;
			divisor = divisor / 10;
			multiplier = multiplier * 10;
			numberDigits--;
		}
		// eingegebene & umgedrehte Zahl vergleichen
		return (reverseInput == input);
	}

	public static void main(String[] args) {

		print("Please enter a whole number: ");
		int input = readInt();
		if (isPalindrome2(input))
			println("The number you entered is a Palindrome. ");
		else
			println("The number you entered is not a Palindrome. ");
	}
}
