package uebung06;

import static pr.MakeItSimple.*;

public class SearchInRandomNumbersExy {

	static int[] generate(int numbercount) {

		if (numbercount < 0)
			throw new PRException("Invalid input: " + numbercount);

		// Array mit Zufallszahlen hat die Länge der Eingabe (numbercourt)
		int[] arrayRandomnumbers = new int[numbercount];
		int index = 0;
		int randomnumbers;

		// Zufallszahlen in dem Array füllen
		while (index < arrayRandomnumbers.length) {
			randomnumbers = (int) (Math.random() * 1000) + 1;
			// die Zufallszahl wird im Array an der Stelle [0] zugewiesen
			arrayRandomnumbers[index] = randomnumbers;
			index++;
		}

		return arrayRandomnumbers; // Array mit zufälligen Zahlen
	}

	static int[] searchAll(int[] arrayRandomnumbers, int numberToSearch) {

		int index = 0;
		int numberFoundInArray = 0;

		// Suche alle Positionen von numberToSearch: 8 ,wo ist die 8 in dem Array?
		while (index < arrayRandomnumbers.length) {
			if (arrayRandomnumbers[index] == numberToSearch) {
				numberFoundInArray++; // zählt auf wie viele er gefunden hat zb 2
			}
			index++;
		} // 8 ist in [0] und [11] <<<<

		// Neues Array mit gefundenen Positionen
		int[] foundPositions = new int[numberFoundInArray]; // Anzahl der gefundenen Zahlen -->(2) Länge

		int positionAusgabe = 0;
		index = 0; // statt neue Index hinzufügen

		if (numberFoundInArray >= 1) {// muss mir mind eine gefundene Zahl augeben oder mehr

			while (index < arrayRandomnumbers.length) {
				// vorher stand hier: (index < foundPositions.length) // 0-1 soll er gehen

				if (arrayRandomnumbers[index] == numberToSearch) {// an der Stelle (Index) [0] [11] steht die == 8
					foundPositions[positionAusgabe] = index; // gibt in den Array wie die Positionen lauten index=(0,11)
					positionAusgabe++; // sucht weitere stellen in index
				}
				index++;
			}
		}
		return foundPositions; // --> [0] [11] steht die 8 wird ausgegeben || wenn keine 8 gefunden, nichts
								// ausgegeben
	}

	static int searchLast(int[] arrayRandomnumbers, int numberToSearch) {

		int[] foundPositions = searchAll(arrayRandomnumbers, numberToSearch); // ruft [0] und [11] auf ..

		if (foundPositions.length < 1) // wenn keine 8 gefunden wurde musst die Arraylänge < 1 sein bzw nichts
			throw new PRException("Your number to search " + numberToSearch + " wasn't found in the array.");

		return foundPositions[foundPositions.length - 1]; // letzte Position des Array zurückgeben [11]
	}

	public static void main(String[] args) {

		print("Please enter a number: ");
		int numbercount = readInt();

		print("Please enter a number to search in the array: ");
		int numberToSearch = readInt();

		// alle gefundenen Positionen ausgeben
		int[] arraynumbers = generate(numbercount);
		int[] positionsArray = searchAll(arraynumbers, numberToSearch);

		println("Here are the positions of the array: ");
		for (int index = 0; index < positionsArray.length; index++) {
			print(positionsArray[index] + " ");

		}

		// die letzte Position wird ausgegeben
		println("\nThe last position of your number you've looked for is: " + searchLast(arraynumbers, numberToSearch));
	}

}
