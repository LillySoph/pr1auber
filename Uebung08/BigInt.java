package uebung08;

import static pr.MakeItSimple.*;

public class BigInt {

	private int[] bigInt;

	// constructor & String in int Array
	BigInt(String input) {

		/*hat gefehlt*/
		
		if (input.equals("")) {
			throw new PRException("Wrong input. Please only enter numbers.");
		}
		
		// checks if all chars of entered String are digits
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) < '0' || input.charAt(i) > '9') {
				throw new PRException("Wrong input: " + input + ". Please only enter numbers.");
			}
		}

		boolean numberStarted = false;
		int firstDigit = -1;
		int numberCounter = 0;

		// stores numbers without leading zero(s) in new array
		for (int i = 0; i < input.length() && !numberStarted; i++) {
//			if (input.charAt(i) != '0' && firstDigit == -1) {
			if (input.charAt(i) != '0') {
				numberStarted = true;
				firstDigit = i;
				while (numberStarted && i < input.length()) {
					numberCounter++;
					i++;
				}
				bigInt = new int[numberCounter];
				for (i = 0; i < numberCounter; firstDigit++, i++) {
					bigInt[i] = (int) input.charAt(firstDigit) - '0';
				}
			}
		}

		// in case only a zero was entered
		if (firstDigit == -1) {
			bigInt = new int[1];
			bigInt[0] = 0;
		}
	}

	void add(BigInt number) {

		int result[];

		// if both numbers have the same length
		if (bigInt.length == number.bigInt.length) {

			result = new int[bigInt.length];

			for (int iResult = result.length - 1, iNumbers = bigInt.length - 1; iNumbers >= 0; iResult--, iNumbers--) {
				if (result[iResult] + bigInt[iNumbers] + number.bigInt[iNumbers] >= 10 && iNumbers == 0
						&& result.length <= bigInt.length) {
					result = new int[result.length + 1];
					iResult = result.length;
					iNumbers = bigInt.length;
				} else if (result[iResult] + bigInt[iNumbers] + number.bigInt[iNumbers] >= 10) {
					result[iResult] += bigInt[iNumbers] + number.bigInt[iNumbers] - 10;
					result[iResult - 1] += 1;
				} else {
					result[iResult] += bigInt[iNumbers] + number.bigInt[iNumbers];
				}
			}

		} else if (bigInt.length > number.bigInt.length) {

			result = new int[bigInt.length];

			for (int iResult = result.length - 1, iBigInt = bigInt.length - 1, iNumber = number.bigInt.length
					- 1; iBigInt >= 0; iResult--, iBigInt--, iNumber--) {
				if (((iNumber >= 0 && result[iResult] + bigInt[iBigInt] + number.bigInt[iNumber] >= 10)
						|| (iNumber < 0 && result[iResult] + bigInt[iBigInt] >= 10)) && iBigInt == 0
						&& result.length <= bigInt.length) {
					result = new int[result.length + 1];
					iResult = result.length;
					iBigInt = bigInt.length;
					
					/*iNumber .. nicht gut bei for Schleife*/
					iNumber = number.bigInt.length;
				} else if ((iNumber >= 0 && result[iResult] + bigInt[iBigInt] + number.bigInt[iNumber] >= 10)
						|| (iNumber < 0 && result[iResult] + bigInt[iBigInt] >= 10)) {
					if (iNumber < 0) {
						result[iResult] += bigInt[iBigInt] - 10;
					} else {
						result[iResult] += bigInt[iBigInt] + number.bigInt[iNumber] - 10;
					}
					result[iResult - 1] += 1;
				} else {
					if (iNumber < 0) {
						result[iResult] += bigInt[iBigInt];
					} else {
						result[iResult] += bigInt[iBigInt] + number.bigInt[iNumber];
					}
				}
			}

		} else {

			result = new int[number.getDigits().length];

			for (int iResult = result.length - 1, iBigInt = bigInt.length - 1, iNumber = number.bigInt.length
					- 1; iNumber >= 0; iResult--, iBigInt--, iNumber--) {
				if (((iBigInt >= 0 && result[iResult] + bigInt[iBigInt] + number.bigInt[iNumber] >= 10)
						|| (iBigInt < 0 && result[iResult] + number.bigInt[iNumber] >= 10)) && iNumber == 0
						&& result.length <= number.bigInt.length) {
					result = new int[result.length + 1];
					iResult = result.length;
					iBigInt = bigInt.length;
					iNumber = number.bigInt.length;
				} else if ((iBigInt >= 0 && result[iResult] + bigInt[iBigInt] + number.bigInt[iNumber] >= 10)
						|| (iBigInt < 0 && result[iResult] + number.bigInt[iNumber] >= 10)) {
					if (iBigInt < 0) {
						result[iResult] += number.bigInt[iNumber] - 10;
					} else {
						result[iResult] += bigInt[iBigInt] + number.bigInt[iNumber] - 10;
					}
					result[iResult - 1] += 1;
				} else {
					if (iBigInt < 0) {
						result[iResult] += number.bigInt[iNumber];
					} else {
						result[iResult] += bigInt[iBigInt] + number.bigInt[iNumber];
					}
				}
			}
		}

		bigInt = new int[result.length];

		for (int i = 0; i < result.length; i++) {
			bigInt[i] = result[i];
		}

	}

	@Override
	public String toString() {

		String numberAsString = "";

		for (int i = 0; i < bigInt.length; i++) {
			numberAsString += bigInt[i];
		}

		return numberAsString;

	}

	int[] getDigits() {

		return this.bigInt;

	}

	int length() {

		return bigInt.length;

	}

	boolean equals(BigInt number) {

		if (this.bigInt.length != number.getDigits().length) {
			return false;
		} else {
			for (int i = 0; i < this.bigInt.length; i++) {
				if (this.bigInt[i] != number.getDigits()[i]) {
					return false;
				}
			}
			return true;
		}

	}

	boolean greaterThan(BigInt number) {

		if (this.equals(number)) {
			return false;
		} else if (this.bigInt.length == number.getDigits().length) {
			for (int i = 0; i < this.bigInt.length; i--) {
				if (this.bigInt[i] > number.getDigits()[i]) {
					return true;
				} else if (this.bigInt[i] < number.getDigits()[i]) {
					return false;
				}
			}
		} else if (this.bigInt.length < number.getDigits().length) {
			return false;
		}

		return true;

	}

	public static void main(String[] args) {

		println("Please enter a number: ");
		BigInt bigInt = new BigInt(readString());

		println(bigInt);

		print("Please enter another number: ");
		BigInt number = new BigInt(readString());

		println("Are " + bigInt + " and " + number + " Equal? " + bigInt.equals(number));
		println("Is " + bigInt + " is greater than " + number + "? " + bigInt.greaterThan(number));

		bigInt.add(number);
		print("This is the result: " + bigInt);

	}

}
