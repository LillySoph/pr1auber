package uebung05;

import static pr.MakeItSimple.*;

public class BaconKodierer {
	// a) Hallo Welt! --> HALLOWELT
	static String reinigeNachricht(String nachricht) {

		int position = 0;
		String ergebnis = "";

		while (position < nachricht.length()) {

			char aktuellesZeichen = nachricht.charAt(position);

			if (aktuellesZeichen >= 'A' && aktuellesZeichen <= 'Z') {
				ergebnis += aktuellesZeichen;
			} else if (aktuellesZeichen >= 'a' && aktuellesZeichen <= 'z') {
				aktuellesZeichen = (char) (aktuellesZeichen - 'a' + 'A');
				ergebnis += aktuellesZeichen;
			} else if (aktuellesZeichen == 'Ä' || aktuellesZeichen == 'ä') {
				ergebnis += "AE";
			} else if (aktuellesZeichen == 'Ö' || aktuellesZeichen == 'ö') {
				ergebnis += "OE";
			} else if (aktuellesZeichen == 'Ü' || aktuellesZeichen == 'ü') {
				ergebnis += "UE";
			} else if (aktuellesZeichen == 'ß') {
				ergebnis += "SS";
			}

			position++;
		}
		return ergebnis;
	}

	// b) HALLOWELT --> kkgggkkkkk...
	static String kodiereNachricht(String gereinigteNachricht) {
		int position = 0;

		String ergebnis = "";
		while (position < gereinigteNachricht.length()) {

			char aktuellesZeichen = gereinigteNachricht.charAt(position);

			if (aktuellesZeichen < 'A' || aktuellesZeichen > 'Z')
				throw new PRException("Die Eingabe " + gereinigteNachricht + " ist ungültig. ");
			else if (aktuellesZeichen == 'A')
				ergebnis = ergebnis + "kkkkk";
			else if (aktuellesZeichen == 'B')
				ergebnis = ergebnis + "kkkkg";
			else if (aktuellesZeichen == 'C')
				ergebnis = ergebnis + "kkkgk";
			else if (aktuellesZeichen == 'D')
				ergebnis = ergebnis + "kkkgg";
			else if (aktuellesZeichen == 'E')
				ergebnis = ergebnis + "kkgkk";
			else if (aktuellesZeichen == 'F')
				ergebnis = ergebnis + "kkgkg";
			else if (aktuellesZeichen == 'G')
				ergebnis = ergebnis + "kkggk";
			else if (aktuellesZeichen == 'H')
				ergebnis = ergebnis + "kkggg";
			else if (aktuellesZeichen == 'I' || aktuellesZeichen == 'J')
				ergebnis = ergebnis + "kgkkk";
			else if (aktuellesZeichen == 'K')
				ergebnis = ergebnis + "kgkkg";
			else if (aktuellesZeichen == 'L')
				ergebnis = ergebnis + "kgkgk";
			else if (aktuellesZeichen == 'M')
				ergebnis = ergebnis + "kgkgg";
			else if (aktuellesZeichen == 'N')
				ergebnis = ergebnis + "kggkk";
			else if (aktuellesZeichen == 'O')
				ergebnis = ergebnis + "kggkg";
			else if (aktuellesZeichen == 'P')
				ergebnis = ergebnis + "kgggk";
			else if (aktuellesZeichen == 'Q')
				ergebnis = ergebnis + "kgggg";
			else if (aktuellesZeichen == 'R')
				ergebnis = ergebnis + "gkkkk";
			else if (aktuellesZeichen == 'S')
				ergebnis = ergebnis + "gkkkg";
			else if (aktuellesZeichen == 'T')
				ergebnis = ergebnis + "gkkgk";
			else if (aktuellesZeichen == 'U' || aktuellesZeichen == 'V')
				ergebnis = ergebnis + "gkkgg";
			else if (aktuellesZeichen == 'W')
				ergebnis = ergebnis + "gkgkk";
			else if (aktuellesZeichen == 'X')
				ergebnis = ergebnis + "gkgkg";
			else if (aktuellesZeichen == 'Y')
				ergebnis = ergebnis + "gkggk";
			else if (aktuellesZeichen == 'Z')
				ergebnis = ergebnis + "gkggg";

			position++;
		}
		return ergebnis;

	}

	// c) kkgggkkkkk... --> HALLOWELT
	static String dekodiereNachricht(String binaerCode) {

		int laengeDurch5Teilbar = binaerCode.length() - (binaerCode.length() % 5);
		int position = 0;
		String ergebnis = "";

		while (position < laengeDurch5Teilbar) {

			String fuenferBlock = (String) "" + binaerCode.charAt(position) + binaerCode.charAt(position + 1)
					+ binaerCode.charAt(position + 2) + binaerCode.charAt(position + 3)
					+ binaerCode.charAt(position + 4);

			if (fuenferBlock.equals("kkkkk"))
				ergebnis += 'A';
			else if (fuenferBlock.equals("kkkkg"))
				ergebnis += 'B';
			else if (fuenferBlock.equals("kkkgk"))
				ergebnis += 'C';
			else if (fuenferBlock.equals("kkkgg"))
				ergebnis += 'D';
			else if (fuenferBlock.equals("kkgkk"))
				ergebnis += 'E';
			else if (fuenferBlock.equals("kkgkg"))
				ergebnis += 'F';
			else if (fuenferBlock.equals("kkggk"))
				ergebnis += 'G';
			else if (fuenferBlock.equals("kkggg"))
				ergebnis += 'H';
			else if (fuenferBlock.equals("kgkkk"))
				ergebnis += 'I';
			else if (fuenferBlock.equals("kgkkg"))
				ergebnis += 'K';
			else if (fuenferBlock.equals("kgkgk"))
				ergebnis += 'L';
			else if (fuenferBlock.equals("kgkgg"))
				ergebnis += 'M';
			else if (fuenferBlock.equals("kggkk"))
				ergebnis += 'N';
			else if (fuenferBlock.equals("kggkg"))
				ergebnis += 'O';
			else if (fuenferBlock.equals("kgggk"))
				ergebnis += 'P';
			else if (fuenferBlock.equals("kgggg"))
				ergebnis += 'Q';
			else if (fuenferBlock.equals("gkkkk"))
				ergebnis += 'R';
			else if (fuenferBlock.equals("gkkkg"))
				ergebnis += 'S';
			else if (fuenferBlock.equals("gkkgk"))
				ergebnis += 'T';
			else if (fuenferBlock.equals("gkkgg"))
				ergebnis += 'U';
			else if (fuenferBlock.equals("gkgkk"))
				ergebnis += 'W';
			else if (fuenferBlock.equals("gkgkg"))
				ergebnis += 'X';
			else if (fuenferBlock.equals("gkggk"))
				ergebnis += 'Y';
			else if (fuenferBlock.equals("gkggg"))
				ergebnis += 'Z';
			else
				ergebnis += '#';

			position += 5;
		}
		return ergebnis;
	}

	// d) Hallo Welt & Es ist traurig... --> es IST trauriG..
	static String versteckeNachricht(String nachricht, String traegerMedium) {

		String kodierteNachricht = kodiereNachricht(reinigeNachricht(nachricht));

		int positionMedium = 0;
		int buchstabenAnzahl = 0;

		while (positionMedium < traegerMedium.length()) {
			char zeichenPruefen = traegerMedium.charAt(positionMedium);
			if (zeichenPruefen >= 'A' && zeichenPruefen <= 'Z' || zeichenPruefen >= 'a' && zeichenPruefen <= 'z'
					|| zeichenPruefen == 'Ä' || zeichenPruefen == 'ä' || zeichenPruefen == 'Ö' || zeichenPruefen == 'ö'
					|| zeichenPruefen == 'Ü' || zeichenPruefen == 'ü')
				buchstabenAnzahl++;
			positionMedium++;
		}
		if (buchstabenAnzahl < kodierteNachricht.length())
			throw new PRException("Das Trägermedium ist zu kurz. ");

		positionMedium = 0;
		int positionKodiert = 0;

		String ergebnis = "";

		while (positionKodiert < kodierteNachricht.length()) {

			char zeichenKodiert = kodierteNachricht.charAt(positionKodiert);
			char zeichenMedium = traegerMedium.charAt(positionMedium);

			if (zeichenKodiert == 'k') {
				if (zeichenMedium >= 'A' && zeichenMedium <= 'Z') {
					zeichenMedium = (char) (zeichenMedium + 'a' - 'A');
					ergebnis += zeichenMedium;
				} else if (zeichenMedium >= 'a' && zeichenMedium <= 'z') {
					ergebnis += zeichenMedium;
				} else if (zeichenMedium == 'Ä' || zeichenMedium == 'ä') {
					ergebnis += 'ä';
				} else if (zeichenMedium == 'Ö' || zeichenMedium == 'ö') {
					ergebnis += 'ö';
				} else if (zeichenMedium == 'Ü' || zeichenMedium == 'ü') {
					ergebnis += 'ü';
				} else {
					ergebnis += zeichenMedium;
					positionKodiert--;
				}
			} else if (zeichenKodiert == 'g') {
				if (zeichenMedium >= 'A' && zeichenMedium <= 'Z') {
					ergebnis += zeichenMedium;
				} else if (zeichenMedium >= 'a' && zeichenMedium <= 'z') {
					zeichenMedium = (char) (zeichenMedium - 'a' + 'A');
					ergebnis += zeichenMedium;
				} else if (zeichenMedium == 'Ä' || zeichenMedium == 'ä') {
					ergebnis += 'Ä';
				} else if (zeichenMedium == 'Ö' || zeichenMedium == 'ö') {
					ergebnis += 'Ö';
				} else if (zeichenMedium == 'Ü' || zeichenMedium == 'ü') {
					ergebnis += 'Ü';
				} else {
					ergebnis += zeichenMedium;
					positionKodiert--;
				}
			}
			positionKodiert++;
			positionMedium++;
		}
		while (ergebnis.length() < traegerMedium.length()) {
			ergebnis += traegerMedium.charAt(positionMedium);
			positionMedium++;
		}
		return ergebnis;
	}

	// e) es IST trauriG... --> HALLOWELT
	static String zeigeNachricht(String steganogramm) {

		int position = 0;
		String binaerCode = "";

		while (position < steganogramm.length()) {
			char aktuellesZeichen = steganogramm.charAt(position);

			if (aktuellesZeichen >= 'A' && aktuellesZeichen <= 'Z' || aktuellesZeichen == 'Ä' || aktuellesZeichen == 'Ö'
					|| aktuellesZeichen == 'Ü') {
				binaerCode += 'g';
			} else if (aktuellesZeichen >= 'a' && aktuellesZeichen <= 'z' || aktuellesZeichen == 'ä'
					|| aktuellesZeichen == 'ö' || aktuellesZeichen == 'ü') {
				binaerCode += 'k';
			}
			position++;
		}
		return dekodiereNachricht(binaerCode);
	}

	public static void main(String[] args) {

		int menu = 0;

		while (menu != 4) {
			println("Bitte wählen Sie die gewünschte Aktion aus, indem Sie die entsprechende Zahl eingeben: ");
			println("1. Botschaft verstecken");
			println("2. Botschaft sichtbar machen");
			println("3. Demo");
			println("4. Programm beenden");
			menu = readInt();

			if (menu == 1) {
				println("* Botschaft verstecken *");
				print("Bitte geben Sie Ihre Nachricht ein: ");
				String nachricht = readString();
				print("Bitte geben Sie Ihr Trägermedium ein: ");
				String traegerMedium = readString();
				println("Hier ist das Ergebnis: " + versteckeNachricht(nachricht, traegerMedium));
				println("");
			} else if (menu == 2) {
				println("* Botschaft sichtbar machen *");
				println("Bitte geben Sie ein beliebiges Steganogramm ein: ");
				String steganogramm = readString();
				println("Hier ist das Ergebnis: " + zeigeNachricht(steganogramm));
				println("");
			} else if (menu == 3) {
				println("* Demo *");
				String nachricht = "Treffen uns um drei Uhr am Bahnhof!";
				println("Die Nachricht lautet: “" + nachricht + "”");
				String traegerMedium = "Mein Name ist Juan Sanchez Villa-Lobos Ramirez, oberster Metallurge am Hofe König Karl V. von Spanien; ich wurde 896 vor Christus in Ägypten geboren und bin unsterblich seit 846 vor Christus.";
				println("Das Trägermedium lautet: “" + traegerMedium + "”");
				println("");
				String gereinigteNachricht = reinigeNachricht(nachricht);
				println("Hier ist die gereinigte Nachricht: " + gereinigteNachricht);
				String binaerCode = kodiereNachricht(gereinigteNachricht);
				println("Hier ist die kodierte Nachricht: " + binaerCode);
				String dekodierteNachricht = dekodiereNachricht(binaerCode);
				println("Hier ist die dekodierte Nachricht: " + dekodierteNachricht);
				String steganogramm = versteckeNachricht(nachricht, traegerMedium);
				println("Hier das Ergebnis mit der versteckten Nachricht: " + steganogramm);
				String zeigeNachricht = zeigeNachricht(steganogramm);
				println("Hier ist die versteckte Nachricht aus dem Text: " + zeigeNachricht);
				println("");
			} else if (menu == 4) {
				println("* Programm beenden *");
				println("Das Programm wird beendet. ");
			} else {
				throw new PRException("Ungültige Eingabe: " + menu);
			}
		}
	}
}
