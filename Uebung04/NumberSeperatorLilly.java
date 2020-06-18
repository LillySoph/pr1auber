package uebung04;

import static pr.MakeItSimple.*;

public class NumberSeperatorLilly {

	static String splitNumber2(int input) {

		// Für den Fall, dass 0 eingegeben wird
		String zero = "+,0";
		if (input == 0)
			return zero;

		// Vorzeichen ermitteln
		String sign = "";
		if (input >= 0) {
			sign = "+";
		} else {
			sign = "-";
			// Wenn die Zahl negativ ist, wird Input positiv gemacht
			input = input * (-1);
		}

		// Zahl von hinten nach vorne auseinander nehmen
		String result = "";
		while (input > 0) {
			int number = input - ((input / 10) * 10);
			result = "," + number + result;
			input = input / 10;
		}

		result = sign + result;
		return result;

	}

	static String splitNumber(int input) {

		// Für den Fall, dass 0 eingegeben wird
		String zero = "+,0";
		if (input == 0)
			return zero;

		// Vorzeichen ermitteln
		String sign = "";
		if (input >= 0) {
			sign = "+";
		} else {
			sign = "-";
			// Wenn die Zahl negativ ist, wird Input positiv gemacht
			input = input * (-1);
		}

		// Anzahl der Ziffern ermitteln
		int numberDigits = 0;
		int modInput = input;
		while (modInput > 0) {
			modInput = modInput / 10;
			numberDigits++;
		}

		// Eingegebene Zahl aufteilen
		int divisor = 1;
		modInput = input;
		String result = sign;
		while (numberDigits > 0) {

			// Teiler ermitteln
			while (divisor <= modInput / 10)
				divisor = divisor * 10;

			// Einzelne Ziffern ermitteln und zum String result hinzufügen
			while (divisor > 0) {
				int number = input / divisor;
				input = input - (number * divisor);
				numberDigits--;
				result = result + "," + number;
				divisor = divisor / 10;
			}
		}
		return result;
	}

	public static void main(String[] args) {

		print("Please enter a whole number: ");
		int input = readInt();
		println(splitNumber2(input));
	}

}
