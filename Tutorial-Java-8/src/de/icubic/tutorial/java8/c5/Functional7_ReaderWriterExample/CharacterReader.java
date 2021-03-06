package de.icubic.tutorial.java8.c5.Functional7_ReaderWriterExample;

import java.io.*;
import java.util.function.*;

public class CharacterReader implements Supplier<Character> {

	private final Reader reader;

	public CharacterReader( Reader reader ) {
		this.reader = reader;
	}

	public Character get() {
		try {
			int ch = reader.read();
			return ch < 0 ? null : ( char ) ch;
		} catch ( Exception e ) {
			throw new RuntimeException( e );
		}
	}

}
