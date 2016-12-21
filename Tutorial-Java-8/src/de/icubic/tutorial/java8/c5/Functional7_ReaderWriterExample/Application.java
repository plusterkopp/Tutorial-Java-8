package de.icubic.tutorial.java8.c5.Functional7_ReaderWriterExample;

import java.io.*;
import java.util.function.*;

public class Application {

	public static void main( String[] args ) {
		{
			String input = "abc\n";
			Supplier<Character> reader = new CharacterReader( new StringReader( input ) );
			Function<Character, Character> toUpper = new ToUpper();
			Consumer<Character> writer = new CharacterWriter( new PrintWriter( System.out ) );
			process( reader, toUpper, writer );
		}
		{
			String input = "abc\n";
			Supplier<Character> reader = new CharacterReader( new StringReader( input ) );
			process( reader, ch -> Character.toUpperCase( ch ), ch -> System.out.print( ch ) );
		}
	}

	static <T, R> void process( Supplier<T> supplier, Function<T, R> function, Consumer<R> consumer ) {
		T t;
		while ( ( t = supplier.get() ) != null ) {
			R r = function.apply( t );
			consumer.accept( r );
		}
	}

}
