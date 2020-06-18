package uebung04;

import static pr.MakeItSimple.*;

public class NumberSeparator {

	public static String splitNumber(int numbers) {

		// Für den Fall, dass 0 eingegeben wird

		String zero = "+,0";
		if (numbers == 0)
			return zero;

		// Vorzeichen ermitteln

		String sign;

		if (numbers > 0) {
			sign = "+";
		} else {
			sign = "-";

		}

		int modulo = 0;
		String result = "";

		while (numbers != 0) {
			modulo = numbers % 10;
			numbers = numbers / 10;
			result = " , " + modulo + result;
		}

		result = sign + result;

		return result;

	}

	public static void main(String[] args) {

		print("Please enter an integer: ");
		int numbers = readInt();
		println(splitNumber(numbers));
	}
}
