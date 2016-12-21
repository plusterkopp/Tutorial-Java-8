package de.icubic.tutorial.java8.util;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class ThreadStatisticRunner {

	private final Map<Thread, Item> items = new ConcurrentHashMap<>();
	private final PrintStream out = System.out;

	public static void main( String[] args ) {
		ThreadStatisticRunner s = new ThreadStatisticRunner();
		s.run( "test", 1, () -> {
			Thread t1 = new Thread() {
				public void run() {
					for ( int i = 0; i < 10; i++ ) {
						s.step( () -> {
							ThreadUtil.sleep( 100 );
						} );
					}
				}
			};
			Thread t2 = new Thread() {
				public void run() {
					for ( int i = 0; i < 30; i++ ) {
						s.step( () -> {
							ThreadUtil.sleep( 100 );
						} );
					}
				}
			};
			t1.start();
			t2.start();
			ThreadUtil.join( t1 );
			ThreadUtil.join( t2 );
		} );
	}

	public void run( String text, int times, Runnable runnable ) {
		this.items.clear();
		this.out.println( "| " + text + " (" + times + " times)..." );
		try {
			long start = System.nanoTime();
			for ( int i = 0; i < times; i++ ) {
				runnable.run();
			}
			long end = System.nanoTime();
			this.print( ( end - start ) / 1_000_000 );
		} catch ( Throwable t ) {
			this.out.println( t );
		}
		out.println();
	}

	public void step( Runnable runnable ) {
		runnable.run();
		final Thread thread = Thread.currentThread();
		Item item = this.items.get( thread );
		if ( item == null ) {
			this.items.put( thread, item = new Item() );
		}
		item.steps++;
	}

	private void print( long duration ) {
		final String HEAD = "| thread          steps";
		final String ITEMFORMAT = "| %6d        %7d\n";
		final String LINE = "|-----------------------";
		final String STEPFORMAT = "| total steps : %7d\n";
		final String DURATIONFORMAT = "| duration    : %7d\n";
		this.out.println( HEAD );
		this.out.println( LINE );
		int totalSteps = 0;
		for ( Map.Entry<Thread, Item> entry : this.items.entrySet() ) {
			final Thread thread = entry.getKey();
			final Item item = entry.getValue();
			this.out.printf( ITEMFORMAT, thread.getId(), item.steps );
			totalSteps += item.steps;
		}
		this.out.println( LINE );
		this.out.printf( STEPFORMAT, totalSteps );
		this.out.printf( DURATIONFORMAT, duration );
	}

	private static class Item {
		int steps = 0;
	}
}
