package uebung08;

public class Ball {

	private int positionX = 3;
	private int positionY = 2;
	private String ball = "o";
	private int directionX = 1;
	private int directionY = -1;

	Ball() {
	}

	void addInPlayground(String[][] field) {

		for (int indexY = 0; indexY < field.length; indexY++) {
			for (int indexX = 0; indexX < field.length; indexX++) {
				field[indexY][indexX] = " ";
			}
		}
		field[positionY][positionX] = ball;

	}

	int move() {

		int counter = 0;

		if (positionX == 0 || positionX == 9) {
			directionX *= (-1);
		}

		if (positionY == 9 || positionY == 0) {
			directionY *= (-1);
			if (positionY == 9) {
				counter++;
			}
		}

		positionX += directionX;
		positionY += directionY;
		return counter;
	}
}
