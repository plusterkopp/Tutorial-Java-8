package de.icubic.tutorial.java8.c6.Streams_1_Intro;

import java.util.*;
import java.util.stream.*;

public class Application {

	public static void main( String[] args ) {

		final List<Integer> list = new ArrayList<>();
		for ( int i = 0; i < 10; i++ ) {
			list.add( i );
		}

		{
			Stream<Integer> stream = list.stream();
			stream.forEach( x -> System.out.print( x + " " ) );
			System.out.println();
		}
		{
			Stream<Integer> stream = list.stream();
			stream.filter( x -> x > 5 )
					.filter( x -> x % 2 == 0 )
					.forEach( x -> System.out.print( x + " " ) );
			System.out.println();
		}
		{

			Stream<Integer> stream = list.stream();
			stream.forEach( x -> System.out.print( x + " " ) );
			System.out.println();
			try {
				stream.forEach( x -> System.out.print( x + " " ) );
			} catch ( IllegalStateException e ) {
				System.out.println( "Expected: " + e );
			}
		}
		{
			Stream<Integer> stream = list.stream();
			stream.map( x -> x * 2 )
					.map( x -> x + 1 )
					.forEach( x -> System.out.print( x + " " ) );
			System.out.println();
		}
		{
			Stream<Integer> stream = list.stream();
			stream.map( x -> x * 3 )
					.filter( x -> x % 2 == 0 )
					.forEach( x -> System.out.print( x + " " ) );
			System.out.println();
		}
	}
}
