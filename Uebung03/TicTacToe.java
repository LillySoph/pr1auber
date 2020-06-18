package uebung03;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToe extends JFrame {

	private static final String EMPTY = "";
	private static final String CROSS = "X";
	private static final String CIRCLE = "O";
	private String currentSymbol = CROSS;
	private JButton[][] fields;

	TicTacToe() {
		super("Tic Tac Toe");
		setLayout(new GridLayout(3, 3));
		fields = new JButton[3][3];
		for (int row = 0; row < fields.length; row++) {
			for (int col = 0; col < fields[row].length; col++) {
				fields[row][col] = new JButton(EMPTY);
				fields[row][col].setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 36));
				fields[row][col].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						((JButton) e.getSource()).setText(currentSymbol);
						if (draw(fields[0][0].getText(), fields[0][1].getText(), fields[0][2].getText(),
								fields[1][0].getText(), fields[1][1].getText(), fields[1][2].getText(),
								fields[2][0].getText(), fields[2][1].getText(), fields[2][2].getText())) {
							JOptionPane.showMessageDialog(TicTacToe.this, "Das Spiel endete leider unentschieden",
									"Unentschieden!", JOptionPane.INFORMATION_MESSAGE);
							System.exit(0);
						} else if (success(fields[0][0].getText(), fields[0][1].getText(), fields[0][2].getText(),
								fields[1][0].getText(), fields[1][1].getText(), fields[1][2].getText(),
								fields[2][0].getText(), fields[2][1].getText(), fields[2][2].getText())) {
							JOptionPane.showMessageDialog(TicTacToe.this,
									"Spieler '" + currentSymbol + "' hat gewonnen", "Gewonnen!",
									JOptionPane.INFORMATION_MESSAGE);
							System.exit(0);
						} else {
							toggleSymbol();
						}
					}
				});
				add(fields[row][col]);
			}
		}

		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void toggleSymbol() {
		if (currentSymbol.equals(CROSS))
			currentSymbol = CIRCLE;
		else
			currentSymbol = CROSS;
	}

	static boolean success(String topLeft, String topCenter, String topRight, String middleLeft, String middleCenter,
			String middleRight, String bottomLeft, String bottomCenter, String bottomRight){
		if (topLeft.equals(topCenter) && topLeft.equals(topRight) && !topLeft.equals(EMPTY)
		|| middleLeft.equals(middleCenter) && middleLeft.equals(middleRight) && !middleLeft.equals(EMPTY)
		|| bottomLeft.equals(bottomCenter) && bottomLeft.equals(bottomRight) && !bottomLeft.equals(EMPTY)
		|| topLeft.equals(middleLeft) && topLeft.equals(bottomLeft) && !topLeft.equals(EMPTY)
		|| topCenter.equals(middleCenter) && topCenter.equals(bottomCenter) && !topCenter.equals(EMPTY)
		|| topRight.equals(middleRight) && topRight.equals(bottomRight) && !topRight.equals(EMPTY)
		|| topLeft.equals(middleCenter) && topLeft.equals(bottomRight) && !topLeft.equals(EMPTY)
		|| topRight.equals(middleCenter) && topRight.equals(bottomLeft) && !topRight.equals(EMPTY)) 
			return true;
		else
			return false;
	}

	static boolean draw(String topLeft, String topCenter, String topRight, String middleLeft, String middleCenter,
			String middleRight, String bottomLeft, String bottomCenter, String bottomRight) {
		// Alle Felder sind befüllt
		if (!topLeft.equals(EMPTY) && !topCenter.equals(EMPTY) && !topRight.equals(EMPTY) 
		&& !middleLeft.equals(EMPTY) && !middleCenter.equals(EMPTY) && !middleRight.equals(EMPTY)
		&& !bottomLeft.equals(EMPTY) && !bottomCenter.equals(EMPTY) && !bottomRight.equals(EMPTY)) {
			// geprüft, ob jmd schon gewonnen hat
			if (success(topLeft,  topCenter,  topRight,  middleLeft,  middleCenter,
					 middleRight,  bottomLeft,  bottomCenter,  bottomRight))
						return false;
			else
				//falls niemand gewonnen hat, dann unentschieden, weil alle Felder voll sind
				return true;
		}  
		else
			//wenn nicht alle Felder befüllt sind 
			return false;
	}

	public static void main(String[] args) {
		new TicTacToe().setVisible(true);
	}

}
