package uebung03;

import static pr.MakeItSimple.*;

public class Rechner {
	// Methode, um die Zahlen zu ermitteln
	static int number(int a, int b, int c) {
		return (a * 100) + (b * 10) + c;
	}

	// Methode, um zu Prüfen, dass alle Bedingungen des Zahlenrätsels erfüllt sind.
	static boolean zahlenrätselErfüllt(int star, int triangle, int square, int diamond, int forever, int triangleDown, int circle,
			int tree, int circleCross, int circlePoint) {

		int numberTopLeft = number(star, triangle, diamond);
		int numberTopMiddle = number(forever, triangle, triangleDown);
		int numberTopRight = number(triangleDown, square, square);
		int numberCenterLeft = number(forever, triangleDown, circlePoint);
		int numberCenterMiddle = number(square, square, star);
		int numberCenterRight = number(tree, square, circleCross);
		int numberBottomLeft = number(diamond, triangle, circleCross);
		int numberBottomMiddle = number(square, triangleDown, forever);
		int numberBottomRight = number(forever, triangleDown, circle);

		return numberTopLeft + numberTopMiddle == numberTopRight
				&& numberCenterLeft + numberCenterMiddle == numberCenterRight
				&& numberBottomLeft + numberBottomMiddle == numberBottomRight
				&& numberTopLeft - numberCenterLeft == numberBottomLeft
				&& numberTopMiddle - numberCenterMiddle == numberBottomMiddle
				&& numberTopRight - numberCenterRight == numberBottomRight
				// wenn die summe aller Variablen ungleich 0 ist, ist sichergestellt, dass 0
				// nicht als Loesung ausgegeben wird.
				&& star + triangle + square + diamond + forever + triangleDown + circle + tree + circleCross
						+ circlePoint != 0;
	}

	public static void main(String[] args) {
		// Symbole als Integer vereinbaren mit Wert auf 0
		int star = 0, triangle = 0, square = 0, diamond = 0, forever = 0, triangleDown = 0, circle = 0, tree = 0,
				circleCross = 0, circlePoint = 0;

		// solange die Methode check = false ist, wird die while-Schleife ausgeführt.
		while (!zahlenrätselErfüllt(star, triangle, square, diamond, forever, triangleDown, circle, tree, circleCross, circlePoint)) {
			// Dies ist der Zähler, der alle möglichen Kombinationen ausprobiert:
			// (10 hoch 10 mögliche Kombinationen)
			star++;
			if (star > 9) {
				star = 0;
				triangleDown++;
			}
			if (triangleDown > 9) {
				triangleDown = 0;
				circlePoint++;
			}
			if (circlePoint > 9) {
				circlePoint = 0;
				diamond++;
			}
			if (diamond > 9) {
				diamond = 0;
				forever++;
			}
			if (forever > 9) {
				forever = 0;
				triangle++;
			}
			if (triangle > 9) {
				triangle = 0;
				circle++;
			}
			if (circle > 9) {
				circle = 0;
				tree++;
			}
			if (tree > 9) {
				tree = 0;
				circleCross++;
			}
			if (circleCross > 9) {
				circleCross = 0;
				square++;
			}
		}

		// sobald check = true ist, wird das Ergebnis auf die Konsole ausgegeben:
		println("star: " + star + " | triangleDown: " + triangleDown + " | circlePoint: " + circlePoint + " | diamond: "
				+ diamond + " | forever: " + forever + " | triangle: " + triangle + " | circle: " + circle + " | tree: "
				+ tree + " | circleCross: " + circleCross + " | square: " + square);
		println();
		println(number(star, triangle, diamond) + " + " + number(forever, triangle, triangleDown) + " = "
				+ number(triangleDown, square, square));
		println(" -  " + "   - " + "    - ");
		println(number(forever, triangleDown, circlePoint) + " + " + number(square, square, star) + " = "
				+ number(tree, square, circleCross));
		println(" =  " + "   = " + "    = ");
		println(number(diamond, triangle, circleCross) + " + " + number(square, triangleDown, forever) + " = "
				+ number(forever, triangleDown, circle));
	}
}
