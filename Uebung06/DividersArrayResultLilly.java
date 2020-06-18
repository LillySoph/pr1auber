package uebung06;

import static pr.MakeItSimple.*;

// Aufgabe 2

public class DividersArrayResultLilly {

	static int[] calculateDividers(int input) {

		int[] dividers = new int[500];
		int index = 0;
		int divider = 0;
		// Teiler hochzählen
		while (divider <= input) {
			divider++;
			// Wenn es Teiler der Zahl ist, in Array speichern & Index hochzählen
			if (input % divider == 0) {
				dividers[index] = divider;
				index++;
			}
		}
		return dividers;
	}

	public static void main(String[] args) {

		print("Please enter a whole number between 1 and 500: ");
		int input = readInt();

		if (input < 1 || input > 500)
			throw new PRException("Unvalid input: " + input);

		print("Here are all the dividers of the entered number: ");
		int[] result = calculateDividers(input);

		for (int i = 0; result[i] != 0; i++) {
			print(result[i] + " ");
		}
	}
}
