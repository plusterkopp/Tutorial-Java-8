package de.icubic.tutorial.java8.c3.Comparator1;

import java.util.*;

public class Book {
	public static final List<Book> List = new ArrayList<>();
	public String isbn;
	public String title;
	public String author;
	public double price;

	public Book( String isbn, String title, String author, double price ) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [" + isbn + ", " + title + ", " + author + ", " + price + "]";
	}

	static {
		List.add( new Book( "1111", "Pascal", "Wirth", 44.44 ) );
		List.add( new Book( "2222", "Modula", "Wirth", 33.33 ) );
		List.add( new Book( "3333", "Oberon", "Wirth", 22.22 ) );
		List.add( new Book( "4444", "Eiffel", "Meyer", 11.11 ) );
	}
}
