package uebung07;

import pr.MakeItSimple;

public class Sudoku {

	/* Hilfmethoden: */

	static boolean noBlanks(int[][] field) {
		int row;
		int col;

		for (row = 0; row < 9; row++) {
			for (col = 0; col < 9; col++) {
				if (field[row][col] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	static boolean checkRow(int[][] field, int indexV, int indexH) {

		int[] currentRow = new int[9];

		for (int indexRow = 0; indexH < 9; indexH++, indexRow++) {
			currentRow[indexRow] = field[indexV][indexH];
		}

		int checkNumber = 1;
		int checkCounter = 0;

		while (checkNumber < 10) {

			for (int index = 0; index < 9 && checkCounter < 2; index++) {
				if (currentRow[index] == checkNumber)
					checkCounter++;
			}
			if (checkCounter > 1) {
				return false;
			}
			checkNumber++;
			checkCounter = 0;
		}

		return true;
	}

	static boolean checkColumn(int[][] field, int indexV, int indexH) {

		int[] currentColumn = new int[9];

		for (int indexColumn = 0; indexV < 9; indexV++, indexColumn++) {
			currentColumn[indexColumn] = field[indexV][indexH];
		}
		int checkNumber = 1;
		int checkCounter = 0;

		while (checkNumber < 10) {

			for (int index = 0; index < 9 && checkCounter < 2; index++) {
				if (currentColumn[index] == checkNumber)
					checkCounter++;
			}
			if (checkCounter > 1) {
				return false;
			}
			checkNumber++;
			checkCounter = 0;
		}

		return true;
	}

	static boolean checkBlock(int[][] field, int indexV, int indexH, int counterV, int counterH) {

		int[] currentBlock = new int[9];
		int indexBlock = 0;

		for (indexV = 0; indexV < 3; indexV++) {
			for (indexH = 0; indexH < 3; indexH++, indexBlock++) {
				currentBlock[indexBlock] = field[indexV + counterV][indexH + counterH];
			}
		}
		int checkNumber = 1;
		int checkCounter = 0;

		while (checkNumber < 10) {

			for (int index = 0; index < 9 && checkCounter < 2; index++) {
				if (currentBlock[index] == checkNumber)
					checkCounter++;
			}
			if (checkCounter > 1) {
				return false;
			}
			checkNumber++;
			checkCounter = 0;
		}

		return true;
	}

	/* vorgegebene Methoden: */

	static void print(int[][] field) {
		int i;
		int j;

		for (i = 0; i < field.length; i++) {
			if (i % 3 == 0 && i != 0) {
				MakeItSimple.println("––––––+–––––––+–––––––");
			}
			for (j = 0; j < field.length; j++) {
				MakeItSimple.print(field[i][j]);
				if ((j + 1) % 3 == 0 && j != 8) {
					MakeItSimple.print(" | ");
				} else
					MakeItSimple.print(" ");
			}
			MakeItSimple.println("");
		}
		MakeItSimple.println("");

	}

	static boolean isCorrect(int[][] field) {

		/* check Rows */
		int indexV = 0;
		int indexH = 0;

		while (indexV < 9) {
			if (!checkRow(field, indexV, indexH)) {
				return false;
			}
			indexV++;
			indexH = 0;
		}

		/* check Columns */
		indexV = 0;
		indexH = 0;

		while (indexH < 9) {
			if (!checkColumn(field, indexV, indexH)) {
				return false;
			}
			indexH++;
			indexV = 0;
		}

		/* check Blocks */
		indexV = 0;
		indexH = 0;
		int counterV = 0;
		int counterH = 0;

		while (indexV < 9 && counterH < 9) {
			while (indexH < 9 && counterV < 9) {
				if (!checkBlock(field, indexV, indexH, counterV, counterH)) {
					return false;
				}
				counterV += 3;
			}
			/* counter V = counterH */
			counterV = 0;
			counterH += 3;
		}
		return true;
	}

  	static void solve(int[][] field, int row, int col) {

		if (col >= field[row].length) {
			col = 0;
			row++;
		}

		if (row >= field.length) {
			row = 0;
			col++;
		}

		if (field[row][col] == 0) {

			for (int i = 1; i <= 9; i++) {

				field[row][col] = i;

				if (isCorrect(field) && noBlanks(field)) {

					print(field);

				} else if (isCorrect(field)) {

					print(field);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}

					solve(field, row, col + 1);

				}
			}
			field[row][col] = 0;

		} else {
			solve(field, row, col + 1);
		}

	}

	public static void main(String[] args) {

		// Sudoku entsprechend der Aufgabe füllen:
		int[][] field = { { 0, 9, 0, 0, 0, 5, 0, 2, 1 }, { 0, 3, 0, 9, 0, 1, 4, 0, 0 }, { 2, 7, 0, 0, 0, 0, 0, 9, 6 },
				{ 5, 0, 0, 0, 0, 6, 8, 3, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 3, 4, 0, 0, 6, 5, 0 },
				{ 0, 0, 0, 0, 5, 9, 1, 8, 0 }, { 0, 0, 0, 2, 8, 0, 0, 0, 5 }, { 9, 5, 0, 3, 0, 0, 2, 6, 7 } };

		solve(field, 0, 0);

	}
}
