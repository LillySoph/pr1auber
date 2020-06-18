package uebung02;

import static pr.MakeItSimple.print;
import static pr.MakeItSimple.println;
import static pr.MakeItSimple.readInt;

public class Median {

	public static void main(String[] args) {

		// Bei der Eingabe von drei beliebigen Ganzzahlen wird der Median ausgegeben
		// (Median = Die Zahl, die wertmäßig zwischen den beiden anderen Zahlen liegt)

		// Die drei Variablen a, b und c werden als Integer (Ganzzahl) deklariert
		println("Bitte geben Sie nacheinander 3 beliebige Ganzzahlen ein, damit der Median ermittelt werden kann: ");
		int a, b, c;

		// und mit der readInt()-Methode initialisiert
		a = readInt();
		b = readInt();
		c = readInt();

		// Zunächst wird geprüft, ob 3 mal oder 2 mal die selbe Zahl eingegeben wurde:
		if (a == b && a == c) {
			print("Es wurde drei mal die selbe Zahl eingegeben. Der Median beträgt: " + a);
		} else if (a == b || a == c) {
			print("Es wurde zwei mal die selbe Zahl eingegeben. Der Median beträgt: " + a);
		} else if (b == a || b == c) {
			print("Es wurde zwei mal die selbe Zahl eingegeben. Der Median beträgt: " + b);
		} else if (c == b || c == a) {
			print("Es wurde zwei mal die selbe Zahl eingegeben. Der Median beträgt: " + c);

		} else {
			print("Der Median der drei eingegeben Zahlen beträgt: ");

			// Bei den nachfolgenden 3 Aussagen wird geprüft welche der einzelnen
			// Variablen a, b und c der Median ist

			if ((a > c && a < b) || (a > b && a < c)) {
				print(a);
			} else if ((c > b && c < a) || (c > a && c < b)) {
				print(c);
			} else if ((b > a && b < c) || (b > c && b < a)) {
				print(b);
			}
		}
	}
}
