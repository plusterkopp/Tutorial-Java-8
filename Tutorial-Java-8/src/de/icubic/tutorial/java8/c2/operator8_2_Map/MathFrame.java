package de.icubic.tutorial.java8.c2.operator8_2_Map;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MathFrame extends JFrame {

	private final Map<String, BinaryOperator> operators = new LinkedHashMap<>();
	private final JTextField textFieldX = new JTextField( 10 );
	private final JTextField textFieldY = new JTextField( 10 );
	private final JTextField textFieldResult = new JTextField( 10 );
	public MathFrame() {
		setLayout( new FlowLayout() );
		add( textFieldX );
		add( textFieldY );
		addButtons();
		add( textFieldResult );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		pack();
		setVisible( true );
	}

	private void addButtons() {
		for ( Map.Entry<String, BinaryOperator> entry : operators.entrySet() ) {
			JButton button = new JButton( entry.getKey() );
			button.addActionListener( e -> onCalc( entry.getValue() ) );
			this.add( button );
		}
	}

	private void onCalc( BinaryOperator op ) {
		try {
			int x = Integer.parseInt( textFieldX.getText() );
			int y = Integer.parseInt( textFieldY.getText() );
			int result = op.apply( x, y );
			textFieldResult.setText( String.valueOf( result ) );
		} catch ( Exception e ) {
			textFieldResult.setText( "Illegal input" );
		}
	}

	{
		operators.put( "Plus", ( x, y ) -> x + y );
		operators.put( "Minus", ( x, y ) -> x - y );
		operators.put( "Times", ( x, y ) -> x * y );
		operators.put( "Div", ( x, y ) -> x / y );
	}
}
