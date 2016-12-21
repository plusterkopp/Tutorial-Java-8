package de.icubic.tutorial.java8.c6.Streams_7_ParallelPerf;

import java.util.*;
import java.util.stream.*;

import de.icubic.tutorial.java8.util.*;

public class Application {

	public static void main( String[] args) {

		final int size = 1000;
		final int loops = 5;
		final int sleepTime = 1;

		final List<Integer> list = new ArrayList<>();
		for ( int i = 0; i < size; i++) {
			list.add( i);
		}

		final ThreadStatisticRunner runner = new ThreadStatisticRunner();

		runner.run( "List forEach", loops, () -> {
			list.forEach( x -> {
				runner.step( () -> ThreadUtil.sleep( sleepTime));
			});
		});
		runner.run( "sequential Stream forEach ", loops, () -> {
			Stream<Integer> stream = list.stream();
			stream.forEach( x -> {
				runner.step( () -> ThreadUtil.sleep( sleepTime));
			});
		});
		runner.run( "parallel Stream forEach", loops, () -> {
			Stream<Integer> stream = list.parallelStream();
			stream.forEach( x -> {
				runner.step( () -> ThreadUtil.sleep( sleepTime));
			});
		});
	}

}
