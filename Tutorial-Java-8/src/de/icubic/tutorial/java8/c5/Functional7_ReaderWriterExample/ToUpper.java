package de.icubic.tutorial.java8.c5.Functional7_ReaderWriterExample;

import java.util.function.*;

public class ToUpper implements Function<Character, Character> {

	public Character apply( Character ch ) {
		return Character.toUpperCase( ch );
	}

}
