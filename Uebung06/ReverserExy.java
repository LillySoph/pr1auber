package uebung06;

import static pr.MakeItSimple.*;

public class ReverserExy {

	static boolean checkIfLetter(char letter) {

		// Sonderzeichen und Satzzeichen werden weggelassen, nur Buchstaben werden
		// zugelassen

		return (letter >= 'A' && letter <= 'Z' || letter >= 'a' && letter <= 'z' || letter == 'Ä' || letter == 'ä'
				|| letter == 'Ö' || letter == 'ö' || letter == 'Ü' || letter == 'ü' || letter == 'ß');
	}

	static String reverseSentence(String sentence) {

// Hallo welt --> welt hallo (Laenge 10)
		int letterPosition = 0;
		String output = "";
		String reversedSentence = "";

		while (letterPosition < sentence.length()) {
			// Position 0 < (10)
			if (checkIfLetter(sentence.charAt(letterPosition))) {
				// Stelle 0 > H ==true
				while (letterPosition < sentence.length() && checkIfLetter(sentence.charAt(letterPosition))) {
					output += sentence.charAt(letterPosition); // H + " ".. // Hi+.....
					// output = sentence...+output; --> reverse each word
					letterPosition++;
				}

			} else if (!checkIfLetter(sentence.charAt(letterPosition))) {

				// Stelle 0 > " " ==false
				output += "";
				while (letterPosition < sentence.length() && !checkIfLetter(sentence.charAt(letterPosition))) {
					letterPosition++; // soll Zeichen zusammenfügen
				}
			}
			reversedSentence = output + reversedSentence;

			// Hier werden die Wörter vertauscht
			output = " ";
			// altes Wort lsöchen und neues vertauschtes Wort hinzufügen

		}
		return reversedSentence;
	}

	public static void main(String[] args) {
		print("Please enter a sentence to reverse: ");
		String sentence = readString();

		println("Your reversed sentence is: " + reverseSentence(sentence));

	}

}
