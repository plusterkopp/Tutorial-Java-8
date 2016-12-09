package de.icubic.tutorial.java8.c3.methodRefs;

@FunctionalInterface
public interface Action<T> {
	public void execute(T arg);
}
