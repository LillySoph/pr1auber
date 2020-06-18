package uebung02;

import static pr.MakeItSimple.print;
import static pr.MakeItSimple.println;
import static pr.MakeItSimple.readDouble;
import static pr.MakeItSimple.readInt;
import static pr.MakeItSimple.readString;

public class BloodAlcoholContent {

	public static void main(String[] args) {
		print("Bitte geben Sie (in g) Ihr alkoholisches Getränkes ein: ");
		double alkoholmasse;
		alkoholmasse = readDouble();
	
		print("Sind Sie männlich (m) oder weiblich (w)?: "); // Abfrage nach dem Geschlecht
	    String geschlecht;
		geschlecht = readString();

		print("Wie viel wiegen Sie (in kg)?: "); // Abfrage nach dem Gewicht
		double gewicht;
		gewicht = readDouble();

		if (geschlecht.equals("m"))
			println("Sie haben als Mann: " + alkoholmasse / (gewicht * 0.7) + " ‰ Alkohol im Blut.");

		else if (geschlecht.equals("w"))
			println("Sie haben als Frau: " + alkoholmasse / (gewicht * 0.6) + " ‰ Alkohol im Blut.");
	}

}
