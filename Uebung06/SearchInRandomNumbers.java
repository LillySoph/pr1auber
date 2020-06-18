package uebung06;

import static pr.MakeItSimple.*;

// Aufgabe 3

public class SearchInRandomNumbers {

	static int[] generate(int numberCount) {

		if (numberCount < 0)
			throw new PRException("Invalid input for length of array: " + numberCount);

		// neues Array mit der Länge numberCount
		int[] generateNumbers = new int[numberCount];
		int randomNumber;

		// zufällige Zahlen generieren und in Array speichern
		for (int index = 0; index < numberCount; index++) {
			randomNumber = (int) (Math.random() * 1000) + 1;
			generateNumbers[index] = randomNumber;
		}
		return generateNumbers;
	}

	static int[] searchAll(int[] generateNumbers, int numberToSearch) {

		int numberOfHits = 0;
		for (int indexGenerator = 0; indexGenerator < generateNumbers.length; indexGenerator++) {
			if (generateNumbers[indexGenerator] == numberToSearch) {
				numberOfHits++;
			}
		}
		// neues Array mit Länge der gefundenen Zahlen
		int[] findNumber = new int[numberOfHits];

		int indexGenerator = 0;
		int indexHits = 0;

		// Stelle speichern, an der die Zahl gefunden wurde
		if (numberOfHits > 0) {
			while (indexGenerator < generateNumbers.length) {
				if (generateNumbers[indexGenerator] == numberToSearch) {
					findNumber[indexHits] = indexGenerator;
					indexHits++;
				}
				indexGenerator++;
			}
		}
		return findNumber;
	}

	static int searchLast(int[] generateNumbers, int numberToSearch) {

		int[] findNumber = searchAll(generateNumbers, numberToSearch);

		if (findNumber.length < 1)
			throw new PRException(
					"The method searchLast could not be executed as the number " + numberToSearch + " was not found. ");

		return findNumber[findNumber.length - 1];
	}

	public static void main(String[] args) {

		boolean menu = true;

		while (menu == true) {

			print("Please enter the length of the array: ");
			int numberCount = readInt();

			print("Please enter the number you want to find in the array: ");
			int numberToSearch = readInt();

			int[] generateNumbers = generate(numberCount);
			int[] findNumber = searchAll(generateNumbers, numberToSearch);

			if (findNumber.length > 1) {
				println("\nHere are the positions of the array, where the number was found: ");
			} else if (findNumber.length == 1) {
				println("\nHere is the position of the array, where the number was found: ");
			} else {
				println("The number " + numberToSearch + " was not found. ");
			}

			for (int i = 0; i < findNumber.length; i++) {
				print(findNumber[i] + " ");
			}

			println("\nThis is the last position the number was found in: "
					+ searchLast(generateNumbers, numberToSearch));

			println("To exit the program please enter 'exit'. ");
			if (readString().equals("exit")) {
				menu = false;
			}
		}
	}
}
