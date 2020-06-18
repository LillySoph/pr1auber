package uebung04;

import static pr.MakeItSimple.*;

public class PerfectNumberExy {

	public static boolean isPerfectNumber(int zahl) {

		if (zahl <= 0) {
			throw new PRException("Ihre Eingabe " + zahl + " ist ungültig");
		}

		int teiler = 1;
		int summe = 0;

		while (teiler < zahl) { // Teiler muss kleiner als die Zahl sein
			if (zahl % teiler == 0) // Divisonsrest muss 0 sein, da der Teiler keine Nachkommastellen haben sollte

				summe = summe + teiler; // Teiler werden summiert (zwischenspeichern)
			teiler++;
		}
		if (zahl == summe) // Summe der Teiler gleich der Zahl ist , --> vollkommene Zahl
			return true;
		else
			return false;

	}

	public static void main(String[] args) {
		print("Bitte geben Sie eine zu prüfende Zahl ein: ");
		int zahl = readInt();

		if (isPerfectNumber(zahl) == true)
			println("Ja, die eingegebene Zahl ist vollkommen.");

		else
			println("Nein, die eingebene Zahl ist nicht vollkommen.");

	}
}