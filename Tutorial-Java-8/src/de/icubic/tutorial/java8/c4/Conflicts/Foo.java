package de.icubic.tutorial.java8.c4.Conflicts;

public interface Foo {
	public default void f() {
		System.out.println("Foo.f");
	}
}
