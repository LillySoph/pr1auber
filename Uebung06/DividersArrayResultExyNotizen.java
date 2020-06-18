package uebung06;

import static pr.MakeItSimple.*;

public class DividersArrayResultExyNotizen {

	static int[] calculateDividers(int zahl) {

		int[] teilerLaenge = new int[500];
		int teiler = 0;
		int index = 0;

		while (teiler <= zahl) { // fange von Teiler=0 an
			teiler++; // dann teiler hochzählen

			if (zahl % teiler == 0) { // 6%1 = 1
				teilerLaenge[index] = teiler; // Setze Teiler in dem Array teilerLaenge [0] = 1,[1]= 2,[3] = 3, [4] = 6
				index++; // [0] --> [1] ....[2]... index hochzählen
			}
			// zb. Eingabe: 6 --> teiler:1,2,3,6 ; Länge [500] , Position: 0-3 mit 1,2,3,6
			// und 000000....

		}
		return teilerLaenge;
	}

	public static void main(String[] args) {
		print("Bitte geben Sie eine ganze Zahl zwischen 1 und 500 ein: ");
		int zahl = readInt();

		if (zahl <= 0 || zahl > 500) {
			throw new PRException("Ungültige Eingabe:" + zahl);
		}

		int[] teiler = calculateDividers(zahl); // Array Teiler meiner eingegebene Zahl (1,2,3,6,00000000...)

		for (int index = 0; teiler[index] != 0; index++) { // Inhalt des Arrays soll nicht 0 ausgegeben werden,
															// sondern
															// nur die Teiler ausgeben
			print(teiler[index] + " ");

		}

	}
}
