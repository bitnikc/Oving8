package oving8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ReadGuess implements ActionListener {
	private JTextField guess;
	private JTextArea console;
	private int tries;
	private int correct;
	private List<Winner> highscore;
	private String win;
	private String getName;
	private String winList;

	public ReadGuess(JTextField guess, JTextArea console, int correct) {
		this.guess = guess;
		this.console = console;
		this.correct = correct;
		tries = 0;
		highscore = new ArrayList<Winner>();
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
					win = "Correct! You guessed it in " + (++tries)
							+ " tries! \n Play again?";
					
					if (!highscore.isEmpty()){
						if (tries <= highscore.get(highscore.size()-1).getScore()) {
							getName = JOptionPane.showInputDialog(null,
									"You got the best score!"
									+ "\nPlease enter your name!");
							highscore.add(0, new Winner(getName, tries));
						}
					}
						
					else {
						getName = JOptionPane.showInputDialog(null,
								"\nPlease enter your name!");
						highscore.add(new Winner(getName, tries));
					}
					winList = "Highscore:\n";
					for (int w = 0; w<highscore.size(); w++)
						winList += (w+1) + ". " + highscore.get(w) + "\n";
					console.setText(winList);
					
					int playAgain = JOptionPane.showConfirmDialog(null, win);
					if (playAgain == JOptionPane.YES_OPTION){
						correct = (int)(Math.random()*1000) + 1;
						tries = 0;
						console.setText(null);
					}
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
			console.setText("Please only enter an integer! (Psst, answer is " + correct + ")");
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
	
	public static void pause(int seconds){
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
		}
	}

}
