package de.icubic.tutorial.java8.c2.operator8_3_BiFunction;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.function.*;

public class MathFrame extends JFrame {

	private final Map<String, BiFunction<Integer, Integer, Integer>> operators = new LinkedHashMap<>();
	private final JTextField textFieldX = new JTextField( 10 );
	private final JTextField textFieldY = new JTextField( 10 );
	private final JTextField textFieldResult = new JTextField( 10 );
	public MathFrame() {
		this.setLayout( new FlowLayout() );
		this.add( this.textFieldX );
		this.add( this.textFieldY );
		this.addButtons();
		this.add( this.textFieldResult );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.pack();
		this.setVisible( true );
	}

	private void addButtons() {
		for ( Map.Entry<String, BiFunction<Integer, Integer, Integer>> entry : operators.entrySet() ) {
			JButton button = new JButton( entry.getKey() );
			button.addActionListener( e -> onCalc( entry.getValue() ) );
			this.add( button );
		}
	}

	private void onCalc( BiFunction<Integer, Integer, Integer> op ) {
		try {
			int x = Integer.parseInt( this.textFieldX.getText() );
			int y = Integer.parseInt( this.textFieldY.getText() );
			int result = op.apply( x, y );
			this.textFieldResult.setText( String.valueOf( result ) );
		} catch ( Exception e ) {
			this.textFieldResult.setText( "Illegal input" );
		}
	}

	{
		operators.put( "Plus", ( x, y ) -> x + y );
		operators.put( "Minus", ( x, y ) -> x - y );
		operators.put( "Times", ( x, y ) -> x * y );
		operators.put( "Div", ( x, y ) -> x / y );
	}
}
