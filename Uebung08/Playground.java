package uebung08;

import static pr.MakeItSimple.*;

import pr.MakeItSimple;

public class Playground {

	private String[][] field = { { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " " },
			{ " ", " ", " ", " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " ", " ", " ", " " },
			{ " ", " ", " ", " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " ", " ", " ", " " },
			{ " ", " ", " ", " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " ", " ", " ", " " },
			{ " ", " ", " ", " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " ", " ", " ", " " },
			{ " ", " ", " ", " ", " ", " ", " ", " ", " ", " " } };

	private int counter = 0;
	private int steps = 1000;

	Ball ball = new Ball();

	Playground() {

	}

	void print() {

		println("____________");
		for (int y = 0; y < field.length; y++) {
			MakeItSimple.print("|");
			for (int x = 0; x < field.length; x++) { // x= Spalte
				MakeItSimple.print(field[y][x]);
			}
			MakeItSimple.println("|");
		}
		println("‾‾‾‾‾‾‾‾‾‾‾‾");

	}

	void runGame() {

		while (steps > 0) {

			ball.addInPlayground(field);
			print();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			counter += ball.move();
			steps--;

		}
		MakeItSimple.print("Counter: " + counter);
	}

	public static void main(String[] args) {

		Playground playground = new Playground();

		playground.runGame();
	}
}
