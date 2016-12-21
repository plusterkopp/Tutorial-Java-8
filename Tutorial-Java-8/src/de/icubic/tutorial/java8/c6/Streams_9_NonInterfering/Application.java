package de.icubic.tutorial.java8.c6.Streams_9_NonInterfering;

import java.awt.*;
import java.util.*;
import java.util.List;

import static java.lang.System.*;

public class Application {

	public static void main( String[] args ) {
		{
			out.println( "---------------------------------" );
			List<Point> points = new ArrayList<>();
			points.add( new Point( 1, 1 ) );
			points.add( new Point( 2, 2 ) );
//			points.stream().forEach(point -> points.add(new Point(0, 0)));
			// ConcurrentModificationException
		}
		{
			out.println( "---------------------------------" );
			List<Point> points = new ArrayList<>();
			points.add( new Point( 1, 1 ) );
			points.add( new Point( 2, 2 ) );
			points.stream()
					.forEach( point -> point.x += 1 );
			points.stream()
					.forEach( point -> out.println( point ) );
		}

	}
}
