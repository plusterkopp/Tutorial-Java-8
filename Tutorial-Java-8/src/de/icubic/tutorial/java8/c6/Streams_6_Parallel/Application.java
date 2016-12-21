package de.icubic.tutorial.java8.c6.Streams_6_Parallel;

import java.util.*;
import java.util.stream.*;

public class Application {

	public static void main( String[] args) {

		final List<Integer> list = new ArrayList<>();
		for ( int i = 0; i < 10; i++) {
			list.add( i);
		}

		{
			list.forEach( x -> System.out.print( x + " "));
			System.out.println();
		}
		{
			Stream<Integer> stream = list.stream();
			stream.forEach( x -> System.out.print( x + " "));
			System.out.println();
		}
		{
			Stream<Integer> stream = list.parallelStream();
			stream.forEach( x -> System.out.print( x + " "));
			System.out.println();
		}
		{
			Stream<Integer> stream = list.parallelStream();
			stream.forEach( x -> System.out.println( x + " (" + Thread.currentThread().getId() + ")"));
		}

		{
			Stream<Integer> stream = list.stream();
			stream.parallel().forEach( x -> System.out.print( x + " "));
			System.out.println();
		}
		{
			Stream<Integer> stream = list.stream();
			stream.parallel().sequential().forEach( x -> System.out.print( x + " "));
			System.out.println();
		}
		{
			Stream<Integer> stream = list.stream();
			stream.parallel().filter( x -> x % 2 == 0).sequential().forEach( x -> System.out.print( x + " "));
		}
	}

}
