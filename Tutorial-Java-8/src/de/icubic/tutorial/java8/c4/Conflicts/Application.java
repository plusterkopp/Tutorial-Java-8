package de.icubic.tutorial.java8.c4.Conflicts;


public class Application {
	public static void main( String[] args ) {
		Foo foo = new FooBar1();
		Bar bar = new FooBar2();
		foo.f();
		bar.f();
	}
}
