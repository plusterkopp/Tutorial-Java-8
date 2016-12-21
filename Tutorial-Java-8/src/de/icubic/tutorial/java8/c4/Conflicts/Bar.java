package de.icubic.tutorial.java8.c4.Conflicts;

public interface Bar {
	public default void f() {
		System.out.println( "Bar.f" );
	}
}
