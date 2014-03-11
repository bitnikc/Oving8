package oving8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ReadGuess implements ActionListener {
	private JTextField guess;
	private JTextArea console;
	private int correct;

	public ReadGuess(JTextField guess, JTextArea console, int correct) {
		this.guess = guess;
		this.console = console;
		this.correct = correct;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int check = 0;
		try {
			check = Integer.parseInt(guess.getText());
			if (check != 0){
				console.setText("Guess is " + check);
			}
			
		} catch (NumberFormatException e) {
			console.setText("Please only enter an integer");
		} catch (NegativeNumberException e) {
			
		}
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return guess.getText();
	}

}
