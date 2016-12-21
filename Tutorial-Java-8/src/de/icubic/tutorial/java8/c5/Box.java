package de.icubic.tutorial.java8.c5;

public class Box<T> {
	private T value;

	public Box( T value ) {
		this.value = value;
	}

	public void set( T value ) {
		this.value = value;
	}

	public T get() {
		return this.value;
	}
}
