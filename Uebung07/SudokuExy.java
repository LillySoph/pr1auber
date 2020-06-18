package uebung07;

import pr.MakeItSimple;

public class SudokuExy {

	static void print(int[][] field) {

		int x = 0;
		int y = 0;

		/* Erstellen eines 9x9 Spielfelds */
		/* Horizontal (x) */

		for (x = 0; x < field.length; x++) {
			MakeItSimple.println();
			if (x % 3 == 0 && x != 0) {
				MakeItSimple.println("––––––+–––––––+–––––––");
			}

			/* Vertikal (y) */
			for (y = 0; y < field.length; y++) {
				if (y % 3 == 0 && y != 0) {
					MakeItSimple.print("| ");
				}
				MakeItSimple.print(field[x][y] + " ");
			}
		}

	}

	/* Hilfsmethode 1 */
	/* schaut ob die Zahl 1x in jeder Zeile vorkommmt , Zahl kommt öfters vor */

	static boolean isInRow(int[][] field, int row, int number) {

		for (int i = 0; i < field.length; i++) {
			if (field[row][i] == number) {
			}

			return true;
		}

		return false; /* keine Zahl in Zeile 9 Spalte i */
	}

	/* Hilfsmethode 2 */
	/*
	 * schaut ob die Zahl einmal in der Spalte vorkommt in jeder Spalte , Zahl kommt
	 * öfters vor
	 */
	static boolean isInCol(int[][] field, int col, int number) {

		for (int j = 0; j < field.length; j++) {
			if (field[j][col] == number) {
			}

			return true;
		}

		return false; /* keine Zahl in der Zeile j Spalte 9 */
	}

	/* Hilfmethode 3 */
	/* schaut ob die Zahl 1x in 3x3 Box vorkommt, Zahl kommt öfters vor */
	static boolean isInThreeBox(int[][] field, int row, int col, int number) {
		int r = (row - row) % 3; /* 9-9 = 0 , 0%3= 0 */
		int c = (col - col) % 3;

		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) {
				if (field[i][j] == number) {

				}
				return true;
			}
		}

		return false;
	}

	static boolean isCorrect(int[][] field, int row, int col, int number) {
		/* ACHTUNG METHODE + int number HINZUGEFÜGT */
		return !isInRow(field, row, number) && !isInCol(field, col, number) && !isInThreeBox(field, row, col, number);
		/* true, Zahl respektiert die Regeln , Zahl soll nur einmal vorkommen */
	}

	static boolean isCorrectWithNull(int[][] field, int row, int col, int number) {
		/* ACHTUNG METHODE + int number HINZUGEFÜGT */
		return !isInRow(field, row, number) && !isInCol(field, col, number) && !isInThreeBox(field, row, col, number);
		/* true, Zahl respektiert die Regeln , Zahl soll nur einmal vorkommen */
	}

	/* Hilfsmethode 4 */
	static boolean trySolve(int[][] field, int row, int col) {

		for (row = 0; row < field.length; row++) {
			for (col = 0; col < field.length; col++) {
				/* man sucht eine leere Zelle */
				if (field[row][col] == 0) {
					/* man setzt mögliche Zahlen ein */
					for (int number = 1; number <= 9; number++) {
						if (isCorrect(field, row, col, number)) {
							// Zahl korrekt, hält sich an die Regeln*/
							field[row][col] = number;

							if (trySolve(field, row, col)) {
								return true;

							} else {
								field[row][col] = 0;
								/* keine passende Zahl, weitermachen */
							}
						}
					}

					return false; /* Sudoku nicht gelöst */
				}

			}
		}
		return true; /* Sudoku gelöst */
	}

//	static boolean tryJoost(int[][] field, int row, int col) {
//
//		
//		
//		/* man sucht eine leere Zelle */
//				if (field[row][col] == 0) {
//					/* man setzt mögliche Zahlen ein */
//					for (int number = 1; number <= 9; number++) {
//						if (isCorrect(field, row, col, number)) {
//							// Zahl korrekt, hält sich an die Regeln*/
//							field[row][col] = number;
//
//							if (trySolve(field, row, col)) {
//								return true;
//
//							} else {
//								/* keine passende Zahl, weitermachen */
//							}
//						}
//					}
//					field[row][col] = 0;
//					
//
//					
//					return false; /* Sudoku nicht gelöst */
//				}
//
//			}
//
//	}return true; /* Sudoku gelöst */
//	}
//	

	static void solve(int[][] field, int row, int col) {
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field.length; j++) {
				MakeItSimple.print(" " + field[i][j]);
			}
			MakeItSimple.println();
		}

		MakeItSimple.println();
	}

	public static void main(String[] args) {

		int[][] field = { { 0, 9, 0, 0, 0, 5, 0, 2, 1 }, { 0, 3, 0, 9, 0, 1, 4, 0, 0 }, { 2, 7, 0, 0, 0, 0, 0, 9, 6 },
				{ 5, 0, 0, 0, 0, 6, 8, 3, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 3, 4, 0, 0, 6, 5, 0 },
				{ 0, 0, 0, 0, 5, 9, 1, 8, 0 }, { 0, 0, 0, 2, 8, 0, 0, 0, 5 }, { 9, 5, 0, 3, 0, 0, 2, 6, 7 } };

		SudokuExy.print(field);
		MakeItSimple.print("\nSudoku grid to solve");

		int row = field.length;
		int col = field.length;

		MakeItSimple.print("\n Sudoku solved");

		if (SudokuExy.trySolve(field, row, col) == true) {
			MakeItSimple.println("Solved");
			SudokuExy.solve(field, row, col);
		} else {
			MakeItSimple.println("Unsolvable");
		}

		print(field);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			solve(field, row, col);
		}
	}
}
