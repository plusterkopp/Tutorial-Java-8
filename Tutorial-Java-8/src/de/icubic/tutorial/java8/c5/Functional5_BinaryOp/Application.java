package de.icubic.tutorial.java8.c5.Functional5_BinaryOp;

import java.util.function.*;

public class Application {
	public static void main( String[] args ) {
		{
			BinaryOperator<Integer> op = new BinaryOperator<Integer>() {
				public Integer apply( Integer x, Integer y ) {
					return x + y;
				}
			};
			System.out.println( op.apply( 40, 2 ) ); // -> 42
		}
		{
			BinaryOperator<Integer> op = ( x, y ) -> x + y;
			System.out.println( op.apply( 40, 2 ) ); // -> 42
		}
		{
			BinaryOperator<String> min = BinaryOperator.minBy( ( x, y ) -> x.compareTo( y ) );
			BinaryOperator<String> max = BinaryOperator.maxBy( ( x, y ) -> x.compareTo( y ) );
			System.out.println( min.apply( "Hello", "World" ) ); // -> "Hello"
			System.out.println( max.apply( "Hello", "World" ) ); // -> "World"
		}

		{
			IntBinaryOperator op = ( x, y ) -> x + y;
			System.out.println( op.applyAsInt( 40, 2 ) ); // 42
		}

		{
			DoubleBinaryOperator op = ( x, y ) -> x + y;
			System.out.println( op.applyAsDouble( 40, 2 ) );  // -> 42.0
		}

	}
}
