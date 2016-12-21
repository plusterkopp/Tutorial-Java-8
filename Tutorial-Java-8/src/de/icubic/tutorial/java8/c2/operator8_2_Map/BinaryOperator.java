package de.icubic.tutorial.java8.c2.operator8_2_Map;

@FunctionalInterface
public interface BinaryOperator {
	public abstract int apply( int x, int y );
}
