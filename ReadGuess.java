package oving8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ReadGuess implements ActionListener {
	private JTextField guess;
	private JTextArea console;
	private int tries;
	private int correct;

	public ReadGuess(JTextField guess, JTextArea console, int correct) {
		this.guess = guess;
		this.console = console;
		this.correct = correct;
		tries = 0;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int check = 0;
		try {
			check = Integer.parseInt(guess.getText());
			if (check < 1 || check > 1000)
				throw new NegativeNumberException();
			else {
				if (check == correct){
					console.setText("Correct! You guessed it in " + (++tries) + " tries!");
				}
				else{
					tries++;
					if (check < correct)
						console.setText(check + " is too low");
					else
						console.setText(check + " is too high");
				}
			}
			
		} catch (NumberFormatException e) {
			console.setText("Please only enter an integer");
		} catch (NegativeNumberException e) {
			console.setText("Only enter a numbers between 1 and 1000!");
		}
		guess.selectAll();
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return guess.getText();
	}

}
