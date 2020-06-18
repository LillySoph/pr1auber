package uebung05;

// kleiner Fehler in d)....
import static pr.MakeItSimple.*;

public class BaconKodiererExy {
//a)
	static String reinigeNachricht(String nachricht) {

		int zaehler = 0;
		String reinigeNachricht = "";

		while (zaehler < nachricht.length()) {

			char aktuellerBuchstabe = nachricht.charAt(zaehler); // liest Zeichen von der Nachricht ;Position 0

			if (aktuellerBuchstabe >= 'A' && aktuellerBuchstabe <= 'Z') { // Großbuchstabe?
				reinigeNachricht += aktuellerBuchstabe;
			} else if (aktuellerBuchstabe >= 'a' && aktuellerBuchstabe <= 'z') { // Kleinbuchstabe?
				aktuellerBuchstabe = (char) (aktuellerBuchstabe - 'a' + 'A'); // Kleinbuchstabe-Großbuchstabe
				reinigeNachricht += aktuellerBuchstabe;
			} else if (aktuellerBuchstabe == 'Ä' || aktuellerBuchstabe == 'ä') { // 1.Eingabe ä/Ä?
				reinigeNachricht += "AE";
			} else if (aktuellerBuchstabe == 'Ü' || aktuellerBuchstabe == 'ü') {// 1.Eingabe ö/Ö?
				reinigeNachricht += "UE";
			} else if (aktuellerBuchstabe == 'Ö' || aktuellerBuchstabe == 'ö') {
				reinigeNachricht += "OE";
			} else if (aktuellerBuchstabe == 'ß') {
				reinigeNachricht += "SS";
			} else {
				reinigeNachricht += ""; // wenn Sonderzeichen
			}
			zaehler++; // nächstes Zeichen..

		}

		return reinigeNachricht;
	}

//b)
	static String kodiereNachricht(String gereinigteNachricht) {

		int zaehler = 0;
		String kodierteNachricht = "";

		while (zaehler < gereinigteNachricht.length()) {

			char aktuellerBuchstabe = gereinigteNachricht.charAt(zaehler);

			if (aktuellerBuchstabe < 'A' || aktuellerBuchstabe > 'Z') {
				throw new PRException("Ungültige Eingabe: " + gereinigteNachricht);
			} else if (aktuellerBuchstabe == 'A') {
				kodierteNachricht += "kkkkk";
			} else if (aktuellerBuchstabe == 'B') {
				kodierteNachricht += "kkkkg";
			} else if (aktuellerBuchstabe == 'C') {
				kodierteNachricht = kodierteNachricht + "kkkgk";
			} else if (aktuellerBuchstabe == 'D') {
				kodierteNachricht = kodierteNachricht + "kkkgg";
			} else if (aktuellerBuchstabe == 'E') {
				kodierteNachricht = kodierteNachricht + "kkgkk";
			} else if (aktuellerBuchstabe == 'F') {
				kodierteNachricht = kodierteNachricht + "kkgkg";
			} else if (aktuellerBuchstabe == 'G') {
				kodierteNachricht = kodierteNachricht + "kkggk";
			} else if (aktuellerBuchstabe == 'H') {
				kodierteNachricht = kodierteNachricht + "kkggg";
			} else if (aktuellerBuchstabe == 'I' || aktuellerBuchstabe == 'J') {
				kodierteNachricht = kodierteNachricht + "kgkkk";
			} else if (aktuellerBuchstabe == 'K') {
				kodierteNachricht = kodierteNachricht + "kgkkg";
			} else if (aktuellerBuchstabe == 'L') {
				kodierteNachricht = kodierteNachricht + "kgkgk";
			} else if (aktuellerBuchstabe == 'M') {
				kodierteNachricht = kodierteNachricht + "kgkgg";
			} else if (aktuellerBuchstabe == 'N') {
				kodierteNachricht = kodierteNachricht + "kggkk";
			} else if (aktuellerBuchstabe == 'O') {
				kodierteNachricht = kodierteNachricht + "kggkg";
			} else if (aktuellerBuchstabe == 'P') {
				kodierteNachricht = kodierteNachricht + "kgggk";
			} else if (aktuellerBuchstabe == 'Q') {
				kodierteNachricht = kodierteNachricht + "kgggg";
			} else if (aktuellerBuchstabe == 'R') {
				kodierteNachricht = kodierteNachricht + "gkkkk";
			} else if (aktuellerBuchstabe == 'S') {
				kodierteNachricht = kodierteNachricht + "gkkkg";
			} else if (aktuellerBuchstabe == 'T') {
				kodierteNachricht = kodierteNachricht + "gkkgk";
			} else if (aktuellerBuchstabe == 'U' || aktuellerBuchstabe == 'V') {
				kodierteNachricht = kodierteNachricht + "gkkgg";
			} else if (aktuellerBuchstabe == 'W') {
				kodierteNachricht = kodierteNachricht + "gkgkk";
			} else if (aktuellerBuchstabe == 'X') {
				kodierteNachricht = kodierteNachricht + "gkgkg";
			} else if (aktuellerBuchstabe == 'Y') {
				kodierteNachricht = kodierteNachricht + "gkggk";
			} else if (aktuellerBuchstabe == 'Z') {
				kodierteNachricht = kodierteNachricht + "gkggg";
			}
			zaehler++;
		}

		return kodierteNachricht;

	}

//c)
	static String dekodiereNachricht(String binaerCode) {

		int zähler = 0;
		String dekodierteNachricht = "";
		int binaerCodeLaengeDurch5 = (binaerCode.length() - (binaerCode.length() % 5));
		// 0%5=0... //mit "+" Fehler out of range .. // nur binaerCode.length%5 = liest
		// nur 1 5er Block

		while (zähler < binaerCodeLaengeDurch5) {

			String fünferBlock = "" + binaerCode.charAt(zähler) + binaerCode.charAt(zähler + 1)
					+ binaerCode.charAt(zähler + 2) + binaerCode.charAt(zähler + 3) + binaerCode.charAt(zähler + 4);

			if (fünferBlock.equals("kkkkk")) // Dekodierung
				dekodierteNachricht += "A";
			else if (fünferBlock.equals("kkkkg"))
				dekodierteNachricht += "B";
			else if (fünferBlock.equals("kkkgk"))
				dekodierteNachricht += "C";
			else if (fünferBlock.equals("kkkgg"))
				dekodierteNachricht += "D";
			else if (fünferBlock.equals("kkgkk"))
				dekodierteNachricht += "E";
			else if (fünferBlock.equals("kkgkg"))
				dekodierteNachricht += "F";
			else if (fünferBlock.equals("kkggk"))
				dekodierteNachricht += "G";
			else if (fünferBlock.equals("kkggg"))
				dekodierteNachricht += "H";
			else if (fünferBlock.equals("kgkkk"))
				dekodierteNachricht += "I";
			else if (fünferBlock.equals("kgkkg"))
				dekodierteNachricht += "K";
			else if (fünferBlock.equals("kgkgk"))
				dekodierteNachricht += "L";
			else if (fünferBlock.equals("kgkgg"))
				dekodierteNachricht += "M";
			else if (fünferBlock.equals("kggkk"))
				dekodierteNachricht += "N";
			else if (fünferBlock.equals("kggkg"))
				dekodierteNachricht += "O";
			else if (fünferBlock.equals("kgggk"))
				dekodierteNachricht += "P";
			else if (fünferBlock.equals("kgggg"))
				dekodierteNachricht += "Q";
			else if (fünferBlock.equals("gkkkk"))
				dekodierteNachricht += "R";
			else if (fünferBlock.equals("gkkkg"))
				dekodierteNachricht += "S";
			else if (fünferBlock.equals("gkkgk"))
				dekodierteNachricht += "T";
			else if (fünferBlock.equals("gkkgg"))
				dekodierteNachricht += "U";
			else if (fünferBlock.equals("gkgkk"))
				dekodierteNachricht += "W";
			else if (fünferBlock.equals("gkgkg"))
				dekodierteNachricht += "X";
			else if (fünferBlock.equals("gkggk"))
				dekodierteNachricht += "Y";
			else if (fünferBlock.equals("gkggg"))
				dekodierteNachricht += "Z";
			else
				dekodierteNachricht += "#";
			{
				zähler += 5; // liest immer 5er Blöcke
			}
		}
		return dekodierteNachricht;

	}

//d)
	static String versteckeNachricht(String nachricht, String traegerMedium) {

		int zählerBuchstabe = 0;
		int zählerTraegerMedium = 0; // zählt alle Buchstaben des Trägermediums
		String binaerCode = kodiereNachricht(reinigeNachricht(nachricht));

		while (zählerBuchstabe < traegerMedium.length()) {

			char aktuelleBuchstabeprüfung = traegerMedium.charAt(zählerBuchstabe);

			if (aktuelleBuchstabeprüfung >= 'A' && aktuelleBuchstabeprüfung <= 'Z'
					|| aktuelleBuchstabeprüfung >= 'a' && aktuelleBuchstabeprüfung <= 'z'
					|| aktuelleBuchstabeprüfung == 'Ä' || aktuelleBuchstabeprüfung == 'ä'
					|| aktuelleBuchstabeprüfung == 'Ü' || aktuelleBuchstabeprüfung == 'ü'
					|| aktuelleBuchstabeprüfung == 'Ö' || aktuelleBuchstabeprüfung == 'ö')

				zählerTraegerMedium++;
			zählerBuchstabe++;
		}
		if (zählerTraegerMedium < binaerCode.length())
			throw new PRException("Das Trägermedium ist zu kurz.");

		int zaehlerTraegermedium = 0, zaehlerBinaerCode = 0;
		String korrektur = "";

		while (zaehlerBinaerCode < binaerCode.length()) {

			char aktuellesBinaerzeichen = binaerCode.charAt(zaehlerBinaerCode);
			char aktuellesTraegermediumzeichen = traegerMedium.charAt(zaehlerTraegermedium);

			if (aktuellesBinaerzeichen == 'k') {
				if (aktuellesTraegermediumzeichen >= 'A' && aktuellesTraegermediumzeichen <= 'Z') {
					aktuellesTraegermediumzeichen = (char) (aktuellesTraegermediumzeichen + 'a' - 'A');
					korrektur += aktuellesTraegermediumzeichen;
				} else if (aktuellesTraegermediumzeichen >= 'a' && aktuellesTraegermediumzeichen <= 'z') {
					korrektur += aktuellesTraegermediumzeichen;
				} else if (aktuellesTraegermediumzeichen == 'Ä' || aktuellesTraegermediumzeichen == 'ä') {
					korrektur += 'ä';
				} else if (aktuellesTraegermediumzeichen == 'Ü' || aktuellesTraegermediumzeichen == 'ü') {
					korrektur += 'ü';
				} else if (aktuellesTraegermediumzeichen == 'Ö' || aktuellesTraegermediumzeichen == 'ö') {
					korrektur += 'ö';
				} else {
					korrektur += aktuellesTraegermediumzeichen;
					zaehlerBinaerCode--;
				}
			}
			if (aktuellesBinaerzeichen == 'g') {
				if (aktuellesTraegermediumzeichen >= 'A' && aktuellesTraegermediumzeichen <= 'Z') {
					korrektur += aktuellesTraegermediumzeichen;
				} else if (aktuellesTraegermediumzeichen >= 'a' && aktuellesTraegermediumzeichen <= 'z') {
					aktuellesTraegermediumzeichen = (char) (aktuellesTraegermediumzeichen - 'a' + 'A'); // Großbuchstabe-Kleinbuchstabe
					korrektur += aktuellesTraegermediumzeichen;
				} else if (aktuellesTraegermediumzeichen == 'Ä' || aktuellesTraegermediumzeichen == 'ä') {
					korrektur += 'Ä';
				} else if (aktuellesTraegermediumzeichen == 'Ü' || aktuellesTraegermediumzeichen == 'ü') {
					korrektur += 'Ü';
				} else if (aktuellesTraegermediumzeichen == 'Ö' || aktuellesTraegermediumzeichen == 'ö') {
					korrektur += 'Ö';
				} else {
					korrektur += aktuellesTraegermediumzeichen;
					zaehlerBinaerCode--;
				}
			}
			zaehlerBinaerCode++;
			zaehlerTraegermedium++;

		}
		while (korrektur.length() < traegerMedium.length()) {
			korrektur += traegerMedium.charAt(zaehlerTraegermedium);
			zaehlerTraegermedium++;
		}
		return korrektur;
	}

//e)
	static String zeigeNachricht(String steganogramm) {

		int zähler = 0;
		String code = "";

		while (zähler < steganogramm.length()) {
			char aktuellerBuchstabe = steganogramm.charAt(zähler);
//Großbuchstaben sind die die mit g anfangen, Kleibuchstabe mit k	

			if (aktuellerBuchstabe >= 'A' && aktuellerBuchstabe <= 'Z' || aktuellerBuchstabe == 'Ä'
					|| aktuellerBuchstabe == 'Ö' || aktuellerBuchstabe == 'Ü') {
				code += 'g';
			} else if (aktuellerBuchstabe >= 'a' && aktuellerBuchstabe <= 'z' || aktuellerBuchstabe == 'ä'
					|| aktuellerBuchstabe == 'ö' || aktuellerBuchstabe == 'ö') {
				code += 'k';
			}
			zähler++;
		}
		String analyseBeendet = dekodiereNachricht(code);
		return analyseBeendet;
	}

	public static void main(String[] args) {

		boolean programmstart = true; // Programm läuft und Rückkehr ins Hauptmenü

		while (programmstart == true) {
			println("Herzlich Willkommen im Hauptmenü! Bitte geben Sie eine Zahl ein, um Ihre gewünschte Aktion auszuführen: ");
			println("Menü 1: Botschaft verstecken");
			println("Menü 2: Botschaft sichtbar machen");
			println("Menü 3: Demo");
			println("Menü 4: Programm beeenden");
			int hauptmenue = readInt();

			if (hauptmenue == 1) {
				println("Sie sind in Menü 1: Botschaft verstecken");
				println("Bitte geben Sie eine Nachricht ein: ");
				String nachricht = readString();
				println("Bitte geben Sie ein Trägermedium ein: ");
				String traegerMedium = readString();
				println("Ihre versteckte Botschaft lautet: " + versteckeNachricht(nachricht, traegerMedium));
			} else if (hauptmenue == 2) {
				println("Sie sind in Menü 2: Botschaft sichtbar machen");
				println("Bitte geben Sie ein Steganogramm ein: ");
				String steganogramm = readString();
				println("Ihr Ergebnis lautet: " + zeigeNachricht(steganogramm));
			} else if (hauptmenue == 3) {
				println("Sie sind in Menü 3: Demo");
				String nachricht = "Treffen uns um drei Uhr am Bahnhof!";
				println("Die Nachricht lautet:“" + nachricht + "”");
				String traegerMedium = "Mein Name ist Juan Sanchez Villa-Lobos Ramirez, oberster Metallurge am Hofe König Karl V. von Spanien;ich wurde 896 vor Christus in Ägypten geboren und bin unsterblich seit 846 vor Christus.";
				println("Das Trägermedium lautet: “" + traegerMedium + "”");
				println("Die gereinigte Nachricht lautet: " + reinigeNachricht(nachricht));
				String gereinigteNachricht = reinigeNachricht(nachricht);
				println("Die kodierte Nachricht lautet: " + kodiereNachricht(gereinigteNachricht));
				String binaerCode = kodiereNachricht(gereinigteNachricht);
				println("Die dekodierte Nachricht lautet: " + dekodiereNachricht(binaerCode));
				println("Die versteckte Nachricht lautet: " + versteckeNachricht(nachricht, traegerMedium));
				String steganogramm = versteckeNachricht(nachricht, traegerMedium);
				println("Die versteckte Nachricht aus dem Text lautet: " + zeigeNachricht(steganogramm));
			} else if (hauptmenue == 4) {
				println("Sie sind in Menü 4: Programm beenden ");
				println("Das Programm wird beendet! Auf Wiedersehen! :-)");
				programmstart = false; // Programm wird in 4 beendet
			} else
				throw new PRException("Ungültige Eingabe" + hauptmenue);
		}

	}
}
