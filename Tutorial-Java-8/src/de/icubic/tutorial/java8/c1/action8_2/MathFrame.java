package de.icubic.tutorial.java8.c1.action8_2;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MathFrame extends JFrame {

	private final JTextField textFieldX = new JTextField( 10);
	private final JTextField textFieldY = new JTextField( 10);
	private final JButton buttonSum = new JButton( "Sum");
	private final JButton buttonDiff = new JButton( "Diff");
	private final JTextField textFieldResult = new JTextField( 10);

	public MathFrame() {
		setLayout( new FlowLayout());
		this.add( textFieldX);
		this.add( textFieldY);
		this.add( buttonSum);
		this.add( buttonDiff);
		this.add( textFieldResult);

		buttonSum.addActionListener( ( ActionEvent e) -> onSum());
		buttonDiff.addActionListener( ( ActionEvent e) -> onDiff());

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible( true);
	}

	public void onSum() {
		try {
			int x = Integer.parseInt( textFieldX.getText());
			int y = Integer.parseInt( textFieldY.getText());
			int result = x + y;
			textFieldResult.setText( String.valueOf( result));
		} catch ( NumberFormatException e) {
			textFieldResult.setText( "Bad input");
		}
	}

	public void onDiff() {
		try {
			int x = Integer.parseInt( textFieldX.getText());
			int y = Integer.parseInt( textFieldY.getText());
			int result = x - y;
			textFieldResult.setText( String.valueOf( result));
		} catch ( NumberFormatException e) {
			textFieldResult.setText( "Bad input");
		}
	}

}
