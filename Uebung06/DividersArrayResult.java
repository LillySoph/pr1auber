package uebung06;

import static pr.MakeItSimple.*;

public class DividersArrayResult {

	static boolean isPrim(int number) {
		int[] dividers = calculateDividers(number);
		int counter = 0;

		for (int index = 0; dividers[index] != 0; index++) {
			counter++;
		}
		return (counter == 2);
	}

	static int[] calculateDividers(int number) {

		int[] dividers = new int[500];
		int divider = 0;
		int index = 0;

		while (divider <= number) {
			divider++;

			if (number % divider == 0) {

				dividers[index] = divider;
				index++;
			}

		}
		return dividers;
	}

	public static void main(String[] args) {

		print("Please enter a number between 1 and 500: ");
		int number = readInt();

		if (number <= 0 || number > 500) {
			throw new PRException("invalid input: " + number);
		}

		int[] dividers = calculateDividers(number);

		for (int index = 0; dividers[index] != 0; index++) {
			print(dividers[index] + " ");

		}

		if (isPrim(number))
			print("\n" + number + " is a prim number.");
		else
			print("\n" + number + " is not a prim number.");

	}
}
