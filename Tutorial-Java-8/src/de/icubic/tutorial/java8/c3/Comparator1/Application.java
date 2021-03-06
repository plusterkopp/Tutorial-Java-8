package de.icubic.tutorial.java8.c3.Comparator1;

import java.util.*;

public class Application {

	public static void main( String[] args ) {
		demo1();
		System.out.println( "-----------------------" );
		demo2();
	}

	static void demo1() {
		Collections.sort( Book.List, new Comparator<Book>() {
			public int compare( Book b1, Book b2 ) {
				return b1.title.compareTo( b2.title );
			}
		} );
		for ( Book b : Book.List ) {
			System.out.println( b );
		}
	}

	static void demo2() {
		Collections.sort( Book.List, ( b1, b2 ) -> - b1.title.compareTo( b2.title ) );
		for ( Book b : Book.List ) {
			System.out.println( b );
		}
	}
}
