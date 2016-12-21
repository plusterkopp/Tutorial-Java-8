package de.icubic.tutorial.java8.c3.detail1_MethodRefs;

@FunctionalInterface
public interface Action<T> {
	public void execute( T arg );
}
