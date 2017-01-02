package de.icubic.tutorial.java8.c1.action7;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MathFrame extends JFrame {

	private final JTextField textFieldX = new JTextField( 10);
	private final JTextField textFieldY = new JTextField( 10);
	private final JButton buttonPlus = new JButton( "Plus");
	private final JButton buttonMinus = new JButton( "Minus");
	private final JTextField textFieldResult = new JTextField( 10);

	public MathFrame() {
		setLayout( new FlowLayout());
		add( textFieldX);
		add( textFieldY);
		add( buttonPlus);
		add( buttonMinus);
		add( textFieldResult);
		registerListeners();
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible( true);
	}

	private void registerListeners() {
		buttonPlus.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent e) {
				MathFrame.this.onPlus();
			}
		});
		buttonMinus.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent e) {
				MathFrame.this.onMinus();
			}
		});
	}

	private void onPlus() {
		try {
			int x = Integer.parseInt( textFieldX.getText());
			int y = Integer.parseInt( textFieldY.getText());
			int result = x + y;
			textFieldResult.setText( String.valueOf( result));
		} catch ( NumberFormatException e) {
			textFieldResult.setText( "Illegal input");
		}
	}

	private void onMinus() {
		try {
			int x = Integer.parseInt( textFieldX.getText());
			int y = Integer.parseInt( textFieldY.getText());
			int result = x - y;
			textFieldResult.setText( String.valueOf( result));
		} catch ( NumberFormatException e) {
			textFieldResult.setText( "Illegal input");
		}
	}

}
