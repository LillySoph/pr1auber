package uebung06;

import static pr.MakeItSimple.*;

public class Reverser {

	static boolean checkIfLetter(char checkChar) {
		return (checkChar >= 'A' && checkChar <= 'Z' || checkChar >= 'a' && checkChar <= 'z' || checkChar == 'Ä'
				|| checkChar == 'ä' || checkChar == 'Ö' || checkChar == 'ö' || checkChar == 'Ü' || checkChar == 'ü'
				|| checkChar == 'ß');
	}

	static String reverseSentence(String sentence) {

		int index = 0;
		String result = "";
		String word = "";

		while (index < sentence.length()) {
			// wenn nicht-Buchstabe, einmal Leerzeichen, rest ignorieren
			if (!checkIfLetter(sentence.charAt(index))) {
				word += " ";
				while (index < sentence.length() && !checkIfLetter(sentence.charAt(index))) {
					index++;
				}
				
			} else if (checkIfLetter(sentence.charAt(index))) {
				while (index < sentence.length() && checkIfLetter(sentence.charAt(index))) {
					word += sentence.charAt(index);
					index++;
				}
			}
			
			result = word + result;
			word = "";
		}
		return result;

	}

	public static void main(String[] args) {

		print("Please enter your Sentence: ");
		String sentence = readString();

		print("Here is your reversed Sentence: " + reverseSentence(sentence));

	}
}
