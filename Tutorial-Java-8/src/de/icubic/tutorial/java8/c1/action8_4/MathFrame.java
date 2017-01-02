package de.icubic.tutorial.java8.c1.action8_4;

import java.awt.*;

import javax.swing.*;

public class MathFrame extends JFrame {

	private final JTextField textFieldX = new JTextField( 10 );
	private final JTextField textFieldY = new JTextField( 10 );
	private final JButton buttonSum = new JButton( "Sum" );
	private final JButton buttonDiff = new JButton( "Diff" );
	private final JTextField textFieldResult = new JTextField( 10 );

	public MathFrame() {
		setLayout( new FlowLayout() );
		add( textFieldX );
		add( textFieldY );
		add( buttonSum );
		add( buttonDiff );
		add( textFieldResult );

		buttonSum.addActionListener( e -> onSum() );
		buttonDiff.addActionListener( e -> onDiff() );

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		pack();
		setVisible( true );
	}

	public void onSum() {
		try {
			int x = Integer.parseInt( textFieldX.getText() );
			int y = Integer.parseInt( textFieldY.getText() );
			int result = x + y;
			textFieldResult.setText( String.valueOf( result ) );
		} catch ( NumberFormatException e ) {
			textFieldResult.setText( "Bad input" );
		}
	}

	public void onDiff() {
		try {
			int x = Integer.parseInt( textFieldX.getText() );
			int y = Integer.parseInt( textFieldY.getText() );
			int result = x - y;
			textFieldResult.setText( String.valueOf( result ) );
		} catch ( NumberFormatException e ) {
			textFieldResult.setText( "Bad input" );
		}
	}

}
