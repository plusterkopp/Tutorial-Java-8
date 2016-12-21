package de.icubic.tutorial.java8.c3.detail2_LocalRefs;

@FunctionalInterface
public interface Action<T> {
	public void execute( T arg );
}
