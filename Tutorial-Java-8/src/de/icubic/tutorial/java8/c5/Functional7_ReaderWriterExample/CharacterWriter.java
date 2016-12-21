package de.icubic.tutorial.java8.c5.Functional7_ReaderWriterExample;

import java.io.*;
import java.util.function.*;

public class CharacterWriter implements Consumer<Character> {

	private final Writer writer;

	public CharacterWriter( Writer writer ) {
		this.writer = writer;
	}

	public void accept( Character ch ) {
		try {
			writer.write( ch );
			writer.flush();
		} catch ( IOException e ) {
			throw new RuntimeException( e );
		}
	}

}
