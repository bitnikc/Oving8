package oving8;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Innlev8Main {

	public static void main(String[] args) {
		
		JFrame leBox = new JFrame("Guess the Number");
		leBox.setLayout(new FlowLayout());
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		JLabel leQuestion = new JLabel("What's you guess?  (Number from 1 to 1000)");
		JTextField leTextField = new JTextField(5);
		JTextArea leConsole = new JTextArea(1,29);
		JButton leButton = new JButton("Guess");
		
		leBox.add(leQuestion);
		leBox.add(leTextField);
		leBox.add(leConsole);
		leBox.add(leButton);
		
		setVisuals(leBox, dim, leQuestion, leConsole);
		
		int randomNumber = (int)(Math.random()*1000) +1;
		ReadGuess leGuess = new ReadGuess(leTextField, leConsole, randomNumber);
		leButton.addActionListener(leGuess);
		leTextField.addActionListener(leGuess);
		
		leConsole.setText(leGuess.toString());
		
		leBox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//leBox.pack();
		leBox.setVisible(true);

	}

	private static void setVisuals(JFrame leBox, Dimension dim,
			JLabel leQuestion, JTextArea leConsole) {
		leQuestion.setForeground(Color.WHITE);
		leConsole.setBackground(new Color(0.0f,0.0f,0.0f,1.0f));
		leConsole.setForeground(Color.WHITE);
		leConsole.setLineWrap(true);
		leConsole.setWrapStyleWord(true);
		leBox.setUndecorated(true);
		//leBox.setShape(new RoundRectangle2D.Double(10, 10, 100, 100, 50, 50));
		leBox.setSize(350, 90);
		leBox.setBackground(new Color(0.0f,0.0f,0.0f,1.0f));
		leBox.setLocation(dim.width/2-leBox.getSize().width/2, dim.height/2-leBox.getSize().height/2);
	}

}
