package de.icubic.tutorial.java8.c4.Conflicts;

public class FooBar2 implements Foo, Bar {
	public void f() {
		Foo.super.f();
		Bar.super.f();
	}
}
