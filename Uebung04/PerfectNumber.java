package uebung04;

import static pr.MakeItSimple.*;

public class PerfectNumber {

	static boolean isPerfectNumber(int eingabe) {
		if (eingabe <= 0)
			throw new PRException("Ihre Eingabe " + eingabe + " ist ungültig. ");

		int teilerSumme = 0;
		int teiler = 1;
		while (teiler < eingabe) {
			if ((eingabe % teiler) == 0) {
				teilerSumme +=  teiler; }
			teiler++;
		}
		return (eingabe == teilerSumme);
	}

	public static void main(String[] args) {

		print("Bitte geben Sie eine natürliche Zahl ein. Wir werden prüfen, ob es sich dabei um eine vollkommene Zahl handelt. ");
		int eingabe = readInt();

		if (isPerfectNumber(eingabe))
			println("ja, die eingegebene Zahl ist vollkommen.");
		else
			println("nein, die eingebenene Zahl ist nicht vollkommen.");
	}
}
