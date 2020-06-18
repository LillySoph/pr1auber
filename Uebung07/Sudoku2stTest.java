package uebung07;

import static pr.MakeItSimple.*;

import org.junit.Test;

public class Sudoku2stTest {

	@Test
	public void test() {
		int[][] test = { { 0, 9, 0, 0, 0, 5, 0, 2, 1 }, { 0, 3, 0, 9, 0, 1, 4, 0, 0 }, { 2, 7, 0, 0, 0, 0, 0, 9, 6 },

				{ 5, 0, 0, 0, 0, 6, 8, 3, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 3, 4, 0, 0, 6, 5, 0 },

				{ 0, 0, 0, 0, 5, 9, 1, 8, 0 }, { 0, 0, 0, 2, 8, 0, 0, 0, 5 }, { 9, 5, 0, 3, 0, 0, 2, 6, 7 }, };

		SudokuExy.solve(test, 0, 0);

		println("");
		println("Die Ausgabe sollte wie folgt aussehen:");
		println("8 9 4 | 7 6 5 | 3 2 1");
		println("6 3 5 | 9 2 1 | 4 7 8");
		println("2 7 1 | 8 4 3 | 5 9 6");
		println("––––––+–––––––+––----");
		println("5 2 7 | 1 9 6 | 8 3 4");
		println("4 6 9 | 5 3 8 | 7 1 2");
		println("1 8 3 | 4 7 2 | 6 5 9");
		println("––––––+–––––––+––----");
		println("7 4 2 | 6 5 9 | 1 8 3");
		println("3 1 6 | 2 8 7 | 9 4 5");
		println("9 5 8 | 3 1 4 | 2 6 7");
	}

}