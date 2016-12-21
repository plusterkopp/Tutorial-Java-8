package de.icubic.tutorial.java8.c6.Streams_8_Stateless;

import static java.lang.System.*;

import java.util.*;
import java.util.stream.*;

import de.icubic.tutorial.java8.util.*;

public class Application {

	public static void main( String[] args) {
		{
			out.println( "---------------------------------");
			List<Integer> source = Arrays.asList( 10, 11, 12, 13, 14, 15);
			List<Integer> result = new ArrayList<>();
			Stream<Integer> s = source.stream()
					.filter( x -> x % 2 == 0);
			s.forEach( x -> result.add( x));
			result.stream()
			.forEach( x -> out.print( x + " "));
			out.println();
		}
		{
			out.println( "---------------------------------");
			List<Integer> source = Arrays.asList( 10, 11, 12, 13, 14, 15);
			List<Integer> result = new ArrayList<Integer>() {
				@Override
				public boolean add( Integer value) {
					ThreadUtil.sleep( 100);
					out.println( "==> " + Thread.currentThread().getId());
					synchronized ( this) {
						return super.add( value);
					}
				}
			};
			source.parallelStream()
			.filter( x -> x % 2 == 0)
			.forEach( x -> result.add( x));
			result.stream()
			.forEach( x -> out.print( x + " "));
			out.println();
		}

	}
}
