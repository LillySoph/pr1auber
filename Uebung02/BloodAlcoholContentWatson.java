package uebung02;

import static pr.MakeItSimple.*;

public class BloodAlcoholContentWatson {

	public static void main(String[] args) {


		print("Bitte geben Sie die Masse des Alkohols in g an: ");
		double alkoholmasse; // Masse des Alkohols
		alkoholmasse = readDouble(); 

		print("Sind Sie männlich (m) oder weiblich (w)?: "); // Abfrage nach dem Geschlecht

		String geschlecht;
		geschlecht = readString();

		print("Bitte geben Sie Ihre Körpergröße in (cm) an: ");
		int größe;
		größe = readInt();

		print("Bitte geben Sie Ihr Körpergewicht in (kg) an: ");
		double kg;
		kg = readDouble();		

		if (geschlecht.equals("m")) {
			print("Wie alt sind Sie?: ");
			int alter;
			alter = readInt();
			
			double gkwm; // Gesamtkörperwasser für den Mann
			gkwm = (2.447 - (0.09516 * alter) + (0.1074 * größe) + (0.3362 * kg));
			double rm; // Reduktionsfaktor männlich
			rm = ((1.055 * gkwm) / (0.8 * kg));
			
			println("\nIhr Gesamtkörperwasser in Liter beträgt: " + gkwm);
			println("Ihr Reduktionfaktor im Körper ist: " + rm);
			println("Sie haben: " + (alkoholmasse / (kg * rm)) + " ‰ Alkohol im Blut.");
		}
		else if (geschlecht.equals("w")) {
			double gkww; // Gesamtörperwasser für die Frau
			gkww = (-2.097 + (0.1069 * größe) + (0.2466 * kg));
			double rw; // Reduktionsfaktor weiblich
			rw = ((1.055 * gkww) / (0.8 * kg));
			
			println("\nIhr Gesamtkörperwasser in Liter beträgt: " + gkww);
			println("Ihr Reduktionfaktor im Körper ist: " + rw);
			println("Sie haben: " + (alkoholmasse / (kg * rw)) + " ‰ Alkohol im Blut.");
		}
	}

}
